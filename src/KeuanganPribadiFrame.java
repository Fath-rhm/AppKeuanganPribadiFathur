import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ListSelectionModel;



public class KeuanganPribadiFrame extends javax.swing.JFrame {
    
    DefaultTableModel model;
    public KeuanganPribadiFrame() {
        initComponents();
        
        //Mengatur JTable agar dapat menerima data
        model = (DefaultTableModel) tblPengeluaranHarian.getModel();
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

                // Kunci tanggal agar tidak bisa diedit
                tglPengeluaran.setEnabled(false);

                // Aktifkan tombol Edit dan Hapus
                btnEdit.setEnabled(true);
                btnHapus.setEnabled(true);
            }
        });

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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Masukkan Total Uang");

        txtTotalUang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalUangKeyTyped(evt);
            }
        });

        jLabel3.setText("Jumlah Pengeluaran ");

        jLabel4.setText("tanggal");

        jLabel5.setText("Kebutuhan");

        tblPengeluaranHarian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tanggal", "Kebutuhan", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tblPengeluaranHarian);

        btnUangTotal.setText("Masukkan Uang");
        btnUangTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUangTotalActionPerformed(evt);
            }
        });

        lblPemasukkan.setText("Pemasukkan");

        lblPengeluaran.setText("Pengeluaran");

        lblSisa.setText("Sisa bulan ini");

        btnPengeluaran.setText("Catat Pengeluaran");
        btnPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengeluaranActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPemasukkan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(btnUangTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotalUang)
                            .addComponent(txtPengeluaran)
                            .addComponent(tglPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKebutuhan))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTotalUang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUangTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPemasukkan)
                        .addGap(3, 3, 3)
                        .addComponent(lblPengeluaran)
                        .addGap(2, 2, 2)
                        .addComponent(lblSisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtKebutuhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tglPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPengeluaran)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit)))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("APLIKASI PENGELOLA KEUANGAN PRIBADI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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
    
//fungsi untuk memasukkan total uang yang didapatkan
    private void MasukkanUangTotal(){
        try {
            String input = txtTotalUang.getText().trim();
            double nilai = Double.parseDouble(input);

            lblPemasukkan.setText("Pemasukkan: " + nilai);


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!");
        }
    }
    
//fungsi untuk memasukkan data jumlah pengeluaran, kebutuhan, tanggal ke JTable
    private void CatatPengeluaran(){
        try {
            // Ambil nilai input
            String pengeluaran = txtPengeluaran.getText().trim();
            String kebutuhan = txtKebutuhan.getText().trim();

            // Validasi input angka
            if (!pengeluaran.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Pengeluaran harus angka!");
                return;
            }

            // Format tanggal dari JDateChooser
            Date date = tglPengeluaran.getDate();
            if (date == null) {
                JOptionPane.showMessageDialog(this, "Pilih tanggal pengeluaran!");
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String tanggal = sdf.format(date);

            // Masukkan ke tabel
            DefaultTableModel model = (DefaultTableModel) tblPengeluaranHarian.getModel();
            model.addRow(new Object[]{ pengeluaran, kebutuhan, tanggal });

            // Bersihkan input
            txtPengeluaran.setText("");
            txtKebutuhan.setText("");
            tglPengeluaran.setDate(null);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan input!");
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

        ((javax.swing.table.DefaultTableModel) tblPengeluaranHarian.getModel()).removeRow(row);

        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");

        // Reset form
        clearForm();
    }
    
//fungsi mengedit kolom yang dipilih dari table pengeluaran harian
    private void EditKolomHarian(){
       int row = tblPengeluaranHarian.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!");
            return;
        }

        String pengeluaran = txtPengeluaran.getText().trim();
        String kebutuhan = txtKebutuhan.getText().trim();

        // Update data pada JTable
        tblPengeluaranHarian.setValueAt(pengeluaran, row, 0);
        tblPengeluaranHarian.setValueAt(kebutuhan, row, 1);

        JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");

        // Reset form dan tombol
        clearForm();
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
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPengeluaran;
    private javax.swing.JButton btnUangTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPemasukkan;
    private javax.swing.JLabel lblPengeluaran;
    private javax.swing.JLabel lblSisa;
    private javax.swing.JTable tblPengeluaranHarian;
    private com.toedter.calendar.JDateChooser tglPengeluaran;
    private javax.swing.JTextField txtKebutuhan;
    private javax.swing.JTextField txtPengeluaran;
    private javax.swing.JTextField txtTotalUang;
    // End of variables declaration//GEN-END:variables
}
