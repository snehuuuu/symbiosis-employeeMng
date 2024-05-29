package sym.test.emp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sym.test.emp.entity.Employee;
import sym.test.emp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployee(){
		return service.getAllEmp();
		
	}
	
	@PostMapping("/saveemp")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return service.saveEmp(emp);
		
	}
	
	@PutMapping("/updateemp")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return service.updateEmp(emp);
	}
	
	@GetMapping("/getbyid")
	public Employee getById(@PathVariable long id) {
		return service.getEmpById(id);
	}
	
	@DeleteMapping("/deleteemp")
	public String deleteEmployee(@PathVariable long id) {
		return service.deleteEmp(id);
	}

	
}
