package es.iesclaradelrey.dm1e2122.programame.serie02;


import java.util.Scanner;

public class P462MundoLimpio {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());
		while (numCasos > 0) {
			int numLimpiezas = sc.nextInt();
			LocalTime tiempo = LocalTime.parse(sc.nextLine().trim(), DateTimeFormatter.ofPattern("H:m:s"));
			long numSegundos = tiempo.toSecondOfDay() * numLimpiezas;
			Duration d = Duration.ofSeconds(numSegundos);
			System.out.printf("%d %02d:%02d:%02d", d.toDays(), d.toHoursPart(), d.toMinutesPart(), d.toSecondsPart());
			numCasos--;
		}
	}
}
