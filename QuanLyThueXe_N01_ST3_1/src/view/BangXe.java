package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import controller.Connect;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.util.HashMap;
import javax.swing.text.BadLocationException;
import model.Xe;
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

public class BangXe extends javax.swing.JFrame {

    DefaultTableModel tbn = new DefaultTableModel();

    public BangXe() {
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
            PreparedStatement ps = conn.prepareStatement("Select LoaiXe from BangXe group by LoaiXe");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbLoaiXe.addItem(rs.getString("LoaiXe"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    //ham do du lieu vao bang
    private void showDuLieu() {
        try {
            tableMain.removeAll();
            String[] arr = {"Ma Xe", "Bien So", "LoaiXe", "Hang Xe", "Mau Xe ", "Trang Thai Thue", "Gia Thue", "Tgkiemdinh", "tgbaohiem", "phibaohiem"};

            DefaultTableModel model = new DefaultTableModel(arr, 0);
            Connection connection = Connect.getConnection();
            String query = "SELECT * FROM dbo.bangxe";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString("maxe"));
                vector.add(rs.getString("bienso"));
                vector.add(rs.getString("loaixe"));
                vector.add(rs.getString("hangxe"));
                vector.add(rs.getString("mauxe"));
                vector.add(rs.getString("trangthaithue"));
                vector.add(rs.getString("giathue"));
                vector.add(rs.getString("tgkiemdinh"));
                vector.add(rs.getString("tgbaohiem"));
                vector.add(rs.getString("phibaohiem"));
                model.addRow(vector);
            }
            Connect.closeConnection(connection);
            tableMain.setModel(model);

            tableMain.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tableMain.getSelectedRow() >= 0) {
                        txtMaXe.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 0) + "");
                        txtBienSo.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 1) + "");
                        cbLoaiXe.setSelectedItem(tableMain.getModel().getValueAt(tableMain.getSelectedRow(), 2) + "");
                        txtHangXe.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 3) + "");
                        txtMauXe.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 4) + "");
                        txtTrangThaiThue.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 5) + "");
                        txtGiaThue.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 6) + "");
                        txtTgKiemDinh.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 7) + "");
                        txtTgBaoHiem.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 8) + "");
                        txtPhiBaoHiem.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 9) + "");
                    }
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(BangXe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadData() {
        try {
            tableMain.removeAll();
            Connect a = new Connect();
            Connection conn = a.getConnection();
            int number;
            Vector row, column;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from BangXe");
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
                row.addElement(rs.getString(3));
                row.addElement(rs.getString(4));
                row.addElement(rs.getString(5));
                row.addElement(rs.getString(6));
                row.addElement(rs.getString(7));
                row.addElement(rs.getDate(8));
                row.addElement(rs.getDate(9));
                row.addElement(rs.getString(10));
//                for(int i =1;i<=number;i++){
//                    row.addElement(rs.getString(i));
//                }
                tbn.addRow(row);
                tableMain.setModel(tbn);
            }
            tableMain.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tableMain.getSelectedRow() >= 0) {
                        txtMaXe.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 0) + "");
                        txtBienSo.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 1) + "");
                        cbLoaiXe.setSelectedItem(tableMain.getModel().getValueAt(tableMain.getSelectedRow(), 2) + "");
                        txtHangXe.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 3) + "");
                        txtMauXe.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 4) + "");
                        txtTrangThaiThue.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 5) + "");
                        txtGiaThue.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 6) + "");
                        txtTgKiemDinh.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 7) + "");
                        txtTgBaoHiem.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 8) + "");
                        txtPhiBaoHiem.setText(tableMain.getValueAt(tableMain.getSelectedRow(), 9) + "");
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
        jLabel11 = new javax.swing.JLabel();
        txtMaXe = new javax.swing.JTextField();
        txtBienSo = new javax.swing.JTextField();
        txtHangXe = new javax.swing.JTextField();
        txtMauXe = new javax.swing.JTextField();
        txtTrangThaiThue = new javax.swing.JTextField();
        txtGiaThue = new javax.swing.JTextField();
        txtTgKiemDinh = new javax.swing.JTextField();
        txtTgBaoHiem = new javax.swing.JTextField();
        txtPhiBaoHiem = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMain = new javax.swing.JTable();
        cbLoaiXe = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfnhapfile = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cbTimKiem = new javax.swing.JComboBox<>();
        txtTimKiem1 = new javax.swing.JTextField();
        cbDate = new javax.swing.JComboBox<>();
        txtTimKiem2 = new javax.swing.JTextField();
        txtTimKiem3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbThongKe = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Quản lý Bảng Xe");

        jLabel2.setText("Mã Xe");

        jLabel3.setText("Biển Số");

        jLabel4.setText("Loại Xe");

        jLabel5.setText("Hãng Xe");

        jLabel6.setText("Màu Xe");

        jLabel7.setText("Trạng Thái Thuê");

        jLabel8.setText("Giá Thuê");

        jLabel9.setText("Thời hạn kiểm định");

        jLabel10.setText("Thời hạn bảo hiểm");

        jLabel11.setText("Phí bảo hIểm");

        txtMauXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMauXeActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
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

        jLabel12.setText("Tìm Kiếm:");

        jLabel13.setText("Thống Kê:");

        tableMain.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableMain);

        jButton1.setText("Xuất file ecxel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nhập file");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mã xe", "biển số", "loại xe", "hãng xe", "màu xe" }));
        cbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTimKiemActionPerformed(evt);
            }
        });

        cbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "thời hạn kiểm định", "thời gian bảo hiểm" }));
        cbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDateActionPerformed(evt);
            }
        });

        jLabel14.setText("Ngày");

        jLabel15.setText("Tháng:");

        jLabel16.setText("Năm:");

        cbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hãng xe theo loại xe", "màu xe theo loại xe", "thời hạn kiểm định", "thời hạn bảo hiểm" }));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(cbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(8, 8, 8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTimKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtHangXe))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel4)
                                    .addGap(8, 8, 8)
                                    .addComponent(cbLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtBienSo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMauXe, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTgKiemDinh, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtTrangThaiThue, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhiBaoHiem, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTgBaoHiem, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua)
                        .addGap(33, 33, 33)
                        .addComponent(btnXoa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(tfnhapfile, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(tfnhapfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTrangThaiThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(txtBienSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(txtTgKiemDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(txtHangXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTgBaoHiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(txtMauXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhiBaoHiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private boolean checkTrungMaSach() {
        try {
            Connection connection = Connect.getConnection();
            String query = "SELECT * FROM dbo.bangxe where MAxe = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, txtMaXe.getText());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BangXe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtMaXe.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Chua Nhap Ma Xe");
            txtMaXe.requestFocus();
            return;
        } else if (txtBienSo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Chua Nhap bien so");
            txtBienSo.requestFocus();
            return;
        } else if (txtMauXe.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Chua Nhap mau xe");
            txtMauXe.requestFocus();
            return;
        } else if (txtGiaThue.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Chua Nhap giathue");
            txtGiaThue.requestFocus();
            return;
        } else if (txtTrangThaiThue.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "them trang thai chua thanh cong");
            return;
        } else if (txtTgBaoHiem.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "them thoi gian bao hiem chua thanh cong");
            return;
        }
        String masach = txtMaXe.getText();
        if (masach.length() != 6) {
            JOptionPane.showMessageDialog(rootPane, "MaXe phai co 6 ki tu");
            txtMaXe.requestFocus();
            return;
        }
        try {
            String a1 = txtMaXe.getText(0, 2);
            boolean a5 = a1.equals("MX");
            boolean a2 = Character.isDigit(masach.charAt(2));
            boolean a3 = Character.isDigit(masach.charAt(3));
            boolean a4 = Character.isDigit(masach.charAt(4));
            boolean a6 = Character.isDigit(masach.charAt(5));
            if ((a2 && a3 && a4 && a5 && a6) == false) {
                JOptionPane.showMessageDialog(null, "nhap sai dinh dang Ma Xe MXxxxx");
                return;
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(BangXe.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (checkTrungMaSach() == true) {
            JOptionPane.showMessageDialog(null, "Ma Xe da ton tai");
            txtMaXe.requestFocus();
            return;

        }   // TODO add your handling code here:

        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into BangXe values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, txtMaXe.getText());
            ps.setString(2, txtBienSo.getText());
            ps.setString(3, cbLoaiXe.getSelectedItem().toString());
            ps.setString(4, txtHangXe.getText());
            ps.setString(5, txtMauXe.getText());
            ps.setString(6, txtTrangThaiThue.getText());
            ps.setString(7, txtGiaThue.getText());
            ps.setString(8, txtTgKiemDinh.getText());
            ps.setString(9, txtTgBaoHiem.getText());
            ps.setString(10, txtPhiBaoHiem.getText());
            int chk = ps.executeUpdate();
            if (chk > 0) {
                JOptionPane.showMessageDialog(this, "Them thanh cong!");
                tbn.setRowCount(0);
                loadData();
            } else {
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtMauXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMauXeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMauXeActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("Update BangXe set Bienso=?,Loaixe=?,Hangxe=?,"
                    + "Mauxe=?,Trangthaithue=?,Giathue=?,Tgkiemdinh=?,Tgbaohiem=?,Phibaohiem=? Where Maxe=?");
            ps.setString(10, txtMaXe.getText());
            ps.setString(1, txtBienSo.getText());
            ps.setString(2, cbLoaiXe.getSelectedItem().toString());
            ps.setString(3, txtHangXe.getText());
            ps.setString(4, txtMauXe.getText());
            ps.setString(5, txtTrangThaiThue.getText());
            ps.setString(6, txtGiaThue.getText());
            ps.setString(7, txtTgKiemDinh.getText());
            ps.setString(8, txtTgBaoHiem.getText());
            ps.setString(9, txtPhiBaoHiem.getText());

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
            PreparedStatement ps = conn.prepareStatement("Delete BangXe Where Maxe=?");
            ps.setString(1, tableMain.getValueAt(tableMain.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(this, "Delete this Xe?", "Confirm",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                ps.executeUpdate();
                tbn.setRowCount(0);
                loadData();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String excelFilePath = tfnhapfile.getText();
            SimpleExcelReader reader = new SimpleExcelReader();
            List<Xe> listBooks;

            listBooks = reader.readBooksFromExcelFile(excelFilePath);
            for (Xe aBook : listBooks) {
                Connection connection = Connect.getConnection();
                String query = "INSERT INTO dbo.[bangxe](maxe, bienso , loaixe,hangxe,mauxe,trangthaithue,giathue,tgkiemdinh,tgbaohiem,phibaohiem) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,? )";
                PreparedStatement ps;
                try {
                    ps = connection.prepareStatement(query);

                    ps.setString(1, aBook.getMaxe());
                    ps.setString(2, aBook.getBienso());
                    ps.setString(3, aBook.getLoaixe());
                    ps.setString(4, aBook.getHangxe());
                    ps.setString(5, aBook.getMauxe());
                    ps.setString(6, aBook.getTrangthaithue());

                    ps.setString(7, aBook.getGiathue());
                    ps.setString(8, aBook.getTgkiemdinh());
                    ps.setString(9, aBook.getTgbaohiem());
                    ps.setString(10, aBook.getPhibaohiem());

                    ps.executeUpdate();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Đã Trùng Mã Xe");
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
    }//GEN-LAST:event_jButton2ActionPerformed
    public class SimpleExcelWriter {

        public void main(String[] args) throws IOException {

            SimpleExcelWriter excelWriter = new SimpleExcelWriter();

            List<Xe> listBook = excelWriter.getListBook();
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

        public void writeExcel(List<Xe> listBook, String excelFilePath) throws IOException {
            Workbook workbook = getWorkbook(excelFilePath);
            Sheet sheet = workbook.createSheet();
            createHeaderRow(sheet);
            int rowCount = 0;

            for (Xe aBook : listBook) {
                Row row = sheet.createRow(++rowCount);
                writeBook(aBook, row);
            }

            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }
        }

        private void writeBook(Xe aBook, Row row) {
            Cell cell = row.createCell(0);
            cell.setCellValue(aBook.getMaxe());

            cell = row.createCell(1);
            cell.setCellValue(aBook.getBienso());

            cell = row.createCell(2);
            cell.setCellValue(aBook.getLoaixe());
            cell = row.createCell(3);
            cell.setCellValue(aBook.getHangxe());
            cell = row.createCell(4);
            cell.setCellValue(aBook.getMauxe());
            cell = row.createCell(5);
            cell.setCellValue(aBook.getTrangthaithue());
            cell = row.createCell(6);
            cell.setCellValue(aBook.getGiathue());
            cell = row.createCell(7);
            cell.setCellValue(aBook.getTgkiemdinh());
            cell = row.createCell(8);
            cell.setCellValue(aBook.getTgbaohiem());
            cell = row.createCell(9);
            cell.setCellValue(aBook.getPhibaohiem());
        }

        //Có thể format được như in đậm, set font
        private void createHeaderRow(Sheet sheet) {

            CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
            Font font = sheet.getWorkbook().createFont();
            font.setBold(true);
            font.setFontHeightInPoints((short) 16);
            cellStyle.setFont(font);

            Row row = sheet.createRow(0);

            Cell cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("maxe");
            cell.setCellStyle(style);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("bieso");
            cell.setCellStyle(style);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("loaixe");
            cell.setCellStyle(style);
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("hangxe");
            cell.setCellStyle(style);
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("mauxe");
            cell.setCellStyle(style);

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("trangthaithue");
            cell.setCellStyle(style);
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("giathue");
            cell.setCellStyle(style);
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("tgkiemdinh");
            cell.setCellStyle(style);
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("tgbaohiem");
            cell.setCellStyle(style);
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("phibaohiem");
            cell.setCellStyle(style);
        }

        public List<Xe> getListBook() {
            List<Xe> listBook = new ArrayList<>();
            String sql = "select * from dbo.Bangxe";
            java.sql.Connection connection = Connect.getConnection();
            try {

                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Xe book = new Xe();
                    book.setMaxe(rs.getString("maxe"));
                    book.setBienso(rs.getString("bienso"));
                    book.setLoaixe(rs.getString("loaixe"));
                    book.setHangxe(rs.getString("hangxe"));
                    book.setMauxe(rs.getString("trangthaithue"));
                    book.setTrangthaithue(rs.getString("trangthaithue"));
                    book.setGiathue(rs.getString("giathue"));
                    book.setTgkiemdinh(rs.getString("tgkiemdinh"));
                    book.setTgbaohiem(rs.getString("tgbaohiem"));
                    book.setPhibaohiem(rs.getString("phibaohiem"));
                    listBook.add(book);
                }
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(SimpleExcelWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
            return listBook;
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SimpleExcelWriter excelWriter = new SimpleExcelWriter();

        List<Xe> listBook = excelWriter.getListBook();
        String excelFilePath = "E:/BangXe.xls";

        try {
            excelWriter.writeExcel(listBook, excelFilePath);
            JOptionPane.showMessageDialog(null, "da xuat thanh cong ra E:/BangXe.xls");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Đã Có lỗi Xảy ra vui lòng kiểm tra lại");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTimKiemActionPerformed
        // TODO add your handling code here:
        String a1 = (String) cbTimKiem.getSelectedItem();
        if (a1.equals("mã xe")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from BangXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where maxe like '%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Mã xe không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("maxe"));
                    data.add(rs.getString("bienso"));
                    data.add(rs.getString("loaixe"));
                    data.add(rs.getString("hangxe"));
                    data.add(rs.getString("mauxe"));
                    data.add(rs.getString("trangthaithue"));
                    data.add(rs.getString("giathue"));
                
                    data.add(rs.getString("tgkiemdinh"));
                    data.add(rs.getString("tgbaohiem"));
                    data.add(rs.getString("phibaohiem"));
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                tableMain.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else if (a1.equals("biển số")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from BangXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where bienso like '%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "biển số không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("maxe"));
                    data.add(rs.getString("bienso"));
                    data.add(rs.getString("loaixe"));
                    data.add(rs.getString("hangxe"));
                    data.add(rs.getString("mauxe"));
                    data.add(rs.getString("trangthaithue"));
                    data.add(rs.getString("giathue"));
                    
                    data.add(rs.getString("tgkiemdinh"));
                    data.add(rs.getString("tgbaohiem"));
                    data.add(rs.getString("phibaohiem"));
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                tableMain.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else if (a1.equals("loại xe")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from BangXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where loaixe like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "loai xe không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("maxe"));
                    data.add(rs.getString("bienso"));
                    data.add(rs.getString("loaixe"));
                    data.add(rs.getString("hangxe"));
                    data.add(rs.getString("mauxe"));
                    data.add(rs.getString("trangthaithue"));
                    data.add(rs.getString("giathue"));
                   
                    data.add(rs.getString("tgkiemdinh"));
                    data.add(rs.getString("tgbaohiem"));
                    data.add(rs.getString("phibaohiem"));
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                tableMain.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else if (a1.equals("hãng xe")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from BangXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where hangxe like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "hãng xe không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("maxe"));
                    data.add(rs.getString("bienso"));
                    data.add(rs.getString("loaixe"));
                    data.add(rs.getString("hangxe"));
                    data.add(rs.getString("mauxe"));
                    data.add(rs.getString("trangthaithue"));
                    data.add(rs.getString("giathue"));
                    
                    data.add(rs.getString("tgkiemdinh"));
                    data.add(rs.getString("tgbaohiem"));
                    data.add(rs.getString("phibaohiem"));
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                tableMain.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else if (a1.equals("màu xe")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from BangXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem.getText().length() > 0) {
                    sql = sql + "where mauxe like N'%" + txtTimKiem.getText() + "%' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "màu xe không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();

                    data.add(rs.getString("maxe"));
                    data.add(rs.getString("bienso"));
                    data.add(rs.getString("loaixe"));
                    data.add(rs.getString("hangxe"));
                    data.add(rs.getString("mauxe"));
                    data.add(rs.getString("trangthaithue"));
                    data.add(rs.getString("giathue"));
                    data.add(rs.getString("tgkiemdinh"));
                    data.add(rs.getString("tgbaohiem"));
                    data.add(rs.getString("phibaohiem"));
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                tableMain.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_cbTimKiemActionPerformed

    private void cbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDateActionPerformed
        // TODO add your handling code here:
        String a2 = (String) cbDate.getSelectedItem();
        if (a2.equals("thời hạn kiểm định")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from BangXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() >= 0) {
                    sql = sql + "where (month(Tgkiemdinh) like '" + txtTimKiem2.getText() + "') and (day(Tgkiemdinh) like '" + txtTimKiem1.getText() + "') and (year(Tgkiemdinh) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() > 0) {
                    sql = sql + "where  (year(Tgkiemdinh) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where (month(Tgkiemdinh) like '" + txtTimKiem2.getText() + "') ";
                }
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where  day(Tgkiemdinh) like '" + txtTimKiem1.getText() + "' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Ngày tháng năm kiểm định không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();
                    data.add(rs.getString("maxe"));
                    data.add(rs.getString("bienso"));
                    data.add(rs.getString("loaixe"));
                    data.add(rs.getString("hangxe"));
                    data.add(rs.getString("mauxe"));
                    data.add(rs.getString("trangthaithue"));
                    data.add(rs.getString("giathue"));

                    data.add(rs.getString("tgkiemdinh"));
                    data.add(rs.getString("tgbaohiem"));
                    data.add(rs.getString("phibaohiem"));
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                tableMain.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else if (a2.equals("thời gian bảo hiểm")) {
            try {
                Connect a = new Connect();
                Connection conn = a.getConnection();
                // Câu lệnh xem dữ liệu
                String sql = "select * from BangXe ";
                // Nếu tìm kiếm theo BookID
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() >= 0) {
                    sql = sql + "where (month(Tgbaohiem) like '" + txtTimKiem2.getText() + "') and (day(Tgbaohiem) like '" + txtTimKiem1.getText() + "') and (year(Tgbaohiem) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() > 0) {
                    sql = sql + "where  (year(Tgbaohiem) like '%" + txtTimKiem3.getText() + "%')";
                }
                if (txtTimKiem1.getText().length() == 0 && txtTimKiem2.getText().length() > 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where (month(Tgbaohiem) like '" + txtTimKiem2.getText() + "') ";
                }
                if (txtTimKiem1.getText().length() > 0 && txtTimKiem2.getText().length() == 0 && txtTimKiem3.getText().length() == 0) {
                    sql = sql + "where  day(Tgbaohiem) like '" + txtTimKiem1.getText() + "' ";
                }
                // Tạo đối tượng thực thi câu lệnh Select
                Statement st = conn.createStatement();

                // Thực thi 
                ResultSet rs = st.executeQuery(sql);
                Vector data = null;
                tbn.setRowCount(0);
                // Nếu sách không tồn tại
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Ngày tháng năm bảo hiểm không tồn tại!");
                    return;
                }
                //trong khi chưa hết dữ liệu
                while (rs.next()) {
                    data = new Vector();
                    data.add(rs.getString("maxe"));
                    data.add(rs.getString("bienso"));
                    data.add(rs.getString("loaixe"));
                    data.add(rs.getString("hangxe"));
                    data.add(rs.getString("mauxe"));
                    data.add(rs.getString("trangthaithue"));
                    data.add(rs.getString("giathue"));

                    data.add(rs.getString("tgkiemdinh"));
                    data.add(rs.getString("tgbaohiem"));
                    data.add(rs.getString("phibaohiem"));
                    // Thêm một dòng vào table model
                    tbn.addRow(data);
                }
                tableMain.setModel(tbn); // Thêm dữ liệu vào table
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_cbDateActionPerformed

    private void cbThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThongKeActionPerformed
        // TODO add your handling code here:
         String a1 = (String) cbThongKe.getSelectedItem();
        if (a1.equals("hãng xe theo loại xe")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_bangxe_hangxe.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "  select Hangxe as [hãng xe],isnull([4 chỗ],'0') as [4 chỗ],isnull([7 chỗ],'0') as [7 chỗ],isnull([12 chỗ],'0') as[12 chỗ],isnull([21 chỗ],'0') as [21 chỗ],isnull([30 chỗ],'0') as [30 chỗ]\n" +
"from\n" +
"(\n" +
"	select Hangxe,Loaixe,count(*) as [số lượng]\n" +
"	from BangXe\n" +
"	group by  Hangxe,Loaixe\n" +
"	) as j\n" +
"	pivot\n" +
"	(\n" +
"	sum([số lượng]) for Loaixe in ([4 chỗ],[7 chỗ],[12 chỗ],[21 chỗ],[30 chỗ])\n" +
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
        } else if (a1.equals("màu xe theo loại xe")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_bangxe_mauxe.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = " select Mauxe as [màu xe],isnull([4 chỗ],'0') as [4 chỗ],isnull([7 chỗ],'0') as [7 chỗ],isnull([12 chỗ],'0') as[12 chỗ],isnull([21 chỗ],'0') as [21 chỗ],isnull([30 chỗ],'0') as [30 chỗ]\n" +
"from\n" +
"(\n" +
"	select Mauxe,Loaixe,count(*) as [số lượng]\n" +
"	from BangXe\n" +
"	group by  Mauxe,Loaixe\n" +
"	) as j\n" +
"	pivot\n" +
"	(\n" +
"	sum([số lượng]) for Loaixe in ([4 chỗ],[7 chỗ],[12 chỗ],[21 chỗ],[30 chỗ])\n" +
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
        }else if (a1.equals("thời hạn kiểm định")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_bangxe_tgkiemdinh.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = " select convert (varchar, Tgkiemdinh, 103) as [thời gian kiểm định],isnull([4 chỗ],'0') as [4 chỗ],isnull([7 chỗ],'0') as [7 chỗ],isnull([12 chỗ],'0') as[12 chỗ],isnull([21 chỗ],'0') as [21 chỗ],isnull([30 chỗ],'0') as [30 chỗ]\n" +
"from\n" +
"(\n" +
"	select Tgkiemdinh,Loaixe,count(*) as [số lượng]\n" +
"	from BangXe\n" +
"	group by  Tgkiemdinh,Loaixe\n" +
"	) as j\n" +
"	pivot\n" +
"	(\n" +
"	sum([số lượng]) for Loaixe in ([4 chỗ],[7 chỗ],[12 chỗ],[21 chỗ],[30 chỗ])\n" +
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
        }else if (a1.equals("thời hạn bảo hiểm")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlyxe", "sa", "123456");
                InputStream in = new FileInputStream(new File("E:\\QuanLyThueXe_N01_ST3_1\\src\\report\\TK_bangxe_tgbaohiem.jrxml"));
                JasperDesign jd = JRXmlLoader.load(in);
                String sql = "select convert (varchar, Tgbaohiem, 103) as [thời gian bảo hiểm],isnull([4 chỗ],'0') as [4 chỗ],isnull([7 chỗ],'0') as [7 chỗ],isnull([12 chỗ],'0') as[12 chỗ],isnull([21 chỗ],'0') as [21 chỗ],isnull([30 chỗ],'0') as [30 chỗ]\n" +
"from\n" +
"(\n" +
"	select Tgbaohiem,Loaixe,count(*) as [số lượng]\n" +
"	from BangXe\n" +
"	group by  Tgbaohiem,Loaixe\n" +
"	) as j\n" +
"	pivot\n" +
"	(\n" +
"	sum([số lượng]) for Loaixe in ([4 chỗ],[7 chỗ],[12 chỗ],[21 chỗ],[30 chỗ])\n" +
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

    public class ReadExcelDemo {

        public void main(String[] args) throws IOException {

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
            List<Xe> listBooks = reader.readBooksFromExcelFile(excelFilePath);
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

                case NUMERIC:
                    return cell.getNumericCellValue();
                case _NONE:
                case BLANK:
                case ERROR:
                    break;
                default:
                    break;
            }

            return cellvalue;
        }

        public List<Xe> readBooksFromExcelFile(String excelFilePath) throws IOException {
            List<Xe> listBooks = new ArrayList<>();
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

            Workbook workbook = getWorkbook(inputStream, excelFilePath);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();

            if (iterator.hasNext()) {
                Row nextRow = iterator.next();

                Iterator<Cell> cellIterator = nextRow.cellIterator();
            }
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();

                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Xe aBook = new Xe();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {

                        case 0:
                            aBook.setMaxe((String) getCellValue(nextCell));
                            break;
                        case 1:
                            aBook.setBienso((String) getCellValue(nextCell));
                            break;
                        case 2:
                            aBook.setLoaixe((String) getCellValue(nextCell));
                            break;
                        case 3:
                            aBook.setHangxe((String) getCellValue(nextCell));
                            break;
                        case 4:
                            aBook.setMauxe((String) getCellValue(nextCell));
                            break;
                        case 5:
                            aBook.setTrangthaithue((String) getCellValue(nextCell));
                            break;
                        case 6:
                            aBook.setGiathue((String) getCellValue(nextCell));
                            break;
                        case 7:
                            aBook.setTgkiemdinh((String) getCellValue(nextCell));
                            break;
                        case 8:
                            aBook.setTgbaohiem((String) getCellValue(nextCell));
                            break;
                        case 9:
                            aBook.setPhibaohiem((String) getCellValue(nextCell));
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
            java.util.logging.Logger.getLogger(BangXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BangXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BangXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BangXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BangXe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbDate;
    private javax.swing.JComboBox cbLoaiXe;
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableMain;
    private javax.swing.JTextField tfnhapfile;
    private javax.swing.JTextField txtBienSo;
    private javax.swing.JTextField txtGiaThue;
    private javax.swing.JTextField txtHangXe;
    private javax.swing.JTextField txtMaXe;
    private javax.swing.JTextField txtMauXe;
    private javax.swing.JTextField txtPhiBaoHiem;
    private javax.swing.JTextField txtTgBaoHiem;
    private javax.swing.JTextField txtTgKiemDinh;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtTimKiem2;
    private javax.swing.JTextField txtTimKiem3;
    private javax.swing.JTextField txtTrangThaiThue;
    // End of variables declaration//GEN-END:variables
}
