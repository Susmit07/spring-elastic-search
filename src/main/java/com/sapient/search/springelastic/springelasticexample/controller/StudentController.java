package com.sapient.search.springelastic.springelasticexample.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.search.springelastic.springelasticexample.model.Student;
import com.sapient.search.springelastic.springelasticexample.repository.StudentRepository;

@RestController
public class StudentController {

		@Autowired
		StudentRepository repository;

		
		@PostMapping("/student/add")
		public Student addStudent(@RequestBody Student student ){
			return repository.save(student);
		}

		@GetMapping("/student/all")
		public List<Student> getStudents(){
			return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
		}

		@GetMapping("/student/{id}")
		public Optional<Student> getStudent(@PathVariable Integer id){
			return repository.findById(id);
		}

		@PutMapping("/student/{id}")
		public Student updateStudent(@PathVariable Integer id,@RequestBody Student student){
			Optional<Student> std = repository.findById(id);
			if(std.isPresent()){
				Student s = std.get();
				s.setName(student.getName());
				return repository.save(s);
			}else return null;
		}

		@DeleteMapping("/student/{id}")
		public void deleteStudent(@PathVariable Integer id){
			repository.deleteById(id);
		}
	}
