package com.example.spring.demo.util;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author han_lic
 * @date 2021/3/4 11:51
 */
public class ObjectUtils {
    private static final Logger logger = LoggerFactory.getLogger(ObjectUtils.class);

    /**
     * 将字段值为空的赋值为 " "
     *
     * @param o
     * @return
     */
    public static void strToObject(Object o) {
        try {
            Field[] fields = o.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                if ("class java.lang.String".equals(f.getGenericType().toString())) {
                    f.setAccessible(true);
                    if (JudgeUtils.isNull(f.get(o))) {
                        f.set(o, " ");
                    }
                } else if ("class java.math.BigDecimal".equals(f.getGenericType().toString())) {
                    f.setAccessible(true);
                    if (JudgeUtils.isNull(f.get(o))) {
                        f.set(o, new BigDecimal(0));
                    }
                } else if ("class java.lang.Long".equals(f.getGenericType().toString())) {
                    f.setAccessible(true);
                    if (JudgeUtils.isNull(f.get(o))) {
                        f.set(o, Long.parseLong("0"));
                    }
                } else if ("class java.lang.Integer".equals(f.getGenericType().toString())) {
                    f.setAccessible(true);
                    if (JudgeUtils.isNull(f.get(o))) {
                        f.set(o, Integer.parseInt("0"));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
