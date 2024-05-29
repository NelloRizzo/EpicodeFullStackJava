package it.epicode;

public class Dispenser100 implements Handler<Long> {

	private Handler<Long> next = null;

	@Override
	public void setNext(Handler<Long> h) {
		this.next = h;
	}

	@Override
	public void handle(Long data) {
		if (data >= 100) { // distribuisce le banconote da 100 euro
			long total = data / 100;
			System.out.format("Distribuisco %s banconote da 100\n", total);
			data -= 100 * total;
		}
		if (next != null) { // se esiste un gestore successivo nella catena
			next.handle(data);
		}
	}

}
