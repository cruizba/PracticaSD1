
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

import SD.Practica_1.Entity.Contratado;
import SD.Practica_1.repository.ContratadoRepository;

@Controller
public class ContratadosController {
	
	@Autowired 
	private ContratadoRepository conRep;
	private List<Contratado> listCon = new ArrayList<Contratado>();
	
	@RequestMapping(value="/personal", method=RequestMethod.GET)
	public String personal(Model model){
		listCon = conRep.findAll();
		
		model.addAttribute("contratados", listCon);
		
		return "personal";
	}
	
	@RequestMapping(value="/insertarPersonal", method=RequestMethod.GET)
	public String insertarPersonal(){
		
		return "insertarPersonal";
	}
	
	@RequestMapping("/insertarPersonalBD")
	public String insertar(Contratado contratado, Model model) {

		conRep.save(contratado);

		return "insercionExito";
	}
	
	@RequestMapping("/modificarPersonal/{num}")
	public String modificarPersonal(@PathVariable(value = "num") Integer num, Model model){
		
		Contratado contratado = conRep.findOne(num);
		
		model.addAttribute(contratado);
		
		return "modificarPersonal";
		
	}
	
	@RequestMapping("/modificarPersonalBD/{num}")
	public String modificar(@PathVariable(value = "num") Integer num, Contratado contratado, Model model){
		
		Contratado contratadoAux = conRep.findOne(num);
		
		contratadoAux.setNombre(contratado.getNombre());
		contratadoAux.setApellidos(contratado.getApellidos());
		contratadoAux.setTelFijo(contratado.getTelFijo());
		contratadoAux.setTelMovil(contratado.getTelMovil());
		contratadoAux.setTipo(contratado.getTipo());
		
		conRep.save(contratadoAux);
		
		return "edicionExito";
	}
	
	@RequestMapping("/eliminarPersonalBD/{num}")
	public String eliminar(@PathVariable(value="num") Integer num, Model model){
		
		conRep.delete(num);
		
		return "borradoExito";
		
	}
	
	@RequestMapping("/buscarPersonalPorApellidos")
	public String buscarPersonalPorApellidos(){
		
		return "buscarPersonalPorApellidos";
		
	}
	
	@RequestMapping("/buscarPersonalPorApellidosReq")
	public String buscarPersonalPorApellidosReq(@RequestParam("apellidos") String apellidos, Model model){
		
		List<Contratado> contratados = conRep.findByApellidos(apellidos);
		
		model.addAttribute("contratados", contratados);
		
		return "personal";
		
	}
	
	@RequestMapping("/buscarPersonalPorNyA")
	public String buscarPersonalPorNyA(){
		
		return "buscarPersonalPorNyA";
		
	}
	
	@RequestMapping("/buscarPersonalPorNyAReq")
	public String buscarPersonalPorNyAReq(@RequestParam("nombre") String nombre,
											@RequestParam("apellidos") String apellidos,
											Model model){
		
		List<Contratado> contratados = conRep.findByNombreAndApellidos(nombre, apellidos);
		
		model.addAttribute("contratados", contratados);
		
		return "personal";
		
	}
	
	@RequestMapping("/buscarPersonalPorTipo")
	public String buscarPersonalPorTipo(){
		
		return "buscarPersonalPorTipo";
		
	}
	
	@RequestMapping("/buscarPersonalPorTipoReq")
	public String buscarPersonalPorTipo(@RequestParam("tipo") String tipo, Model model){
		
		List<Contratado> contratados = conRep.findByTipo(tipo);
		
		model.addAttribute("contratados", contratados);
		
		return "personal";
		
	}
	
	
	
}
