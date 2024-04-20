package it.epicode.media;

public class Control {

	private final Character symbol;
	private final int min;
	private final int max;
	private int value;

	public Control(int min, int max, int current, char symbol) {
		this.min = min;
		this.max = max;
		this.value = current;
		this.symbol = symbol;
	}

	public int getValue() {
		return value;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public void up() {
		if (value < max)
			++value;
	}

	public void down() {
		if (value > min)
			--value;
	}

	@Override
	public String toString() {
		return symbol.toString().repeat(value);
	}
}
