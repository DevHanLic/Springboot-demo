package com.example.spring.demo.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author han_lic
 * @date 2021/3/5 9:20
 */
public class CopyUtils {
    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 排除null值的拷贝
     * @param src
     * @param target
     */
    public static void copyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }


    /**
     * Apache
     * @param src
     * @param target
     * @throws Exception
     */
    public static void copyPropertiesOfApache(Object src, Object target) {
        try {
          copyProperties(target, src);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    /**
     * List的拷贝
     * @param srcList
     * @param tarClass
     */
    public static <T> List<T> convertListProperties(List<?> srcList, Class<T> tarClass) {
        if (JudgeUtils.isEmpty(srcList)){
            return Collections.emptyList();
        }

        List<T> tarGetList = new ArrayList<>(srcList.size());

        try {
            for(Object src :srcList){
                T target=tarClass.newInstance();
                BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
                tarGetList.add(target);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return  tarGetList;
    }

    /**
     * 转换成目标对象
     * @param src
     * @param tarClass
     * @param <T>
     * @return
     */
    public static <T> T convertObject(Object src, Class<T> tarClass){
        if (null == src){
            return null;
        }
        T t=null;
        try {
            t = tarClass.newInstance();
            copyProperties(src,t);
        } catch (Exception e) {
            e.getMessage();
        }
        return t;
    }

    /**
     * 转换成目标对象
     * @param src
     * @param tarClass
     * @param <T>
     * @return
     */
    public static <T> T convertObjectOfApache(Object src, Class<T> tarClass){
        if (null == src){
            return null;
        }
        T t=null;
        try {
            t = tarClass.newInstance();
            copyPropertiesOfApache(src,t);
        } catch (Exception e) {
            e.getMessage();
        }
        return t;
    }

    /**
     * 设置空值
     * @param source
     * @param <T>
     * @return
     */
    public static <T> T setStringObjectNull(T source) {
        if (null == source) {
            return null;
        }
        try {
            Field[] fields = source.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("class java.lang.String".equals(field.getGenericType().toString())) {
                    field.setAccessible(true);
                    String obj = (String) field.get(source);
                    if (StringUtils.isBlank(obj)) {
                        field.set(source, " ");
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return source;
    }
}
