/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package cl.test.bancochile.app.prueba.bch.controller;

import cl.test.bancochile.app.prueba.bch.viewmodel.ErrorGenerico;
import cl.test.bancochile.app.prueba.bch.viewmodel.ResponseGenerico;
import cl.test.bancochile.app.prueba.bch.viewmodel.RetornoJson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
public interface UfFechaApi {

    /**
     * POST /v1/indicadores/tipo/uf/{fecha} : Get para indicador UF según fecha dd-mm-yyyy
     *
     * @param fecha  (required)
     * @param response  (required)
     * @param request  (required)
     * @return OK (status code 200)
     *         or (Bad Request) Los datos enviados son incorrectos o hay datos obligatorios no enviados (status code 400)
     *         or (Unauthorized) No Autorizado (status code 401)
     *         or (NotFound) No se encontro informacion (status code 404)
     *         or Error en servidor (status code 500)
     */
	@Operation(summary = "Get para indicador UF según fecha dd-mm-yyyy", description = "UF según fecha dd-mm-yyyy")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseGenerico.class)) }),
			@ApiResponse(responseCode = "400", description = "(Bad Request) Los datos enviados son incorrectos o hay datos obligatorios no enviados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorGenerico.class)) }),
			@ApiResponse(responseCode = "401", description = "(Unauthorized) No Autorizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorGenerico.class)) }),
			@ApiResponse(responseCode = "404", description = "(NotFound) No se encontro informacion", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorGenerico.class)) }),
			@ApiResponse(responseCode = "500", description = "Se presenta un error interno durante la consulta a base de datos", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorGenerico.class)) }) })
	@CrossOrigin(origins = "http://localhost:9876")
	@RequestMapping(
        method = RequestMethod.GET,
        value = "/v1/indicadores/tipo/uf/fecha/{fecha}",
        produces = { "application/json" }
    )
    ResponseEntity<RetornoJson> fecha(@PathVariable("fecha") String fecha);

}
