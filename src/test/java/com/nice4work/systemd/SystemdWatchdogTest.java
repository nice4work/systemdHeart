package com.nice4work.systemd;

import com.sunday.commons.RunUtils;
import com.sunday.commons.utils.thread.ThreadUtils;
import org.junit.jupiter.api.Test;

class SystemdWatchdogTest {

    @Test
    void notifyWatchdog() {
        SystemdWatchdog.notifyWatchdog();


        ThreadUtils.waitAWhile(1000);

    }
}