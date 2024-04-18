package it.epicode.ratio;

public class Ratio {
	static Ratio half = new Ratio(.5f);
	
	int signum;
	int numerator;
	int denominator;

	Ratio() {
//		signum = 1;
//		numerator = 0;
//		denominator = 1;
		this(0,1);
	}

	Ratio(int numerator, int denominator) {
		if (denominator == 0)
			denominator = 1;
		int s = numerator * denominator;
		signum = s > 0 ? 1 : -1;
		this.numerator = numerator > 0 ? numerator : -numerator;
		this.denominator = denominator > 0 ? denominator : -denominator;
		int g = gcf(this.numerator, this.denominator);
		this.numerator /= g;
		this.denominator /= g;
	}

	Ratio(float number) {
		this();
		signum = number > 0 ? 1 : -1;
		if (number < 0)
			number = -number;
		numerator = (int) (number * 1000);
		denominator = 1000;
		int gcf = this.gcf(numerator, denominator);
		numerator /= gcf;
		denominator /= gcf;
	}

	private int gcf(int a, int b) {
		if (a < b) {
			int t = a;
			a = b;
			b = t;
		}
		if (b == 0)
			return a;
		return gcf(b, a % b);
	}

	Ratio add(Ratio other) {
		int n = signum * numerator * other.denominator //
				+ other.signum * other.numerator * denominator;
		int d = denominator * other.denominator;
		return new Ratio(n, d);
	}

	String asString() {
		if (numerator == 0)
			return "0";
		String result = "";
		if (signum < 0)
			result += "-";
		result += numerator;
		if (denominator != 1)
			result += "/" + denominator;
		return result;
	}
}
