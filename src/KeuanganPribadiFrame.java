import java.text.SimpleDateFormat;
import javax.swing.ListSelectionModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class KeuanganPribadiFrame extends javax.swing.JFrame {
    
    DefaultTableModel model;
    DefaultTableModel modelBulanan;
    public KeuanganPribadiFrame() {
        initComponents();
        
        /*Mematikan inputan agar user tidak menginput data sebelum 
        Pemasukan di input */
        txtPengeluaran.setEnabled(false);
        txtKebutuhan.setEnabled(false);
        tglPengeluaran.setEnabled(false);
        //memakai jcalendar agar inputan tanggal menjadi tanggal pada hari ini
        tglPengeluaran.setDate(new Date());
    //Setting untuk tblPengeluaranHarian
        String[] columnNames = {
            "Pengeluaran", 
            "Kebutuhan", 
            "Tanggal", 
            "Pemasukan", 
            "Pengeluaran Total", 
            "Sisa"
        };
        //Mengatur JTable agar dapat menerima data
        model = (DefaultTableModel) tblPengeluaranHarian.getModel();
        model.setColumnIdentifiers(columnNames);
        tblPengeluaranHarian.setRowSelectionAllowed(true);
        tblPengeluaranHarian.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model.setRowCount(0);
        
        //fungsi agar saat kolom di klik data dari table pindah ke menu pengisian
        tblPengeluaranHarian.getSelectionModel().addListSelectionListener(event -> {
                    
            if (!event.getValueIsAdjusting() && tblPengeluaranHarian.getSelectedRow() != -1) {

                int row = tblPengeluaranHarian.getSelectedRow();

                // Ambil data
                String pengeluaran = tblPengeluaranHarian.getValueAt(row, 0).toString();
                String kebutuhan = tblPengeluaranHarian.getValueAt(row, 1).toString();
                String tanggal = tblPengeluaranHarian.getValueAt(row, 2).toString();
                String pemasukan = lblPemasukkan.getText();
                String totalPengeluaran = lblPengeluaran.getText();
                String sisa = lblSisa.getText();
                // Kembalikan ke textfield
                txtPengeluaran.setText(pengeluaran);
                txtKebutuhan.setText(kebutuhan);

                // Kembalikan tanggal ke JCalendar (format: yyyy-MM-dd)
                try {
                    java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(tanggal);
                    tglPengeluaran.setDate(date);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Jika ingin menampilkan pemasukan/pengeluaran total/sisa kembali ke label:
                lblPemasukkan.setText(model.getValueAt(row, 3).toString());
                lblPengeluaran.setText(model.getValueAt(row, 4).toString());
                lblSisa.setText(model.getValueAt(row, 5).toString());
                // Kunci tanggal agar tidak bisa diedit
                tglPengeluaran.setEnabled(false);

                // Aktifkan tombol Edit dan Hapus
                btnEdit.setEnabled(true);
                btnHapus.setEnabled(true);
            }
        });
        
    //Setting untuk tblPengeluaranBulanan
        String[] kolomBulanan = {
            "Tanggal",
            "Total Pengeluaran",
            "Total Pemasukkan",
            "Total Pengeluaran Total",
            "Total Sisa"
        };

        modelBulanan = (DefaultTableModel) tblDataBulanan.getModel();
        modelBulanan.setColumnIdentifiers(kolomBulanan);
        modelBulanan.setRowCount(0);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotalUang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPengeluaran = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tglPengeluaran = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtKebutuhan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPengeluaranHarian = new javax.swing.JTable();
        btnUangTotal = new javax.swing.JButton();
        lblPemasukkan = new javax.swing.JLabel();
        lblPengeluaran = new javax.swing.JLabel();
        lblSisa = new javax.swing.JLabel();
        btnPengeluaran = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnMuatData = new javax.swing.JButton();
        btnSimpanData = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDataBulanan = new javax.swing.JTable();
        btnKonversiBulanan = new javax.swing.JButton();
        btnExportCSV = new javax.swing.JButton();
        btnExportTXT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Masukkan Total Uang");

        txtTotalUang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalUangKeyTyped(evt);
            }
        });

        jLabel3.setText("Jumlah Pengeluaran ");

        txtPengeluaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPengeluaranKeyTyped(evt);
            }
        });

        jLabel4.setText("tanggal");

        jLabel5.setText("Kebutuhan");

        tblPengeluaranHarian.setBackground(new java.awt.Color(204, 204, 204));
        tblPengeluaranHarian.setForeground(new java.awt.Color(255, 255, 255));
        tblPengeluaranHarian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Pengeluaran hari ini", "Kebutuhan", "Tanggal", "Pemasukan", "Pengeluaran Total", "Sisa"
            }
        ));
        jScrollPane1.setViewportView(tblPengeluaranHarian);

        btnUangTotal.setBackground(new java.awt.Color(0, 0, 0));
        btnUangTotal.setForeground(new java.awt.Color(255, 255, 255));
        btnUangTotal.setText("Masukkan Uang");
        btnUangTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUangTotalActionPerformed(evt);
            }
        });

        lblPemasukkan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblPemasukkanPropertyChange(evt);
            }
        });

        btnPengeluaran.setBackground(new java.awt.Color(0, 0, 0));
        btnPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        btnPengeluaran.setText("Catat Pengeluaran");
        btnPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengeluaranActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(0, 0, 0));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 0, 0));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnMuatData.setBackground(new java.awt.Color(0, 0, 0));
        btnMuatData.setForeground(new java.awt.Color(255, 255, 255));
        btnMuatData.setText("Muat data");
        btnMuatData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatDataActionPerformed(evt);
            }
        });

        btnSimpanData.setBackground(new java.awt.Color(0, 0, 0));
        btnSimpanData.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanData.setText("Simpan data");
        btnSimpanData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanDataActionPerformed(evt);
            }
        });

        jLabel6.setText("Pemasukan");

        jLabel7.setText("Pengeluaran");

        jLabel8.setText("Sisa Bulan ini");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMuatData, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpanData))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalUang, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tglPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKebutuhan, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUangTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblPengeluaran, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPemasukkan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblPemasukkan))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPengeluaran)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTotalUang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUangTotal)))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKebutuhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tglPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(btnPengeluaran))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit)
                    .addComponent(btnMuatData)
                    .addComponent(btnSimpanData))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("APLIKASI PENGELOLA KEUANGAN PRIBADI");

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblDataBulanan.setBackground(new java.awt.Color(204, 204, 204));
        tblDataBulanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Total Pengeluaran", "Total Pemasukkan", "Pengeluaran Total", "Total Sisa"
            }
        ));
        jScrollPane2.setViewportView(tblDataBulanan);

        btnKonversiBulanan.setBackground(new java.awt.Color(0, 0, 0));
        btnKonversiBulanan.setForeground(new java.awt.Color(255, 255, 255));
        btnKonversiBulanan.setText("Masukkan Data Bulanan");
        btnKonversiBulanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonversiBulananActionPerformed(evt);
            }
        });

        btnExportCSV.setBackground(new java.awt.Color(0, 0, 0));
        btnExportCSV.setForeground(new java.awt.Color(255, 255, 255));
        btnExportCSV.setText("Simpan ke CSV");
        btnExportCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportCSVActionPerformed(evt);
            }
        });

        btnExportTXT.setBackground(new java.awt.Color(0, 0, 0));
        btnExportTXT.setForeground(new java.awt.Color(255, 255, 255));
        btnExportTXT.setText("Simpan ke TXT");
        btnExportTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportTXTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnKonversiBulanan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportCSV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExportTXT))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKonversiBulanan)
                    .addComponent(btnExportCSV)
                    .addComponent(btnExportTXT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUangTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUangTotalActionPerformed
       MasukkanUangTotal();
    }//GEN-LAST:event_btnUangTotalActionPerformed

    private void txtTotalUangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalUangKeyTyped
        char c = evt.getKeyChar();
           // Izinkan angka, backspace, dan delete
        if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE && c != java.awt.event.KeyEvent.VK_DELETE) {
            evt.consume(); // batalkan input
            // Tampilkan notifikasi
            JOptionPane.showMessageDialog(this, 
                    "Input hanya boleh angka saja!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtTotalUangKeyTyped
    
    private void btnPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengeluaranActionPerformed
        CatatPengeluaran();
    }//GEN-LAST:event_btnPengeluaranActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        HapusKolomHarian();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        EditKolomHarian();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnMuatDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatDataActionPerformed
        MuatCsv();
    }//GEN-LAST:event_btnMuatDataActionPerformed

    private void btnSimpanDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanDataActionPerformed
        SimpanCsv();
    }//GEN-LAST:event_btnSimpanDataActionPerformed

    private void txtPengeluaranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPengeluaranKeyTyped
       char c = evt.getKeyChar();
           // Izinkan angka, backspace, dan delete
        if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE && c != java.awt.event.KeyEvent.VK_DELETE) {
            evt.consume(); // batalkan input
            // Tampilkan notifikasi
            JOptionPane.showMessageDialog(this, 
                    "Input hanya boleh angka saja!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtPengeluaranKeyTyped

    private void btnKonversiBulananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonversiBulananActionPerformed
        KonversiKeBulanan();
    }//GEN-LAST:event_btnKonversiBulananActionPerformed

    private void lblPemasukkanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblPemasukkanPropertyChange
        if ("text".equals(evt.getPropertyName())) {
        String teks = lblPemasukkan.getText().trim();

        if (!teks.isEmpty()) {
            // Aktifkan field pengeluaran setelah pemasukan terisi
            txtPengeluaran.setEnabled(true);
            txtKebutuhan.setEnabled(true);
            tglPengeluaran.setEnabled(true);
        }
    }
    }//GEN-LAST:event_lblPemasukkanPropertyChange

    private void btnExportCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportCSVActionPerformed
        ExportCsvBulanan();
    }//GEN-LAST:event_btnExportCSVActionPerformed

    private void btnExportTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportTXTActionPerformed
        ExportTxtBulanan();
    }//GEN-LAST:event_btnExportTXTActionPerformed
    
