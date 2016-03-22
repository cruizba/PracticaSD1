package SD.Practica_1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepository extends JpaRepository<Especie, Integer>{
	
	Especie findByNombreComun(String nombreComun);

}
