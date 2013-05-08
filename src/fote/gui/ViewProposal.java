package fote.gui;

import fote.FOTE;
import fote.controller.ProposalLogic;
import fote.entry.Comment;
import fote.entry.Proposal;
import fote.model.UserModel;
import fote.util.MongoHelper;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jason
 */
public class ViewProposal extends javax.swing.JDialog {

private Proposal proposal;

    /**
     * Constructor
     * @param parent the MainFrame
     * @param modal whether we want this to be modal in regards to the parent frame
     */
    public ViewProposal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Constructor
     * @param parent the MainFrame
     * @param modal whether we want this to be modal in regards to the parent frame
     * @param proposal the proposal the user is requesting to view
     */
    public ViewProposal(java.awt.Frame parent, boolean modal, Proposal proposal) {
        super(parent, modal);
        this.setTitle("Proposal");
        initComponents();
        this.setProposal(proposal);
        setViewProposal(proposal);
        this.setLocationRelativeTo(null);
    }

    /**
     * 
     * @param p The proposal the user is viewing
     */
    private void setProposal(Proposal p){
        this.proposal = p;
    }

    /**
     * 
     * @return The proposal the user is viewing
     */
    private Proposal getProposal(){
        return this.proposal;
    }

    /**
     * Loads the proposal's values into the view 
     * @param proposal The proposal the user is viewing
     */
    private void setViewProposal(Proposal proposal) {
        setProposal(proposal);
        UserModel userModel = new UserModel();
        authorLabelTextField.setText(userModel.getUser(proposal.getAuthor()).getFullName());
        dateCreatedTextField.setText(proposal.getCreateDate().toString());
        priorityTextField.setText(Proposal.getPriorityLevel(proposal.getPriority()));
        dateUpdatedTextField.setText(proposal.getUpdateDate().toString());
        subjectTextField.setText(proposal.getSubject());
        descriptionTextArea.setText(proposal.getDescription());
        expirationDateTextField.setText(proposal.getExpirationDate().toString());
        optionComboBox.setModel(new DefaultComboBoxModel(proposal.getOptions().toArray(new String[proposal.getOptions().size()])));
        attachmentsComboBox.setModel(new DefaultComboBoxModel(proposal.getAttachments().toArray(new String[proposal.getAttachments().size()])));
        setComments();
        if (this.proposal.getAuthor() != FOTE.getUser().getId()) {
            editButton.setVisible(false);
            deleteButton.setVisible(false);
        }
    }

