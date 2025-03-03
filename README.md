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




