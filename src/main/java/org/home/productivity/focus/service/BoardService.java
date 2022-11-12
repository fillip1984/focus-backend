package org.home.productivity.focus.service;

import java.util.List;

import org.home.productivity.focus.model.Board;
import org.home.productivity.focus.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // create
    public Board save(Board board) {
        log.info("Saving board: {}", board);
        return boardRepository.save(board);
    }

    public List<Board> saveAll(List<Board> boards) {
        log.info("Saving list of boards");
        return boardRepository.saveAll(boards);
    }

    public List<Board> findAll() {
        log.info("Retrieving all boards");
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        log.info("Retrieving board by id: {}", id);
        return boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unable to find board by id: " + id));
    }

    // update
    public Board update(Board board) {
        log.info("Updating board: {}", board);
        return boardRepository.save(board);
    }

    // delete
    public boolean deleteById(Long id) {
        log.info("Deleting board by id: {}", id);
        boardRepository.deleteById(id);
        return true;
    }
}
