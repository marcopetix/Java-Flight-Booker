/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.gui;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import p2.logic.App;
import p2.logic.Prenotazione;
import p2.logic.Ricerca;
import p2.logic.Utente;

/**
 *
 * @author markp
 */
public class Interfaccia extends javax.swing.JFrame {
    
    ArrayList<Utente> utenti = new ArrayList<>();
    ArrayList<Ricerca> ricerche = new ArrayList<>();
    ArrayList<Prenotazione> prenotazioni = new ArrayList<>();

    /**
     * Creates new form Interfaccia
     */
    public Interfaccia() {
        initComponents();
    }
    
    public Interfaccia(String token){
        this.setTitle("Client B - Interfaccia");
        this.token = token;
        initComponents();
        setListaUtenti(token);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ricerche_button = new javax.swing.JRadioButton();
        prenotazioni_button = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        utenti_lista = new javax.swing.JList<>();
        label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        log_out_button = new javax.swing.JButton();
        aggiorna_button = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabella = new javax.swing.JTable();

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
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 60, 160));
        jPanel1.setForeground(new java.awt.Color(26, 60, 160));
        jPanel1.setMaximumSize(new java.awt.Dimension(1070, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(1070, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Riepilogo Utilizzo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Utenti");

        ricerche_button.setBackground(new java.awt.Color(26, 60, 160));
        buttonGroup1.add(ricerche_button);
        ricerche_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ricerche_button.setForeground(new java.awt.Color(255, 255, 255));
        ricerche_button.setSelected(true);
        ricerche_button.setText("Ricerche");
        ricerche_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ricerche_buttonMouseClicked(evt);
            }
        });

        prenotazioni_button.setBackground(new java.awt.Color(26, 60, 160));
        buttonGroup1.add(prenotazioni_button);
        prenotazioni_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prenotazioni_button.setForeground(new java.awt.Color(255, 255, 255));
        prenotazioni_button.setText("Prenotazioni");
        prenotazioni_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prenotazioni_buttonMouseClicked(evt);
            }
        });

        utenti_lista.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        utenti_lista.setForeground(new java.awt.Color(26, 60, 160));
        utenti_lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        utenti_lista.setToolTipText("");
        jScrollPane2.setViewportView(utenti_lista);

        label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Ricerche");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(26, 60, 160));
        jButton1.setText("Visualizza tutte le ricerche");
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(26, 60, 160));
        jButton2.setText("Visualizza tutte le prenotazioni");
        jButton2.setBorderPainted(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        log_out_button.setBackground(new java.awt.Color(255, 255, 255));
        log_out_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        log_out_button.setForeground(new java.awt.Color(26, 60, 160));
        log_out_button.setText("Log out");
        log_out_button.setActionCommand("Token scaduto - Premi per log out");
        log_out_button.setBorderPainted(false);
        log_out_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                log_out_buttonMouseClicked(evt);
            }
        });

        aggiorna_button.setBackground(new java.awt.Color(255, 255, 255));
        aggiorna_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        aggiorna_button.setForeground(new java.awt.Color(26, 60, 160));
        aggiorna_button.setText("Aggiorna");
        aggiorna_button.setActionCommand("Token scaduto - Premi per log out");
        aggiorna_button.setBorderPainted(false);
        aggiorna_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aggiorna_buttonMouseClicked(evt);
            }
        });

        tabella.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Utente", "Origine (nome)", "Origine (id)", "Destinazione (nome)", "Destinazione (id)", "N. di passeggeri", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabella);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                .addComponent(log_out_button)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aggiorna_button))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ricerche_button)
                        .addGap(18, 18, 18)
                        .addComponent(prenotazioni_button)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(log_out_button)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ricerche_button)
                            .addComponent(prenotazioni_button)
                            .addComponent(label)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aggiorna_button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        label.setText("Ricerche di tutti gli utenti");
        setTabellaRicerche((DefaultTableModel) tabella.getModel(), "no_utente");
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        label.setText("Prenotazioni di tutti gli utenti");
        setTabellaPrenotazioni((DefaultTableModel) tabella.getModel(), "no_utente");
    }//GEN-LAST:event_jButton2MouseClicked

    private void prenotazioni_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prenotazioni_buttonMouseClicked
        if(prenotazioni_button.isSelected()){
            
            DefaultTableModel model = new DefaultTableModel(new Object[]{"Utente", "Compagnia Aerea", "Numero Volo", "Origine", "Destinazione", "Orario Partenza", "Agente", "Prezzo"}, 0);
            
            tabella.setModel(model);            
            if(utenti_lista.getSelectedIndex() != -1){
                label.setText("Prenotazioni di " + utenti.get(utenti_lista.getSelectedIndex()).getUsername());
                setTabellaPrenotazioni(model, utenti.get(utenti_lista.getSelectedIndex()).getUsername());
            }
            
            
        }
    }//GEN-LAST:event_prenotazioni_buttonMouseClicked

    private void ricerche_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ricerche_buttonMouseClicked
        if(ricerche_button.isSelected()){
            
            DefaultTableModel model = new DefaultTableModel(new Object[]{"Utente", "Origine (nome)", "Origine (id)", "Destinazione (nome)", "Destinazione(id)", "N. di Passeggeri", "Data"}, 0);
            
            tabella.setModel(model);
            
            if(utenti_lista.getSelectedIndex() != -1){
                label.setText("Ricerche di " + utenti.get(utenti_lista.getSelectedIndex()).getUsername());
                setTabellaRicerche(model, utenti.get(utenti_lista.getSelectedIndex()).getUsername());
            }
            
        }
    }//GEN-LAST:event_ricerche_buttonMouseClicked

    private void log_out_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_log_out_buttonMouseClicked
        token = null;
        this.setVisible(false);
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_log_out_buttonMouseClicked

    private void aggiorna_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aggiorna_buttonMouseClicked
        setListaUtenti(token);
    }//GEN-LAST:event_aggiorna_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(Interfaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaccia().setVisible(true);
            }
        });
    }
    
    public void setListaUtenti(String token) {
        DefaultListModel listModel = new DefaultListModel();        
        utenti = App.getUtenti(token);
        
        if (utenti.isEmpty()) {
            listModel.addElement("Nessun utente trovato");
            utenti_lista.setSelectionModel(new DisabledItemSelectionModel());
        } else {
            for (Utente utente : utenti) {
                listModel.addElement(utente.toString());
            }
            utenti_lista.setSelectionModel(new DefaultListSelectionModel());

        }

        utenti_lista.setModel(listModel);
        utenti_lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        utenti_lista.setVisibleRowCount(5);
        
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                JList list = (JList) listSelectionEvent.getSource();
                int index = list.getSelectedIndex();
                if(!utenti.isEmpty() && index != -1 ){
                    if(ricerche_button.isSelected()){
                        setTabellaRicerche((DefaultTableModel) tabella.getModel(), utenti.get(index).getUsername());
                    }else{
                        setTabellaPrenotazioni((DefaultTableModel) tabella.getModel(), utenti.get(index).getUsername());
                    }
                }else{
                    utenti_lista.removeListSelectionListener(this);
                }
                
            }
          };
        utenti_lista.addListSelectionListener(listSelectionListener);
        
    }
    
    public void setTabellaRicerche(DefaultTableModel model, String username) {
        int rowCount = model.getRowCount();
        if(rowCount != 0){
            for(int i=0; i< rowCount; i++)
                model.removeRow(rowCount - i - 1);
        }
        if(username == "no_utente"){
            ricerche = App.getRicerche();
        }else{
            ricerche = App.getRicerche(username);
        }
        if(!ricerche.isEmpty()){
            for (Ricerca ricerca : ricerche) {
                if(ricerca.getUtente() == null){
                    ricerca.setUtente(username);
                }
                model.addRow(new Object[] { ricerca.getUtente(), ricerca.getOrigineNome(), ricerca.getOrigineId(), ricerca.getDestinazioneNome(), ricerca.getDestinazioneId(), ricerca.getPasseggeri(), ricerca.getData() });
            }
        }
    }
    
    public void setTabellaPrenotazioni(DefaultTableModel model, String username) {
        int rowCount = model.getRowCount();
        if(rowCount != 0){
            for(int i=0; i< rowCount; i++)
                model.removeRow(rowCount - i - 1);
        }
        if(username == "no_utente"){
            prenotazioni = App.getPrenotazioni();
        }else{
            prenotazioni = App.getPrenotazioni(username);
        }
        if(!prenotazioni.isEmpty()){
            for (Prenotazione prenotazione : prenotazioni) {
                if(prenotazione.getUtente() == null){
                    prenotazione.setUtente(username);
                }
                model.addRow(new Object[] { prenotazione.getUtente(), prenotazione.getCompagniaAerea(), prenotazione.getNumeroVolo(), prenotazione.getOrigineNome(), prenotazione.getDestinazioneNome(), prenotazione.getOrarioPartenza(), prenotazione.getAgentePrenotazione(), prenotazione.getPrezzo() });
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiorna_button;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label;
    private javax.swing.JButton log_out_button;
    private javax.swing.JRadioButton prenotazioni_button;
    private javax.swing.JRadioButton ricerche_button;
    private javax.swing.JTable tabella;
    private javax.swing.JList<String> utenti_lista;
    // End of variables declaration//GEN-END:variables
    String token;
}

class DisabledItemSelectionModel extends DefaultListSelectionModel {

    @Override
    public void setSelectionInterval(int index0, int index1) {
        super.setSelectionInterval(-1, -1);
    }
}

