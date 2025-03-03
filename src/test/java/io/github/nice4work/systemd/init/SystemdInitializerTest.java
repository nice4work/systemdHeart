package io.github.nice4work.systemd.init;

import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.*;

class SystemdInitializerTest {

    @Test
    void initialize() {

        ServiceLoader<Initializer> loader = ServiceLoader.load(Initializer.class);
        for (Initializer initializer : loader) {
            initializer.initialize();
        }
    }
}