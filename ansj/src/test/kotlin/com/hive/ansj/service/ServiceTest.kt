package com.hive.ansj.service

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.xml.bind.annotation.*

@SpringBootTest(
    properties = [
        "spring.config.location=" +
                "file:\${APP_HOME}/properties/application.yml" +
                ", file:\${APP_HOME}/properties/database.yml"
    ]
)
class ServiceTest {
    val easyXml = """
        <response>
            <person>
                <no>1</no>
                <name>seongjin</name>
                <age>28</age>
            </person>
        </response>
    """.trimIndent()

    data class EasyXml(val person: Person){

            data class Person(
                val no:Int,
                val name:String,
                val age:Int
            )
    }
    val easyXml2 = """
        <response>
            <store>
                <stuff>
                    <name>1</name>
                </stuff>
                <stuff>
                    <name>2</name>
                </stuff>
            </store>
        </response>
    """.trimIndent()
    data class EasyXml2(var store: Store){
        data class Store(var stuff: List<Stuff>){
            data class Stuff(var name: Int){}
        }
    }
    val sampleRequest = """
        <response>
            <samplerequest>
                <ticketNo>1</ticketNo>
                <name>jack</name>
                <couponNos>1</couponNos>
            </samplerequest>
        </response>
    """.trimIndent()
    data class Sample(val samplerequest: SampleRequest) {
        data class SampleRequest(
            val ticketNo: Int,
            val name: String,
            val couponNos: Int,
        )
    }
    val test = """
        <response>
            <imsi>
                <test>1</test>
                <test>2</test>
            </imsi>
        </response>
    """.trimIndent()
    @JacksonXmlRootElement(localName = "imsi")
    data class Imsi(val imsi: Temp? = null) {
        data class Temp(
//            @field:XmlElementWrapper(name = "test")
//            @field:XmlElement(name = "test")
            @JacksonXmlProperty(localName = "test")
            @JacksonXmlElementWrapper(useWrapping = false)
            val test: List<String>? = arrayListOf()
        )
    }
    @Test
    fun easyXml(){
        val xmlMapper = XmlMapper().registerModule(KotlinModule())
//        val xmlMapper:XmlMapper = XmlMapper().registerKotlinModule() as XmlMapper
//        val xmlMapper = jacksonObjectMapper()
        val easyObject = xmlMapper.readValue<EasyXml>(easyXml)
        println("///////////////////////")
//        val easyObject2 = xmlMapper.readValue<EasyXml2>(easyXml2)
        val sample = xmlMapper.readValue<Sample>(sampleRequest)
        println("SAMPLE: $sample")
        val tes = xmlMapper.readValue<Imsi>(test)
        println("test: $tes")
//        println("EASY2: $easyObject2")
//        Assertions.assertNotNull(easyObject)
    }
}