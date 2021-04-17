package com.hive.ansj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class AnsjApplication

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
