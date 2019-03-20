package beanValidation;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotNull
@Size(min = 7)
@Pattern(regexp = "[A-Za-z0-9]*@[A-Za-z0-9]*\\.com")
@Constraint(validatedBy = {})
@Target({METHOD, FIELD, PARAMETER, ANNOTATION_TYPE, CONSTRUCTOR})
@Retention(RUNTIME)
public @interface CheckEmail{
    String message() default "Email address doesn't look good";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

