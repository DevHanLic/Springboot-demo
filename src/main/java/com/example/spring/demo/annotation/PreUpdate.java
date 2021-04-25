package com.example.spring.demo.annotation;

import java.lang.annotation.*;

/**
 * @author han_lic
 * @date 2021/4/25 15:00
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface PreUpdate {

}
