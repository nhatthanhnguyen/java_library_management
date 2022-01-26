package DataAccessObject;

import DataAccessObject.SQLConnection;
import UI.TrangChu;
import com.toedter.calendar.JDateChooser;
import model.DocGia;
import process.ChuanHoaChuoi;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XuLyQuanLyDocGia {
    private ArrayList<DocGia> danhSachDocGia;
    public static final int LOI_HO = 0;
    public static final int LOI_TEN = 1;
    public static final int LOI_EMAIL = 2;
    public static final int LOI_NGAY_SINH = 3;
    public static final int LOI_SDT = 4;
    public static final int THANH_CONG = 5;
    public static final int LOI_BAT_DINH = 6;
    public XuLyQuanLyDocGia() {
        danhSachDocGia = new ArrayList<DocGia>();
        Connection connection = SQLConnection.openConnection();
        try {
            assert connection != null;
            Statement stm = connection.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM dbo.DOCGIA");
            while(res.next()) {
                danhSachDocGia.add(new DocGia(Integer.parseInt(res.getString("MaDocGia")),
                        res.getString("Ho"),
                        res.getString("Ten"),
                        res.getString("GioiTinh").equals("1"),
                        res.getString("NgaySinh"),
                        res.getString("Email"),
                        res.getString("SDT"),
                        res.getBoolean("TrangThai")));
            }
            res.close();
            stm.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DocGia> getDanhSachDocGia() {
        return danhSachDocGia;
    }

    private boolean checkInList(int maDocGia) {
        for (DocGia docGia: danhSachDocGia) {
            if (docGia.getMaDocGia() == maDocGia){
                return true;
            }
        }
        return false;
    }
    public int themDocGia(String ho, String ten, boolean gioiTinh, java.util.Date ngaySinh, String email, String sdt) {
        ChuanHoaChuoi chuanHoa = new ChuanHoaChuoi(ho);
        chuanHoa.chuanHoaCap4();
        ho = chuanHoa.getString();
        if (ho.equals("")) {
            return LOI_HO;
        }
        chuanHoa.setString(ten);
        chuanHoa.chuanHoaCap4();
        ten = chuanHoa.getString();
        if (ten.equals("")) {
            return LOI_TEN;
        }
        if (ngaySinh.toString().equals("") || ngaySinh.toString() == null) {
            return LOI_NGAY_SINH;
        } else {
            java.util.Date now = new java.util.Date();
            if (ngaySinh.after(now)) {
                return LOI_NGAY_SINH;
            }
        }
        chuanHoa.setString(email);
        chuanHoa.chuanHoaCap1();
        email = chuanHoa.getString();
        if (email.equals("")) {
            return LOI_EMAIL;
        } else {
            String regex = "^[a-zA-Z][\\\\w-]+@([\\\\w]+\\\\.[\\\\w]+|[\\\\w]+\\\\.[\\\\w]{2,}\\\\.[\\\\w]{2,})$\n";
            if (!email.matches(regex)) {
                return LOI_EMAIL;
            }
        }
        chuanHoa.setString(sdt);
        chuanHoa.chuanHoaCap1();
        sdt = chuanHoa.getString();
        if (sdt.equals("")) {
            return LOI_SDT;
        } else {
            if (sdt.length() < 10 || sdt.length() > 11 || !sdt.startsWith("0")) {
                return LOI_SDT;
            }
        }
        Random random = new Random();
        int maDocGia = 0;
        while(checkInList(maDocGia) || maDocGia == 0) {
            maDocGia = random.nextInt(99999) + 10000;
        }
        String query = "INSERT INTO dbo.DOCGIA VALUES (?,?,?,?,?,?,?,?)";
        Connection connection = SQLConnection.openConnection();
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maDocGia);
            preparedStatement.setString(2, ho);
            preparedStatement.setString(3, ten);
            preparedStatement.setBoolean(4, gioiTinh);
            preparedStatement.setDate(5, new Date(ngaySinh.getTime()));
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, sdt);
            preparedStatement.setString(8,"1");
            preparedStatement.executeUpdate();
            danhSachDocGia.add(new DocGia(maDocGia, ho, ten, gioiTinh, (new Date(ngaySinh.getTime())).toString(), email, sdt, true));
            preparedStatement.close();
            connection.close();
            return THANH_CONG;
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            return LOI_BAT_DINH;
        }
    }
    public int chinhSuaDocGia(int maDocGia, String ho, String ten, boolean gioiTinh, java.util.Date ngaySinh, String email, String sdt, boolean hoatDong) {
        ChuanHoaChuoi chuanHoa = new ChuanHoaChuoi(ho);
        chuanHoa.chuanHoaCap4();
        ho = chuanHoa.getString();
        if (ho.equals("")) {
            return LOI_HO;
        }
        chuanHoa.setString(ten);
        chuanHoa.chuanHoaCap4();
        ten = chuanHoa.getString();
        if (ten.equals("")) {
            return LOI_TEN;
        }
        if (ngaySinh.toString().equals("") || ngaySinh.toString() == null) {
            return LOI_NGAY_SINH;
        } else {
            java.util.Date now = new java.util.Date();
            if (ngaySinh.after(now)) {
                return LOI_NGAY_SINH;
            }
        }
        chuanHoa.setString(email);
        chuanHoa.chuanHoaCap1();
        email = chuanHoa.getString();
        if (email.equals("")) {
            return LOI_EMAIL;
        } else {
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if (!email.matches(regex)) {
                return LOI_EMAIL;
            }
        }
        chuanHoa.setString(sdt);
        chuanHoa.chuanHoaCap1();
        sdt = chuanHoa.getString();
        if (sdt.equals("")) {
            return LOI_SDT;
        } else {
            if (sdt.length() < 10 || sdt.length() > 11 || !sdt.startsWith("0")) {
                return LOI_SDT;
            }
        }
        Connection connection = SQLConnection.openConnection();
        String query = "UPDATE dbo.DOCGIA SET Ho=?, Ten=?, GioiTinh=?, NgaySinh=?, Email=?, SDT=?, TrangThai=? WHERE MaDocGia = ?";
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ho);
            preparedStatement.setString(2, ten);
            preparedStatement.setBoolean(3, gioiTinh);
            preparedStatement.setDate(4, new Date(ngaySinh.getTime()));
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, sdt);
            preparedStatement.setString(7, hoatDong ? "1" : "0");
            preparedStatement.setInt(8, maDocGia);
            preparedStatement.executeUpdate();
            for(int i = 0; i < danhSachDocGia.size(); i++){
                if(danhSachDocGia.get(i).getMaDocGia() == maDocGia){
                    danhSachDocGia.set(i, new DocGia(maDocGia, ho, ten, gioiTinh, (new Date(ngaySinh.getTime())).toString(), email, sdt, hoatDong));
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
    public int xoaDocGia(int maDocGia) {
        Connection con = SQLConnection.openConnection();
        String query = "DELETE FROM dbo.DOCGIA WHERE MaDocGia=?";
        try {
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, maDocGia);
            pstmt.executeUpdate();
            int i = -1;
            for(i = 0; i < danhSachDocGia.size(); i++){
                if(danhSachDocGia.get(i).getMaDocGia() == maDocGia){
                    break;
                }
            }
            danhSachDocGia.remove(i);
            con.close();
            pstmt.close();
            return THANH_CONG;
        } catch (SQLException e) {
            e.printStackTrace();
            return LOI_BAT_DINH;
        }
    }
}