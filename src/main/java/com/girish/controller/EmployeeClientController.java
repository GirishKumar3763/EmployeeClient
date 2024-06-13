package com.girish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.girish.dto.EmployeeRecord;
import com.girish.service.EmployeeClientService;

@RestController
@RequestMapping("/client/employees")
public class EmployeeClientController {
	
	
	public final EmployeeClientService employeeClientService;
	
	public EmployeeClientController(EmployeeClientService employeeClientService ) {
		this.employeeClientService=employeeClientService;
	}
	
	@GetMapping("/getallemployees")
	ResponseEntity<List<EmployeeRecord>> getAllEmployees(){
		return employeeClientService.getAllEmployees();
	}
	
	@GetMapping("/employeebyid/{id}")
	ResponseEntity<EmployeeRecord> getByEmployeeId(@PathVariable("id") Integer id){
		return employeeClientService.getByEmployeeId(id);
	}
	
	@PostMapping("/insertemployee")
	ResponseEntity<EmployeeRecord> insertEmployee(@RequestBody EmployeeRecord user){
		return employeeClientService.insertEmployee(user);
	}

   @PutMapping("/updateemployee")
	ResponseEntity<EmployeeRecord> updateEmployee( @RequestBody EmployeeRecord user){
	   return employeeClientService.updateEmployee(user);
   }

	@DeleteMapping("/delete/{id}")
	ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Integer id){
		return employeeClientService.deleteEmployee(id);
	}

}
