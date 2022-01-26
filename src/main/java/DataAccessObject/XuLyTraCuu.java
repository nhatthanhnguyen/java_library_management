package DataAccessObject;

import DataAccessObject.SQLConnection;
import model.DauSach;
import process.StringUtils;

import java.sql.*;
import java.util.ArrayList;

public class XuLyTraCuu {
    private final ArrayList<DauSach> danhSachDauSach;
    private ArrayList<String> tacGia, theLoai, nhaXuatBan, nam;
    public XuLyTraCuu() {
        danhSachDauSach = new ArrayList<>();
        tacGia = new ArrayList<>();
        theLoai = new ArrayList<>();
        nhaXuatBan = new ArrayList<>();
        nam = new ArrayList<>();
        Connection connection = SQLConnection.openConnection();
        String query = "SELECT * FROM dbo.DAUSACH";
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet res = preparedStatement.executeQuery();
            while(res.next()) {
                danhSachDauSach.add(new DauSach(
                        res.getString("ISBN"),
                        res.getString("TenDauSach"),
                        res.getString("TenLoaiSach"),
                        res.getString("TacGia"),
                        res.getString("NhaXuatBan"),
                        res.getInt("NamXuatBan")
                ));
            }
            query = "SELECT DISTINCT NamXuatBan FROM DAUSACH";
            preparedStatement = connection.prepareStatement("SELECT DISTINCT NamXuatBan FROM DAUSACH");
            res = preparedStatement.executeQuery();
            while(res.next()){
                nam.add(res.getString("NamXuatBan"));
            }
            preparedStatement = connection.prepareStatement("SELECT DISTINCT NhaXuatBan FROM DAUSACH");
            res = preparedStatement.executeQuery();
            while(res.next()){
                nhaXuatBan.add(res.getString("NhaXuatBan"));
            }
            preparedStatement = connection.prepareStatement("SELECT DISTINCT TenLoaiSach FROM DAUSACH");
            res = preparedStatement.executeQuery();
            while(res.next()){
                theLoai.add(res.getString("TenLoaiSach"));
            }
            preparedStatement = connection.prepareStatement("SELECT DISTINCT TacGia FROM DAUSACH");
            res = preparedStatement.executeQuery();
            while(res.next()){
                tacGia.add(res.getString("TacGia"));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        danhSachDauSach.clear();
        tacGia.clear();
        theLoai.clear();
        nhaXuatBan.clear();
        nam.clear();
        Connection connection = SQLConnection.openConnection();
        String query = "SELECT * FROM dbo.DAUSACH";
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet res = preparedStatement.executeQuery();
            while(res.next()) {
                danhSachDauSach.add(new DauSach(
                        res.getString("ISBN"),
                        res.getString("TenDauSach"),
                        res.getString("TenLoaiSach"),
                        res.getString("TacGia"),
                        res.getString("NhaXuatBan"),
                        res.getInt("NamXuatBan")
                ));
            }
            query = "SELECT DISTINCT NamXuatBan FROM DAUSACH";
            preparedStatement = connection.prepareStatement("SELECT DISTINCT NamXuatBan FROM DAUSACH");
            res = preparedStatement.executeQuery();
            while(res.next()){
                nam.add(res.getString("NamXuatBan"));
            }
            preparedStatement = connection.prepareStatement("SELECT DISTINCT NhaXuatBan FROM DAUSACH");
            res = preparedStatement.executeQuery();
            while(res.next()){
                nhaXuatBan.add(res.getString("NhaXuatBan"));
            }
            preparedStatement = connection.prepareStatement("SELECT DISTINCT TenLoaiSach FROM DAUSACH");
            res = preparedStatement.executeQuery();
            while(res.next()){
                theLoai.add(res.getString("TenLoaiSach"));
            }
            preparedStatement = connection.prepareStatement("SELECT DISTINCT TacGia FROM DAUSACH");
            res = preparedStatement.executeQuery();
            while(res.next()){
                tacGia.add(res.getString("TacGia"));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<DauSach> getDanhSachDauSach() {
        return danhSachDauSach;
    }

    public ArrayList<String> getTacGia() {
        return tacGia;
    }

    public ArrayList<String> getTheLoai() {
        return theLoai;
    }

    public ArrayList<String> getNhaXuatBan() {
        return nhaXuatBan;
    }

    public ArrayList<String> getNam() {
        return nam;
    }

    // trả về danh sách đã được lọc theo yêu cầu. lưu ý:
    // - để thể hiện chuỗi rỗng thì khi gọi hàm chỉ cần đặt ""
    // - để thể hiện năm xuất bản không có thì khi gọi hàm ta truyền tham số -1 vào
    public ArrayList<DauSach> danhSachDauSachLocTheo(String tenDauSach, String tenLoaiSach, int namXuatBan, String nhaXuatBan, String tenTacGia) {
        ArrayList<DauSach> danhSachDauSachDaLoc = new ArrayList<>(this.danhSachDauSach);
        if (!tenDauSach.isEmpty()) {
            if (danhSachDauSachDaLoc.isEmpty()) {
                for (DauSach dauSach : danhSachDauSach) {
                    if (StringUtils.removeAccent(dauSach.getTenDauSach()).toLowerCase().startsWith(tenDauSach)) {
                        danhSachDauSachDaLoc.add(dauSach);
                    }
                }
            } else {
                danhSachDauSachDaLoc.removeIf(e -> (!e.getTenDauSach().startsWith(tenDauSach)));
            }
        }
        if (!tenLoaiSach.isEmpty()) {
            if (danhSachDauSachDaLoc.isEmpty()) {
                for (DauSach dauSach : danhSachDauSach) {
                    if (dauSach.getTenLoaiSach().equals(tenLoaiSach)) {
                        danhSachDauSachDaLoc.add(dauSach);
                    }
                }
            } else {
                danhSachDauSachDaLoc.removeIf(e -> (!e.getTenLoaiSach().equals(tenLoaiSach)));
            }
        }
        if (namXuatBan != -1) {
            if (danhSachDauSachDaLoc.isEmpty()) {
                for (DauSach dauSach : danhSachDauSach) {
                    if (dauSach.getNamXuatBan() == namXuatBan) {
                        danhSachDauSachDaLoc.add(dauSach);
                    }
                }
            } else {
                danhSachDauSachDaLoc.removeIf(e -> (e.getNamXuatBan() != namXuatBan));
            }
        }
        if (!nhaXuatBan.isEmpty()) {
            if (danhSachDauSachDaLoc.isEmpty()) {
                for (DauSach dauSach : danhSachDauSach) {
                    if (dauSach.getNhaXuatBan().equals(nhaXuatBan)) {
                        danhSachDauSachDaLoc.add(dauSach);
                    }
                }
            } else {
                danhSachDauSachDaLoc.removeIf(e -> (!e.getNhaXuatBan().equals(nhaXuatBan)));
            }
        }
        if (!tenTacGia.isEmpty()) {
            if (danhSachDauSachDaLoc.isEmpty()) {
                for (DauSach dauSach : danhSachDauSach) {
                    if (dauSach.getTacGia().equals(tenTacGia)) {
                        danhSachDauSachDaLoc.add(dauSach);
                    }
                }
            } else {
                danhSachDauSachDaLoc.removeIf(e -> (!e.getTacGia().equals(tenTacGia)));
            }
        }
        return danhSachDauSachDaLoc;
    }
}