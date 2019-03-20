package beanValidation;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

@WebServlet("/bv3")
public class ClassValidExample extends HttpServlet {
    @Inject
    Validator validator;

    @Inject
    LuckyPerson luckyPerson;

    void OutValidateResult(Set<ConstraintViolation<LuckyPerson>> validate) {
        if (validate.size() > 0) {
            System.out.print("Error: ");
        } else {
            System.out.println("Validate is ok.");
        }
        for (ConstraintViolation<LuckyPerson> v : validate) {
            System.out.println(v.getPropertyPath().toString() + " = " + v.getInvalidValue() + ": " + v.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        luckyPerson.setBirthDay(LocalDate.of(2017,1,1));
        luckyPerson.setDeathDate(LocalDate.of(1117,1,1));
        OutValidateResult(validator.validate(luckyPerson));

        resp.getWriter().write("ClassValidExample");
    }
}


