package com.hspedu.ch14.Collection_.Set_;

import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new EM("lpl", 90000, new EM.Birthday(12, 21)));
        hashSet.add(new EM("lpl", 90000, new EM.Birthday(12, 21)));
        System.out.println(hashSet);

    }
}

class EM {
    public String name;
    public int salary;
    public Birthday birthday;

    public EM(String name, int salary, Birthday birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    static class Birthday {
        public int mm;
        public int dd;

        public Birthday(int mm, int dd) {
            this.mm = mm;
            this.dd = dd;
        }

        @Override
        public String toString() {
            return "Birthday{" +
                    "mm=" + mm +
                    ", dd=" + dd +
                    '}';
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Birthday birthday = (Birthday) o;
            return mm == birthday.mm && dd == birthday.dd;
        }

        @Override
        public int hashCode() {
            return Objects.hash(mm, dd);
        }
    }

    @Override
    public String toString() {
        return "EM{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EM em = (EM) o;
        return Objects.equals(name, em.name) && Objects.equals(birthday, em.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}
