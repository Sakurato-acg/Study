package com.hspedu.network.TCP_.test03;

import java.io.*;
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
        BufferedReader bufferedWriter = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedWriter.readLine();
        System.out.println(s);


        /*上面接收


         *下面发给客户端
         */
        OutputStream outputStream=accept.getOutputStream();
        BufferedWriter bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter1.write("收到图片");
        bufferedWriter1.newLine();
        bufferedWriter1.flush();


        accept.shutdownOutput();//out流暂停标记

        bufferedWriter1.close();
        bufferedWriter.close();
        accept.close();
        serverSocket.close();
    }
}
