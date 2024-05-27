package cl.test.bancochile.app.prueba.bch.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UfAñoDto {

	private String codigo;
	private String nombre;
	private String unidad_medida;
	private List<SerieUfDto> serie;
	
}
