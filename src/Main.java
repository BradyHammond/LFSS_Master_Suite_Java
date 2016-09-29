/*================================================
               Life Sciences Master Suite
==================================================
// Created: 08/24/16
// Created by: Brady Hammond
// Last edited:
// Last edited by:
================================================*/

import Forms.LoginForm;
import java.awt.Color;

public class Main 
{
    public static void main(String[] args) 
    {
        LoginForm login_form = new LoginForm();
        login_form.setVisible(true);
        login_form.getContentPane().setBackground(new Color(0,46,93));
    }
}
