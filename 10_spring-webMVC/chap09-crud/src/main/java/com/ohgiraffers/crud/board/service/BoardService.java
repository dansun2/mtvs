package com.ohgiraffers.crud.board.service;

import com.ohgiraffers.crud.board.dto.BoardDTO;
import com.ohgiraffers.crud.board.entity.Board;
import com.ohgiraffers.crud.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BoardService {

    private static final Logger logger = Logger.getLogger(BoardService.class.getName());
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public BoardDTO createBoard(BoardDTO boardDTO) {
        logger.info("보드 추가하기 제목 : " + boardDTO.getTitle());

        // Optional
        Optional<Board> findBoard = boardRepository.findByBoardTitle(boardDTO.getTitle());

        if (findBoard.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 제목입니다. : " + boardDTO.getTitle());
        }

        Board board = new Board(boardDTO.getTitle(), boardDTO.getContent());
        Board savedBoard = boardRepository.save(board);

        logger.info("게시판 등록 성공! 게시글ID : " + savedBoard.getBoardId());

        // 1. 엔티티로 반환해도 상관없지만 다른 레이어에서 참조하다가 값이 변조될 수 있음
        // 2. 모든 데이터를 노출하면 안되는 엔티티가 있다 (ex. 결제정보 테이블 등)
        // => 그래서 내가 클라이언트에게 응답할 데이터만 DTO에 담아서 반환해주는것
        return new BoardDTO(savedBoard.getBoardId(), savedBoard.getBoardTitle(), savedBoard.getBoardContent());
    }

    @Transactional
    public BoardDTO updateBoard(int boardId, BoardDTO boardDTO) {
        logger.info("update board Id : " + boardId);

        //
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        Optional<Board> findBoard = boardRepository.findByBoardTitleAndBoardIdNot(boardDTO.getTitle(), boardId);

        if (findBoard.isPresent()) {
            throw new IllegalArgumentException("중복되는 제목이 존재합니다.");
        }

        board.setBoardTitle(boardDTO.getTitle());
        board.setBoardContent(boardDTO.getContent());
        Board savedBoard = boardRepository.save(board);
        logger.info("board updated : " + boardId);

        return new BoardDTO(savedBoard.getBoardId(), savedBoard.getBoardTitle(), savedBoard.getBoardContent());
    }

    @Transactional
    public void deleteBoard(int boardId) {
        logger.info("delete board Id : " + boardId);

        // JPA에서 ID값이 존재하는지 확인하는 메서드
        boolean result = boardRepository.existsById(boardId);

        if (!result) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다. : " + boardId);
        }

        boardRepository.deleteById(boardId);
        logger.info("board deleted : " + boardId);
    }

    public BoardDTO getBoardById(int boardId) {
        logger.info("get board Id : " + boardId);

        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시물이 존재하지 않습니다. " + boardId));
        return new BoardDTO(board.getBoardId(), board.getBoardTitle(), board.getBoardContent());
    }
}
