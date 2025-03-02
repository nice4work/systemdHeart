package io.github.nice4work.systemd;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Systemd extends Library {

    Systemd INSTANCE = Native.load("systemd", Systemd.class);

    void sd_notify(int unset_environment, String state);
}
