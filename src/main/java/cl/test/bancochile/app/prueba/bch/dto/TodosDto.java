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
public class TodosDto {

	private String version;
	private String autor;
	private String fecha;
	private List<IndicadoresDto> uf;
	@SuppressWarnings({ "rawtypes" })
	private List ivp;
	@SuppressWarnings({ "rawtypes" })
	private List dolar;
	@SuppressWarnings({ "rawtypes" })
	private List dolarIntercambio;
	@SuppressWarnings({ "rawtypes" })
	private List euro;
	@SuppressWarnings({ "rawtypes" })
	private List ipc;
	@SuppressWarnings({ "rawtypes" })
	private List utm;
	@SuppressWarnings({ "rawtypes" })
	private List imacec;
	@SuppressWarnings({ "rawtypes" })
	private List tpm;
	@SuppressWarnings({ "rawtypes" })
	private List libra_cobre;
	@SuppressWarnings({ "rawtypes" })
	private List tasa_desempleo;
	@SuppressWarnings({ "rawtypes" })
	private List bitcoin;
}
