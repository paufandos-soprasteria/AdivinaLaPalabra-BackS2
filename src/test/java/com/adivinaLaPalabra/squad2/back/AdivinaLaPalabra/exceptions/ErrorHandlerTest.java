package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;;

@SpringBootTest
@AutoConfigureMockMvc
public class ErrorHandlerTest {
    
        @Autowired
        MockMvc mockMvc;
    
        @Test
        void testBadURLRequestMustReturn404Status() throws Exception {
            final String BAD_URL = "/NotNonexistentURL";
            this.mockMvc.perform(MockMvcRequestBuilders.get(BAD_URL))
                    .andExpect(status().isNotFound());
        }
    }
