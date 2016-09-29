/*================================================
                    Login Form
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
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

// Create the LoginForm class
public class LoginForm extends javax.swing.JFrame 
{
    // Create the LoginForm Constructor
    public LoginForm() 
    {
        // Initialize components and set the submit button as the default button
        initComponents();
        this.getRootPane().setDefaultButton(submit_button);
    }
    
    // Suppress compile warnings
    @SuppressWarnings("unchecked")
    
    private void initComponents() 
    {

        net_id_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        net_id_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        submit_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 46, 93));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Verdana", 0, 12));
        setResizable(false);

        net_id_label.setFont(new java.awt.Font("Verdana", 0, 12));
        net_id_label.setForeground(new java.awt.Color(255, 255, 255));
        net_id_label.setLabelFor(net_id_field);
        net_id_label.setText("Net ID:");

        password_label.setFont(new java.awt.Font("Verdana", 0, 12));
        password_label.setForeground(new java.awt.Color(255, 255, 255));
        password_label.setLabelFor(password_field);
        password_label.setText("Password:");

        net_id_field.setBackground(new java.awt.Color(255, 255, 255));
        net_id_field.setForeground(new java.awt.Color(0, 0, 0));

        password_field.setBackground(new java.awt.Color(255, 255, 255));
        password_field.setForeground(new java.awt.Color(0, 0, 0));
        password_field.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        submit_button.setFont(new java.awt.Font("Verdana", 1, 12));
        submit_button.setForeground(new java.awt.Color(0, 0, 0));
        submit_button.setText("Submit");
        submit_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submit_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                submit_buttonActionPerformed(evt);
            }
        });

        cancel_button.setFont(new java.awt.Font("Verdana", 1, 12));
        cancel_button.setForeground(new java.awt.Color(0, 0, 0));
        cancel_button.setText("Cancel");
        cancel_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancel_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(net_id_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password_label, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(net_id_field, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(password_field))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(net_id_label, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(net_id_field))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(password_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password_field, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }

    // Define the cancel button click function
    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // Close the login form
        this.dispose();
    }

    // Define the submit button click function
    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // Get the user input
        String net_id = net_id_field.getText();
        String password = password_field.getText();
                
        // Check if the Net ID is valid
        if(net_id.matches("[a-zA-Z]+") == false || net_id.length() <= 0)
        {
            // If not output an error message and exit the function
            JOptionPane.showMessageDialog(null, "Please enter a valid Net ID and try again.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Check if the password is valid
        if(password.length() <= 0)
        {
            // If not output an error message and exit the function
            JOptionPane.showMessageDialog(null, "Please enter your password and try again", "Missing Password", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        // Create the web browser
        System.setProperty("phantomjs.binary.path", "M:\\Secretary Resources\\Brady\\Programming\\Java\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        WebDriver browser = new PhantomJSDriver();
        browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        // Navigate to the BYU login page
        browser.get("https://cas.byu.edu/cas/login?service=https://my.byu.edu/uPortal/Login");
        
        // Input the Net ID and password
        WebElement net_id_input = browser.findElement(By.id("netid"));
        net_id_input.sendKeys(net_id);
        WebElement password_input = browser.findElement(By.id("password"));
        password_input.sendKeys(password);
        
        // Click the submit button
        WebElement page_submit_button = browser.findElement(By.className("submit"));
        page_submit_button.click();
        
        // Check if the login worked
        if(!"https://my.byu.edu/uPortal/f/u20l1s5/normal/render.uP".equals(browser.getCurrentUrl()))
        {
           // If not ouptput an error message, close the browser, and reset the input fields
           JOptionPane.showMessageDialog(null, "The information you provided does not appear to be correct. Please check your Net ID and password and try again.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
           browser.quit();
           password_field.setText("");
           return;   
        }
        
        // Create a new main form
        MainForm main_form = new MainForm(browser);
        main_form.getContentPane().setBackground(new Color(0,46,93));
        main_form.setVisible(true);
        
        // Close the login form
        this.dispose();
    }

    // Define the main function
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - swing variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JTextField net_id_field;
    private javax.swing.JLabel net_id_label;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel password_label;
    private javax.swing.JButton submit_button;
    // End of variables declaration
    
}
