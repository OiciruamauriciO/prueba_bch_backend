package cl.test.bancochile.app.prueba.bch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.test.bancochile.app.prueba.bch.dto.UfAñoDto;
import cl.test.bancochile.app.prueba.bch.service.UfAñoService;
import cl.test.bancochile.app.prueba.bch.viewmodel.RetornoJson;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@RestController
@RequestMapping("${openapi.aPIRestMsPruebaBch.base-path:/ms-prueba-bch}")
public class UfAñoApiController implements UfAñoApi {
	
	@Autowired
	private UfAñoService ufAñoService;

	@Override
	public ResponseEntity<RetornoJson> ufAño(String año) {
		Optional<UfAñoDto> ufAño = ufAñoService.getUfAño(año);
		RetornoJson resJson = new RetornoJson(true, ufAño);
        return new ResponseEntity<>(resJson, HttpStatus.OK);
	}



}
