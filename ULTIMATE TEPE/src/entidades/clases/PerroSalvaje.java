package entidades.clases;

import entidades.Personaje;
import biblioteca.Biblioteca;


public class PerroSalvaje extends Personaje{

	private final static int vidaMax = 15;
	private final static int defensa = 15;
	private final static int recistencia = 5;
	private final static int dañoF = 20;
	private final static int dañoM = 20;
	private final static int velocidad = 40;
	private final static String clase = "PerroSalvaje";
	private final static int experienciaBase = 50;
	
	
	public PerroSalvaje() {
		super();
	}

	public PerroSalvaje(int level)
	{
		super(vidaMax,defensa,recistencia,dañoF,dañoM,velocidad,level,clase,experienciaBase);
		setHabilidades(Biblioteca.CargarHabilidadesPerro());
	}
}
