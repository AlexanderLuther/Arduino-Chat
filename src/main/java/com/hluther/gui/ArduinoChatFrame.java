package com.hluther.gui;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.Color;
import java.awt.event.KeyEvent;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
/**
 *
 * @author helmuth
 */
public class ArduinoChatFrame extends javax.swing.JFrame {

    private boolean connected = false;
    private SerialPortEventListener serialPortListener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if(arduino.isMessageAvailable()){
                    messagesArea.setText(messagesArea.getText() + "Recibido: " + arduino.printMessage() + "\n");
                }
            } catch (SerialPortException ex) {
                System.out.println(ex.getMessage());
            } catch (ArduinoException ex) {
                System.out.println(ex.getMessage());
            }
        }
    };
    
    private PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    public ArduinoChatFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        statusLabel.setText("Estado: No Conectado");
        statusPanel.setBackground(Color.red);
        fillAvailableConnections(); 
    }
    
    private void fillAvailableConnections(){
        availableConnectiosComboBox.removeAllItems();
        for(var connection : arduino.getSerialPorts()){
            availableConnectiosComboBox.addItem(connection);
        }
    }
    
    private void sendMessage(){
        if(connected && !sendMessagesArea.getText().isBlank() || !sendMessagesArea.getText().isEmpty()){
            try {
                messagesArea.setText(messagesArea.getText() + "Enviado: " + sendMessagesArea.getText() + "\n");
                arduino.sendData(sendMessagesArea.getText());
            } catch (ArduinoException ex) {
                System.out.println(ex.getMessage());
            } catch (SerialPortException ex) {
                System.out.println(ex.getMessage());
            }
        }
        sendMessagesArea.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        left = new javax.swing.JPanel();
        right = new javax.swing.JPanel();
        up = new javax.swing.JPanel();
        down = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        leftCorner = new javax.swing.JPanel();
        rightCorner = new javax.swing.JPanel();
        statusPanel = new javax.swing.JPanel();
        center = new javax.swing.JPanel();
        connectionArea = new javax.swing.JPanel();
        availableConnections = new javax.swing.JPanel();
        availableConnectiosComboBox = new javax.swing.JComboBox<>();
        connectionButtons = new javax.swing.JPanel();
        connect = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        disconnect = new javax.swing.JPanel();
        disconnectButton = new javax.swing.JButton();
        messages = new javax.swing.JPanel();
        sendMessage = new javax.swing.JPanel();
        sendButton = new javax.swing.JButton();
        sendMessagesArea = new javax.swing.JTextField();
        chat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagesArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arduino Chat");
        setPreferredSize(new java.awt.Dimension(695, 500));

        left.setMaximumSize(new java.awt.Dimension(25, 32767));
        left.setMinimumSize(new java.awt.Dimension(25, 100));
        left.setPreferredSize(new java.awt.Dimension(25, 173));

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        getContentPane().add(left, java.awt.BorderLayout.LINE_START);

        right.setMaximumSize(new java.awt.Dimension(25, 32767));
        right.setMinimumSize(new java.awt.Dimension(25, 100));
        right.setPreferredSize(new java.awt.Dimension(25, 173));

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        getContentPane().add(right, java.awt.BorderLayout.LINE_END);

        up.setMaximumSize(new java.awt.Dimension(32767, 25));
        up.setMinimumSize(new java.awt.Dimension(100, 25));
        up.setPreferredSize(new java.awt.Dimension(695, 25));

        javax.swing.GroupLayout upLayout = new javax.swing.GroupLayout(up);
        up.setLayout(upLayout);
        upLayout.setHorizontalGroup(
            upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        upLayout.setVerticalGroup(
            upLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        getContentPane().add(up, java.awt.BorderLayout.PAGE_START);

        down.setMaximumSize(new java.awt.Dimension(32767, 25));
        down.setMinimumSize(new java.awt.Dimension(100, 25));
        down.setPreferredSize(new java.awt.Dimension(695, 25));
        down.setLayout(new java.awt.BorderLayout());

        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        statusLabel.setMinimumSize(new java.awt.Dimension(645, 0));
        statusLabel.setPreferredSize(new java.awt.Dimension(645, 0));
        down.add(statusLabel, java.awt.BorderLayout.CENTER);

        leftCorner.setMaximumSize(new java.awt.Dimension(25, 32767));
        leftCorner.setMinimumSize(new java.awt.Dimension(25, 0));
        leftCorner.setPreferredSize(new java.awt.Dimension(25, 100));

        javax.swing.GroupLayout leftCornerLayout = new javax.swing.GroupLayout(leftCorner);
        leftCorner.setLayout(leftCornerLayout);
        leftCornerLayout.setHorizontalGroup(
            leftCornerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        leftCornerLayout.setVerticalGroup(
            leftCornerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        down.add(leftCorner, java.awt.BorderLayout.WEST);

        rightCorner.setMaximumSize(new java.awt.Dimension(25, 32767));
        rightCorner.setMinimumSize(new java.awt.Dimension(25, 0));
        rightCorner.setPreferredSize(new java.awt.Dimension(25, 100));
        rightCorner.setLayout(new java.awt.GridBagLayout());

        statusPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        statusPanel.setMinimumSize(new java.awt.Dimension(10, 10));
        statusPanel.setPreferredSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        rightCorner.add(statusPanel, new java.awt.GridBagConstraints());

        down.add(rightCorner, java.awt.BorderLayout.EAST);

        getContentPane().add(down, java.awt.BorderLayout.PAGE_END);

        center.setLayout(new java.awt.BorderLayout());

        connectionArea.setMaximumSize(new java.awt.Dimension(2147483647, 80));
        connectionArea.setMinimumSize(new java.awt.Dimension(0, 80));
        connectionArea.setPreferredSize(new java.awt.Dimension(698, 80));
        connectionArea.setLayout(new java.awt.BorderLayout());

        availableConnections.setPreferredSize(new java.awt.Dimension(350, 80));
        availableConnections.setLayout(new java.awt.GridBagLayout());

        availableConnectiosComboBox.setMaximumSize(new java.awt.Dimension(200, 32767));
        availableConnectiosComboBox.setMinimumSize(new java.awt.Dimension(200, 23));
        availableConnectiosComboBox.setPreferredSize(new java.awt.Dimension(200, 23));
        availableConnections.add(availableConnectiosComboBox, new java.awt.GridBagConstraints());

        connectionArea.add(availableConnections, java.awt.BorderLayout.CENTER);

        connectionButtons.setPreferredSize(new java.awt.Dimension(350, 80));
        connectionButtons.setLayout(new javax.swing.BoxLayout(connectionButtons, javax.swing.BoxLayout.LINE_AXIS));

        connect.setLayout(new java.awt.GridBagLayout());

        connectButton.setText("Conectar");
        connectButton.setPreferredSize(new java.awt.Dimension(110, 23));
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        connect.add(connectButton, new java.awt.GridBagConstraints());

        connectionButtons.add(connect);

        disconnect.setLayout(new java.awt.GridBagLayout());

        disconnectButton.setText("Desconectar");
        disconnectButton.setPreferredSize(new java.awt.Dimension(110, 23));
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });
        disconnect.add(disconnectButton, new java.awt.GridBagConstraints());

        connectionButtons.add(disconnect);

        connectionArea.add(connectionButtons, java.awt.BorderLayout.EAST);

        center.add(connectionArea, java.awt.BorderLayout.PAGE_START);

        messages.setLayout(new java.awt.BorderLayout());

        sendMessage.setLayout(new javax.swing.BoxLayout(sendMessage, javax.swing.BoxLayout.LINE_AXIS));

        sendButton.setText("Enviar");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        sendMessage.add(sendButton);

        sendMessagesArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sendMessagesAreaKeyPressed(evt);
            }
        });
        sendMessage.add(sendMessagesArea);

        messages.add(sendMessage, java.awt.BorderLayout.PAGE_START);

        chat.setLayout(new javax.swing.BoxLayout(chat, javax.swing.BoxLayout.LINE_AXIS));

        messagesArea.setEditable(false);
        messagesArea.setColumns(20);
        messagesArea.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
        messagesArea.setRows(5);
        jScrollPane1.setViewportView(messagesArea);

        chat.add(jScrollPane1);

        messages.add(chat, java.awt.BorderLayout.CENTER);

        center.add(messages, java.awt.BorderLayout.CENTER);

        getContentPane().add(center, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        try {
            if(availableConnectiosComboBox.getSelectedIndex() != -1){
                arduino.arduinoRXTX(arduino.getSerialPorts().get(availableConnectiosComboBox.getSelectedIndex()), 9600, serialPortListener);
                statusPanel.setBackground(Color.GREEN);
                statusLabel.setText("Estado: Conectado a " + arduino.getSerialPorts().get(availableConnectiosComboBox.getSelectedIndex()));
                connected = true;
            }
        } catch (ArduinoException ex) {
             System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        try {
            arduino.killArduinoConnection();
            statusPanel.setBackground(Color.red);
            statusLabel.setText("Estado: No Conectado");
            connected = false;
            fillAvailableConnections();
        } catch (ArduinoException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendMessage();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void sendMessagesAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sendMessagesAreaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            sendMessage();
        }
    }//GEN-LAST:event_sendMessagesAreaKeyPressed


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
            java.util.logging.Logger.getLogger(ArduinoChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArduinoChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArduinoChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArduinoChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArduinoChatFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel availableConnections;
    private javax.swing.JComboBox<String> availableConnectiosComboBox;
    private javax.swing.JPanel center;
    private javax.swing.JPanel chat;
    private javax.swing.JPanel connect;
    private javax.swing.JButton connectButton;
    private javax.swing.JPanel connectionArea;
    private javax.swing.JPanel connectionButtons;
    private javax.swing.JPanel disconnect;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JPanel down;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel left;
    private javax.swing.JPanel leftCorner;
    private javax.swing.JPanel messages;
    private javax.swing.JTextArea messagesArea;
    private javax.swing.JPanel right;
    private javax.swing.JPanel rightCorner;
    private javax.swing.JButton sendButton;
    private javax.swing.JPanel sendMessage;
    private javax.swing.JTextField sendMessagesArea;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JPanel up;
    // End of variables declaration//GEN-END:variables
}
