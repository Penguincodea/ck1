/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author VI TRUNG VIET
 */
public class Customer {
    
   int MaKH;
  String TenKH;
  int NSKH;
   String DCKH;
     int Sokhoi;
   int Thanhtien;
String SDT;
    public Customer(int MaKH,String  TenKH, int NSKH, String DCKH, int Sokhoi,int Thanhtien,String SDT) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.NSKH = NSKH;
        this.DCKH = DCKH;
        this.Sokhoi = Sokhoi;
        this.SDT=SDT;
        if (this.Sokhoi <= 10) {
            Thanhtien = this.Sokhoi * 6000;
        } else if (this.Sokhoi <= 20) {
            Thanhtien = this.Sokhoi * 7000;
        } else if (this.Sokhoi <= 30) {
            Thanhtien = this.Sokhoi * 8500;
        } else {
            Thanhtien = this.Sokhoi * 16000;
        }

    }

   
    
    public Customer(String  TenKH, int NSKH, String DCKH, int Sokhoi,int Thanhtien,String SDT) {
        this.TenKH = TenKH;
        this.NSKH = NSKH;
        this.DCKH = DCKH;
        this.Sokhoi = Sokhoi;
        this.SDT=SDT;
        if (this.Sokhoi <= 10) {
            Thanhtien = this.Sokhoi * 6000;
        } else if (this.Sokhoi <= 20) {
            Thanhtien = this.Sokhoi * 7000;
        } else if (this.Sokhoi <= 30) {
            Thanhtien = this.Sokhoi * 8500;
        } else {
            Thanhtien = this.Sokhoi * 16000;
        }

    }

    public int getThanhtien() {
           if (this.Sokhoi <= 10) {
           return Thanhtien = this.Sokhoi * 6000;
        } else if (this.Sokhoi <= 20) {
          return  Thanhtien = this.Sokhoi * 7000;
        } else if (this.Sokhoi <= 30) {
           return Thanhtien = this.Sokhoi * 8500;
        } else {
           return Thanhtien = this.Sokhoi * 16000;
        }
    }
    
    
     public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setThanhtien(int Thanhtien) {
        this.Thanhtien = Thanhtien;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    
        
    
    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public int getNSKH() {
        return NSKH;
    }

    public void setNSKH(int NSKH) {
        this.NSKH = NSKH;
    }

    public String getDCKH() {
        return DCKH;
    }

    public void setDCKH(String DCKH) {
        this.DCKH = DCKH;
    }

    public int getSokhoi() {
        return Sokhoi;
    }

    public void setSokhoi(int Sokhoi) {
        this.Sokhoi = Sokhoi;
    }
    
}


