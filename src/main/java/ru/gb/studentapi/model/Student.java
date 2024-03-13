package ru.gb.studentapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
public class Student {
    private long id;
    private String firstName;
    private String surName;
    private long groupId;

    private static long idCounter = 1;

    public Student() {
        id = idCounter++;
    }

    public static class Builder {
        private Student student;

        public Builder(){
            student = new Student();
        }

        public Builder withFirstName(String firstName){
            student.setFirstName(firstName);
            return this;
        }
        public Builder withSurName(String surName){
            student.setSurName(surName);
            return this;
        }

        public Builder withGroupId(int groupId){
            student.setGroupId(groupId);
            return this;
        }

        public Student build(){
            return student;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(surName, student.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, surName);
    }
}
