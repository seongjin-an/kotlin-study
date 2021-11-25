package com.hive.ansj.service

import com.hive.ansj.cache.BoardCache
import com.hive.ansj.entity.Board
import com.hive.ansj.entity.Replies
import com.hive.ansj.repository.BoardRepository
import com.hive.ansj.repository.RepliesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BoardService {
    @Autowired
    private lateinit var boardRepository: BoardRepository

    @Autowired
    private lateinit var repliesRepository: RepliesRepository
    @Autowired
    private lateinit var boardCache: BoardCache

    fun findAll(): List<Board>{
        return boardCache.getCache()
    }


    fun initializeCache(){
        val list = boardRepository.customFindAll()
        println("///////////////////////////////")
        list.forEach{
            println(it.toString())
        }
        println("///////////////////////////////")
        boardCache.setCache(list)
    }

    @Transactional
    fun saveImsi(){

    }


}