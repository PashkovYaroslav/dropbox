package com.epam.pashkov;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yaroslav on 14.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        try {
            File file = new File(args[1] + FileNameHelper.getFileName(args[0]));
            URL connection = new URL(args[0]);
            HttpURLConnection urlConn = (HttpURLConnection) connection.openConnection();
            urlConn.setRequestMethod("GET");
            urlConn.connect();
            InputStream in = urlConn.getInputStream();
            OutputStream writer = new FileOutputStream(file);
            byte buffer[] = new byte[512];
            int c = in.read(buffer);
            while (c > 0) {
                writer.write(buffer, 0, c);
                c = in.read(buffer);
            }
            writer.flush();
            writer.close();
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
