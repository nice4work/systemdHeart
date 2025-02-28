package com.nice4work.systemd;

public class SystemdWatchdog {



    public static void notifyWatchdog() {

        //判断平台是否支持systemd



        // 发送 watchdog 信号
        Systemd.INSTANCE.sd_notify(0, "WATCHDOG=1");
    }
}

