package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.AuthDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LoginDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private UserServiceImpl userServiceImpl;


    @Test
    public void testLogin() throws Exception {
        final String LOGIN_URL = "/auth/login";
        final LoginDTO REQUEST_DTO = new LoginDTO("cGF1ZmFuZG9z", "MTIzNDU2");
        final AuthDTO TOKEN_EXPECTED_RESPONSE = new AuthDTO(
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoicGF1ZmFuZG9zIiwiaWF0IjoxNjgzMTkzOTQxLCJleHAiOjE2ODMxOTQ4NDF9.0h-dzQcF_tVTUpirwr9WyUOx4VFNNKFxV8lki6duQcg");

        Mockito.when(userServiceImpl.validateUser(REQUEST_DTO)).thenReturn(TOKEN_EXPECTED_RESPONSE);
        String data = asJsonString(TOKEN_EXPECTED_RESPONSE);
        mockMvc.perform(MockMvcRequestBuilders.post(LOGIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(REQUEST_DTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(data));
    }

    public String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
