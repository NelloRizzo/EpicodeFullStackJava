package it.epicode;

public abstract class BookItem {

	final void print() {
		print(0);
	}

	protected abstract int getPages();
	protected abstract void print(int indent);
}
