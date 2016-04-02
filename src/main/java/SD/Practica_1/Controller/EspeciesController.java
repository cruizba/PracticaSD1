package SD.Practica_1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SD.Practica_1.Entity.Especie;
import SD.Practica_1.repository.EspecieRepository;


@Controller
public class EspeciesController {
		
	@Autowired 
	private EspecieRepository especiesRep;
	
	private List<Especie> listEspecies = new  ArrayList <Especie> ();
	
	@RequestMapping(value="/especies", method=RequestMethod.GET)
	public String especie (Model model){
		listEspecies = especiesRep.findAll();
		
		model.addAttribute("especies", listEspecies);
		
		return "especies";
	}
	
	@RequestMapping(value="/insertarEspecie", method=RequestMethod.GET)
	public String insertarEspecie(){
		
		return "insertarEspecie";
	}
	
	@RequestMapping("/insertarEspecieBD")
	public String insertar(Especie especie, Model model) {

		especiesRep.save(especie);

		return "insercionExitoEspecie";
	}
	
	@RequestMapping("/modificarEspecie/{num}")
	public String modificarEspecie(@PathVariable(value = "num") Integer num, Model model){
		
		Especie especie = especiesRep.findOne(num);
		
		model.addAttribute(especie);
		
		return "modificarEspecie";
		
	}
	
	@RequestMapping("/modificarEspecieBD/{num}")
	public String modificar(@PathVariable(value = "num") Integer num, Especie especie, Model model){
		
		
		Especie especieAux = especiesRep.findOne(num);
		
		especieAux.setNombreCientifico(especie.getNombreCientifico());
		especieAux.setNombreComun(especie.getNombreComun());
		especieAux.setTipo(especie.getTipo());
		especieAux.setImageUrl(especie.getImageUrl());
		
		especiesRep.save(especieAux);
		
		return "edicionExitoEspecie";
	}
	
	@RequestMapping("/eliminarEspecieBD/{num}")
	public String eliminar(@PathVariable(value="num") Integer num, Model model){
		
		especiesRep.delete(num);
		
		return "borradoExitoEspecie";
		
	}

}
