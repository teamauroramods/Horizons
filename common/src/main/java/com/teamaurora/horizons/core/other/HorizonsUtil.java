package com.teamaurora.horizons.core.other;

public class HorizonsUtil {

    public static boolean isVanillaInvocOfOBB() {
        StackTraceElement[] traces = Thread.currentThread().getStackTrace();
        int startIdx = 2;
        int endIdx = -1;
        for (int i = 0; i < traces.length; i++) {
            StackTraceElement t = traces[i];
            if (t.getClassName().equals("terrablender.util.LevelUtils")) {
                endIdx = i;
                break;
            }
        }
        if (endIdx == -1) {
            return true;
        }
        for (int i = startIdx; i <= endIdx; i++) {
            StackTraceElement t = traces[i];

            if (!isValidPackage(t.getClassName())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidPackage(String classname) {
        return classname.startsWith("java.") || classname.startsWith("supercoder79.") || classname.startsWith("net.minecraft.") || classname.startsWith("terrablender.");
    }
}
