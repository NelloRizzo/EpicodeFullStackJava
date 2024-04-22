package it.epicode;

public class Program {
    public static void stampaTabellina(int n) {
        for (int i = 1; i < 11; ++i) {
            int t = n * i;
            System.out.format("%d x %d = %d\n", i, n, t);
        }
    }

    public static void main(String[] args) {
        stampaTabellina(6);

    }

}
