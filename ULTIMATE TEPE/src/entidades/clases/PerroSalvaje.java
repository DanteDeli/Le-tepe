package entidades.clases;

import entidades.Personaje;
import biblioteca.Biblioteca;


public class PerroSalvaje extends Personaje{

	private final static int vidaMax = 15;
	private final static int defensa = 15;
	private final static int recistencia = 5;
	private final static int da�oF = 20;
	private final static int da�oM = 20;
	private final static int velocidad = 40;
	private final static String clase = "PerroSalvaje";
	private final static int experienciaBase = 50;
	
	
	public PerroSalvaje() {
		super();
	}

	/**
	 * Crea una instancia de perro salvaje
	 * @param level el nivel con el que queres que se cree el perro
	 */
	public PerroSalvaje(int level)
	{
		super(vidaMax,defensa,recistencia,da�oF,da�oM,velocidad,level,clase,experienciaBase);
		setHabilidades(Biblioteca.CargarHabilidadesPerro());
	}
}
