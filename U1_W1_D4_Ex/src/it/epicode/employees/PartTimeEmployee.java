package it.epicode.employees;

public class PartTimeEmployee extends Employee {

	private int workedHours;
	private float hourlyPay;

	public PartTimeEmployee(String id, Department department, int workedHours, float hourlyPay) {
		super(id, 0f, department);
		this.workedHours = workedHours;
		this.hourlyPay = hourlyPay;
	}

	public int getWorkedHours() {
		return workedHours;
	}

	public float getHourlyPay() {
		return hourlyPay;
	}

	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}

	public void setHourlyPay(float hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	@Override
	public float getSalary() {
		return workedHours * hourlyPay;
	}

	@Override
	public String toString() {
		return String.format("PartTimeEmployee[%s, workedHours=%d, hourlyPay=%f]", super.toString(), workedHours,
				hourlyPay);
	}

}
