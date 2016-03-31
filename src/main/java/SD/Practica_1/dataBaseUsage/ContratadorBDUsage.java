package SD.Practica_1.dataBaseUsage;
//package SD.Practica_1;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Controller;
//
//
//@Controller
//public class ContratadorBDUsage implements CommandLineRunner {
//	
//	@Autowired
//	private ContratadoRepository conRep;
//	
//	@Override
//	public void run(String... args) throws Exception{
//		
//		conRep.save(new Contratado("Jorge", "Fernandez", "91", "62", "Vigilante"));
//		conRep.save(new Contratado("Alberto", "Ruiz", "92", "61", "Vigilante"));
//		conRep.save(new Contratado("Tomas", "Valiente", "93", "61", "Cientifico"));
//		
//		// Vista de contratados
//		Iterable<Contratado> contratados = conRep.findAll();
//		System.out.println("-----Contratados------");
//		for(Contratado con: contratados){
//			System.out.println(con);
//		}
//		System.out.println();
//		
//		Iterable<Contratado> contratados2 = conRep.findByNombre("Pepe");
//		
//		for(Contratado con: contratados2){
//			System.out.println(con);
//		}
//		
//		
//	}
//	
//	
//
//}
