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
import java.util.HashMap;
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
public class KhachHang extends javax.swing.JFrame {

   DefaultTableModel tbn = new DefaultTableModel();
    public KhachHang() {
        initComponents();
        loadData();
        loadCombobox();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void loadCombobox() {
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Select Gioitinh from KhachHang group by Gioitinh");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbGioitinh.addItem(rs.getString("Gioitinh"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
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
            ResultSet rs = st.executeQuery("Select * from KhachHang");
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
                row.addElement(rs.getString(5));
                row.addElement(rs.getString(6));
                row.addElement(rs.getString(7));
                row.addElement(rs.getString(8));
                
                
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
                        txtMakhachhang.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "");
                        txtHoten.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1) + "");
                        txtNgaysinh.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "");
                        cbGioitinh.setSelectedItem(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 3) + "");
                        txtSdt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4) + "");
                        txtDiachi.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5) + "");
                       
                        txtNghenghiep.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6) + "");
                        txtcmnd.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7) + "");
                        
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtMakhachhang = new javax.swing.JTextField();
        txtHoten = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        txtNghenghiep = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cbGioitinh = new javax.swing.JComboBox();
        txtTimKiem = new javax.swing.JTextField();
        cbTimKiem = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtTimKiem1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcmnd = new javax.swing.JTextField();
        txtTimKiem3 = new javax.swing.JTextField();
        cbDate = new javax.swing.JButton();
        cbThongKe = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lí Khách Hàng");

        jLabel2.setText("Mã KH");

        jLabel3.setText("Họ Tên");

        jLabel4.setText("Ngày Sinh");

        jLabel5.setText("Giớii tính");

        jLabel6.setText("SĐT");

        jLabel7.setText("Địa chỉ");

        jLabel8.setText("Nghề Nghiệp");

        jLabel9.setText("tìm kiếm");

        jLabel10.setText("thống kê");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mã KH", "họ tên", "giới tính", "sđt", "địa chỉ", "nghề nghiệp", "cmnd" }));
        cbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTimKiemActionPerformed(evt);
            }
        });

        jLabel11.setText("ngày");

        jLabel12.setText("tháng");

        jLabel13.setText("năm");

        jLabel14.setText("CMND");

        cbDate.setText("ngày sinh");
        cbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDateActionPerformed(evt);
            }
        });

        cbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "địa chỉ theo giới tính", "nghề nghiệp theo giới tính", "ngày sinh theo giới tính", "tháng sinh theo giới tính", "năm sinh theo giới tính" }));
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
                .addGap(300, 300, 300)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtMakhachhang)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(txtNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                                .addGap(2, 2, 2))
                                            .addComponent(txtHoten, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabel14))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel9)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNghenghiep, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(txtDiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(txtcmnd)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem3, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbDate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(cbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(txtMakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNghenghiep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtTimKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?,?)");
            ps.setString(1, txtMakhachhang.getText());
            ps.setString(2, txtHoten.getText());
            ps.setString(3, txtNgaysinh.getText());
            ps.setString(4, cbGioitinh.getSelectedItem().toString());
            ps.setString(5, txtSdt.getText());
            ps.setString(6, txtDiachi.getText());
            ps.setString(7, txtNghenghiep.getText());
            ps.setString(8, txtcmnd.getText());
            
           
            int chk = ps.executeUpdate();
            if (chk > 0) {
                JOptionPane.showMessageDialog(this, "Them thanh cong!");
                tbn.setRowCount(0);
                loadData();
            } else {
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Update KhachHang set Hoten=?,Ngaysinh=?,Gioitinh=?,Sdt=?,Diachi=?,Nghenghiep=?,CMND=?  Where Makhachhang=?");
            ps.setString(8, txtMakhachhang.getText());
            ps.setString(1, txtHoten.getText());
            ps.setString(2, txtNgaysinh.getText());
            ps.setString(3, cbGioitinh.getSelectedItem().toString());
            ps.setString(4, txtSdt.getText());
            ps.setString(5, txtDiachi.getText());
            ps.setString(6, txtNghenghiep.getText());
            ps.setString(7, txtcmnd.getText());

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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Delete KhachHang Where MaKhachHang=?");
            ps.setString(1, jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(this, "Delete this khách?", "Confirm",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                ps.executeUpdate();
                tbn.setRowCount(0);
                loadData();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDateActionPerformed
        // TODO add your handling code here:
        try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from KhachHang ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() >= 0) {
                    sql = sql + "where (month(Ngaysinh) like '" + txtTimKiem2.getText() + "') and (day(Ngaysinh) like '" + txtTimKiem1.getText() + "') and (year(Ngaysinh) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() > 0) {
                    sql = sql + "where  (year(Ngaysinh) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where (month(Ngaysinh) like '" + txtTimKiem2.getText() + "') ";
                }
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where  day(Ngaysinh) like '" + txtTimKiem1.getText() + "' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Ngày tháng năm sinh không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();
                     data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("nghenghiep"));
                      data.add(rs.getString("cmnd"));
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
    }//GEN-LAST:event_cbDateActionPerformed

    private void cbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTimKiemActionPerformed
        // TODO add your handling code here:
        String a1 = (String) cbTimKiem.getSelectedItem();
        if (a1.equals("mã KH")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from KhachHang ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where Makhachhang like '%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Mã KH không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("nghenghiep"));
                      data.add(rs.getString("cmnd"));
                
                    
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }else if (a1.equals("họ tên")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from KhachHang ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where Hoten like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Họ tên không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("nghenghiep"));
                
                    
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }else if (a1.equals("giới tính")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from KhachHang ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where Gioitinh like '%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "gender không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("nghenghiep"));
                    data.add(rs.getString("cmnd"));
                
                    
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }else if (a1.equals("sđt")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from KhachHang ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where Sdt like '%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "sdt không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("nghenghiep"));
                   data.add(rs.getString("cmnd"));
                    
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }else if (a1.equals("địa chỉ")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from KhachHang ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where Diachi like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Địa chỉ không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("nghenghiep"));
                     data.add(rs.getString("cmnd"));
                    
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }else if (a1.equals("nghề nghiệp")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from KhachHang ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where nghenghiep like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "nghề không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("nghenghiep"));
                     data.add(rs.getString("cmnd"));
                    
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }else if (a1.equals("cmnd")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from KhachHang ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where CMND like '%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "cmnd không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("makhachhang"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("nghenghiep"));
                     data.add(rs.getString("cmnd"));
                    
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_cbTimKiemActionPerformed

    private void cbThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThongKeActionPerformed
        // TODO add your handling code here:
        String a1 = (String) cbThongKe.getSelectedItem();
        if (a1.equals("địa chỉ theo giới tính")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_khachhang_diachi.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "select diachi as [Địa chỉ],isnull([Nữ],'0') as [nữ] ,isnull([Nam],'0') as [nam] \n" +
"from (\n" +
"	select diachi,gioitinh,count(*) as [số lượng]\n" +
"	from KhachHang\n" +
"	group by diachi,gioitinh\n" +
"	) as j\n" +
"	pivot\n" +
"	(\n" +
"	sum([số lượng]) for gioitinh in ([Nữ],[Nam])\n" +
"	) as j";
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
        } else if (a1.equals("nghề nghiệp theo giới tính")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_khachhang_nghenghiep.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "	  select Nghenghiep as [Nghề nghiệp],isnull([Nữ],'0') as [nữ] ,isnull([Nam],'0') as [nam] \n" +
"from (\n" +
"	select Nghenghiep,gioitinh,count(*) as [số lượng]\n" +
"	from KhachHang\n" +
"	group by Nghenghiep,gioitinh\n" +
"	) as j\n" +
"	pivot\n" +
"	(\n" +
"	sum([số lượng]) for gioitinh in ([Nữ],[Nam])\n" +
"	) as j";
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
        } else if (a1.equals("ngày sinh theo giới tính")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_khachhang_ngaysinh.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "select [ngày sinh] ,isnull([Nữ],'0') as [nữ] ,isnull([Nam],'0') as [nam] \n" +
"from (\n" +
"	select day(Ngaysinh) as[ngày sinh],gioitinh,count(*) as [số lượng]\n" +
"	from KhachHang\n" +
"	group by day(Ngaysinh),gioitinh\n" +
"	) as j\n" +
"	pivot\n" +
"	(\n" +
"	sum([số lượng]) for gioitinh in ([Nữ],[Nam])\n" +
"	) as j";
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
        } else if (a1.equals("tháng sinh theo giới tính")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_khachhang_thangsinh.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "select [tháng sinh] ,isnull([Nữ],'0') as [nữ] ,isnull([Nam],'0') as [nam] \n" +
"from (\n" +
"	select month(Ngaysinh) as[tháng sinh],gioitinh,count(*) as [số lượng]\n" +
"	from KhachHang\n" +
"	group by month(Ngaysinh),gioitinh\n" +
"	) as j\n" +
"	pivot\n" +
"	(\n" +
"	sum([số lượng]) for gioitinh in ([Nữ],[Nam])\n" +
"	) as j";
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
        }else if (a1.equals("năm sinh theo giới tính")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_khachhang_namsinh.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = " select [năm sinh] ,isnull([Nữ],'0') as [nữ] ,isnull([Nam],'0') as [nam] \n" +
"from (\n" +
"	select year(Ngaysinh) as[năm sinh],gioitinh,count(*) as [số lượng]\n" +
"	from KhachHang\n" +
"	group by year(Ngaysinh),gioitinh\n" +
"	) as j\n" +
"	pivot\n" +
"	(\n" +
"	sum([số lượng]) for gioitinh in ([Nữ],[Nam])\n" +
"	) as j";
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
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cbDate;
    private javax.swing.JComboBox cbGioitinh;
    private javax.swing.JComboBox<String> cbThongKe;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtMakhachhang;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtNghenghiep;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtTimKiem2;
    private javax.swing.JTextField txtTimKiem3;
    private javax.swing.JTextField txtcmnd;
    // End of variables declaration//GEN-END:variables
}
