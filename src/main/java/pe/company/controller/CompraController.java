package pe.company.controller;

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

import pe.company.model.CompraEntity;
import pe.company.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
    @Autowired
    private CompraService compraService;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ROLE_SEBAS')")
    public ResponseEntity<?> listarCompras() {
        return ResponseEntity.ok(compraService.listarCompras());
    }

    @PostMapping("/agregar")
    @PreAuthorize("hasAuthority('ROLE_SEBAS')")
    public ResponseEntity<CompraEntity> agregarCompra(@RequestBody CompraEntity compra) {
        CompraEntity nuevaCompra = compraService.crearCompra(compra);
        return new ResponseEntity<>(nuevaCompra, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('ROLE_SEBAS')")
    public ResponseEntity<CompraEntity> buscarCompraPorId(@PathVariable Long id) {
        CompraEntity compra = compraService.buscarPorId(id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
