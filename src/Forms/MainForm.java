/*================================================
                    Main Form
==================================================
// Created: 08/24/16
// Created by: Brady Hammond
// Last edited:
// Last edited by:
================================================*/

// Specify the correct package
package Forms;

// Import needed libraries
import java.awt.Color;
import javax.swing.JFrame;
import microsoft.exchange.webservices.data.autodiscover.IAutodiscoverRedirectionUrl;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.search.ResolveNameSearchLocation;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.misc.NameResolutionCollection;
import org.openqa.selenium.WebDriver;

// Create the MainForm class
public class MainForm extends javax.swing.JFrame 
{
    // Create the MainForm constructor
    public MainForm(WebDriver passed_browser) 
    {
        // Initialize components and save the passed browser
        initComponents();
        browser = passed_browser;
    }

    // Suppress compile warnings
    @SuppressWarnings("unchecked")

    private void initComponents() 
    {

        main_page_title_label = new javax.swing.JLabel();
        separator_I = new javax.swing.JSeparator();
        main_page_image = new javax.swing.JLabel();
        scanning_button = new javax.swing.JButton();
        imaging_button = new javax.swing.JButton();
        emails_button = new javax.swing.JButton();
        texts_button = new javax.swing.JButton();
        helper_button = new javax.swing.JButton();
        logout_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 46, 93));

        main_page_title_label.setBackground(new java.awt.Color(0, 46, 93));
        main_page_title_label.setFont(new java.awt.Font("Verdana", 1, 20));
        main_page_title_label.setForeground(new java.awt.Color(255, 255, 255));
        main_page_title_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        main_page_title_label.setText("LIFE SCIENCES MASTER SUITE");

        main_page_image.setBackground(new java.awt.Color(0, 46, 93));
        main_page_image.setForeground(new java.awt.Color(255, 255, 255));
        main_page_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LifeScienceImage.png")));

        scanning_button.setFont(new java.awt.Font("Verdana", 0, 12)); 
        scanning_button.setText("Scanning");
        scanning_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                scanning_buttonActionPerformed(evt);
            }
        });

        imaging_button.setFont(new java.awt.Font("Verdana", 0, 12));
        imaging_button.setText("Imaging");
        imaging_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                imaging_buttonActionPerformed(evt);
            }
        });

        emails_button.setFont(new java.awt.Font("Verdana", 0, 12));
        emails_button.setText("Emails");
        emails_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                emails_buttonActionPerformed(evt);
            }
        });

        texts_button.setFont(new java.awt.Font("Verdana", 0, 12));
        texts_button.setText("Texts");
        texts_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                texts_buttonActionPerformed(evt);
            }
        });

        helper_button.setFont(new java.awt.Font("Verdana", 0, 12));
        helper_button.setText("Helper");
        helper_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                helper_buttonActionPerformed(evt);
            }
        });

        logout_button.setFont(new java.awt.Font("Verdana", 0, 12));
        logout_button.setText("Logout");
        logout_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                logout_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(main_page_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separator_I)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(main_page_image)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logout_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imaging_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emails_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(texts_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scanning_button, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(helper_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_page_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator_I, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scanning_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imaging_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emails_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(texts_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(helper_button)
                        .addGap(13, 13, 13)
                        .addComponent(logout_button))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(main_page_image, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }

    // Define the logout button click function
    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // Close the browser
        browser.quit();
        
        // Close the main form
        this.dispose();
        
        // Terminate the program
        System.exit(0);
    }

    // Define the helper button click function
    private void helper_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // Hide the main form
        this.setVisible(false);
        
        // Create the helper form
        HelperForm helper_form = new HelperForm(this);
        helper_form.setVisible(true);
        helper_form.getContentPane().setBackground(new Color(0,46,93));
    }
    
    // Define the texts button click function
    private void texts_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        JOptionPane.showMessageDialog(null, "This feature is currently unavailable. Funcionatlity should be restored soon", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
    }

    // Define the emails button click function
    private void emails_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        JOptionPane.showMessageDialog(null, "This feature is currently unavailable. Funcionatlity should be restored soon", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
    }

    // Define the imaging button click function
    private void imaging_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        JOptionPane.showMessageDialog(null, "This feature is currently unavailable. Funcionatlity should be restored soon", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
    }

    // Define the scanning button click function
    private void scanning_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        
        // Hide the main form
        this.setVisible(false);
        
        // Create the scanning form
        ScanningForm helper_form = new ScanningForm(browser,this);
        helper_form.setVisible(true);
        helper_form.getContentPane().setBackground(new Color(0,46,93));
    }/

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
    //End of variables declaration
    
    // Variables declaration - swing variables
    private javax.swing.JButton emails_button;
    private javax.swing.JButton helper_button;
    private javax.swing.JButton imaging_button;
    private javax.swing.JButton logout_button;
    private javax.swing.JLabel main_page_image;
    private javax.swing.JLabel main_page_title_label;
    private javax.swing.JButton scanning_button;
    private javax.swing.JSeparator separator_I;
    private javax.swing.JButton texts_button;
    // End of variables declaration
}