//fungsi untuk memasukkan total uang yang didapatkan
    private void MasukkanUangTotal() {
        try {
            // Ambil input baru
            String input = txtTotalUang.getText().trim();
            double nilaiBaru = Double.parseDouble(input);

            // Ambil nilai lama dari label pemasukkan
            String teksLama = lblPemasukkan.getText().trim();
            double nilaiLama = 0.0;

            if (!teksLama.isEmpty()) {
                nilaiLama = Double.parseDouble(teksLama);
            }

            // Tambahkan nilai baru ke nilai lama
            double totalBaru = nilaiLama + nilaiBaru;

            // Tampilkan hasil ke label
            lblPemasukkan.setText(String.valueOf(totalBaru));

            // Bersihkan input
            txtTotalUang.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!");
        }
    }
    
    private void CatatPengeluaran() {
        try {
            String pengeluaran = txtPengeluaran.getText().trim();
            String kebutuhan = txtKebutuhan.getText().trim();

            if (!pengeluaran.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Pengeluaran harus berupa angka!");
                return;
            }

            Date date = tglPengeluaran.getDate();
            if (date == null) {
                JOptionPane.showMessageDialog(this, "Pilih tanggal pengeluaran!");
                return;
            }
            //Memasukkan fungsi koreksi pemasukkan/saldo
            double pemasukan = 0;
            try {
                String teksPemasukkan = lblPemasukkan.getText().replaceAll("[^0-9.]", "");
                if (!teksPemasukkan.isEmpty()) {
                    pemasukan = Double.parseDouble(teksPemasukkan);
                }
            } catch (Exception e) {}

            double totalPengeluaranSaatIni = 0;
            try {
                totalPengeluaranSaatIni = Double.parseDouble(lblPengeluaran.getText());
            } catch (Exception e) {}

            double pengeluaranBaru = Double.parseDouble(pengeluaran);

            double sisaSimulasi = pemasukan - (totalPengeluaranSaatIni + pengeluaranBaru);

            if (sisaSimulasi < 0) {
                JOptionPane.showMessageDialog(this,
                    "Saldo anda tidak cukup!",
                    "Gagal",
                    JOptionPane.ERROR_MESSAGE
                );
            return;
            }
            
            //Memasukkan data ke table pengeluaran harian
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String tanggal = sdf.format(date);
            DefaultTableModel model = (DefaultTableModel) tblPengeluaranHarian.getModel();
            model.addRow(new Object[]{
                pengeluaran,
                kebutuhan,
                tanggal,
                lblPemasukkan.getText(),
                "",     // kolom pengeluaran total
                ""      // kolom sisa
            });
            updatePengeluaranDanSisa();

            int lastRow = model.getRowCount() - 1;
            model.setValueAt(lblPengeluaran.getText(), lastRow, 4); // kolom Pengeluaran Total
            model.setValueAt(lblSisa.getText(), lastRow, 5);         // kolom Sisa

            // Reset input
            txtPengeluaran.setText("");
            txtKebutuhan.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan input: " + e.getMessage());
        }
    }
 
