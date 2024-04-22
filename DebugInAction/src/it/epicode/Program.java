package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program {
	
	private static final Logger logger = LoggerFactory.getLogger(Program.class);

	public static void stampaTabellina(int n) {
		for(int i=1; i < 11; ++i) {
			int t = n * i;
//			System.out.format("%d x %d = %d\n", i, n, t);
			logger.trace("{} x {} = {}\n", i, n, t);
			logger.debug("{} x {} = {}\n", i, n, t);
			logger.info("{} x {} = {}\n", i, n, t);
			logger.warn("{} x {} = {}\n", i, n, t);
			logger.error("{} x {} = {}\n", i, n, t);
		}
	}
	
	public static void main(String[] args) {
		stampaTabellina(6);

	}

}
