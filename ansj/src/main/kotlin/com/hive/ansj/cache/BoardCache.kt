package com.hive.ansj.cache
import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import com.hive.ansj.entity.Board
import org.springframework.stereotype.Component

@Component
class BoardCache {

    private var cache: Cache<String, List<Board>>

    constructor(){
        this.cache = CacheBuilder.newBuilder().build()
    }

    fun setCache(list: List<Board>){
        cache.put("board", list)
    }

    fun getCache():List<Board>{
        val map: Map<String, List<Board>> = cache.asMap()
        val list: List<Board> = map.get("board")!!
        return list
    }

}