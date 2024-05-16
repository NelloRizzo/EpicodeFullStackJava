package it.epicode.springdata.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import it.epicode.springdata.data.Automobile;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JdbcAutomobileDao implements AutomobileDao {

	@Autowired
	private JdbcTemplate jdbc;

	private static final String INSERT = //
			"INSERT INTO automobili(id, targa, marca, annoproduzione, colore) VALUES(?, ?, ?, ?, ?);";
	private static final String UPDATE = //
			"UPDATE automobili SET targa = ?, marca = ?, annoproduzione = ?, colore = ? WHERE id = ?";
	private static final String DELETE = "DELETE FROM automobili WHERE id = ?";
	private static final String SELECT_BY_ID = //
			"SELECT id, targa, marca, annoproduzione, colore FROM automobili WHERE id = ?";
	private static final String SELECT_BY_ANNO = //
			"SELECT id, targa, marca, annoproduzione, colore FROM automobili WHERE annoproduzione = ?";

	public static class AutomobileRowMapper implements RowMapper<Automobile> {

		@Override
		public Automobile mapRow(ResultSet rs, int rowNum) throws SQLException {
			log.info("Mapping row with id = {} and index = {}", rs.getInt("id"), rowNum);
			return Automobile.builder() //
					.withAnnoProduzione(rs.getInt("annoproduzione")) //
					.withColore(rs.getString("colore")) //
					.withId(rs.getInt("id")) //
					.withMarca(rs.getString("marca")) //
					.withTarga(rs.getString("targa")) //
					.build();
		}

	}

	@Override
	public void insert(Automobile auto) {
		jdbc.update(INSERT, auto.getId(), auto.getTarga(), auto.getMarca(), auto.getAnnoProduzione(), auto.getColore());
	}

	@Override
	public void update(Automobile auto) {
		jdbc.update(UPDATE, auto.getTarga(), auto.getMarca(), auto.getAnnoProduzione(), auto.getColore(), auto.getId());
	}

	@Override
	public void delete(Integer id) {
		jdbc.update(DELETE, id);
	}

	@Override
	public Automobile getById(Integer id) {
		return jdbc.queryForObject(SELECT_BY_ID, new AutomobileRowMapper(), id);
	}

	@Override
	public List<Automobile> getByAnnoProduzione(int annoProduzione) {
		return jdbc.query(SELECT_BY_ANNO, new AutomobileRowMapper(), annoProduzione);
	}

}
