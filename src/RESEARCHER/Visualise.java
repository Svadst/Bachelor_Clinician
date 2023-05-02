package RESEARCHER;

import Filter.FilterFrame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;
import Filter.FilterFrame;

/**
 *
 * @author signekristiansen
 */
public class Visualise extends javax.swing.JFrame {

    public static Map<String, List<Object>> result;

    private boolean CardiacB = false;
    private boolean BurnB = false;
    private boolean SepsisB = false;
    private boolean AllDataB = false;
    List<String> selectedAetiologies = new ArrayList<>();
    
    private boolean Nofilter = false;
    private boolean IMfilter = false;
    private boolean RQfilter = false;
    private boolean FiO2filter = false;
    private boolean PEEPfilter = false;
  
    public Visualise() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        AllData = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        Cardiac = new javax.swing.JCheckBox();
        Burn = new javax.swing.JCheckBox();
        Sepsis = new javax.swing.JCheckBox();
        SelectData = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        RQ = new javax.swing.JCheckBox();
        IM = new javax.swing.JCheckBox();
        NoFilter = new javax.swing.JCheckBox();
        FiO2 = new javax.swing.JCheckBox();
        PEEP = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        RQlow = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        FiO2val = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PEEPval = new javax.swing.JTextField();
        RQhigh = new javax.swing.JTextField();
        SelectFilter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AllData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        AllData.setText("All data");
        AllData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllDataActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Please select data categories");

        Cardiac.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Cardiac.setText("Cardiac patients");
        Cardiac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardiacActionPerformed(evt);
            }
        });

        Burn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Burn.setText("Burn victims ");
        Burn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BurnActionPerformed(evt);
            }
        });

        Sepsis.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Sepsis.setText("Sepsis");
        Sepsis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SepsisActionPerformed(evt);
            }
        });

        SelectData.setBackground(new java.awt.Color(102, 153, 255));
        SelectData.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        SelectData.setText("Select data");
        SelectData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(Cardiac)
                            .addComponent(AllData)
                            .addComponent(Burn))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Sepsis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SelectData, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(AllData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cardiac)
                        .addGap(18, 18, 18)
                        .addComponent(Burn)
                        .addGap(18, 18, 18)
                        .addComponent(Sepsis)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SelectData))))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setText("StatMedX");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Please select filter ");

        RQ.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        RQ.setText("RQ filter");
        RQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RQActionPerformed(evt);
            }
        });

        IM.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        IM.setText("IM filter");

        NoFilter.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        NoFilter.setText("No filter");
        NoFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoFilterActionPerformed(evt);
            }
        });

        FiO2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        FiO2.setText("FiO2 filter ");

        PEEP.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PEEP.setText("PEEP filter");
        PEEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PEEPActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("- exclude data with a RQ value outside the range ");

        RQlow.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        RQlow.setText("0.7");
        RQlow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RQlowActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("and");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("- exclude data with a PEEP value above ");

        FiO2val.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        FiO2val.setText("0.6");
        FiO2val.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiO2valActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("cmH20");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("- exclude data with a PEEP value above ");

        PEEPval.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PEEPval.setText("10");

        RQhigh.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        RQhigh.setText("1.0");

        SelectFilter.setBackground(new java.awt.Color(102, 153, 255));
        SelectFilter.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        SelectFilter.setText("Select filter");
        SelectFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(NoFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(FiO2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FiO2val, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(PEEP)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PEEPval, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IM)
                                    .addComponent(RQ))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(RQlow, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                        .addComponent(RQhigh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SelectFilter)
                                .addContainerGap())))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(NoFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(IM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RQ)
                        .addComponent(RQlow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(RQhigh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PEEP)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(PEEPval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FiO2)
                            .addComponent(jLabel8)
                            .addComponent(FiO2val, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SelectFilter))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Bottum for cardiac
    private void CardiacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardiacActionPerformed
        if(Cardiac.isSelected()){
            CardiacB = true;
            selectedAetiologies.add("Cardiac");
        }
        else{
            CardiacB = false;
            selectedAetiologies.remove("Cardiac");
        }
    }//GEN-LAST:event_CardiacActionPerformed

    private void BurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BurnActionPerformed
         if(Burn.isSelected()){
            BurnB = true;
            selectedAetiologies.add("Burn");
        }
        else{
            BurnB = false;
            selectedAetiologies.remove("Burn");
        }
    }//GEN-LAST:event_BurnActionPerformed

    private void SepsisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SepsisActionPerformed
        if(Sepsis.isSelected()){
            SepsisB = true;
             selectedAetiologies.add("Sepsis");
        }
        else{
            SepsisB = false;
             selectedAetiologies.remove("Sepsis");
        }
    }//GEN-LAST:event_SepsisActionPerformed

    private void SelectDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectDataActionPerformed
 
     // Secure that the user chose some data
        if(CardiacB == false && SepsisB==false && BurnB==false && AllDataB ==false){
          String message = "Please select data before continuing";
          JOptionPane.showMessageDialog(this, message);
      }
        else{
        
DataSelect dataSelect = new DataSelect();
Map<String, List<Object>> SelectedData = dataSelect.fetchData(UnitID, selectedAetiologies);
// Print the data
for (Map.Entry<String, List<Object>> entry : SelectedData.entrySet()) {
    System.out.println(entry.getKey());
    List<Object> resultList = entry.getValue();
    for (Object result : resultList) {
        if (result instanceof Patient) {
            Patient patient = (Patient) result;
            System.out.println("Patient: " + patient.toString());
        } else if (result instanceof ICData) {
            ICData icdata = (ICData) result;
            System.out.println("ICData: " + icdata.toString());
        }
    }
}

        // Create a new filterframe and tranfer the selected data
//         FilterFrame filterFrame = new FilterFrame(SelectedData);
//         filterFrame.setVisible(true);
//         dispose();
    
    

      }
    }//GEN-LAST:event_SelectDataActionPerformed

    private void AllDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllDataActionPerformed
      if(AllData.isSelected()){
            AllDataB = true;
            selectedAetiologies.clear();
           selectedAetiologies.addAll(Arrays.asList("Cardiac", "Burn", "Sepsis"));
        }
        else{
            AllDataB = false;
            selectedAetiologies.removeAll(Arrays.asList("Cardiac", "Burn", "Sepsis"));
        }
    }//GEN-LAST:event_AllDataActionPerformed

    private void RQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RQActionPerformed
        // TODO add your handling code here:
        if(RQ.isSelected()){
            RQfilter = true;
        }
        else{
            RQfilter = false;
        }
    }//GEN-LAST:event_RQActionPerformed

    private void NoFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoFilterActionPerformed
        // TODO add your handling code here:
        if(NoFilter.isSelected()){
            Nofilter = true;
        }
        else{
            Nofilter = false;
        }
    }//GEN-LAST:event_NoFilterActionPerformed

    private void PEEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PEEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PEEPActionPerformed

    private void SelectFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectFilterActionPerformed
        // TODO add your handling code here:
