package com.hspedu.network.TCP_.test01;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP01 {
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
        inputStream.close();
        accept.close();
        serverSocket.close();

    }
}
