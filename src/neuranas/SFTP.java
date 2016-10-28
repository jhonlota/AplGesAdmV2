/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neuranas;

import clases.ClaseMensaje;
import com.itextpdf.text.DocumentException;
import com.jcraft.jsch.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
            File file = new File(url);
            escribirPDF.escribirCodigoVerificacacion(file, nombreArchivo);
            
            session = jsch.getSession("facultadciencias", "cms.univalle.edu.co", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setConfig("PreferredAuthentications", "password,gssapi-with-mic,publickey,keyboard-interactive");
            session.setPassword("gXEErGmy");
            session.connect();
            
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
                        
            sftpChannel.cd("public_html/UmVbZxut/archivos/");
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
            session = jsch.getSession("facultadciencias", "cms.univalle.edu.co", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setConfig("PreferredAuthentications", "password,gssapi-with-mic,publickey,keyboard-interactive");
            session.setPassword("gXEErGmy");
            session.connect();
            
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
                        
            sftpChannel.cd("public_html/UmVbZxut/archivos/");
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
