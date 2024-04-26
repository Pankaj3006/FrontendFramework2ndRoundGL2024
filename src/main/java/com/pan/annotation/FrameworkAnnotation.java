package com.pan.annotation;

import com.pan.enums.AuthorType;
import com.pan.enums.CategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotation {

    public AuthorType[] author() default {};

    public CategoryType[] category() default  {};

}
