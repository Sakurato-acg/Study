package com.hspedu.ch09.poly.polyarr;

public class PolyArray {
    public static void main(String[] args) {
        //shuzu
        Person []person=new Person[5];
        person[0]=new Person("jack",20);
        person[1]=new Student("JACK",18,100);
        person[2]=new Student("smith",19,60);
        person[3]=new Teacher("king",20,4000);
        person[4]=new Teacher("scott",20,3000);
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].say());
            //无法识别是因为父类没有study()或teach(),所以用向上转型，从子类出发
            //System.out.println(person[1].());
            if (person[i] instanceof Student){
                //转为从子类出发
                Student student=(Student) person[1];
                student.study();
                //((Student)person[i]).study();
            }else if (person[i] instanceof Teacher){
                Teacher teacher=(Teacher) person[i];
                teacher.teach();
                //((Teacher)person[i]).teach();
            }else {
                System.out.println("NO");
            }
        }

    }
}
