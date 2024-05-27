package cl.test.bancochile.app.prueba.bch.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.test.bancochile.app.prueba.bch.dto.IndicadoresDto;
import cl.test.bancochile.app.prueba.bch.dto.IndicadoresOnlyTpmDto;
import cl.test.bancochile.app.prueba.bch.dto.IndicadoresOnlyUtmDto;
import cl.test.bancochile.app.prueba.bch.dto.TodosDto;
import cl.test.bancochile.app.prueba.bch.service.TodosService;

@Service
public class ImplTodosService implements TodosService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ImplTodosService.class);

	@Override
	public Optional<TodosDto> getIndicadores() {

		TodosDto todosDto = new TodosDto();
		RestTemplate todos = new RestTemplate();
		String resultado = todos.getForObject("https://mindicador.cl/api", String.class);
		System.out.println(resultado);
		
	    try {
	    	
	        JSONObject jsonObject = new JSONObject(resultado);
	        todosDto.setVersion(jsonObject.getString("version"));
	        todosDto.setAutor(jsonObject.getString("autor"));
	        todosDto.setFecha(jsonObject.getString("fecha"));
	        
	        ArrayList<IndicadoresDto> ufList = new ArrayList<>();
	        IndicadoresDto indicadoresUfDto = new IndicadoresDto();

            indicadoresUfDto.setCodigo(String.valueOf(jsonObject.getJSONObject("uf").get("codigo")));
            indicadoresUfDto.setNombre(String.valueOf(jsonObject.getJSONObject("uf").get("nombre")));
            indicadoresUfDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("uf").get("unidad_medida")));
            indicadoresUfDto.setFecha(String.valueOf(jsonObject.getJSONObject("uf").get("fecha")));
            indicadoresUfDto.setValor((BigDecimal) jsonObject.getJSONObject("uf").get("valor"));   
                
	        ufList.add(indicadoresUfDto);	        
	        todosDto.setUf(ufList);
	        
	        ArrayList<IndicadoresDto> ivpList = new ArrayList<>();
	        IndicadoresDto indicadoresIvpDto = new IndicadoresDto();
	        indicadoresIvpDto.setCodigo(String.valueOf(jsonObject.getJSONObject("ivp").get("codigo")));
	        indicadoresIvpDto.setNombre(String.valueOf(jsonObject.getJSONObject("ivp").get("nombre")));
	        indicadoresIvpDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("ivp").get("unidad_medida")));
	        indicadoresIvpDto.setFecha(String.valueOf(jsonObject.getJSONObject("ivp").get("fecha")));
	        indicadoresIvpDto.setValor((BigDecimal) jsonObject.getJSONObject("ivp").get("valor"));   
            
            ivpList.add(indicadoresIvpDto);	        
	        todosDto.setIvp(ivpList);
	        
	        ArrayList<IndicadoresDto> dolarList = new ArrayList<>();
	        IndicadoresDto indicadoresDolarDto = new IndicadoresDto();
	        indicadoresDolarDto.setCodigo(String.valueOf(jsonObject.getJSONObject("dolar").get("codigo")));
	        indicadoresDolarDto.setNombre(String.valueOf(jsonObject.getJSONObject("dolar").get("nombre")));
	        indicadoresDolarDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("dolar").get("unidad_medida")));
	        indicadoresDolarDto.setFecha(String.valueOf(jsonObject.getJSONObject("dolar").get("fecha")));
	        indicadoresDolarDto.setValor((BigDecimal) jsonObject.getJSONObject("dolar").get("valor"));

	        dolarList.add(indicadoresDolarDto);	        
	        todosDto.setDolar(dolarList);
	        
	        ArrayList<IndicadoresDto> dolarIntercambioList = new ArrayList<>();
	        IndicadoresDto indicadoresDolarIntercambioDto = new IndicadoresDto();
	        indicadoresDolarIntercambioDto.setCodigo(String.valueOf(jsonObject.getJSONObject("dolar_intercambio").get("codigo")));
	        indicadoresDolarIntercambioDto.setNombre(String.valueOf(jsonObject.getJSONObject("dolar_intercambio").get("nombre")));
	        indicadoresDolarIntercambioDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("dolar_intercambio").get("unidad_medida")));
	        indicadoresDolarIntercambioDto.setFecha(String.valueOf(jsonObject.getJSONObject("dolar_intercambio").get("fecha")));
	        indicadoresDolarIntercambioDto.setValor((BigDecimal) jsonObject.getJSONObject("dolar_intercambio").get("valor"));
	        
	        dolarIntercambioList.add(indicadoresDolarIntercambioDto);	        
	        todosDto.setDolarIntercambio(dolarIntercambioList);
	        
	        ArrayList<IndicadoresDto> euroList = new ArrayList<>();
	        IndicadoresDto indicadoresEuroDto = new IndicadoresDto();
	        indicadoresEuroDto.setCodigo(String.valueOf(jsonObject.getJSONObject("euro").get("codigo")));
	        indicadoresEuroDto.setNombre(String.valueOf(jsonObject.getJSONObject("euro").get("nombre")));
	        indicadoresEuroDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("euro").get("unidad_medida")));
	        indicadoresEuroDto.setFecha(String.valueOf(jsonObject.getJSONObject("euro").get("fecha")));
	        indicadoresEuroDto.setValor((BigDecimal) jsonObject.getJSONObject("euro").get("valor"));
	        
	        euroList.add(indicadoresEuroDto);	        
	        todosDto.setEuro(euroList);
	        
	        ArrayList<IndicadoresDto> ipcList = new ArrayList<>();
	        IndicadoresDto indicadoresIpcDto = new IndicadoresDto();
	        indicadoresIpcDto.setCodigo(String.valueOf(jsonObject.getJSONObject("ipc").get("codigo")));
	        indicadoresIpcDto.setNombre(String.valueOf(jsonObject.getJSONObject("ipc").get("nombre")));
	        indicadoresIpcDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("ipc").get("unidad_medida")));
	        indicadoresIpcDto.setFecha(String.valueOf(jsonObject.getJSONObject("ipc").get("fecha")));
	        indicadoresIpcDto.setValor((BigDecimal) jsonObject.getJSONObject("ipc").get("valor"));
	        
	        ipcList.add(indicadoresIpcDto);	        
	        todosDto.setIpc(ipcList);
	        
	        ArrayList<IndicadoresOnlyUtmDto> utmList = new ArrayList<>();
	        IndicadoresOnlyUtmDto indicadoresUtmDto = new IndicadoresOnlyUtmDto();
	        indicadoresUtmDto.setCodigo(String.valueOf(jsonObject.getJSONObject("utm").get("codigo")));
	        indicadoresUtmDto.setNombre(String.valueOf(jsonObject.getJSONObject("utm").get("nombre")));
	        indicadoresUtmDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("utm").get("unidad_medida")));
	        indicadoresUtmDto.setFecha(String.valueOf(jsonObject.getJSONObject("utm").get("fecha")));
	        indicadoresUtmDto.setValor((Integer) jsonObject.getJSONObject("utm").get("valor"));
	        
	        utmList.add(indicadoresUtmDto);	        
	        todosDto.setUtm(utmList);
	        
	        ArrayList<IndicadoresDto> imacecList = new ArrayList<>();
	        IndicadoresDto indicadoresImacecDto = new IndicadoresDto();
	        indicadoresImacecDto.setCodigo(String.valueOf(jsonObject.getJSONObject("imacec").get("codigo")));
	        indicadoresImacecDto.setNombre(String.valueOf(jsonObject.getJSONObject("imacec").get("nombre")));
	        indicadoresImacecDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("imacec").get("unidad_medida")));
	        indicadoresImacecDto.setFecha(String.valueOf(jsonObject.getJSONObject("imacec").get("fecha")));
	        indicadoresImacecDto.setValor((BigDecimal) jsonObject.getJSONObject("imacec").get("valor"));
	        
	        imacecList.add(indicadoresImacecDto);	        
	        todosDto.setImacec(imacecList);
	        
	        ArrayList<IndicadoresOnlyTpmDto> tpmList = new ArrayList<>();
	        IndicadoresOnlyTpmDto indicadoresTpmDto = new IndicadoresOnlyTpmDto();
	        indicadoresTpmDto.setCodigo(String.valueOf(jsonObject.getJSONObject("tpm").get("codigo")));
	        indicadoresTpmDto.setNombre(String.valueOf(jsonObject.getJSONObject("tpm").get("nombre")));
	        indicadoresTpmDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("tpm").get("unidad_medida")));
	        indicadoresTpmDto.setFecha(String.valueOf(jsonObject.getJSONObject("tpm").get("fecha")));
	        indicadoresTpmDto.setValor((Integer) jsonObject.getJSONObject("tpm").get("valor"));
	        
	        tpmList.add(indicadoresTpmDto);	        
	        todosDto.setTpm(tpmList);
	        
	        ArrayList<IndicadoresDto> libraCobreList = new ArrayList<>();
	        IndicadoresDto indicadoresLibraCobreDto = new IndicadoresDto();
	        indicadoresLibraCobreDto.setCodigo(String.valueOf(jsonObject.getJSONObject("libra_cobre").get("codigo")));
	        indicadoresLibraCobreDto.setNombre(String.valueOf(jsonObject.getJSONObject("libra_cobre").get("nombre")));
	        indicadoresLibraCobreDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("libra_cobre").get("unidad_medida")));
	        indicadoresLibraCobreDto.setFecha(String.valueOf(jsonObject.getJSONObject("libra_cobre").get("fecha")));
	        indicadoresLibraCobreDto.setValor((BigDecimal) jsonObject.getJSONObject("libra_cobre").get("valor"));
	        
	        libraCobreList.add(indicadoresLibraCobreDto);	        
	        todosDto.setLibra_cobre(libraCobreList);
	        
	        ArrayList<IndicadoresDto> tasaDesempleoList = new ArrayList<>();
	        IndicadoresDto indicadoresTasaDesempleoDto = new IndicadoresDto();
	        indicadoresTasaDesempleoDto.setCodigo(String.valueOf(jsonObject.getJSONObject("tasa_desempleo").get("codigo")));
	        indicadoresTasaDesempleoDto.setNombre(String.valueOf(jsonObject.getJSONObject("tasa_desempleo").get("nombre")));
	        indicadoresTasaDesempleoDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("tasa_desempleo").get("unidad_medida")));
	        indicadoresTasaDesempleoDto.setFecha(String.valueOf(jsonObject.getJSONObject("tasa_desempleo").get("fecha")));
	        indicadoresTasaDesempleoDto.setValor((BigDecimal) jsonObject.getJSONObject("tasa_desempleo").get("valor"));
	        
	        tasaDesempleoList.add(indicadoresTasaDesempleoDto);	        
	        todosDto.setTasa_desempleo(tasaDesempleoList);
	        
	        ArrayList<IndicadoresDto> bitcoinList = new ArrayList<>();
	        IndicadoresDto indicadoresBitcoinDto = new IndicadoresDto();
	        indicadoresBitcoinDto.setCodigo(String.valueOf(jsonObject.getJSONObject("bitcoin").get("codigo")));
	        indicadoresBitcoinDto.setNombre(String.valueOf(jsonObject.getJSONObject("bitcoin").get("nombre")));
	        indicadoresBitcoinDto.setUnidad_medida(String.valueOf(jsonObject.getJSONObject("bitcoin").get("unidad_medida")));
	        indicadoresBitcoinDto.setFecha(String.valueOf(jsonObject.getJSONObject("bitcoin").get("fecha")));
	        indicadoresBitcoinDto.setValor((BigDecimal) jsonObject.getJSONObject("bitcoin").get("valor"));        
	        
	        bitcoinList.add(indicadoresBitcoinDto);	        
	        todosDto.setBitcoin(bitcoinList);
	        
	      } catch (JSONException err) {
	        LOGGER.error("Exception : " + err.toString());
	      }
	    
	    Optional<TodosDto> indicadores = Optional.ofNullable(todosDto);
	    
	    if(!indicadores.isPresent()){
	    	LOGGER.info("Error: Optional is not present to indicadores");
	    	return Optional.empty();
	    }else{
	       return indicadores;
	    } 
	}

}
