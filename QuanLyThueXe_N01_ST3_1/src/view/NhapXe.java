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
public class NhapXe extends javax.swing.JFrame {

    DefaultTableModel tbn = new DefaultTableModel();
    public NhapXe() {
        initComponents();
          loadData();
      
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

     //ham do du lieu vao bang

    public void loadData() {
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            int number;
            Vector row, column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from NhapXe");
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount();//tra ve so cot
            for (int i = 1; i <= number; i++) {
                column.add(metadata.getColumnName(i));//lay ra tieu de  cac cot
            }
            tbn.setColumnIdentifiers(column);
            while (rs.next()) {
                row = new Vector();

                row.addElement(rs.getString(1));
                row.addElement(rs.getString(2));
                row.addElement(rs.getDate(3));
                row.addElement(rs.getString(4));
               
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
                        txtManhapxe.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "");
                        txtMancc.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1) + "");
                        txtNgaynhap.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "");
                        txtManhanvien.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "");
                       
                        
                    }
                }
            });

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtManhapxe = new javax.swing.JTextField();
        txtMancc = new javax.swing.JTextField();
        txtNgaynhap = new javax.swing.JTextField();
        txtManhanvien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        rdbThem = new javax.swing.JButton();
        rdbSua = new javax.swing.JButton();
        rdbXoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        cbTimKiem = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiem1 = new javax.swing.JTextField();
        txtTimKiem2 = new javax.swing.JTextField();
        txtTimKiem3 = new javax.swing.JTextField();
        cbDate = new javax.swing.JButton();
        cbThongKe = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lí Nhập Xe");

        jLabel2.setText("Mã Nhập Xe");

        jLabel3.setText("Mã NCC");

        jLabel4.setText("Ngày nhập");

        jLabel5.setText("Mã Nhân Viên");

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

        jLabel6.setText("tìm kiếm");

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mã nhập xe", "mã ncc", "mã nhân viên" }));
        cbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTimKiemActionPerformed(evt);
            }
        });

        jLabel8.setText("ngày");

        jLabel9.setText("tháng");

        jLabel10.setText("năm");

        cbDate.setText("tìm ngày nhập");
        cbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDateActionPerformed(evt);
            }
        });

        cbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nhân viên", "ngày nhập", "tháng nhập", "năm nhập" }));
        cbThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThongKeActionPerformed(evt);
            }
        });

        jLabel11.setText("thống kê theo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(218, 218, 218))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtMancc, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                            .addComponent(txtManhapxe))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNgaynhap)
                                            .addComponent(txtManhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdbThem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdbSua)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdbXoa)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTimKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbDate))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(txtManhapxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(txtMancc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtManhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTimKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbDate))))
                        .addGap(17, 17, 17)
                        .addComponent(cbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbThem)
                    .addComponent(rdbSua)
                    .addComponent(rdbXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbThemActionPerformed
         if(txtManhapxe.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Chua Nhap  Ma  nhap Xe");
       txtManhapxe.requestFocus();
       return;
       }
       else if(txtManhanvien.getText().equals("")){
       JOptionPane.showMessageDialog(rootPane, "Chua Nhap ma nhan vien");
       txtManhanvien.requestFocus();
       return;}
       else if(txtNgaynhap.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Chua Nhap mau xe");
       txtNgaynhap.requestFocus();
       return;}
       else if (txtManhanvien.getText().equals("")){
       JOptionPane.showMessageDialog(rootPane, "Chua Nhap giathue");
        txtManhanvien.requestFocus();
       return;}
       String masach=txtManhapxe.getText();
       if(masach.length()!=6){
       JOptionPane.showMessageDialog(rootPane, "MaNhapXe phai co 6 ki tu");
       txtManhapxe.requestFocus();
       return;}
        try {
            String a1=txtManhapxe.getText(0, 3);
            boolean a5=a1.equals("MNX");
           
            boolean a3=Character.isDigit(masach.charAt(3));
              boolean a4=Character.isDigit(masach.charAt(4));
              boolean a6=Character.isDigit(masach.charAt(5));
              if((a3&&a4&&a5&&a6)==false){
                  JOptionPane.showMessageDialog(null, "nhap sai dinh dang Ma Xe MXxxxx");
                  return;
              }
        } catch (BadLocationException ex) {
            Logger.getLogger(BangXe.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      if(checkTrungMaSach()==true){
          JOptionPane.showMessageDialog(null,"Ma Nhap Xe da ton tai");
          txtManhapxe.requestFocus();
          return;
          
      }   // TODO add your handling code h  // TODO add your handl
        

// TODO add your handling code here:
         try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into Nhapxe values(?,?,?,?)");
            ps.setString(1, txtManhapxe.getText());
            ps.setString(2, txtMancc.getText());
            ps.setString(3, txtNgaynhap.getText());
            ps.setString(4, txtManhanvien.getText());
           
           
            int chk = ps.executeUpdate();
            if (chk > 0) {
                JOptionPane.showMessageDialog(this, "Them thanh cong!");
                tbn.setRowCount(0);
                loadData();
                new ChiTietNhapXe().setVisible(true);
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
            PreparedStatement ps = conn.prepareStatement("Update Nhapxe set Mancc=?,Ngaynhap=?,Manhanvien=? Where Manhapxe=?");
            ps.setString(4, txtManhapxe.getText());
            ps.setString(1, txtMancc.getText());
            ps.setString(2, txtNgaynhap.getText());
            ps.setString(3, txtManhanvien.getText());

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
private boolean checkTrungMaSach(){
        try {
            Connection connection = Connect.getConnection();
            String query = "SELECT * FROM dbo.nhapxe where Manhapxe= ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, txtManhapxe.getText());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BangXe.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
          
            
        
    
   
        
}
    private void rdbXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbXoaActionPerformed
        // TODO add your handling code here:
         try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Delete NhapXe Where Manhapxe=?");
            ps.setString(1, jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(this, "Delete this NhanVien?", "Confirm",
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
        if (a1.equals("mã nhập xe")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from NhapXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where manhapxe like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "mã nhập xe không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("manhapxe"));
                    data.add(rs.getString("mancc"));
                   data.add(rs.getDate("ngaynhap"));
                    data.add(rs.getString("manhanvien"));
                    
                
                   
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }else if (a1.equals("mã ncc")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from NhapXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where mancc like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "mã nhà cung cấp không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("manhapxe"));
                    data.add(rs.getString("mancc"));
                    data.add(rs.getDate("ngaynhap"));
                    data.add(rs.getString("manhanvien"));
                    
                
                   
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else if (a1.equals("mã nhân viên")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from NhapXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where manhanvien like N'%" + txtTimKiem.getText() + "%' ";
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

                    data.add(rs.getString("manhapxe"));
                    data.add(rs.getString("mancc"));
                    data.add(rs.getDate("ngaynhap"));
                    data.add(rs.getString("manhanvien"));
                    
                
                   
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
         try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from NhapXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() >= 0) {
                    sql = sql + "where (month(Ngaynhap) like '" + txtTimKiem2.getText() + "') and (day(Ngaynhap) like '" + txtTimKiem1.getText() + "') and (year(Ngaynhap) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() > 0) {
                    sql = sql + "where  (year(Ngaynhap) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where (month(Ngaynhap) like '" + txtTimKiem2.getText() + "') ";
                }
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where  day(Ngaynhap) like '" + txtTimKiem1.getText() + "' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Ngày tháng năm nhập không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();
                  data.add(rs.getString("manhapxe"));
                    data.add(rs.getString("mancc"));
                    data.add(rs.getDate("ngaynhap"));
                    data.add(rs.getString("manhanvien"));
                    
                    
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
    }//GEN-LAST:event_cbDateActionPerformed

    private void cbThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThongKeActionPerformed
        // TODO add your handling code here:
        String a1 = (String) cbThongKe.getSelectedItem();
        if (a1.equals("nhân viên")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_nhapxe_nhanvien.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "	select Nhapxe.Manhanvien,NhanVien.Hoten,count(*) as [Số lượng phiếu], sum(Tiencoc) as [tiền cọc],sum(giaxe) as [giá xe]\n" +
"	from NhapXe,ChiTietNhapXe,NhanVien \n" +
"	where NhapXe.Manhapxe=ChiTietNhapXe.Manhapxe and NhapXe.Manhanvien=NhanVien.Manhanvien\n" +
"	group by Nhapxe.Manhanvien,NhanVien.Hoten";
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
        }else if (a1.equals("ngày nhập")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_nhapxe_ngaynhap.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "	select day(ngaynhap) as [ngày nhập],count(*) as [Số lượng phiếu], sum(Tiencoc) as [tiền cọc],sum(giaxe) as [giá xe]\n" +
"	from NhapXe,ChiTietNhapXe\n" +
"	where NhapXe.Manhapxe=ChiTietNhapXe.Manhapxe \n" +
"	group by day(ngaynhap)";
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
        } else if (a1.equals("tháng nhập")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_nhapxe_thangnhap.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "	select month(ngaynhap) as [tháng nhập],count(*) as [Số lượng phiếu], sum(Tiencoc) as [tiền cọc],sum(giaxe) as [giá xe]\n" +
"	from NhapXe,ChiTietNhapXe\n" +
"	where NhapXe.Manhapxe=ChiTietNhapXe.Manhapxe \n" +
"	group by month(ngaynhap)";
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
        } else if (a1.equals("năm nhập")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_nhapxe_namnhap.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "	select year(ngaynhap) as [năm nhập],count(*) as [Số lượng phiếu], sum(Tiencoc) as [tiền cọc],sum(giaxe) as [giá xe]\n" +
"	from NhapXe,ChiTietNhapXe\n" +
"	where NhapXe.Manhapxe=ChiTietNhapXe.Manhapxe \n" +
"	group by year(ngaynhap)";
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
            java.util.logging.Logger.getLogger(NhapXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhapXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhapXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhapXe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cbDate;
    private javax.swing.JComboBox<String> cbThongKe;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton rdbSua;
    private javax.swing.JButton rdbThem;
    private javax.swing.JButton rdbXoa;
    private javax.swing.JTextField txtMancc;
    private javax.swing.JTextField txtManhanvien;
    private javax.swing.JTextField txtManhapxe;
    private javax.swing.JTextField txtNgaynhap;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtTimKiem2;
    private javax.swing.JTextField txtTimKiem3;
    // End of variables declaration//GEN-END:variables
}
