package sym.test.emp.service;

import java.util.List;

import sym.test.emp.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmp();
	public Employee saveEmp(Employee emp);
	public Employee updateEmp(Employee emp);
	public Employee getEmpById(long id);
	public String deleteEmp(long id);
	
	
}
