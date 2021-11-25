package com.hive.ansj.repository

import com.hive.ansj.entity.Test
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository: JpaRepository<Test, Int> {
}