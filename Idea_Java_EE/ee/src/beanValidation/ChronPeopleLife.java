package beanValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {ChronPeopleLifeLogic.class})
@Target({TYPE})
@Retention(RUNTIME)
public @interface ChronPeopleLife {
    String message() default "wrong birthday or deathDate";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


