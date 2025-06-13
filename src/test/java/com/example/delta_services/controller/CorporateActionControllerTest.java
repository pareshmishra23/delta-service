
package com.example.delta_services.controller;


/*
import com.example.delta_services.controller.CorporateActionController;
import com.example.delta_services.model.CorporateAction;
import com.example.delta_services.services.CorporateActionServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(CorporateActionController.class)
public class CorporateActionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CorporateActionServices services;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testUpload() throws Exception {
        CorporateAction mockAction = new CorporateAction(1L, "TCS", LocalDate.of(2024, 2, 1),
                "Dividend", "2:1", 10.0, LocalDate.now(), LocalDate.now(), "Quarterly payout");

        Mockito.when(services.save(ArgumentMatchers.any(CorporateAction.class))).thenReturn(mockAction);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/corporate-actions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockAction)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.ticker").value("TCS"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.actionType").value("Dividend"));
    }

    @Test
    void testGetAll() throws Exception {
        List<CorporateAction> actions = Arrays.asList(
                new CorporateAction(1L, "TCS", LocalDate.of(2024, 2, 1), "Dividend", "2:1", 10.0,
                        LocalDate.now(), LocalDate.now(), "Q1 payout"));

        Mockito.when(services.getAll()).thenReturn(actions);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/corporate-actions"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ticker").value("TCS"));
    }

    @Test
    void testDeltas() throws Exception {
        List<Map<String, Object>> mockDelta = new ArrayList<>();
        Map<String, Object> delta = new HashMap<>();
        delta.put("ticker", "TCS");
        delta.put("actionDate", LocalDate.of(2024, 2, 1));
        delta.put("ratio_delta", "2:1");
        delta.put("faceValue_delta", 4.0);
        mockDelta.add(delta);

        Mockito.when(services.getDelta("TCS")).thenReturn(mockDelta);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/corporate-actions/deltas/TCS"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ticker").value("TCS"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ratio_delta").value("2:1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].faceValue_delta").value(4.0));
    }
}

*/
