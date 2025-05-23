package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {
  @Autowired private GameListRepository gameListRepository;
  @Autowired private GameRepository gameRepository;

  @Transactional(readOnly = true) // nao vai bloquear o banco de dados para escrita
  public List<GameListDTO> findAll() {
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(GameListDTO::new).toList();
  }

  @Transactional(readOnly = true) // nao vai bloquear o banco de dados para escrita
  public List<GameMinDTO> findByList(Long listId) {
    List<GameMinProjection> result = gameRepository.searchByList(listId);
    return result.stream().map(GameMinDTO::new).toList();
  }
}
