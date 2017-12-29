/**
 * author: Feng Bo
 *
 * date: Dec 29, 2017
 */
package studio.bobbyfeng;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private String name;
	
	private List<Employee> employees;

	public Department(String name) {
		this.name = name;
		employees = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
}
