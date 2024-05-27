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
import cl.test.bancochile.app.prueba.bch.dto.UfDto;
import cl.test.bancochile.app.prueba.bch.service.UfService;

@Service
public class ImplUfService implements UfService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ImplUfService.class);

	@Override
	public Optional<UfDto> getTipo(String tipo) {
		UfDto ufDto = new UfDto();
		RestTemplate uf = new RestTemplate();
		String resultado = uf.getForObject("https://mindicador.cl/api/"+tipo, String.class);
		System.out.println(resultado);

	    try {
	    	
	        JSONObject jsonObject = new JSONObject(resultado);
	        ufDto.setVersion(jsonObject.getString("version"));
	        ufDto.setAutor(jsonObject.getString("autor"));
	        ufDto.setCodigo(jsonObject.getString("codigo"));    
	        ufDto.setNombre(jsonObject.getString("nombre"));
	        ufDto.setUnidad_medida(jsonObject.getString("unidad_medida"));    
	        
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
            
            ufDto.setSerie(serieUfList);
	        
	      } catch (JSONException err) {
	        LOGGER.error("Exception : " + err.toString());
	      }
	    
	    Optional<UfDto> ufObject = Optional.ofNullable(ufDto);
	    
	    if(!ufObject.isPresent()){
	    	LOGGER.info("Error: Optional is not present to ufAñoObject");
	    	return Optional.empty();
	    }else{
	       return ufObject;
	    } 
	}

}
