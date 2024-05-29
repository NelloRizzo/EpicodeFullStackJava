package it.epicode;

public class Dispenser20 implements Handler<Long>{


	private Handler<Long> next = null;

	@Override
	public void setNext(Handler<Long> h) {
		this.next = h;
	}

	@Override
	public void handle(Long data) {
		if (data >= 20) { // distribuisce le banconote da 20 euro
			long total = data / 20;
			System.out.format("Distribuisco %s banconote da 20\n", total);
			data -= 20 * total;
		}
		if (next != null) { // se esiste un gestore successivo nella catena
			next.handle(data);
		}
	}
}
