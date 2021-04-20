package com.hive.ansj.service

import org.junit.jupiter.api.Test


class RegularTest {

    @Test
    fun regularTest(){
        val http1 = "http://localhost:8080"
        val httpRegex = Regex("http")
        val http1Result = httpRegex.find(http1)
        http1Result!!.range.forEach{println(it)}//0 1 2 3
        println(http1Result.value)//http

        val tRegex = Regex("t")
        val tResult = tRegex.find(http1)
        tResult!!.range.forEach{println(it)}//1
        println(tResult.value)//t //최초의 t인덱스 하나만..

        val tsResult = tRegex.findAll(http1)
        tsResult.iterator().forEach{println(it.value)}// t t t

    }

}