/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import neuranas.SmtpAuthenticator;

/**
 *
 * @author Andres
 */
public class ClaseCorreo {

    public static Message[] mensajes = null;
    private static int cantidad = 0;
    private static Store store;
    private static Session sesionEntrada;
    private static Session sesionSalida;
    private static Transport transporte;
    public static String correo = "jhon.lopez@correounivalle.edu.co";
    public static String contrasena = "Hmc124970";

    public ClaseCorreo() {
        try {
            Properties prop = new Properties();
//            prop.setProperty("mail.imap.port", "993"); //El puerto del servidor IMAP para conectarse.
//            prop.setProperty("mail.imap.ssl.enable", "true");
//            prop.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //especifica el nombre de una clase que implementa la javax.net.SocketFactory interfaz.
//            prop.setProperty("mail.imap.socketFactory.port", "993"); //Especifica el puerto para conectarse a cuando se utiliza la fábrica de socket especificado
//            sesionEntrada = Session.getInstance(prop);
//            sesionEntrada.setDebug(true);
//            store = sesionEntrada.getStore("imap");
//            store.connect("imap.gmail.com", correo, contrasena);

            prop = new Properties();
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.setProperty("mail.smtp.port", "465");
            prop.setProperty("mail.smtp.ssl.enable", "true");
            prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.setProperty("mail.smtp.ssl.socketFactory.port", "465");
            prop.setProperty("mail.smtp.user", ClaseCorreo.correo);
            prop.setProperty("mail.smtp.password", ClaseCorreo.contrasena);

            SmtpAuthenticator authentication = new SmtpAuthenticator();
            sesionSalida = Session.getDefaultInstance(prop, authentication);
//            sesionSalida.setDebug(true);
            transporte = sesionSalida.getTransport("smtps");
        } catch (MessagingException me) {
            Logger.getLogger(ClaseCorreo.class.getName()).log(Level.SEVERE, null, me);
        } catch (Exception ex) {
            Logger.getLogger(ClaseCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean getConnected() {
        return store.isConnected();
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static Message getMensaje(int posicion) {
        return mensajes[posicion];
    }

    public static boolean enviarCorreo(String contenido, String emisor, String receptor) {
        boolean error = false;

        try {
            MimeMessage mensaje = new MimeMessage(sesionSalida);
            mensaje.setText(contenido, "UTF-8", "html");
            mensaje.setSubject("AGA - NOTA INFORMATIVA POR PAGO GENERADO (" + ClaseInformacion.calendario.getTimeInMillis() + ")");
            mensaje.setFrom(new InternetAddress(emisor));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            transporte.connect("smtp.gmail.com", ClaseCorreo.correo, ClaseCorreo.contrasena);
            transporte.sendMessage(mensaje, mensaje.getAllRecipients());
            transporte.close();
            ClaseMensaje.informacion("Se envio correctamente el correo");
        } catch (MessagingException me) {
            error = true;
//            ClaseMensaje.error("ERROR al enviar el correo");
            Logger.getLogger(ClaseCorreo.class.getName()).log(Level.SEVERE, null, me);
        } catch (Exception ex) {
            error = true;
//            ClaseMensaje.error("ERROR al enviar el correo");
            Logger.getLogger(ClaseCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return error;
    }
}
