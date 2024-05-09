package it.epicode.bw1.transportcompany.entities.tickets;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class TimeSpan {
	@Column(nullable = false)
	private int duration;
	@Enumerated(EnumType.ORDINAL)
	private TimeSpanUnit unit;

	public TimeSpan(int duration, TimeSpanUnit unit) {
		this.duration = duration;
		this.unit = unit;
	}

	public TimeSpan() {
	}

	public int getDuration() {
		return duration;
	}

	public TimeSpanUnit getUnit() {
		return unit;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setUnit(TimeSpanUnit unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return String.format("TimeSpan(duration=%s, unit=%s)", duration, unit);
	}

}
