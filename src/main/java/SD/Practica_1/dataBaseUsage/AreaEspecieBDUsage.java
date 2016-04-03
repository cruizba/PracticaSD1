//package SD.Practica_1.dataBaseUsage;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Controller;
//
//import SD.Practica_1.Entity.Area;
//import SD.Practica_1.Entity.Especie;
//import SD.Practica_1.repository.AreaRepository;
//import SD.Practica_1.repository.EspecieRepository;
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
//		especie1 = new Especie("Sapo etiópico","Sapo", "Animal","/img/especies/sapo.png");
//		especie2 = new Especie("Atelopus", "Sapos stubfoot", "Animal","/img/especies/atelopus.jpg");
//		especie3 = new Especie("Capensibufo", "Sapo del Cabo", "Animal","img/especies/capensibufo.jpg");
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
//		Especie resEsp1 = especieRep.findByNombreComun("Sapo").get(0);
//		Especie resEsp2 = especieRep.findByNombreComun("Sapos stubfoot").get(0);
//		Especie resEsp3 = especieRep.findByNombreComun("Sapo del Cabo").get(0);
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
