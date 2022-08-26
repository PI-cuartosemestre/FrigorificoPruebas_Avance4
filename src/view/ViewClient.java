/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.DAOClient;
import controller.NClient;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ViewClient extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Cliente
     */
    BackPanel back = new BackPanel();

    public ViewClient() {
        this.setContentPane(back);

        initComponents();
        this.setLocationRelativeTo(null);
        mostrar("");
        habilitar();

    }

    void mostrar(String BuscarDato) {

        try {

            DefaultTableModel modelo;
            NClient f = new NClient();
            modelo = f.consult(BuscarDato);
            // modelo = clientController.mostrar (BuscarDato);
            jTabListado.setModel(modelo);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlClientBackGround = new BackPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabListado = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        txtDeuda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        pnlClientBackGround.setBackground(new java.awt.Color(255, 255, 255));
        pnlClientBackGround.setPreferredSize(new java.awt.Dimension(928, 523));
        pnlClientBackGround.setVerifyInputWhenFocusTarget(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(38, 35, 34));
        jLabel3.setText("Codigo");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 35, 34));
        jLabel4.setText("Cedula");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(38, 35, 34));
        jLabel5.setText("Nombres");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(38, 35, 34));
        jLabel6.setText("Apellidos");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(38, 35, 34));
        jLabel7.setText("Telefono");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(38, 35, 34));
        jLabel8.setText("Email");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(38, 35, 34));
        jLabel9.setText("Direccion");

        jTabListado.setModel(new javax.swing.table.DefaultTableModel(
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
        jTabListado.setGridColor(new java.awt.Color(153, 153, 153));
        jTabListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabListado);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(38, 35, 34));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imgBusqueda.png"))); // NOI18N

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imgNuevo.PNG"))); // NOI18N
        btnnuevo.setBorderPainted(false);
        btnnuevo.setContentAreaFilled(false);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(0, 0, 0));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imgGuardar.PNG"))); // NOI18N
        btnguardar.setBorderPainted(false);
        btnguardar.setContentAreaFilled(false);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(255, 51, 0));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imgEliminar.PNG"))); // NOI18N
        btneliminar.setBorderPainted(false);
        btneliminar.setContentAreaFilled(false);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(255, 255, 255));
        btneditar.setForeground(new java.awt.Color(51, 51, 51));
        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imgEditar.PNG"))); // NOI18N
        btneditar.setBorderPainted(false);
        btneditar.setContentAreaFilled(false);
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imgSalir.PNG"))); // NOI18N
        btnsalir.setBorderPainted(false);
        btnsalir.setContentAreaFilled(false);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipo.setText("Tipo");

        txtDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeudaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Deuda");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista de Clientes");

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "NATURAL", "JURIDICA" }));

        javax.swing.GroupLayout pnlClientBackGroundLayout = new javax.swing.GroupLayout(pnlClientBackGround);
        pnlClientBackGround.setLayout(pnlClientBackGroundLayout);
        pnlClientBackGroundLayout.setHorizontalGroup(
            pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(70, 70, 70))
                    .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                                .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                                                .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(15, 15, 15)
                                                .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtEmail)
                                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                                                    .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                                                    .addGap(65, 65, 65)
                                                    .addComponent(txtCodigo)))))
                                    .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(lblTipo)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(15, 15, 15)
                                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtNombres)
                                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(266, 266, 266)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(289, 289, 289))
            .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(105, 105, 105))
        );
        pnlClientBackGroundLayout.setVerticalGroup(
            pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientBackGroundLayout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlClientBackGroundLayout.createSequentialGroup()
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipo)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(10, 10, 10)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlClientBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlClientBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 1358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlClientBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeudaActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed

        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed

        if (txtCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Identificación", "Aviso", JOptionPane.ERROR_MESSAGE);

        } else if (cmbTipo.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Seleccione el Tipo", "Aviso", JOptionPane.ERROR_MESSAGE);

        } else if (txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el numero de Telefono", "Aviso", JOptionPane.ERROR_MESSAGE);

        } else if (txtNombres.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Nombre", "Aviso", JOptionPane.ERROR_MESSAGE);

        } else if (txtDeuda.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el valor de la deuda. En caso de no haber deuda ingrese '0'", "Aviso", JOptionPane.ERROR_MESSAGE);

        } else {
            //EDITAR VALORES A LA TABLA CLIENTE
            DAOClient client = new DAOClient();

            NClient clientController = new NClient();

            client.setClientID(Integer.parseInt(txtCodigo.getText()));
            client.setDni(txtCedula.getText());
            client.setType(cmbTipo.getSelectedItem().toString());
            client.setName(txtNombres.getText());
            client.setLastName(txtApellidos.getText());
            client.setAddress(txtDireccion.getText());
            client.setPhoneNumber(txtTelefono.getText());
            client.setEmail(txtEmail.getText());
            client.setDebt(txtDeuda.getText());

            clientController.edit(client);

            //MENSAJE
            JOptionPane.showMessageDialog(this, "Los datos han sido modificados", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            mostrar("");
            //BORAR DATO DE LA CAJA DE TEXTOS

            limpiar();

            habilitar();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        if (!txtCodigo.getText().equals("")) {

            int con = JOptionPane.showConfirmDialog(rootPane, "¿Desea Eliminar el Registro?");

            if (con == 0) {

                //ELIMINAR VALOR
                DAOClient client = new DAOClient();

                NClient clientController = new NClient();

                client.setClientID(Integer.parseInt(txtCodigo.getText()));

                clientController.delete(client);

                JOptionPane.showMessageDialog(this, "Han sido eliminados los Datos", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                mostrar("");
                //BORAR DATO DE LA CAJA DE TEXTOS

                limpiar();

                habilitar();

            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (txtCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Identificación", "Aviso", JOptionPane.ERROR_MESSAGE);

        } else if (cmbTipo.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Seleccione el Tipo", "Aviso", JOptionPane.ERROR_MESSAGE);

        } else if (txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el numero de Telefono", "Aviso", JOptionPane.ERROR_MESSAGE);

        } else if (txtNombres.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Nombre", "Aviso", JOptionPane.ERROR_MESSAGE);

        } else if (txtDeuda.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el valor de la deuda. En caso de no haber deuda ingrese '0'", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else {
            /*                 INSERTAR VALORES A LA TABLA CLIENTE                                              */
            DAOClient client = new DAOClient();

            NClient clientController = new NClient();

            //            client.setIdcliente(Integer.parseInt(txtCodigo.getText()));
            client.setDni(txtCedula.getText());
            client.setType(cmbTipo.getSelectedItem().toString());
            client.setName(txtNombres.getText());
            client.setLastName(txtApellidos.getText());
            client.setAddress(txtDireccion.getText());
            client.setPhoneNumber(txtTelefono.getText());
            client.setEmail(txtEmail.getText());
            client.setDebt(txtDeuda.getText());
            clientController.insertPerson(client);
            clientController.insertClient(client);
            // MENSAJE
            JOptionPane.showMessageDialog(this, "Los datos han sido guardados", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            mostrar("");
            //BORAR DATO DE LA CAJA DE TEXTOS

            limpiar();

            habilitar();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed

        mostrar("");

        //BORAR DATO DE LA CAJA DE TEXTOS
        limpiar();
        habilitar();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased

        mostrar(txtBusqueda.getText());

        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void jTabListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabListadoMouseClicked

        limpiar();

        int fila = jTabListado.rowAtPoint(evt.getPoint());

        try {
            txtCodigo.setText(jTabListado.getValueAt(fila, 0).toString());
        } catch (NullPointerException nullE) {
            txtCodigo.setText("NULL");
        }
        try {
            txtCedula.setText(jTabListado.getValueAt(fila, 1).toString());
        } catch (NullPointerException nullE) {
            txtCedula.setText("NULL");
        }
        try {
            txtNombres.setText(jTabListado.getValueAt(fila, 3).toString());
        } catch (NullPointerException nullE) {
            txtNombres.setText("NULL");
        }
        try {
            txtApellidos.setText(jTabListado.getValueAt(fila, 4).toString());
        } catch (NullPointerException nullE) {
            txtApellidos.setText("NULL");
        }
        try {
            txtDireccion.setText(jTabListado.getValueAt(fila, 5).toString());
        } catch (NullPointerException nullE) {
            txtDireccion.setText("NULL");
        }
        try {
            txtTelefono.setText(jTabListado.getValueAt(fila, 6).toString());
        } catch (NullPointerException nullE) {
            txtTelefono.setText("NULL");
        }
        try {
            txtEmail.setText(jTabListado.getValueAt(fila, 7).toString());
        } catch (NullPointerException nullE) {
            txtEmail.setText("NULL");
        }
        try {
            txtDeuda.setText(jTabListado.getValueAt(fila, 8).toString());
        } catch (NullPointerException nullE) {
            txtDeuda.setText("NULL");
        }
        if (jTabListado.getValueAt(fila, 2).toString().equals("NATURAL")) {
            cmbTipo.setSelectedItem(String.valueOf("NATURAL"));
        } else {
            cmbTipo.setSelectedItem(String.valueOf("JURIDICA"));
        }
        desahabilitar();

        // TODO add your handling code here:
    }//GEN-LAST:event_jTabListadoMouseClicked

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped

        char c = evt.getKeyChar();

        if (c < '0' || c > '9') {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped

        //char c = evt.getKeyChar();
        //if (c < '0' || c > '9') {
        //    evt.consume();
        //}
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed
    private void habilitar() {

        btnguardar.setEnabled(true);
        btneditar.setEnabled(false);
        btneliminar.setEnabled(false);

    }

    private void desahabilitar() {

        btnguardar.setEnabled(false);
        btneditar.setEnabled(true);
        btneliminar.setEnabled(true);
    }

    private void limpiar() {

        this.txtCodigo.setText("");
        this.txtNombres.setText("");
        this.txtApellidos.setText("");
        this.txtCedula.setText("");
        this.txtDireccion.setText("");
        this.txtTelefono.setText("");
        this.txtDeuda.setText("");
        this.txtEmail.setText("");
        cmbTipo.setSelectedItem(String.valueOf("Seleccionar"));

    }

    class BackPanel extends JPanel {

        private Image image;

        @Override
        public void paint(Graphics g) {
            image = new ImageIcon(getClass().getResource("/images/imgClienteBg.PNG")).getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
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
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabListado;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel pnlClientBackGround;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDeuda;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
