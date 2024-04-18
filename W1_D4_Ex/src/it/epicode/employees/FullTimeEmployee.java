package it.epicode.employees;

public class FullTimeEmployee extends Employee {

	public FullTimeEmployee(String id, float salary, Department department) {
		super(id, salary, department);
	}

	@Override
	public String toString() {
		return String.format("FullTimeEmployee[%s]", super.toString());
	}

}
