package biblioteca.escenario;

import entidades.Personaje;
import manager.InteraccionUsuario;

public abstract class Pueblo {

	public void Posada(Personaje a)
	{
		if(a.getVidaActual()==a.getVidaMax())
		{
			InteraccionUsuario.YaEstasDescansado();
		}
		else
		{
			a.RecuperarSalud();
			InteraccionUsuario.TeRecuperastePleno();
		}
		
	}
	
	public abstract void Avanzar(Personaje p);
	public abstract void Retroceder(Personaje p);
}
