package com.exercise35frases.fmmvc.model;

//import java.util.Date;
import java.sql.Date;

public class Persona {
	private int id_Persona;
	private String nombre;
	private byte edad;
	private String carrera;
	private Date fecha;
	
	public Persona() {
	}
	
	public Persona(int id_Persona,String nombre,byte edad, String carrera, Date fecha) {
		this.id_Persona = id_Persona;
		this.nombre = nombre;
		this.edad = edad;
		this.carrera = carrera;
		this.fecha = fecha;
	}
	
	public int getId_Persona() {
		return id_Persona;
	}
	
	public void setId_Persona(int id_Persona) {
		this.id_Persona = id_Persona;
	}
	
	public String getName() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public byte getEdad() {
		return edad;
	}
	
	public void setEdad(byte i) {
		this.edad = i;
	}
	
	public String getCarrera() {
		return carrera;
	}
	
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String toString()
	{
		return String.format("'%s', %d, '%s'", nombre, edad, carrera);
	}
}
