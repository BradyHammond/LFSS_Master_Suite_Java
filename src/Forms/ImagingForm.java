/*================================================
                  Imaging Form
==================================================
// Created: 08/24/16
// Created by: Brady Hammond
// Last edited:
// Last edited by:
================================================*/

// Specify the correct package
package Forms;

// Import needed libraries
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Create the ImagingForm class
public class ImagingForm extends javax.swing.JFrame 
{
    // Create the imagingForm constructor
    public ImagingForm(MainForm form, WebDriver passed_browser) 
    {
        // Initialize swing componenets
        initComponents();
        
        // Save data members
        main_form = form;
        browser = passed_browser;
        
        // Set the default button
        this.getRootPane().setDefaultButton(submit_button);
        
        // Resize the form and remove student file tab
        this.setSize(620, 250);
        tabs_container.remove(student_file_tab);
        
        // Create the pdf viewer
        controller = new SwingController();
        SwingViewBuilder builder = new SwingViewBuilder(controller);
        JPanel viewer_component_panel = builder.buildViewerPanel();
        pdf_viewer.add(viewer_component_panel, BorderLayout.CENTER);
    }

    // Suppress compile warning
    @SuppressWarnings("unchecked")
                         
    private void initComponents() 
    {
        java.awt.GridBagConstraints gridBagConstraints;

        file_chooser = new javax.swing.JFileChooser();
        imaging_form_title_label = new javax.swing.JLabel();
        serparator_I = new javax.swing.JSeparator();
        tabs_container = new javax.swing.JTabbedPane();
        find_student_tab = new javax.swing.JPanel();
        find_student_label = new javax.swing.JLabel();
        find_student_input = new javax.swing.JTextField();
        cancel_button_I = new javax.swing.JButton();
        submit_button = new javax.swing.JButton();
        student_file_tab = new javax.swing.JPanel();
        student_folder_label = new javax.swing.JLabel();
        pdf_viewer = new javax.swing.JPanel();
        keep_button = new javax.swing.JButton();
        cancel_button_II = new javax.swing.JButton();
        file_number_label = new javax.swing.JLabel();
        filename_label = new javax.swing.JLabel();
        delete_button = new javax.swing.JButton();
        merge_pdfs_tab = new javax.swing.JPanel();
        merge_button = new javax.swing.JButton();
        cancel_button_III = new javax.swing.JButton();

        file_chooser.setCurrentDirectory(new java.io.File("M:\\To Be Imaged"));
        file_chooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 220));

        imaging_form_title_label.setFont(new java.awt.Font("Verdana", 0, 20));
        imaging_form_title_label.setForeground(new java.awt.Color(255, 255, 255));
        imaging_form_title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imaging_form_title_label.setText("IMAGING FORM");
        imaging_form_title_label.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        imaging_form_title_label.setMinimumSize(new java.awt.Dimension(600, 26));
        imaging_form_title_label.setPreferredSize(new java.awt.Dimension(600, 26));

        serparator_I.setMinimumSize(new java.awt.Dimension(600, 0));
        serparator_I.setPreferredSize(new java.awt.Dimension(600, 0));

        tabs_container.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabs_container.setFont(new java.awt.Font("Verdana", 1, 12));
        tabs_container.setMinimumSize(new java.awt.Dimension(600, 159));

        find_student_tab.setFont(new java.awt.Font("Verdana", 0, 12));
        find_student_tab.setMinimumSize(new java.awt.Dimension(600, 125));
        find_student_tab.setPreferredSize(new java.awt.Dimension(600, 125));
        find_student_tab.setLayout(new java.awt.GridBagLayout());

        find_student_label.setFont(new java.awt.Font("Verdana", 1, 12));
        find_student_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        find_student_label.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 298;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 106, 0, 106);
        find_student_tab.add(find_student_label, gridBagConstraints);

        find_student_input.setFont(new java.awt.Font("Verdana", 0, 12));
        find_student_input.setMinimumSize(new java.awt.Dimension(14, 25));
        find_student_input.setPreferredSize(new java.awt.Dimension(14, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 360;
        gridBagConstraints.ipady = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 106, 0, 106);
        find_student_tab.add(find_student_input, gridBagConstraints);

        cancel_button_I.setFont(new java.awt.Font("Verdana", 1, 12));
        cancel_button_I.setText("Cancel");
        cancel_button_I.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                cancel_button_IActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 14, 0);
        find_student_tab.add(cancel_button_I, gridBagConstraints);

        submit_button.setFont(new java.awt.Font("Verdana", 1, 12));
        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                submit_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 191, 14, 0);
        find_student_tab.add(submit_button, gridBagConstraints);

        tabs_container.addTab("Find Student", find_student_tab);

        student_file_tab.setFont(new java.awt.Font("Verdana", 0, 12));

        student_folder_label.setFont(new java.awt.Font("Verdana", 1, 12));
        student_folder_label.setText("Student Folder: ");

        pdf_viewer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pdf_viewer.setMinimumSize(new java.awt.Dimension(574, 30));
        pdf_viewer.setPreferredSize(new java.awt.Dimension(574, 30));
        pdf_viewer.setLayout(new java.awt.BorderLayout());

        keep_button.setFont(new java.awt.Font("Verdana", 1, 12));
        keep_button.setText("Keep");
        keep_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                keep_buttonActionPerformed(evt);
            }
        });

        cancel_button_II.setFont(new java.awt.Font("Verdana", 1, 12));
        cancel_button_II.setText("Cancel");
        cancel_button_II.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                cancel_button_IIActionPerformed(evt);
            }
        });

        file_number_label.setFont(new java.awt.Font("Verdana", 1, 12));
        file_number_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        file_number_label.setText("File: # of #");

        filename_label.setFont(new java.awt.Font("Verdana", 1, 12));
        filename_label.setText("Filename: ");

        delete_button.setFont(new java.awt.Font("Verdana", 1, 12));
        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                delete_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout student_file_tabLayout = new javax.swing.GroupLayout(student_file_tab);
        student_file_tab.setLayout(student_file_tabLayout);
        student_file_tabLayout.setHorizontalGroup(
            student_file_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, student_file_tabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keep_button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel_button_II, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
            .addGroup(student_file_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(student_file_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(student_folder_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(student_file_tabLayout.createSequentialGroup()
                        .addGroup(student_file_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(student_file_tabLayout.createSequentialGroup()
                                .addComponent(filename_label, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(file_number_label, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pdf_viewer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        student_file_tabLayout.setVerticalGroup(
            student_file_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_file_tabLayout.createSequentialGroup()
                .addComponent(student_folder_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(student_file_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(file_number_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filename_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pdf_viewer, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(student_file_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keep_button)
                    .addComponent(cancel_button_II)
                    .addComponent(delete_button))
                .addContainerGap())
        );

        tabs_container.addTab("Student File", student_file_tab);

        merge_pdfs_tab.setFont(new java.awt.Font("Verdana", 0, 12));
        merge_pdfs_tab.setLayout(new java.awt.GridBagLayout());

        merge_button.setFont(new java.awt.Font("Verdana", 1, 12));
        merge_button.setText("Merge PDF's");
        merge_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                merge_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 233, 0, 233);
        merge_pdfs_tab.add(merge_button, gridBagConstraints);

        cancel_button_III.setFont(new java.awt.Font("Verdana", 1, 12));
        cancel_button_III.setText("Cancel");
        cancel_button_III.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                cancel_button_IIIActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 233, 25, 233);
        merge_pdfs_tab.add(cancel_button_III, gridBagConstraints);

        tabs_container.addTab("Merge PDF's", merge_pdfs_tab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imaging_form_title_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(serparator_I, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tabs_container, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imaging_form_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(serparator_I, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(tabs_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                      

    // Define the advance current file function
    private void advanceCurrentFile()
    {
        // Check if for the last file
        if(current_file < file_list.size() - 1)
        {
            // If more files remain increment the current file
            current_file ++;
            
            // Close the previous file and open the new one
            try
            {
                input_stream.close();
                input_stream = new FileInputStream(directory_path + "\\" + file_list.get(current_file));
            }
            catch(Exception e)
            {
                // Throw an exception
                throw new RuntimeException(e);
            }
            
            // Load the new file to the window
            controller.openDocument(input_stream, "", "");
            
            // Reset the appropriate labels
            filename_label.setText("Filename: " + file_list.get(current_file));
            file_number_label.setText("File: " + (String.valueOf(current_file + 1)) + " of " + (String.valueOf(file_list.size())));
        }
        
        else
        {
            // Output a instructions and a file chooser window
            JOptionPane.showMessageDialog(null, "Please select a folder to move these files.", "File Destination", JOptionPane.INFORMATION_MESSAGE);
            int return_value = file_chooser.showOpenDialog(this);
            
            // Check for a chosen file
            if (return_value == JFileChooser.APPROVE_OPTION)
            {
                // Attempt to close the last pdf
                try
                {
                    input_stream.close();
                }
                catch(Exception e)
                {
                    // Throw an exception
                    throw new RuntimeException(e);
                }
                
                // Get the selected file
                File new_folder = file_chooser.getSelectedFile();
                
                // Get the student's folder
                File student_folder = new File(directory_path);
                
                // Get the files from the student's folder
                getStudentFiles(student_folder);
                
                // Initialize the name count
                int file_name_count = 1;
                
                // Loop through the files from the student folder
                for (String file: file_list)
                {
                    // Get the file's absolute path
                    File rename_file = new File(directory_path + "\\" + file);
                    
                    // Attempt to move the file to the selected folder
                    try
                    {
                        rename_file.renameTo(new File(new_folder + "\\" + student_name + " " + String.valueOf(file_name_count) + ".pdf"));
                    }
                    
                    catch (Exception e)
                    {
                        // Throw an exception
                        throw new RuntimeException(e);
                    }
                 
                    // Increment the file count
                    file_name_count++;
                }
                
                // Attempt to delete the student file
                try
                {
                    student_folder.delete();
                }
                
                catch (Exception e)
                {
                    // Throw an exception
                    throw new RuntimeException(e);
                }
            }

            // Resize the form
            this.setSize(620, 250);
        
            // Restore the form
            tabs_container.remove(student_file_tab);
            tabs_container.addTab("Find Student", find_student_tab);
            tabs_container.addTab("Merge PDF's", merge_pdfs_tab);
            find_student_input.setText("");
            this.getRootPane().setDefaultButton(submit_button);
        }
    }
    
    private void cancel_button_IActionPerformed(java.awt.event.ActionEvent evt) 
    {                                                
        // Close the helper form
        this.dispose();
        
        // Restore the main form
        main_form.setVisible(true);
    }                                               

    private void cancel_button_IIActionPerformed(java.awt.event.ActionEvent evt) 
    {                                                 
        // Resize the form
        this.setSize(620, 250);
        
        // Restore the form
        tabs_container.remove(student_file_tab);
        tabs_container.addTab("Find Student", find_student_tab);
        tabs_container.addTab("Merge PDF's", merge_pdfs_tab);
        find_student_input.setText("");
        this.getRootPane().setDefaultButton(submit_button);
    }                                                

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                              
        // Set the implicit wait time
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                
        // Navigate to persum
        browser.get("https://y.byu.edu/ry/ae/prod/person/cgi/personSummary.cgi");
        
        // Input the student id in the search box
        WebElement student_id_input = browser.findElement(By.name("NAVpattern"));
        student_id_input.sendKeys(find_student_input.getText());
        
        // Click the go button
        WebElement go_button = browser.findElement(By.xpath("//a[@href='javascript:NAVpreXref()']"));
        go_button.click();
        
        // Save all phantomjs windows
        Set<String> handles = browser.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        
        // Check if there was a pop up window
        if(handles.size() > 1)
        {
            // Save the main and pop up windows
            String main_window = iterator.next();
            String pop_up_window = iterator.next();
            
            // Close the pop up window
            browser.switchTo().window(pop_up_window);
            browser.close();
            
            // Switch back to the main window
            browser.switchTo().window(main_window);
            
            // Output an error message
            JOptionPane.showMessageDialog(null, "The ID you've entered is incorrect. Please check it and try again.", "Incorrect ID", JOptionPane.ERROR_MESSAGE);
            
            // Exit the function
            return;
        }
        
        else
        {
            // Get the student's name
            WebElement student_name_element = browser.findElement(By.name("restore_name"));
            student_name = student_name_element.getAttribute("value");
            
            // Get the student's id_number and name
            WebElement student_id_element = browser.findElement(By.name("restore_byu_id"));
            String student_id = student_id_element.getAttribute("value");
            
            // Format the id number
            student_id = student_id.replaceAll("\\D", "");
            
            // Get the digital copies folder
            File student_digital_copies = new File("M:\\Student Digital Copies");
            
            // Initialize the target folder variable
            File target_folder = null;
            
            // Get all of the files in student digital copies
            File[] digital_copies = student_digital_copies.listFiles();
            
            // Loop through each file
            for(File file: digital_copies)
            {
                // Check if the student folder can be located
                if(file.getName().indexOf(student_id) >= 0)
                {
                    // If so, save the folder and exit the loop
                    target_folder = file;
                    break;
                }
            }
            
            // Check if the student's folder was found
            if(target_folder == null)
            {
                // If not output an error message and exit the program
                JOptionPane.showMessageDialog(null, "This student does not appear to have a folder. Please make sure that you have used the correct student ID and try again.", "Missing Folder", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else
            {
                // Get the files from the target folder
                getStudentFiles(target_folder);
                    
                // Check if there are any files to be scanned
                if(file_list.size() > 0 )
                { 
                    // Initialize the needed variables
                    current_file = 0;
                    student_folder_label.setText("Student Folder: " + target_folder.getAbsolutePath());
                    directory_path = target_folder.getAbsolutePath();
                    filename_label.setText("Filename: " + file_list.get(current_file));
                    file_number_label.setText("File: 1 of " + (String.valueOf(file_list.size())));

                    // Adjust the appropriate tabs
                    tabs_container.addTab("Student File Tab", student_file_tab);
                    tabs_container.remove(find_student_tab);
                    tabs_container.remove(merge_pdfs_tab);

                    // Reorganize the form
                    this.setSize(620,750);
                    this.repaint();
                    tabs_container.setPreferredSize(new Dimension(588, 637));
                    tabs_container.revalidate();
                    tabs_container.repaint();
                    pdf_viewer.setPreferredSize(new Dimension(565, 492));
                    pdf_viewer.revalidate();
                    pdf_viewer.repaint();
                
                    // Attempt to open the first file
                    try
                    {
                        input_stream = new FileInputStream(directory_path + "\\" + file_list.get(current_file));
                    }
            
                    catch(Exception e)
                    {
                        // Throw an exception
                        throw new RuntimeException(e);
                    }
            
                    // Show the file in the pdf_viewer
                    controller.openDocument(input_stream, "", "");
                }
                
                else
                {
                    // If not output an error message and exit the program
                    JOptionPane.showMessageDialog(null, "The folder you've selected is already empty.", "Empty Folder", JOptionPane.ERROR_MESSAGE);
                    find_student_input.setText("");
                    return;
                }
            }
        }
    }                                             

    private void cancel_button_IIIActionPerformed(java.awt.event.ActionEvent evt) 
    {                                                  
        // Close the helper form
        this.dispose();

        // Restore the main form
        main_form.setVisible(true);
    }                                                 

    private void keep_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                            
        // Advance the file
        advanceCurrentFile();
    }                                           

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                              
        // Attempt to close the pdf
        try 
        {
            input_stream.close();
        } 
        
        catch(Exception e)
        {
            // Throw an exception
            throw new RuntimeException(e);
        }
        
        // Get the file to be deleted
        File delete_file = new File(directory_path + "\\" + file_list.get(current_file));
        
        // Attempt to delete the file
        try
        {
            delete_file.delete();
        }
        
        catch (Exception e)
        {
            // Throw an exception
            throw new RuntimeException(e);
        }
        
        // Advance the file
        advanceCurrentFile();
    }                                             

    private void merge_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                             
        // Output instructions and a file chooser
        JOptionPane.showMessageDialog(null, "Please select a folder to merge.", "Merge Folder", JOptionPane.INFORMATION_MESSAGE);
        int return_value = file_chooser.showOpenDialog(this);
        
        // Check for a selected folder
        if (return_value == JFileChooser.APPROVE_OPTION)
        {
            // Save the folder and it's absolute path
            File folder = file_chooser.getSelectedFile();
            directory_path = folder.getAbsolutePath();
            
            // Get the files in that folder
            getMergeFiles(folder);
            
            // Check if there are less than 100 files in the folder
            if (file_list.size() <= 100 && file_list.size() > 0)
            {
                // Create a pdf merger
                PDFMergerUtility utility = new PDFMergerUtility();
                
                // Loop through each file
                for(String file: file_list)
                {
                    // Attempt to add the file to the merger
                    try
                    {
                        utility.addSource(file);
                    }
                    
                    catch(Exception e)
                    {
                        // Throw an exception
                        throw new RuntimeException(e);
                    }
                }
                
                // Set the merge file name
                utility.setDestinationFileName(directory_path + "\\Merge.pdf");
                
                // Attempt to merge the documents
                try 
                {
                    utility.mergeDocuments();
                } 
                
                catch (Exception e) 
                {
                    // Throw an exception
                    throw new RuntimeException(e);
                }
                
                // Get all of the files in the folder
                getMergeFiles(folder);
                
                // Loop through each file
                for(String file: file_list)
                {
                    // Check if the file is a merge file
                    if(!(file.contains("Merge")))
                    {
                        // If not, delete the file
                        File delete_file = new File(file);
                        delete_file.delete();
                    }
                }
                
                // Output a completion message
                JOptionPane.showMessageDialog(null, "The files in the selected folder have been successfully merged.", "Process Complete", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // Check if the folder is empty
            else if(file_list.size() <= 0)
            {
                // If so, output an error message
                JOptionPane.showMessageDialog(null, "There are currently no files to merge in this folder.", "Empty File", JOptionPane.ERROR_MESSAGE);
            }
            
            else
            {
                // Get the sets of 100 to merge
                int merge_sets = (int) Math.ceil(file_list.size() / 100.0);
                
                // Loop through the sets of 100
                for(int i = 0;  i < merge_sets; i++)
                {
                    // Check for the first 100
                    if(i == 0)
                    {
                        // Create a new pdf merger
                        PDFMergerUtility utility = new PDFMergerUtility();
                        
                        // Loop through the first 100 files
                        for(int j = 0; j < 100; j++)
                        {
                            // Attempt to add the file to the merger
                            try
                            {
                                utility.addSource(file_list.get(j));
                            }

                            catch(Exception e)
                            {
                                // Throw an exception
                                throw new RuntimeException(e);
                            }
                        }

                        // Set the merge file name
                        utility.setDestinationFileName(directory_path + "\\Merge_" + String.valueOf(i+1) + ".pdf");
                        
                        // Attempt to merge the documents
                        try 
                        {
                            utility.mergeDocuments();
                        } 
                        
                        catch (Exception e) 
                        {
                            // Throw an exception
                            throw new RuntimeException(e);
                        }
                    }
                    
                    // Check for the last set of 100
                    else if(i == (merge_sets - 1))
                    {
                        // Create a new pdf merger 
                        PDFMergerUtility utility = new PDFMergerUtility();
                        
                        // Loop through the remaining folder
                        for(int j = (i* 100); j < file_list.size(); j++)
                        {
                          // Attempt to add the file to the merger
                          try
                            {
                                utility.addSource(file_list.get(j));
                            }

                            catch(Exception e)
                            {
                                // Throw an exception
                                throw new RuntimeException(e);
                            }  
                        }
                        
                        // Set the merge file name
                        utility.setDestinationFileName(directory_path + "\\Merge_" + String.valueOf(i+1) + ".pdf");
                        
                        // Atempt to mege the documents
                        try 
                        {
                            utility.mergeDocuments();
                        } 
                        
                        catch (Exception e) 
                        {
                            // Throw an exception
                            throw new RuntimeException(e);
                        }
                    }
                    
                    else
                    {
                        // Create a new pdf merger 
                        PDFMergerUtility utility = new PDFMergerUtility();
                        
                        // Loop through the correct set of 100
                        for(int j = (i* 100); j < ((i*100) + 100); j++)
                        {
                            // Attempt to add the files to the merger
                            try
                            {
                                utility.addSource(file_list.get(j));
                            }

                            catch(Exception e)
                            {
                                // Throw an exception
                                throw new RuntimeException(e);
                            }
                        }
                        
                        // Set the merge file name
                        utility.setDestinationFileName(directory_path + "\\Merge_" + String.valueOf(i+1) + ".pdf");
                        
                        // Attempt to merge the documents
                        try 
                        {
                            utility.mergeDocuments();
                        } 
                        
                        catch (Exception e) 
                        {
                            // Throw an exception
                            throw new RuntimeException(e);
                        }
                    }
                }
                
                // Get all of the files in the folder
                getMergeFiles(folder);
                
                // Loop through each file
                for(String file: file_list)
                {
                    // Check if the file is a merge file
                    if(!(file.contains("Merge")))
                    {
                        // If not delete the file
                        File delete_file = new File(file);
                        delete_file.delete();
                    }
                }
                
                // Output a completion message
                JOptionPane.showMessageDialog(null, "The files in the selected folder have been successfully merged.", "Process Complete", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }                                            
    
    // Define the get student files function
    private static void getStudentFiles(final File folder)
    {
        // Clear the file list
        file_list.clear();
        
        // Loop through all the files in the given directory
        for(final File file : folder.listFiles())
        {
            // Check if current object is a directory in the given directory
            if(file.isDirectory())
            {
                // Get the scanned files from the subdirectory
                getStudentFiles(file);
            }

            // Check if the file is a pdf
            else if(file.getName().endsWith(".pdf"))
            {
                // Add the file to the file list
                file_list.add(file.getName());
            }
            
            else
            {}
        }
    }
    
    // Define the get merge files function
    private static void getMergeFiles(final File folder)
    {
        // Clear the file list
        file_list.clear();
        
        // Loop through all the files in the given directory
        for(final File file : folder.listFiles())
        {
            // Check if current object is a directory in the given directory
            if(file.isDirectory())
            {
                // Get the scanned files from the subdirectory
                getMergeFiles(file);
            }

            // Check if the file is a pdf
            else if(file.getName().endsWith(".pdf"))
            {
                // Add the file to the file list
                file_list.add(file.getAbsolutePath());
            }
            
            else
            {}
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
    private WebDriver browser;
    private static ArrayList<String> file_list = new ArrayList<String>();
    private SwingController controller;
    private InputStream input_stream;
    private Integer current_file;
    private String directory_path;
    private String student_name;
    // End of variables declaration
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton cancel_button_I;
    private javax.swing.JButton cancel_button_II;
    private javax.swing.JButton cancel_button_III;
    private javax.swing.JButton delete_button;
    private javax.swing.JFileChooser file_chooser;
    private javax.swing.JLabel file_number_label;
    private javax.swing.JLabel filename_label;
    private javax.swing.JTextField find_student_input;
    private javax.swing.JLabel find_student_label;
    private javax.swing.JPanel find_student_tab;
    private javax.swing.JLabel imaging_form_title_label;
    private javax.swing.JButton keep_button;
    private javax.swing.JButton merge_button;
    private javax.swing.JPanel merge_pdfs_tab;
    private javax.swing.JPanel pdf_viewer;
    private javax.swing.JSeparator serparator_I;
    private javax.swing.JPanel student_file_tab;
    private javax.swing.JLabel student_folder_label;
    private javax.swing.JButton submit_button;
    private javax.swing.JTabbedPane tabs_container;
    // End of variables declaration                   
}
