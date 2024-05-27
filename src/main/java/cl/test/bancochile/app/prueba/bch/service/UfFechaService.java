package cl.test.bancochile.app.prueba.bch.service;

import java.util.Optional;

import cl.test.bancochile.app.prueba.bch.dto.UfFechaDto;

public interface UfFechaService {

	Optional<UfFechaDto> getUfFecha(String fecha);
}
