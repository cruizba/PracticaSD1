package SD.Practica_1;

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
@Table(name="Area")
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idArea;
	
	private String nombreArea;
	private String extension;
	
	@ManyToMany(mappedBy="areas", fetch=FetchType.EAGER)
	List<Especie> especies = new ArrayList<Especie>();
	
	public Area(){
		
	}
	
	public Area(String nombreArea, String extension){
		this.nombreArea = nombreArea;
		this.extension = extension;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public List<Especie> getEspecies() {
		return especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}

	public String toString(){
		return String.format("Area[nombre='%s', extension='%s']", nombreArea, extension);
	}

	
	

}
