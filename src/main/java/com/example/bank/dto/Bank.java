package com.example.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;


public class Bank {

    @JsonProperty("CDBank")
    private String CDBank;

    @JsonProperty("typ")
    private String typ;

    @JsonProperty("CDHeadBank")
    private String CDHeadBank;

    @JsonProperty("NrBank")
    private String NrBank;

    @JsonProperty("BICStatus")
    private String BICStatus;

    @JsonProperty("NmBankShort")
    private String NmBankShort;

    @JsonProperty("AdrBank")
    private String AdrBank;

    @JsonProperty("CdControl")
    private String CdControl;

    @JsonProperty("DtControl")
    private LocalDate DtControl;

    @JsonProperty("CdBankSuccessor")
    private String CdBankSuccessor;

    @JsonProperty("DTBegin")
    private LocalDate DTBegin;

    @JsonProperty("DtEnd")
    private LocalDate DtEnd;

    public Bank() {}

    public String getCDBank() {
        return CDBank;
    }

    public void setCDBank(String CDBank) {
        this.CDBank = CDBank;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getCDHeadBank() {
        return CDHeadBank;
    }

    public void setCDHeadBank(String CDHeadBank) {
        this.CDHeadBank = CDHeadBank;
    }

    public String getNrBank() {
        return NrBank;
    }

    public void setNrBank(String NrBank) {
        this.NrBank = NrBank;
    }

    public String getBICStatus() {
        return BICStatus;
    }

    public void setBICStatus(String BICStatus) {
        this.BICStatus = BICStatus;
    }

    public String getNmBankShort() {
        return NmBankShort;
    }

    public void setNmBankShort(String NmBankShort) {
        this.NmBankShort = NmBankShort;
    }

    public String getAdrBank() {
        return AdrBank;
    }

    public void setAdrBank(String AdrBank) {
        this.AdrBank = AdrBank;
    }

    public String getCdControl() {
        return CdControl;
    }

    public void setCdControl(String CdControl) {
        this.CdControl = CdControl;
    }

    public LocalDate getDtControl() {
        return DtControl;
    }

    public void setDtControl(LocalDate DtControl) {
        this.DtControl = DtControl;
    }

    public String getCdBankSuccessor() {
        return CdBankSuccessor;
    }

    public void setCdBankSuccessor(String CdBankSuccessor) {
        this.CdBankSuccessor = CdBankSuccessor;
    }

    public LocalDate getDTBegin() {
        return DTBegin;
    }

    public void setDTBegin(LocalDate DTBegin) {
        this.DTBegin = DTBegin;
    }

    public LocalDate getDtEnd() {
        return DtEnd;
    }

    public void setDtEnd(LocalDate DtEnd) {
        this.DtEnd = DtEnd;
    }


}
