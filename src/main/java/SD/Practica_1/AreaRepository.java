package SD.Practica_1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Integer> {
	
	Area findByNombreArea(String nombreArea);

}
