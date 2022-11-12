package org.home.productivity.focus.controller;

import java.util.List;

import org.home.productivity.focus.model.Board;
import org.home.productivity.focus.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/boards")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // create
    @PostMapping
    // @JsonView(Views.Public.class)
    public ResponseEntity<Board> save(@RequestBody Board board) {
        log.info("Saving board: {}", board);
        return ResponseEntity.ok(boardService.save(board));
    }

    // read
    @GetMapping
    // @JsonView(Views.Public.class)
    public ResponseEntity<List<Board>> findAll() {
        log.info("Retrieving all boards");
        return ResponseEntity.ok(boardService.findAll());
    }

    @GetMapping("/{id}")
    // @JsonView(Views.Public.class)
    public ResponseEntity<Board> findById(@PathVariable Long id) {
        log.info("Retrieving board by id: {}", id);
        return ResponseEntity.ok(boardService.findById(id));
    }

    // update
    @PutMapping("/{id}")
    // @JsonView(Views.Public.class)
    public ResponseEntity<Board> update(@PathVariable Long id, @RequestBody Board board) {
        log.info("Updating board: {}", board);

        var existingBoard = boardService.findById(id);
        existingBoard.setName(board.getName());
        existingBoard.setDescription(board.getDescription());

        return ResponseEntity.ok(boardService.save(existingBoard));
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        log.info("Deleting board by id: {}", id);
        return ResponseEntity.ok(boardService.deleteById(id));
    }

}
