package com.yash.employeeInfogram.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.yash.employeeInfogram.model.Employee;
import com.yash.employeeInfogram.serviceImpl.EmpServiceImpl;

public class EmployeeTest {

	EmpServiceImpl service;
	Employee employee;

	@Before
	public void setUp() throws Exception {
		service = new EmpServiceImpl();
		employee = new Employee(8, "AAA", "AAA", "111111111", 45664, LocalDate.now(), "Devloper");
	}

	@Test
	public void testGetEmployeeById() throws ParseException {
		assertEquals("Employee fetched by id successfully ", true, service.getEmployeeById(1));
	}

	@Test
	public void testGetEmployeeByName() throws ParseException {
		assertEquals("Employee fetched by name successfully ", true, service.getEmployeeByName("kazim"));
	}

	@Test
	public void testGetEmployeeBySalary() throws ParseException {
		assertEquals("Employee fetched by salary successfully ", true, service.getEmployeeBySalary(50000, 1));
	}

	@Test
	public void testGetEmployeeBySalary_GivenSalaryMuchMoreOrLess_ShouldReturnNull() throws ParseException {
		assertEquals("No Employee Found With Given Criteria..!", false, service.getEmployeeBySalary(90000, 1));
	}

	@Test
	public void getNewJoinersByUsingFunction() {
		assertEquals("New Joiners Fetched Successfully..!", 3, service.getNewJoinersByUsingFunction().size());
	}

	@Test
	public void getEmployeeByRole() {
		assertEquals("Employee fetched by Role successfully..!", true, service.getEmployeeByRole("admin"));
	}

	@Test
	public void addEmployee() {

		assertEquals("Employee added successfully..!", true, service.addEmployee(employee));
	}

	@Test
	public void updateEmployee() throws ParseException {
		employee.setName("BBB");

		assertEquals("Employee fetched by Role successfully..!", true, service.updateEmployee(8));
	}

	@Test
	public void deleteEmployee() {
		assertEquals("Employee fetched by Role successfully..!", true, service.deleteEmployee(1));
	}

	@Test
	public void testGetListEmployees() {
		assertEquals(4, service.getAllEmployees().size());
	}
}
