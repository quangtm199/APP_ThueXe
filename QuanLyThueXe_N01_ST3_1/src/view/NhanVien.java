
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
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import model.objnhanvien;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class NhanVien extends javax.swing.JFrame {

   DefaultTableModel tbn = new DefaultTableModel();
    public NhanVien() {
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
            PreparedStatement ps = conn.prepareStatement("Select Gioitinh from NhanVien group by Gioitinh");
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
            ResultSet rs = st.executeQuery("Select * from NhanVien");
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
                row.addElement(rs.getString(9));
                
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
                        txtManhanvien.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "");
                        txtHoten.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1) + "");
                        txtNgaysinh.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "");
                        cbGioitinh.setSelectedItem(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 3) + "");
                        txtSdt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4) + "");
                        txtDiachi.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5) + "");
                        if (jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString().equals("1")) {
                            rdbQuanli.setSelected(true);
                        } else if (jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString().equals("0")) {
                            rdbNhanvien.setSelected(true);
                        }
                        txtUsername.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7) + "");
                        txtpass.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 8) + "");
                        
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

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtManhanvien = new javax.swing.JTextField();
        txtHoten = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JTextField();
        cbGioitinh = new javax.swing.JComboBox();
        txtSdt = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        rdbQuanli = new javax.swing.JRadioButton();
        rdbNhanvien = new javax.swing.JRadioButton();
        txtUsername = new javax.swing.JTextField();
        txtpass = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfnhapfile = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        cbTimKiem = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtTimKiem1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTimKiem2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTimKiem3 = new javax.swing.JTextField();
        cbDate = new javax.swing.JButton();
        cbThongKe = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Quản lí Nhân Viên");

        jLabel2.setText("Mã NV");

        jLabel3.setText("Họ tên");

        jLabel4.setText("Ngày Sinh");

        jLabel5.setText("Giới tính");

        jLabel6.setText("Sđt");

        jLabel7.setText("Địa Chỉ");

        jLabel8.setText("chức vụ");

        jLabel9.setText("tài khoản");

        jLabel10.setText("mật khẩu");

        btnThem.setText("thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel11.setText("Tìm Kiếm");

        jLabel12.setText("Thống Kê");

        buttonGroup1.add(rdbQuanli);
        rdbQuanli.setText("quản lí");

        buttonGroup1.add(rdbNhanvien);
        rdbNhanvien.setText("nhân viên");
        rdbNhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNhanvienActionPerformed(evt);
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

        jButton1.setText("nhập file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("xuất file excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mã nv", "họ tên", "sđt", "địa chỉ" }));
        cbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTimKiemActionPerformed(evt);
            }
        });

        jLabel13.setText("ngày");

        jLabel14.setText("tháng");

        txtTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiem2ActionPerformed(evt);
            }
        });

        jLabel15.setText("năm");

        cbDate.setText("tìm ngày sinh");
        cbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDateActionPerformed(evt);
            }
        });

        cbThongKe.setEditable(true);
        cbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "địa chỉ theo giới tính", "ngày sinh theo giới tính", "tháng sinh theo giới tính", "năm sinh theo giới tính" }));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                        .addComponent(txtHoten)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSdt)
                                        .addComponent(cbGioitinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(txtManhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTimKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(cbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnXoa)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdbQuanli)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbNhanvien))
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(235, 235, 235))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(519, 519, 519)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfnhapfile, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(tfnhapfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(txtManhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdbQuanli)
                                    .addComponent(rdbNhanvien))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtTimKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDate))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbNhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNhanvienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbNhanvienActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
         if(txtManhanvien.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Chua Nhap Ma nhan vien ");
     
       return;
       }
       else if(txtDiachi.getText().equals("")){
       JOptionPane.showMessageDialog(rootPane, "Chua Nhap dia chi");
       
       return;}
       else if(txtHoten.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Chua Nhap ho ten");
      
       return;}
       else if (txtSdt.getText().equals("")){
       JOptionPane.showMessageDialog(rootPane, "Chua Nhap sdt");
       
       return;}
       else if(txtNgaysinh.getText().equals("")){JOptionPane.showMessageDialog(null, "chua nhap ngay sinh");
       return;}
       else if(txtUsername.getText().equals("")){JOptionPane.showMessageDialog(null, "chua nhap username");
       return;}
       String masach=txtManhanvien.getText();
       if(masach.length()!=6){
       JOptionPane.showMessageDialog(rootPane, "Ma nhan vien phai co 6 ki tu");
       txtManhanvien.requestFocus();
       return;}
        try {
            String a1=txtManhanvien.getText(0, 2);
            boolean a5=a1.equals("NV");
            boolean a2=Character.isDigit(masach.charAt(2));
            boolean a3=Character.isDigit(masach.charAt(3));
              boolean a4=Character.isDigit(masach.charAt(4));
              boolean a6=Character.isDigit(masach.charAt(5));
              if((a2&&a3&&a4&&a5&&a6)==false){
                  JOptionPane.showMessageDialog(null, "nhap sai dinh dang Ma Xe NCCxxx");
                  return;
              }
        } catch (BadLocationException ex) {
            Logger.getLogger(BangXe.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      if(checkTrungMaSach()==true){
          JOptionPane.showMessageDialog(null,"Ma Nhan vien da ton tai");
          txtManhanvien.requestFocus();
          return;
          
      }   // TODO add your handling code here
        // TODO add your handling code here:
         try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, txtManhanvien.getText());
            ps.setString(2, txtHoten.getText());
            ps.setString(3, txtNgaysinh.getText());
            ps.setString(4, cbGioitinh.getSelectedItem().toString());
            ps.setString(5, txtSdt.getText());
            ps.setString(6, txtDiachi.getText());
            if (rdbQuanli.isSelected()) {
                ps.setBoolean(7, true);
            } else {
                ps.setBoolean(7, false);
            }
            ps.setString(8, txtUsername.getText());
            ps.setString(9, txtpass.getText());
           
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
    }//GEN-LAST:event_btnThemActionPerformed
