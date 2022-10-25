package com.hspedu.network.TCP_.传图片;

import com.hspedu.Tools.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//字节流传图片
public class TCP_Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端"+socket);
        //得到 输出流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\lpl\\Desktop\\《花舞少女》第1集BD版720P1080P在线观看 - EDD动漫-E站-test_1415782579.mp4"));
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //发送数据
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);

        bufferedInputStream.close();
        socket.shutdownOutput();//设置写出数据的结束标记

        //用字节流接受消息
        InputStream inputStream=socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);
        inputStream.close();

        bos.close();
        socket.close();
    }
}
