package com.ohgiraffers.crud.board.repository;

import com.ohgiraffers.crud.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> { // Integer는 키 타입. 해당 엔티티의 PK를 넣어주고 식별가능하게함
    Optional<Board> findByBoardTitle(String boardTitle); // select * from board where title = ?
    Optional<Board> findByBoardTitleAndBoardIdNot(String boardTitle, int boardId); // select * from board where title = ? and id not in ? -> id not in(나 자신을 제외하고) => 중복되는 제목 있는지
}
