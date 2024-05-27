package cl.test.bancochile.app.prueba.bch.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.test.bancochile.app.prueba.bch.dto.SerieUfDto;
import cl.test.bancochile.app.prueba.bch.dto.UfFechaDto;
import cl.test.bancochile.app.prueba.bch.service.UfFechaService;

@Service
public class ImplUfFechaService implements UfFechaService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ImplUfFechaService.class);

	@Override
	public Optional<UfFechaDto> getUfFecha(String fecha) {
		
		UfFechaDto ufFechaDto = new UfFechaDto();
		RestTemplate ufFecha = new RestTemplate();
		String resultado = ufFecha.getForObject("https://mindicador.cl/api/uf/"+fecha, String.class);
		System.out.println(resultado);

	    try {
	    	
	        JSONObject jsonObject = new JSONObject(resultado);
	        ufFechaDto.setVersion(jsonObject.getString("version"));
	        ufFechaDto.setAutor(jsonObject.getString("autor"));
	        ufFechaDto.setCodigo(jsonObject.getString("codigo"));   
	        ufFechaDto.setNombre(jsonObject.getString("nombre"));
	        ufFechaDto.setUnidad_medida(jsonObject.getString("unidad_medida"));    
	        
	        ArrayList<SerieUfDto> serieUfFechaList = new ArrayList<>();
	        SerieUfDto serieUfDto = new SerieUfDto();
            JSONArray jsonArrSeries = new JSONArray(jsonObject.getJSONArray("serie"));

            for (int j = 0; j < jsonArrSeries.length(); j++) {
                JSONObject objectInArray = jsonArrSeries.getJSONObject(j);
                System.out.println("--------");
                System.out.println(objectInArray);
                serieUfDto.setFecha(objectInArray.getString("fecha"));
                serieUfDto.setValor(objectInArray.getFloat("valor"));
                serieUfFechaList.add(serieUfDto);
            }
            
            ufFechaDto.setSerie(serieUfFechaList);
	        
	      } catch (JSONException err) {
	        LOGGER.error("Exception : " + err.toString());
	      }
	    
	    Optional<UfFechaDto> ufFechaObject = Optional.ofNullable(ufFechaDto);
	    
	    if(!ufFechaObject.isPresent()){
	    	LOGGER.info("Error: Optional is not present to ufAñoObject");
	    	return Optional.empty();
	    }else{
	       return ufFechaObject;
	    } 
	}

}
