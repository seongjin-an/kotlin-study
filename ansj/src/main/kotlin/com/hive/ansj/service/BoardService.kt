package com.hive.ansj.service

import com.hive.ansj.cache.BoardCache
import com.hive.ansj.entity.Board
import com.hive.ansj.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BoardService {
    @Autowired
    private lateinit var boardRepository: BoardRepository

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
}