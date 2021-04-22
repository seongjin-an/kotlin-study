package com.hive.ansj.service

import com.hive.ansj.entity.Board
import com.hive.ansj.repository.BoardRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    properties = [
        "spring.config.location=" +
                "file:\${APP_HOME}/properties/application.yml" +
                ", file:\${APP_HOME}/properties/database.yml"
    ]
)
class EntityTest {

    @Autowired
    private lateinit var boardRepository: BoardRepository

    @Test
    fun entityTest(){
        val boardList: MutableList<Board> = mutableListOf()
        for(i in 1..10){
            Board(i,"title..$i", "content...$i")
            boardList.add()
        }
    }

}