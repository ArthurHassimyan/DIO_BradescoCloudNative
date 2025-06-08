package com.hassimyan.Board.repository;

import com.hassimyan.Board.Model.ReasonBlocking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockReasonRepository extends JpaRepository<ReasonBlocking, Long> {
}