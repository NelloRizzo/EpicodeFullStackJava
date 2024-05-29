package it.epicode.es1;

import java.time.LocalDate;

public class InfoAdapter implements DataSource {

	private Info info;

	public InfoAdapter(Info info) {
		this.info = info;
	}

	@Override
	public String getNomeCompleto() {
		return info.getNome() + " " + info.getCognome();
	}

	@Override
	public int getEta() {
		return LocalDate.now().getYear() - info.getDataDiNascita().getYear();
	}

}
