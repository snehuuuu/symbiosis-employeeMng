package sym.test.emp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sym.test.emp.entity.Employee;
import sym.test.emp.service.EmployeeService;

@Controller
public class EmployeeHtmlController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/saveEmployees")
	public String SaveEmp(Model model) {
		model.addAttribute("newemp",new Employee());
		return "newEmployee";
	}
	
	@PostMapping("/employeeAdded")
	public String employeeAdd( @ModelAttribute("newemp")Employee employee,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "newEmployee";
		}
		service.saveEmp(employee);
		model.addAttribute("message", "employee added successfully");
		return "newEmployee";
		
	}
	
	@GetMapping("/existingEmployee")
	public String existingEmp(Model model) {
		List<Employee> list=service.getAllEmp();
//		for(Employee e:list) {
//			System.out.println(e.getFirstName());
//		}
		model.addAttribute("employees", list);
		return "existingEmployee";
		
	}
	
	@PostMapping("/deleteExisting")
	public String deleteEmp(@RequestParam("id") long id) {
		service.deleteEmp(id);
		return "redirect:/existingEmployee";
		
	}
	
	@GetMapping("/updatedExisting")
	public String updateEmpForm(@RequestParam("id" )long id,Model model) {
		Employee emp=service.getEmpById(id);
		//System.out.println(emp);
		model.addAttribute("emp", emp);
		return "updateEmployee";
	}
	
	@PostMapping("/empUpdateSucc")
	public String updatedSuccess(@ModelAttribute("emp") Employee bt, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "updateEmployee";
		}
		
		//System.out.println(bt);
		Employee b=service.updateEmp(bt);
		//System.out.println(b);
		model.addAttribute("message", "employee updated successfully");
		return "redirect:/existingEmployee";
		
	}
	
	

}