private boolean checkTrungMaSach(){
        try {
            Connection connection = Connect.getConnection();
            String query = "SELECT * FROM dbo.nhanvien where manhanvien = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, txtManhanvien.getText());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BangXe.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
          
            
        
    
   
        
}
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
         try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Update NhanVien set Hoten=?,Ngaysinh=?,Gioitinh=?,Sdt=?,Diachi=?,Chucvu=?,Username=?,Pass=?  Where Manhanvien=?");
            ps.setString(9, txtManhanvien.getText());
            ps.setString(1, txtHoten.getText());
            ps.setString(2, txtNgaysinh.getText());
            ps.setString(3, cbGioitinh.getSelectedItem().toString());
            ps.setString(4, txtSdt.getText());
            ps.setString(5, txtDiachi.getText());
            if (rdbQuanli.isSelected()) {
                ps.setBoolean(6, true);
            } else {
                ps.setBoolean(6, false);
            }
            ps.setString(7, txtUsername.getText());
            ps.setString(8, txtpass.getText());

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
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
         try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Delete NhanVien Where Manhanvien=?");
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
    }//GEN-LAST:event_btnXoaActionPerformed
public class ReadExcelDemo {
 
   public  void main(String[] args) throws IOException {
  
       // Đọc một file XSL.
       FileInputStream inputStream = new FileInputStream(new File("C:/demo/employee.xls"));
  
       // Đối tượng workbook cho file XSL.
       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
  
       // Lấy ra sheet đầu tiên từ workbook
       HSSFSheet sheet = workbook.getSheetAt(1);
 
  
       // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
       Iterator<Row> rowIterator = sheet.iterator();
 
       while (rowIterator.hasNext()) {
           Row row = rowIterator.next();
     
           // Lấy Iterator cho tất cả các cell của dòng hiện tại.
           Iterator<Cell> cellIterator = row.cellIterator();
 
           while (cellIterator.hasNext()) {
               Cell cell = cellIterator.next();
  
               // Đổi thành getCellType() nếu sử dụng POI 4.x
               CellType cellType = cell.getCellType();
 
               switch (cellType) {
               case _NONE:
                   System.out.print("");
                   System.out.print("\t");
                   break;
               case BOOLEAN:
                   System.out.print(cell.getBooleanCellValue());
                   System.out.print("\t");
                   break;
               case BLANK:
                   System.out.print("");
                   System.out.print("\t");
                   break;
               case FORMULA:
       
                   // Công thức
                   System.out.print(cell.getCellFormula());
                   System.out.print("\t");
                    
                   FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
         
                   // In ra giá trị từ công thức
                   System.out.print(evaluator.evaluate(cell).getNumberValue());
                   break;
               case NUMERIC:
                   System.out.print(cell.getNumericCellValue());
                   System.out.print("\t");
                   break;
               case STRING:
                   System.out.print(cell.getStringCellValue());
                   System.out.print("\t");
                   break;
               case ERROR:
                   System.out.print("!");
                   System.out.print("\t");
                   break;
               }
 
           }
           System.out.println("");
       }
   }
 
}

    public class SimpleExcelReader {

    public void main(String[] args) throws IOException {
	    String excelFilePath = "E:/NiceJavaBooks.xls";
	    SimpleExcelReader reader = new SimpleExcelReader();
	    List< objnhanvien> listBooks = reader.readBooksFromExcelFile(excelFilePath);
	    System.out.println(listBooks);
	}

	private Object getCellValue(Cell cell) {
           CellType celltype = cell.getCellType();
           Object cellvalue = null;
	    switch (celltype) {
	    case STRING:
               return cell.getStringCellValue();
	      
	 
	    case BOOLEAN:
	        return cell.getBooleanCellValue();
	 
            case NUMERIC :
	        return cell.getNumericCellValue();
            case _NONE:
            case BLANK :
            case ERROR:
                break;
            default:break;
            }
	 
	    return cellvalue;
	}
	
	public List<objnhanvien> readBooksFromExcelFile(String excelFilePath) throws IOException {
	    List<objnhanvien> listBooks = new ArrayList<>();
	    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	 
	    Workbook workbook = getWorkbook(inputStream, excelFilePath);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	     
	    if(iterator.hasNext()) {
	        Row nextRow = iterator.next();
           
	        Iterator<Cell> cellIterator = nextRow.cellIterator();      
	    }
	 while(iterator.hasNext()) {
	        Row nextRow = iterator.next();
           
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	       objnhanvien aBook = new objnhanvien();
	 
	        while (cellIterator.hasNext()) {
	            Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex();
	 
	            switch (columnIndex) {
                        
                        
                        
	            case 0:
	                aBook.setManhanvien((String) getCellValue(nextCell));
	                break;
	            case 1:
	                aBook.setHoten((String) getCellValue(nextCell));
	                break;
	            case 2:
	                aBook.setNgaysinh((String) getCellValue(nextCell));
	                break;
                    case 3:
	                aBook.setGioitinh((String) getCellValue(nextCell));
	                break;
                    case 4:
	                aBook.setSdt((String) getCellValue(nextCell));
	                break;
                       case 5:
	                aBook.setDiachi((String) getCellValue(nextCell));
	                break;
                            case 6:
	                aBook.setChucvu((String) getCellValue(nextCell));
	                break;
	                case 7:
	                aBook.setUsername((String) getCellValue(nextCell));
	                break;
                                case 8:
	                aBook.setPass((String) getCellValue(nextCell));
	                break;
                    
                    
                    }
	 
	 
	        }
	        listBooks.add(aBook);
	    }
	    workbook.close();
	    inputStream.close();
	 
	    return listBooks;
	}
	
    //Được sử dụng để có thể đọc được cả định dạng .xls và xlsx
	private Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
	        throws IOException {
	    Workbook workbook = null;
	 
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook(inputStream);
	    } else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook(inputStream);
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	 
	    return workbook;
	}
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try {
            String excelFilePath = tfnhapfile.getText();
            SimpleExcelReader reader = new SimpleExcelReader();
            List<objnhanvien> listBooks;
            
        
            listBooks = reader.readBooksFromExcelFile(excelFilePath);
            for (objnhanvien aBook : listBooks) {
                Connection connection = Connect.getConnection();
            String query = "INSERT INTO dbo.[nhanvien](manhanvien, hoten , ngaysinh, gioitinh, sdt,diachi,chucvu,username,pass) "+
                    "VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps;
                try {
                    ps = connection.prepareStatement(query);
               
            ps.setString(1, aBook.getManhanvien());
            ps.setString(2, aBook.getHoten());
            ps.setString(3, aBook.getNgaysinh());
            ps.setString(4, aBook.getGioitinh());
            ps.setString(5, aBook.getSdt());
            
            ps.setString(6, aBook.getDiachi());
            ps.setString(7, aBook.getChucvu());
              ps.setString(8, aBook.getUsername());
               ps.setString(9, aBook.getPass());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "Đã Trùng Mã Nhan Vien");
                   break;
                }
                 tbn.setRowCount(0);
           loadData();
            Connect.closeConnection(connection);
           
           
            
            }
           
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "nhap dung duong dan file ");
        }
                 // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
