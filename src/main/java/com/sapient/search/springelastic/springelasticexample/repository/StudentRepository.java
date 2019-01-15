package com.sapient.search.springelastic.springelasticexample.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.search.springelastic.springelasticexample.model.Student;

@Repository
public interface StudentRepository extends ElasticsearchCrudRepository<Student, Integer> {
	

}
