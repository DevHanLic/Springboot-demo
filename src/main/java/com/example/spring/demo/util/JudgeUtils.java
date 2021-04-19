package com.example.spring.demo.util;

import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author han_lic
 * @date 2021/3/4 11:55
 */
public class JudgeUtils {

    public static <T> boolean isNull(T t) {
        return null == t;
    }

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return ! isEmpty(str);
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 集合是否为空
     * @param c
     * @return
     */
    public static boolean isEmpty(Collection<?> c) {
        if(null == c) {
            return true;
        }
        if(c.size() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 集合是否不为空
     * @param c
     * @return
     */
    public static boolean isNotEmpty(Collection<?> c) {
        return !isEmpty(c);
    }

    /**
     * 判断map是否为空
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        if(null == map) {
            return true;
        }
        if(map.size() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断map是否不为空
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }


    public static <T> boolean isEmpty(T[] ts) {
        if(null == ts) {
            return true;
        }
        if(ts.length <= 0) {
            return true;
        }
        return false;
    }

    public static <T> boolean isNotEmpty(T[] ts) {
        return !isEmpty(ts);
    }

    /**
     * 集合是否包含某个元素，当元素为空是不判断，直接返回false
     * @param collection
     * @param item
     * @param <T>
     * @return
     */
    public static <T> boolean contain(Collection<T> collection, T item) {
        if (isEmpty(collection)) {
            return false;
        }
        if (isNull(item)) {
            return false;
        }
        return collection.stream().anyMatch(c -> c.equals(item));
    }


    /**
     * 非
     * @param flag
     * @return
     */
    public static boolean not(boolean flag) {
        return ! flag;
    }

    /**
     *
     * @param flag
     * @param defaultFlag flag == null 时取该值
     * @return
     */
    public static boolean isTrue(Boolean flag, boolean defaultFlag) {
        return null == flag ? defaultFlag : flag;
    }

    /**
     *
     * @param flag
     * @param supplier
     * @param <T>
     * @return
     */
    public static <T> T callbackIfNecessary(boolean flag, Supplier<T> supplier) {
        return flag ? supplier.get() : null;
    }


}
