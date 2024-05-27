package cl.test.bancochile.app.prueba.bch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.test.bancochile.app.prueba.bch.dto.UfFechaDto;
import cl.test.bancochile.app.prueba.bch.service.UfFechaService;
import cl.test.bancochile.app.prueba.bch.viewmodel.RetornoJson;

//import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@RestController
@RequestMapping("${openapi.aPIRestMsPruebaBch.base-path:/ms-prueba-bch}")
public class UfFechaApiController implements UfFechaApi {
	
	@Autowired
	private UfFechaService ufFechaService;

	@Override
	public ResponseEntity<RetornoJson> fecha(String fecha) {
		Optional<UfFechaDto> ufFecha = ufFechaService.getUfFecha(fecha);
		RetornoJson resJson = new RetornoJson(true, ufFecha);
        return new ResponseEntity<>(resJson, HttpStatus.OK);
	}
	
}
