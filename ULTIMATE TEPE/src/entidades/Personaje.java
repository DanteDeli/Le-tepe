package entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import biblioteca.Dado;
import manager.InteraccionUsuario;

import org.json.JSONException;
import org.json.JSONObject;
import biblioteca.CalcularStats;

public class Personaje {

	
	//Estas variables representan las estad�sticas individuales que pueden tener los personajes.
	//Son numeros al azar entre 1 y 31 y sirven, en conjunto con las estad�sticas base de la clase,
	//para calcular las estad�sticas finales del personaje tanto cuando es creado como cuando sube 
	//de nivel.
	
	private HashMap<String,Integer> statsI;
	
	
	//Son las estad�sticas finales y visibles que posee un personaje una vez se lo calcula en
	//referencia a las estad�sticas individuales (del personaje) y base (de la clase).
	private LinkedHashMap<String,Integer> stats;
	
	//Las claves utilizadas en los HashMap
	private final String vidaActual = "Vida actual";
	private final String vidaMax = "Vida max";
	private final String resistenciaF = "Resistencia f";
	private final String resistenciaM = "Resistencia m";
	private final String da�oF = "Da�o f";
	private final String da�oM = "Da�o m";
	private final String velocidad = "Velocidad";
	private final String exp = "Exp";
	private final String nivel = "Nivel";
	
	
	
	
	private ArrayList<Habilidad> habilidades;
	
	private boolean conVida;
	
	private String ubicacion;
	
	private int expBase;
	
	private String clase;
	/*
	private int vidaActual;
	private int vidaMax;
	private int defensa;
	private int recistencia;
	private int da�oF;
	private int da�oM;
	private int exp;
	private int level;
	*/
	
	public String getClase() 
	{
		return clase;
	}

	
	
	public Personaje()
	{
		statsI = new HashMap<>();
		stats = new LinkedHashMap<>();
		habilidades = new ArrayList<Habilidad>();
	}
	
	
	public Personaje(Integer vidaMax, Integer defensa, Integer resistenciaM, Integer da�oF, Integer da�oM,
			Integer velocidad, Integer level, String clase, Integer ExpBase) {
		
		statsI = new HashMap<>();
		statsI.put(this.vidaMax,Dado.tirarDado(31));
		statsI.put(this.resistenciaF,Dado.tirarDado(31));
		statsI.put(this.resistenciaM,Dado.tirarDado(31));
		statsI.put(this.da�oF,Dado.tirarDado(31));
		statsI.put(this.da�oM,Dado.tirarDado(31));
		statsI.put(this.velocidad,Dado.tirarDado(31));
		
		this.clase = clase;
		
		stats = new LinkedHashMap<>();
		
		
		stats.put(this.vidaMax,CalcularStats.calcularHp(vidaMax,statsI.get(this.vidaMax),level));
		stats.put(this.vidaActual,stats.get(this.vidaMax));
		stats.put(this.da�oF,CalcularStats.calcularStat(da�oF,statsI.get(this.da�oF),level));
		stats.put(this.da�oM,CalcularStats.calcularStat(da�oM,statsI.get(this.da�oM),level));
		stats.put(this.resistenciaF,CalcularStats.calcularStat(defensa,statsI.get(this.resistenciaF),level));
		stats.put(this.resistenciaM,CalcularStats.calcularStat(resistenciaM,statsI.get(this.resistenciaM),level));
		stats.put(this.velocidad,CalcularStats.calcularStat(velocidad,statsI.get(this.velocidad),level));
		stats.put(this.exp,CalcularStats.setearExp(level));
		stats.put(this.nivel,level);
		
		habilidades = new ArrayList<Habilidad>();
		conVida = true;
		
	}
	
	public void RecuperarSalud()
	{
		setVidaActual(getVidaMax());
	}

	public void Muerte() // iiiiaaaaaaaooooo
	{
		conVida = false;
	}
	
	public boolean conVida()
	{
		return conVida;
	}
	
	public void mostrarStatsPersonaje()
	{
		InteraccionUsuario.MostrarStatsPersonaje(stats);
	}
	
	public void mostrarVida()
	{
		InteraccionUsuario.MostrarVida(getVidaMax(),getVidaActual());
	}
	
	public void QuitarVida(int resta)
	{
		int vida = stats.get(vidaActual);
		vida -= resta;
		stats.put(vidaActual,vida);
	}
	protected void setHabilidades(ArrayList<Habilidad> h)
	{
		habilidades = h;
	}
	public void mostrarHabilidades()
	{
		InteraccionUsuario.MostrarHabilidades(this);
	}
	public int getResistenciaM()
	{
		return stats.get(resistenciaM);
	}
	public int getVelocidad(){
		return stats.get(velocidad);
	}
	public int getVidaActual() {
		return stats.get(vidaActual);
	}
	public int getVidaMax() {
		return stats.get(vidaMax);
	}
	public int getResistenciaF() {
		return stats.get(resistenciaF);
	}
	public int getDa�oF() {
		return stats.get(da�oF);
	}
	public int getDa�oM() {
		return stats.get(da�oM);
	}
	public int getExp() {
		return stats.get(exp);
	}
	public int getNivel() {
		return stats.get(nivel);
	}
	public Habilidad getHabilidad(int index)
	{
		return habilidades.get(index);
	}
	public ArrayList<Habilidad> getHabilidades()
	{
		return habilidades;
	}
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public int getExpBase() {
		return expBase;
	}

	public void setExpBase(int expBase) {
		this.expBase = expBase;
	}

	public void setVidaActual(int vida) {
		stats.put(vidaActual,vida);
	}

	public void setVidaMax(int vidaMax) {
		stats.put(this.vidaMax,vidaMax);
	}

	public void setResistenciaF(int defensa) {
		stats.put(this.resistenciaF,defensa);
	}

	public void setResistenciaM(int recistenciaM) {
		stats.put(this.resistenciaM,recistenciaM);
	}

	public void setDa�oF(int da�oF) {
		stats.put(this.da�oF,da�oF);
	}

	public void setDa�oM(int da�oM) {
		stats.put(this.da�oM,da�oM);
	}

	public void setExp(int exp) {
		stats.put(this.exp,stats.get(this.exp) + exp);
	}

	public void setNivel(int level) {
		stats.put(this.nivel,level);
	}

	public void setVelocidad(int velocidad) {
		stats.put(this.velocidad,velocidad);
	}

	
	public String getVidaActualString()
	{
		return this.vidaActual;
	}
	public String getVidaMaxString()
	{
		return this.vidaMax;
	}
	public String getResistenciaFString()
	{
		return this.resistenciaF;
	}
	public String getResistenciaMString()
	{
		return this.resistenciaM;
	}
	public String getDa�oFString()
	{
		return this.da�oF;
	}
	public String getDa�oMString()
	{
		return this.da�oM;
	}
	public String getVelocidadString()
	{
		return this.velocidad;
	}
	public String getExpString()
	{
		return this.exp;
	}
	public String getNivelString()
	{
		return this.nivel;
	}
	public LinkedHashMap<String,Integer> getStatsMap()
	{
		return stats;
	}
	public JSONObject getFormatoJSON() throws JSONException
	{
		JSONObject a = new JSONObject();
		a.put("Stats",stats);
		a.put("StatsI",statsI);
		a.put("Habilidades",habilidades);
		a.put("Con Vida",conVida);
		a.put("Ubicacion",ubicacion);
		return a;
	}
	
	
}
