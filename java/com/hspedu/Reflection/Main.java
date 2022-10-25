package com.hspedu.Reflection;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\hspedu\\Reflection\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();


        Class cls=Class.forName(classfullpath);
        Object o = cls.newInstance();
        Method method1 = cls.getMethod(method);
        method1.invoke(o);
    }
    @Test
    public void test01() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<PrivateTest> privateTestClass = PrivateTest.class;


        PrivateTest privateTestOBJ = privateTestClass.newInstance();

        Field name = privateTestClass.getDeclaredField("name");

        name.setAccessible(true);

        name.set(privateTestOBJ,"LPL")

        ;
        Method method = privateTestClass.getMethod("getName");

        System.out.println(method.invoke(privateTestOBJ));
    }
}
