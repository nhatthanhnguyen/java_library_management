package DataAccessObject;

import DataAccessObject.SQLConnection;
import UI.TrangChu;
import model.DanhMucSachModel;
import model.DauSach;
import process.ChuanHoaChuoi;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

public class XuLyQuanLySach {
    private ArrayList<DauSach> danhSachDauSach;
    private ArrayList<DanhMucSachModel> danhSachDanhMucSach;
    public static int LOI_ISBN = 0;
    public static int LOI_ISBN_TRUNG = 8;
    public static int LOI_TEN_SACH = 1;
    public static int LOI_THE_LOAI = 2;
    public static int LOI_TAC_GIA = 3;
    public static int LOI_NHA_XUAT_BAN = 4;
    public static int LOI_NAM_XUAT_BAN = 5;
    public static int THANH_CONG = 6;
    public static int LOI_BAT_DINH = 7;
    public static int LOI_XOA = 9;
    public XuLyQuanLySach() {
        danhSachDanhMucSach = new ArrayList<>();
        danhSachDauSach = new ArrayList<>();

        Connection connection = SQLConnection.openConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM dbo.DAUSACH");
            while(res.next()){
                danhSachDauSach.add(new DauSach(res.getString("ISBN"), res.getString("TenDauSach"), res.getString("TenLoaiSach"), res.getString("TacGia"), res.getString("NhaXuatBan"), res.getInt("NamXuatBan")));
            }
            res = statement.executeQuery("SELECT * FROM dbo.DANHMUCSACH");
            while(res.next()){
                danhSachDanhMucSach.add(new DanhMucSachModel(res.getString("MaDanhMucSach"), res.getString("ISBN"), Integer.parseInt(res.getString("TrangThai"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DauSach> getDanhSachDauSach() {
        return danhSachDauSach;
    }

    public ArrayList<DanhMucSachModel> getDanhSachDanhMucSach() {
        return danhSachDanhMucSach;
    }

    public int themSach(String ISBN, String tenDauSach, String tenLoaiSach, String tacGia, String nhaXuatBan, String namXuatBan){
        ChuanHoaChuoi chuanHoaChuoi = new ChuanHoaChuoi(ISBN);
        chuanHoaChuoi.chuanHoaCap5();
        ISBN = chuanHoaChuoi.getString();
        if(ISBN.equals("")){
            return LOI_ISBN;
        }
        chuanHoaChuoi.setString(tenDauSach);
        chuanHoaChuoi.chuanHoaCap4();
        tenDauSach = chuanHoaChuoi.getString();
        if(tenDauSach.equals("")){
            return LOI_TEN_SACH;
        }
        chuanHoaChuoi.setString(tenLoaiSach);
        chuanHoaChuoi.chuanHoaCap3();
        tenLoaiSach = chuanHoaChuoi.getString();
        if(tenLoaiSach.equals("")){
            return LOI_THE_LOAI;
        }
        chuanHoaChuoi.setString(tacGia);
        chuanHoaChuoi.chuanHoaCap4();
        tacGia = chuanHoaChuoi.getString();
        if(tacGia.equals("")){
            return LOI_TAC_GIA;
        }
        chuanHoaChuoi.setString(nhaXuatBan);
        chuanHoaChuoi.chuanHoaCap5();
        nhaXuatBan = chuanHoaChuoi.getString();
        if(nhaXuatBan.equals("")){
            return LOI_NHA_XUAT_BAN;
        }
        chuanHoaChuoi.setString(namXuatBan);
        chuanHoaChuoi.chuanHoaCap1();
        namXuatBan = chuanHoaChuoi.getString();
        if(namXuatBan.equals("")){
            return LOI_NAM_XUAT_BAN;
        } else {
            Date bayGio = new Date();
            try {
                Date namDuocChon = (Date) new SimpleDateFormat("yyyy").parse(namXuatBan);
                if (namDuocChon.after(bayGio)) {
                    return LOI_NAM_XUAT_BAN;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        for(DauSach it:danhSachDauSach){
            if(ISBN.equals(it.getISBN())){
                return LOI_ISBN_TRUNG;
            }
        }
        danhSachDauSach.add(new DauSach(ISBN, tenDauSach, tenLoaiSach, tacGia, nhaXuatBan, Integer.parseInt(namXuatBan)));
        Connection connection = SQLConnection.openConnection();
        String query = "INSERT INTO dbo.DAUSACH(ISBN, TenLoaiSach, TenDauSach, TacGia, NhaXuatBan, NamXuatBan) VALUES(?,?,?,?,?,?)";
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ISBN);
            preparedStatement.setString(2, tenLoaiSach);
            preparedStatement.setString(3, tenDauSach);
            preparedStatement.setString(4, tacGia);
            preparedStatement.setString(5, nhaXuatBan);
            preparedStatement.setInt(6, Integer.parseInt(namXuatBan));
            int addSuccess = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            if(addSuccess == 1) {
                return THANH_CONG;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LOI_BAT_DINH;
    }
    public int chinhSuaSach(String ISBN, String tenDauSach, String tenLoaiSach, String tacGia, String nhaXuatBan, String namXuatBan){
        ChuanHoaChuoi chuanHoaChuoi = new ChuanHoaChuoi(ISBN);
        chuanHoaChuoi.chuanHoaCap5();
        ISBN = chuanHoaChuoi.getString();
        if(ISBN.equals("")){
            return LOI_ISBN;
        }
        chuanHoaChuoi.setString(tenDauSach);
        chuanHoaChuoi.chuanHoaCap4();
        tenDauSach = chuanHoaChuoi.getString();
        if(tenDauSach.equals("")){
            return LOI_TEN_SACH;
        }
        chuanHoaChuoi.setString(tenLoaiSach);
        chuanHoaChuoi.chuanHoaCap3();
        tenLoaiSach = chuanHoaChuoi.getString();
        if(tenLoaiSach.equals("")){
            return LOI_THE_LOAI;
        }
        chuanHoaChuoi.setString(tacGia);
        chuanHoaChuoi.chuanHoaCap4();
        tacGia = chuanHoaChuoi.getString();
        if(tacGia.equals("")){
            return LOI_TAC_GIA;
        }
        chuanHoaChuoi.setString(nhaXuatBan);
        chuanHoaChuoi.chuanHoaCap5();
        nhaXuatBan = chuanHoaChuoi.getString();
        if(nhaXuatBan.equals("")){
            return LOI_NHA_XUAT_BAN;
        }
        chuanHoaChuoi.setString(namXuatBan);
        chuanHoaChuoi.chuanHoaCap1();
        namXuatBan = chuanHoaChuoi.getString();
        if(namXuatBan.equals("")){
            return LOI_NAM_XUAT_BAN;
        } else {
            Date bayGio = new Date();
            try {
                Date namDuocChon = (Date) new SimpleDateFormat("yyyy").parse(namXuatBan);
                if (namDuocChon.after(bayGio)) {
                    return LOI_NAM_XUAT_BAN;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Connection connection = SQLConnection.openConnection();
        String query = "UPDATE dbo.DAUSACH SET TenLoaiSach=?, TenDauSach=?, TacGia=?, NhaXuatBan=?, NamXuatBan=? WHERE ISBN = ?";
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(6, ISBN);
            preparedStatement.setString(1, tenLoaiSach);
            preparedStatement.setString(2, tenDauSach);
            preparedStatement.setString(3, tacGia);
            preparedStatement.setString(4, nhaXuatBan);
            preparedStatement.setInt(5, Integer.parseInt(namXuatBan));
            preparedStatement.executeUpdate();
            for(int i = 0; i < danhSachDauSach.size(); i++){
                if(ISBN.equals(danhSachDauSach.get(i).getISBN())){
                    System.out.println(namXuatBan);
                    danhSachDauSach.set(i, new DauSach(ISBN, tenDauSach, tenLoaiSach, tacGia, nhaXuatBan, Integer.parseInt(namXuatBan)));
                    break;
                }
            }
            preparedStatement.close();
            connection.close();
            return THANH_CONG;
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            return LOI_BAT_DINH;
        }
    }
    public int xoaSach(int index){
        Connection connection = SQLConnection.openConnection();
        int soLuongDanhMucSach = 0;
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(MaDanhMucSach) FROM dbo.DANHMUCSACH WHERE ISBN =?");
            preparedStatement.setString(1, danhSachDanhMucSach.get(index).getMaDauSach());
            ResultSet res = preparedStatement.executeQuery();
            if(res.next()){
                soLuongDanhMucSach = res.getInt(1);
            }
            res.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(soLuongDanhMucSach > 0){
            return LOI_XOA;
        }
        String query = "DELETE FROM dbo.DAUSACH WHERE ISBN=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, danhSachDauSach.get(index).getISBN());
            pstmt.executeUpdate();
            danhSachDauSach.remove(index);
            pstmt.close();
            connection.close();
            return THANH_CONG;
        } catch (SQLException e) {
            e.printStackTrace();
            return LOI_BAT_DINH;
        }
    }
}
