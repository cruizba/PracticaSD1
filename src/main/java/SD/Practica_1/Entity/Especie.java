package SD.Practica_1.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Especie")
public class Especie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEspecie;
	private String nombreComun;
	private String nombreCientifico;
	private String tipo;
	private String imageUrl;
	
	@ManyToMany(fetch=FetchType.EAGER)
	List<Area> areas = new ArrayList<Area>();
	
	//public Especie(){
		
	//}
	
	public Especie(String nombreCientifico, String nombreComun, String tipo, String imageUrl){
		this.nombreCientifico = nombreCientifico;
		this.nombreComun = nombreComun;
		this.tipo = tipo;
		this.imageUrl = imageUrl;
	}

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String toString(){
		return String.format("Especie[nombreComun='%s', nombreCientifico='%s', Tipo='%s']", nombreComun, nombreCientifico, tipo);
	}




}
