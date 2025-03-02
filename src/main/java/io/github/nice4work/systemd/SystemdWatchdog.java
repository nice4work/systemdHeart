package io.github.nice4work.systemd;

import java.io.*;
import java.nio.file.Files;

/**
 * 看门狗，激活systemd,不让systemd自动重启
 */
public class SystemdWatchdog {

    /**
     * 是否支持systemd
     *
     * @return bool
     */
    public static boolean isSystemdSupported() {
        // 检查操作系统是否为Linux
        String osName = System.getProperty("os.name").toLowerCase();
        if (!osName.contains("linux")) {
            return false;
        }

        // 检查 /proc/1/comm 文件内容是否为 systemd
        File commFile = new File("/proc/1/comm");
        if (commFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(commFile.toPath())))) {
                String line = reader.readLine();
                if (line != null && line.trim().equals("systemd")) {
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }

        // 检查 systemctl 命令是否存在
        try {
            Process process = Runtime.getRuntime().exec("systemctl --version");
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            return false;
        }
    }

    /**
     * 发送心跳请求
     */
    public static void notifyWatchdog() {

        // 发送 watchdog 信号
        Systemd.INSTANCE.sd_notify(0, "WATCHDOG=1");
    }
}

