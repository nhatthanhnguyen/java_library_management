package process;

public class ChuanHoaChuoi {
    private String string;
    public ChuanHoaChuoi(String string) {
        this.string = string;
    }
    public void chuanHoaCap1() { // xóa khoảng trắng cuối và đầu chuỗi
        if(string.isEmpty()) return;
        string = string.trim().toLowerCase();
    }
    public void chuanHoaCap2() { // xóa khoảng trắng dư thừa ở giữa
        chuanHoaCap1();
        if (string.isEmpty()) return;
        string = string.replaceAll("\\s+", " ");
    }
    public void chuanHoaCap3() { // chữ cái đầu viết hoa
        chuanHoaCap2();
        if (string.isEmpty()) return;
        String temp = string;
        string = temp.substring(0, 1).toUpperCase() + temp.substring(1);
    }
    public void chuanHoaCap4() { // viết hoa chữ đầu mỗi từ
        chuanHoaCap2();
        if (string.isEmpty()) return;
        String[] temp = string.split(" ");
        string = "";
        for (int i = 0; i < temp.length; ++i) {
            string += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1)
                string += " ";
        }
    }
    public void chuanHoaCap5() { // viết hoa toàn bộ các ký tự
        chuanHoaCap2();
        if (string.isEmpty()) return;
        string = string.toUpperCase();
    }

    public void setString(String string) {
        this.string = string;
    }
    public String getString() {
        return string;
    }
}
