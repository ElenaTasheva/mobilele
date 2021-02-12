package com.example.mobilele.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.YearMonth;

public class YearInPastOrPresentValidator implements ConstraintValidator<YearInPastOrPresent,Integer> {


    private int minYear;

    @Override
    public void initialize(YearInPastOrPresent constraintAnnotation) {
        this.minYear = constraintAnnotation.minYear();

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        int nowYear = YearMonth.now().getYear();
        return value >= minYear && value <= nowYear;
    }
}
