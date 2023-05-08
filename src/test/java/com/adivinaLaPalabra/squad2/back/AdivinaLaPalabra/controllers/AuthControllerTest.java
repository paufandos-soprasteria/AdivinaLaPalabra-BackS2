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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userServiceImpl;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testLoginEndPointMustReturnOKStatus() throws Exception {
        final String LOGIN_URL = "/auth/login";
        final LoginDTO REQUEST_DTO = new LoginDTO("cGF1ZmFuZG9z", "MTIzNDU2");
        final LoginDTO REQUEST_BODY = new LoginDTO("Y0dGMVptRnVaRzl6", "TVRJek5EVTI=");
        final AuthDTO TOKEN_EXPECTED_RESPONSE = new AuthDTO("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiY0dGMVptRnVaRzl6IiwiaWF0IjoxNjgzNTI3MTYzLCJleHAiOjE3NzM1MjcxNjN9.cWcr1qwsbyG1BI__okiNEoYET-5tZXGcYhcUq47Ecrg");

        Mockito.when(userServiceImpl.validateUser(REQUEST_DTO)).thenReturn(TOKEN_EXPECTED_RESPONSE);

        mockMvc.perform(MockMvcRequestBuilders.post(LOGIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(REQUEST_BODY)))
                .andExpect(status().isOk());
    }

    @Test
    public void testLoginEndPointWithNonAuthUserMustReturnUnauthorizedStatus() throws Exception {
        // TO DO
    }


    public String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
