package com.Student.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Exception.StudentNotFoundException;
import com.Student.model.Student;
import com.Student.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student updateData(Long id, Student studentDetails){
        Student student = getStudentById(id);
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setCourse(studentDetails.getCourse());
        return repo.save(student);
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElseThrow(()-> new StudentNotFoundException("Cant find student ID: "+id));
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        repo.delete(student);
    }
}
