/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguye
 */
public class PhieuMuon {
    private final int maPhieuMuon;
    private final int maDocGia;
    private final String maDanhMucSach;
    private final String ngayMuon;
    private String ngayTra;
    private int trangThai;

    public PhieuMuon(int maPhieuMuon, int maDocGia, String maDanhMucSach, String ngayMuon, String ngayTra, int trangThai) {
        this.maPhieuMuon = maPhieuMuon;
        this.maDocGia = maDocGia;
        this.maDanhMucSach = maDanhMucSach;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public String getMaDanhMucSach() {
        return maDanhMucSach;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
}
