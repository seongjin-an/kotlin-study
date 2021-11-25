package com.hive.ansj.service

import com.hive.ansj.entity.Test
import com.hive.ansj.repository.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TestService {
    @Autowired
    private lateinit var testRepository: TestRepository

    fun saveTest(){
        val list:MutableList<Test> = mutableListOf();
        for(i in 20..30){
            val test = Test(i);
            list.add(test);
        }
        testRepository.saveAll(list);
    }

    @Transactional
    fun transaction(){
        try{
            testRepository.deleteAll();
            throw Exception("error test");
            saveTest();
        }catch(error: Exception){
            throw RuntimeException("runtime error");
        }
    }
}