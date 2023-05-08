package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.AuthDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LoginDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.security.jwt.JwtUtils;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class) 
public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Mock
    JwtUtils jwtUtils;

    @Mock
    AuthenticationManager authenticationManager;


    @Test
    public void testValidateUserMustReturnAuthDTO() {
        final LoginDTO USER_REQUEST = new LoginDTO("cGF1ZmFuZG9z", "MTIzNDU2"); 
        final Authentication AUTHENTICATION =  new UsernamePasswordAuthenticationToken(USER_REQUEST.getName(), USER_REQUEST.getPassword());
        final AuthDTO TOKEN_EXPECTED_RESPONSE = new AuthDTO("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiY0dGMVptRnVaRzl6IiwiaWF0IjoxNjgzNTM3NDU5LCJleHAiOjI2ODM1Mzc0NTh9.1wcPPYvUA5e6FCsPvfjp073ioL_kY4plPNykmFmGvCs");

        when(authenticationManager.authenticate(AUTHENTICATION)).thenReturn(AUTHENTICATION);
        SecurityContextHolder.getContext().setAuthentication(AUTHENTICATION);
        when(jwtUtils.generateJwtToken(AUTHENTICATION)).thenReturn(TOKEN_EXPECTED_RESPONSE.token());

        String token = jwtUtils.generateJwtToken(AUTHENTICATION);

        assertEquals(TOKEN_EXPECTED_RESPONSE.token(),token);

    }
}
