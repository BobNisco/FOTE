package fote.gui;
import fote.controller.ProposalLogic;
import fote.entry.Entry;
import fote.entry.Proposal;
import fote.entry.Suggestion;
import fote.entry.User;
import fote.model.ProposalModel;
import fote.model.SuggestionModel;
import fote.model.UserModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Evan
 */
public class MainFrame extends javax.swing.JFrame {

    ArrayList<Proposal> proposals;
    ArrayList<Suggestion> suggestions;
    int selection;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.proposals = new ArrayList<Proposal>();
        this.suggestions = new ArrayList<Suggestion>();
        loadProposals();
        loadSuggestions();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            e.printStackTrace();
        }

        this.setLocationRelativeTo(null);
        this.setTitle("FOTE");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        suggestionTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        proposalTable = new javax.swing.JTable();
        suggestionHeaderLabel = new javax.swing.JLabel();
        proposalHeaderLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        addProposalButton = new javax.swing.JButton();
        addSuggestionButton = new javax.swing.JButton();
        filterLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox();
        priorityLabel = new javax.swing.JLabel();
        priorityComboBox = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        suggestionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Subject", "Author", "Date Created", "Comment Count"
            }
        ));
        suggestionTable.setColumnSelectionAllowed(true);
        suggestionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                suggestionTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                suggestionTableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(suggestionTable);
        suggestionTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        proposalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Subject", "Author", "Expiration Date", "Status"
            }
        ));
        proposalTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                proposalTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                proposalTableMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(proposalTable);
        proposalTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        suggestionHeaderLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        suggestionHeaderLabel.setText("Suggestions");

        proposalHeaderLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        proposalHeaderLabel.setText("Proposals");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        addProposalButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addProposalButton.setText("+");
        addProposalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProposalButtonActionPerformed(evt);
            }
        });

        addSuggestionButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addSuggestionButton.setText("+");
        addSuggestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSuggestionButtonActionPerformed(evt);
            }
        });

        filterLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        filterLabel.setText("Filters:");

        statusLabel.setText("Status:");

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Active", "Expired" }));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        priorityLabel.setText("Priority:");

        priorityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Urgent", "Important", "Moderate", "Low", "Backlog" }));
        priorityComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priorityComboBoxActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refreshButton)
                        .addGap(5, 5, 5)
                        .addComponent(exitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(filterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priorityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priorityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(statusLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addProposalButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(proposalHeaderLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(suggestionHeaderLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addSuggestionButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(proposalHeaderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priorityLabel)
                    .addComponent(priorityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProposalButton)
                    .addComponent(filterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSuggestionButton)
                    .addComponent(suggestionHeaderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(exitButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProposalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProposalButtonActionPerformed
        new CreateProposal(this, true).setVisible(true);
    }//GEN-LAST:event_addProposalButtonActionPerformed

    private void addSuggestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSuggestionButtonActionPerformed
        new CreateSuggestion(this, true).setVisible(true);
    }//GEN-LAST:event_addSuggestionButtonActionPerformed

    /**
     * Event listener for the logout button
     * @param evt 
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        new Logout(this,true).setVisible(true);
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * Event listener for the refresh button
     * @param evt 
     */
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        loadProposals();
        loadSuggestions();
    }//GEN-LAST:event_refreshButtonActionPerformed

    /**
     * Event listener for Proposals table mouse down
     * @param evt 
     */
    private void proposalTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proposalTableMousePressed
        JTable jtable = (JTable) evt.getSource();
        selection = jtable.getSelectedRow();
        jtable.clearSelection();
    }//GEN-LAST:event_proposalTableMousePressed

    /**
     * Event listener for Proposals table mouse release,
     * Creating a proposal view dialog for the selected proposal.
     * @param evt 
     */
    private void proposalTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proposalTableMouseReleased
        JTable jtable = (JTable) evt.getSource();
        System.out.println("Selection: " + selection);
        System.out.println(proposals.get(selection).toString());
        new ViewProposal(this, true, (Proposal) proposals.get(selection)).setVisible(true);
    }//GEN-LAST:event_proposalTableMouseReleased

    /**
     * Event listener for Suggestions table mouse down
     * @param evt 
     */
    private void suggestionTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suggestionTableMousePressed
        JTable jtable = (JTable) evt.getSource();
        selection = jtable.getSelectedRow();
        jtable.clearSelection();
    }//GEN-LAST:event_suggestionTableMousePressed

    /**
     * Event listener for Suggestions table mouse release,
     * creating a new suggestion view dialog for the selected suggestion.
     * @param evt 
     */
    private void suggestionTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suggestionTableMouseReleased
        JTable jtable = (JTable) evt.getSource();
        System.out.println("Selection: " + selection);
        System.out.println(suggestions.get(selection).toString());
        new ViewSuggestion(this, true, (Suggestion) suggestions.get(selection)).setVisible(true);
    }//GEN-LAST:event_suggestionTableMouseReleased

    /**
     * Event listener for proposal status filter, which triggers a refresh
     * @param evt 
     */
    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        loadProposals();
    }//GEN-LAST:event_statusComboBoxActionPerformed

    /**
     * Event listener for proposal priority filter, which triggers a refresh
     * @param evt 
     */
    private void priorityComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorityComboBoxActionPerformed
        loadProposals();
    }//GEN-LAST:event_priorityComboBoxActionPerformed

    /**
     * Query the database for proposals using the specified filters,
     * and display them in the table.
     */
    public void loadProposals() {
        this.proposals.clear();
        ProposalModel proposalModel = new ProposalModel();
        String selectedStatus = statusComboBox.getSelectedItem().toString();
        String statusQuery = "";
        if (selectedStatus.equalsIgnoreCase("active")) { 
            statusQuery = ", expirationTime: {$gte:"+new Date().getTime()+"}";
        } else if(selectedStatus.equalsIgnoreCase("expired")) {
            statusQuery = ", expirationTime: {$lt:"+new Date().getTime()+"}";
        }
        
        int selectedPriority = Proposal.getPriorityLevel(priorityComboBox.getSelectedItem().toString());
        String priorityQuery = "";
        if(selectedPriority > 0) {
            priorityQuery = ", priority: " + selectedPriority;
        }
        
        Iterable<Entry> proposalQuery = proposalModel.query("{id:{$gte: 0}"+statusQuery+priorityQuery+"}");
        System.out.println("{id:{$gte: 0}"+statusQuery+priorityQuery+"}");
        
        DefaultTableModel model = (DefaultTableModel) proposalTable.getModel();
        model.setRowCount(0);

        UserModel userModel = new UserModel();
        for (Entry entry : proposalQuery){
            this.proposals.add((Proposal) entry);
            Proposal proposal = (Proposal) entry;
            String status = "active";
            if (ProposalLogic.isExpired(proposal)) {
                status = "expired";
            }
            Iterable<Entry> userQuery = userModel.query("{id:"+proposal.getAuthor()+"}");
            if(userQuery.iterator().hasNext()) {
                User author = (User) userQuery.iterator().next();
                String name = author.getFirstName() + " " + author.getLastName();
                model.addRow(new String[]{proposal.getSubject(), name, proposal.getExpirationDate().toString() , status});
            }
            else {
                System.out.println("author not found, row not added");
            }
        }
    }

    /**
     * Query the database for suggestions and display them in the table
     */
    public void loadSuggestions() {
        this.suggestions.clear();
        SuggestionModel suggestionModel = new SuggestionModel();
        Iterable<Entry> suggestionQuery = suggestionModel.query("{id:{$gte: 0}}");

        DefaultTableModel model = (DefaultTableModel) suggestionTable.getModel();
        model.setRowCount(0);

        UserModel userModel = new UserModel();
        for (Entry entry : suggestionQuery){
            this.suggestions.add((Suggestion) entry);
            Suggestion suggestion = (Suggestion) entry;
            Iterable<Entry> userQuery = userModel.query("{id:"+suggestion.getAuthor()+"}");
            if(userQuery.iterator().hasNext()){
                User author = (User) userQuery.iterator().next();
                String name = author.getFirstName() + " " + author.getLastName();
                model.addRow(new String[]{suggestion.getSubject(), name, suggestion.getCreateDate().toString() , String.valueOf(suggestion.getComments().size())});
            } else {
                System.out.println("author not found, row not added");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProposalButton;
    private javax.swing.JButton addSuggestionButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox priorityComboBox;
    private javax.swing.JLabel priorityLabel;
    private javax.swing.JLabel proposalHeaderLabel;
    private javax.swing.JTable proposalTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel suggestionHeaderLabel;
    private javax.swing.JTable suggestionTable;
    // End of variables declaration//GEN-END:variables
}
