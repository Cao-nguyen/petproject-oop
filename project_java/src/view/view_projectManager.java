/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO_Interface.Employee_DAO;
import DAO_Interface.ProjectManager_DAO;
import DAO_Interface.Project_DAO;
import JDBC.JDBCConnection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import model.Employee;
import model.Project;
import model.ProjectManager;

/**
 *
 * @author ACER
 */
public class view_projectManager extends javax.swing.JFrame {
    private ProjectManager_DAO projectManager_DAO;
    /**
     * Creates new form view_employee
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     */
    public view_projectManager() throws SQLException, ParseException {
        initComponents();
        showDataToTable();
        showDataToComboBox();
    }

    public void showDataToComboBox() throws SQLException, ParseException{
        Project_DAO project_DAO = new Project_DAO();
        Employee_DAO emp_DAO = new Employee_DAO();
        ArrayList<Project> listProject = project_DAO.selectAll();
        ArrayList<Employee> listEmp = emp_DAO.selectAll();
        DefaultComboBoxModel box_ProjectID = (DefaultComboBoxModel)boxProjectID.getModel();
        DefaultComboBoxModel box_empID = (DefaultComboBoxModel)boxEmpID.getModel();
        box_ProjectID.removeAllElements();
        box_empID.removeAllElements();
        for(Project p : listProject){
            String project_ID = p.getProject_ID();
            box_ProjectID.addElement(project_ID);
        }
        for(Employee e : listEmp){
            String emp_ID = e.getID();
            box_empID.addElement(emp_ID);
        }
        JDBCConnection.disconnect(project_DAO.getStatement().connect);
        JDBCConnection.disconnect(emp_DAO.getStatement().connect);
    }
    
    
    public void reset() throws SQLException, ParseException{
        txtTask.setText("");
        txtProjectID.setText("");
        txtEmpID.setText("");
        boxProjectID.setEnabled(true);
        boxEmpID.setEnabled(true);
        showDataToTable();
    }
    public void showDataToTable() throws SQLException, ParseException{
        projectManager_DAO = new ProjectManager_DAO();
        ArrayList<ProjectManager> listProjectManager = projectManager_DAO.selectAll();
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        tableModel.setRowCount(0);
        for(ProjectManager pm : listProjectManager){
            String project_ID = pm.getProject().getProject_ID();
            String emp_ID = pm.getEmployee().getID();
            String task = pm.getTask();
            String[] dataRow = {project_ID, emp_ID, task};
            tableModel.addRow(dataRow);
        }
        JDBCConnection.disconnect(projectManager_DAO.getStatement().connect);
    }
    
