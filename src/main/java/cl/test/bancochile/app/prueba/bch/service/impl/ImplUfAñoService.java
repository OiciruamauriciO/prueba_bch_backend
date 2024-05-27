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
import cl.test.bancochile.app.prueba.bch.dto.UfAñoDto;
import cl.test.bancochile.app.prueba.bch.service.UfAñoService;

@Service
public class ImplUfAñoService implements UfAñoService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ImplUfAñoService.class);

	@Override
	public Optional<UfAñoDto> getUfAño(String año) {

		UfAñoDto ufAñoDto = new UfAñoDto();
		RestTemplate ufAño = new RestTemplate();
		String resultado = ufAño.getForObject("https://mindicador.cl/api/uf/"+año, String.class);
		System.out.println(resultado);

	    try {
	    	
	        JSONObject jsonObject = new JSONObject(resultado);
	        ufAñoDto.setCodigo(jsonObject.getString("codigo"));
	        ufAñoDto.setNombre(jsonObject.getString("nombre"));
	        ufAñoDto.setUnidad_medida(jsonObject.getString("unidad_medida"));    
	        
	        ArrayList<SerieUfDto> serieUfList = new ArrayList<>();
	        SerieUfDto serieUfDto = new SerieUfDto();
            JSONArray jsonArrSeries = new JSONArray(jsonObject.getJSONArray("serie"));

            for (int j = 0; j < jsonArrSeries.length(); j++) {
                JSONObject objectInArray = jsonArrSeries.getJSONObject(j);
                System.out.println("--------");
                System.out.println(objectInArray);
                serieUfDto.setFecha(objectInArray.getString("fecha"));
                serieUfDto.setValor(objectInArray.getFloat("valor"));
                serieUfList.add(serieUfDto);
            }
            
            ufAñoDto.setSerie(serieUfList);
	        
	      } catch (JSONException err) {
	        LOGGER.error("Exception : " + err.toString());
	      }
	    
	    Optional<UfAñoDto> ufAñoObject = Optional.ofNullable(ufAñoDto);
	    
	    if(!ufAñoObject.isPresent()){
	    	LOGGER.info("Error: Optional is not present to ufAñoObject");
	    	return Optional.empty();
	    }else{
	       return ufAñoObject;
	    } 
	}

}
