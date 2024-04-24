package it.epicode;

//public class DecidiSeScambiareAsc extends DecidiSeScambiare{
public class DecidiSeScambiareAsc implements DecidiSeScambiare {
	@Override
	public boolean decidiSeScambiare(int a, int b) {
		return a > b;
	}
}
