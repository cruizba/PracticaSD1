package SD.Practica_1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SD.Practica_1.Entity.Contratado;


public interface ContratadoRepository extends JpaRepository<Contratado, Integer>{
	
	List<Contratado> findByNombre(String nombre);
	
	List<Contratado> findByApellidos(String apellidos);
}
