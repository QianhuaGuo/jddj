package com.example.qianhua.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberCheck.NumberCheckValidtor.class)
@Documented
public @interface NumberCheck {
    String message() default "校验失败,字段不能为负";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    class NumberCheckValidtor implements ConstraintValidator<NumberCheck,Integer> {
        @Override
        public void initialize(NumberCheck constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(Integer value, ConstraintValidatorContext context) {
            return value>0;
        }
    }
}
