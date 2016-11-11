package org.packt.spring.main;

import org.packt.spring.chapter6.hibernate.model.Employee;
import org.packt.spring.chapter6.hibernate.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/app-context.xml");
		EmployeeService employeeService = context.getBean(
				"employeeServiceImpl", EmployeeService.class);

		// insert employee
		
		// Employee emp = new Employee();
		// emp.setFirstName("Constantin");
		// emp.setLastName("Brasovan");
		// emp.setJobTitle("Software Engineer");
		// emp.setDepartment("Development");
		// emp.setSalary(3000);
		// employeeService.insertEmployee(emp);
		
		// fetch all employee
		for (Employee employee : employeeService.getAllEmployees())
			System.out.println(employee);
	
	}

}
