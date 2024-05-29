package it.epicode;

public class Dispenser50 implements Handler<Long> {

	private Handler<Long> next = null;

	@Override
	public void setNext(Handler<Long> h) {
		this.next = h;
	}

	@Override
	public void handle(Long data) {
		if (data >= 50) { // distribuisce le banconote da 50 euro
			long total = data / 50;
			System.out.format("Distribuisco %s banconote da 50\n", total);
			data -= 50 * total;
		}
		if (next != null) { // se esiste un gestore successivo nella catena
			next.handle(data);
		}
	}

}
