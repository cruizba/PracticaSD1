package SD.Practica_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SD.Practica_1.Entity.Area;

public interface AreaRepository extends JpaRepository<Area, Integer> {
	
	Area findByNombreArea(String nombreArea);

}
