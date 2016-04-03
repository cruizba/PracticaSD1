package SD.Practica_1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SD.Practica_1.Entity.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Integer>{
	
	List<Especie> findByNombreComun(String nombreComun);
	
	List<Especie> findByTipo(String tipo);

}
