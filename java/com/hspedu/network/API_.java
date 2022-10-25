package com.hspedu.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress的对象
        InetAddress local=InetAddress.getLocalHost();
        System.out.println(local);//LAPTOP-9E8B34FL/10.106.69.168

        //根据指定主机名 获取 InetAddress 对象
        InetAddress byName = InetAddress.getByName("LAPTOP-9E8B34FL");
        System.out.println(byName);//LAPTOP-9E8B34FL/10.106.69.168

        //根据域名返回 InetAddress 对象，比如 www.bilibili.com
        InetAddress byName1 = InetAddress.getByName("www.bilibili.com");
        System.out.println(byName1);

        //通过  InetAddress 对象 ，获取对应地址
        String hostAddress = byName1.getHostAddress();
        System.out.println("www.bilibili.com 对应ip"+hostAddress);

        //通过InetAddress对象 ，获取主机名或域名
        String hostName = byName1.getHostName();
        System.out.println(hostName);

    }
}