SimpleExcelWriter excelWriter = new SimpleExcelWriter();
		 
		List<objnhanvien> listBook = excelWriter.getListBook();
		String excelFilePath = "E:/BangSach.xls";
		 
		try {
			excelWriter.writeExcel(listBook, excelFilePath);
                        JOptionPane.showMessageDialog(null, "da xuat thanh cong ra E:/BangSach.xls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Đã Có lỗi Xảy ra vui lòng kiểm tra lại");
		}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTimKiemActionPerformed
        // TODO add your handling code here:
        String a1 = (String) cbTimKiem.getSelectedItem();
        if (a1.equals("mã nv")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from NhanVien ";
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
                    JOptionPane.showMessageDialog(this, "Mã nv không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("manhanvien"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("chucvu"));
                    data.add(rs.getString("username"));
                    data.add(rs.getString("pass"));
                
                   
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
                String sql = "select * from NhanVien ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where hoten like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "họ tên nv không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("manhanvien"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("chucvu"));
                    data.add(rs.getString("username"));
                    data.add(rs.getString("pass"));
                
                   
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
                String sql = "select * from NhanVien ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where sdt like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "số điện thoại không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("manhanvien"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("chucvu"));
                    data.add(rs.getString("username"));
                    data.add(rs.getString("pass"));
                
                   
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
                String sql = "select * from NhanVien ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where diachi like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "địa chỉ không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("manhanvien"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("chucvu"));
                    data.add(rs.getString("username"));
                    data.add(rs.getString("pass"));
                
                   
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                jTable1.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_cbTimKiemActionPerformed

    private void txtTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiem2ActionPerformed

    private void cbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDateActionPerformed
        // TODO add your handling code here:
         try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from NhanVien ";
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
                  data.add(rs.getString("manhanvien"));
                    data.add(rs.getString("hoten"));
                    data.add(rs.getDate("ngaysinh"));
                    data.add(rs.getString("gioitinh"));
                    data.add(rs.getString("sdt"));
                    data.add(rs.getString("diachi"));
                    data.add(rs.getString("chucvu"));
                    data.add(rs.getString("username"));
                    data.add(rs.getString("pass"));
                    
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
        if (a1.equals("địa chỉ theo giới tính")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_nhanvien_diachi.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "select diachi as [Địa chỉ],isnull([Nữ],'0') as [nữ] ,isnull([Nam],'0') as [nam] \n" +
"from (\n" +
"	select diachi,gioitinh,count(*) as [số lượng]\n" +
"	from NhanVien\n" +
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
        }  else if (a1.equals("ngày sinh theo giới tính")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_nhanvien_ngaysinh.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "select [ngày sinh] ,isnull([Nữ],'0') as [nữ] ,isnull([Nam],'0') as [nam] \n" +
"from (\n" +
"	select day(Ngaysinh) as[ngày sinh],gioitinh,count(*) as [số lượng]\n" +
"	from NhanVien\n" +
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
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_nhanvien_thangsinh.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = " select [tháng sinh] ,isnull([Nữ],'0') as [nữ] ,isnull([Nam],'0') as [nam] \n" +
"from (\n" +
"	select month(Ngaysinh) as[tháng sinh],gioitinh,count(*) as [số lượng]\n" +
"	from NhanVien\n" +
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
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_nhanvien_namsinh.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "select [năm sinh] ,isnull([Nữ],'0') as [nữ] ,isnull([Nam],'0') as [nam] \n" +
"from (\n" +
"	select year(Ngaysinh) as[năm sinh],gioitinh,count(*) as [số lượng]\n" +
"	from NhanVien\n" +
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
public class SimpleExcelWriter {

	public void main(String[] args) throws IOException {
		
		SimpleExcelWriter excelWriter = new SimpleExcelWriter();
		 
		List<objnhanvien> listBook = excelWriter.getListBook();
		String excelFilePath = "E:/BangSach.xls";
		 
                excelWriter.writeExcel(listBook, excelFilePath);
	}
    private CellStyle style;
	
	private Workbook getWorkbook(String excelFilePath)
	        throws IOException {
	    Workbook workbook = null;
	 
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook();
	    } else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook();
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	 
	    return workbook;
	}
	
	public void writeExcel(List<objnhanvien> listBook, String excelFilePath) throws IOException {
	    Workbook workbook = getWorkbook(excelFilePath);
	    Sheet sheet = workbook.createSheet();
	    createHeaderRow(sheet);
	    int rowCount = 0;
	 
	    for (objnhanvien aBook : listBook) {
	        Row row = sheet.createRow(++rowCount);
	        writeBook(aBook, row);
	    }
	 
	    try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	        workbook.write(outputStream);
	    }
	}
	
	private void writeBook(objnhanvien aBook, Row row) {
	    Cell cell = row.createCell(0);
	   cell.setCellValue(aBook.getManhanvien());
	 
	    cell = row.createCell(1);
	    cell.setCellValue(aBook.getHoten());
	 
	    cell = row.createCell(2);
	    cell.setCellValue(aBook.getNgaysinh());
            cell=row.createCell(3);
            cell.setCellValue(aBook.getGioitinh());
            cell=row.createCell(4);
            cell.setCellValue(aBook.getSdt());
            cell=row.createCell(5);
            cell.setCellValue(aBook.getDiachi());
            cell=row.createCell(6);
            cell.setCellValue(aBook.getChucvu());
             cell=row.createCell(7);
            cell.setCellValue(aBook.getUsername());
             cell=row.createCell(8);
            cell.setCellValue(aBook.getPass());
	}
	
    //Có thể format được như in đậm, set font
	private void createHeaderRow(Sheet sheet) {
            
		 
	    CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
	    Font font = sheet.getWorkbook().createFont();
	    font.setBold(true);
	    font.setFontHeightInPoints((short) 16);
	    cellStyle.setFont(font);
	  
	    Row row = sheet.createRow(0);
            
          
          Cell  cell = row.createCell(0, CellType.STRING);
          cell.setCellValue("MaNhanVien");
           cell.setCellStyle(style);
	     cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("HoTen");
        cell.setCellStyle(style);
	     cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("NgaySinh");
        cell.setCellStyle(style);
	   cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("GioiTinh");
        cell.setCellStyle(style);
            cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Sdt");
        cell.setCellStyle(style);
            
              cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("DiaChi");
        cell.setCellStyle(style);
              cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("ChucVu");
        cell.setCellStyle(style);
            cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("UserName");
        cell.setCellStyle(style);
            cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("Pass");
        cell.setCellStyle(style);
	}

	public List<objnhanvien> getListBook() {
             List<objnhanvien> listBook = new ArrayList<>();
                String sql = "select * from dbo.nhanvien";
                  java.sql.Connection connection=Connect.getConnection();
            try {
               
              
                PreparedStatement ps =connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    objnhanvien book= new  objnhanvien();
                    book.setManhanvien(rs.getString("manhanvien"));
                    book.setHoten(rs.getString("hoten"));
                    book.setNgaysinh(rs.getString("ngaysinh"));
                    book.setGioitinh(rs.getString("gioitinh"));
                      book.setSdt(rs.getString("sdt"));
                    book.setDiachi(rs.getString("diachi"));
                    book.setChucvu(rs.getString("chucvu"));
                    book.setUsername(rs.getString("username"));
                      book.setPass(rs.getString("pass"));
                listBook.add(book);
                }
                connection.close();
                
               
                
                
            } catch (SQLException ex) {
                Logger.getLogger(SimpleExcelWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
            return listBook;
	}

}
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
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cbDate;
    private javax.swing.JComboBox cbGioitinh;
    private javax.swing.JComboBox<String> cbThongKe;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JRadioButton rdbNhanvien;
    private javax.swing.JRadioButton rdbQuanli;
    private javax.swing.JTextField tfnhapfile;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtManhanvien;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtTimKiem2;
    private javax.swing.JTextField txtTimKiem3;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtpass;
    // End of variables declaration//GEN-END:variables
}
