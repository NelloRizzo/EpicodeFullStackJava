package it.epicode;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class SitoWeb extends Recapito {
	private String url;

	public SitoWeb(boolean lavoro, String url) {
		super(lavoro);
		this.url = url;
	}

	public SitoWeb() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return String.format("SitoWeb[url=%s, id=%s, lavoro=%s]", url, getId(), isLavoro());
	}
}
