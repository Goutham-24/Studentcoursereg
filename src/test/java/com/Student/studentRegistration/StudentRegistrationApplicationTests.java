package com.Student.studentRegistration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.Student.model.Student;
import com.Student.repository.StudentRepository;
import com.Student.service.StudentService;

@ExtendWith(MockitoExtension.class)
class StudentRegistrationApplicationTests {
	@Mock
	private StudentRepository repo;

	@InjectMocks
	private StudentService service;

	@Test
	void contextLoads() {
		Student s = new Student();
		s.setName("name");
		s.setEmail("yas@gmail.com");
		s.setCourse("new course");

		when(repo.save(s)).thenReturn(s);
		Student res = service.saveStudent(s);

		assertEquals("name",res.getName());
		assertEquals("yas@gmail.com", res.getEmail());
	}

}
