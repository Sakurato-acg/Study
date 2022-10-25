package 杂七杂八;

import java.util.Scanner;

class Complex{
    double x,y;
    Complex(double x){
        this.x=x;
        this.y=0;
    }
    Complex(double x,double y){
        this.x=x;
        this.y=y;
    }
    public Complex add(Complex Z) {
        double aa=x+Z.x;
        double bb=y+Z.y;
        return new Complex(aa,bb);
    }
    public Complex sub(Complex Z) {
        double aa=x-Z.x;
        double bb=y-Z.y;
        return new Complex(aa,bb);
    }
    public Complex mult(Complex Z) {
        double aa=x*Z.x-y*Z.y;
        double bb=y*Z.x+x*Z.y;
        return new Complex(aa,bb);
    }
    public String toString() {
        if(y==0) {
            return ""+x;
        }
        if(y>0) {
            return ""+x+"+"+y+"i";
        }
        return ""+x+"-"+(-y)+"i";
    }
}
class LPL{
    public static void main(String[] args) {
        Scanner az=new Scanner(System.in);
        double a=az.nextDouble(),b=az.nextDouble(),c=az.nextDouble(),d=az.nextDouble();
        Complex c1=new Complex(a,b);
        Complex c2=new Complex(c,d);
        Complex ac=c1.add(c2);
        Complex sc=c1.sub(c2);
        Complex mc=c1.mult(c2);
        System.out.println(ac.toString());
        System.out.println(sc.toString());
        System.out.println(mc.toString());
    }
}
