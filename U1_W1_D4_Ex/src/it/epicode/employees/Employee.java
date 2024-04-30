package it.epicode.employees;

import java.util.Objects;

public abstract class Employee implements CheckableIn {
	private String id;
	private float salary;
	private Department department;

	public String getId() {
		return id;
	}

	public float getSalary() {
		return salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void checkIn() {
		System.out.println(this + " ha iniziato il suo turno di lavoro");
	}

	/**
	 * Costruttore.
	 * 
	 * @param id         la matricola del dipendente.
	 * @param salary     il salario del dipendente.
	 * @param department il dipartimento del dipendente.
	 */
	public Employee(String id, float salary, Department department) {
		this.id = id;
		this.salary = salary;
		this.department = department;
	}

	/**
	 * Rappresentazione sotto forma di stringa.
	 */
	@Override
	public String toString() {
		return String.format("Employee[id=%s, salary=%s, department=%s]", id, salary, department);
	}

	/**
	 * Metodo comune a tutti gli Object. Serve per associare un numero intero
	 * univoco ad una istanza di classe. Non esistono regole per l'algoritmo da
	 * implementare, l'unica specifica è che istanze considerate uguali devono
	 * restituire lo stesso hashCode.
	 */
	@Override
	public int hashCode() {
		// Objects.hash è una funzione di sistema che crea un intero che possa
		// rappresentare il codice hash costruito a partire da una
		// serie di parametri
		return Objects.hash(id);
	}

	/**
	 * Confronta due istanze di Employee.
	 */
	@Override
	public boolean equals(Object obj) {
		// controlla che obj sia Employee e nel caso che sia così confronta i due
		// hashCode.
		return (obj instanceof Employee) && obj.hashCode() == this.hashCode();
	}
}
