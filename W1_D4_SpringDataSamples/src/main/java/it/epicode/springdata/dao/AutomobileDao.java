package it.epicode.springdata.dao;

import java.util.List;

import it.epicode.springdata.data.Automobile;

public interface AutomobileDao { // CRUD
	public void insert(Automobile auto); // Create

	public void update(Automobile auto); // Update

	public void delete(Integer id); // Delete

	public Automobile getById(Integer id); // Read

	public List<Automobile> getByAnnoProduzione(int annoProduzione);
}
