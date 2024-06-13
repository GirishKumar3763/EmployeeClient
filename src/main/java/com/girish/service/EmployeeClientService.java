package com.girish.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;
import com.girish.dto.EmployeeRecord;

@HttpExchange(url="/emp-service")
public interface EmployeeClientService {
	
	@GetExchange("/getallemployees")
	 ResponseEntity<List<EmployeeRecord>> getAllEmployees();
	
	@GetExchange("/employeebyid/{id}")
	ResponseEntity<EmployeeRecord> getByEmployeeId(@PathVariable("id") Integer id);
	
	@PostExchange("/insertemployee")
	ResponseEntity<EmployeeRecord> insertEmployee(@RequestBody EmployeeRecord user);

    @PutExchange("/updateemployee")
	ResponseEntity<EmployeeRecord> updateEmployee( @RequestBody EmployeeRecord user);

	@DeleteExchange("/delete/{id}")
	ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Integer id);

}