//
//        if(Nofilter==false && RQfilter==false && IMfilter ==false && PEEPfilter==false &&FiO2filter==false){
//            String message = "Please choose a filter before continuing";
//            JOptionPane.showMessageDialog(this, message);
//        }
//
//        else if(Nofilter ==true){
//            Map<String, List<Object>> Filterdata = SelectedData;
//            System.out.println(Filterdata);
//        }
//
//        else if(RQfilter == true){
//            // Apply the filter to the result map
//            double rqLow = Double.parseDouble(RQlow.getText());
//            double rqHigh = Double.parseDouble(RQhigh.getText());
//            //RQFilter Filter = new Filter();
//            Map<String, List<Object>> Filterdata = Filter.filterData(SelectedData, rqLow, rqHigh);
//            // Print the filtered data
//            for (Map.Entry<String, List<Object>> entry : Filterdata.entrySet()) {
//                System.out.println(entry.getKey() + ":");
//                // Loop through each data item in the list and print its contents
//                List<Object> dataList = entry.getValue();
//                for (Object data : dataList) {
//                    if (data instanceof Map) {
//                        Map<String, Object> dataMap = (Map<String, Object>) data;
//                        for (Map.Entry<String, Object> dataEntry : dataMap.entrySet()) {
//                            System.out.println("  " + dataEntry.getKey() + ": " + dataEntry.getValue());
//                        }
//                    }
//                }
//            }
//            //VariableSelection.VariableSelecter(Filterdata);
//            // Create a new varibleframe and tranfer the selected data
////            VariableFrame variableFrame = new VariableFrame(Filterdata);
////            variableFrame.setVisible(true);
////            dispose();
//
//            //System.out.println(Filterdata);
//            //VariableSelect.printData(Filterdata);
//            //VariableSelect.VariableSelecter(Filterdata);
//        }
    }//GEN-LAST:event_SelectFilterActionPerformed

    private void RQlowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RQlowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RQlowActionPerformed

    private void FiO2valActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiO2valActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiO2valActionPerformed

  
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
            java.util.logging.Logger.getLogger(Visualise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visualise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visualise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visualise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visualise().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AllData;
    private javax.swing.JCheckBox Burn;
    private javax.swing.JCheckBox Cardiac;
    private javax.swing.JCheckBox FiO2;
    private javax.swing.JTextField FiO2val;
    private javax.swing.JCheckBox IM;
    private javax.swing.JCheckBox NoFilter;
    private javax.swing.JCheckBox PEEP;
    private javax.swing.JTextField PEEPval;
    private javax.swing.JCheckBox RQ;
    private javax.swing.JTextField RQhigh;
    private javax.swing.JTextField RQlow;
    private javax.swing.JButton SelectData;
    private javax.swing.JButton SelectFilter;
    private javax.swing.JCheckBox Sepsis;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
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
    // End of variables declaration//GEN-END:variables
}
