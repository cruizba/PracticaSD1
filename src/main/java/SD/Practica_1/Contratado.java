package SD.Practica_1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Contratado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idContratado;
	
	private String nombre;
	private String apellidos;
	private String telFijo;
	private String telMovil;
	private String tipo;
	
	public Contratado(){
		
	}
	
	public Contratado(String nombre, String apellidos, String telFijo, String telMovil, String tipo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telFijo = telFijo;
		this.telMovil = telMovil;
		this.tipo = tipo;
	}
	
	
	public int getIdContratado() {
		return idContratado;
	}


	public void setIdContratado(int idContratado) {
		this.idContratado = idContratado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getTelFijo() {
		return telFijo;
	}


	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}


	public String getTelMovil() {
		return telMovil;
	}


	public void setTelMovil(String telMovil) {
		this.telMovil = telMovil;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString(){
		return String.format("Contratado[nombre='%s', apellido='%s', Telefono Fijo='%s', Movil ='%s', Tipo='%s']", nombre, apellidos, telFijo, telMovil, tipo);
	}
	
}
