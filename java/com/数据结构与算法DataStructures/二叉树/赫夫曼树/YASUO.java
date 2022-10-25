package com.数据结构与算法DataStructures.二叉树.赫夫曼树;

import java.io.*;
import java.util.*;

public class YASUO {
    public static byte[] zip;
    public static Map<Byte, String> pre;
    public static int count;

    public static void main(String[] args) throws Exception {
//        String str = "i like like like java" +
//                " d you like a java";
//        byte[] contentBytes = str.getBytes();
        /*  [105, 32 , 108, 105, 107,
             101, 32 , 108, 105, 107,
             101, 32 , 108, 105, 107,
             101, 32 , 106, 97 , 118,
             97 , 32 , 100, 111, 32 ,
             121, 111, 117, 32 , 108,
             105, 107, 101, 32 , 97 ,
             32 , 106, 97 , 118, 97 ]
         */
//        System.out.println("原始byte数组");
//        System.out.println(contentBytes.length);
//        zip = getZip(contentBytes);
//        System.out.println("最终结果");
//        System.out.println(Arrays.toString(zip));
//
//        System.out.println("压缩了 " + (1 - (double) zip.length / str.length()) * 100 + "%");


        //解压
//        byte[] decode = decode(pre, zip);
//
//        System.out.println("解压后");
//        System.out.println(new String(decode));

        String src = "C:\\Users\\lpl\\Desktop\\图\\壁纸.jpg";
        String drc = "src\\宝可梦.zip";

        String out="C:\\Users\\lpl\\Desktop\\壁纸.jpg";
        zipFile(src, drc);

        unZipFile(drc,out);
    }

    /**
     * @param srcFile 原文件路径
     * @param dstFile 压缩后路径
     */
    public static void zipFile(String srcFile, String dstFile) {
        FileInputStream is = null;
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];

            is.read(b);

            byte[] zip = getZip(b);

            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            oos.writeObject(zip);

            oos.writeObject(pre);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void unZipFile(String src, String drc) {
        InputStream is = null;

        ObjectInputStream ois = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(src);

            ois = new ObjectInputStream(is);

            byte[] huffman = (byte[]) ois.readObject();
            Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();

            byte[] decode = decode(codes, huffman);

            os=new FileOutputStream(drc);
            os.write(decode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------//

    /*
    解压，后面用File流操作
     */

    public static byte[] decode(Map<Byte, String> codes, byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            boolean flag = (i == bytes.length - 1);

            stringBuilder.append(byteToBitStr(!flag, bytes[i]));
        }
        System.out.println("二进制字符串\n" + stringBuilder);

        //根据编码表
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : codes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        List<Byte> list = new ArrayList<>();

        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                if (i + count > stringBuilder.length()) {
                    break;
                }
                String str = stringBuilder.substring(i, i + count);
                b = map.get(str);

                if (b == null) {

                    count = count + 1;
                } else {
                    flag = false;
                }
            }
            i += count;
            list.add(b);
        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                break;
            } else {
                b[i] = list.get(i);
            }
        }
        return b;
    }

    //将byte转字符串
    private static String byteToBitStr(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp = temp | 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            int length = count - str.length();
            for (int i = 0; i < length; i++) {
                str = 0 + str;
            }
            System.out.println(str);
            if (str.length() > 8) {
                return str.substring(str.length() - 8);
            } else {
                return str;
            }
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------//
    //压缩
    public static byte[] getZip(byte[] contentBytes) {


        List<Code> codes = getCodes(contentBytes);
        System.out.println("统计次数");
        System.out.println(codes);

        System.out.println("哈夫曼");
        Code creat = creat(codes);
        pre = pre(creat);
        System.out.println("存到Map");
        System.out.println(pre);
//        getCodes(creat,"",stringBuilder);
//        System.out.println(huffmanCodes);

//        zip(contentBytes, pre);
        byte[] dd = zip(contentBytes, pre);
        return dd;
    }


    private static List<Code> getCodes(byte[] bytes) {
        ArrayList<Code> codes = new ArrayList<>();

        //统计相同次数
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer nums = counts.get(b);
            if (nums == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, nums + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            codes.add(new Code(entry.getKey(), entry.getValue()));
        }
        return codes;
    }


    public static void set(List<Code> list) {
        Collections.sort(list);
        if (list.size() == 1) {
            return;
        }
        Code left = list.get(0);
        Code right = list.get(1);

        Code parent = new Code(null, left.weight + right.weight);
        parent.left = left;
        parent.right = right;

        list.remove(left);
        list.remove(right);

        list.add(parent);
        set(list);
    }

    public static Code creat(List<Code> list) {
        set(list);
        return list.get(0);
    }

//    static Map<Byte, String> huffmanCodes = new HashMap<>();
//    static StringBuilder stringBuilder = new StringBuilder();
//
//    public static void getCodes(Code node, String code, StringBuilder stringBuilder) {
//        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
//        stringBuilder2.append(code);
//        if (node != null) {
//            if (node.data == null) {
//                getCodes(node.left, "0", stringBuilder2);
//                getCodes(node.right, "1", stringBuilder2);
//            } else {
//                huffmanCodes.put(node.data, String.valueOf(stringBuilder2));
//            }
//        }
//
//    }

    public static Map<Byte, String> pre(Code root) {
        Map<Byte, String> pre = new HashMap<>();
        if (root != null) {
            pre = root.pre("");
        }
        return pre;
    }

    //编码表转从二进制数字
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        count = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println("二级制字符串：\n" + stringBuilder);

        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] by = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String s;
            if (i + 8 > stringBuilder.length()) {
                s = stringBuilder.substring(i);
                for (int j = i; j < stringBuilder.length(); j++) {
                    count++;
                }
            } else {
                s = stringBuilder.substring(i, i + 8);
            }
            by[index] = (byte) Integer.parseInt(s, 16);
            index++;
        }

        return by;
    }

}

class Code implements Comparable<Code> {
    public Byte data;//存放数据（字符）本身，比如‘a’ =>97
    public int weight;//权值，表示字符出现的次数
    public Code left;
    public Code right;
    public static Map<Byte, String> huffmanCodes = new HashMap<>();

    public Code(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
//        char c = (char) (data & 0xFF);
        return "Code[data = " + data +
                " weight = " + weight + "]";
    }

    @Override
    public int compareTo(Code o) {
        return this.weight - o.weight;
    }

    public Map<Byte, String> pre(String code) {
        boolean l = false;
        if (this.left != null) {
            l = true;
            code = code + "0";
            this.left.pre(code);
        }
        if (l) {
            code = code.substring(0, code.length() - 1);
        }
        if (this.right != null) {
            code = code + "1";
            this.right.pre(code);
        }
        if (this.left == null && this.right == null) {
            System.out.println(this);
            System.out.println(code);
            huffmanCodes.put(this.data, code);
        }
        return huffmanCodes;
    }
}
