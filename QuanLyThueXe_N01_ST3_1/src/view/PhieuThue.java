/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import controller.Connect;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dell
 */
public class PhieuThue extends javax.swing.JFrame {

    DefaultTableModel tbn = new DefaultTableModel();
    public PhieuThue() {
        initComponents();
        loadData();
      
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public void loadData() {
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            int number;
            Vector row, column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from PhieuThue");
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount();//tra ve so cot
            for (int i = 1; i <= number-1; i++) {
                column.add(metadata.getColumnName(i));//lay ra tieu de  cac cot
            }
            tbn.setColumnIdentifiers(column);
            while (rs.next()) {
                row = new Vector();

                row.addElement(rs.getString(1));
                row.addElement(rs.getDate(2));
                row.addElement(rs.getDate(3));
                row.addElement(rs.getString(4));
                row.addElement(rs.getString(5));
                row.addElement(rs.getString(6));
               
//                for(int i =1;i<=number;i++){
//                    row.addElement(rs.getString(i));
//                }
                tbn.addRow(row);
                jTable1.setModel(tbn);
            }
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (jTable1.getSelectedRow() >= 0) {
                        txtMaphieuthue.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "");
                        txtNgayxuat.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1) + "");
                        txtNgaythue.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "");
                        txtMakhachhang.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "");
                        txtManhanvien.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4) + "");
                        txtTiencoc.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5) + "");
                       
                        
                    }
                }
            });

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
       public void reset(){
       txtMakhachhang.setText("");
       txtManhanvien.setText("");
       txtNgaythue.setText("");
       txtNgayxuat.setText("");
       txtTiencoc.setText("");
       txtMaphieuthue.setText("");}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        rdbThem = new javax.swing.JButton();
        rdbSua = new javax.swing.JButton();
        rdbXoa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaphieuthue = new javax.swing.JTextField();
        txtNgayxuat = new javax.swing.JTextField();
        txtNgaythue = new javax.swing.JTextField();
        txtMakhachhang = new javax.swing.JTextField();
        txtManhanvien = new javax.swing.JTextField();
        txtTiencoc = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        cbTimKiem = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTimKiem2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem3 = new javax.swing.JTextField();
        cbDate = new javax.swing.JComboBox<>();
        cbThongKe = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Phiếu Thuê");

        jLabel2.setText("Mã Phiếu Thuê");

        jLabel3.setText("Ngày Xuất");

        jLabel4.setText("Ngày Thuê");

        jLabel5.setText("Mã KH");

        jLabel6.setText("Mã NV");

        jLabel7.setText("Tiền cọc");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        rdbThem.setText("thêm");
        rdbThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbThemActionPerformed(evt);
            }
        });

        rdbSua.setText("sửa");
        rdbSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbSuaActionPerformed(evt);
            }
        });

        rdbXoa.setText("xóa");
        rdbXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbXoaActionPerformed(evt);
            }
        });

        jLabel8.setText("tìm kiếm");

        jLabel9.setText("thống kê theo :");

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mã phiếu thuê", "mã kh", "mã nv" }));
        cbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTimKiemActionPerformed(evt);
            }
        });

        jLabel10.setText("ngày");

        jLabel11.setText("tháng");

        jLabel12.setText("năm");

        cbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ngày xuất", "ngày thuê" }));
        cbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDateActionPerformed(evt);
            }
        });

        cbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nhân viên", "ngày thuê", "tháng thuê", "năm thuê" }));
        cbThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTimKiem))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdbThem)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbSua)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbXoa)
                                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNgaythue)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMaphieuthue, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNgayxuat)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMakhachhang)
                                    .addComponent(txtManhanvien)
                                    .addComponent(txtTiencoc, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(txtMaphieuthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(txtNgayxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtManhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(txtNgaythue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbThem)
                            .addComponent(rdbSua)
                            .addComponent(rdbXoa))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtTimKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private boolean checkTrungMaSach(){
        try {
            Connection connection = Connect.getConnection();
            String query = "SELECT * FROM dbo.phieuthue where Maphieuthue = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, txtMaphieuthue.getText());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BangXe.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
          
            
        
    
   
        
}
    private void rdbThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbThemActionPerformed
 if(txtMaphieuthue.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Chua Nhap  Ma  nhap Xe");
       txtMaphieuthue.requestFocus();
       return;
       }
       else if(txtMakhachhang.getText().equals("")){
       JOptionPane.showMessageDialog(rootPane, "Chua Nhap bien so");
       txtMakhachhang.requestFocus();
       return;}
       else if(txtManhanvien.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Chua Nhap mau xe");
       txtManhanvien.requestFocus();
       return;}
       else if (txtNgaythue.getText().equals("")){
       JOptionPane.showMessageDialog(rootPane, "Chua Nhap giathue");
        txtNgaythue.requestFocus();
       return;}
       else if(txtNgayxuat.getText().equals("")){JOptionPane.showMessageDialog(null, "them trang thai chua thanh cong");
       return;}
       else if(txtTiencoc.getText().equals("")){JOptionPane.showMessageDialog(null, "them thoi gian bao hiem chua thanh cong");
       return;}
       String masach=txtMaphieuthue.getText();
       if(masach.length()!=6){
       JOptionPane.showMessageDialog(rootPane, "MaPT phai co 6 ki tu theo dinh dang MPTxxx");
       txtMaphieuthue.requestFocus();
       return;}
        try {
            String a1=txtMaphieuthue.getText(0, 3);
            boolean a5=a1.equals("MPT");
           
            boolean a3=Character.isDigit(masach.charAt(3));
              boolean a4=Character.isDigit(masach.charAt(4));
              boolean a6=Character.isDigit(masach.charAt(5));
              if((a3&&a4&&a5&&a6)==false){
                  JOptionPane.showMessageDialog(null, "nhap sai dinh dang Ma Xe MPTxxx");
                  return;
              }
        } catch (BadLocationException ex) {
            Logger.getLogger(BangXe.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      if(checkTrungMaSach()==true){
          JOptionPane.showMessageDialog(null,"Ma  phieu thue da ton tai");
          txtMaphieuthue.requestFocus();
          return;
          
      }   // TODO add your han        // TODO add your handling code here:
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into PhieuThue values(?,?,?,?,?,?)");
            ps.setString(1, txtMaphieuthue.getText());
            ps.setString(2, txtNgayxuat.getText());
            ps.setString(3, txtNgaythue.getText());
            ps.setString(4, txtMakhachhang.getText());
             ps.setString(5, txtManhanvien.getText());
              ps.setString(6, txtTiencoc.getText());
           
           
            int chk = ps.executeUpdate();
            if (chk > 0) {
                JOptionPane.showMessageDialog(this, "Them thanh cong!");
                tbn.setRowCount(0);
                loadData();
                new ChiTietPhieuThue().setVisible(true);
            } else {
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
                                

   
    }//GEN-LAST:event_rdbThemActionPerformed

    private void rdbSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSuaActionPerformed
        // TODO add your handling code here:
          try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Update PhieuThue set Ngayxuat=?,Ngaythue=?,Makhachhang=?,Manhanvien=?,Tiencoc=? Where Maphieuthue=?");
              ps.setString(6, txtMaphieuthue.getText());
            ps.setString(1, txtNgayxuat.getText());
            ps.setString(2, txtNgaythue.getText());
            ps.setString(3, txtMakhachhang.getText());
             ps.setString(4, txtManhanvien.getText());
              ps.setString(5, txtTiencoc.getText());

            int chk = ps.executeUpdate();
            if (chk > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thanh cong!");
                tbn.setRowCount(0);
                loadData();
            } else {
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_rdbSuaActionPerformed

    private void rdbXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbXoaActionPerformed
        // TODO add your handling code here:
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Delete PhieuThue Where Maphieuthue=?");
            ps.setString(1, jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(this, "Delete this PHieuthue?", "Confirm",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                ps.executeUpdate();
                tbn.setRowCount(0);
                loadData();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_rdbXoaActionPerformed

    private void cbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTimKiemActionPerformed
        // TODO add your handling code here:
         String a1 = (String) cbTimKiem.getSelectedItem();
        if (a1.equals("mã phiếu thuê")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from PhieuThue ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where maphieuthue like '%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "mã phiếu thuê không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("maphieuthue"));
                   data.add(rs.getDate("ngayxuat"));
                   data.add(rs.getDate("ngaythue"));
                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("manhanvien"));
                    data.add(rs.getString("tiencoc"));
                 
                    
                
                   
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }else  if (a1.equals("mã kh")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from PhieuThue ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where makhachhang like '%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "mã KH không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("maphieuthue"));
                   data.add(rs.getDate("ngayxuat"));
                   data.add(rs.getDate("ngaythue"));
                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("manhanvien"));
                    data.add(rs.getString("tiencoc"));
                 
                    
                
                   
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else  if (a1.equals("mã nv")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from PhieuThue ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where manhanvien like '%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "mã nhân viên không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("maphieuthue"));
                    data.add(rs.getDate("ngayxuat"));
                   data.add(rs.getDate("ngaythue"));
                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("manhanvien"));
                    data.add(rs.getString("tiencoc"));
                 
                    
                
                   
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_cbTimKiemActionPerformed

    private void cbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDateActionPerformed
        // TODO add your handling code here:
        String a2 = (String) cbDate.getSelectedItem();
        if (a2.equals("ngày xuất")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from PhieuThue ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() >= 0) {
                    sql = sql + "where (month(Ngayxuat) like '" + txtTimKiem2.getText() + "') and (day(Ngayxuat) like '" + txtTimKiem1.getText() + "') and (year(Ngayxuat) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() > 0) {
                    sql = sql + "where  (year(Ngayxuat) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where (month(Ngayxuat) like '" + txtTimKiem2.getText() + "') ";
                }
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where  day(Ngayxuat) like '" + txtTimKiem1.getText() + "' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Ngày tháng năm xuất không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();
                    
                    data.add(rs.getString("maphieuthue"));
                    data.add(rs.getDate("ngayxuat"));
                   data.add(rs.getDate("ngaythue"));
                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("manhanvien"));
                    data.add(rs.getString("tiencoc"));
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else if (a2.equals("ngày thuê")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from PhieuThue ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() >= 0) {
                    sql = sql + "where (month(Ngaythue) like '" + txtTimKiem2.getText() + "') and (day(Ngaythue) like '" + txtTimKiem1.getText() + "') and (year(Ngaythue) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() > 0) {
                    sql = sql + "where  (year(Ngaythue) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where (month(Ngaythue) like '" + txtTimKiem2.getText() + "') ";
                }
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where  day(Ngaythue) like '" + txtTimKiem1.getText() + "' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Ngày tháng năm thuê không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();
                    
                    data.add(rs.getString("maphieuthue"));
                    data.add(rs.getDate("ngayxuat"));
                   data.add(rs.getDate("ngaythue"));
                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("manhanvien"));
                    data.add(rs.getString("tiencoc"));
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } 
    }//GEN-LAST:event_cbDateActionPerformed

    private void cbThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThongKeActionPerformed
        // TODO add your handling code here:
        String a1 = (String) cbThongKe.getSelectedItem();
        
        if (a1.equals("nhân viên")) {
           try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_phieuthue_nhanvien.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "select NhanVien.Manhanvien,Hoten,count(*) as [Số lượng phiếu], sum(Tiencoc) as [tiền cọc],sum(tienphat) as [tienphat]\n" +
"	from PhieuThue,ChiTietPhieuThue,NhanVien\n" +
"	where PhieuThue.Maphieuthue=ChiTietPhieuThue.Maphieuthue and NhanVien.Manhanvien=PhieuThue.Manhanvien\n" +
"	group by NhanVien.Manhanvien,Hoten";
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                HashMap para = new HashMap();
                JasperPrint j = JasperFillManager.fillReport(jr, para, conn);
                JasperViewer.viewReport(j, false);
                OutputStream os = new FileOutputStream(new File("E:\\report"));
                JasperExportManager.exportReportToPdfStream(j, os);
                JasperExportManager.exportReportToXmlStream(j, os);

            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        } else if (a1.equals("ngày thuê")) {
           try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_phieuthue_ngaythue.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "select day(Ngaythue) as [ngày thuê],count(*) as [Số lượng phiếu], sum(Tiencoc) as [tiền cọc],sum(tienphat) as [tienphat]\n" +
"	from PhieuThue,ChiTietPhieuThue\n" +
"	where PhieuThue.Maphieuthue=ChiTietPhieuThue.Maphieuthue \n" +
"	group by day(Ngaythue)";
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                HashMap para = new HashMap();
                JasperPrint j = JasperFillManager.fillReport(jr, para, conn);
                JasperViewer.viewReport(j, false);
                OutputStream os = new FileOutputStream(new File("E:\\report"));
                JasperExportManager.exportReportToPdfStream(j, os);
                JasperExportManager.exportReportToXmlStream(j, os);

            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        } else if (a1.equals("tháng thuê")) {
           try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_phieuthue_thangthue.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "select month(Ngaythue) as [tháng thuê],count(*) as [Số lượng phiếu], sum(Tiencoc) as [tiền cọc],sum(tienphat) as [tienphat]\n" +
"	from PhieuThue,ChiTietPhieuThue\n" +
"	where PhieuThue.Maphieuthue=ChiTietPhieuThue.Maphieuthue \n" +
"	group by month(Ngaythue)";
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                HashMap para = new HashMap();
                JasperPrint j = JasperFillManager.fillReport(jr, para, conn);
                JasperViewer.viewReport(j, false);
                OutputStream os = new FileOutputStream(new File("E:\\report"));
                JasperExportManager.exportReportToPdfStream(j, os);
                JasperExportManager.exportReportToXmlStream(j, os);

            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        } else if (a1.equals("năm thuê")) {
           try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_phieuthue_namthue.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "	select year(Ngaythue) as [năm thuê],count(*) as [Số lượng phiếu], sum(Tiencoc) as [tiền cọc],sum(tienphat) as [tienphat]\n" +
"	from PhieuThue,ChiTietPhieuThue\n" +
"	where PhieuThue.Maphieuthue=ChiTietPhieuThue.Maphieuthue \n" +
"	group by year(Ngaythue)";
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                HashMap para = new HashMap();
                JasperPrint j = JasperFillManager.fillReport(jr, para, conn);
                JasperViewer.viewReport(j, false);
                OutputStream os = new FileOutputStream(new File("E:\\report"));
                JasperExportManager.exportReportToPdfStream(j, os);
                JasperExportManager.exportReportToXmlStream(j, os);

            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        } 
    }//GEN-LAST:event_cbThongKeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuThue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbDate;
    private javax.swing.JComboBox<String> cbThongKe;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton rdbSua;
    private javax.swing.JButton rdbThem;
    private javax.swing.JButton rdbXoa;
    private javax.swing.JTextField txtMakhachhang;
    private javax.swing.JTextField txtManhanvien;
    private javax.swing.JTextField txtMaphieuthue;
    private javax.swing.JTextField txtNgaythue;
    private javax.swing.JTextField txtNgayxuat;
    private javax.swing.JTextField txtTiencoc;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtTimKiem2;
    private javax.swing.JTextField txtTimKiem3;
    // End of variables declaration//GEN-END:variables
}
