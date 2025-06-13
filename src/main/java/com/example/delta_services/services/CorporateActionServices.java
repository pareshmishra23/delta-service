package com.example.delta_services.services;

import com.example.delta_services.model.CorporateAction;
import com.example.delta_services.repository.CorporateActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CorporateActionServices {

    @Autowired
    private CorporateActionRepository corporateActionRepository;

    public CorporateAction save(CorporateAction dto){
        return  corporateActionRepository.save(dto);
    }

    public List<CorporateAction> getAll(){

      return corporateActionRepository.findAll();
    }
    public List<CorporateAction> saveAll(List<CorporateAction> actions) {
        return corporateActionRepository.saveAll(actions);
    }


/*
Delta Detection Logic
Detect change in any of these fields over time: actionType, ratio, faceValue.

 */
    public List<Map<String, Object >> getDelta(String ticker){
        List<CorporateAction> actions= corporateActionRepository.findByTickerOrderByActionDateAsc(ticker);
        List<Map<String, Object>> deltas= new ArrayList<>();

        for(int i=1;i<actions.size();i++){

            CorporateAction prev= actions.get(i-1);
            CorporateAction curr= actions.get(i);

            Map<String, Object> delta= new LinkedHashMap<>();
            delta.put("ticker",curr.getTicker());
            delta.put("actiondate",curr.getActionDate());
            if(!Objects.equals(curr.getRatio(),prev.getRatio())){
                delta.put("Ratio_delta",curr.getRatio());
            }
            if(!Objects.equals(curr.getActionType(),prev.getActionType())){
                delta.put("ActionType_delta",curr.getActionType());
            }
            if(!Objects.equals(curr.getFaceValue(),prev.getFaceValue())){
                delta.put("FaceValue_delta",curr.getFaceValue());
            }
           if(!delta.isEmpty()){
               deltas.add(delta);
           }
        }
        return deltas;
    }
}
