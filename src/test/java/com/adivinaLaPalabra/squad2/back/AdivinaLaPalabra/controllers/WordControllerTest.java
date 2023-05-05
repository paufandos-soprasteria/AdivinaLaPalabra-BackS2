package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LetterDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.WordServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.request.ValidatePositionsRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.UUID;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WordControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    WordServiceImpl wordService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testCheckIfwordExtistMustReturnOKStatus() throws Exception {
        final String OK_URL = "/checkIfWordExists/word";

        this.mockMvc.perform(MockMvcRequestBuilders.get(OK_URL))
                .andExpect(status().isOk());
    }

    @Test
    public void testEndPointValidatePositionsReturnOkStatus() throws Exception {
        final UUID GAME_ID = UUID.randomUUID();
        final String VALIDATE_POSITIONS_URL = "/validatePositions/{game_id}";
        ValidatePositionsRequest requestBody = new ValidatePositionsRequest('h', 'a', 'l', 'l', 'a');
        final String REQUEST_WORD = "halla";

        final List<LetterDTO> EXPECTED_LIST = List.of(
                new LetterDTO('h', LetterDTO.Status.NOT_MATCHED,0),
                new LetterDTO('a', LetterDTO.Status.MATCHED,1),
                new LetterDTO('l', LetterDTO.Status.NOT_MATCHED,2),
                new LetterDTO('l', LetterDTO.Status.NOT_MATCHED,3),
                new LetterDTO('a', LetterDTO.Status.MATCHED,4)
        );

        final String data = "[\n" +
                "    {\n" +
                "        \"letter\": \"h\",\n" +
                "        \"status\": \"NOT_MATCHED\",\n" +
                "        \"position\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"letter\": \"a\",\n" +
                "        \"status\": \"MATCHED\",\n" +
                "        \"position\": 1\n" +
                "    },\n" +
                "    {\n" +
                "        \"letter\": \"l\",\n" +
                "        \"status\": \"NOT_MATCHED\",\n" +
                "        \"position\": 2\n" +
                "    },\n" +
                "    {\n" +
                "        \"letter\": \"l\",\n" +
                "        \"status\": \"NOT_MATCHED\",\n" +
                "        \"position\": 3\n" +
                "    },\n" +
                "    {\n" +
                "        \"letter\": \"a\",\n" +
                "        \"status\": \"MATCHED\",\n" +
                "        \"position\": 4\n" +
                "    }\n" +
                "]";

        when(wordService.validatePositions(REQUEST_WORD,GAME_ID)).thenReturn(EXPECTED_LIST);

        this.mockMvc.perform(MockMvcRequestBuilders.post(VALIDATE_POSITIONS_URL, GAME_ID)
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk())
                .andExpect(content().json(data));
    }

}