    public void showDataToTable(String condition) throws SQLException, ParseException{
        projectManager_DAO = new ProjectManager_DAO();
        ArrayList<ProjectManager> listProjectManager = projectManager_DAO.selectByCondition(condition);
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        tableModel.setRowCount(0);
        for(ProjectManager pm : listProjectManager){
            String project_ID = pm.getProject().getProject_ID();
            String emp_ID = pm.getEmployee().getID();
            String task = pm.getTask();
            String[] dataRow = {project_ID, emp_ID, task};
            tableModel.addRow(dataRow);
        }
        JDBCConnection.disconnect(projectManager_DAO.getStatement().connect);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtTask = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        boxProjectID = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        boxEmpID = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btxDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtNameProject = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        btnShow = new javax.swing.JButton();
        txtEmpID = new javax.swing.JTextField();
        txtProjectID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("EMPLOYEE MANAGER");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 153));
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 153, 153));

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mã dự án:");

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.setForeground(new java.awt.Color(255, 204, 204));

        txtTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaskActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nhiệm vụ:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTask, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        boxProjectID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxProjectID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxProjectIDActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mã nhân viên:");

        boxEmpID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxEmpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEmpIDActionPerformed(evt);
            }
        });

        btnInsert.setBackground(new java.awt.Color(255, 153, 153));
        btnInsert.setForeground(new java.awt.Color(0, 0, 0));
        btnInsert.setText("Thêm");
        btnInsert.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 153, 153));
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btxDelete.setBackground(new java.awt.Color(255, 153, 153));
        btxDelete.setForeground(new java.awt.Color(0, 0, 0));
        btxDelete.setText("Xóa");
        btxDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxDeleteActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 153, 153));
        btnReset.setForeground(new java.awt.Color(0, 0, 0));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        txtNameProject.setEditable(false);
        txtNameProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameProjectActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tên dự án:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btxDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNameProject, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boxEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(303, 303, 303))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNameProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btxDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dự án", "Mã nhân viên", "Nhiệm vụ"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setForeground(new java.awt.Color(255, 153, 153));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("PROJECT MANAGER");

        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        backBtn.setForeground(new java.awt.Color(0, 0, 0));
        backBtn.setText("<");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(backBtn))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnShow.setBackground(new java.awt.Color(255, 153, 153));
        btnShow.setForeground(new java.awt.Color(0, 0, 0));
        btnShow.setText("Xem");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mã nhân viên:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Mã dự án:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int x = table.getSelectedRow();
        if(x >= 0){
            boxProjectID.setSelectedItem(table.getValueAt(x, 0));
            boxEmpID.setSelectedItem(table.getValueAt(x, 1));
            txtTask.setText(table.getValueAt(x, 2) + "");
            boxProjectID.setEnabled(false);
            boxEmpID.setEnabled(false);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void boxEmpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEmpIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxEmpIDActionPerformed

    private void boxProjectIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxProjectIDActionPerformed
        String project_ID = boxProjectID.getItemAt(boxProjectID.getSelectedIndex());
        String sql = "SELECT project_name FROM database.project WHERE project_ID ='"+project_ID+"';";
        try {
            Statement stm = JDBCConnection.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            String project_name = "";
            if(rs.next()){
                project_name = rs.getString("project_name");
            }
            txtNameProject.setText(project_name);
        } catch (SQLException ex) {
            Logger.getLogger(view_projectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_boxProjectIDActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        try {
            reset();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(view_projectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btxDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxDeleteActionPerformed
        String project_ID = boxProjectID.getItemAt(boxProjectID.getSelectedIndex());
        String emp_ID = boxEmpID.getItemAt(boxEmpID.getSelectedIndex());
        String task = txtTask.getText();
        try {
            Project_DAO project_DAO = new Project_DAO();
            Project p = project_DAO.selectByID(project_ID);
            Employee_DAO emp_DAO = new Employee_DAO();
            Employee emp = emp_DAO.selectByID(emp_ID);
            ProjectManager pm = new ProjectManager(p, emp, task);
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa thành viên này khỏi dự án ?", "Yes", JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION){
                int result = projectManager_DAO.delete(pm);
                switch (result) {
                    case -1 -> JOptionPane.showMessageDialog(this, "Không thể xóa thành viên này vì dự án đang đạt tối thiểu 5 nhân viên!");
                    case 0 -> JOptionPane.showMessageDialog(this, "Không có thành viên này trong dự án!");
                    case 1 -> {
                        JOptionPane.showMessageDialog(this, "Xóa thành công!");
                        reset();
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Xóa không thành công!");
                }    
            }
         catch (SQLException | ParseException ex) {
            Logger.getLogger(view_projectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btxDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String project_ID = boxProjectID.getItemAt(boxProjectID.getSelectedIndex());
        String emp_ID = boxEmpID.getItemAt(boxEmpID.getSelectedIndex());
        String task = txtTask.getText();
        if(task.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập nhiệm vụ của nhân viên!");
        }
        else{
            try {
                Project_DAO project_DAO = new Project_DAO();
                Project project = project_DAO.selectByID(project_ID);
                Employee_DAO emp_DAO = new Employee_DAO();
                Employee emp = emp_DAO.selectByID(emp_ID);
                ProjectManager pm = new ProjectManager(project, emp, task);
                int result = projectManager_DAO.update(pm);
                if(result != 1){
                    JOptionPane.showMessageDialog(this, "Không có thành viên này trong dự án!");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Sửa thành công!");
                    reset();
                }
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(view_projectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        String project_ID = boxProjectID.getItemAt(boxProjectID.getSelectedIndex());
        String emp_ID = boxEmpID.getItemAt(boxEmpID.getSelectedIndex());
        String task = txtTask.getText();
        if(task.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập công việc cho nhân viên!");
        }
        else{
            try {
                projectManager_DAO = new ProjectManager_DAO();
                Project_DAO project_DAO = new Project_DAO();
                Project project = project_DAO.selectByID(project_ID);
                Employee_DAO emp_DAO = new Employee_DAO();
                Employee emp = emp_DAO.selectByID(emp_ID);
                ProjectManager pm = new ProjectManager(project, emp, task);
                int result = projectManager_DAO.insert(pm);
                switch (result) {
                    case -1 -> JOptionPane.showMessageDialog(this, "Số lượng dự án mà nhân viên này làm đã đạt tối đa!");
                    case -2 -> JOptionPane.showMessageDialog(this, "Số lượng nhân viên trong dự án này đã đạt tối đa!");
                    case 1 -> {
                        JOptionPane.showMessageDialog(this, "Thêm thành công!");
                        reset();
                    }
                }
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(view_projectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaskActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaskActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        projectManager_DAO  = new ProjectManager_DAO();
        String textProjectIDSearch = txtProjectID.getText();
        String textEmpIDSearch = txtEmpID.getText();
        if(textProjectIDSearch.equals("") && textEmpIDSearch.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã dự án hoặc Mã nhân viên để tìm kiếm!");
        }
        else{
            try {
                if(textEmpIDSearch.equals("")){
                    String sql = " project_ID = '"+textProjectIDSearch+"'";
                    showDataToTable(sql);
                }
                else if(textProjectIDSearch.equals("")){
                    String sql = " emp_ID = '"+textEmpIDSearch+"'";
                    showDataToTable(sql);
                }
                else{
                    String sql = " project_ID = '"+textProjectIDSearch+"' AND emp_ID = '"+textEmpIDSearch+"'";
                    showDataToTable(sql);
                }
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(view_projectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnShowActionPerformed

    private void txtNameProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameProjectActionPerformed

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
            java.util.logging.Logger.getLogger(view_projectManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_projectManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_projectManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_projectManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new view_projectManager().setVisible(true);
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(view_projectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backBtn;
    private javax.swing.JComboBox<String> boxEmpID;
    private javax.swing.JComboBox<String> boxProjectID;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btxDelete;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtEmpID;
    private javax.swing.JTextField txtNameProject;
    private javax.swing.JTextField txtProjectID;
    private javax.swing.JTextField txtTask;
    // End of variables declaration//GEN-END:variables
}
