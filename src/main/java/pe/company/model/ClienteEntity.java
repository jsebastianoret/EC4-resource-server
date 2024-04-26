package pe.company.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="clientes")	
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
    private String nombre;
    private String direccion;
    private String telefono;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    @JsonIgnore  // Ignora esta propiedad al serializar a JSON
    private List<CitaEntity > citas;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    @JsonIgnore  // Ignora esta propiedad al serializar a JSON
    private List<CompraEntity > compras;
	


}
