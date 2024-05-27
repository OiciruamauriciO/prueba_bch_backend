package cl.test.bancochile.app.prueba.bch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IndicadoresOnlyUtmDto {

	private String codigo;
	private String nombre;
	private String unidad_medida;
	private String fecha;
	private Integer valor;
}
