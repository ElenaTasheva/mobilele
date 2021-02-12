package com.example.mobilele.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = YearInPastOrPresentValidator.class)
public @interface YearInPastOrPresent {


    String message () default "Invalid year";

    int minYear();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
