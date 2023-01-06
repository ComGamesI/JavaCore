package dev.syster42.framework;

import dev.syster42.framework.serverhandler.ConsoleHandler;
import dev.syster42.framework.serverhandler.LogHandler;
import dev.syster42.framework.utils.FileAPI;

import java.util.Scanner;

public class Main {
    static LogHandler logger = new LogHandler();


    public static LogHandler getLogger() {
        return logger;
    }

    public void setLogger(LogHandler logger) {
        this.logger = logger;
    }

}
