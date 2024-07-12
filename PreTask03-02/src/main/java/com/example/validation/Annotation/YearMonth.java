package com.example.validation.Annotation;

import com.example.validation.Validator.YearMonthValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {YearMonthValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
//@Size(min=8, max=8)
public @interface YearMonth {
    String message() default "Invalid YearMonth ex) yyyyMM";
    String pattern() default "yyyyMM";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
