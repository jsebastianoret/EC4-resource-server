package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.CitaEntity;

import pe.company.repository.CitaRepository;

@Service
public class CitaService {
	
	@Autowired
	private CitaRepository citaRepository;
	
	
    public List<CitaEntity> listarCitas() {
        return (List<CitaEntity>) citaRepository.findAll();
    }

    public CitaEntity buscarPorId(Long id) {
        Optional<CitaEntity> citaOptional = citaRepository.findById(id);
        return citaOptional.orElse(null);
    }

    public CitaEntity crearCita(CitaEntity cita) {
        // Aquí puedes agregar lógica adicional antes de guardar el cliente
        return citaRepository.save(cita);
    }
	

}
