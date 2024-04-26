package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.company.model.CompraEntity;
import pe.company.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private CompraRepository compraRepository;
	
	
    public List<CompraEntity> listarCompras() {
        return (List<CompraEntity>) compraRepository.findAll();
    }

    public CompraEntity buscarPorId(Long id) {
        Optional<CompraEntity> compraOptional = compraRepository.findById(id);
        return compraOptional.orElse(null);
    }

    public CompraEntity crearCompra(CompraEntity compra) {
        // Aquí puedes agregar lógica adicional antes de guardar el cliente
        return compraRepository.save(compra);
    }
	
	
	
	
	
	
	
	
	

}
