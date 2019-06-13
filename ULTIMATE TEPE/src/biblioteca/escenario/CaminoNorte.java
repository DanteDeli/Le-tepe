package biblioteca.escenario;

import java.util.Random;
import java.util.Scanner;

import entidades.Personaje;
import biblioteca.Biblioteca;
import entidades.clases.PerroSalvaje;
import biblioteca.Dado;
import manager.InteraccionUsuario;
import combate.MetodosCombate;

public class CaminoNorte extends Camino{


	
	public CaminoNorte()
	{
		dificultad = 2;
		ubicacion = 0;
	}
	
	public void Avanzar (Personaje a)
	{
		if(ubicacion<5)
		{
			flag = true;
			ubicacion++;
			InteraccionUsuario.AvanzasElCamino();
			numero = Dado.tirarDado(100);
			if(0 <20)
			{
				p = new PerroSalvaje(Dado.tirarDado(dificultad));
				while(flag == true)
				{
					opcion = InteraccionUsuario.Encounter(p.getClase());
					if(opcion == 1)
					{
						p.mostrarStatsPersonaje();
						InteraccionUsuario.MostrarHabilidades(p);
						MetodosCombate.Combate(a,p);
						flag = false;
					}
					else if(opcion == 2)
					{
						numero = Dado.tirarDado(50);
						if(numero<20)
						{
							InteraccionUsuario.NoPuedesEscapar();
							MetodosCombate.Combate(a, p);
							flag = false;
						}	
						else
						{
							InteraccionUsuario.LograsEscapar();
							flag = false;
						}
					}
					else
					{
						InteraccionUsuario.OpcionInvalida();
					}
				}
			}
		}
		else if(ubicacion>=5)
		{
			while(!flag)
			{
			opcion = InteraccionUsuario.FinalCamino(Biblioteca.Mapa_PuebloSegundo());
			switch(opcion)
			{
			case 1:
				a.setUbicacion(Biblioteca.Mapa_PuebloSegundo());
				flag = true;
			break;
			case 2:
				this.Retroceder(a);
				flag = true;
			break;
			default:
				InteraccionUsuario.OpcionInvalida();
			break;
			}
			}
		}
	}
	
	public void Retroceder(Personaje a)
	{
		if(ubicacion == 0)
		{
			opcion = InteraccionUsuario.FinalCamino(Biblioteca.Mapa_PuebloInicio());
			switch(opcion)
			{
			case 1:
				a.setUbicacion(Biblioteca.Mapa_PuebloInicio());
			}
		}
		else if(ubicacion > 0)
		{
			flag = true;
			ubicacion--;
			InteraccionUsuario.RetrocedesElCamino();
			numero = Dado.tirarDado(100);
			if(numero <20)
			{
				p = new PerroSalvaje(Dado.tirarDado(dificultad));
				while(flag == true)
				{
					opcion = InteraccionUsuario.Encounter(p.getClase());
					if(opcion == 1)
					{
						MetodosCombate.Combate(a,p);
						flag = false;
					}
					else if(opcion == 2)
					{
						numero = Dado.tirarDado(50);
						if(numero<20)
						{
							InteraccionUsuario.NoPuedesEscapar();
							MetodosCombate.Combate(a, p);
							flag = false;
						}	
						else
						{
							InteraccionUsuario.LograsEscapar();
							flag = false;
						}
					}
					else
					{
						InteraccionUsuario.OpcionInvalida();
					}
				}
			}
		}
	}	
}
