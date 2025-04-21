package com.ohgiraffers.crud.board.controller;

import com.ohgiraffers.crud.board.dto.BoardDTO;
import com.ohgiraffers.crud.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/boards")
@Validated // 유효성검증(validate는 비즈니스로직이 아니다 왜냐하면 사용자에게 입력값이 들어와야 비즈니스로직에 맞는지 확인할 수 있으니까) -> 순수 비즈니스 로직에만 집중가능
public class BoardController {

    private static final Logger logger = Logger.getLogger(BoardController.class.getName());
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<BoardDTO> createBoard(@Validated @RequestBody BoardDTO boardDTO) {
        logger.info("post : /boards " + boardDTO.getTitle());

        BoardDTO savedBoard = boardService.createBoard(boardDTO);

        if (savedBoard == null) {
            return ResponseEntity.status(500).body(null);
        } else {
            return ResponseEntity.ok().body(savedBoard);
        }
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<BoardDTO> updateBoard(@PathVariable("boardId") int boardId, @Validated @RequestBody BoardDTO boardDTO) {
        logger.info("patch : /boards/" + boardId);

        BoardDTO updatedBoard = boardService.updateBoard(boardId, boardDTO);

        if (updatedBoard == null) {
            return ResponseEntity.status(500).body(null);
        } else {
            return ResponseEntity.ok().body(updatedBoard);
        }
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("boardId") int boardId) {
        logger.info("DELETE : /api/boards/" + boardId);
        boardService.deleteBoard(boardId);
        return ResponseEntity.noContent().build(); // 이거 뭔지 찾아보기
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDTO> getBoardById(@PathVariable("boardId") int boardId) {
        logger.info("GET : /api/boards/" + boardId);
        BoardDTO board = boardService.getBoardById(boardId);
        return ResponseEntity.ok(board);
    }

    // 예외 처리
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.warning("Validation error: {}" + ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
