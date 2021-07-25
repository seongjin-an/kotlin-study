package com.hive.ansj

import com.hive.ansj.service.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
@ConfigurationPropertiesScan
class AnsjApplication{
    @Autowired
    private lateinit var boardService: BoardService
    @PostConstruct
    fun initialization(){
        boardService.initializeCache()
    }
}

fun main(args: Array<String>) {
    val appHome = System.getenv("APP_HOME")
    SpringApplicationBuilder(AnsjApplication::class.java)
        .profiles("development")
        .headless(false)
        .properties(
            "spring.config.location="+
                    "file:$appHome/properties/database.yml" +
                    ", file:$appHome/properties/application.yml"
        ).application().run(*args)
}
