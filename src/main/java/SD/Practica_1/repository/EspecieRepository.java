package SD.Practica_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SD.Practica_1.Entity.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Integer>{
	
	Especie findByNombreComun(String nombreComun);

}
