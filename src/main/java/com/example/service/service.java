package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Emp;
import com.example.repository.EmpRepository;

//import com.javatpoint.repository.EmpRepository;
@Service
public class service {

	@Autowired
	EmpRepository empsRepository;

	// getting all books record by using the method findaAll() of CrudRepository
	public List<Emp> getAllEmps() {
		List<Emp> emps = new ArrayList<Emp>();
		empsRepository.findAll().forEach(emps1 -> emps.add(emps1));
		return emps;
	}

	// getting a specific record by using the method findById() of CrudRepository
	public Emp getBooksById(int id) {
		return empsRepository.findById(id).get();
	}

	public int saveOrUpdate(Emp emps) {
		// TODO Auto-generated method stub
		empsRepository.save(emps);
		return emps.getEmpid();

	}

	public void delete(int empid) {
		// TODO Auto-generated method stub
		empsRepository.deleteById(empid);

	}

	public void update(Emp emps, int empid) {
		empsRepository.save(emps);
	}

}
