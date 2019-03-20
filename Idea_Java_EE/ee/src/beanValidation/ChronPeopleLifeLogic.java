package beanValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChronPeopleLifeLogic implements ConstraintValidator<ChronPeopleLife, LuckyPerson> {
    @Override
    public void initialize(ChronPeopleLife chronPeopleLife) {
    }

    @Override
    public boolean isValid(LuckyPerson luckyPerson, ConstraintValidatorContext constraintValidatorContext) {
        return luckyPerson.getBirthDay().isBefore(luckyPerson.getDeathDate());
    }
}
