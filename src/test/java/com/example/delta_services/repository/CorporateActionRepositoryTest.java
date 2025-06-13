package com.example.delta_services.repository;

import com.example.delta_services.model.CorporateAction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CorporateActionRepositoryTest {

    @Autowired
    private CorporateActionRepository repository;

    @Test
    void testSaveAndFindByTickerOrderByActionDateAsc() {
        // given
        CorporateAction action1 = new CorporateAction();
        action1.setTicker("TCS");
        action1.setActionDate(LocalDate.of(2024, 1, 10));
        action1.setActionType("Bonus");
        action1.setRatio("2:1");
        action1.setFaceValue(10.0);
        repository.save(action1);

        CorporateAction action2 = new CorporateAction();
        action2.setTicker("TCS");
        action2.setActionDate(LocalDate.of(2024, 2, 10));
        action2.setActionType("Split");
        action2.setRatio("1:2");
        action2.setFaceValue(5.0);
        repository.save(action2);

        // when
        List<CorporateAction> actions = repository.findByTickerOrderByActionDateAsc("TCS");

        // then
        assertThat(actions).hasSize(2);
        assertThat(actions.get(0).getActionDate()).isEqualTo(LocalDate.of(2024, 1, 10));
        assertThat(actions.get(1).getFaceValue()).isEqualTo(5.0);
    }
}
