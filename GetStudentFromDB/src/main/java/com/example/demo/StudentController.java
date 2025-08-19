package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students") // Base path
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getall")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }


    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }


    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean deleted = studentService.deleteStudent(id);
        return deleted ? "Student deleted successfully" : "Student not found";
    }
}
