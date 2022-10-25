package com.hspedu.network.TCP_.传图片;

import com.hspedu.Tools.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {
    public static void main(String[] args) throws Exception {
        //服务端，等待连接
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket=serverSocket.accept();

        //得到输入
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //4.将输入写出来
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\1.mp4"));
        bos.write(bytes);
        bos.close();

        //回复
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片");
        bufferedWriter.flush();
        socket.shutdownOutput();
        bufferedWriter.close();


        bis.close();
        socket.close();
        serverSocket.close();

    }
}
