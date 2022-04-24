package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio0102;

public class PruebaFecha {
	public static void main(String[] args) {
		Fecha f1 = new Fecha(1,1,2020);
		Fecha f2 = new Fecha(1,7,2020);
		System.out.println(f1.fechaCorrecta());
		System.out.println(f2.fechaCorrecta());
		System.out.println(f1.esMayorQue(f2));
		System.out.println(f2.esMayorQue(f1));
		//int a = f2.getAnio();
		
		System.out.println(f1);
		System.out.println(f2);
		
		
		Fecha fNac = new Fecha(1,1,2010);
		Persona p = new Persona("Nombre", "", "", "", fNac);
		System.out.println(p.getFechaNacimiento());
		fNac.diaSiguiente();
		System.out.println(p.getFechaNacimiento());
		Fecha fNac2 = p.getFechaNacimiento();
		fNac2.diaSiguiente();
		System.out.println(p.getFechaNacimiento());
		
		Fecha fNac3 = new Fecha(10,10,1995);
		p.setFechaNacimiento(fNac3);
		System.out.println(p.getFechaNacimiento());
		fNac3.setAnio(2000);
		System.out.println(p.getFechaNacimiento());
		
		
		// Prueba del método diaSiguiente
		Fecha fDiaSiguiente = new Fecha (20, 2, 2024);
		for (int i = 0; i < 100; i++)
		{
			System.out.println(fDiaSiguiente);
			fDiaSiguiente.diaSiguiente();
		}
		
		
		
	}
	
	

}
