package cl.test.bancochile.app.prueba.bch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.test.bancochile.app.prueba.bch.dto.UfDto;
import cl.test.bancochile.app.prueba.bch.service.UfService;
import cl.test.bancochile.app.prueba.bch.viewmodel.RetornoJson;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@RestController
@RequestMapping("${openapi.aPIRestMsPruebaBch.base-path:/ms-prueba-bch}")
public class UfApiController implements UfApi {
	
	@Autowired
	private UfService ufService;

	@Override
	public ResponseEntity<RetornoJson> uf(String tipo) {
		Optional<UfDto> uf = ufService.getTipo(tipo);
		RetornoJson resJson = new RetornoJson(true, uf);
        return new ResponseEntity<>(resJson, HttpStatus.OK);
	}

}
