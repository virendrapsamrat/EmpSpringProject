package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Emp;
import com.example.service.service;

@RestController
public class EmpController {

	@Autowired
	service empsservice;

	@PostMapping("/emps")
	private int saveEmp(@RequestBody Emp emps) {
		empsservice.saveOrUpdate(emps);
		return emps.getEmpid();

	}
	
	@GetMapping("/emp/{empid}")
	private Emp getBooks(@PathVariable("empid") int empid) 
	{
	return empsservice.getBooksById(empid);
//	return 1;
	}
	
	@GetMapping("/allemps")
	private List<Emp> getAllEmp() {
		return empsservice.getAllEmps();
	}

	//creating a delete mapping that deletes a specified book
	
	@DeleteMapping("/emp/{empid}")
	private void deleteEmp(@PathVariable("empid") int empid) 
	{
		empsservice.delete(empid);
	}
	
	//creating put mapping that updates the book detail 
	@PutMapping("/emps")
	private Emp update(@RequestBody Emp emps) 
	{
		empsservice.saveOrUpdate(emps);
	return emps;
	}
}
