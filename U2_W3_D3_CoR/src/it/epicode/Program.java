package it.epicode;

public class Program {

	public static void main(String[] args) {
		var d3 = new Dispenser100();
		var d1 = new Dispenser50();
		var d2 = new Dispenser20();
		
		var amount = 12370L;
//		d3.setNext(d1);
//		d1.setNext(d2);
//
//		d3.handle(amount);
		d1.setNext(d3);
		d3.setNext(d2);
		d1.handle(amount);
		
		Calculator c = new Calculator();
		c.setNext(new AddOperator()).setNext(new SubOperator()).setNext(new MulOperator());
		c.executeOperation(13, 53, '*');
	}

}
