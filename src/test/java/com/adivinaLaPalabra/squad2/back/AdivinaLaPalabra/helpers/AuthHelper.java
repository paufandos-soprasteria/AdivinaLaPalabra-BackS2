package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.helpers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.AuthDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LoginDTO;

public class AuthHelper {

    public static final String LOGIN_URL = "/auth/login";

    public static final String AUTH_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiY0dGMVptRnVaRzl6IiwiaWF0IjoxNjgzNTM3NDU5LCJleHAiOjI2ODM1Mzc0NTh9.1wcPPYvUA5e6FCsPvfjp073ioL_kY4plPNykmFmGvCs";

    public static final LoginDTO USER_REQUEST_DTO = new LoginDTO("cGF1ZmFuZG9z", "MTIzNDU2");

    public static final AuthDTO TOKEN_EXPECTED_RESPONSE = new AuthDTO(AUTH_TOKEN);
}