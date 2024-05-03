package it.epicode.library.services;

public class IsbValidatorImpl implements IsbnValidator {

	@Override
	public boolean isValidIsbn(String code) {
		code = code.replace("-", "");
		switch (code.length()) {
		case 10:
			return checkIsbn10(code);
		case 13:
			return checkIsbn13(code);
		default:
			return false;
		}
	}

	private boolean checkIsbn13(String code) {
		if (code.length() != 13)
			return false;
		int sum = 0;
		int weight = 1;
		for (var i = 0; i < 12; ++i) {
			sum += (code.charAt(i) - '0') * weight;
			weight = weight == 1 ? 3 : 1;
		}
		var result = '0' + (10 - (sum % 10)) % 10;
		return code.charAt(12) == result;
	}

	private boolean checkIsbn10(String code) {
		if (code.length() != 10)
			return false;
		int sum = 0;
		int mult = 10;
		for (var i = 0; i < 9; ++i)
			sum += (code.charAt(i) - '0') * mult--;
		var result = 11 - (sum % 11);
		return result == 10 ? (code.charAt(9) == 'X') : code.charAt(9) == '0' + result;
	}

}
