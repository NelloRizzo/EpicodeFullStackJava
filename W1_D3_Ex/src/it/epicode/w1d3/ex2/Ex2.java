package it.epicode.w1d3.ex2;

public class Ex2 {

	public static void execute() {
		Sim sim = new Sim("1234567");
		sim.addCall(new Call(5, "0000000"));
		sim.addCall(new Call(3, "0000001"));
		sim.addCall(new Call(7, "0000042"));
		sim.addCall(new Call(1, "0000000"));
		System.out.println(sim);
	}
}
