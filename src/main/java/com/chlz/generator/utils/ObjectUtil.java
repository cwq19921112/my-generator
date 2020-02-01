package com.chlz.generator.utils;

import java.lang.reflect.Field;

public class ObjectUtil {

    public static void setField(Object obj, String fieldName, Object fieldValue) {
        Class<?> aClass = obj.getClass();
        try {
            Field field = aClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, fieldValue);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
