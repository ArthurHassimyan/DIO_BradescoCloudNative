package com.hassimyan.Board.repository;

import com.hassimyan.Board.Model.ColumnBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnBoardRepository extends JpaRepository<ColumnBoard, Long> {
}
