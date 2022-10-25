package 杂七杂八;

class Main {
     public  static void main(String[] args) throws Exception {
        char jj='A';
        System.out.println(++jj);//"B"
        String tom = "boy";
        String hill = "boy";
        System.out.println(tom == hill);//true
        System.out.println(tom.equals(hill));//true
        System.out.println("---------");
        String tom1 = new String("boy");
        String hill1 = new String("boy");
        System.out.println(tom1 == hill1);//false
        System.out.println(tom1.equals(hill1));//true
        System.out.println(tom == tom1);//false
        System.out.println("-------");
        String s = "people";
        String t = new String("people");
        char c[] = {'p', 'e', 'o', 'p', 'l', 'e'};
        System.out.println(s.equals(t));//true
        System.out.println(s.equals(c));//false
    }
}

interface A {

    public static final int a = 0;
    public abstract  void lo();
 }

//class cdcd implements 杂七杂八.A{
//
//}
abstract class kll{

  protected static void aa(){

    }
}

class aaaaa {
    int xx;
    public int qs = 0;

}

class sdsas extends aaaaa implements A{
    public void aa() {
        int qs1 = super.qs;
    }

    @Override
    public void lo() {

    }
}


