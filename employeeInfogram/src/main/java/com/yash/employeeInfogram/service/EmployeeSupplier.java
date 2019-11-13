package com.yash.employeeInfogram.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.yash.employeeInfogram.model.Employee;

public interface EmployeeSupplier {

	Supplier<List<Employee>> supplier = () -> {
		Employee e1 = new Employee(01, "Kazim", "syedkazim@gmail.com", "8308771980", 55000,
				LocalDate.of(2019, Month.OCTOBER, 10), "Admin");
		Employee e2 = new Employee(02, "Vinit", "Vinit@gmail.com", "111111111", 60000,
				LocalDate.of(2019, Month.OCTOBER, 10), "consumer");
		Employee e3 = new Employee(03, "Ram", "Ram@gmail.com", "8888888888", 45000,
				LocalDate.of(2019, Month.JANUARY, 20), "consumer");
		Employee e4 = new Employee(04, "Aniket", "Aniket@gmail.com", "7894561236", 35000,
				LocalDate.of(2019, Month.OCTOBER, 20), "consumer");
		Employee e5 = new Employee(05, "Rahul", "Rahul@gmail.com", "66666666666", 85000,
				LocalDate.of(2019, Month.JANUARY, 17), "consumer");
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);

		return list;

	};
	
}
