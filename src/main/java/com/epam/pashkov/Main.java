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
            File file = new File(args[1]);
            URL connection = new URL(args[0]);
            HttpURLConnection urlconn;
            urlconn = (HttpURLConnection) connection.openConnection();
            urlconn.setRequestMethod("GET");
            urlconn.connect();
            InputStream in = urlconn.getInputStream();
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
