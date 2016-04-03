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

import SD.Practica_1.repository.EspecieRepository;

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
	
	public List<Especie> especiesNoEnArea(EspecieRepository espRep){
		
		List<Especie> todasEspecies = espRep.findAll();
		List<Especie> especiesArea = this.getEspecies();
		List<Especie> result = new ArrayList<Especie>();
		
		for(Especie e: todasEspecies){
			if(!especiesArea.contains(e)){
				result.add(e);
			}
		}
		
		return result;	
	}

	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof Area)){
			return false;
		}
		Area area = (Area) object;
		if(area.getIdArea() == this.getIdArea()){
			return true;
		}
		return false;	
	}
	

	
	

}
