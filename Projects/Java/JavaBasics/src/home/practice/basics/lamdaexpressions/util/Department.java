package home.practice.basics.lamdaexpressions.util;

import java.util.ArrayList;
import java.util.List;

public class Department {

	String name;
	List<Employee> employees;

	public Department(String name) {
		super();
		this.name = name;
		employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [name=");
		builder.append(name);
		builder.append(", employees=");
		builder.append(employees);
		builder.append("]");
		return builder.toString();
	}
}