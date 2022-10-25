package com.hspedu.network.TCP_.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {
    public static void main(String[] args) throws IOException {
        //服务端，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        //阻塞
        Socket accept = serverSocket.accept();//接受Socket
        System.out.println("服务端"+accept.getClass());
        InputStream inputStream = accept.getInputStream();

        //IO读取

        byte [] buf =new byte[1024];
        int read=0;
        while ((read = inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,read));
        }
        OutputStream outputStream=accept.getOutputStream();
        outputStream.write("hello client " .getBytes());
        accept.shutdownOutput();//out流暂停标记

        outputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
