package biblioteca;

import entidades.Personaje;

public class CalcularStats {

	
	public static int calcularHp(int hpBase,int hpIndividual,int nivel)
	{
		return (int)(((2*hpBase+hpIndividual)*nivel)/100)+nivel+10;
	}
	
	public static int calcularStat(int statBase,int statIndividual,int nivel)
	{
		return (int)(((2*statBase+statIndividual)*nivel)/100)+5;
	}
	
	public static int calcularNivel(int exp)
	{
		return (int)Math.pow(exp,1.0/3.0);
	}
	
	public static int aumentarExp(Personaje a, Personaje b)
	{
		return (int)(b.getExpBase()*b.getNivel()/5*Math.pow(2*b.getNivel()+10,2.5)
				/Math.pow(b.getNivel()+a.getNivel()+10,2.5)+1);
	}
	
	public static int setearExp(int nivel)
	{
		return (int) Math.pow(nivel,3);
	}
}
