package cl.test.bancochile.app.prueba.bch.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IndicadoresDto {

	private String codigo;
	private String nombre;
	private String unidad_medida;
	private String fecha;
	private BigDecimal valor;
}
