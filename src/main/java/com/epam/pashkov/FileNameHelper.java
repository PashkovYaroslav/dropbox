package com.epam.pashkov;

/**
 * Created by Yaroslav on 14.10.2015.
 */
public class FileNameHelper {
    public static String getFileName(String url) {
        int lastSlashIndex = url.lastIndexOf("/") + 1;
        return url.substring(lastSlashIndex, url.length());
    }
}
