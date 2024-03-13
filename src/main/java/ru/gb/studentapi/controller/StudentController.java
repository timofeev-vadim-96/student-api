package ru.gb.studentapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.studentapi.model.Student;
import ru.gb.studentapi.dao.StudentDao;

import java.util.List;

@RestController
public class StudentController {
    private final StudentDao service;

    public StudentController(StudentDao service) {
        this.service = service;
    }

    @GetMapping("student")
    public List<Student> getAllStudents(){
        return service.getALlStudents();
    }

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable("id") long id){
        return service.getById(id);
    }

    @GetMapping("student/search")
    public List<Student> getStudentsByName(@RequestParam("name") String name){
        return service.getStudentsByFirstName(name);
    }

    @GetMapping("/group/{groupId}/student")
    public List<Student> getStudentsByGroup(@PathVariable("groupId") long groupId){
        return service.getStudentsByGroup(groupId);
    }

    @PostMapping("student")
    public ResponseEntity<Student> postStudent(@RequestBody Student inputStudent){
        Student createdStudent = service.addNewStudent(inputStudent);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    @PutMapping("student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student inputStudent){
        Student createdStudent = service.updateStudent(id, inputStudent);
        return new ResponseEntity<>(createdStudent, HttpStatus.OK);
    }

    @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable("id") long id){
        service.deleteStudent(id);
    }
}
