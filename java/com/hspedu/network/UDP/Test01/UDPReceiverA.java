package com.hspedu.network.UDP.Test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//接受端
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.Socket
        DatagramSocket socket = new DatagramSocket(9999);
        //2.构建数据包  最大64KB
        byte[] buf = new byte[64*1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3.接受
        System.out.println("等待中~~~");
        socket.receive(packet);

        //4.把packet拆包
        int length = packet.getLength();//实际数据大小
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        /*上面接受
        *
        * 下面发送*/

        data = "Hellofafafa".getBytes();
        packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8888);
        socket.send(packet);

        //5.关闭自愿

        socket.close();
    }
}
