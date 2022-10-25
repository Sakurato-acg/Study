package 必看;

import java.util.Scanner;

public class 字符串循环 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ar = "";
        String br = "";
        String str = sc.nextLine();
        int i = 0;
        //不断用同一个相同的字串加自身，如果最后与输入字符串相等，则输出i+1
        for (i = 0; i < str.length(); i++) {
            ar += str.charAt(i) + "";
            br = ar;
            while (br.length() < str.length()) {//只要没有加满输入字符串长度就继续加
                br += ar;
            }
            if (br.equals(str)) {
                break;
            }
        }
        System.out.println(i + 1);
    }

}
