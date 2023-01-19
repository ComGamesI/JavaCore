package dev.syster42.framework;

import dev.syster42.framework.api.ServerAPI;
import dev.syster42.framework.serverhandler.LogHandler;

public class Main {
    static LogHandler logger = new LogHandler();
    static ServerAPI serverAPI = new ServerAPI();

    public static ServerAPI getServerAPI() {
        return serverAPI;
    }

    public static LogHandler getLogger() {
        return logger;
    }



}
