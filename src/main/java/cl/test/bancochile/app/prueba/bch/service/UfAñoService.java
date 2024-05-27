package cl.test.bancochile.app.prueba.bch.service;

import java.util.Optional;

import cl.test.bancochile.app.prueba.bch.dto.UfAñoDto;

public interface UfAñoService {

	Optional<UfAñoDto> getUfAño(String año);
}
