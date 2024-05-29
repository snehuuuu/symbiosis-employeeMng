package sym.test.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sym.test.emp.entity.Employee;
import sym.test.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository repo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Employee> getAllEmp() {
	List<Employee> ls=repo.findAll();
		return ls;
	}

	@Override
	public Employee saveEmp(Employee emp) {
		Employee et=repo.save(emp);
		return et;
	}

	@Override
	public Employee updateEmp(Employee emp) {
		Employee e=repo.findById(emp.getId()).get();
		e.setFirstName(emp.getFirstName());
		e.setLastName(emp.getLastName());
		e.setEmail(emp.getEmail());
		e.setDepartment(emp.getDepartment());
		repo.save(e);
		return e;
	}

	@Override
	public Employee getEmpById(long id) {
		Employee e=repo.findById(id).get();
		return e;
	}

	@Override
	public String deleteEmp(long id) {
		repo.deleteById(id);
		return "deleted";
		
	}

}
