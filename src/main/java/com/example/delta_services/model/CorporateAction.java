package com.example.delta_services.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "corporate_actions")
public class CorporateAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;

    private String ticker;

    private LocalDate actionDate;

    private String actionType ;

    private String ratio;

    private Double faceValue;

    private LocalDate recordDate;

    private LocalDate exdate;

    private String remark;

    public CorporateAction(long l, String tcs, LocalDate of, String dividend, String s, double v, LocalDate now, LocalDate now1, String quarterlyPayout) {
    }

    public CorporateAction() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDate actionDate) {
        this.actionDate = actionDate;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public Double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Double faceValue) {
        this.faceValue = faceValue;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public LocalDate getExdate() {
        return exdate;
    }

    public void setExdate(LocalDate exdate) {
        this.exdate = exdate;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /*public CorporateActionDTO(String tcs, LocalDate of, String bonus, double v, LocalDate of1, LocalDate of2) {
    }*/
}
