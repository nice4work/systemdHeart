package io.github.nice4work.systemd.init;

import io.github.nice4work.systemd.SystemdWatchdog;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SystemdInitializer implements Initializer {

    @Override
    public void initialize() {
        if(SystemdWatchdog.isSystemdSupported()){
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(SystemdWatchdog::notifyWatchdog,1,5, TimeUnit.SECONDS);
        }
    }
}
