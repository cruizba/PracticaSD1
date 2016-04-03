package SD.Practica_1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import SD.Practica_1.Entity.Area;
import SD.Practica_1.Entity.Especie;
import SD.Practica_1.repository.AreaRepository;
import SD.Practica_1.repository.EspecieRepository;

@Controller
public class EspeciesController {
	
	@Autowired
	private EspecieRepository espRep;
	
	@Autowired
	private AreaRepository areaRep;
	
	private List<Especie> especies = new ArrayList<Especie>();
	
	
	@RequestMapping(value="/especies", method=RequestMethod.GET)
	public String especie(Model model){
		
		especies = espRep.findAll();
		
		model.addAttribute("especies", especies);
		
		return "especies";
		
	}
	
	@RequestMapping("/especieInfo/{num}")
	public String areaInfo(@PathVariable(value = "num") Integer num, Model model){
		
		Especie especie = espRep.findOne(num);
		
		model.addAttribute(especie);
		
		return "especieInfo";
		
	}
	
	@RequestMapping("/insertarEspecie")
	public String insertarEspecie(){
		return "insertarEspecie";
	}
	
	@RequestMapping("/insertarEspecieBD")
	public String insertarEspecieBD(Especie especie, Model model){
		
		espRep.save(especie);
		
		return "insercionExito";
		
	}
	
	@RequestMapping("/modificarEspecie/{num}")
	public String modificarEspecie(@PathVariable(value = "num") Integer num, Model model){
		
		Especie esp = espRep.findOne(num);
		
		model.addAttribute(esp);
		
		return "modificarEspecie";
		
	}
	@RequestMapping("/modificarEspecieBD/{num}")
	public String modificarEspecieBD(@PathVariable(value = "num") Integer num, Especie especie, Model model){
		
		Especie especieAux = espRep.findOne(num);
		
		especieAux.setNombreCientifico(especie.getNombreCientifico());
		especieAux.setNombreComun(especie.getNombreComun());
		especieAux.setTipo(especie.getTipo());
		
		espRep.save(especieAux);
		
		return "edicionExito";
	}
	
	@RequestMapping("/eliminarEspecieBD/{num}")
	public String eliminar(@PathVariable(value="num") Integer num, Model model){
		
		espRep.delete(num);
		
		return "borradoExito";
		
	}
	
	@RequestMapping("/areaInfo/{num}")
	public String Info(@PathVariable (value="num") Integer num, Model model){
		
		Area area = areaRep.findOne(num);
		
		model.addAttribute("area", area);
		
		return "areaInfo";
		
	}
	

	@RequestMapping("/añadirAreasEspecie/{num}")
	public String añadirAreasEspecie(@PathVariable(value="num") Integer num, Model model){
		
		Especie especie = espRep.findOne(num);
		
		List<Area> opcionesArea = especie.areasNoContienenEspecie(areaRep);
		
		model.addAttribute("especie", especie);
		model.addAttribute("opciones", opcionesArea);
		
		return "añadirAreasEspecie";
		
	}
	
	@RequestMapping("/añadirAreasEspecieBD/{num}")
	public String añadirAreasEspecieBD(@PathVariable(value="num") Integer num,
										@RequestParam(value="idArea") Integer idArea,
										Model model){
		
		Area area = areaRep.findOne(idArea);
		Especie especie = espRep.findOne(num);
		
		especie.getAreas().add(area);
		
		espRep.save(especie);
		
		return "insercionExito";
	}
	
	@RequestMapping("/eliminarAreasEspecie/{num}")
	public String eliminarAreasEspecie(@PathVariable(value="num") Integer num, Model model){
		
		Especie especie = espRep.findOne(num);
		
		List<Area> opcionesArea = especie.getAreas();
		
		model.addAttribute("especie", especie);
		model.addAttribute("opciones", opcionesArea);
		
		return "eliminarAreasEspecie";
		
	}
	
	@RequestMapping("/eliminarAreasEspecieBD/{num}")
	public String eliminarAreasEspecieBD(@PathVariable(value="num") Integer num,
										@RequestParam(value="idArea") Integer idArea,
										Model model){
		
		Area area = areaRep.findOne(idArea);
		Especie especie = espRep.findOne(num);
		
		especie.getAreas().remove(area);
		
		espRep.save(especie);
		
		return "borradoExito";
	}
	
}