//fungsi mengosongkan menu pengisian pengeluaran harian
    private void clearForm() {
        txtPengeluaran.setText("");
        txtKebutuhan.setText("");
        tglPengeluaran.setDate(null);

        tglPengeluaran.setEnabled(true); // Aktifkan lagi untuk input baru
        tblPengeluaranHarian.clearSelection();

        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
    }

//fungsi menghapus kolom pada table pengeluaran harian
    private void HapusKolomHarian(){
        int row = tblPengeluaranHarian.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblPengeluaranHarian.getModel();
        model.removeRow(row);

        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");

        clearForm();
        refreshTableKalkulasi();
    }
    
//fungsi mengedit kolom yang dipilih dari table pengeluaran harian
    private void EditKolomHarian() {
        int row = tblPengeluaranHarian.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!");
            return;
        }

        String pengeluaran = txtPengeluaran.getText().trim();
        String kebutuhan = txtKebutuhan.getText().trim();

        if (!pengeluaran.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Pengeluaran harus berupa angka!");
            return;
        }

        // Update tabel
        DefaultTableModel model = (DefaultTableModel) tblPengeluaranHarian.getModel();
        model.setValueAt(pengeluaran, row, 0);
        model.setValueAt(kebutuhan, row, 1);

        JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");

        clearForm();
        refreshTableKalkulasi();
    }
