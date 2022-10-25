package com.数据结构与算法DataStructures.二叉树.赫夫曼树;

import com.数据结构与算法DataStructures.二叉树.赫夫曼树.YASUO;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;

public class JieYa {
    public static void main(String[] args) throws Exception {
//        //服务端，等待连接
//        ServerSocket serverSocket = new ServerSocket(9999);
//        //阻塞
//        Socket accept = serverSocket.accept();//接受Socket
//        System.out.println("服务端"+accept.getClass());
//        InputStream inputStream=accept.getInputStream();
//
//        //IO读取
//
//        byte [] buf =new byte[17];
//        int read;
//        while ((read = inputStream.read(buf))!=-1){
//             new String(buf, 0, read);
//        }
//        System.out.println(Arrays.toString(buf));
//        inputStream.close();
//        accept.close();
//        serverSocket.close();
//        byte[] zip = buf;
//        System.out.println(Arrays.toString(zip));
//        Map<Byte, String> pre = YASUO.pre;
//        System.out.println(pre.toString());
//        //1.[-88, -65, -56, -65, -56, -65....]转成101010....
//
//        //2.二进制转字符
//
//        decode(pre,zip);
    }

    public static void decode(Map<Byte, String> codes, byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            boolean flag=(i== bytes.length-1);

            stringBuilder.append(byteToBitStr(!flag,bytes[i]));
        }
        System.out.println("二进制字符串\n"+stringBuilder);

    }

    //将byte转字符串
    private static String byteToBitStr(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp = temp | 256;
        }
        String s = Integer.toBinaryString(temp);
        if (flag) {
            return s.substring(s.length() - 8);
        }else {
            return s;
        }
    }
}
