package it.epicode;

public class SpecialAddition extends Addition {

	// overriding -> sovrascrittura del metodo della classe base
	@Override
	public int add(int a, int b) {
//		return add(new int[] { a, b, 10 });
		int s = super.add(a, b);
		return s + 10;
	}

//	public int add(int a) {
//		return a * a;
//	}

	// overloadind di add di Addition
	public int add(int[] a) {
		int result = 0;
		for (int i = 0; i < a.length; ++i) {
			result += a[i];
		}
		return result;
	}
}
