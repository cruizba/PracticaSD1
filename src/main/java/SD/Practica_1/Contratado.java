package SD.Practica_1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contratado")
public class Contratado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_contratado")
	private int id;
	
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="apellidos", nullable=false)
	private String apellidos;
	
	@Column(name="tel_fijo", nullable=false)
	private String fijo;
	
	@Column(name="tel_movil", nullable=false)
	private String telMovil;
	
	@Column(name="tipo", nullable=false)
	private String tipo;

	public Contratado(){
		//Used by SpringData
	}
	
	public Contratado(String nombre, String apellidos, String telFijo, String telMovil, String tipo){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fijo = telFijo;
		this.telMovil = telMovil;
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFijo() {
		return fijo;
	}

	public void setFijo(String fijo) {
		this.fijo = fijo;
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
		return String.format("Contratado[nombre='%s', apellido='%s', Telefono Fijo='%s', Movil ='%s', Tipo='%s']", nombre, apellidos, fijo, telMovil, tipo);
	}
	
}
