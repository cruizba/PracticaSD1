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
public class AreasController {
	
	@Autowired
	private AreaRepository areaRep;
	
	@Autowired
	private EspecieRepository especieRep;
	
	private List<Area> areas = new ArrayList<Area>();
	
	@RequestMapping(value="/areas", method=RequestMethod.GET)
	public String areas(Model model){
		
		areas = areaRep.findAll();
		
		model.addAttribute("areas", areas);
		
		return "areas";
		
	}

	
	@RequestMapping("/modificarArea/{num}")
	public String modificarArea(@PathVariable(value ="num") Integer num, Model model){
		
		Area area = areaRep.findOne(num);
		
		model.addAttribute(area);
		
		return "modificarArea";
		
	}
	
	@RequestMapping(value="/insertarArea", method=RequestMethod.GET)
	public String insertarArea(){
		
		return "insertarArea";
	}
	
	@RequestMapping("/insertarAreaBD")
	public String insertarAreaBD(Area area, Model model) {

		areaRep.save(area);

		return "insercionExito";
	}
	
	@RequestMapping("/modificarAreaBD/{num}")
	public String modificarAreaBD(@PathVariable(value = "num") Integer num, Area area,Model model){
		
		Area areaAux = areaRep.findOne(num);
		
		areaAux.setNombreArea(area.getNombreArea());
		areaAux.setExtension(area.getExtension());
		
		areaRep.save(areaAux);
		
		return "edicionExito";
	}
	
	@RequestMapping("/eliminarAreaBD/{num}")
	public String eliminar(@PathVariable(value="num") Integer num, Model model){
		
		areaRep.delete(num);
		
		return "borradoExito";
		
	}
	
	@RequestMapping("/añadirEspeciesArea/{num}")
	public String añadirEspeciesArea(@PathVariable(value="num") Integer num, Model model){
		
		Area area = areaRep.findOne(num);
		
		List<Especie> opcionesEspecie = area.especiesNoEnArea(especieRep);
		
		model.addAttribute("area", area);
		model.addAttribute("opciones", opcionesEspecie);
		
		return "añadirEspeciesArea";
		
	}
	
	@RequestMapping("/añadirEspeciesAreaBD/{num}")
	public String añadirEspeciesAreaBD(@PathVariable(value="num") Integer num,
										@RequestParam(value="idEspecie") Integer idEspecie,
										Model model){
		
		Area area = areaRep.findOne(num);
		Especie especie = especieRep.findOne(idEspecie);
		
		especie.getAreas().add(area);
		
		especieRep.save(especie);
		
		return "insercionExito";
		
	}
	
	@RequestMapping("/eliminarEspeciesArea/{num}")
	public String eliminarEspeciesArea(@PathVariable(value="num") Integer num, Model model){
		
		Area area = areaRep.findOne(num);
		
		List<Especie> opcionesEspecie = area.getEspecies();
		
		model.addAttribute("area", area);
		model.addAttribute("opciones", opcionesEspecie);
		
		return "eliminarEspeciesArea";
		
	}
	
	@RequestMapping("/eliminarEspeciesAreaBD/{num}")
	public String eliminarEspeciesAreaBD(@PathVariable(value="num") Integer num,
										@RequestParam(value="idEspecie") Integer idEspecie,
										Model model){
		
		Area area = areaRep.findOne(num);
		Especie especie = especieRep.findOne(idEspecie);
		
		especie.getAreas().remove(area);
		
		especieRep.save(especie);
		
		return "borradoExito";
		
	}
}
