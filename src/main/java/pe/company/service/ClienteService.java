package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.ClienteEntity;
import pe.company.repository.ClienteRepository;

@Service
public class ClienteService {
	
	
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteEntity> listarClientes() {
        return (List<ClienteEntity>) clienteRepository.findAll();
    }

    public ClienteEntity buscarPorId(Long id) {
        Optional<ClienteEntity> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }

    public ClienteEntity crearCliente(ClienteEntity cliente) {
        // Aquí puedes agregar lógica adicional antes de guardar el cliente
        return clienteRepository.save(cliente);
    }
	
	
	
	
	
	

}
