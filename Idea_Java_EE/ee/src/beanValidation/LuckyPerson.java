package beanValidation;

import java.time.LocalDate;

@ChronPeopleLife
public class LuckyPerson {
    LocalDate birthDay;
    LocalDate deathDate;

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
}
