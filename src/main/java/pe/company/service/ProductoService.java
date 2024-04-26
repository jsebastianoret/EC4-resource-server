package pe.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.CompraEntity;
import pe.company.model.ProductoEntity;
import pe.company.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
    public List<ProductoEntity> listarProductos() {
        return (List<ProductoEntity>) productoRepository.findAll();
    }

    public ProductoEntity buscarPorId(Long id) {
        Optional<ProductoEntity> productoOptional = productoRepository.findById(id);
        return productoOptional.orElse(null);
    }

    public ProductoEntity crearProducto(ProductoEntity producto) {
        // Aquí puedes agregar lógica adicional antes de guardar el cliente
        return productoRepository.save(producto);
    }
	
	
	
	
	
	

	
}
