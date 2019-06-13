package biblioteca;

import entidades.Personaje;

public class CalcularStats {

	/**
	 * 
	 * @param hpBase
	 * @param hpIndividual
	 * @param nivel es el nivel del persoanje que la invoca
	 * @return
	 */
	public static int calcularHp(int hpBase,int hpIndividual,int nivel)
	{
		return (int)(((2*hpBase+hpIndividual)*nivel)/100)+nivel+10;
	}
	
	/**
	 * 
	 * @param statBase
	 * @param statIndividual
	 * @param nivel
	 * @return
	 */
	public static int calcularStat(int statBase,int statIndividual,int nivel)
	{
		return (int)(((2*statBase+statIndividual)*nivel)/100)+5;
	}
	
	/**
	 * 
	 * @param exp
	 * @return
	 */
	public static int calcularNivel(int exp)
	{
		return (int)Math.pow(exp,1.0/3.0);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int aumentarExp(Personaje a, Personaje b)
	{
		return (int)(b.getExpBase()*b.getNivel()/5*Math.pow(2*b.getNivel()+10,2.5)
				/Math.pow(b.getNivel()+a.getNivel()+10,2.5)+1);
	}
	
	/**
	 * 
	 * @param nivel
	 * @return
	 */
	public static int setearExp(int nivel)
	{
		return (int) Math.pow(nivel,3);
	}
}
