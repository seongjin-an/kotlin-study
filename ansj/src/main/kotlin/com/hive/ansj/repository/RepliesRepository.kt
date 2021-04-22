package com.hive.ansj.repository

import com.hive.ansj.entity.Replies
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RepliesRepository: JpaRepository<Replies, Int> {
}