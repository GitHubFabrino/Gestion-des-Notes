package com.todoliste.myapp.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ueec")
public class UeEcModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUeEc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Ec")
    private EcModel idEc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Ue")
    private  UeModel idUe;

    @Column(name = "credit_ec")
    private BigDecimal creditec;

    @Column(name = "coefec")
    private BigDecimal coefec;

    public UeEcModel() {
    }

    public UeEcModel(int idUeEc, EcModel idEc, UeModel idUe, BigDecimal creditec, BigDecimal coefec) {
        this.idUeEc = idUeEc;
        this.idEc = idEc;
        this.idUe = idUe;
        this.creditec = creditec;
        this.coefec = coefec;
    }

    public UeEcModel(EcModel idEc, UeModel idUe, BigDecimal creditec, BigDecimal coefec) {
        this.idEc = idEc;
        this.idUe = idUe;
        this.creditec = creditec;
        this.coefec = coefec;
    }

    public int getIdUeEc() {
        return idUeEc;
    }

    public void setIdUeEc(int idUeEc) {
        this.idUeEc = idUeEc;
    }

    public EcModel getIdEc() {
        return idEc;
    }

    public void setIdEc(EcModel idEc) {
        this.idEc = idEc;
    }

    public UeModel getIdUe() {
        return idUe;
    }

    public void setIdUe(UeModel idUe) {
        this.idUe = idUe;
    }

    public BigDecimal getCreditec() {
        return creditec;
    }

    public void setCreditec(BigDecimal creditec) {
        this.creditec = creditec;
    }

    public BigDecimal getCoefec() {
        return coefec;
    }

    public void setCoefec(BigDecimal coefec) {
        this.coefec = coefec;
    }
}
