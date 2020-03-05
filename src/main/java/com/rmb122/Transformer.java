package com.rmb122;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class Transformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (classfileBuffer.length == 112079) {
            System.out.println("Detected class, patching...");
            System.out.println(className);

            byte[] newBytes = new byte[classfileBuffer.length];
            System.arraycopy(classfileBuffer, 0, newBytes, 0, newBytes.length);

            int[] patch = {31264, 0, 31265, 3, 31292, 0, 31293, 3, 31379, 167, 31380, 90, 31381, 36};
            for(int i = 0; i < patch.length; i += 2) {
                newBytes[patch[i]] = (byte) patch[i + 1];
            }
            return newBytes;
        }
        return null;
    }

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new Transformer());
    }
}
