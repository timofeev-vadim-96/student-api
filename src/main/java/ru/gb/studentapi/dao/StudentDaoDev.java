package ru.gb.studentapi.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.gb.studentapi.model.Student;
import ru.gb.studentapi.util.StudentDaoInitializerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("development")
public class StudentDaoDev implements StudentDao {
    private List<Student> students;

    public StudentDaoDev() {
        students = new ArrayList<>();
        StudentDaoInitializerUtil.init(students);
    }

    @Override
    public Student getById(long id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Student addNewStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student updateStudent(long id, Student student) {
        Student retrievedStudent = getById(id);

        if (retrievedStudent == null) return null;

        retrievedStudent.setFirstName(student.getFirstName());
        retrievedStudent.setSurName(student.getSurName());
        retrievedStudent.setGroupId(student.getGroupId());

        return retrievedStudent;
    }

    @Override
    public boolean deleteStudent(long id) {
        return students.removeIf(student -> student.getId() == id);
    }

    @Override
    public List<Student> getALlStudents() {
        return students;
    }

    @Override
    public List<Student> getStudentsByFirstName(String firstName) {
        return students.stream()
                .filter(student -> student.getFirstName().contains(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsByGroup(long groupId) {
        return students.stream()
                .filter(student -> student.getGroupId() == groupId)
                .collect(Collectors.toList());
    }
}
