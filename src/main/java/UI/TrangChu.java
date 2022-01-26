/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import DataAccessObject.*;

import java.awt.event.KeyEvent;

import com.toedter.calendar.JTextFieldDateEditor;
import model.*;

import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import process.*;
import process.Process;

public class TrangChu extends javax.swing.JFrame {

    private DefaultTableModel modelManagement;
    private int selectedRowIndex = -1;
    private XuLyQuanLySach xuLyQuanLySach;
    private XuLyQuanLyDocGia xuLyQuanLyDocGia;
    private XuLyThongKe xuLyThongKe;
    private XuLyTraCuu xuLyTraCuu;
    private final int QUAN_LY_DOC_GIA = 0;
    private final int QUAN_LY_SACH = 1;
    private final int QUAN_LY_MUON_TRA = 2;
    private final int THONG_KE_DOC_GIA_QUA_HAN = 6;
    private final int THONG_KE_DOC_GIA_CHUA_TRA = 7;
    private final int THONG_KE_SACH_MUON_NHIEU_NHAT = 8;
    private final int THONG_KE_SACH_DANG_DUOC_MUON = 9;
    private int dangNhapTai = 0;
    private final int TRA_CUU = 10;
    private String traCuuTenSach = "";
    private String traCuuTenLoaiSach = "";
    private String traCuuNhaXuatBan = "";
    private String traCuuTacGia = "";
    private int traCuuNamXuatBan = -1;

