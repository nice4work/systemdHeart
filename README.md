# systemdHeart

# 如何使用
### 1 引入包
```xml
  <dependency>
    <groupId>io.github.nice4work</groupId>
    <artifactId>systemdHeartbeat</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 2  代码中添加一下语句，会自动判断是否支持systemd环境，如果支持，会自动与systemd进行交互

```java

ServiceLoader<Initializer> loader = ServiceLoader.load(Initializer.class);
        for (Initializer initializer : loader) {
        initializer.initialize();
        }
```


### 3 service文件添加一下配置

```service
KillMode=process
TimeoutStopSec=5
User=your_user_name
Group=your_group_name
WatchdogSec=10s
Restart=on-failure
RestartSec=5s
```




### 4 例子：
![](./doc/img/img.png)



