package com.sample.security.webapp.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.security.webapp.dto.EmployeeCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void given_valid_details_employee_should_be_created_successfully() throws Exception {
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(asJsonString(EmployeeCreateRequest.builder().firstName("First Name").middleName("Middle Name").lastName("Last Name").dateOfBirth(LocalDate.of(1982,12,31)).build()))).andExpect(status().isCreated());
    }

    public String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
