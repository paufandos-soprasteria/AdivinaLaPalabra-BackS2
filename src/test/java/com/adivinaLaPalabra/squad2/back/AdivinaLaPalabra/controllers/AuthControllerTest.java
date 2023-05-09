package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

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
import static com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.helpers.UtilsHelper.*;
import static com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.helpers.AuthHelper.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userServiceImpl;

    @Test
    public void testLoginEndPointMustReturnOKStatus() throws Exception {
        final LoginDTO REQUEST_BODY = new LoginDTO("Y0dGMVptRnVaRzl6", "TVRJek5EVTI=");
        
        Mockito.when(userServiceImpl.validateUser(USER_REQUEST_DTO)).thenReturn(TOKEN_EXPECTED_RESPONSE);

        mockMvc.perform(MockMvcRequestBuilders.post(LOGIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(REQUEST_BODY)))
                .andExpect(status().isOk());
    }

    @Test
    public void testLoginEndPointWithNonAuthUserMustReturnUnauthorizedStatus() throws Exception {
        // TO DO
    }
}
