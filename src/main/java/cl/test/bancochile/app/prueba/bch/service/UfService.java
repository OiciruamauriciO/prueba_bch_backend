package cl.test.bancochile.app.prueba.bch.service;

import java.util.Optional;

import cl.test.bancochile.app.prueba.bch.dto.UfDto;

public interface UfService {

	Optional<UfDto> getTipo(String tipo);
}
