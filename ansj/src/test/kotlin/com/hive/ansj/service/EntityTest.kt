package com.hive.ansj.service

import com.hive.ansj.entity.Board
import com.hive.ansj.entity.Replies
import com.hive.ansj.repository.BoardRepository
import com.hive.ansj.repository.RepliesRepository
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
    private lateinit var testService: TestService
//    @Autowired
//    private lateinit var boardRepository: BoardRepository
//
//    @Autowired
//    private lateinit var repliesRepository: RepliesRepository
//
//    @Test
//    fun boardTest(){
//        val boards: MutableList<Board> = mutableListOf()
//        for(i in 1..5){
//            val board = Board(i,"title..$i", "content...$i")
//            boards.add(board)
//        }
//        boardRepository.saveAll(boards)
//    }
//
//    @Test
//    fun replies(){
//        val boards:List<Board> = boardRepository.findAll()
//        val replies:MutableList<Replies> = mutableListOf()
//        boards.forEach{board ->
//            for(i in 6..10){
//                replies.add(Replies(100*i,"reply..$i",board.bno))
//            }
//        }
//        repliesRepository.saveAll(replies)
//    }
//
//    @Test
//    fun list(){
//        val list:List<Board> = boardRepository.customFindAll()
//        list.forEach{i->println(i)}
//    }

    @Test
    fun saveTest(){
        testService.saveTest();
    }

    @Test
    fun transaction(){
        testService.transaction()
    }


}