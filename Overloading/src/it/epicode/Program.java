package it.epicode;

public class Program {

	// sum(float,int)
	public static float sum(float number, int times) {
		float result = 0;
		for (int i = 0; i < times; ++i) {
			result += number;
		}
		return result;
	}

	// overloading -> firma (signature) -> sum(float,float,float)
	public static float sum(float number1, float number2, float number3) {
		return number1 + number2 + number3;
	}

	public static float sum(float n, float f) {
		return n + f;
	}

	public static void main(String[] args) {
		float x = sum(10, 5f);
		System.out.println("sum(10, 5) = " + x);
		float y = sum(10, 20, 30);
		System.out.println("sum(10, 20, 30) = " + y);

		Addition add = new Addition();
		System.out.println("Addition.add = " + add.add(10, 20));
		Addition spec = new SpecialAddition();
		System.out.println("SpecialAddition.add = " + spec.add(10, 20));
//		int[] n = { 432, 465, 4756, 847, 234, 847 };
//		System.out.println("SpecialAddition.add(int[]) = " + spec.add(n));
	}

}
