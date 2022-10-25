package com.hspedu.network.TCP_.test03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//字符流
public class TCP_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端"+socket);
        //得到 输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("HELLO server");
        bufferedWriter.newLine();//写入结束
        bufferedWriter.flush();
        //
        socket.shutdownOutput();//out流暂停标记

        /*上面发给服务端


        *下面接收
         */
        InputStream inputStream=socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        //关闭流与Socket
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();

    }
}
