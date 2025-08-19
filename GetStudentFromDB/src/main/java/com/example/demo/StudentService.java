package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student updateStudent(int id, Student updatedStudent) {
        return studentRepo.findById(id).map(existing -> {
            existing.setName(updatedStudent.getName());
            existing.setAge(updatedStudent.getAge());
            existing.setAddress(updatedStudent.getAddress());
            return studentRepo.save(existing);
        }).orElse(null);
    }


    public boolean deleteStudent(int id) {
        return studentRepo.findById(id).map(student -> {
            studentRepo.delete(student);
            return true;
        }).orElse(false);
    }
}
