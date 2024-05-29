package it.epicode.es1;

public class UserData {
	private String nomeCompleto;
	private int eta;

	public void getData(DataSource ds) {
		nomeCompleto = ds.getNomeCompleto();
		eta = ds.getEta();
	}

	@Override
	public String toString() {
		return String.format("UserData [nomeCompleto=%s, eta=%s]", nomeCompleto, eta);
	}
}
