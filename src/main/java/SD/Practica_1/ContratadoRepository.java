package SD.Practica_1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ContratadoRepository extends JpaRepository<Contratado, Integer>{
	
	List<Contratado> findByNombre(String nombre);
	
	List<Contratado> findByApellidos(String apellidos);
}
