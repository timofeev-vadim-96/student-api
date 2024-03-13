package ru.gb.studentapi.dao;

import ru.gb.studentapi.model.Student;

import java.util.List;

public interface StudentDao {
    Student getById(long id);
    Student addNewStudent(Student student);
    Student updateStudent(long id, Student student);
    boolean deleteStudent(long id);
    List<Student> getALlStudents();
    List<Student> getStudentsByFirstName(String firstName);
    List<Student> getStudentsByGroup(long groupId);
}
