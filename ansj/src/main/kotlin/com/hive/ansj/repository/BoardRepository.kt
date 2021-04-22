package com.hive.ansj.repository

import com.hive.ansj.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository: JpaRepository<Board, Int> {
    @Query("SELECT DISTINCT b FROM Board b join fetch b.replies r")
    fun customFindAll():List<Board>
}