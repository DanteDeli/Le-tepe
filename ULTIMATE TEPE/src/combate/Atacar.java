package combate;

import entidades.Habilidad;

public class Atacar {

		
	public static int CalcularDaño(Habilidad h, int dañoF, int dañoM, int lvl, int def, int res)  
	{
		if(h.getTipoDaño().equals("F"))
		{
			return (int)(((2*lvl/5+2)*h.getPotencia()*dañoF/ def )/50)+2;
		}
		else
		{
			return (int)(((2*lvl/5+2)*h.getPotencia()*dañoM/ res )/50)+2;
		}
	}
	
	
}
