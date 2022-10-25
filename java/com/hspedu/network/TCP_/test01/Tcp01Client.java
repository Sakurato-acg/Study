package com.hspedu.network.TCP_.test01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Tcp01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端"+socket);
        //得到 输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HELLO".getBytes());
        //关闭流与Socket
        outputStream.close();
        socket.close();
    }
}
