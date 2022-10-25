package com.hspedu.network.UDP.Test01;

import java.io.IOException;
import java.net.*;

//发送端
public class UDPReceiverB {
    public static void main(String[] args) throws IOException {
        //1.socket端口
        DatagramSocket socket = new DatagramSocket(8888);
        //2.数据打包
        byte[] data = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        //3，发送
        socket.send(packet);



        /*上面发送
         *
         * 下面接受*/

        byte[] buf = new byte[64*1024];
         packet= new DatagramPacket(buf, buf.length);
        //3.接受
        System.out.println("等待中~~~");
        socket.receive(packet);

        //4.把packet拆包
        int length = packet.getLength();//实际数据大小
        data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);



        //
        socket.close();
    }
}
