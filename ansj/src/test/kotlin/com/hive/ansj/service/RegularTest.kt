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

        println(tRegex.pattern)//패턴

        println(httpRegex.containsMatchIn(http1))//Indicates whether the regular expression can find at least one match in the specified input.
        println(httpRegex.matches(http1))//Indicates whether the regular expression matches the entire input.
        println(httpRegex.matchEntire(http1))//An instance of MatchResult if the entire input matches or null otherwise.


        println(httpRegex.replace(http1, "hi"))

    }

}