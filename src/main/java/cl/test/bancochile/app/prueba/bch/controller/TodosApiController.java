package cl.test.bancochile.app.prueba.bch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.test.bancochile.app.prueba.bch.dto.TodosDto;
import cl.test.bancochile.app.prueba.bch.service.TodosService;
import cl.test.bancochile.app.prueba.bch.viewmodel.RetornoJson;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@RestController
@RequestMapping("${openapi.aPIRestMsPruebaBch.base-path:/ms-prueba-bch}")
public class TodosApiController implements TodosApi {
	
	@Autowired
	private TodosService todosService;

	@Override
	public ResponseEntity<RetornoJson> todos() {
		Optional<TodosDto> indicadores = todosService.getIndicadores();
		RetornoJson resJson = new RetornoJson(true, indicadores);
        return new ResponseEntity<>(resJson, HttpStatus.OK);
	}

}
