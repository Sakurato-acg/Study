package com.i18n;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NTest {
    @Test
    public void testLocale(){
        Locale aDefault = Locale.getDefault();
        Locale china = Locale.CHINA;
        Locale us = Locale.US;

        System.out.println("china = " + china);
        System.out.println("us = " + us);
    }
    @Test
    public void  test(){
        Locale locale = Locale.US;

        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        String username = bundle.getString("username");
        System.out.println("username = " + username);
    }
}
