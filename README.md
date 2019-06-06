[TOC]
[网关服务器](https://github.com/qq275860560/gateway-server)


 

## 运行
1.运行[认证服务器](https://github.com/qq275860560/authorization-server)
2.运行[资源服务器](https://github.com/qq275860560/resource-server)
3.命令行切换到项目根目录下，执行

```
mvn spring-boot:run  -Dspring-boot.run.jvmArguments="-Dlogging.level.root=ERROR -Dserver.port=8081 -Xms128m -Xmx1024m -Dserver.servlet.session.cookie.name=OAUTH2SESSION -Dsecurity.oauth2.client.user-authorization-uri=http://localhost:8080/oauth/authorize -Dsecurity.oauth2.client.access-token-uri=http://localhost:8080/oauth/token -Dsecurity.oauth2.resource.jwt.key-uri=http://localhost:8080/oauth/token_key -Dsecurity.oauth2.client.client-id=app1 -Dsecurity.oauth2.client.client-secret=123456 -DresourceUrl=http://localhost:8083"
```

```
mvn spring-boot:run  -Dspring-boot.run.jvmArguments="-Dlogging.level.root=ERROR -Dserver.port=8082 -Xms128m -Xmx1024m -Dserver.servlet.session.cookie.name=OAUTH2SESSION -Dsecurity.oauth2.client.user-authorization-uri=http://localhost:8080/oauth/authorize -Dsecurity.oauth2.client.access-token-uri=http://localhost:8080/oauth/token -Dsecurity.oauth2.resource.jwt.key-uri=http://localhost:8080/oauth/token_key -Dsecurity.oauth2.client.client-id=app2 -Dsecurity.oauth2.client.client-secret=123456 -DresourceUrl=http://localhost:8084"

```


此时，本地会默认开启8081端口和8082端口

## 测试
### 获取token
/login
### 访问资源
/api
# 温馨提醒

* 此项目将会长期维护，增加或改进实用的功能
* 右上角点击star，给我继续前进的动力,谢谢