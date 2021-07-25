package com.hive.ansj.controller

import com.hive.ansj.service.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("board")
class BoardController {
    @Autowired
    private lateinit var boardService: BoardService
    @GetMapping
    fun findAll():ResponseEntity<Any>{
        return ResponseEntity(boardService.findAll(), HttpStatus.OK)
    }
}