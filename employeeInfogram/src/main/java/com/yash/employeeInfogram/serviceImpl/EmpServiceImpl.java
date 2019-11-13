package com.yash.employeeInfogram.serviceImpl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.yash.employeeInfogram.model.Employee;
import com.yash.employeeInfogram.service.EmpServices;
import com.yash.employeeInfogram.service.EmployeeSupplier;

public class EmpServiceImpl implements EmpServices {
	Scanner sc = new Scanner(System.in);

	// Get List using Supplier Interface
	public static List<Employee> list = EmployeeSupplier.supplier.get();

	// Using Consumer
	@Override
	public List<Employee> getAllEmployees() {
		Consumer<List<Employee>> consumer = (list) -> list.forEach(System.out::println);
		consumer.accept(list);
		return list;
	}

	// stream API
	@Override
	public boolean getEmployeeById(int id) throws ParseException {

		try {
			list.stream().filter((e) -> e.getId() == id).forEach(System.out::println);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean getEmployeeByName(String name) throws ParseException {

		try {
			list.stream().filter((e) -> e.getName().equalsIgnoreCase(name)).forEach(System.out::println);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	// Using Predicate Interface
	@Override
	public boolean getEmployeeBySalary(double salary, int option) throws ParseException {
		switch (option) {
		case 1:
			Predicate<Employee> predicate = (p) -> p.getSalary() > salary;
			List<Employee> empList = list.stream().filter(predicate).collect(Collectors.toList());
			if (!empList.isEmpty()) {
				System.out.println(empList);
				return true;
			} else {
				System.out.println("No Employee Found With Given Criteria..!");
			}
			break;
		case 2:
			Predicate<Employee> predicate2 = (p) -> p.getSalary() < salary;
			List<Employee> empList2 = list.stream().filter(predicate2).collect(Collectors.toList());
			if (!empList2.isEmpty()) {
				System.out.println(empList2);
				return true;
			} else {
				System.out.println("No Employee Found With Given Criteria..!");
			}
			break;

		default:
			break;
		}

		return false;

	}

	// Using Function Interface
	@Override
	public List<String> getNewJoinersByUsingFunction() {
		Function<List<Employee>, List<String>> f = (li) -> list.stream()
				.filter((employee) -> ChronoUnit.DAYS.between(LocalDate.of(employee.getJoiningDate().getYear(),
						employee.getJoiningDate().getMonth(), employee.getJoiningDate().getDayOfMonth()),
						LocalDate.now()) < 30)
				.map((e) -> " \n" + e.getName() + " Join on ::" + e.getJoiningDate()).collect(Collectors.toList());

		return f.apply(list);
	}

	// Using Function Interface
	public boolean getEmployeeByRole(String role) {

		try {

			Function<List<Employee>, List<String>> f = (list) -> list.stream()
					.filter((e) -> e.getRole().equalsIgnoreCase(role)).map((e) -> e.getName())
					.collect(Collectors.toList());
			System.out.println(f.apply(list));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// JAVA 8 DATE API used
	@Override
	public List<Employee> getNewJoinersd() throws ParseException {
		List<Employee> list = new ArrayList<Employee>();
		for (Employee employee : list) {
			long noOfDays = ChronoUnit.DAYS.between(LocalDate.of(employee.getJoiningDate().getYear(),
					employee.getJoiningDate().getMonth(), employee.getJoiningDate().getDayOfMonth()), LocalDate.now());
			if (noOfDays < 30) {
				System.out.println("Number of Days of " + employee.getName() + " in Yash are " + noOfDays);
				list.add(employee);
			}
		}
		return list;
	}

	@Override
	public boolean deleteEmployee(int id) {
		Iterator<Employee> itr = list.listIterator();
		while (itr.hasNext()) {
			Employee emp = (Employee) itr.next();
			if (emp.getId() == id) {
				itr.remove();
				System.out.println("Employee with Id  " + emp.getId() + " deleted Successfully...!");
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmployee(int id) {
		for (Employee employee : list) {
			if (employee.getId() == id) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Employee Name");
				String empName = sc.next();
				System.out.println("Enter Employee Email");
				String mail = sc.next();
				System.out.println("Enter Employee mobile number");
				String mobile = sc.next();
				System.out.println("Enter Employee salary");
				double salary = sc.nextDouble();
				System.out.println("Enter Employee role");
				String emprole = sc.next();

				employee.setName(empName);
				employee.setEmail(mail);
				employee.setMobile(mobile);
				employee.setSalary(salary);
				employee.setRole(emprole);
				System.out.println("Employee with Id  " + employee.getId() + " update Successfully...!");
				
				return true;
			} else
				System.out.println("No Employee found with this id..!");

		}
		return false;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		try {
			list.add(emp);
			System.out.println("Employee " + emp.getName() + " added Successfully...!");
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	/*
	 * Grouping By Map<String, List<Employee>>
	 * e=list.stream().collect(Collectors.groupingBy(Employee::getRole));
	 * Set<Entry<String, List<Employee>>> set=e.entrySet(); for (Entry<String,
	 * List<Employee>> entry : set) { System.out.println(entry.getKey()+" "+
	 * entry.getValue()); }
	 * 
	 */

}
