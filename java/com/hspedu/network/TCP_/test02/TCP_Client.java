package com.hspedu.network.TCP_.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class TCP_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端"+socket);
        //得到 输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HELLO server".getBytes());
        socket.shutdownOutput();//out流暂停标记

        InputStream inputStream=socket.getInputStream();
        byte [] buf =new byte[1024];
        int read=0;
        while ((read = inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,read));
        }
        //关闭流与Socket
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
