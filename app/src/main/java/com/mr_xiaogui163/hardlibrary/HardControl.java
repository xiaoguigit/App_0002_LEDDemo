package com.mr_xiaogui163.hardlibrary;


public class HardControl {
    public static native int ledCtrl(int which, int status);
    public static native int ledOpen();
    public static native void ledClose();

    static {
        try {
            System.loadLibrary("hardcontrol");
        } catch (Exception e) {
            System.out.println("Load lib occurring exception.");
            e.printStackTrace();
        }
    }
}