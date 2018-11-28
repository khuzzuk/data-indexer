package com.example.dataindexer.userservice.rest;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@RequestMapping(method = RequestMethod.GET)
@Documented
@Inherited
public @interface GetMapping {
    @AliasFor(annotation = RequestMapping.class)
    String value() default "";
}
