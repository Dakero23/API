package co.com.api.prueba.Entidad;

import java.io.Serializable;
import java.util.Date;

public class Empresa implements Serializable {

    private int empId;
    private String tipDoc;
    private Long empDoc;
    private String empNom;

    public Empresa() {
    }

    public Empresa(
            int empId,
            String tipDoc,
            Long empDoc,
            String empNom) {
        this.empId = empId;
        this.tipDoc = tipDoc;
        this.empDoc = empDoc;
        this.empNom = empNom;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public Long getEmpDoc() {
        return empDoc;
    }

    public void setEmpDoc(Long empDoc) {
        this.empDoc = empDoc;
    }

    public String getEmpNom() {
        return empNom;
    }

    public void setEmpNom(String empNom) {
        this.empNom = empNom;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

    
}