//fungsi untuk mengetahui pemasukkan dan pengeluaran 
   private void updatePengeluaranDanSisa() {
        DefaultTableModel model = (DefaultTableModel) tblPengeluaranHarian.getModel();
        double total = 0.0;

        // Hitung seluruh nilai pengeluaran dari kolom 0
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                double nilai = Double.parseDouble(model.getValueAt(i, 0).toString());
                total += nilai;
            } catch (Exception e) {
                // Jika ada error parsing, skip (tidak menghentikan program)
            }
        }

        // Tampilkan ke label pengeluaran
        lblPengeluaran.setText(String.valueOf(total));

        // Ambil pemasukkan dari label (format fleksibel)
        double pemasukan = 0.0;
        try {
        String teksLabel = lblPemasukkan.getText(); 
        String angka = teksLabel.replaceAll("[^0-9.]", "");  // hanya baca, tidak ubah label
        if (!angka.isEmpty()) {
            pemasukan = Double.parseDouble(angka);
        }
    } catch (Exception e) {}
        // Hitung sisa pemasukan
        double sisa = pemasukan - total;
        lblSisa.setText(String.valueOf(sisa));
    }

//fungsi untuk menympan data di tabel harian sebagai file csv
    private void SimpanCsv() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan Data Pengeluaran ke CSV");

        // Default nama file
        fileChooser.setSelectedFile(new java.io.File("pengeluaran_harian.csv"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try (FileWriter fw = new FileWriter(fileToSave);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                DefaultTableModel model = (DefaultTableModel) tblPengeluaranHarian.getModel();

                // Tulis header kolom
                for (int i = 0; i < model.getColumnCount(); i++) {
                    bw.write(model.getColumnName(i));
                    if (i != model.getColumnCount() - 1) bw.write(",");
                }
                bw.newLine();

                // Tulis isi data baris per baris
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Object value = model.getValueAt(row, col);
                        bw.write(value != null ? value.toString() : "");
                        if (col != model.getColumnCount() - 1) bw.write(",");
                    }
                    bw.newLine();
                }

                bw.flush();
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke CSV!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                    "Gagal menyimpan file: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
//fungsi untuk memuat file csv kedalam tabel data harian
    private void MuatCsv() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih File CSV");

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {

                String line;
                DefaultTableModel model = (DefaultTableModel) tblPengeluaranHarian.getModel();

                // Hapus data lama di tabel
                model.setRowCount(0);

                // Ambil header dari CSV (baris pertama)
                if ((line = br.readLine()) != null) {
                    String[] header = line.split(",");
                    model.setColumnIdentifiers(header);
                }

                // Isi data baris demi baris
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    model.addRow(data);
                }

                JOptionPane.showMessageDialog(this, "File CSV berhasil dimuat!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    "Gagal memuat file: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

//fungsi update ulang seluruh tabel data harian
    private void refreshTableKalkulasi() {
        DefaultTableModel model = (DefaultTableModel) tblPengeluaranHarian.getModel();

        // Hitung ulang total pengeluaran
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            total += Double.parseDouble(model.getValueAt(i, 0).toString());
        }

        // Update label Pengeluaran
        lblPengeluaran.setText(String.valueOf(total));

        // Ambil pemasukan
        double pemasukan = Double.parseDouble(lblPemasukkan.getText());
        double sisa = pemasukan - total;

        // Update label Sisa
        lblSisa.setText(String.valueOf(sisa));

        // MASUKKAN NILAI TOTAL & SISA KE SEMUA BARIS
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(total, i, 4); // kolom Pengeluaran Total
            model.setValueAt(sisa,  i, 5); // kolom Sisa
        }
    }
