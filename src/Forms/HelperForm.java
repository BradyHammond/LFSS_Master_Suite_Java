/*================================================
                   Helper Form
==================================================
// Created: 08/24/16
// Created by: Brady Hammond
// Last edited:
// Last edited by:
================================================*/

// Specify the correct package
package Forms;

// Import needed libraries
import javax.swing.JOptionPane;

// Create the HelperForm class
public class HelperForm extends javax.swing.JFrame 
{   
    // Create the HelperForm constructor
    public HelperForm(MainForm form) 
    {
        // Define the main form and initialize components
        main_form = form;
        initComponents();
    }

    // Suppress compile warnings
    @SuppressWarnings("unchecked")
    
    private void initComponents() 
    {
        helper_form_title_label = new javax.swing.JLabel();
        serparator_I = new javax.swing.JSeparator();
        button_I = new javax.swing.JButton();
        button_II = new javax.swing.JButton();
        button_III = new javax.swing.JButton();
        button_IV = new javax.swing.JButton();
        button_V = new javax.swing.JButton();
        button_VI = new javax.swing.JButton();
        button_VII = new javax.swing.JButton();
        button_VIII = new javax.swing.JButton();
        button_IX = new javax.swing.JButton();
        button_X = new javax.swing.JButton();
        button_XI = new javax.swing.JButton();
        button_XII = new javax.swing.JButton();
        button_XIII = new javax.swing.JButton();
        button_XIV = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        helper_form_title_label.setFont(new java.awt.Font("Verdana", 0, 20)); 
        helper_form_title_label.setForeground(new java.awt.Color(255, 255, 255));
        helper_form_title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helper_form_title_label.setText("SCHEDULING HELPER");

        button_I.setFont(new java.awt.Font("Verdana", 0, 12));
        button_I.setText("Athletic Training");
        button_I.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_IActionPerformed(evt);
            }
        });

        button_II.setFont(new java.awt.Font("Verdana", 0, 12));
        button_II.setText("Biological Science Education");
        button_II.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_IIActionPerformed(evt);
            }
        });

        button_III.setFont(new java.awt.Font("Verdana", 0, 12));
        button_III.setText("Biology Department");
        button_III.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_IIIActionPerformed(evt);
            }
        });

        button_IV.setFont(new java.awt.Font("Verdana", 0, 12));
        button_IV.setText("Dietetics");
        button_IV.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_IVActionPerformed(evt);
            }
        });

        button_V.setFont(new java.awt.Font("Verdana", 0, 12));
        button_V.setText("Exercise Science (A - M)");
        button_V.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_VActionPerformed(evt);
            }
        });

        button_VI.setFont(new java.awt.Font("Verdana", 0, 12));
        button_VI.setText("Exercise Science (N - Z)");
        button_VI.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_VIActionPerformed(evt);
            }
        });

        button_VII.setFont(new java.awt.Font("Verdana", 0, 12));
        button_VII.setText("Exercise & Wellness");
        button_VII.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_VIIActionPerformed(evt);
            }
        });

        button_VIII.setFont(new java.awt.Font("Verdana", 0, 12));
        button_VIII.setText("Food Science");
        button_VIII.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_VIIIActionPerformed(evt);
            }
        });

        button_IX.setFont(new java.awt.Font("Verdana", 0, 12));
        button_IX.setText("Health Science Department");
        button_IX.addActionListener(new java.awt.event.ActionListener()
         {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_IXActionPerformed(evt);
            }
        });

        button_X.setFont(new java.awt.Font("Verdana", 0, 12)); 
        button_X.setText("MMBIO Department");
        button_X.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_XActionPerformed(evt);
            }
        });

        button_XI.setFont(new java.awt.Font("Verdana", 0, 12));
        button_XI.setText("Nutritional Science");
        button_XI.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
             {
                button_XIActionPerformed(evt);
            }
        });

        button_XII.setFont(new java.awt.Font("Verdana", 0, 12));
        button_XII.setText("PDBIO Department");
        button_XII.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_XIIActionPerformed(evt);
            }
        });

        button_XIII.setFont(new java.awt.Font("Verdana", 0, 12));
        button_XIII.setText("PWS Department");
        button_XIII.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_XIIIActionPerformed(evt);
            }
        });

        button_XIV.setFont(new java.awt.Font("Verdana", 0, 12)); 
        button_XIV.setText("School Health Education");
        button_XIV.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                button_XIVActionPerformed(evt);
            }
        });

        cancel_button.setFont(new java.awt.Font("Verdana", 0, 12));
        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener()
         {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                cancel_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(helper_form_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(serparator_I)
                    .addComponent(button_I, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_III, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_IV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_VIII, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_IX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_XI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_XII, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_XIV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_II, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_V, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_VI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_VII, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_XIII, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helper_form_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serparator_I, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_I)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_II)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_III)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_IV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_V)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_VI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_VII)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_VIII)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_IX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_X)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_XI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_XII)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_XIII)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_XIV)
                .addGap(18, 18, 18)
                .addComponent(cancel_button)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }

    // Define the cancel button clicked function
    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        
        // Close the helper form
        this.dispose();
        
        // Restore the main form
        main_form.setVisible(true);
    }

    // Define the numbered button click functions
    private void button_IActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            athletic_training = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            academic_improvement_plan = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_IIActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            biological_science_education = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            change_major = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_IIIActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            biology_department = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            general_education_questions = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_IVActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            dietetics = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            graduation_clearance = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_VActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            exercise_science_I = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            initial_class_plan = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_VIActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            exercise_science_II = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            internship_exit_interview = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_VIIActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            exercise_wellness = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            internship_orientation = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_VIIIActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            food_science = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            major_advising = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_IXActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            health_science_department = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            major_exploration = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_XActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            mmbio_department = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            one_semester_planning = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_XIActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            nutritional_science = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            over_hours_change_major = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_XIIActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            pdbio_department = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            revise_class_plan = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_XIIIActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(part_I_complete == false)
        {
            // Set the appropriate booleans to true
            pws_department = true;
            part_I_complete = true;
            
            // Switch the buttons out
            switchButtons();
        }
        
        else
        {
            // Set the appropriate boolean to true
            substitutions = true;
            
            // Evaluate the query
            evaluateQuery();
            
            // Close the helper form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    private void button_XIVActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // Set the appropriate booleans to true
        school_health_education = true;
        part_I_complete = true;
        
        // Switch the buttons out
        switchButtons();
    }
   
    // Define the switch buttons function
    private void switchButtons()
    {
        // Remove the last button
        button_XIV.setVisible(false);
        
        // Change the labels for the remaining buttons
        button_I.setText("Academic Improvement Plan");
        button_II.setText("Change of Major");
        button_III.setText("General Education Questions");
        button_IV.setText("Graduation Clearance");
        button_V.setText("Initial Class Plan");
        button_VI.setText("Internship Exit Interview");
        button_VII.setText("Internship Orientation");
        button_VIII.setText("Major Advising");
        button_IX.setText("Major Exploration");
        button_X.setText("One Semester Planning");
        button_XI.setText("Over Hours Change of Major");
        button_XII.setText("Revise Class Plan");
        button_XIII.setText("Substitutions");
    }
    
    // Define the evaluate
    private void evaluateQuery()
    {
        // Check first click data
        if(athletic_training == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // Check first click data
        else if(biological_science_education == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }   
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // Check first click data
        else if(biology_department == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // Check first click data
        else if(dietetics == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }        
        }
        
        // Check first click data
        else if(exercise_science_I == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }        
        }
        
        // Check first click data
        else if(exercise_science_II == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }        
        }
        
        // Check first click data
        else if(exercise_wellness == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }        
        }
        
        // Check first click data
        else if(food_science == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }        
        }
        
        // Check first click data
        else if(health_science_department == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }        
        }
        
        // Check first click data
        else if(mmbio_department == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }       
        }
        
        // Check first click data
        else if(nutritional_science == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }        
        }
        
        // Check first click data
        else if(pdbio_department == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }        
        }
        
        // Check first click data
        else if(pws_department == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }        
        }
        
        // Check first click data
        else if(school_health_education == true)
        {
            // Check second click data
            if(academic_improvement_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "Students CANNOT change their major to School Health Education", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(general_education_questions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(graduation_clearance == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(initial_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_exit_interview == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(internship_orientation == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_advising == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(major_exploration == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "Students CANNOT explore School Health Education", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(one_semester_planning == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(over_hours_change_major == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(revise_class_plan == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check second click data
            else if(substitutions == true)
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "XXXXX", "Advisor", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if there was an error with the second click data
            else
            {
                // Output the appropriate message
                JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
            }        
        }
        
        // Check if there was an error with the first click data
        else
        {
            // Output the appropriate message
            JOptionPane.showMessageDialog(null, "There appears to be a programming error. Please let the current developer know.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Define the main function
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
            }
        });
    }
    
    // Variables declaration - data members
    private MainForm main_form;
    
    private boolean academic_improvement_plan = false;
    private boolean change_major = false;
    private boolean general_education_questions = false;
    private boolean graduation_clearance = false;
    private boolean initial_class_plan = false;
    private boolean internship_exit_interview = false;
    private boolean internship_orientation = false;
    private boolean major_advising = false;
    private boolean major_exploration = false;
    private boolean one_semester_planning = false;
    private boolean over_hours_change_major = false;
    private boolean revise_class_plan = false;
    private boolean substitutions = false;
    
    private boolean athletic_training = false;
    private boolean biological_science_education = false;
    private boolean biology_department = false;
    private boolean dietetics = false;
    private boolean exercise_science_I = false;
    private boolean exercise_science_II = false;
    private boolean exercise_wellness = false;
    private boolean food_science = false;
    private boolean health_science_department = false;
    private boolean mmbio_department = false;
    private boolean nutritional_science = false;
    private boolean pdbio_department = false;
    private boolean pws_department = false;
    private boolean school_health_education = false;
    
    private boolean part_I_complete = false;
    // End of variables declaration

    // Variables declaration - swing variables
    private javax.swing.JButton button_I;
    private javax.swing.JButton button_II;
    private javax.swing.JButton button_III;
    private javax.swing.JButton button_IV;
    private javax.swing.JButton button_IX;
    private javax.swing.JButton button_V;
    private javax.swing.JButton button_VI;
    private javax.swing.JButton button_VII;
    private javax.swing.JButton button_VIII;
    private javax.swing.JButton button_X;
    private javax.swing.JButton button_XI;
    private javax.swing.JButton button_XII;
    private javax.swing.JButton button_XIII;
    private javax.swing.JButton button_XIV;
    private javax.swing.JButton cancel_button;
    private javax.swing.JLabel helper_form_title_label;
    private javax.swing.JSeparator serparator_I;
    // End of variables declaration
}
