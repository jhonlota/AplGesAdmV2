/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neuranas;

import clases.ClaseCorreo;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Admin
 */
public class SmtpAuthenticator extends Authenticator {

    public SmtpAuthenticator() {
        super();
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        String username = ClaseCorreo.correo;
        String password = ClaseCorreo.contrasena;
        if ((username != null) && (username.length() > 0) && (password != null)
                && (password.length() > 0)) {
            return new PasswordAuthentication(username, password);
        }

        return null;
    }
}