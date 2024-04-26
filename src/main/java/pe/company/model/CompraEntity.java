package pe.company.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="compras")	
public class CompraEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String fechaCompra;
    private int cantidad;
	
	
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonIgnore  // Ignora esta propiedad al serializar a JSON
    private ClienteEntity clientes;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    @JsonIgnore  // Ignora esta propiedad al serializar a JSON
    private ProductoEntity productos;
	

}
