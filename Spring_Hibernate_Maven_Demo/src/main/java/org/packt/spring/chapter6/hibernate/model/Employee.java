package org.packt.spring.chapter6.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_INFO")
public class Employee {

	@Id
	@SequenceGenerator(name = "employee_info_seq", allocationSize = 1, sequenceName = "employee_info_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_info_seq")
	@Column(name = "ID")
	private Integer id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "JOB_TITLE")
	private String jobTitle;

	@Column(name = "DEPARTMENT")
	private String department;

	@Column(name = "SALARY")
	private int salary;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String jobTitle,
			String department, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.department = department;
		this.salary = salary;
	}

	public Employee(Integer id, String firstName, String lastName,
			String jobTitle, String department, int salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.department = department;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee employee = (Employee) obj;
		if (firstName != null ? !firstName.equals(employee.firstName)
				: employee.firstName != null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int hashCode() {
		return firstName != null ? firstName.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", jobTitle=" + jobTitle
				+ ", department=" + department + ", salary=" + salary + "]";
	}

}
