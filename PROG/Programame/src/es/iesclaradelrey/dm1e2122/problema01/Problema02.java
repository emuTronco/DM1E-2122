package es.iesclaradelrey.dm1e2122.problema01;

import java.io.IOException;

public class Problema02 {

	public static void main(String[] args) throws IOException {
		char c = (char) System.in.read();
		while (c != '.') {
			int numVerano = 0;
			int numInvierno = 0;
			while (c != '.') {
				if (c == 'V')
					numVerano++;
				if (c == 'I')
					numInvierno++;
				c = (char) System.in.read();
			}

			if (numVerano > numInvierno) {
				System.out.println("VERANO");
			} else if (numVerano < numInvierno) {
				System.out.println("INVIERNO");
			} else {
				System.out.println("EMPATE");
			}
			System.in.skip(1); // Saltamos el salto de línea.
			c = (char) System.in.read();
		}
	}
}
