package com.example.delta_services.services;


import com.example.delta_services.model.CorporateAction;
import com.example.delta_services.repository.CorporateActionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CorporateActionServicesTest {

    @InjectMocks
    private CorporateActionServices services;

    @Mock
    private CorporateActionRepository repository;

    private CorporateAction action1,action2,action3 ;




    @BeforeEach
    void setup()

    {
        action1 = new CorporateAction();
        action1.setId(1);
        action1.setTicker("TCS");
        action1.setActionDate(LocalDate.of(2024, 6, 1));
        action1.setActionType("Bonus");
        action1.setRatio("1:1");
        action1.setFaceValue(1.0);
        action1.setRecordDate(LocalDate.of(2024, 6, 10));
        action1.setExdate(LocalDate.of(2024, 6, 9));
        action1.setRemark("1:1 bonus issue approved by board.");

        action2 = new CorporateAction();
        action2.setId(2);
        action2.setTicker("TCS");
        action2.setActionDate(LocalDate.of(2024, 7, 1));
        action2.setActionType("Bonus");
        action2.setRatio("2:1");
        action2.setFaceValue(1.0);
        action2.setRecordDate(LocalDate.of(2024, 7, 10));
        action2.setExdate(LocalDate.of(2024, 7, 9));
        action2.setRemark("2:1 bonus issue approved by board.");

        action3 = new CorporateAction();
        action3.setId(3);
        action3.setTicker("TCS");
        action3.setActionDate(LocalDate.of(2024, 8, 1));
        action3.setActionType("Dividend");
        action3.setRatio("2:1");
        action3.setFaceValue(1.0);
        action3.setRecordDate(LocalDate.of(2024, 8, 10));
        action3.setExdate(LocalDate.of(2024, 8, 9));
        action3.setRemark("3:1 Dividend issue approved by board.");

    }

    @Test
    void testSave_returnSaveAction() {
        when(repository.save(action1)).thenReturn(action1);
        CorporateAction dto = services.save(action1);
        assertEquals("TCS", dto.getTicker());
        verify(repository, times(1)).save(action1);
    }

    @Test
    void testgetAll(){
        when(repository.findAll()).thenReturn(List.of(action1,action2));
        List<CorporateAction> list=services.getAll();
        assertEquals(2,list.size());
        verify(repository,times(1)).findAll();

    }


    @Test
    void testDetectDelta_when_one_field_changed_should_return_Delta_Map() {
        when(repository.findByTickerOrderByActionDateAsc("TCS")).thenReturn(List.of(action1, action2, action3));
        List<Map<String, Object>> deltas = services.getDelta("TCS");
        // as the camparison for 2 action in 1 delta , and another 2 in anather delta
        assertEquals(2,deltas.size());

        Map<String ,Object> delta1 = deltas.get(0);
        assertEquals(LocalDate.of(2024, 7, 1),delta1.get("actiondate"));
        assertEquals("2:1",delta1.get("Ratio_delta"));

        Map<String ,Object> delta2 = deltas.get(1);
        assertEquals(LocalDate.of(2024, 8, 1),delta2.get("actiondate"));
        assertEquals("Dividend",delta2.get("ActionType_delta"));


    }


    }



