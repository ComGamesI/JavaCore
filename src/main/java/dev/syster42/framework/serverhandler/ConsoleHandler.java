package dev.syster42.framework.serverhandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleHandler {

    private String error;
    private String warning;
    private String info;

    public String getError(){
        return getTime() + this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getWarning() {
        return getTime() + this.warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getInfo() {
        return getTime() + this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm:ss] ");
        String date = sdf.format(new Date());
        return date;
    }

}
