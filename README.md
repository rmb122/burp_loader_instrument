## burp_loader_instrument

修改于 scz 版本. `-Xbootclasspath/p:` 在 java9 后删除, 采用原作者推荐的 instrument API 来 patch bytecode. 因此支持 java11 等版本.  
核心在于原作者 patch 的七个字节, 我也只是给他换了个相对更好用的壳. 可以自行提取之后版本 patch 的 bytecode 更新, 当前 patch 的版本是 v2020.2.

Usage:
```sh
java -noverify -javaagent:burp_loader.jar -jar burpsuite_pro_vX.X.XX.jar
```

Build:
```
mvn package
```

原版地址:  
http://scz.617.cn/misc/201910151519.txt
