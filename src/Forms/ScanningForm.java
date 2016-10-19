/*================================================
                  Scanning Form
==================================================
// Created: 08/24/16
// Created by: Brady Hammond
// Last edited:
// Last edited by:
================================================*/

// Specify the correct package
package Forms;

// Import needed libraries
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Create the ScanningForm class
public class ScanningForm extends javax.swing.JFrame 
{
    
    // Create the ScanningForm constructor
    public ScanningForm(WebDriver passed_browser, MainForm form) 
    {
        // Save the variables passed into the constructor
        main_form = form;
        browser = passed_browser;
        
        // Set the file number
        current_file = 0;
        
        // Initialize components
        initComponents();
        
        // Set the default button
        this.getRootPane().setDefaultButton(submit_button);
        
        // Get the files in the default folder
        File file = new File(directory_path);
        getScannedFiles(file);
        
        // Check if there were files in the default folder
        if(file_list.size() > 0)
        {
            // Set the number and filename lables
            number_I_label.setText("1");
            number_II_label.setText(String.valueOf(file_list.size()));
            filename_label.setText(file_list.get(current_file));
        }
        
        else
        {
            // Set the number lables
            number_I_label.setText("0");
            number_II_label.setText("0");
            filename_label.setText("There are currently no files to be scanned");
            
            // Output an instruction message
            JOptionPane.showMessageDialog(null, "The default scanning folder is empty. Please select a different folder to scan from or exit the program", "Default Folder Empty", JOptionPane.INFORMATION_MESSAGE);
        }
        
        // Create the pdf viewer
        controller = new SwingController();
        SwingViewBuilder builder = new SwingViewBuilder(controller);
        JPanel viewer_component_panel = builder.buildViewerPanel();
        pdf_viewer.add(viewer_component_panel, BorderLayout.CENTER);
        
        // Check if there are any files to be scanned
        if(file_list.size() > 0 )
        { 
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
    }
    
    // Define the get scanned files function
    private static void getScannedFiles(final File folder)
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
                getScannedFiles(file);
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
    
    // Define the is numeric function
    public boolean isNumeric(String string) 
    {  
        // Check if the string is numeric
        return string.matches("[-+]?\\d*\\.?\\d+");  
    }
    
    // Define the search id number function
    private void searchIDNumber(String student_id)
    {
        // Set the implicit wait time
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        // Navigate to persum
        browser.get("https://y.byu.edu/ry/ae/prod/person/cgi/personSummary.cgi");
        
        // Input the student id in the search box
        WebElement student_id_input = browser.findElement(By.name("NAVpattern"));
        student_id_input.sendKeys(student_id);

        // Click the go button
        WebElement page_go_button = browser.findElement(By.xpath("//a[@href='javascript:NAVpreXref()']"));
        page_go_button.click();
        
        // Save all phantomjs windows
        Set<String> handles = browser.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        
        // Check if there was a pop up window
        if (handles.size() > 1)
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
            String student_name = student_name_element.getAttribute("value");
            
            // Get the student's id number
            WebElement student_id_element = browser.findElement(By.name("restore_byu_id"));
            student_id = student_id_element.getAttribute("value");
            
            // Format the id number
            student_id = student_id.replaceAll("\\D", "");
            
            // Get the file name
            String folder_name = student_name + " " + student_id;
            
            // Get the digital copies folder
            File student_digital_copies = new File("M:\\Student Digital Copies");
            
            // Initialize the target folder variable
            File target_folder = null;
            
            // Get all of the files in student digital copies
            File[] digital_copies = student_digital_copies.listFiles();
            
            // Loop through each file
            for(File file: digital_copies)
            {
                // Check if the student already has a folder
                if(file.getName().equals(folder_name))
                {
                    // If so, save the folder and exit the loop
                    target_folder = file;
                    break;
                }
            }
            
            // Check if the studen't fodler was found
            if(target_folder == null)
            {
                // If not, ask to make a new folder
                int response = JOptionPane.showConfirmDialog(null, student_name + " does not currently have a folder. Would you like to make one now?", "Make Folder", JOptionPane.YES_NO_OPTION);
               
                // Check if the user chose yes
                if(response == JOptionPane.YES_OPTION)
                {
                    // If so, make a new folder for them
                    File new_folder = new File(student_digital_copies.getAbsolutePath() + "\\" + folder_name);
                    new_folder.mkdir();
                    
                    // Get the scanning folder and the new folder
                    File source = new File(location_label.getText() + "\\" + file_list.get(current_file));
                    File destination = new File(new_folder + "\\" + file_option_box.getSelectedItem().toString() + " 1.pdf");
                    
                    // Copy the file from the old folder to the new one
                    try 
                    {
                        Files.copy(source, destination);
                    }
                    
                    catch (IOException e) 
                    {
                        // Throw an exception
                        throw new RuntimeException(e);
                    }
                }
                
                else
                {
                    return;
                }
            }
            
            else
            {
                // Get the scanning file
                File source = new File(location_label.getText() + "\\" + file_list.get(current_file));
                
                // Set the file number
                Integer file_number = 1;
                
                // Initialize the destination folder variable
                File destination;
                
                do
                {
                    // Get the destination folder
                    destination = new File(target_folder + "\\" + file_option_box.getSelectedItem().toString() + " " + file_number + ".pdf");
                    file_number ++;
                } 
                while(destination.exists());
                
                // Copy the file from the old folder to the new one
                try 
                {
                    Files.copy(source, destination);
                }

                catch (IOException e) 
                {
                    // Throw an exception
                    throw new RuntimeException(e);
                }
            }
        
            // Get the next file
            advanceCurrentFile();
        }
    }
    
