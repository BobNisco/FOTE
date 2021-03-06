/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fote.gui;

import fote.FOTE;
import java.util.Date;
import fote.controller.ProposalLogic;
import fote.entry.Proposal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Bob Nisco
 */
public class CreateProposal extends javax.swing.JDialog {

    private Proposal proposal;

    /**
     * Creates new form Logout
     */
    public CreateProposal(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Create Proposal");
    }

    /**
     * Creates a view for editing the proposal
     * @param parent
     * @param modal
     * @param existingProposal
     */
    public CreateProposal(java.awt.Frame parent, boolean modal, Proposal existingProposal) {
        super(parent,modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Edit Proposal");
        this.proposal = existingProposal;
        this.setFieldsForEditing();
        createButton.setText("Save Changes");
        clearButton.setVisible(false);
    }

    private void setFieldsForEditing() {
        subjectTextField.setText(this.proposal.getSubject());
        descriptionTextField.setText(this.proposal.getDescription());
        String options = "";
        for (Iterator<String> it = this.proposal.getOptions().iterator(); it.hasNext();) {
            String o = it.next();
            options += o + ", ";
        }
        optionTextField.setText(options);
        SimpleDateFormat format = new SimpleDateFormat("MM");
        monthComboBox.setSelectedIndex(Integer.parseInt(
                format.format(this.proposal.getExpirationDate())) + 1);
        monthComboBox.setSelectedIndex(Integer.parseInt(
                format.format(this.proposal.getExpirationDate())));
        format = new SimpleDateFormat("dd");
        dayComboBox.setSelectedIndex(Integer.parseInt(
                format.format(this.proposal.getExpirationDate())));
        format = new SimpleDateFormat("yyyy");
        String thisYear = format.format(this.proposal.getExpirationDate());
        int numOfOptions = yearComboBox.getItemCount();
        for (int i = 0; i < numOfOptions; i++) {
            if (yearComboBox.getItemAt(i).equals(thisYear)) {
                yearComboBox.setSelectedIndex(i);
            }
        }
        priorityComboBox.setSelectedIndex(5 - this.proposal.getPriority());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subjectLabel = new javax.swing.JLabel();
        subjectTextField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextField = new javax.swing.JTextArea();
        optionLabel = new javax.swing.JLabel();
        optionTextField = new javax.swing.JTextField();
        optionsSubText = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        expirationLabel = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox();
        dayComboBox = new javax.swing.JComboBox();
        yearComboBox = new javax.swing.JComboBox();
        priorityLabel = new javax.swing.JLabel();
        priorityComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        subjectLabel.setText("Subject:");

        descriptionLabel.setText("Description:");

        descriptionTextField.setColumns(20);
        descriptionTextField.setRows(5);
        jScrollPane1.setViewportView(descriptionTextField);

        optionLabel.setText("Options:");

        optionsSubText.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        optionsSubText.setText("Enter options separated by a comma");

        createButton.setText("Create Proposal");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        expirationLabel.setText("Expiration:");

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));

        priorityLabel.setText("Priority:");

        priorityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Urgent", "Important", "Moderate", "Low", "Backlog" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(descriptionLabel)
                            .addComponent(subjectLabel)
                            .addComponent(optionLabel)
                            .addComponent(expirationLabel)
                            .addComponent(priorityLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subjectTextField)
                            .addComponent(jScrollPane1)
                            .addComponent(optionTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(optionsSubText))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(priorityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(descriptionLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionLabel)
                    .addComponent(optionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsSubText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expirationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priorityLabel)
                    .addComponent(priorityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(cancelButton)
                    .addComponent(clearButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        descriptionTextField.setText("");
        subjectTextField.setText("");
        optionTextField.setText("");
        monthComboBox.setSelectedIndex(0);
        dayComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        priorityComboBox.setSelectedIndex(0);

    }//GEN-LAST:event_clearButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        try {
            String subject = subjectTextField.getText();
            String description = descriptionTextField.getText();
            ArrayList<String> options = new ArrayList(Arrays.asList(optionTextField.getText().split(",")));
            for(String option : options) {
                option = option.trim();
            }
            String priority = priorityComboBox.getSelectedItem().toString();
            int month = Integer.valueOf(monthComboBox.getSelectedItem().toString());
            int day = Integer.valueOf(dayComboBox.getSelectedItem().toString());
            int year = Integer.valueOf(yearComboBox.getSelectedItem().toString());
            Date expiration = new Date(year, month, day);

            boolean success = false;
            if (this.proposal != null && this.proposal.getId() > -1) {
                this.proposal.setDescription(description);
                this.proposal.setSubject(subject);
                this.proposal.setOptions(options);
                this.proposal.setExpirationDate(expiration);
                this.proposal.setOptions(options);
                this.proposal.setPriority(Proposal.getPriorityLevel(priority));
                success = ProposalLogic.updateProposal(this.proposal);
            } else {
                success = ProposalLogic.createProposal(expiration, subject, description, priority, options);
            }

            if (success){
                JOptionPane.showMessageDialog(this,
                   "Proposal successfully created!");
                FOTE.getMainFrame().loadProposals();
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this,
                   "Proposal creation failed!");
            }
        } catch (java.lang.NumberFormatException e) {
            // TODO : Show error on input
        }


    }//GEN-LAST:event_createButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton createButton;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextArea descriptionTextField;
    private javax.swing.JLabel expirationLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JLabel optionLabel;
    private javax.swing.JTextField optionTextField;
    private javax.swing.JLabel optionsSubText;
    private javax.swing.JComboBox priorityComboBox;
    private javax.swing.JLabel priorityLabel;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JTextField subjectTextField;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables
}
