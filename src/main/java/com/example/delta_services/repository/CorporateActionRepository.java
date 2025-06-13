package com.example.delta_services.repository;

import com.example.delta_services.model.CorporateAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CorporateActionRepository extends JpaRepository<CorporateAction, Long> {

  List<CorporateAction> findByTickerOrderByActionDateAsc(String ticker);
}
