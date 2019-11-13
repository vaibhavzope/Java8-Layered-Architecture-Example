package com.yash.employeeInfogram.client;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

import com.yash.employeeInfogram.model.Employee;
import com.yash.employeeInfogram.serviceImpl.EmpServiceImpl;

public class EmployeeClient {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
	

		EmpServiceImpl service = new EmpServiceImpl();
	

		while (true) {
			System.out.println("\n================================ Choose Options ====================================");
			System.out.println("\n 1. Get Employee by Id\n " + "2. Get All Employees\n "
					+ "3. Get Employee by Name\n" + " 4. Get Employee By Salary\n " + "5. Get new joiners\n 6. Get Employee by Role");
			System.out.println("\n 7. Add Employee \n " + "8. Update Employee\n "
					+ "9. Delete Employee\n" );
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("Enter Employee Id::");
				int id = sc.nextInt();
		        service.getEmployeeById(id);

				break;
			case 2:
				
				service.getAllEmployees();

				break;
			case 3:
				System.out.println("Enter Employee Name::");
				String name = sc.next();
				service.getEmployeeByName(name);

				break;
			case 4:
				System.out.println("Please Choose Options");
				System.out.println(" 1.Salary Greater Than  2.Salary Less Than ");
				int j = sc.nextInt();
					System.out.println("Enter salary");
					double s = sc.nextDouble();
					service.getEmployeeBySalary(s,j);
			case 5:
				service.getNewJoinersByUsingFunction().forEach(System.out::println);;
				
				break;
			case 6:

				System.out.println("Enter Role");
				String role=sc.next();
				service.getEmployeeByRole(role);
				break;
				
			case 7:

				System.out.println("Enter Employee id");
				int empid=sc.nextInt();
				System.out.println("Enter Employee Name");
				String empName=sc.next();
				System.out.println("Enter Employee Email");
				String mail=sc.next();
				System.out.println("Enter Employee mobile number");
				String mobile=sc.next();
				System.out.println("Enter Employee salary");
				double salary=sc.nextDouble();
				System.out.println("Enter Employee role");
				String emprole=sc.next();
				Employee emp=new Employee();
				emp.setId(empid);
				emp.setName(empName);
				emp.setEmail(mail);
				emp.setMobile(mobile);
				emp.setSalary(salary);
				emp.setJoiningDate(LocalDate.now());
				emp.setRole(emprole);
				service.addEmployee(emp);
				
				break;
				
			case 8:
				System.out.println("Enter Employee id to update");
				int id1=sc.nextInt();
				service.updateEmployee(id1);
				break;
				
			case 9:
				System.out.println("Enter Employee id to delete");
				int id2=sc.nextInt();
				service.deleteEmployee(id2);
				break;
			default:
				break;
			}
		}

	}
	
}
