package com.Project.Application.Validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NameValidation.class)

public @interface FnameValidator {
    public String message() default "Invalid Name";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
