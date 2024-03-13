package ru.gb.studentapi.util;

import ru.gb.studentapi.model.Student;

import java.util.List;

public class StudentDaoInitializerUtil {
    public static void init(List<Student> students){
        students.add(new Student.Builder().withFirstName("Anton").withSurName("Antonov").withGroupId(1).build());
        students.add(new Student.Builder().withFirstName("Ivan").withSurName("Ivanov").withGroupId(1).build());
        students.add(new Student.Builder().withFirstName("Petr").withSurName("Petrov").withGroupId(2).build());
        students.add(new Student.Builder().withFirstName("Boris").withSurName("Borisov").withGroupId(3).build());
        students.add(new Student.Builder().withFirstName("Semen").withSurName("Semenov").withGroupId(3).build());
    }
}
