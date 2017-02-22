/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neuranas;

import clases.ClaseGeneral;
import clases.ClaseMensaje;
import com.itextpdf.text.DocumentException;
import com.jcraft.jsch.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Jhon Lopez
 */
public class SFTP {

    JSch jsch = new JSch();
    Session session = null;
    EscribirPDF escribirPDF = new EscribirPDF();

    public void subir(String url, String nombreArchivo) throws DocumentException, IOException {
        try {
//            IMPORTANTE cargar archivo de configuracion    
//            File archivo = new File("C:/config.con");
//            ArrayList<String> array = ClaseGeneral.leer.MetodoLeer(archivo);
//
//            urlFTP = array.get(1).substring(array.get(1).indexOf("='") + 2, array.get(1).indexOf("';"));
//            login = array.get(6).substring(array.get(6).indexOf("='") + 2, array.get(6).indexOf("';"));
//            pwd = array.get(7).substring(array.get(7).indexOf("='") + 2, array.get(7).indexOf("';"));
            
            File file = new File(url);
            escribirPDF.escribirCodigoVerificacacion(file, nombreArchivo);

            session = jsch.getSession(ClaseGeneral.login, ClaseGeneral.urlFTP, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setConfig("PreferredAuthentications", "password,gssapi-with-mic,publickey,keyboard-interactive");
            session.setPassword(ClaseGeneral.pwd);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
//            System.out.println(sftpChannel.pwd());

            sftpChannel.cd("datos/UmVbZxut/archivos/");
            sftpChannel.put(new FileInputStream(file.getParent() + "\\_" + file.getName()), nombreArchivo);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException ex) {
            ClaseMensaje.error("Error al importar la libreria JSCH");
            java.util.logging.Logger.getLogger(SFTP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SftpException ex) {
            ClaseMensaje.error("Error al conectarse SFTP al servidor");
            java.util.logging.Logger.getLogger(SFTP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            ClaseMensaje.error("Error, no se encontro el archivo");
            java.util.logging.Logger.getLogger(SFTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bajar(String url, String nombreArchivo) throws DocumentException, IOException {
        try {
            File archivo = new File("C:/config.con");
            ArrayList<String> array = ClaseGeneral.leer.MetodoLeer(archivo);

            String urlFTP = array.get(1).substring(array.get(1).indexOf("='") + 2, array.get(1).indexOf("';"));
            String login = array.get(6).substring(array.get(6).indexOf("='") + 2, array.get(6).indexOf("';"));
            String pwd = array.get(7).substring(array.get(7).indexOf("='") + 2, array.get(7).indexOf("';"));

            session = jsch.getSession(login, urlFTP, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setConfig("PreferredAuthentications", "password,gssapi-with-mic,publickey,keyboard-interactive");
            session.setPassword(pwd);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;

            sftpChannel.cd("datos/UmVbZxut/archivos/");
            sftpChannel.get(nombreArchivo);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException ex) {
            ClaseMensaje.error("Error al importar la libreria JSCH");
            java.util.logging.Logger.getLogger(SFTP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SftpException ex) {
            ClaseMensaje.error("Error al conectarse SFTP al servidor");
            java.util.logging.Logger.getLogger(SFTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
