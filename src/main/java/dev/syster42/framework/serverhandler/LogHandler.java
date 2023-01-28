package dev.syster42.framework.serverhandler;

import dev.syster42.framework.utils.FileAPI;

public class LogHandler {

    private static ConsoleHandler consoleHandler = new ConsoleHandler();

    public static ConsoleHandler getConsoleHandler() {
        return consoleHandler;
    }

    FileAPI logfile = new FileAPI("latest.log");

    public void startLogging(){
        if(logfile.exists()){
            logfile.renameFile(getConsoleHandler().getTimeForFiles() + ".log");
            logfile.createFile();
        }else
            logfile.createFile();
    }

    public void logInfo(String logMessage){
        getConsoleHandler().setInfo("[INFO] ");
        logfile.writeInNextFreeLine(getConsoleHandler().getInfo() + logMessage);
        System.out.println(getConsoleHandler().getInfo() + logMessage);
    }

    public void logWarn(String logMessage){
        getConsoleHandler().setWarning("[WARN] ");
        logfile.writeInNextFreeLine(getConsoleHandler().getWarning() + logMessage);
        System.out.println(getConsoleHandler().getWarning() + logMessage);
    }

    public void logError(String logMessage){
        getConsoleHandler().setInfo("[ERROR] ");
        logfile.writeInNextFreeLine(getConsoleHandler().getError() + logMessage);
        System.err.println(getConsoleHandler().getError() + logMessage);
    }

    public void logCrash(){
        getConsoleHandler().setInfo("[ERROR] ");

    }

}
