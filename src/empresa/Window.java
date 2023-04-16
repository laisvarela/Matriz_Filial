package empresa;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

public class Window extends javax.swing.JFrame {

    Client client;

    public Window() throws JSONException, UnknownHostException, SocketException {
        initComponents();
        this.pack();
        //pn_table.setVisible(false);
        //this.pack();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        client = new Client(ip, 23567);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cb_local = new javax.swing.JComboBox<>();
        bt_onoff = new javax.swing.JToggleButton();
        pn_check = new javax.swing.JPanel();
        lb_local = new javax.swing.JLabel();
        lb_status = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        pn_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_status = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cb_local.addItem("luz_guarita");
        cb_local.addItem("ar_guarita");
        cb_local.addItem("luz_estacionamento");
        cb_local.addItem("luz_galpao_externo");
        cb_local.addItem("luz_galpao_interno");
        cb_local.addItem("luz_escritorios");
        cb_local.addItem("ar_escritorios");
        cb_local.addItem("luz_sala_reunioes");
        cb_local.addItem("ar_sala_reunioes");
        cb_local.setBackground(new java.awt.Color(255, 255, 255));
        cb_local.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        cb_local.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_localActionPerformed(evt);
            }
        });

        bt_onoff.setBackground(new java.awt.Color(255, 255, 255));
        bt_onoff.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        bt_onoff.setText("OFF");
        bt_onoff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_onoffMouseClicked(evt);
            }
        });

        pn_check.setBackground(new java.awt.Color(255, 255, 255));
        pn_check.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.cyan, java.awt.Color.lightGray));

        lb_local.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        lb_local.setText("nome");

        lb_status.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        lb_status.setText("estado");

        javax.swing.GroupLayout pn_checkLayout = new javax.swing.GroupLayout(pn_check);
        pn_check.setLayout(pn_checkLayout);
        pn_checkLayout.setHorizontalGroup(
            pn_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_checkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_local)
                    .addComponent(lb_status))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        pn_checkLayout.setVerticalGroup(
            pn_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_checkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_local)
                .addGap(18, 18, 18)
                .addComponent(lb_status)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.black, java.awt.Color.white, java.awt.Color.white));

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.white, java.awt.Color.white));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jButton1.setText("Status complete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(pn_check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(cb_local, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_onoff))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_onoff))
                .addGap(18, 18, 18)
                .addComponent(pn_check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(11, 11, 11))
        );

        jTable_status.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Local", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_status);

        javax.swing.GroupLayout pn_tableLayout = new javax.swing.GroupLayout(pn_table);
        pn_table.setLayout(pn_tableLayout);
        pn_tableLayout.setHorizontalGroup(
            pn_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_tableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_tableLayout.setVerticalGroup(
            pn_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_onoffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_onoffMouseClicked
        lb_local.setText((String) cb_local.getSelectedItem());
        if (bt_onoff.isSelected()) {
            bt_onoff.setText("On");
            lb_status.setText("On");
        } else {
            bt_onoff.setText("Off");
            lb_status.setText("Off");
        }
        try {
            try {
                client.sendMsg("set", cb_local.getSelectedItem().toString(), bt_onoff.getText());
            } catch (SocketException | JSONException ex) {
                System.out.println("aqui");
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_onoffMouseClicked

    private void cb_localActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_localActionPerformed

        try {
            lb_local.setText(client.getjObj().get("locate").toString());
            lb_status.setText(client.getjObj().get("value").toString());
        } catch (JSONException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb_localActionPerformed

    public static void main(String args[]) throws UnknownHostException, SocketException, IOException, JSONException {
        Window w = new Window();
        w.setVisible(true);
        w.setLocationRelativeTo(null);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bt_onoff;
    private javax.swing.JComboBox<String> cb_local;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable_status;
    private javax.swing.JLabel lb_local;
    private javax.swing.JLabel lb_status;
    private javax.swing.JPanel pn_check;
    private javax.swing.JPanel pn_table;
    // End of variables declaration//GEN-END:variables
}
