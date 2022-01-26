package DataAccessObject;

import DataAccessObject.SQLConnection;
import UI.DanhMucSach;
import model.*;

import java.sql.*;
import java.util.ArrayList;

public class XuLyDanhMucSach {
    private ArrayList<DanhMucSachModel> danhsachDanhMucSach;
    public static int THANH_CONG = 1;
    public static int LOI = 0;
    public static int LOI_XOA_SACH = 2;
    private String maDauSach;
    public XuLyDanhMucSach(String maDauSachParent) {
        this.maDauSach = maDauSachParent;
        danhsachDanhMucSach = new ArrayList<>();
        Connection connection = SQLConnection.openConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DANHMUCSACH WHERE ISBN  = ?");
            preparedStatement.setString(1, maDauSachParent);
            ResultSet res = preparedStatement.executeQuery();
            while(res.next()){
                danhsachDanhMucSach.add(new DanhMucSachModel(res.getString("MaDanhMucSach"), res.getString("ISBN"), res.getString("TrangThai").equals("0") ? 0 : res.getString("TrangThai").equals("1") ? 1 : 2));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DanhMucSachModel> getDanhsachDanhMucSach() {
        return danhsachDanhMucSach;
    }

    public int themDanhMucSach(){
        if(danhsachDanhMucSach.size() > 0){
            danhsachDanhMucSach.add(new DanhMucSachModel(maDauSach + "-" + String.valueOf(danhsachDanhMucSach.size()), maDauSach,  0));
        } else {
            danhsachDanhMucSach.add(new DanhMucSachModel(maDauSach + "-0", maDauSach,  0));
        }
        int soLuongDanhMucSach = danhsachDanhMucSach.size();
        Connection connection = SQLConnection.openConnection();
        String query = "INSERT INTO dbo.DANHMUCSACH(MaDanhMucSach, ISBN, TrangThai) VALUES(?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            assert connection != null;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, danhsachDanhMucSach.get(soLuongDanhMucSach - 1).getMaDanhMucSach());
            preparedStatement.setString(2, danhsachDanhMucSach.get(soLuongDanhMucSach - 1).getMaDauSach());
            preparedStatement.setInt(3, 0);
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
            return THANH_CONG;
        } catch (SQLException e) {
            e.printStackTrace();
            return LOI;
        }
    }
    public int chinhSuaDanhMucSach(int index, int selected){
        danhsachDanhMucSach.get(index).setTrangThaiSach(selected);
        Connection connection = SQLConnection.openConnection();
        String query = "UPDATE dbo.DANHMUCSACH SET TrangThai = ? WHERE MaDanhMucSach = ?";
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(selected));
            preparedStatement.setString(2, danhsachDanhMucSach.get(index).getMaDanhMucSach());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
            return THANH_CONG;
        } catch (SQLException e) {
            e.printStackTrace();
            return LOI;
        }
    }
    public int xoaDanhMucSach(int index){
        if(danhsachDanhMucSach.get(index).getTrangThaiSach() != 2){
            return LOI_XOA_SACH;
        }
        danhsachDanhMucSach.remove(index);
        Connection connection = SQLConnection.openConnection();
        String query = "DELETE FROM dbo.DANHMUCSACH WHERE MaDanhMucSach=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, danhsachDanhMucSach.get(index).getMaDanhMucSach());
            preparedStatement.executeUpdate();
            danhsachDanhMucSach.remove(index);
            preparedStatement.close();
            connection.close();
            return THANH_CONG;
        } catch (SQLException e) {
            e.printStackTrace();
            return LOI;
        }
    }
}
