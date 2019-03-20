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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

@WebServlet("/bv2")
public class MyValidator extends HttpServlet {
    @Inject
    Validator validator;

    void OutValidateResult(Set<ConstraintViolation<Person>> validate) {
        if (validate.size() > 0) {
            System.out.print("Error: ");
        } else {
            System.out.println("Validate is ok.");
        }
        for (ConstraintViolation<Person> v : validate) {
            System.out.println(v.getPropertyPath().toString() + " = " + v.getInvalidValue() + ": " + v.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<Person>> email1 = validator.validateValue(Person.class, "email", "mymail@gmail.com");
        OutValidateResult(email1);
        OutValidateResult(validator.validateValue(Person.class, "email", "mymail@gmail.ru"));
        OutValidateResult(validator.validateValue(Person.class, "site", "mymail@tut.by"));
        OutValidateResult(validator.validateValue(Person.class, "site2", "24234@gmail.ru"));
        OutValidateResult(validator.validateValue(Person.class, "site3", "http://localhost:8080/bv2"));
        OutValidateResult(validator.validateValue(Person.class, "site4", "x@x.ru"));
        OutValidateResult(validator.validateValue(Person.class, "site4", "http://mysite.com/#/index.html"));
        OutValidateResult(validator.validateValue(Person.class, "site4", "ftp://mysite.com:22/Paco/index.html"));
        OutValidateResult(validator.validateValue(Person.class, "site4", "ftp://mysite.com:21/Paco/index.html"));
    }
}


class Person {
    @CheckEmail
    String email;

    @CheckSiteUrl
    String site;
    @CheckSiteUrl(protocol = "http")
    String site2;
    @CheckSiteUrl(host = "mysite.com")
    String site3;
    @CheckSiteUrl(protocol = "ftp", port = 21)
    String site4;

}

class CheckSiteUrlLogic implements ConstraintValidator<CheckSiteUrl, String> {
    int port;
    String host;
    String protocol;

    @Override
    public void initialize(CheckSiteUrl checkSiteUrl) {
        port = checkSiteUrl.port();
        host = checkSiteUrl.host();
        protocol = checkSiteUrl.protocol();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (s == null || s.equals("")) {
            return true;
        }
        java.net.URL url;
        try {
            url = new URL(s);
        } catch (MalformedURLException e) {
            return false;
        }

        if (protocol != null && protocol.length() > 0 && !protocol.equals(url.getProtocol())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("protocol invalid").addConstraintViolation();
            return false;
        }
        if (host != null && host.length() > 0 && !host.equals(url.getHost())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("host invalid").addConstraintViolation();
            return false;
        }
        if (port != -1 && port != url.getPort()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("port invalid").addConstraintViolation();
            return false;
        }
        return true;
    }
}