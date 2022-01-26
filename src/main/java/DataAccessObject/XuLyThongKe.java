package DataAccessObject;

import DataAccessObject.SQLConnection;
import model.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;
// đã fix
public class XuLyThongKe {
    private final ArrayList<DocGia> danhSachDocGia;
    private final ArrayList<DauSach> danhSachDauSach;
    private final ArrayList<PhieuMuon> danhSachPhieuMuon;
    private final Map<String, Integer> thongKeSoLuotMuonSach;
    public XuLyThongKe() {
        danhSachDocGia = new ArrayList<>();
        danhSachDauSach = new ArrayList<>();
        danhSachPhieuMuon = new ArrayList<>();
        thongKeSoLuotMuonSach = new HashMap<>();
        Connection connection = SQLConnection.openConnection();
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dbo.DAUSACH");
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                danhSachDauSach.add(new DauSach(res.getString("ISBN"),
                        res.getString("TenDauSach"),
                        res.getString("TenLoaiSach"),
                        res.getString("TacGia"),
                        res.getString("NhaXuatBan"),
                        res.getInt("NamXuatBan")));
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM dbo.PHIEUMUON");
            res = preparedStatement.executeQuery();
            while(res.next()) {
                danhSachPhieuMuon.add(new PhieuMuon(res.getInt("MaPhieuMuon"),
                        res.getInt("MaDocGia"),
                        res.getString("MaDanhMucSach"),
                        res.getString("NgayMuon"),
                        res.getString("NgayTra"),
                        res.getInt("TrangThai")));
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM dbo.DOCGIA");
            res = preparedStatement.executeQuery();
            while(res.next()) {
                danhSachDocGia.add(new DocGia(res.getInt("MaDocGia"),
                        res.getString("Ho"),
                        res.getString("Ten"),
                        res.getBoolean("GioiTinh"),
                        res.getString("NgaySinh"),
                        res.getString("Email"),
                        res.getString("SDT"),
                        res.getBoolean("TrangThai")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (DauSach dauSach: danhSachDauSach) {
            thongKeSoLuotMuonSach.put(dauSach.getISBN(), 0);
        }
    }
    public void update(){
        danhSachDocGia.clear();
        danhSachDauSach.clear();
        danhSachPhieuMuon.clear();
        thongKeSoLuotMuonSach.clear();
        Connection connection = SQLConnection.openConnection();
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dbo.DAUSACH");
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                danhSachDauSach.add(new DauSach(res.getString("ISBN"),
                        res.getString("TenDauSach"),
                        res.getString("TenLoaiSach"),
                        res.getString("TacGia"),
                        res.getString("NhaXuatBan"),
                        res.getInt("NamXuatBan")));
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM dbo.PHIEUMUON");
            res = preparedStatement.executeQuery();
            while(res.next()) {
                danhSachPhieuMuon.add(new PhieuMuon(res.getInt("MaPhieuMuon"),
                        res.getInt("MaDocGia"),
                        res.getString("MaDanhMucSach"),
                        res.getString("NgayMuon"),
                        res.getString("NgayTra"),
                        res.getInt("TrangThai")));
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM dbo.DOCGIA");
            res = preparedStatement.executeQuery();
            while(res.next()) {
                danhSachDocGia.add(new DocGia(res.getInt("MaDocGia"),
                        res.getString("Ho"),
                        res.getString("Ten"),
                        res.getBoolean("GioiTinh"),
                        res.getString("NgaySinh"),
                        res.getString("Email"),
                        res.getString("SDT"),
                        res.getBoolean("TrangThai")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (DauSach dauSach: danhSachDauSach) {
            thongKeSoLuotMuonSach.put(dauSach.getISBN(), 0);
        }
    }
    private int timKiemTrongDanhSachDauSach(String maDauSach) {
        for (int i = 0; i < danhSachDauSach.size(); ++i) {
            if (danhSachDauSach.get(i).getISBN().equals(maDauSach)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<DauSach> thongKeSachDangMuon() {
        ArrayList<DauSach> danhSachDangMuon = new ArrayList<>();
        Set<String> tapHopMaDauSach = new HashSet<>();
        for (PhieuMuon phieuMuon: danhSachPhieuMuon) {
            int maDocGia = phieuMuon.getMaDocGia();
            int indexDocGia = timKiemTrongDanhSachDocGia(maDocGia);
            if (phieuMuon.getTrangThai() == 0 && danhSachDocGia.get(indexDocGia).getHoatDong()) {
                tapHopMaDauSach.add(phieuMuon.getMaDanhMucSach().split("-")[0]);
            }
        }
        for (String maDauSach: tapHopMaDauSach) {
            int index = timKiemTrongDanhSachDauSach(maDauSach);
            danhSachDangMuon.add(danhSachDauSach.get(index));
        }
        return danhSachDangMuon;
    }

    public ArrayList<DauSach> thongKeSachMuonNhieuNhat() {
        ArrayList<DauSach> danhSachSoLuotMuonNhieuNhat = new ArrayList<>();
        for (PhieuMuon phieuMuon: danhSachPhieuMuon) {
            String maDauSach = phieuMuon.getMaDanhMucSach().split("-")[0];
            thongKeSoLuotMuonSach.put(maDauSach, thongKeSoLuotMuonSach.get(maDauSach) + 1);
        }
        SortedSet<Map.Entry<String, Integer>> tapHopTangDan = new TreeSet<>((e1, e2)->{
            int soSanh = e1.getValue().compareTo(e2.getValue());
            if (soSanh == 0)
                return e1.getKey().compareTo(e2.getKey());
            return soSanh * (-1);
        });
        tapHopTangDan.addAll(thongKeSoLuotMuonSach.entrySet());
        int count = 0;
        for (Map.Entry<String, Integer> entry: tapHopTangDan) {
            int index = timKiemTrongDanhSachDauSach(entry.getKey());
            danhSachSoLuotMuonNhieuNhat.add(danhSachDauSach.get(index));
            count++;
            if (count == 10)
                break;
        }
        return danhSachSoLuotMuonNhieuNhat;
    }

    private int timKiemTrongDanhSachDocGia(int maDocGia) {
        for (int i = 0; i < danhSachDocGia.size(); ++i) {
            if (danhSachDocGia.get(i).getMaDocGia() == maDocGia) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<DocGia> thongKeDocGiaChuaTraSach() {
        ArrayList<DocGia> danhSachDocGiaChuaTraSach = new ArrayList<>();
        Set<Integer> tapHopMaDocGia = new HashSet<>();
        for (PhieuMuon phieuMuon: danhSachPhieuMuon) {
            int maDocGia = phieuMuon.getMaDocGia();
            int indexDocGia = timKiemTrongDanhSachDocGia(maDocGia);
            if (phieuMuon.getNgayTra() == null && danhSachDocGia.get(indexDocGia).getHoatDong()) {
                tapHopMaDocGia.add(phieuMuon.getMaDocGia());
            }
        }
        for (int maDocGia: tapHopMaDocGia) {
            int index = timKiemTrongDanhSachDocGia(maDocGia);
            danhSachDocGiaChuaTraSach.add(danhSachDocGia.get(index));
        }
        return danhSachDocGiaChuaTraSach;
    }
    private boolean kiemTraNgayQuaHan(String ngay) {
        Date homNay = new Date();
        try {
            Date ngayMuon = new SimpleDateFormat("yyyy-MM-dd").parse(ngay);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(ngayMuon);
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            Date hanTra = calendar.getTime();
            if (homNay.after(hanTra)) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<DocGia> thongKeDocGiaMuonQuaHan() {
        ArrayList<DocGia> danhSachDocGiaMuonQuaHan = new ArrayList<>();
        Set<Integer> tapHopMaDocGia = new HashSet<>();
        for (PhieuMuon phieuMuon: danhSachPhieuMuon) {
            int trangThai = phieuMuon.getTrangThai();
            int maDocGia = phieuMuon.getMaDocGia();
            int indexDocGia = timKiemTrongDanhSachDocGia(maDocGia);
            if (trangThai == 0 && kiemTraNgayQuaHan(phieuMuon.getNgayMuon()) && danhSachDocGia.get(indexDocGia).getHoatDong()) {
                tapHopMaDocGia.add(phieuMuon.getMaDocGia());
            }
        }
        for (int maDocGia: tapHopMaDocGia) {
            int index = timKiemTrongDanhSachDocGia(maDocGia);
            danhSachDocGiaMuonQuaHan.add(danhSachDocGia.get(index));
        }
        return danhSachDocGiaMuonQuaHan;
    }
}
