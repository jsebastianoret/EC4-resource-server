package pe.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.company.model.ClienteEntity;
import pe.company.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
    @Autowired
    private ClienteService clienteService;
	
    @GetMapping("listar")
    @PreAuthorize("hasAuthority('ROLE_SEBAS')")
    public ResponseEntity<?> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }
    
    
    
    @PostMapping("/agregar")
    @PreAuthorize("hasAuthority('ROLE_SEBAS')")
    public ResponseEntity<ClienteEntity> agregarCliente(@RequestBody ClienteEntity cliente) {
        ClienteEntity nuevoCliente = clienteService.crearCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('ROLE_SEBAS')")
    public ResponseEntity<ClienteEntity> buscarClientePorId(@PathVariable Long id) {
        ClienteEntity cliente = clienteService.buscarPorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	

}
