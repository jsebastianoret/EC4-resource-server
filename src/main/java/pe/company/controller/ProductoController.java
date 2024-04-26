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

import pe.company.model.ProductoEntity;
import pe.company.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @PostMapping("/agregar")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<ProductoEntity> agregarProducto(@RequestBody ProductoEntity producto) {
        ProductoEntity nuevoProducto = productoService.crearProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<ProductoEntity> buscarProductoPorId(@PathVariable Long id) {
        ProductoEntity producto = productoService.buscarPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
