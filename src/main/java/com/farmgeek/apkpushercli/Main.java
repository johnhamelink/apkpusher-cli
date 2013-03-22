package com.farmgeek.apkpushercli;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void sendFile(String path, String host, Integer port) throws IOException {
        Socket socket = new Socket(host, port);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        File file = new File(path);

        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[1024*1024];
        int bytesRead = 0;

        while((bytesRead = fileInputStream.read(buffer)) > 0)
        {
            out.write(buffer, 0, bytesRead);
        }

        out.flush();
        fileInputStream.close();
        out.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        OptionParser parser = new OptionParser(){
            {
                accepts("h").withRequiredArg().ofType(String.class)
                        .describedAs("host").defaultsTo("127.0.0.1");
                accepts("p").withRequiredArg().ofType(Integer.class)
                        .describedAs("port").defaultsTo(8080);
                accepts("f").withRequiredArg().ofType(String.class)
                        .describedAs("file");
            }
        };


        OptionSet options = parser.parse(args);

        String  file = (String)  options.valueOf("f");
        String  host = (String)  options.valueOf("h");
        Integer port = (Integer) options.valueOf("p");

        if (file != null && host.length() > 0 && port > 0) {
            Main.sendFile(file, host, port);
            System.out.println(file + " sent.");
        } else {
            parser.printHelpOn(System.out);
        }
    }

}
