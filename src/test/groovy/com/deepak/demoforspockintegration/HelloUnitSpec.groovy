package com.deepak.demoforspockintegration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@ContextConfiguration
//@WebMvcTest(HelloWorldController)
@WebMvcTest
class HelloUnitSpec extends Specification {

    @Autowired
    private MockMvc mockMvc


    @Unroll
    def "when I call the Helloworld return double method"() {

        given: "Helloworld double end point exists"

        when: "When I call the end point"
        mockMvc.perform(get("/double"))
                .andExpect(status().isOk())

        then: "I expect the output to be status ok and return double output of 22.0"



    }


}
