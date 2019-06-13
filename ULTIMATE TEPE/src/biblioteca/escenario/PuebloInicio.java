package biblioteca.escenario;
import manager.InteraccionUsuario;
import biblioteca.Biblioteca;
import entidades.Personaje;


public class PuebloInicio extends Pueblo{
	
	@Override
	public void Avanzar(Personaje p) {
		p.setUbicacion(Biblioteca.Mapa_CaminoNorte());
	}

	@Override
	public void Retroceder(Personaje p) 
	{
		
	}
	
	
}