    // Define the advance current file function
    private void advanceCurrentFile()
    {
        // Check if for the last file
        if(current_file < Integer.valueOf(number_II_label.getText()) - 1)
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
            filename_label.setText(file_list.get(current_file));
            number_I_label.setText(String.valueOf(current_file + 1));
            id_input.setText("");
            file_option_box.setSelectedIndex(0);
        }
        
        else
        {
            // Ask if the user wants to clear the folder they scanned from
            int response = JOptionPane.showConfirmDialog(null, "The scanning process is now complete. Would you like to clear the scanning folder?", "Clear Folder", JOptionPane.YES_NO_OPTION);
            
            // Check if they said yes
            if(response == JOptionPane.YES_OPTION)
            {                  
                // If so get the scanning folder
                File delete_folder = new File(location_label.getText());
                try 
                {
                    // Close the last opened file
                    input_stream.close();
                    
                    // Clear the scanning folder
                    FileUtils.cleanDirectory(delete_folder);
                } 
                
                catch (IOException e) 
                {
                    // Throw an exception
                    throw new RuntimeException(e);
                }

            }
            
            else
            {
                return;
            }
            
            // Reset the directory path
            directory_path = "M:\\To_Be_Scanned\\";
            
            // Clear the file list
            file_list.clear();
                 
            // Close the scanning form
            this.dispose();
            
            // Restore the main form
            main_form.setVisible(true);
        }
    }

    // Suppress compile warnings
    @SuppressWarnings("unchecked")
                          
    private void initComponents() 
    {
        java.awt.GridBagConstraints gridBagConstraints;

        file_chooser = new javax.swing.JFileChooser();
        pdf_viewer = new javax.swing.JPanel();
        submit_button = new javax.swing.JButton();
        skip_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        helper_form_title_label = new javax.swing.JLabel();
        serparator_I = new javax.swing.JSeparator();
        options_panel = new javax.swing.JPanel();
        id_label = new javax.swing.JLabel();
        scanning_from_label = new javax.swing.JLabel();
        id_input = new javax.swing.JTextField();
        processing_label = new javax.swing.JLabel();
        filename_label = new javax.swing.JLabel();
        number_I_label = new javax.swing.JLabel();
        of_label = new javax.swing.JLabel();
        number_II_label = new javax.swing.JLabel();
        file_type_label = new javax.swing.JLabel();
        location_label = new javax.swing.JLabel();
        file_chooser_button = new javax.swing.JButton();
        file_option_box = new javax.swing.JComboBox<>();

        file_chooser.setCurrentDirectory(new java.io.File("M:\\To_Be_Scanned"));
        file_chooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 46, 93));
        setMinimumSize(new java.awt.Dimension(600, 850));
        setPreferredSize(new java.awt.Dimension(600, 850));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pdf_viewer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pdf_viewer.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        pdf_viewer.setMinimumSize(new java.awt.Dimension(563, 563));
        pdf_viewer.setPreferredSize(new java.awt.Dimension(563, 563));
        pdf_viewer.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 6);
        getContentPane().add(pdf_viewer, gridBagConstraints);

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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 127, 6, 0);
        getContentPane().add(submit_button, gridBagConstraints);

        skip_button.setText("Skip");
        skip_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                skip_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 6, 0);
        getContentPane().add(skip_button, gridBagConstraints);

        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                cancel_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 6, 0);
        getContentPane().add(cancel_button, gridBagConstraints);

        helper_form_title_label.setFont(new java.awt.Font("Verdana", 0, 20));
        helper_form_title_label.setForeground(new java.awt.Color(255, 255, 255));
        helper_form_title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helper_form_title_label.setText("SCANNING FORM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 386;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 6);
        getContentPane().add(helper_form_title_label, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 562;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 6);
        getContentPane().add(serparator_I, gridBagConstraints);

        options_panel.setBackground(new java.awt.Color(123, 153, 203));
        options_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        options_panel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        options_panel.setMinimumSize(new java.awt.Dimension(563, 109));

        id_label.setBackground(new java.awt.Color(0, 46, 93));
        id_label.setFont(new java.awt.Font("Verdana", 0, 12));
        id_label.setForeground(new java.awt.Color(255, 255, 255));
        id_label.setText("ID Number/NetID:");
        id_label.setMaximumSize(new java.awt.Dimension(113, 25));
        id_label.setMinimumSize(new java.awt.Dimension(113, 25));
        id_label.setPreferredSize(new java.awt.Dimension(113, 25));

        scanning_from_label.setBackground(new java.awt.Color(0, 46, 93));
        scanning_from_label.setFont(new java.awt.Font("Verdana", 0, 12));
        scanning_from_label.setForeground(new java.awt.Color(255, 255, 255));
        scanning_from_label.setText("Scanning From:");
        scanning_from_label.setFocusable(false);
        scanning_from_label.setMaximumSize(new java.awt.Dimension(97, 25));
        scanning_from_label.setMinimumSize(new java.awt.Dimension(97, 25));
        scanning_from_label.setPreferredSize(new java.awt.Dimension(97, 25));

        id_input.setFont(new java.awt.Font("Verdana", 0, 12));
        id_input.setMaximumSize(new java.awt.Dimension(156, 25));
        id_input.setMinimumSize(new java.awt.Dimension(156, 25));
        id_input.setPreferredSize(new java.awt.Dimension(156, 25));

        processing_label.setBackground(new java.awt.Color(0, 46, 93));
        processing_label.setFont(new java.awt.Font("Verdana", 0, 12));
        processing_label.setForeground(new java.awt.Color(255, 255, 255));
        processing_label.setText("Currently Processing:");
        processing_label.setFocusable(false);
        processing_label.setMaximumSize(new java.awt.Dimension(135, 25));
        processing_label.setMinimumSize(new java.awt.Dimension(135, 25));
        processing_label.setPreferredSize(new java.awt.Dimension(135, 25));

        filename_label.setBackground(new java.awt.Color(0, 46, 93));
        filename_label.setFont(new java.awt.Font("Verdana", 0, 12));
        filename_label.setForeground(new java.awt.Color(255, 255, 255));
        filename_label.setText("Filename");
        filename_label.setFocusable(false);
        filename_label.setMaximumSize(new java.awt.Dimension(295, 16));
        filename_label.setMinimumSize(new java.awt.Dimension(295, 16));
        filename_label.setPreferredSize(new java.awt.Dimension(295, 16));

        number_I_label.setBackground(new java.awt.Color(0, 46, 93));
        number_I_label.setFont(new java.awt.Font("Verdana", 0, 12));
        number_I_label.setForeground(new java.awt.Color(255, 255, 255));
        number_I_label.setText("#");
        number_I_label.setFocusable(false);
        number_I_label.setMaximumSize(new java.awt.Dimension(25, 25));
        number_I_label.setMinimumSize(new java.awt.Dimension(25, 25));
        number_I_label.setPreferredSize(new java.awt.Dimension(25, 25));

        of_label.setBackground(new java.awt.Color(0, 46, 93));
        of_label.setFont(new java.awt.Font("Verdana", 0, 12));
        of_label.setForeground(new java.awt.Color(255, 255, 255));
        of_label.setText("of");
        of_label.setFocusable(false);
        of_label.setMaximumSize(new java.awt.Dimension(25, 25));
        of_label.setMinimumSize(new java.awt.Dimension(25, 25));
        of_label.setPreferredSize(new java.awt.Dimension(25, 25));

        number_II_label.setBackground(new java.awt.Color(0, 46, 93));
        number_II_label.setFont(new java.awt.Font("Verdana", 0, 12));
        number_II_label.setForeground(new java.awt.Color(255, 255, 255));
        number_II_label.setText("#");
        number_II_label.setFocusable(false);
        number_II_label.setMaximumSize(new java.awt.Dimension(25, 25));
        number_II_label.setMinimumSize(new java.awt.Dimension(25, 25));
        number_II_label.setPreferredSize(new java.awt.Dimension(25, 25));

        file_type_label.setBackground(new java.awt.Color(0, 46, 93));
        file_type_label.setFont(new java.awt.Font("Verdana", 0, 12));
        file_type_label.setForeground(new java.awt.Color(255, 255, 255));
        file_type_label.setText("File Type:");
        file_type_label.setMaximumSize(new java.awt.Dimension(60, 25));
        file_type_label.setMinimumSize(new java.awt.Dimension(60, 25));
        file_type_label.setPreferredSize(new java.awt.Dimension(60, 25));

        location_label.setBackground(new java.awt.Color(0, 46, 93));
        location_label.setFont(new java.awt.Font("Verdana", 0, 12));
        location_label.setForeground(new java.awt.Color(255, 255, 255));
        location_label.setText("M:\\To_Be_Scanned\\");
            location_label.setFocusable(false);
            location_label.setMaximumSize(new java.awt.Dimension(389, 25));
            location_label.setMinimumSize(new java.awt.Dimension(389, 25));
            location_label.setName("");
            location_label.setPreferredSize(new java.awt.Dimension(389, 25));

            file_chooser_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FolderIcon.png")));
            file_chooser_button.setMaximumSize(new java.awt.Dimension(25, 25));
            file_chooser_button.setMinimumSize(new java.awt.Dimension(25, 25));
            file_chooser_button.setPreferredSize(new java.awt.Dimension(25, 25));
            file_chooser_button.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) 
                {
                    file_chooser_buttonActionPerformed(evt);
                }
            });

            file_option_box.setFont(new java.awt.Font("Verdana", 0, 12))
            file_option_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Academic Improvemtent Plan", "Change of Major", "Email", "Minor", "Plan", "Progress Report", "Substitution", "Transfer", "Waiver", "Other" }));
            file_option_box.setMaximumSize(new java.awt.Dimension(210, 25));

            javax.swing.GroupLayout options_panelLayout = new javax.swing.GroupLayout(options_panel);
            options_panel.setLayout(options_panelLayout);
            options_panelLayout.setHorizontalGroup(
                options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, options_panelLayout.createSequentialGroup()
                    .addContainerGap(466, Short.MAX_VALUE)
                    .addComponent(number_I_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(of_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(number_II_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(options_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(options_panelLayout.createSequentialGroup()
                                .addComponent(file_type_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(file_option_box, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id_input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(options_panelLayout.createSequentialGroup()
                                .addGroup(options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(options_panelLayout.createSequentialGroup()
                                        .addComponent(scanning_from_label, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(file_chooser_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(processing_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(options_panelLayout.createSequentialGroup()
                                        .addComponent(filename_label, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(location_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(12, 12, 12)))
            );
            options_panelLayout.setVerticalGroup(
                options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(options_panelLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(number_II_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(of_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(number_I_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(43, Short.MAX_VALUE))
                .addGroup(options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(options_panelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scanning_from_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(location_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(file_chooser_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(processing_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filename_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(options_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(file_type_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(file_option_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(id_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(id_input, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(11, Short.MAX_VALUE)))
            );

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.gridwidth = 4;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 6);
            getContentPane().add(options_panel, gridBagConstraints);

            pack();
        }                       

    // Define the submit button click function            
    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                              
        
        // Check if there is a file loaded
        if(number_I_label.getText() == "#" || number_I_label.getText() == "0")
        {
            // If not, output an error message and exit the function
            JOptionPane.showMessageDialog(null, "There is nothing to submit.", "No File", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Initialize the id value variable
        String id_value = "";
        
        // Check if there is anything in the id box
        if(id_input.getText().equals("") == false)
        {
            // If so get the id number and format it
            id_value = id_input.getText();
            id_value.replaceAll("[\\s\\-()]", "");
            id_value.replaceAll("\\s+","");
        }
        
        // Check if there is anything in the id box
        if(id_value == "")
        {
            // If not, output an error message and exit the function
            JOptionPane.showMessageDialog(null, "Please enter an ID number or NetID.", "Missing ID", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Check if the id box contains a number 
        else if(isNumeric(id_value) == true)
        {
            // If so, check if the number is too short
            if(id_value.length() < 9)
            {
                // If so, output an error message and exit the function
                JOptionPane.showMessageDialog(null, "The given ID number is too short. Please try again.", "Invalid ID Number", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Check if the id number is too long
            else if(id_value.length() > 9)
            {
                // If so, output an error message and exit the function
                JOptionPane.showMessageDialog(null, "The given ID number is too long. Please try again.", "Invalid ID Number", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else
            {
                // Search for the student's information
                searchIDNumber(id_value);
            }
        }
        
        else
        {
            // Search for the student's information
           searchIDNumber(id_value);
        }
    }                                             

    // Define the skip button click function
    private void skip_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                            
        // Check if the student actually wants to skip the file
        int response = JOptionPane.showConfirmDialog(null, 
                "WARNING: This file will still be cleared with the rest of the items in the scanning folder if you choose to empty the file at the end of the program. Are you sure you wish to continue?", 
                "Skip Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            // Check if the student said yes
            if(response == JOptionPane.YES_OPTION)
            {
                // If so, go to the next file
                advanceCurrentFile();
            }
            
            else
            {
                // Otherwise do nothing
                return;
            }
    }                                           

    // Define the cancel button click function
    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                              
        // Reset the directory
        directory_path = "M:\\To_Be_Scanned\\";

        // Clear the file list
        file_list.clear();
        
        // Close the input stream
        if(input_stream != null)
        {
            try 
            {
                input_stream.close();
            } 
            catch (IOException e) 
            {
                // Throw an exception
                throw new RuntimeException(e);
            }
        }
        
        // Close scanning form
        this.dispose();
        
        // Restore the main form
        main_form.setVisible(true);
    }                                             

    // Define the file chooser button click
    private void file_chooser_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                                    
        // Check if the scanning process has begun yet
        if (number_I_label.getText() == "1" || number_I_label.getText() == "#" || number_I_label.getText() == "0")
        {
            // Open and handle a file selection dialogue
            int return_value = file_chooser.showOpenDialog(this);
            if(return_value == JFileChooser.APPROVE_OPTION)
            {
                // Get the chosen directory
                File file = file_chooser.getSelectedFile();
                
                // Extract the files from the folder
                getScannedFiles(file);
                
                // Check if there are any files in the selected folder
                if(file_list.size() > 0)
                {
                    // Set the new label for the new directory
                    location_label.setText(file.getAbsolutePath());
                
                    // Save the directory path
                    directory_path = file.getAbsolutePath();
                
                    // Set the number and filename lables
                    number_I_label.setText("1");
                    number_II_label.setText(String.valueOf(file_list.size()));
                    filename_label.setText(file_list.get(0));

                    // attempt to open the pdf
                    try
                    {
                        input_stream = new FileInputStream(directory_path + "\\" + file_list.get(0));
                    }
                    catch(Exception e)
                    {
                        // Throw an exception
                        throw new RuntimeException(e);
                    }
                    
                    // Add the pdf to the form
                    controller.openDocument(input_stream, "", "");
                }
                
                else
                {
                    // Output an error message
                    JOptionPane.showMessageDialog(null, "I'm sorry, the folder you've chosen does not contain any PDF's. Please try again.", "Incompatible Folder", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        else
        {
            // Output an error message
            JOptionPane.showMessageDialog(null, "The scanning process has already begun. To scan from a new folder either complete the current scanning procedure or exit and reopen the scanning form.", "Scanning in Progress", JOptionPane.ERROR_MESSAGE);
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
    private WebDriver browser;
    private MainForm main_form;
    private static String directory_path = "M:\\To_Be_Scanned\\";
    private static ArrayList<String> file_list = new ArrayList<String>();
    private SwingController controller;
    private InputStream input_stream;
    private Integer current_file;
    // End of variables declaration
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton cancel_button;
    private javax.swing.JFileChooser file_chooser;
    private javax.swing.JButton file_chooser_button;
    private javax.swing.JComboBox<String> file_option_box;
    private javax.swing.JLabel file_type_label;
    private javax.swing.JLabel filename_label;
    private javax.swing.JLabel helper_form_title_label;
    private javax.swing.JTextField id_input;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel location_label;
    private javax.swing.JLabel number_II_label;
    private javax.swing.JLabel number_I_label;
    private javax.swing.JLabel of_label;
    private javax.swing.JPanel options_panel;
    private volatile javax.swing.JPanel pdf_viewer;
    private javax.swing.JLabel processing_label;
    private javax.swing.JLabel scanning_from_label;
    private javax.swing.JSeparator serparator_I;
    private javax.swing.JButton skip_button;
    private javax.swing.JButton submit_button;
    // End of variables declaration                   
}
