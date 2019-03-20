package beanValidation;

import jsp.Person;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import javax.validation.executable.ExecutableValidator;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

@WebServlet("/bv1")
public class StandartValidExample extends HttpServlet {
    @Inject
    RightPerson person;

//    @Inject
//    Validation validation;

    void OutValidateResult(Set<ConstraintViolation<RightPerson>>  validate) {
        if (validate.size() > 0) {
            System.out.println("Error:");
        } else {
            System.out.println("Validate is ok.");
        }
        for (ConstraintViolation<RightPerson> v : validate) {
            System.out.println(v.getPropertyPath().toString()+ " = " + v.getInvalidValue() + ": " + v.getMessage());
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        person.name = "rpm";
        person.age = 14;

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
//        Set<ConstraintViolation<RightPerson>> validate = validator.validate(person);
        OutValidateResult(validator.validate(person));
        OutValidateResult(validator.validateProperty(person, "name"));
        OutValidateResult(validator.validateValue(RightPerson.class, "name", "anton"));
        OutValidateResult(validator.validateValue(RightPerson.class, "name", "Paco"));


        try {
            Method setName = RightPerson.class.getMethod("setName", String.class);
            ExecutableValidator executableValidator = validator.forExecutables();
            Object[] params = {"Max"};
//            Object[] params = {null};
            Set<ConstraintViolation<Class<RightPerson>>> v2 = executableValidator.validateParameters(RightPerson.class, setName, params);
            if (v2.size() > 0) {
                System.out.println("param is wrong");
            } else {
                System.out.println("param is ok");
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        validatorFactory.close();


        resp.getWriter().write("StandartValidExample: hello!");

    }
}


class RightPerson {
    @NotNull
    @Pattern(regexp = "[A-Z][a-z]*")
    @Size(max = 200, min = 3)
    String name;

    @Pattern.List({@Pattern(regexp = "[A-Z][a-z]*"), @Pattern(regexp = "Paco2000")})
    String surname;

    @Min(18)
    @Max(150)
    int age;

    @Past
    Date birthDay;

    public String getName() {
        return name;
    }

    public void setName(@NotNull @Pattern(regexp = "[A-Z][a-z]*") String name) {
        this.name = name;
    }

    @Future
    Date badDay;


}