    public TrangChu() {
        //Front_end
        initComponents();
        setVisible(true);
        setResizable(false);
        setTitle("Library Management");
        logoutButton.setFocusPainted(false);
        themSachButton.setFocusPainted(false);
        themDocGiaButton.setFocusPainted(false);
        xoaDocGiaButton.setFocusPainted(false);
        chinhSuaDocGiaButton.setFocusPainted(false);
        logoutButton.setFocusPainted(false);
        chinhSuaSachButton.setFocusPainted(false);
        maDocGia.setEditable(false);
        hoatDongRadioButton.setSelected(!hoatDongRadioButton.isSelected());
        namRadioButton.setSelected(!namRadioButton.isSelected());

        //Back-end
        xuLyQuanLySach = new XuLyQuanLySach();
        xuLyQuanLyDocGia = new XuLyQuanLyDocGia();
        xuLyThongKe = new XuLyThongKe();
        xuLyTraCuu = new XuLyTraCuu();
        theLoaiComboBox.addItem("");
        for(String item:xuLyTraCuu.getTheLoai()){
            theLoaiComboBox.addItem(item);
        }
        namComBoBox.addItem("");
        for(String item:xuLyTraCuu.getNam()){
            namComBoBox.addItem(String.valueOf(item));
        }
        nhaXuatBanComboBox.addItem("");
        for(String item:xuLyTraCuu.getNhaXuatBan()){
            nhaXuatBanComboBox.addItem(item);
        }
        tacGiaComboBox.addItem("");
        for(String item:xuLyTraCuu.getTacGia()){
            tacGiaComboBox.addItem(item);
        }
        khoiTaoBang("", QUAN_LY_DOC_GIA);
        khoiTaoBang("", QUAN_LY_SACH);
        khoiTaoBang("", QUAN_LY_MUON_TRA);
        khoiTaoBang("", THONG_KE_DOC_GIA_QUA_HAN);
        khoiTaoBang("", THONG_KE_SACH_MUON_NHIEU_NHAT);
        khoiTaoBang("", TRA_CUU);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        sexRadioGroup = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        adjRadioGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tabChinh = new javax.swing.JTabbedPane();
        QuanLyDocGia = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        quanLyDocGiaTable = new javax.swing.JTable();
        txtReaderID = new javax.swing.JLabel();
        txtlastName = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JLabel();
        txtDayOfBirth = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        maDocGia = new javax.swing.JTextField();
        hoDocGia = new javax.swing.JTextField();
        emailDocGia = new javax.swing.JTextField();
        sdtDocGia = new javax.swing.JTextField();
        namRadioButton = new javax.swing.JRadioButton();
        nuRadioButton = new javax.swing.JRadioButton();
        txtGender = new javax.swing.JLabel();
        themDocGiaButton = new javax.swing.JButton();
        chinhSuaDocGiaButton = new javax.swing.JButton();
        xoaDocGiaButton = new javax.swing.JButton();
        txtStatus = new javax.swing.JLabel();
        hoatDongRadioButton = new javax.swing.JRadioButton();
        biKhoaRadioButton = new javax.swing.JRadioButton();
        firstName = new javax.swing.JLabel();
        tenDocGia = new javax.swing.JTextField();
        ngaySinhDocGia = new com.toedter.calendar.JDateChooser();
        QuanLySach = new javax.swing.JPanel();
        txtBookTitleID = new javax.swing.JLabel();
        txtBookType = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JLabel();
        txtBookName = new javax.swing.JLabel();
        txtPublishingYear = new javax.swing.JLabel();
        txtPublishingCompany = new javax.swing.JLabel();
        tenSach = new javax.swing.JTextField();
        maDauSach = new javax.swing.JTextField();
        theLoaiSach = new javax.swing.JTextField();
        tacGia = new javax.swing.JTextField();
        nhaXuatBan = new javax.swing.JTextField();
        namXuatBan = new javax.swing.JTextField();
        themSachButton = new javax.swing.JButton();
        chinhSuaSachButton = new javax.swing.JButton();
        xoaSachButton = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        quanLySachTable = new javax.swing.JTable();
        QuanLyMuonTra = new javax.swing.JPanel();
        QuanLyTra = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        docGiaMuonTraSachTable = new javax.swing.JTable();
        huongDanButton = new javax.swing.JButton();
        timKiemDocGiaMuonTra = new javax.swing.JTextField();
        muonSachButton = new javax.swing.JButton();
        traSachButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ThongKe = new javax.swing.JPanel();
        tabThongKe = new javax.swing.JTabbedPane();
        readerStatistics = new javax.swing.JPanel();
        txtReaderStatisticIcon = new javax.swing.JLabel();
        thongKeDocGiaComboBox = new javax.swing.JComboBox<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        thongKeDocGiaTable = new javax.swing.JTable();
        booksStatistics = new javax.swing.JPanel();
        txtBookStatisticIcon = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        thongKeSachTable = new javax.swing.JTable();
        thongKeSachComboBox = new javax.swing.JComboBox<>();
        TraCuu = new javax.swing.JPanel();
        txtSearchBook = new javax.swing.JLabel();
        timKiemSach = new javax.swing.JTextField();
        txtYearFilter = new javax.swing.JLabel();
        theLoaiComboBox = new javax.swing.JComboBox<>();
        txtCategoryFilter = new javax.swing.JLabel();
        tacGiaComboBox = new javax.swing.JComboBox<>();
        txtPublishingCompanyFilter = new javax.swing.JLabel();
        nhaXuatBanComboBox = new javax.swing.JComboBox<>();
        txtAuthorFilter = new javax.swing.JLabel();
        namComBoBox = new javax.swing.JComboBox<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        traCuuTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ptitlogo.png")))); // NOI18N);

    jLabel2.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
    jLabel2.setText("HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG");

    jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 0, 0));
    jLabel3.setText("Posts and Telecommunications Institute of Technology");

    logoutButton.setBackground(new java.awt.Color(255, 255, 255));
    logoutButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png")))); // NOI18N);
    logoutButton.setToolTipText("");
    logoutButton.setBorder(null);
    logoutButton.setBorderPainted(false);
    logoutButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            logoutButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(194, 194, 194)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logoutButton)
            .addGap(19, 19, 19))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(logoutButton)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)))
            .addContainerGap(29, Short.MAX_VALUE))
    );

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));

    tabChinh.setBackground(new java.awt.Color(153, 255, 153));
    tabChinh.setForeground(new java.awt.Color(0, 0, 0));
    tabChinh.setTabPlacement(javax.swing.JTabbedPane.LEFT);
    tabChinh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    tabChinh.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabChinhMouseClicked(evt);
        }
    });

    QuanLyDocGia.setBackground(new java.awt.Color(255, 255, 255));
    QuanLyDocGia.setForeground(new java.awt.Color(0, 0, 0));
    QuanLyDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            QuanLyDocGiaMouseClicked(evt);
        }
    });

    quanLyDocGiaTable.setBackground(new java.awt.Color(255, 255, 255));
    quanLyDocGiaTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    quanLyDocGiaTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    quanLyDocGiaTable.setForeground(new java.awt.Color(0, 0, 0));
    quanLyDocGiaTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {

        }
    ));
    quanLyDocGiaTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    quanLyDocGiaTable.setGridColor(new java.awt.Color(0, 0, 0));
    quanLyDocGiaTable.setSelectionBackground(new java.awt.Color(204, 255, 255));
    quanLyDocGiaTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
    quanLyDocGiaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    quanLyDocGiaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    quanLyDocGiaTable.setShowGrid(true);
    quanLyDocGiaTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            quanLyDocGiaTableMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(quanLyDocGiaTable);
    quanLyDocGiaTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

    txtReaderID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtReaderID.setForeground(new java.awt.Color(0, 0, 0));
    txtReaderID.setText("Mã độc giả");

    txtlastName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtlastName.setForeground(new java.awt.Color(0, 0, 0));
    txtlastName.setText("Họ");

    txtPhoneNumber.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtPhoneNumber.setForeground(new java.awt.Color(0, 0, 0));
    txtPhoneNumber.setText("Số điện thoại");

    txtDayOfBirth.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtDayOfBirth.setForeground(new java.awt.Color(0, 0, 0));
    txtDayOfBirth.setText("Ngày sinh");

    txtEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtEmail.setForeground(new java.awt.Color(0, 0, 0));
    txtEmail.setText("Email");

    maDocGia.setBackground(new java.awt.Color(255, 255, 255));


    hoDocGia.setBackground(new java.awt.Color(255, 255, 255));
    hoDocGia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    hoDocGia.setForeground(new java.awt.Color(0, 0, 0));
    hoDocGia.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            hoDocGiaKeyTyped(evt);
        }
    });

    emailDocGia.setBackground(new java.awt.Color(255, 255, 255));

    sdtDocGia.setBackground(new java.awt.Color(255, 255, 255));
    sdtDocGia.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            sdtDocGiaKeyTyped(evt);
        }
    });

    namRadioButton.setBackground(new java.awt.Color(255, 255, 255));
    sexRadioGroup.add(namRadioButton);
    namRadioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    namRadioButton.setForeground(new java.awt.Color(0, 0, 0));
    namRadioButton.setText("Nam");


    nuRadioButton.setBackground(new java.awt.Color(255, 255, 255));
    sexRadioGroup.add(nuRadioButton);
    nuRadioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    nuRadioButton.setForeground(new java.awt.Color(0, 0, 0));
    nuRadioButton.setText("Nữ");

    txtGender.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtGender.setForeground(new java.awt.Color(0, 0, 0));
    txtGender.setText("Giới tính");

    themDocGiaButton.setBackground(new java.awt.Color(255, 255, 255));
    themDocGiaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    themDocGiaButton.setForeground(new java.awt.Color(0, 0, 0));
    themDocGiaButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))));
    themDocGiaButton.setText("Thêm");
    themDocGiaButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            themDocGiaButtonActionPerformed(evt);
        }
    });

    chinhSuaDocGiaButton.setBackground(new java.awt.Color(255, 255, 255));
    chinhSuaDocGiaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    chinhSuaDocGiaButton.setForeground(new java.awt.Color(0, 0, 0));
    chinhSuaDocGiaButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))));
    chinhSuaDocGiaButton.setText("Chỉnh sửa");
    chinhSuaDocGiaButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chinhSuaDocGiaButtonActionPerformed(evt);
        }
    });

    xoaDocGiaButton.setBackground(new java.awt.Color(255, 255, 255));
    xoaDocGiaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    xoaDocGiaButton.setForeground(new java.awt.Color(0, 0, 0));
    xoaDocGiaButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))));
    xoaDocGiaButton.setText("Xóa");
    xoaDocGiaButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            xoaDocGiaButtonActionPerformed(evt);
        }
    });

    txtStatus.setBackground(new java.awt.Color(255, 255, 255));
    txtStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtStatus.setForeground(new java.awt.Color(0, 0, 0));
    txtStatus.setText("Trạng thái");

    hoatDongRadioButton.setBackground(new java.awt.Color(255, 255, 255));
    adjRadioGroup.add(hoatDongRadioButton);
    hoatDongRadioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    hoatDongRadioButton.setForeground(new java.awt.Color(0, 0, 0));
    hoatDongRadioButton.setText("Hoạt động");

    biKhoaRadioButton.setBackground(new java.awt.Color(255, 255, 255));
    adjRadioGroup.add(biKhoaRadioButton);
    biKhoaRadioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    biKhoaRadioButton.setForeground(new java.awt.Color(0, 0, 0));
    biKhoaRadioButton.setText("Bị khóa");

    firstName.setBackground(new java.awt.Color(255, 255, 255));
    firstName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    firstName.setForeground(new java.awt.Color(0, 0, 0));
    firstName.setText("Tên");

    tenDocGia.setBackground(new java.awt.Color(255, 255, 255));
    tenDocGia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    tenDocGia.setForeground(new java.awt.Color(0, 0, 0));
    tenDocGia.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            tenDocGiaKeyTyped(evt);
        }
    });

    ngaySinhDocGia.setBackground(new java.awt.Color(255, 255, 255));
    ngaySinhDocGia.setForeground(new java.awt.Color(0, 0, 0));
    JTextFieldDateEditor editor = (JTextFieldDateEditor)ngaySinhDocGia.getDateEditor();
    editor.setEditable(false);

    javax.swing.GroupLayout QuanLyDocGiaLayout = new javax.swing.GroupLayout(QuanLyDocGia);
    QuanLyDocGia.setLayout(QuanLyDocGiaLayout);
    QuanLyDocGiaLayout.setHorizontalGroup(
        QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
            .addGap(47, 47, 47)
            .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(txtlastName, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addComponent(txtReaderID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(firstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
                    .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
                            .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(maDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hoDocGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(27, 262, Short.MAX_VALUE)
                            .addComponent(emailDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDayOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(sdtDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(ngaySinhDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
                            .addComponent(hoatDongRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3)
                            .addComponent(biKhoaRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(themDocGiaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(55, 55, 55)
                            .addComponent(chinhSuaDocGiaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(xoaDocGiaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(54, 54, 54))
                .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
                    .addComponent(namRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(nuRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2)
            .addContainerGap())
    );
    QuanLyDocGiaLayout.setVerticalGroup(
        QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuanLyDocGiaLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtEmail)
                .addComponent(emailDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(maDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtReaderID))
            .addGap(18, 18, 18)
            .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
                    .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtlastName)
                        .addComponent(hoDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(firstName)
                        .addComponent(tenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
                    .addComponent(txtDayOfBirth)
                    .addGap(18, 18, 18)
                    .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sdtDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(ngaySinhDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(10, 10, 10)
            .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtGender)
                .addComponent(namRadioButton)
                .addComponent(nuRadioButton))
            .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chinhSuaDocGiaButton)
                        .addComponent(xoaDocGiaButton)
                        .addComponent(themDocGiaButton)))
                .addGroup(QuanLyDocGiaLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStatus)
                        .addComponent(hoatDongRadioButton)
                        .addComponent(biKhoaRadioButton))))
            .addGap(37, 37, 37)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
            .addContainerGap())
    );

    tabChinh.addTab("QUẢN LÝ ĐỘC GIẢ     ", new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reading_book.png"))), QuanLyDocGia);

    QuanLySach.setBackground(new java.awt.Color(255, 255, 255));
    QuanLySach.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            QuanLySachMouseClicked(evt);
        }
    });

    txtBookTitleID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtBookTitleID.setForeground(new java.awt.Color(0, 0, 0));
    txtBookTitleID.setText("Mã đầu sách");

    txtBookType.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtBookType.setForeground(new java.awt.Color(0, 0, 0));
    txtBookType.setText("Thể loại");

    txtAuthor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtAuthor.setForeground(new java.awt.Color(0, 0, 0));
    txtAuthor.setText("Tác giả");

    txtBookName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtBookName.setForeground(new java.awt.Color(0, 0, 0));
    txtBookName.setText("Tên sách");

    txtPublishingYear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtPublishingYear.setForeground(new java.awt.Color(0, 0, 0));
    txtPublishingYear.setText("Năm xuất bản");

    txtPublishingCompany.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtPublishingCompany.setForeground(new java.awt.Color(0, 0, 0));
    txtPublishingCompany.setText("Nhà xuất bản");

    tenSach.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            tenSachKeyTyped(evt);
        }
    });

    namXuatBan.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            namXuatBanKeyTyped(evt);
        }
    });

    themSachButton.setBackground(new java.awt.Color(255, 255, 255));
    themSachButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    themSachButton.setForeground(new java.awt.Color(0, 0, 0));
    themSachButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))));
    themSachButton.setText("Thêm");
    themSachButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            themSachButtonActionPerformed(evt);
        }
    });

    chinhSuaSachButton.setBackground(new java.awt.Color(255, 255, 255));
    chinhSuaSachButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    chinhSuaSachButton.setForeground(new java.awt.Color(0, 0, 0));
    chinhSuaSachButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))));
    chinhSuaSachButton.setText("Chỉnh sửa");
    chinhSuaSachButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chinhSuaSachButtonActionPerformed(evt);
        }
    });

    xoaSachButton.setBackground(new java.awt.Color(255, 255, 255));
    xoaSachButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    xoaSachButton.setForeground(new java.awt.Color(0, 0, 0));
    xoaSachButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))));
    xoaSachButton.setText("Xóa");
    xoaSachButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            xoaSachButtonActionPerformed(evt);
        }
    });

    quanLySachTable.setBackground(new java.awt.Color(255, 255, 255));
    quanLySachTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    quanLySachTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    quanLySachTable.setForeground(new java.awt.Color(0, 0, 0));
    quanLySachTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {

        }
    ));
    quanLySachTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    quanLySachTable.setGridColor(new java.awt.Color(0, 0, 0));
    quanLySachTable.setSelectionBackground(new java.awt.Color(204, 255, 255));
    quanLySachTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
    quanLySachTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    quanLySachTable.setShowGrid(true);
    quanLySachTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            quanLySachTableMouseClicked(evt);
        }
    });
    jScrollPane10.setViewportView(quanLySachTable);
    quanLySachTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

    javax.swing.GroupLayout QuanLySachLayout = new javax.swing.GroupLayout(QuanLySach);
    QuanLySach.setLayout(QuanLySachLayout);
    QuanLySachLayout.setHorizontalGroup(
        QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(QuanLySachLayout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addGroup(QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtBookTitleID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtBookType, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(28, 28, 28)
            .addGroup(QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLySachLayout.createSequentialGroup()
                    .addGroup(QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maDauSach, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(theLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                    .addGroup(QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPublishingCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPublishingYear)
                        .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addGroup(QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tacGia)
                        .addComponent(nhaXuatBan)
                        .addComponent(namXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                    .addGap(54, 54, 54))
                .addGroup(QuanLySachLayout.createSequentialGroup()
                    .addComponent(themSachButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chinhSuaSachButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(147, 147, 147)
                    .addComponent(xoaSachButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(75, 75, 75))))
        .addGroup(QuanLySachLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane10)
            .addContainerGap())
    );
    QuanLySachLayout.setVerticalGroup(
        QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(QuanLySachLayout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtBookTitleID)
                .addComponent(maDauSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtAuthor)
                .addComponent(tacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtBookName)
                .addComponent(tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtPublishingCompany)
                .addComponent(nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtBookType)
                .addComponent(txtPublishingYear)
                .addComponent(theLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(namXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(29, 29, 29)
            .addGroup(QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(themSachButton)
                .addComponent(chinhSuaSachButton)
                .addComponent(xoaSachButton))
            .addGap(35, 35, 35)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
            .addContainerGap())
    );

    tabChinh.addTab("QUẢN LÝ SÁCH          ", new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/books.png"))), QuanLySach);

    QuanLyMuonTra.setBackground(new java.awt.Color(255, 255, 255));

    QuanLyTra.setBackground(new java.awt.Color(255, 255, 255));

    docGiaMuonTraSachTable.setBackground(new java.awt.Color(255, 255, 255));
    docGiaMuonTraSachTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    docGiaMuonTraSachTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    docGiaMuonTraSachTable.setForeground(new java.awt.Color(0, 0, 0));
    docGiaMuonTraSachTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {

        }
    ));
    docGiaMuonTraSachTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    docGiaMuonTraSachTable.setGridColor(new java.awt.Color(0, 0, 0));
    docGiaMuonTraSachTable.setSelectionBackground(new java.awt.Color(204, 255, 255));
    docGiaMuonTraSachTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
    docGiaMuonTraSachTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    docGiaMuonTraSachTable.setShowGrid(true);
    docGiaMuonTraSachTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            docGiaMuonTraSachTableMouseClicked(evt);
        }
    });
    jScrollPane16.setViewportView(docGiaMuonTraSachTable);
    docGiaMuonTraSachTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

    huongDanButton.setBackground(new java.awt.Color(255, 255, 255));
    huongDanButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    huongDanButton.setForeground(new java.awt.Color(0, 0, 0));
    huongDanButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tutorial.png"))));
    huongDanButton.setText("Hướng dẫn");
    huongDanButton.setFocusPainted(false);
    huongDanButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            huongDanButtonActionPerformed(evt);
        }
    });

    timKiemDocGiaMuonTra.setBackground(new java.awt.Color(255, 255, 255));
    timKiemDocGiaMuonTra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    timKiemDocGiaMuonTra.setForeground(new java.awt.Color(0, 0, 0));
    timKiemDocGiaMuonTra.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            timKiemDocGiaMuonTraKeyTyped(evt);
        }
    });

    muonSachButton.setBackground(new java.awt.Color(255, 255, 255));
    muonSachButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    muonSachButton.setForeground(new java.awt.Color(0, 0, 0));
    muonSachButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/borrow.png"))));
    muonSachButton.setText("Mượn sách");
    muonSachButton.setFocusPainted(false);
    muonSachButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            muonSachButtonActionPerformed(evt);
        }
    });

    traSachButton.setBackground(new java.awt.Color(255, 255, 255));
    traSachButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    traSachButton.setForeground(new java.awt.Color(0, 0, 0));
    traSachButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/give_book.png"))));
    traSachButton.setText("Trả sách");
    traSachButton.setFocusPainted(false);
    traSachButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            traSachButtonActionPerformed(evt);
        }
    });

    jLabel4.setBackground(new java.awt.Color(255, 255, 255));
    jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("Mã độc giả");

    javax.swing.GroupLayout QuanLyTraLayout = new javax.swing.GroupLayout(QuanLyTra);
    QuanLyTra.setLayout(QuanLyTraLayout);
    QuanLyTraLayout.setHorizontalGroup(
        QuanLyTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(QuanLyTraLayout.createSequentialGroup()
            .addGroup(QuanLyTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyTraLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane16))
                .addGroup(QuanLyTraLayout.createSequentialGroup()
                    .addGap(305, 305, 305)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(timKiemDocGiaMuonTra, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
        .addGroup(QuanLyTraLayout.createSequentialGroup()
            .addGap(181, 181, 181)
            .addComponent(muonSachButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(88, 88, 88)
            .addComponent(traSachButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(82, 82, 82)
            .addComponent(huongDanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(164, Short.MAX_VALUE))
    );
    QuanLyTraLayout.setVerticalGroup(
        QuanLyTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(QuanLyTraLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(QuanLyTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(timKiemDocGiaMuonTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
            .addGroup(QuanLyTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(muonSachButton)
                .addComponent(traSachButton)
                .addComponent(huongDanButton))
            .addGap(120, 120, 120))
    );

    javax.swing.GroupLayout QuanLyMuonTraLayout = new javax.swing.GroupLayout(QuanLyMuonTra);
    QuanLyMuonTra.setLayout(QuanLyMuonTraLayout);
    QuanLyMuonTraLayout.setHorizontalGroup(
        QuanLyMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(QuanLyMuonTraLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(QuanLyTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    QuanLyMuonTraLayout.setVerticalGroup(
        QuanLyMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(QuanLyMuonTraLayout.createSequentialGroup()
            .addComponent(QuanLyTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    tabChinh.addTab("QUẢN LÝ MƯỢN TRẢ", new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loan.png"))), QuanLyMuonTra);

    ThongKe.setBackground(new java.awt.Color(255, 255, 255));

    tabThongKe.setBackground(new java.awt.Color(255, 255, 255));
    tabThongKe.setForeground(new java.awt.Color(0, 0, 0));
    tabThongKe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

    readerStatistics.setBackground(new java.awt.Color(255, 255, 255));
    readerStatistics.setForeground(new java.awt.Color(0, 0, 0));


    txtReaderStatisticIcon.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/choose.png"))));

    thongKeDocGiaComboBox.setBackground(new java.awt.Color(255, 255, 255));
    thongKeDocGiaComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    thongKeDocGiaComboBox.setForeground(new java.awt.Color(0, 0, 0));
    thongKeDocGiaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ĐỘC GIẢ MƯỢN QUÁ HẠN", "ĐỘC GIẢ CHƯA TRẢ SÁCH" }));
    thongKeDocGiaComboBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            thongKeDocGiaComboBoxItemStateChanged(evt);
        }
    });

    thongKeDocGiaTable.setBackground(new java.awt.Color(255, 255, 255));
    thongKeDocGiaTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    thongKeDocGiaTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    thongKeDocGiaTable.setForeground(new java.awt.Color(0, 0, 0));
    thongKeDocGiaTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {

        }
    ));
    thongKeDocGiaTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    thongKeDocGiaTable.setGridColor(new java.awt.Color(0, 0, 0));
    thongKeDocGiaTable.setSelectionBackground(new java.awt.Color(204, 255, 255));
    thongKeDocGiaTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
    thongKeDocGiaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    thongKeDocGiaTable.setShowGrid(true);

    jScrollPane12.setViewportView(thongKeDocGiaTable);
    thongKeDocGiaTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

    javax.swing.GroupLayout readerStatisticsLayout = new javax.swing.GroupLayout(readerStatistics);
    readerStatistics.setLayout(readerStatisticsLayout);
    readerStatisticsLayout.setHorizontalGroup(
        readerStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(readerStatisticsLayout.createSequentialGroup()
            .addGap(304, 304, 304)
            .addComponent(txtReaderStatisticIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(thongKeDocGiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(readerStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(readerStatisticsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12)
                .addContainerGap()))
    );
    readerStatisticsLayout.setVerticalGroup(
        readerStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(readerStatisticsLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(thongKeDocGiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(readerStatisticsLayout.createSequentialGroup()
            .addComponent(txtReaderStatisticIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 414, Short.MAX_VALUE))
        .addGroup(readerStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, readerStatisticsLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap()))
    );

    tabThongKe.addTab("THỐNG KÊ ĐỘC GIẢ", new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tk_reader.png"))), readerStatistics);

    booksStatistics.setBackground(new java.awt.Color(255, 255, 255));
    booksStatistics.setForeground(new java.awt.Color(0, 0, 0));

    txtBookStatisticIcon.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/choose.png"))));

    thongKeSachTable.setBackground(new java.awt.Color(255, 255, 255));
    thongKeSachTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    thongKeSachTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    thongKeSachTable.setForeground(new java.awt.Color(0, 0, 0));
    thongKeSachTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {

        }
    ));
    thongKeSachTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    thongKeSachTable.setGridColor(new java.awt.Color(0, 0, 0));
    thongKeSachTable.setSelectionBackground(new java.awt.Color(204, 255, 255));
    thongKeSachTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
    thongKeSachTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    thongKeSachTable.setShowGrid(true);

    jScrollPane13.setViewportView(thongKeSachTable);
    thongKeSachTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

    thongKeSachComboBox.setBackground(new java.awt.Color(255, 255, 255));
    thongKeSachComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    thongKeSachComboBox.setForeground(new java.awt.Color(0, 0, 0));
    thongKeSachComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SÁCH MƯỢN NHIỀU NHẤT", "SÁCH ĐANG ĐƯỢC MƯỢN" }));
    thongKeSachComboBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            thongKeSachComboBoxItemStateChanged(evt);
        }
    });

    javax.swing.GroupLayout booksStatisticsLayout = new javax.swing.GroupLayout(booksStatistics);
    booksStatistics.setLayout(booksStatisticsLayout);
    booksStatisticsLayout.setHorizontalGroup(
        booksStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(booksStatisticsLayout.createSequentialGroup()
            .addContainerGap(265, Short.MAX_VALUE)
            .addComponent(txtBookStatisticIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(thongKeSachComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(387, 387, 387))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, booksStatisticsLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane13)
            .addContainerGap())
    );
    booksStatisticsLayout.setVerticalGroup(
        booksStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(booksStatisticsLayout.createSequentialGroup()
            .addGroup(booksStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtBookStatisticIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(booksStatisticsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(thongKeSachComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    tabThongKe.addTab("THỐNG KÊ SÁCH", new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tk_book.png"))), booksStatistics);

    javax.swing.GroupLayout ThongKeLayout = new javax.swing.GroupLayout(ThongKe);
    ThongKe.setLayout(ThongKeLayout);
    ThongKeLayout.setHorizontalGroup(
        ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tabThongKe)
    );
    ThongKeLayout.setVerticalGroup(
        ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tabThongKe)
    );

    tabChinh.addTab("THỐNG KÊ                  ", new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/analytics.png"))), ThongKe);

    TraCuu.setBackground(new java.awt.Color(255, 255, 255));

    txtSearchBook.setBackground(new java.awt.Color(255, 255, 255));
    txtSearchBook.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtSearchBook.setForeground(new java.awt.Color(0, 0, 0));
    txtSearchBook.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search (1).png"))));
    txtSearchBook.setText("Tìm kiếm sách");

    timKiemSach.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            timKiemSachKeyTyped(evt);
        }
    });

    txtYearFilter.setBackground(new java.awt.Color(255, 255, 255));
    txtYearFilter.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtYearFilter.setForeground(new java.awt.Color(0, 0, 0));
    txtYearFilter.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/year.png"))));
    txtYearFilter.setText("Lọc theo năm");

    theLoaiComboBox.setBackground(new java.awt.Color(255, 255, 255));
    theLoaiComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    theLoaiComboBox.setForeground(new java.awt.Color(0, 0, 0));
    theLoaiComboBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            theLoaiComboBoxItemStateChanged(evt);
        }
    });

    txtCategoryFilter.setBackground(new java.awt.Color(255, 255, 255));
    txtCategoryFilter.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtCategoryFilter.setForeground(new java.awt.Color(0, 0, 0));
    txtCategoryFilter.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/categories.png"))));
    txtCategoryFilter.setText("Lọc theo thể loại");

    tacGiaComboBox.setBackground(new java.awt.Color(255, 255, 255));
    tacGiaComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    tacGiaComboBox.setForeground(new java.awt.Color(0, 0, 0));
    tacGiaComboBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            tacGiaComboBoxItemStateChanged(evt);
        }
    });

    txtPublishingCompanyFilter.setBackground(new java.awt.Color(255, 255, 255));
    txtPublishingCompanyFilter.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtPublishingCompanyFilter.setForeground(new java.awt.Color(0, 0, 0));
    txtPublishingCompanyFilter.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send.png"))));
    txtPublishingCompanyFilter.setText("Theo nhà xuất bản");

    nhaXuatBanComboBox.setBackground(new java.awt.Color(255, 255, 255));
    nhaXuatBanComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    nhaXuatBanComboBox.setForeground(new java.awt.Color(0, 0, 0));
    nhaXuatBanComboBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            nhaXuatBanComboBoxItemStateChanged(evt);
        }
    });

    txtAuthorFilter.setBackground(new java.awt.Color(255, 255, 255));
    txtAuthorFilter.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    txtAuthorFilter.setForeground(new java.awt.Color(0, 0, 0));
    txtAuthorFilter.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/writer.png"))));
    txtAuthorFilter.setText("Theo tác giả");

    namComBoBox.setBackground(new java.awt.Color(255, 255, 255));
    namComBoBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    namComBoBox.setForeground(new java.awt.Color(0, 0, 0));
    namComBoBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            namComBoBoxItemStateChanged(evt);
        }
    });

    traCuuTable.setBackground(new java.awt.Color(255, 255, 255));
    traCuuTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    traCuuTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    traCuuTable.setForeground(new java.awt.Color(0, 0, 0));
    traCuuTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {

        }
    ));
    traCuuTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    traCuuTable.setGridColor(new java.awt.Color(0, 0, 0));
    traCuuTable.setSelectionBackground(new java.awt.Color(204, 255, 255));
    traCuuTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
    traCuuTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    traCuuTable.setShowGrid(true);
    jScrollPane11.setViewportView(traCuuTable);
    traCuuTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

    javax.swing.GroupLayout TraCuuLayout = new javax.swing.GroupLayout(TraCuu);
    TraCuu.setLayout(TraCuuLayout);
    TraCuuLayout.setHorizontalGroup(
        TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(TraCuuLayout.createSequentialGroup()
            .addGroup(TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TraCuuLayout.createSequentialGroup()
                    .addGroup(TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TraCuuLayout.createSequentialGroup()
                            .addGap(276, 276, 276)
                            .addComponent(txtSearchBook)
                            .addGap(27, 27, 27)
                            .addComponent(timKiemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(TraCuuLayout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCategoryFilter)
                                .addComponent(txtPublishingCompanyFilter))
                            .addGap(26, 26, 26)
                            .addGroup(TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(theLoaiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nhaXuatBanComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(118, 118, 118)
                            .addGroup(TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(TraCuuLayout.createSequentialGroup()
                                    .addComponent(txtYearFilter)
                                    .addGap(18, 18, 18)
                                    .addComponent(namComBoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(TraCuuLayout.createSequentialGroup()
                                    .addComponent(txtAuthorFilter)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tacGiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(0, 41, Short.MAX_VALUE))
                .addGroup(TraCuuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane11)))
            .addContainerGap())
    );
    TraCuuLayout.setVerticalGroup(
        TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(TraCuuLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtSearchBook)
                .addComponent(timKiemSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(36, 36, 36)
            .addGroup(TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtCategoryFilter)
                .addComponent(theLoaiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtYearFilter)
                .addComponent(namComBoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPublishingCompanyFilter)
                .addComponent(nhaXuatBanComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtAuthorFilter)
                .addComponent(tacGiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
            .addContainerGap())
    );

    tabChinh.addTab("TRA CỨU                    ", new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))), TraCuu);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tabChinh)
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tabChinh)
    );

    tabChinh.getAccessibleContext().setAccessibleName("readersManagement");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new DangNhap().setVisible(true);
    }

    private void thongKeDocGiaComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        if(thongKeDocGiaComboBox.getSelectedIndex() == 0){
            khoiTaoBang("", THONG_KE_DOC_GIA_QUA_HAN);
        } else {
            khoiTaoBang("", THONG_KE_DOC_GIA_CHUA_TRA);
        }
    }

    private void thongKeSachComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        if(thongKeSachComboBox.getSelectedIndex() == 0){
            khoiTaoBang("", THONG_KE_SACH_MUON_NHIEU_NHAT);
        } else {
            khoiTaoBang("", THONG_KE_SACH_DANG_DUOC_MUON);
        }
    }

    private void theLoaiComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        traCuuTenLoaiSach = (String) theLoaiComboBox.getSelectedItem();
        khoiTaoBang("", TRA_CUU);
    }

    private void nhaXuatBanComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        traCuuNhaXuatBan = (String) nhaXuatBanComboBox.getSelectedItem();
        khoiTaoBang("", TRA_CUU);
    }

    private void namComBoBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        traCuuNamXuatBan = (((String) namComBoBox.getSelectedItem()).length() == 0) ? -1 : Integer.parseInt(namComBoBox.getSelectedItem().toString());
        khoiTaoBang("", TRA_CUU);
    }

    private void tacGiaComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        traCuuTacGia = (String) tacGiaComboBox.getSelectedItem();
        khoiTaoBang("", TRA_CUU);
    }

    private void QuanLyDocGiaMouseClicked(java.awt.event.MouseEvent evt) {
        selectedRowIndex = -1;
        maDocGia.setText("");
        tenDocGia.setText("");
        hoDocGia.setText("");
        emailDocGia.setText("");
        sdtDocGia.setText("");
        ngaySinhDocGia.setCalendar(null);
        namRadioButton.setSelected(!namRadioButton.isSelected());
        hoDocGia.requestFocus();
    }

    private void QuanLySachMouseClicked(java.awt.event.MouseEvent evt) {
        maDauSach.setEnabled(true);
        selectedRowIndex = -1;
        maDauSach.setText("");
        tenSach.setText("");
        theLoaiSach.setText("");
        tacGia.setText("");
        nhaXuatBan.setText("");
        namXuatBan.setText("");
        maDauSach.requestFocus();
    }

    private void tenSachKeyTyped(java.awt.event.KeyEvent evt) {
        String prefixName = "";
        char c = evt.getKeyChar();
        String currText = tenDocGia.getText();
        if (Character.isAlphabetic(c) || c == ' ') {
            prefixName = currText + c;
        } else if (c == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            if (currText.length() >= 1) {
                prefixName = currText.substring(0, currText.length() - 1);
            }
            else {
                prefixName = "";
            }
        } else {
            evt.consume();
            prefixName = currText;
        }
        khoiTaoBang(prefixName, QUAN_LY_SACH);
    }

    private void timKiemSachKeyTyped(java.awt.event.KeyEvent evt) {
        String prefixName = "";
        char c = evt.getKeyChar();
        String currText = tenDocGia.getText();
        if (Character.isAlphabetic(c) || c == ' ') {
            prefixName = currText + c;
        } else if (c == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            if (currText.length() >= 1) {
                prefixName = currText.substring(0, currText.length() - 1);
            }
            else {
                prefixName = "";
            }
        } else {
            evt.consume();
            prefixName = currText;
        }
        traCuuTenSach = prefixName;
        khoiTaoBang("", TRA_CUU);
    }                                    

    private void huongDanButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        JOptionPane.showMessageDialog(null, "Tìm kiếm bằng mã độc giả hoặc chọn độc giả dưới bảng\nrồi sau đó chọn chức năng mượn sách hoặc trả sách");
    }

    private void muonSachButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(selectedRowIndex >= 0){
            if(!xuLyQuanLyDocGia.getDanhSachDocGia().get(selectedRowIndex).getHoatDong()) {
                JOptionPane.showMessageDialog(null, "Độc giả này đang bị khóa");
            } else {
                this.setEnabled(false);
                DocGiaMuonTra docGiaMuonTra = new DocGiaMuonTra(Integer.parseInt(docGiaMuonTraSachTable.getValueAt(selectedRowIndex, 0).toString()),  true);
                docGiaMuonTra.setVisible(true);
                docGiaMuonTra.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent windowEvent) {
                        docGiaMuonTra.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
                    }
                });
                this.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn độc giả");
        }
    }

    private void traSachButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(selectedRowIndex >= 0){
            this.setEnabled(false);
            DocGiaMuonTra docGiaMuonTra = new DocGiaMuonTra(Integer.parseInt(docGiaMuonTraSachTable.getValueAt(selectedRowIndex, 0).toString()),  false);
            docGiaMuonTra.setVisible(true);
            docGiaMuonTra.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    docGiaMuonTra.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
                }
            });
            this.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn độc giả");
        }
    }

    private void docGiaMuonTraSachTableMouseClicked(java.awt.event.MouseEvent evt) {
        selectedRowIndex = docGiaMuonTraSachTable.getSelectedRow();
        timKiemDocGiaMuonTra.setText(docGiaMuonTraSachTable.getValueAt(selectedRowIndex, 0).toString());
    }

    private void timKiemDocGiaMuonTraKeyTyped(java.awt.event.KeyEvent evt) {                                              
        String prefixName = "";
        char c = evt.getKeyChar();
        String currText = timKiemDocGiaMuonTra.getText();
        if (c >= '0' && c <= '9') {
            prefixName = currText + c;
        } else if (c == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            if (currText.length() >= 1){
                prefixName = currText.substring(0, currText.length() - 1);
            } else {
                prefixName = "";
            }
        }
        khoiTaoBang(prefixName, QUAN_LY_MUON_TRA);
    }

    private void hoDocGiaKeyTyped(java.awt.event.KeyEvent evt) {
        dangNhapTai = (tenDocGia.getText().length() == 0) ? 0 : 2;
        String prefixName = "";
        char c = evt.getKeyChar();
        String currText = hoDocGia.getText();
        if (Character.isAlphabetic(c) || c == ' ') {
            prefixName = currText + c;
        } else if (c == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            if (currText.length() >= 1)
                prefixName = currText.substring(0, currText.length() - 1);
            else
                prefixName = "";
        } else {
            evt.consume();
            prefixName = currText;
        }
        khoiTaoBang(prefixName, QUAN_LY_DOC_GIA);
    }

    private void sdtDocGiaKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)){
            evt.consume();
        }
    }

    private void namXuatBanKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)){
            evt.consume();
        }
    }

    private void tenDocGiaKeyTyped(java.awt.event.KeyEvent evt) {
        dangNhapTai = (hoDocGia.getText().length() == 0) ? 1 : 2;
        String prefixName = "";
        char c = evt.getKeyChar();
        String currText = tenDocGia.getText();
        if (Character.isAlphabetic(c) || c == ' ') {
            prefixName = currText + c;
        } else if (c == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            if (currText.length() >= 1) {
                prefixName = currText.substring(0, currText.length() - 1);
            }
            else {
                prefixName = "";
            }
        } else {
            evt.consume();
            prefixName = currText;
        }
        khoiTaoBang(prefixName, QUAN_LY_DOC_GIA);
    }

    private void khoiTaoBang(String prefixName, int maThucHien){
        modelManagement = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        switch (maThucHien){
            case QUAN_LY_DOC_GIA -> {
                quanLyDocGiaTable.setModel(modelManagement);
                modelManagement.setRowCount(0);
                modelManagement.setColumnIdentifiers(new String []{"Mã độc giả", "Họ",  "Tên", "Giới tính", "Ngày sinh", "Email", "SÐT", "Trạng thái"});
                for(DocGia item:xuLyQuanLyDocGia.getDanhSachDocGia()){
                    if(prefixName.length() > 0){
                        if(dangNhapTai == 0){
                            if(StringUtils.removeAccent(item.getHoDocGia()).toLowerCase().startsWith(prefixName.toLowerCase())){
                                modelManagement.addRow(new String[] {String.valueOf(item.getMaDocGia()), item.getHoDocGia(), item.getTenDocGia(), item.getGioiTinhDocGia() ? "Nữ" : "Nam", item.getNgaySinhDocGia(), item.getEmailDocGia(), item.getSdtDocGia(), item.getHoatDong() ? "Hoạt động" : "Bị khóa"});
                            }
                        } else {
                            if(StringUtils.removeAccent(item.getTenDocGia()).toLowerCase().startsWith(prefixName.toLowerCase())){
                                modelManagement.addRow(new String[] {String.valueOf(item.getMaDocGia()), item.getHoDocGia(), item.getTenDocGia(), item.getGioiTinhDocGia() ? "Nữ" : "Nam", item.getNgaySinhDocGia(), item.getEmailDocGia(), item.getSdtDocGia(), item.getHoatDong() ? "Hoạt động" : "Bị khóa"});
                            }
                        }
                    } else {
                        modelManagement.addRow(new String[] {String.valueOf(item.getMaDocGia()), item.getHoDocGia(), item.getTenDocGia(), item.getGioiTinhDocGia() ? "Nữ" : "Nam", item.getNgaySinhDocGia(), item.getEmailDocGia(), item.getSdtDocGia(), item.getHoatDong() ? "Hoạt động" : "Bị khóa"});
                    }
                }
                modelManagement.fireTableDataChanged();
                Process.resizeColumnWidth(quanLyDocGiaTable);
                JTableUtilities.setCellsAlignment(quanLyDocGiaTable, SwingConstants.CENTER);
            }
            case QUAN_LY_MUON_TRA -> {
                docGiaMuonTraSachTable.setModel(modelManagement);
                modelManagement.setRowCount(0);
                modelManagement.setColumnIdentifiers(new String []{"Mã độc giả", "Họ",  "Tên", "Giới tính", "Ngày sinh", "Email", "SÐT", "Trạng thái"});
                for(DocGia item:xuLyQuanLyDocGia.getDanhSachDocGia()){
                    if(prefixName.length() > 0){
                        if(StringUtils.removeAccent(String.valueOf(item.getMaDocGia())).toLowerCase().startsWith(prefixName.toLowerCase())){
                            modelManagement.addRow(new String[] {String.valueOf(item.getMaDocGia()), item.getHoDocGia(), item.getTenDocGia(), item.getGioiTinhDocGia() ? "Nữ" : "Nam", item.getNgaySinhDocGia(), item.getEmailDocGia(), item.getSdtDocGia(), item.getHoatDong() ? "Hoạt động" : "Bị khóa"});
                        }
                    } else {
                        modelManagement.addRow(new String[] {String.valueOf(item.getMaDocGia()), item.getHoDocGia(), item.getTenDocGia(), item.getGioiTinhDocGia() ? "Nữ" : "Nam", item.getNgaySinhDocGia(), item.getEmailDocGia(), item.getSdtDocGia(), item.getHoatDong() ? "Hoạt động" : "Bị khóa"});
                    }
                }
                modelManagement.fireTableDataChanged();
                Process.resizeColumnWidth(docGiaMuonTraSachTable);
                JTableUtilities.setCellsAlignment(docGiaMuonTraSachTable, SwingConstants.CENTER);
            }
            case THONG_KE_DOC_GIA_QUA_HAN -> {
                thongKeDocGiaTable.setModel(modelManagement);
                modelManagement.setRowCount(0);
                modelManagement.setColumnIdentifiers(new String []{"Mã độc giả", "Họ",  "Tên", "Giới tính", "Ngày sinh", "Email", "SÐT", "Trạng thái"});
                for(DocGia item:xuLyThongKe.thongKeDocGiaMuonQuaHan()){
                    modelManagement.addRow(new String[] {String.valueOf(item.getMaDocGia()), item.getHoDocGia(), item.getTenDocGia(), item.getGioiTinhDocGia() ? "Nữ" : "Nam", item.getNgaySinhDocGia(), item.getEmailDocGia(), item.getSdtDocGia(), item.getHoatDong() ? "Hoạt động" : "Bị khóa"});
                }
                modelManagement.fireTableDataChanged();
                Process.resizeColumnWidth(thongKeDocGiaTable);
                JTableUtilities.setCellsAlignment(thongKeDocGiaTable, SwingConstants.CENTER);
            }
            case THONG_KE_DOC_GIA_CHUA_TRA -> {
                thongKeDocGiaTable.setModel(modelManagement);
                modelManagement.setRowCount(0);
                modelManagement.setColumnIdentifiers(new String []{"Mã độc giả", "Họ",  "Tên", "Giới tính", "Ngày sinh", "Email", "SÐT", "Trạng thái"});
                for(DocGia item:xuLyThongKe.thongKeDocGiaChuaTraSach()){
                    modelManagement.addRow(new String[] {String.valueOf(item.getMaDocGia()), item.getHoDocGia(), item.getTenDocGia(), item.getGioiTinhDocGia() ? "Nữ" : "Nam", item.getNgaySinhDocGia(), item.getEmailDocGia(), item.getSdtDocGia(), item.getHoatDong() ? "Hoạt động" : "Bị khóa"});
                }
                modelManagement.fireTableDataChanged();
                Process.resizeColumnWidth(thongKeDocGiaTable);
                JTableUtilities.setCellsAlignment(thongKeDocGiaTable, SwingConstants.CENTER);
            }
            case THONG_KE_SACH_MUON_NHIEU_NHAT -> {
                thongKeSachTable.setModel(modelManagement);
                modelManagement.setRowCount(0);
                modelManagement.setColumnIdentifiers(new String []{"ISBN", "Tên sách",  "Thể loại", "Tác giả", "Nhà xuất bản", "Năm xuất bản"});
                for(DauSach item: xuLyThongKe.thongKeSachMuonNhieuNhat()){
                    modelManagement.addRow(new String[] {item.getISBN(), item.getTenDauSach(), item.getTenLoaiSach(), item.getTacGia(), item.getNhaXuatBan(), String.valueOf(item.getNamXuatBan())});
                }
                modelManagement.fireTableDataChanged();
                Process.resizeColumnWidth(thongKeSachTable);
                JTableUtilities.setCellsAlignment(thongKeSachTable, SwingConstants.CENTER);
            }
            case THONG_KE_SACH_DANG_DUOC_MUON -> {
                thongKeSachTable.setModel(modelManagement);
                modelManagement.setRowCount(0);
                modelManagement.setColumnIdentifiers(new String []{"ISBN", "Tên sách",  "Thể loại", "Tác giả", "Nhà xuất bản", "Năm xuất bản"});
                for(DauSach item: xuLyThongKe.thongKeSachDangMuon()){
                    modelManagement.addRow(new String[] {item.getISBN(), item.getTenDauSach(), item.getTenLoaiSach(), item.getTacGia(), item.getNhaXuatBan(), String.valueOf(item.getNamXuatBan())});
                }
                modelManagement.fireTableDataChanged();
                Process.resizeColumnWidth(thongKeSachTable);
                JTableUtilities.setCellsAlignment(thongKeSachTable, SwingConstants.CENTER);
            }
            case TRA_CUU -> {
                traCuuTable.setModel(modelManagement);
                modelManagement.setRowCount(0);
                modelManagement.setColumnIdentifiers(new String []{"ISBN", "Tên sách",  "Thể loại", "Tác giả", "Nhà xuất bản", "Năm xuất bản"});
                for(DauSach item: xuLyTraCuu.danhSachDauSachLocTheo(traCuuTenSach, traCuuTenLoaiSach, traCuuNamXuatBan, traCuuNhaXuatBan, traCuuTacGia)){
                    modelManagement.addRow(new String[] {item.getISBN(), item.getTenDauSach(), item.getTenLoaiSach(), item.getTacGia(), item.getNhaXuatBan(), String.valueOf(item.getNamXuatBan())});
                }
                modelManagement.fireTableDataChanged();
                Process.resizeColumnWidth(traCuuTable);
                JTableUtilities.setCellsAlignment(traCuuTable, SwingConstants.CENTER);
            }
            case QUAN_LY_SACH -> {
                quanLySachTable.setModel(modelManagement);
                modelManagement.setRowCount(0);
                quanLySachTable.setModel(modelManagement);
                modelManagement.setRowCount(0);
                modelManagement.setColumnIdentifiers(new String []{"ISBN", "Tên sách",  "Thể loại", "Tác giả", "Nhà xuất bản", "Năm xuất bản"});
                for(DauSach item: xuLyQuanLySach.getDanhSachDauSach()){
                    if(prefixName.length() > 0){
                        if(item.getTenDauSach().startsWith(prefixName.toLowerCase())){
                            modelManagement.addRow(new String[] {item.getISBN(), item.getTenDauSach(), item.getTenLoaiSach(), item.getTacGia(), item.getNhaXuatBan(), String.valueOf(item.getNamXuatBan())});
                        }
                    } else {
                        modelManagement.addRow(new String[] {item.getISBN(), item.getTenDauSach(), item.getTenLoaiSach(), item.getTacGia(), item.getNhaXuatBan(), String.valueOf(item.getNamXuatBan())});
                    }
                }
                modelManagement.fireTableDataChanged();
                Process.resizeColumnWidth(quanLySachTable);
                JTableUtilities.setCellsAlignment(quanLySachTable, SwingConstants.CENTER);
            }
        }
    }

    private void quanLyDocGiaTableMouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel model = (DefaultTableModel)quanLyDocGiaTable.getModel();
        selectedRowIndex = quanLyDocGiaTable.getSelectedRow();
        maDocGia.setText(model.getValueAt(selectedRowIndex, 0).toString());
        hoDocGia.setText(model.getValueAt(selectedRowIndex, 1).toString());
        tenDocGia.setText(model.getValueAt(selectedRowIndex, 2).toString());
        if (model.getValueAt(selectedRowIndex, 3).toString().equals("Nam")) {
            namRadioButton.setSelected(true);
        } else {
            nuRadioButton.setSelected(true);
        }
        if(model.getValueAt(selectedRowIndex, 7).toString().equals("Hoạt động")){
            hoatDongRadioButton.setSelected(true);
        } else {
            biKhoaRadioButton.setSelected(true);
        }
        String dateValue = model.getValueAt(selectedRowIndex, 4).toString();
        java.util.Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ngaySinhDocGia.setDate(date);
        emailDocGia.setText(model.getValueAt(selectedRowIndex, 5).toString());
        sdtDocGia.setText(model.getValueAt(selectedRowIndex, 6).toString());
    }

    private void quanLySachTableMouseClicked(java.awt.event.MouseEvent evt) {
        maDauSach.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel)quanLySachTable.getModel();
        selectedRowIndex = quanLySachTable.getSelectedRow();
        maDauSach.setText(model.getValueAt(selectedRowIndex, 0).toString());
        tenSach.setText(model.getValueAt(selectedRowIndex, 1).toString());
        theLoaiSach.setText(model.getValueAt(selectedRowIndex, 2).toString());
        tacGia.setText(model.getValueAt(selectedRowIndex, 3).toString());
        nhaXuatBan.setText(model.getValueAt(selectedRowIndex, 4).toString());
        namXuatBan.setText(model.getValueAt(selectedRowIndex, 5).toString());
        if(evt.getClickCount() == 2){
            this.setEnabled(false);
            DanhMucSach danhMucSach = new DanhMucSach(maDauSach.getText(), tenSach.getText());
            danhMucSach.setVisible(true);
            danhMucSach.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    danhMucSach.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
                }
            });
            this.setEnabled(true);
        }
    }

    private void tabChinhMouseClicked(java.awt.event.MouseEvent evt){
        if(tabChinh.getSelectedIndex() == 0){
            khoiTaoBang("", QUAN_LY_DOC_GIA);
        } else if(tabChinh.getSelectedIndex() == 1) {
            khoiTaoBang("", QUAN_LY_SACH);
        } else if(tabChinh.getSelectedIndex() == 2){
            khoiTaoBang("", QUAN_LY_MUON_TRA);
        } else if(tabChinh.getSelectedIndex() == 3){
            xuLyThongKe.update();
            if(tabThongKe.getSelectedIndex() == 0){
                if(thongKeDocGiaComboBox.getSelectedIndex() == 0){
                    khoiTaoBang("", THONG_KE_DOC_GIA_QUA_HAN);
                }
                else if(thongKeDocGiaComboBox.getSelectedIndex() == 1){
                    khoiTaoBang("", THONG_KE_DOC_GIA_CHUA_TRA);
                }
            } else {
                if(thongKeSachComboBox.getSelectedIndex() == 1){
                    khoiTaoBang("", THONG_KE_SACH_DANG_DUOC_MUON);
                } else {
                    khoiTaoBang("", THONG_KE_SACH_MUON_NHIEU_NHAT);
                }
            }
        } else if(tabChinh.getSelectedIndex() == 4){
            xuLyTraCuu.update();
            khoiTaoBang("", TRA_CUU);
        }
    }

    private void xoaDocGiaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(selectedRowIndex >= 0){
            int confirm = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa", "Confirm", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                int status = xuLyQuanLyDocGia.xoaDocGia(Integer.parseInt(modelManagement.getValueAt(selectedRowIndex, 0).toString()));
                if(status == XuLyQuanLyDocGia.THANH_CONG){
                    JOptionPane.showMessageDialog(null, "Xóa độc giả thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi");
                }
                khoiTaoBang("", QUAN_LY_DOC_GIA);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn độc giả cần xóa");
        }
    }

    private void chinhSuaDocGiaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(selectedRowIndex >= 0){
            Date date = ngaySinhDocGia.getDate();
            String hoDocGia = this.hoDocGia.getText();
            String tenDocGia = this.tenDocGia.getText();
            String txtEmail = emailDocGia.getText();
            String soDienThoaiDocGia = sdtDocGia.getText();
            int maDocGiaChinhSua = Integer.parseInt(maDocGia.getText());
            boolean gioiTinhDocGia = !namRadioButton.isSelected();
            boolean trangThaiDocGia = hoatDongRadioButton.isSelected();
            int status = xuLyQuanLyDocGia.chinhSuaDocGia(maDocGiaChinhSua, hoDocGia, tenDocGia, gioiTinhDocGia, date, txtEmail, soDienThoaiDocGia, trangThaiDocGia);
            switch (status){
                case XuLyQuanLyDocGia.LOI_HO -> {
                    JOptionPane.showMessageDialog(null, "Hãy nhập lại họ của độc giả");
                    this.hoDocGia.setText("");
                    this.hoDocGia.requestFocus();
                }
                case XuLyQuanLyDocGia.LOI_TEN -> {
                    JOptionPane.showMessageDialog(null, "Hãy nhập lại tên của độc giả");
                    this.tenDocGia.setText("");
                    this.tenDocGia.requestFocus();
                }
                case XuLyQuanLyDocGia.LOI_NGAY_SINH -> {
                    JOptionPane.showMessageDialog(null, "Hãy nhập lại ngày sinh của độc giả");
                }
                case XuLyQuanLyDocGia.LOI_EMAIL -> {
                    JOptionPane.showMessageDialog(null, "Hãy nhập lại email của độc giả");
                    this.emailDocGia.setText("");
                    this.emailDocGia.requestFocus();
                }
                case XuLyQuanLyDocGia.LOI_SDT -> {
                    JOptionPane.showMessageDialog(null, "Hãy nhập lại số điện thoại của độc giả");
                    this.sdtDocGia.setText("");
                    this.sdtDocGia.requestFocus();
                }
                case XuLyQuanLyDocGia.LOI_BAT_DINH ->{
                    JOptionPane.showMessageDialog(null, "Thêm độc giả không thành công");
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Chỉnh sửa độc giả thành công");
                    this.hoDocGia.setText("");
                    this.tenDocGia.setText("");
                    this.emailDocGia.setText("");
                    this.sdtDocGia.setText("");
                    this.maDocGia.setText("");
                    this.hoDocGia.requestFocus();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn độc giả cần chỉnh sửa");
        }
        khoiTaoBang("", QUAN_LY_DOC_GIA);
    }

    private void themDocGiaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Date date = ngaySinhDocGia.getDate();
        String hoDocGia = this.hoDocGia.getText();
        String tenDocGia = this.tenDocGia.getText();
        String txtEmail = emailDocGia.getText();
        String soDienThoaiDocGia = sdtDocGia.getText();
        boolean gioiTinhDocGia = !namRadioButton.isSelected();
        int status = xuLyQuanLyDocGia.themDocGia(hoDocGia, tenDocGia, gioiTinhDocGia, date, txtEmail, soDienThoaiDocGia);
        switch (status){
            case XuLyQuanLyDocGia.LOI_HO -> {
                JOptionPane.showMessageDialog(null, "Hãy nhập lại họ của độc giả");
                this.hoDocGia.setText("");
                this.hoDocGia.requestFocus();
            }
            case XuLyQuanLyDocGia.LOI_TEN -> {
                JOptionPane.showMessageDialog(null, "Hãy nhập lại tên của độc giả");
                this.tenDocGia.setText("");
                this.tenDocGia.requestFocus();
            }
            case XuLyQuanLyDocGia.LOI_NGAY_SINH -> {
                JOptionPane.showMessageDialog(null, "Hãy nhập lại ngày sinh của độc giả");
            }
            case XuLyQuanLyDocGia.LOI_EMAIL -> {
                JOptionPane.showMessageDialog(null, "Hãy nhập lại email của độc giả");
                this.emailDocGia.setText("");
                this.emailDocGia.requestFocus();
            }
            case XuLyQuanLyDocGia.LOI_SDT -> {
                JOptionPane.showMessageDialog(null, "Hãy nhập lại số điện thoại của độc giả");
                this.sdtDocGia.setText("");
                this.sdtDocGia.requestFocus();
            }
            case XuLyQuanLyDocGia.LOI_BAT_DINH ->{
                JOptionPane.showMessageDialog(null, "Thêm độc giả không thành công");
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Thêm độc giả thành công");
                this.hoDocGia.setText("");
                this.tenDocGia.setText("");
                this.emailDocGia.setText("");
                this.sdtDocGia.setText("");
                this.maDocGia.setText("");
                this.hoDocGia.requestFocus();
            }
        }
        khoiTaoBang("", QUAN_LY_DOC_GIA);
    }

    private void themSachButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int status = xuLyQuanLySach.themSach(maDauSach.getText(), tenSach.getText(), theLoaiSach.getText(), tacGia.getText(), nhaXuatBan.getText(), namXuatBan.getText());
        if(status == XuLyQuanLySach.LOI_ISBN){
            JOptionPane.showMessageDialog(null, "Hãy nhập lại mã đầu sách");
            maDauSach.setText("");
            maDauSach.requestFocus();
        } else if(status == XuLyQuanLySach.LOI_ISBN_TRUNG){
            JOptionPane.showMessageDialog(null, "Mã đầu sách không được trùng");
            maDauSach.setText("");
            maDauSach.requestFocus();
        } else if(status == XuLyQuanLySach.LOI_TEN_SACH){
            JOptionPane.showMessageDialog(null, "Hãy nhập lại tên sách");
            tenSach.setText("");
            tenSach.requestFocus();
        } else if(status == XuLyQuanLySach.LOI_THE_LOAI){
            JOptionPane.showMessageDialog(null, "Hãy nhập lại thể loại sách");
            theLoaiSach.setText("");
            theLoaiSach.requestFocus();
        } else if(status == XuLyQuanLySach.LOI_TAC_GIA){
            JOptionPane.showMessageDialog(null, "Hãy nhập lại tên tác giả");
            tacGia.setText("");
            tacGia.requestFocus();
        } else if(status == XuLyQuanLySach.LOI_NHA_XUAT_BAN){
            JOptionPane.showMessageDialog(null, "Hãy nhập lại tên nhà xuất bản");
            nhaXuatBan.setText("");
            nhaXuatBan.requestFocus();
        } else if(status == XuLyQuanLySach.LOI_NAM_XUAT_BAN){
            JOptionPane.showMessageDialog(null, "Hãy nhập lại năm xuất bản");
            namXuatBan.setText("");
            namXuatBan.requestFocus();
        } else if(status == XuLyQuanLySach.LOI_BAT_DINH){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi\nHãy nhập lại:");
            maDauSach.setText("");
            tenSach.setText("");
            theLoaiSach.setText("");
            tacGia.setText("");
            nhaXuatBan.setText("");
            namXuatBan.setText("");
            maDauSach.requestFocus();
        } else if(status == XuLyQuanLySach.THANH_CONG){
            JOptionPane.showMessageDialog(null, "Thêm đầu sách thành công");
            maDauSach.setText("");
            tenSach.setText("");
            theLoaiSach.setText("");
            tacGia.setText("");
            nhaXuatBan.setText("");
            namXuatBan.setText("");
            maDauSach.requestFocus();
        }
        khoiTaoBang("", QUAN_LY_SACH);
    }

    private void chinhSuaSachButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(selectedRowIndex >= 0){
            int status = xuLyQuanLySach.chinhSuaSach(maDauSach.getText(), tenSach.getText(), theLoaiSach.getText(), tacGia.getText(), nhaXuatBan.getText(), namXuatBan.getText());
            if(status == XuLyQuanLySach.LOI_ISBN){
                JOptionPane.showMessageDialog(null, "Hãy nhập lại mã đầu sách");
                maDauSach.setText("");
                maDauSach.requestFocus();
            } else if(status == XuLyQuanLySach.LOI_ISBN_TRUNG){
                JOptionPane.showMessageDialog(null, "Mã đầu sách không được trùng");
                maDauSach.requestFocus();
            } else if(status == XuLyQuanLySach.LOI_TEN_SACH){
                JOptionPane.showMessageDialog(null, "Hãy nhập lại tên sách");
                tenSach.setText("");
                tenSach.requestFocus();
            } else if(status == XuLyQuanLySach.LOI_THE_LOAI){
                JOptionPane.showMessageDialog(null, "Hãy nhập lại thể loại sách");
                theLoaiSach.setText("");
                theLoaiSach.requestFocus();
            } else if(status == XuLyQuanLySach.LOI_TAC_GIA){
                JOptionPane.showMessageDialog(null, "Hãy nhập lại tên tác giả");
                tacGia.setText("");
                tacGia.requestFocus();
            } else if(status == XuLyQuanLySach.LOI_NHA_XUAT_BAN){
                JOptionPane.showMessageDialog(null, "Hãy nhập lại tên nhà xuất bản");
                nhaXuatBan.setText("");
                nhaXuatBan.requestFocus();
            } else if(status == XuLyQuanLySach.LOI_NAM_XUAT_BAN){
                JOptionPane.showMessageDialog(null, "Hãy nhập lại năm xuất bản");
                namXuatBan.setText("");
                namXuatBan.requestFocus();
            } else if(status == XuLyQuanLySach.LOI_BAT_DINH){
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi\nHãy nhập lại:");
                maDauSach.setText("");
                tenSach.setText("");
                theLoaiSach.setText("");
                tacGia.setText("");
                nhaXuatBan.setText("");
                namXuatBan.setText("");
                maDauSach.requestFocus();
            } else if(status == XuLyQuanLySach.THANH_CONG){
                JOptionPane.showMessageDialog(null, "Chỉnh sửa đầu sách thành công");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn đầu sách cần chỉnh sửa");
        }
        khoiTaoBang("", QUAN_LY_SACH);
    }

    private void xoaSachButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(selectedRowIndex >= 0){
            int status = xuLyQuanLySach.xoaSach(selectedRowIndex);
            if(status == XuLyQuanLySach.THANH_CONG){
                JOptionPane.showMessageDialog(null, "Xóa đầu sách thành công");
            } else if(status == XuLyQuanLySach.LOI_XOA){
                JOptionPane.showMessageDialog(null, "Số lượng danh mục sách lớn hơn 0");
            } else {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi");
            }
            maDauSach.setText("");
            tenSach.setText("");
            theLoaiSach.setText("");
            tacGia.setText("");
            nhaXuatBan.setText("");
            namXuatBan.setText("");
            maDauSach.requestFocus();
        }
        khoiTaoBang("", QUAN_LY_SACH);
    }

    private javax.swing.JPanel QuanLyDocGia;
    private javax.swing.JPanel QuanLyMuonTra;
    private javax.swing.JPanel QuanLySach;
    private javax.swing.JPanel QuanLyTra;
    private javax.swing.JPanel ThongKe;
    private javax.swing.JPanel TraCuu;
    private javax.swing.ButtonGroup adjRadioGroup;
    private javax.swing.JRadioButton biKhoaRadioButton;
    private javax.swing.JPanel booksStatistics;
    private javax.swing.JButton chinhSuaDocGiaButton;
    private javax.swing.JButton chinhSuaSachButton;
    private javax.swing.JTable docGiaMuonTraSachTable;
    private javax.swing.JTextField emailDocGia;
    private javax.swing.JLabel firstName;
    private javax.swing.JTextField hoDocGia;
    private javax.swing.JRadioButton hoatDongRadioButton;
    private javax.swing.JButton huongDanButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField maDauSach;
    private javax.swing.JTextField maDocGia;
    private javax.swing.JButton muonSachButton;
    private javax.swing.JComboBox<String> namComBoBox;
    private javax.swing.JRadioButton namRadioButton;
    private javax.swing.JTextField namXuatBan;
    private com.toedter.calendar.JDateChooser ngaySinhDocGia;
    private javax.swing.JTextField nhaXuatBan;
    private javax.swing.JComboBox<String> nhaXuatBanComboBox;
    private javax.swing.JRadioButton nuRadioButton;
    private javax.swing.JTable quanLyDocGiaTable;
    private javax.swing.JTable quanLySachTable;
    private javax.swing.JPanel readerStatistics;
    private javax.swing.JTextField sdtDocGia;
    private javax.swing.ButtonGroup sexRadioGroup;
    private javax.swing.JTabbedPane tabChinh;
    private javax.swing.JTabbedPane tabThongKe;
    private javax.swing.JTextField tacGia;
    private javax.swing.JComboBox<String> tacGiaComboBox;
    private javax.swing.JTextField tenDocGia;
    private javax.swing.JTextField tenSach;
    private javax.swing.JComboBox<String> theLoaiComboBox;
    private javax.swing.JTextField theLoaiSach;
    private javax.swing.JButton themDocGiaButton;
    private javax.swing.JButton themSachButton;
    private javax.swing.JComboBox<String> thongKeDocGiaComboBox;
    private javax.swing.JTable thongKeDocGiaTable;
    private javax.swing.JComboBox<String> thongKeSachComboBox;
    private javax.swing.JTable thongKeSachTable;
    private javax.swing.JTextField timKiemDocGiaMuonTra;
    private javax.swing.JTextField timKiemSach;
    private javax.swing.JTable traCuuTable;
    private javax.swing.JButton traSachButton;
    private javax.swing.JLabel txtAuthor;
    private javax.swing.JLabel txtAuthorFilter;
    private javax.swing.JLabel txtBookName;
    private javax.swing.JLabel txtBookStatisticIcon;
    private javax.swing.JLabel txtBookTitleID;
    private javax.swing.JLabel txtBookType;
    private javax.swing.JLabel txtCategoryFilter;
    private javax.swing.JLabel txtDayOfBirth;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtGender;
    private javax.swing.JLabel txtPhoneNumber;
    private javax.swing.JLabel txtPublishingCompany;
    private javax.swing.JLabel txtPublishingCompanyFilter;
    private javax.swing.JLabel txtPublishingYear;
    private javax.swing.JLabel txtReaderID;
    private javax.swing.JLabel txtReaderStatisticIcon;
    private javax.swing.JLabel txtSearchBook;
    private javax.swing.JLabel txtStatus;
    private javax.swing.JLabel txtYearFilter;
    private javax.swing.JLabel txtlastName;
    private javax.swing.JButton xoaDocGiaButton;
    private javax.swing.JButton xoaSachButton;
}
