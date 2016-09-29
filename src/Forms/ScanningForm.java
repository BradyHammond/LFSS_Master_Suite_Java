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
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
        
        // Initialize components
        initComponents();
        
        // Get the files in the default folder
        File file = new File(directory_path);
        getScannedFiles(file);
        
        // Check if there were files in the default folder
        if(file_list.size() > 0)
        {
            // Set the number and filename lables
            number_I_label.setText("1");
            number_II_label.setText(String.valueOf(file_list.size()));
            filename_label.setText(file_list.get(0));
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
                input_stream = new FileInputStream(directory_path + "\\" + file_list.get(0));
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
    public static void getScannedFiles(final File folder)
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
    
    public boolean isNumeric(String string) 
    {  
        return string.matches("[-+]?\\d*\\.?\\d+");  
    }
    
    public void searchIDNumber(String student_id)
    {
        browser.get("https://y.byu.edu/ry/ae/prod/person/cgi/personSummary.cgi");
        
        WebElement student_id_input = browser.findElement(By.name("NAVpattern"));
        student_id_input.sendKeys(student_id);

        WebElement page_go_button = browser.findElement(By.xpath("//a[@href='javascript:NAVpreXref()']"));
        page_go_button.click();
    }

    // Suppress compile warnings
    @SuppressWarnings("unchecked")

    private void initComponents() 
    {

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
        setPreferredSize(new java.awt.Dimension(600, 850));

        pdf_viewer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pdf_viewer.setMaximumSize(new java.awt.Dimension(563, 563));
        pdf_viewer.setMinimumSize(new java.awt.Dimension(563, 563));
        pdf_viewer.setPreferredSize(new java.awt.Dimension(563, 563));
        pdf_viewer.setLayout(new java.awt.BorderLayout());

        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                submit_buttonActionPerformed(evt);
            }
        });

        skip_button.setText("Skip");
        skip_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                skip_buttonActionPerformed(evt);
            }
        });

        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                cancel_buttonActionPerformed(evt);
            }
        });

        helper_form_title_label.setFont(new java.awt.Font("Verdana", 0, 20));
        helper_form_title_label.setForeground(new java.awt.Color(255, 255, 255));
        helper_form_title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helper_form_title_label.setText("SCANNING FORM");

        options_panel.setBackground(new java.awt.Color(123, 153, 203));
        options_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        options_panel.setMaximumSize(new java.awt.Dimension(563, 109));
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

        file_option_box.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        file_option_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Academic Improvemtent Plan", "Change of Major", "Email", "Minor", "Plan", "Progress Report", "Substitution", "Transfer", "Waiver", "Other (Custom)" }));
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
                            .addComponent(id_input, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
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
                                .addComponent(location_label, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))))
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
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(skip_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serparator_I)
                            .addComponent(helper_form_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(options_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pdf_viewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helper_form_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serparator_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(options_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pdf_viewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skip_button)
                    .addComponent(cancel_button)
                    .addComponent(submit_button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // Define the submit button click function            
    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(number_I_label.getText() == "#" || number_I_label.getText() == "0")
        {
            JOptionPane.showMessageDialog(null, "There is nothing to submit.", "No File", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String id_value = "";
        if(id_input.getText().equals("") == false)
        {
            id_value = id_input.getText();
            id_value.replaceAll("[\\s\\-()]", "");
            id_value.replaceAll("\\s+","");
        }
        
        if(id_value == "")
        {
            JOptionPane.showMessageDialog(null, "Please enter an ID number or NetID.", "Missing ID", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        else if(isNumeric(id_value) == true)
        {
            if(id_value.length() < 9)
            {
                JOptionPane.showMessageDialog(null, "The given ID number is too short. Please try again.", "Invalid ID Number", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if(id_value.length() > 9)
            {
                JOptionPane.showMessageDialog(null, "The given ID number is too long. Please try again.", "Invalid ID Number", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else
            {
                searchIDNumber(id_value);
            }
        }
        
        else
        {
           searchIDNumber(id_value); 
        }
    }

    // Define the skip button click function
    private void skip_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // COMING SOON
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
                
                // Set the new label for the new directory
                location_label.setText(file.getAbsolutePath());
                
                // Save the directory path
                directory_path = file.getAbsolutePath();
                
                // Extract the files from the folder
                getScannedFiles(file);
                
                if(file_list.size() > 0)
                {
                    // Set the number and filename lables
                    number_I_label.setText("1");
                    number_II_label.setText(String.valueOf(file_list.size()));
                    filename_label.setText(file_list.get(0));
                }
                
                if(file_list.size() > 0 )
                { 
                    try
                    {
                        input_stream = new FileInputStream(directory_path + "\\" + file_list.get(0));
                    }
                    catch(Exception e)
                    {
                        throw new RuntimeException(e);
                    }
                    controller.openDocument(input_stream, "", "");
                }
            }
        }
        
        else
        {
            // Output an error message
            JOptionPane.showMessageDialog(null, "The scanning process has already begun. To scan from a new folder either complete the current scanning procedure or exit and reopen the scanning form.", "Error: Scanning in Progress", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Define the main function
    public static void main(String args[]) 
    {
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        
        catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(ScanningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(ScanningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(ScanningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(ScanningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


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
    // End of variables declaration
    
    // Variables declaration - swing variables
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
    private javax.swing.JPanel pdf_viewer;
    private javax.swing.JLabel processing_label;
    private javax.swing.JLabel scanning_from_label;
    private javax.swing.JSeparator serparator_I;
    private javax.swing.JButton skip_button;
    private javax.swing.JButton submit_button;
    // End of variables declaration
}
