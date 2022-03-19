# Spring Boot整合Elasticsearch Demo



## 版本约定
- JDK: 11.0.2
- Spring Boot: 2.3.7.RELEASE
- elasticsearch: 7.6.2
- mysql: 8.0.*

## 准备环境

为了方便这里使用docker启动一个单节点模式的ES实例

```shell
docker run -p 9200:9200 -e "discovery.type=single-node" --name es elasticsearch:7.6.2
```
> 若启动报错,执行命令设置系统参数： sudo sysctl -w vm.max_map_count=262144

安装IK分词器
进入容器内部：
```shell
docker exec -it es /bin/bash
```
```shell
elasticsearch-plugin install -batch https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.6.2/elasticsearch-analysis-ik-7.6.2.zip
```

## 创建数据库test（MySQL）
```mysql
CREATE DATABASE `test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
```


## 启动项目

mvn clean spring-boot:run
