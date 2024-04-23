package it.epicode;

public class Pair<F, S> {
	public F first;
	public S second;

	public Pair(F first, S second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return String.format("Pair [first=%s (%s), second=%s]", first, first.getClass(), second);
	}

}
