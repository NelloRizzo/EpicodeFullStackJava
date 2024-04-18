package it.epicode;

import it.epicode.employees.CheckableIn;
import it.epicode.employees.Department;
import it.epicode.employees.Employee;
import it.epicode.employees.FullTimeEmployee;
import it.epicode.employees.PartTimeEmployee;
import it.epicode.employees.Volunteer;

public class Program {

	public static void checkIn(CheckableIn c) {
		c.checkIn();
	}

	public static void handleEmployees(Employee[] employees) {
		float total = 0;
		for (int i = 0; i < employees.length; ++i) {
			Employee e = employees[i];
			System.out.format("%s\t%f\n", e, e.getSalary());
			total += e.getSalary();
		}
		System.out.println("Totale stipendi: " + total);
	}

	public static void main(String[] args) {
		handleEmployees(new Employee[] { //
				new FullTimeEmployee("0001", 1000, Department.Administration),
				new PartTimeEmployee("0002", Department.Sales, 30, 100),
				new FullTimeEmployee("0003", 1500, Department.Production),
				new PartTimeEmployee("0004", Department.Production, 21, 70), });
		checkIn(new FullTimeEmployee("0001", 1000, Department.Administration));
		checkIn(new Volunteer("Archimede", 35, "Il più grande matematico della storia di Paperopoli"));
	}

}
