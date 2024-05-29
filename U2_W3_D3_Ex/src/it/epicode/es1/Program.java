package it.epicode.es1;

import java.time.LocalDate;

public class Program {

	public static void main(String[] args) {
		var ud = new UserData();
		
		var info = new Info("Paperon", "De' Paperoni", LocalDate.of(1970, 1, 1));
		
		ud.getData(new InfoAdapter(info));
		
		System.out.println(ud);
	}

}
