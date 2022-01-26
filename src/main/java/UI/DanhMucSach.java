/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import model.DanhMucSachModel;
import process.JTableUtilities;
import process.Process;
import DataAccessObject.XuLyDanhMucSach;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DanhMucSach extends javax.swing.JFrame {

    private DefaultTableModel modelManagement;
    private int selectedRowIndex = -1;
    private XuLyDanhMucSach xuLyDanhMucSach;
    private String tenSach;
    public DanhMucSach(String maDauSach, String tenSach) {
        this.tenSach = tenSach;
        initComponents();
        setResizable(false);
        setTitle("Library Management");
        xuLyDanhMucSach = new XuLyDanhMucSach(maDauSach);
        khoiTaoBang();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        themDanhMucSachButton = new javax.swing.JButton();
        chinhSuaDanhMucSachButton = new javax.swing.JButton();
        xoaDanhMucSachButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        maDauSach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        maSach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tenSachUI = new javax.swing.JTextField();
        trangThai = new javax.swing.JComboBox<>();
        jScrollPane17 = new javax.swing.JScrollPane();
        danhMucSachTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        themDanhMucSachButton.setBackground(new java.awt.Color(255, 255, 255));
        themDanhMucSachButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        themDanhMucSachButton.setForeground(new java.awt.Color(0, 0, 0));
        themDanhMucSachButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))));
        themDanhMucSachButton.setText("Thêm");
        themDanhMucSachButton.setFocusPainted(false);
        themDanhMucSachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themDanhMucSachButtonActionPerformed(evt);
            }
        });

        chinhSuaDanhMucSachButton.setBackground(new java.awt.Color(255, 255, 255));
        chinhSuaDanhMucSachButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chinhSuaDanhMucSachButton.setForeground(new java.awt.Color(0, 0, 0));
        chinhSuaDanhMucSachButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))));
        chinhSuaDanhMucSachButton.setText("Chỉnh sửa");
        chinhSuaDanhMucSachButton.setFocusPainted(false);
        chinhSuaDanhMucSachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinhSuaDanhMucSachButtonActionPerformed(evt);
            }
        });

        xoaDanhMucSachButton.setBackground(new java.awt.Color(255, 255, 255));
        xoaDanhMucSachButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xoaDanhMucSachButton.setForeground(new java.awt.Color(0, 0, 0));
        xoaDanhMucSachButton.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))));
        xoaDanhMucSachButton.setText("Xóa");
        xoaDanhMucSachButton.setFocusPainted(false);
        xoaDanhMucSachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaDanhMucSachButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new NoScalingIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bookshelf.png"))));
        jLabel1.setText("CHI TIẾT DANH MỤC SÁCH");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ISBN");

        maDauSach.setBackground(new java.awt.Color(255, 255, 255));
        maDauSach.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        maDauSach.setForeground(new java.awt.Color(0, 0, 0));
        maDauSach.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        maDauSach.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mã Sách");

        maSach.setBackground(new java.awt.Color(255, 255, 255));
        maSach.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        maSach.setForeground(new java.awt.Color(0, 0, 0));
        maSach.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        maSach.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Trạng Thái");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tên sách");

        tenSachUI.setBackground(new java.awt.Color(255, 255, 255));
        tenSachUI.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tenSachUI.setForeground(new java.awt.Color(0, 0, 0));
        tenSachUI.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tenSachUI.setEnabled(false);

        trangThai.setBackground(new java.awt.Color(255, 255, 255));
        trangThai.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        trangThai.setForeground(new java.awt.Color(0, 0, 0));
        trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sẵn sàng", "Đang mượn", "Thanh lý / Mất" }));

        danhMucSachTable.setBackground(new java.awt.Color(255, 255, 255));
        danhMucSachTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        danhMucSachTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        danhMucSachTable.setForeground(new java.awt.Color(0, 0, 0));
        danhMucSachTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        danhMucSachTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        danhMucSachTable.setGridColor(new java.awt.Color(0, 0, 0));
        danhMucSachTable.setSelectionBackground(new java.awt.Color(204, 255, 255));
        danhMucSachTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        danhMucSachTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        danhMucSachTable.setShowGrid(true);
        danhMucSachTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                danhMucSachTableMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(danhMucSachTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tenSachUI, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maSach)
                                    .addComponent(trangThai, 0, 295, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(64, 64, 64)
                                .addComponent(maDauSach, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(136, 136, 136)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(themDanhMucSachButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chinhSuaDanhMucSachButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(xoaDanhMucSachButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maDauSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themDanhMucSachButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenSachUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chinhSuaDanhMucSachButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoaDanhMucSachButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void themDanhMucSachButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        int status = xuLyDanhMucSach.themDanhMucSach();
        if(status == XuLyDanhMucSach.THANH_CONG){
            JOptionPane.showMessageDialog(null, "Thêm danh mục sách thành công");
            khoiTaoBang();
            maSach.setText("");
            maDauSach.setText("");
            trangThai.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi");
        }
    }

    private void chinhSuaDanhMucSachButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        if(selectedRowIndex >= 0){
            int status = xuLyDanhMucSach.chinhSuaDanhMucSach(selectedRowIndex, trangThai.getSelectedIndex());
            if(status == XuLyDanhMucSach.THANH_CONG){
                JOptionPane.showMessageDialog(null, "Chỉnh sửa danh mục sách thành công");
                khoiTaoBang();
                maSach.setText("");
                maDauSach.setText("");
                trangThai.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn danh mục sách cần sửa");
        }
    }

    private void xoaDanhMucSachButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        if (selectedRowIndex >= 0){
            int status = xuLyDanhMucSach.xoaDanhMucSach(selectedRowIndex);
            if(status == XuLyDanhMucSach.THANH_CONG){
                JOptionPane.showMessageDialog(null, "Xóa danh mục sách thành công");
                khoiTaoBang();
                maSach.setText("");
                maDauSach.setText("");
                trangThai.setSelectedIndex(0);
            } else if (status == XuLyDanhMucSach.LOI_XOA_SACH){
                JOptionPane.showMessageDialog(null, "Danh mục sách này không thể xóa");
            } else {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn danh mục sách cần xóa");
        }
        selectedRowIndex = -1;
    }
    

    private void khoiTaoBang(){
        modelManagement = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        danhMucSachTable.setModel(modelManagement);
        modelManagement.setRowCount(0);
        danhMucSachTable.setModel(modelManagement);
        modelManagement.setRowCount(0);
        modelManagement.setColumnIdentifiers(new String []{"ISBN", "Tên sách", "Mã danh mục sách",  "Trạng thái"});
        for(DanhMucSachModel item: xuLyDanhMucSach.getDanhsachDanhMucSach()){
            modelManagement.addRow(new String[] {item.getMaDauSach(), tenSach, item.getMaDanhMucSach(), item.getTrangThaiSach() == 0 ? "Sẵn sàng" : item.getTrangThaiSach() == 1 ? "Đang mượn" : "Thanh lý / Mất"});
        }
        modelManagement.fireTableDataChanged();
        Process.resizeColumnWidth(danhMucSachTable);
        JTableUtilities.setCellsAlignment(danhMucSachTable, SwingConstants.CENTER);
    }
    private void danhMucSachTableMouseClicked(java.awt.event.MouseEvent evt) {                                              
        DefaultTableModel model = (DefaultTableModel) danhMucSachTable.getModel();
        selectedRowIndex = danhMucSachTable.getSelectedRow();
        maDauSach.setText(model.getValueAt(selectedRowIndex, 0).toString());
        tenSachUI.setText(tenSach);
        maSach.setText(model.getValueAt(selectedRowIndex, 2).toString());
        trangThai.setSelectedIndex(model.getValueAt(selectedRowIndex, 3).toString().equals("Sẵn sàng") ? 0 : model.getValueAt(selectedRowIndex, 3).toString().equals("Đang mượn") ? 1 : 2);
    }

    private javax.swing.JButton chinhSuaDanhMucSachButton;
    private javax.swing.JTable danhMucSachTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JTextField maDauSach;
    private javax.swing.JTextField maSach;
    private javax.swing.JTextField tenSachUI;
    private javax.swing.JButton themDanhMucSachButton;
    private javax.swing.JComboBox<String> trangThai;
    private javax.swing.JButton xoaDanhMucSachButton;
}
