package com.deepak

import com.deepak.demoforspockintegration.DemoForSpockIntegrationApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT ,classes = DemoForSpockIntegrationApplication.class)
//@WebMvcTest
class HelloSpec extends Specification {

    @Autowired
    private TestRestTemplate restTemplate

    @LocalServerPort
    private int port;

    def setup() {
        println "Setup"
    }

    def cleanup() {
        println "Clean up"
    }

    def setupSpec() {
        println "Setup specification"
    }

    def cleanupSpec() {
        println "Clean up specification"
    }

    @Unroll
    def "when I call the Helloworld return double method"() {

        given:

        when:
        ResponseEntity<Double> entity = restTemplate.exchange(createURLWithPort("/double"),HttpMethod.GET, null, Double.class)

        then:
        entity.statusCode == HttpStatus.OK

        println(entity)

        assert entity.getStatusCodeValue() == 200
        assert entity.getBody() == 22.0

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}