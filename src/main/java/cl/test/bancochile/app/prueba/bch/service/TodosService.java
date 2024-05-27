package cl.test.bancochile.app.prueba.bch.service;

import java.util.Optional;

import cl.test.bancochile.app.prueba.bch.dto.TodosDto;

public interface TodosService {

	Optional<TodosDto> getIndicadores();
}
