package dev.syster42.framework.serverhandler;

import dev.syster42.framework.Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleHandler {

    private String error;
    private String warning;
    private String info;

    public String getError(){
        return Main.getServerAPI().getTimeForConsole() + this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getWarning() {
        return Main.getServerAPI().getTimeForConsole() + this.warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getInfo() {
        return Main.getServerAPI().getTimeForConsole() + this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
