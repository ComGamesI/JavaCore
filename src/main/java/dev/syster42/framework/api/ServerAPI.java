package dev.syster42.framework.api;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServerAPI {

    private String motd;
    private boolean allowedConnection;
    private boolean secret;

    public boolean isAllowedConnection() {
        return this.allowedConnection;
    }

    public void setAllowedConnection(boolean allowedConnection) {
        this.allowedConnection = allowedConnection;
    }

    public String getOS() {
        return System.getProperty("os.name").toLowerCase();
    }

    public String getOSArch() {
        return System.getProperty("os.arch").toLowerCase();
    }

    public String getOSVersion() {
        return System.getProperty("os.version").toLowerCase();
    }

    public void printAllNetworkaddresses() {
        InetAddress[] ias;
        try {
            ias = InetAddress.getAllByName(getOwnerHostName());
            if (ias != null)
                for (InetAddress ia : ias) {
                    System.out.println(ia.getHostAddress());
                }
        } catch (UnknownHostException e) {
            System.err.println("unknown hostname");
        }
    }

    public String getOwnerHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOwnerNetworkDeviceName() {
        try {
            NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            if (ni != null)
                return ni.getDisplayName();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getOwnerMac() {
        try {
            NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            byte[] hwa = null;
            if (ni != null) {
                hwa = ni.getHardwareAddress();
            } else {
                return;
            }
            if (hwa == null) {
                return;
            } else {
                String mac = "";
                for (int i = 0; i < hwa.length; i++) {
                    mac += String.format("%x:", hwa[i]);
                }
                if (mac.length() > 0 && !ni.isLoopback()) {
                    System.out.println(mac.toLowerCase().substring(0, mac.length() - 1));
                }

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String getOwnerIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getInstallationPathJava() {
        return System.getProperty("java.home").toLowerCase();
    }

    public String getJavaVendorName() {
        return System.getProperty("java.vendor").toLowerCase();
    }

    public String getJavaVendorURL() {
        return System.getProperty("java.vendor.url").toLowerCase();
    }

    public String getJavaVersion() {
        return System.getProperty("java.version").toLowerCase();
    }

    public long getTotalMemory() {
        Runtime rt = Runtime.getRuntime();
        return rt.totalMemory();
    }

    public long getFreeMemory() {
        Runtime rt = Runtime.getRuntime();
        return rt.freeMemory();
    }

    public long getUsedMemory() {
        Runtime rt = Runtime.getRuntime();
        return rt.totalMemory() - rt.freeMemory();
    }

    public double getCPULoad() {
        double cpuload = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
        return (Math.round(cpuload * 100));
    }

    public long getUptime() {
        RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
        return rb.getUptime();
    }

    public double getTotalSaveStorage() {
        File file = new File("/");
        long totalSpace = file.getTotalSpace();
        double totalSpaceInDouble = (totalSpace/ 8/1024/1024/1024);
        return totalSpaceInDouble;
    }

    public double getFreeSaveStorage() {
        File file = new File("/");
        long freeSpace = file.getFreeSpace();
        double freeSpaceInDouble = (freeSpace/ 8/1024/1024/1024);
        return freeSpaceInDouble;
    }

    public double getUsedSaveStorage() {
        File file = new File("/");
        long usedSpace = file.getUsableSpace();
        double usedSpaceInDouble = (usedSpace/8/1024/1024/1024);
        return usedSpaceInDouble;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }

    public String showSecretInformation(){
        if(this.isSecret() == true)
            return "online";
        else
            return "offline";
    }

}