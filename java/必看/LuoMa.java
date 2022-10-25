package 必看;

import java.util.Scanner;

public class LuoMa {
    public static void main(String[] args) {
        int key;
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <n ; i++) {

            stringBuffer.append(kb.next());
            key=mm(stringBuffer.charAt(0));
            for (int k = 1; k < stringBuffer.length(); k++) {
                    char s1 = stringBuffer.charAt(k-1);
                    char s2 = stringBuffer.charAt(k);
                    if (mm(s1)<mm(s2)){
                        key=mm(s2)-key;
                        }else{ key+=mm(s2);}


            }
            System.out.println(key);
            stringBuffer.delete(0,stringBuffer.length());
            key=0;

        }
        }

    public static int mm(char s) {
        int index=0;
        if (s == 'I') {
            index=1;
        }
        if (s == 'V') {
            index= 5;
        }
        if (s == 'X') {
            index= 10;
        }
        if (s == 'L') {
            index= 50;
        }
        if (s == 'C') {
            index= 100;
        }
        if (s == 'D') {
            index= 500;
        }
        if (s == 'M') {
            index= 1000;
        }return index;
    }
}
//import java.util.Scanner;
//
//public class Test {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int num = input.nextInt();
//        String[] arr = new String[num];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = input.next();
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(change(arr[i]));
//        }
//    }
//
//    private static int change(String st) {
//        int result = 0;
//        for (int i = 0; i < st.length(); i++) {
//            if(st.charAt(i) == 'I'){
//                result += 1;
//            }else if(st.charAt(i) == 'V'){
//                result += 5;
//            }else if(st.charAt(i) == 'X'){
//                result += 10;
//            }else if(st.charAt(i) == 'L'){
//                result += 50;
//            }else if(st.charAt(i) == 'C'){
//                result += 100;
//            }else if(st.charAt(i) == 'D'){
//                result += 500;
//            }else if(st.charAt(i) == 'M'){
//                result += 1000;
//            }
//        }
//
//        //处理成对数
//        if(st.indexOf("IV") >= 0){
//            result -= 2;
//        }
//        if(st.indexOf("IX") >= 0){
//            result -= 2;
//        }
//        if(st.indexOf("XL") >= 0){
//            result -= 20;
//        }
//        if(st.indexOf("XC") >= 0){
//            result -= 20;
//        }
//        if(st.indexOf("CD") >= 0){
//            result -= 200;
//        }
//        if(st.indexOf("CM") >= 0){
//            result -= 200;
//        }
//        return result;
//    }
//}
