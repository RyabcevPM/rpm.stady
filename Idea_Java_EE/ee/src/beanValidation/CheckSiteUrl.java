package beanValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotNull
@Size(min = 7)
//@Pattern(regexp = "[A-Za-z0-9]*@[A-Za-z0-9]*\\.com")
@Constraint(validatedBy = {CheckSiteUrlLogic.class})
@Target({METHOD, FIELD, PARAMETER, ANNOTATION_TYPE, CONSTRUCTOR})
@Retention(RUNTIME)
public @interface CheckSiteUrl {
    String message() default "wrong url";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int port() default -1;
    String host() default "";
    String protocol() default "";

}
