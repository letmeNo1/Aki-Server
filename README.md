# Aki-Server

Aki-Server是基于Springboot将Aki以本地服务的形式启动，使用户可以用请求的方式来调用Aki中对应的功能。

版本要求：

jdk version >= 1.8.0_295


启动方式：

1.直接执行 Aki-Server\src\main\java\aki\server 中App.java

2.mvn install生成jar包，使用java -jar aki-server-1.0-SNAPSHOT --server.port 8080 （端口号可自定义）
