/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Microsoft Windows
 */
public class Nhacc {
    private String tenncc;

    @Override
    public String toString() {
        return "NhaCungCap{" + "tenncc=" + tenncc + ", mancc=" + mancc + ", email=" + email + ", nvlienhe=" + nvlienhe + ", diachi=" + diachi + ", douytin=" + douytin + ", sdt=" + sdt + '}';
    }
    private String mancc;

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNvlienhe() {
        return nvlienhe;
    }

    public void setNvlienhe(String nvlienhe) {
        this.nvlienhe = nvlienhe;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDouytin() {
        return douytin;
    }

    public void setDouytin(String douytin) {
        this.douytin = douytin;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
     private String email;
    private String  nvlienhe;
   private String   diachi;
   private String   douytin;
   private String   sdt;
    
}
