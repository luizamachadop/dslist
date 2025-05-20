package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true) // nao vai bloquear o banco de dados para escrita
    public List<GameMinDTO> findAll() {
        List<Game> result = repository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();

        return dto;
    }

    @Transactional(readOnly = true) // nao vai bloquear o banco de dados para escrita
    public GameDTO findById(Long id) {
        Game result = repository.findById(id).get();
    return new GameDTO(result);
    }
}
