package com.atguigu.utils;


import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
@SuppressWarnings("all")
public  class WebUtils {
    public static<T> T  copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换从Int类型
     * @param StringInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String stringInt,int defaultValue ){
        try {
            return Integer.parseInt(stringInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
