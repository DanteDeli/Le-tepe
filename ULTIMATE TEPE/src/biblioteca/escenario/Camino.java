package biblioteca.escenario;

import entidades.Personaje;

public abstract class Camino {
	
	protected static int ubicacion;
	protected static int numero;
	protected static int opcion;
	protected static Personaje p;
	protected static int dificultad;  //Determina el nivel de los npc que puedan aparecer
	protected static boolean flag;
	
	public abstract void Avanzar(Personaje a);
	public abstract void Retroceder(Personaje a);
	
	
}
