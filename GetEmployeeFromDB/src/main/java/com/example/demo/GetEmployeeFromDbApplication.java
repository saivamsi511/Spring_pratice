package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
class studentinfo
{
	@Column
	int roomnum;
}

@RestController
class Controlr{	
	@Autowired
	studentinfo s;
	@Autowired
	GetInfo g;
	
	@GetMapping("/")
	public List<studentinfo>getRoomnum()
	{	
		return g.getALL();
	}	
}


@Service
class GetInfo{
	
	@Autowired
	IStudent stud;
	
	public List<studentinfo> getALL()
	{

		return stud.findAll();
	}
}


@Repository

interface IStudent extends JpaRepository<studentinfo, Integer>{
	
}


@SpringBootApplication
public class GetEmployeeFromDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetEmployeeFromDbApplication.class, args);
	}

}