    /**
     * Separate method that sets the comments in the comment view
     */
    private void setComments() {
        ArrayList<Comment> comments = ProposalLogic.getComments(proposal);
        UserModel userModel = new UserModel();
        commentTextArea.setText("");
        for(Comment c : comments){
            commentTextArea.setText(commentTextArea.getText() +
                    c.getText() + "\n-"
                    + userModel.getUser(c.getAuthor()).getFullName() +
                    "\n---------------------\n");
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

        authorLabel = new javax.swing.JLabel();
        authorLabelTextField = new javax.swing.JTextField();
        dateCreatedLabel = new javax.swing.JLabel();
        dateCreatedTextField = new javax.swing.JTextField();
        dateUpdatedLabel = new javax.swing.JLabel();
        dateUpdatedTextField = new javax.swing.JTextField();
        expirationDateLabel = new javax.swing.JLabel();
        expirationDateTextField = new javax.swing.JTextField();
        priorityLabel = new javax.swing.JLabel();
        priorityTextField = new javax.swing.JTextField();
        subjectLabel = new javax.swing.JLabel();
        subjectTextField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        attachmentsLabel = new javax.swing.JLabel();
        attachmentsComboBox = new javax.swing.JComboBox();
        downloadAttachmentButton = new javax.swing.JButton();
        newAttachmentButton = new javax.swing.JButton();
        optionLabel = new javax.swing.JLabel();
        optionComboBox = new javax.swing.JComboBox();
        voteButton = new javax.swing.JButton();
        addCommentLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addCommentTextArea = new javax.swing.JTextArea();
        commentLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();
        postCommentButto = new javax.swing.JButton();
        viewResultsButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        authorLabel.setText("Author:");

        authorLabelTextField.setEditable(false);

        dateCreatedLabel.setText("Date Created: ");

        dateCreatedTextField.setEditable(false);

        dateUpdatedLabel.setText("Date Updated: ");

        dateUpdatedTextField.setEditable(false);

        expirationDateLabel.setText("Expiration Date: ");

        expirationDateTextField.setEditable(false);

        priorityLabel.setText("Priority: ");

        priorityTextField.setEditable(false);

        subjectLabel.setText("Subject: ");

        subjectTextField.setEditable(false);

        descriptionLabel.setText("Description: ");

        descriptionTextArea.setEditable(false);
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(descriptionTextArea);

        attachmentsLabel.setText("Attachments: ");

        attachmentsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        attachmentsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachmentsComboBoxActionPerformed(evt);
            }
        });

        downloadAttachmentButton.setText("Download");
        downloadAttachmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadAttachmentButtonActionPerformed(evt);
            }
        });

        newAttachmentButton.setText("New Attachment");
        newAttachmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAttachmentButtonActionPerformed(evt);
            }
        });

        optionLabel.setText("Options: ");

        optionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        voteButton.setText("Vote");
        voteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteButtonActionPerformed(evt);
            }
        });

        addCommentLabel.setText("Add Comment: ");

        addCommentTextArea.setColumns(20);
        addCommentTextArea.setRows(1);
        jScrollPane2.setViewportView(addCommentTextArea);

        commentLabel.setText("Comments: ");

        commentTextArea.setEditable(false);
        commentTextArea.setColumns(20);
        commentTextArea.setRows(5);
        jScrollPane3.setViewportView(commentTextArea);

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        postCommentButto.setText("Post");
        postCommentButto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postCommentButtoActionPerformed(evt);
            }
        });

        viewResultsButton.setText("View Results");
        viewResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultsButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(expirationDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expirationDateTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewResultsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(dateUpdatedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateUpdatedTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(commentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(attachmentsLabel)
                            .addComponent(optionLabel)
                            .addComponent(addCommentLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(postCommentButto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(optionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(voteButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(attachmentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(downloadAttachmentButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(newAttachmentButton)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(subjectLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(descriptionLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1))
                            .addComponent(subjectTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateCreatedLabel)
                            .addComponent(authorLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(authorLabelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priorityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priorityTextField))
                            .addComponent(dateCreatedTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorLabel)
                    .addComponent(authorLabelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priorityLabel)
                    .addComponent(priorityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateCreatedLabel)
                    .addComponent(dateCreatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateUpdatedLabel)
                    .addComponent(dateUpdatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expirationDateLabel)
                    .addComponent(expirationDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectLabel)
                    .addComponent(subjectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attachmentsLabel)
                    .addComponent(attachmentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downloadAttachmentButton)
                    .addComponent(newAttachmentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionLabel)
                    .addComponent(optionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCommentLabel)
                    .addComponent(postCommentButto)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commentLabel)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(viewResultsButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downloadAttachmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadAttachmentButtonActionPerformed
        if (attachmentsComboBox.getSelectedItem() != null){
            JFileChooser filechooser = new JFileChooser();
                filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int result = filechooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                   String path = filechooser.getCurrentDirectory().toString()
            + File.separatorChar + filechooser.getSelectedFile().getName();
                  String fileNameDB = getProposal().getSubject() + "-" + attachmentsComboBox.getSelectedItem().toString();
                  String fileName = attachmentsComboBox.getSelectedItem().toString();
                   if(MongoHelper.download(fileNameDB, path, fileName)){
                   JOptionPane.showMessageDialog(this, "File downloaded!");
                   }
                   else{
                       JOptionPane.showMessageDialog(this,
                "Attachment failed to download",
                "Error",
                JOptionPane.ERROR_MESSAGE);
                   }

                if (result == JFileChooser.CANCEL_OPTION) {
                    // Disregard
                    }
                }
        }
    }//GEN-LAST:event_downloadAttachmentButtonActionPerformed

    private void newAttachmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAttachmentButtonActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = filechooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
           String path = filechooser.getCurrentDirectory().toString()
            + File.separatorChar + filechooser.getSelectedFile().getName();
           String fileNameDB = getProposal().getSubject() + "-" + filechooser.getSelectedFile().getName();
           if(MongoHelper.upload(path, fileNameDB)){
               getProposal().getAttachments().add(filechooser.getSelectedFile().getName());
               JOptionPane.showMessageDialog(this,
                   "Attachment successfully uploaded");
               setViewProposal(getProposal());
           }
           else{
               JOptionPane.showMessageDialog(this,
                "Attachment failed to upload",
                "Error",
                JOptionPane.ERROR_MESSAGE);
           }
        if (result == JFileChooser.CANCEL_OPTION) {
            // Disregard
            }
        }
    }//GEN-LAST:event_newAttachmentButtonActionPerformed

    private void voteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteButtonActionPerformed
        if(!ProposalLogic.isExpired(getProposal())) {
            int option = optionComboBox.getSelectedIndex();

            if(ProposalLogic.vote(proposal, option)){
                JOptionPane.showMessageDialog(this,
                       "Vote cast!");
            }
            else{
                JOptionPane.showMessageDialog(this,
                    "Voting failed",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "This proposal is already expired!");
        }
    }//GEN-LAST:event_voteButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void postCommentButtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postCommentButtoActionPerformed
        boolean success = ProposalLogic.addComment(proposal, addCommentTextArea.getText());
        if (success) {
            JOptionPane.showMessageDialog(this, "Comment successfully added");
            addCommentTextArea.setText("");
            commentTextArea.setText("");
            setComments();
        } else {
             JOptionPane.showMessageDialog(this,
                "Comment could not be added, try again",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_postCommentButtoActionPerformed

    private void viewResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResultsButtonActionPerformed
        if(getProposal().getAuthor() == FOTE.getUser().getId() || ProposalLogic.isExpired(getProposal())){
            new ViewResults((Frame) this.getParent(), true, getProposal()).setVisible(true);
        }
        else{
             JOptionPane.showMessageDialog(this,
                "You are not the author of this proposal, you cannot view the results!\n" +
                     "Please wait until the proposal is expired.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_viewResultsButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        this.dispose();
        new CreateProposal(FOTE.getMainFrame(), true, this.proposal).setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        boolean success = ProposalLogic.deleteProposal(this.getProposal());
        if (success) {
            FOTE.getMainFrame().loadProposals();
            this.dispose();
        } else {
            System.err.println("Could not delete proposal");
            JOptionPane.showMessageDialog(this,
                "Error while deleting proposal. Please try again",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void attachmentsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachmentsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attachmentsComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(ViewProposal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProposal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProposal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProposal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewProposal dialog = new ViewProposal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addCommentLabel;
    private javax.swing.JTextArea addCommentTextArea;
    private javax.swing.JComboBox attachmentsComboBox;
    private javax.swing.JLabel attachmentsLabel;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JTextField authorLabelTextField;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JLabel dateCreatedLabel;
    private javax.swing.JTextField dateCreatedTextField;
    private javax.swing.JLabel dateUpdatedLabel;
    private javax.swing.JTextField dateUpdatedTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JButton downloadAttachmentButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel expirationDateLabel;
    private javax.swing.JTextField expirationDateTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton newAttachmentButton;
    private javax.swing.JComboBox optionComboBox;
    private javax.swing.JLabel optionLabel;
    private javax.swing.JButton postCommentButto;
    private javax.swing.JLabel priorityLabel;
    private javax.swing.JTextField priorityTextField;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JTextField subjectTextField;
    private javax.swing.JButton viewResultsButton;
    private javax.swing.JButton voteButton;
    // End of variables declaration//GEN-END:variables
}
