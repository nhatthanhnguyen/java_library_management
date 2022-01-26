/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import model.DauSach;
import process.JTableUtilities;
import process.Process;
import DataAccessObject.XuLyMuon;
import DataAccessObject.XuLyTra;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class DocGiaMuonTra extends javax.swing.JFrame {

    private int selectedRowIndex = -1;
    private boolean trangThaiFrame;
    private XuLyTra xuLyTra;
    private XuLyMuon xuLyMuon;
    DefaultTableModel modelManagement;
    private String prefix;
    public DocGiaMuonTra(int maDocGia, boolean trangThai) {
        prefix = "";
        this.trangThaiFrame = trangThai;
        xuLyTra = new XuLyTra(maDocGia);
        xuLyMuon = new XuLyMuon(maDocGia);
        initComponents();
        setResizable(false);
        setTitle("Library Management");
        khoiTaoBang(prefix);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        muonTraSachTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        timKiem = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        muonTraSachTable.setBackground(new java.awt.Color(255, 255, 255));
        muonTraSachTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        muonTraSachTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        muonTraSachTable.setForeground(new java.awt.Color(0, 0, 0));
        muonTraSachTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        muonTraSachTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        muonTraSachTable.setGridColor(new java.awt.Color(0, 0, 0));
        muonTraSachTable.setSelectionBackground(new java.awt.Color(204, 255, 255));
        muonTraSachTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        muonTraSachTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        muonTraSachTable.setShowGrid(true);
        muonTraSachTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muonTraSachTableMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(muonTraSachTable);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search_muon.png"))));
        jLabel2.setText("Tìm kiếm sách");

        timKiem.setBackground(new java.awt.Color(255, 255, 255));
        timKiem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        timKiem.setForeground(new java.awt.Color(0, 0, 0));
        timKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timKiemKeyTyped(evt);
            }
        });

        okButton.setBackground(new java.awt.Color(255, 255, 255));
        okButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        okButton.setForeground(new java.awt.Color(0, 0, 0));
        okButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ok.png"))));
        okButton.setText("Đồng ý");
        okButton.setFocusPainted(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane17)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 99, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50)
                        .addComponent(timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(310, 310, 310))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(okButton)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }
    private void khoiTaoBang(String prefix){
        modelManagement = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        muonTraSachTable.setModel(modelManagement);
        modelManagement.setRowCount(0);
        muonTraSachTable.setModel(modelManagement);
        modelManagement.setRowCount(0);
        if(trangThaiFrame) { // muon
            modelManagement.setColumnIdentifiers(new String []{"ISBN", "Tên sách", "Tên loại sách",  "Tác giả", "Nhà xuất bản", "Năm xuất bản"});
            for(DauSach item: xuLyMuon.getDanhSachDauSach()){
                if(item.getTenDauSach().startsWith(prefix)){
                    modelManagement.addRow(new String[] {item.getISBN(), item.getTenDauSach(), item.getTenLoaiSach(), item.getTacGia(), item.getNhaXuatBan(), String.valueOf(item.getNamXuatBan())});
                }
            }
        } else { // tra
            modelManagement.setColumnIdentifiers(new String []{"Mã phiếu mượn", "Tên đầu sách", "Mã danh mục sách", "Ngày mượn", "Ngày trả", "Trạng thái"});
            for(ArrayList<String> item:xuLyTra.getDataJoin()){
                if(item.get(1).startsWith(prefix)){
                    modelManagement.addRow(new String[]{item.get(0), item.get(1), item.get(2), item.get(3), item.get(4), item.get(5)});
                }
            }
        }

        modelManagement.fireTableDataChanged();
        Process.resizeColumnWidth(muonTraSachTable);
        JTableUtilities.setCellsAlignment(muonTraSachTable, SwingConstants.CENTER);
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(trangThaiFrame){ // muon
            if(selectedRowIndex >= 0){
                int status = xuLyMuon.muonSach(muonTraSachTable.getValueAt(selectedRowIndex, 0).toString());
                if(XuLyMuon.THANH_CONG == status){
                    JOptionPane.showMessageDialog(null, "Thành công");
                    khoiTaoBang(prefix);
                } else if(XuLyMuon.SACH_KHONG_SAN_SANG == status){
                    JOptionPane.showMessageDialog(null, "Sách không sẵn sàng");
                } else if(XuLyMuon.MUON_HON_3_CUON == status){
                    JOptionPane.showMessageDialog(null, "Đã mượn đủ 3 cuốn sách");
                } else{
                    JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra");
                }
                selectedRowIndex = -1;
            } else {
                this.setVisible(false);
            }
        } else { // tra
            if(selectedRowIndex >= 0){
                int confirm = JOptionPane.showConfirmDialog(null, "Sách có bị hỏng hoặc mất ?");
                int status = xuLyTra.traSach(muonTraSachTable.getValueAt(selectedRowIndex, 2).toString(), (confirm == JOptionPane.YES_OPTION) ? 2 : 0);
                if(status == XuLyTra.THANH_CONG){
                    JOptionPane.showMessageDialog(null, "Thành công");
                    khoiTaoBang(prefix);
                } else {
                    JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra");
                }
                selectedRowIndex = -1;
            } else {
                this.setVisible(false);
            }
        }
    }

    private void timKiemKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        String currText = timKiem.getText();
        if (Character.isAlphabetic(c) || c == ' ') {
            prefix = currText + c;
        } else if (c == KeyEvent.VK_BACK_SPACE) {
            if (currText.length() >= 1)
                prefix = currText.substring(0, currText.length() - 1);
            else
                prefix = "";
        } else {
            evt.consume();
            prefix = currText;
        }
        khoiTaoBang(prefix);
    }

    private void muonTraSachTableMouseClicked(java.awt.event.MouseEvent evt) {
        selectedRowIndex = muonTraSachTable.getSelectedRow();
        timKiem.setText(muonTraSachTable.getValueAt(selectedRowIndex, 1).toString());
    }

    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JTable muonTraSachTable;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField timKiem;
}