//fungsi untuk mengkonversi data dari tblPengeluaranHarian ke tblPengeluaranBulanan
    private void KonversiKeBulanan() {
        DefaultTableModel harian = (DefaultTableModel) tblPengeluaranHarian.getModel();
        modelBulanan.setRowCount(0);

        java.util.Map<String, double[]> map = new java.util.HashMap<>();

        for (int i = 0; i < harian.getRowCount(); i++) {

            String tanggal = harian.getValueAt(i, 2).toString();
            double pengeluaran = Double.parseDouble(harian.getValueAt(i, 0).toString());
            double pemasukan = Double.parseDouble(harian.getValueAt(i, 3).toString());
            double totalPeng = Double.parseDouble(harian.getValueAt(i, 4).toString());
            double sisa = Double.parseDouble(harian.getValueAt(i, 5).toString());

            if (!map.containsKey(tanggal)) {
                // index: 0=pengeluaran, 1=pemasukkan, 2=totalPeng, 3=sisa
                map.put(tanggal, new double[]{0, pemasukan, totalPeng, sisa});
            }

            double[] data = map.get(tanggal);

            // hanya pengeluaran yang dijumlahkan
            data[0] += pengeluaran;

            // pemasukan, totalPeng, dan sisa TIDAK dijumlahkan
            // ambil nilai terakhir
            data[1] = pemasukan;
            data[2] = totalPeng;
            data[3] = sisa;
        }
        
        // ----------- SORTING TANGGAL -----------
        List<String> sortedTanggal = new ArrayList<>(map.keySet());
        Collections.sort(sortedTanggal); // ascending (kecil ke besar)
        // ---------------------------------------

        // masukkan ke table dengan tanggal terurut
        for (String tanggal : sortedTanggal) {
            double[] d = map.get(tanggal);
            modelBulanan.addRow(new Object[]{
                tanggal,
                d[0],
                d[1],
                d[2],
                d[3]
        });
        }

        JOptionPane.showMessageDialog(this, "Data berhasil dikonversi ke bulanan!");
    }
//fungsi menyimpan tabel bulanan ke format .Csv
    private void ExportCsvBulanan() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan Data Bulanan ke CSV");
        fileChooser.setSelectedFile(new File("pengeluaran_bulanan.csv"));

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

                for (int i = 0; i < modelBulanan.getColumnCount(); i++) {
                    bw.write(modelBulanan.getColumnName(i));
                    if (i < modelBulanan.getColumnCount() - 1) bw.write(",");
                }
                bw.newLine();

                for (int r = 0; r < modelBulanan.getRowCount(); r++) {
                    for (int c = 0; c < modelBulanan.getColumnCount(); c++) {
                        bw.write(modelBulanan.getValueAt(r, c).toString());
                        if (c < modelBulanan.getColumnCount() - 1) bw.write(",");
                    }
                    bw.newLine();
                }

                JOptionPane.showMessageDialog(this, "CSV bulanan berhasil disimpan!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + e.getMessage());
            }
        }
    }
//fungsi menyimpan tabel bulanan ke file.txt
    private void ExportTxtBulanan() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan Data Bulanan ke TXT");
        fileChooser.setSelectedFile(new File("pengeluaran_bulanan.txt"));

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

                for (int i = 0; i < modelBulanan.getColumnCount(); i++) {
                    bw.write(modelBulanan.getColumnName(i) + "\t");
                }
                bw.newLine();

                for (int r = 0; r < modelBulanan.getRowCount(); r++) {
                    for (int c = 0; c < modelBulanan.getColumnCount(); c++) {
                        bw.write(modelBulanan.getValueAt(r, c).toString() + "\t");
                    }
                    bw.newLine();
                }

                JOptionPane.showMessageDialog(this, "TXT bulanan berhasil disimpan!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + e.getMessage());
            }
        }
    }
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(KeuanganPribadiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeuanganPribadiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeuanganPribadiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeuanganPribadiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeuanganPribadiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExportCSV;
    private javax.swing.JButton btnExportTXT;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKonversiBulanan;
    private javax.swing.JButton btnMuatData;
    private javax.swing.JButton btnPengeluaran;
    private javax.swing.JButton btnSimpanData;
    private javax.swing.JButton btnUangTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPemasukkan;
    private javax.swing.JLabel lblPengeluaran;
    private javax.swing.JLabel lblSisa;
    private javax.swing.JTable tblDataBulanan;
    private javax.swing.JTable tblPengeluaranHarian;
    private com.toedter.calendar.JDateChooser tglPengeluaran;
    private javax.swing.JTextField txtKebutuhan;
    private javax.swing.JTextField txtPengeluaran;
    private javax.swing.JTextField txtTotalUang;
    // End of variables declaration//GEN-END:variables
}
