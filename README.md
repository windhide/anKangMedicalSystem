# anKangMedicalSystem
anKangMedicalSystem

```shell
um install docker
systemctl enable docker
systemctl start docker
vi /etc/docker/daemon.json
```

```json
{
"registry-mirrors": ["http://hub-mirror.c.163.com", "https://registry.docker-cn.com","https://pee6w651.mirror.aliyuncs.com"]
}
```

```shell
systemctl restart docker
```

```shell
docker pull nacos/nacos-server
docker run --name nacos -d -p 8848:8848 --privileged=true --restart=always -e JVM_XMS=256m -e JVM_XMX=256m -e MODE=standalone nacos/nacos-server
```

```shell
docker pull mysql
```

```shell
docker run -itd --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql
```
