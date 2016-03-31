package SD.Practica_1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
}
