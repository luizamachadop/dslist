package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {
  @Autowired private GameListRepository repository;

  @Transactional(readOnly = true) // nao vai bloquear o banco de dados para escrita
  public List<GameListDTO> findAll() {
    List<GameList> result = repository.findAll();
    return result.stream().map(GameListDTO::new).toList();
  }
}
