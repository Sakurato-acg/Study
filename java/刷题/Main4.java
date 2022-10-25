package 刷题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (kb.hasNext()) {
            long startTime = System.currentTimeMillis();    //获取开始时间
            int n = kb.nextInt();//长度
            int m = kb.nextInt();//次数
            List stringBuffer = new ArrayList();
            stringBuffer.add(kb.next());
            for (int i = 0; i < m; i++) {
                String sll = kb.next();
                if (sll.equals("push")) {
                    String str = kb.next();
                    stringBuffer.add(stringBuffer.size(),str);
                    n += 1;
                } else if (sll.equals("pop")) {
                    stringBuffer.remove(n - 1);
                    n -= 1;
                }
                String test = (String) stringBuffer.get(0);
                F(test, n);
            }
            long endTime = System.currentTimeMillis();    //获取结束时间

            System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        }

    }

    public static void F(String stringBuffer, int n) {
        int out = 0;
        boolean ff = false;
        outer:
        for (int i = 1; i < n; i++) {
            String str = stringBuffer.substring(0, i);

            for (int j = 0; j < n; j += str.length()) {
                String k = stringBuffer.substring(j-1, j + str.length());

                if (k.equals(str)) {
                    out++;
                } else {
                    break;
                }
                if ((double) out == (double) n / str.length()) {
                    System.out.println(out);
                    ff = true;
                    break outer;
                }
                int kk = j + 2 * str.length();
                if (kk > n) {
                    break;
                }
                k="";
            }
            out = 0;
        }//ab ab a
        if (ff == false) {
            System.out.println(1);
        }
    }
}
