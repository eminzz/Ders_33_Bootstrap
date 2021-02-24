package az.charming.teachermanagement.dto;

import az.charming.entity.StudentEntity;

import java.math.BigDecimal;

public class StudentFormDto { //Data Transfer Object

    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public void setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
    }

    public StudentEntity toEntity(){
        return new StudentEntity()
                .setName(this.name)
                .setSurname(this.surname)
                .setAge(this.age)
                .setScholarship(this.scholarship);
    }
}
