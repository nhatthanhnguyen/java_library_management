/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguye
 */
public class DauSach {
    private final String ISBN;
    private String tenDauSach;
    private final String tenLoaiSach;
    private String tacGia;
    private String nhaXuatBan;
    private int namXuatBan;

    public DauSach(String maDauSach, String tenDauSach, String tenLoaiSach, String tacGia, String nhaXuatBan, int namXuatBan) {
        this.ISBN = maDauSach;
        this.tenDauSach = tenDauSach;
        this.tenLoaiSach = tenLoaiSach;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTenDauSach() {
        return tenDauSach;
    }

    public void setTenDauSach(String tenDauSach) {
        this.tenDauSach = tenDauSach;
    }

    public String getTenLoaiSach() {
        return tenLoaiSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }
}
