package SD.Practica_1.dataBaseUsage;
//package SD.Practica_1;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class AreaEspecieBDUsage implements CommandLineRunner{
//	
//	@Autowired
//	private AreaRepository areaRep;
//	
//	@Autowired
//	private EspecieRepository especieRep;
//	
//	@Override
//	public void run(String... arg0) throws Exception {
//		
//		Area area1;
//		Area area2;
//		Area area3;
//		
//		Especie especie1;
//		Especie especie2;
//		Especie especie3;
//		
//		area1 = new Area("Valle alto", "1800 ha");
//		area2 = new Area("Fuerte viento", "1500 ha");
//		area3 = new Area("Rio sano", "2000 ha");
//		
//		especie1 = new Especie("Sapo etiópico","Sapo", "Animal",null);
//		especie2 = new Especie("Atelopus", "Sapos stubfoot", "Animal",null);
//		especie3 = new Especie("Capensibufo", "Sapo del Cabo", "Animal",null);
//		
//		//Establecemos la relación
//		
//		especie1.getAreas().add(area1);
//		especie1.getAreas().add(area2);
//		especie1.getAreas().add(area3);
//		
//		especie2.getAreas().add(area2);
//		especie2.getAreas().add(area2);
//		
//		especie3.getAreas().add(area3);
//
//		
//		//Guardamos en la base de datos
//		
//		areaRep.save(area1);
//		areaRep.save(area2);
//		areaRep.save(area3);
//		
//		especieRep.save(especie1);
//		especieRep.save(especie2);
//		especieRep.save(especie3);
//		
//		Especie resEsp1 = especieRep.findByNombreComun("Sapo");
//		Especie resEsp2 = especieRep.findByNombreComun("Sapos stubfoot");
//		Especie resEsp3 = especieRep.findByNombreComun("Sapo del Cabo");
//		
//		Area resArea = areaRep.findByNombreArea("Rio sano");
//		
//		System.out.println(resEsp1);
//		for(Area a: resEsp1.getAreas()){
//			System.out.println(a);
//		}
//		System.out.println(resEsp2);
//		for(Area a: resEsp2.getAreas()){
//			System.out.println(a);
//		}
//		System.out.println(resEsp3);
//		for(Area a: resEsp3.getAreas()){
//			System.out.println(a);
//		}
//		
//		for(Especie e: resArea.getEspecies()){
//			System.out.println(e);
//		}
//		
//	}
//
//}
