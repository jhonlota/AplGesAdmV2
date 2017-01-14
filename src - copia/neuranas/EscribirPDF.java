
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neuranas;

import clases.ClaseInformacion;
import clases.ClaseMensaje;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 *
 * @author Jhon Lopez
 */
public class EscribirPDF {

    public void escribirCodigoVerificacacion(File file, String nombreArchivo) throws FileNotFoundException, DocumentException, IOException {
        try {
            Document document = new Document();
            document.setMargins(0, 0, 0, 0);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file.getParent() + "\\_" + file.getName()));
            document.open();
            PdfReader reader = new PdfReader(file.getPath());
            int n = reader.getNumberOfPages();
            PdfImportedPage page;
            Font font = new Font(Font.FontFamily.COURIER, Font.NORMAL, 6);
            Paragraph paragraph = null;

            for (int i = 1; i <= n; i++) {
                paragraph = new Paragraph("." + ClaseInformacion.CrearCodigoVerificacion(nombreArchivo));
                document.add(paragraph);
                
                page = writer.getImportedPage(reader, i);
                Image instance = Image.getInstance(page);
                instance.scalePercent(100, 90);
                document.add(instance);
                
                while(!document.newPage()) {
                    document.add(new Paragraph(""));
                }
            }
            
            document.close();
            reader.close();
        } catch (Exception e) {
            ClaseMensaje.error("Error al escribir el codigo de verificacion");
        }
    }

    public String toHex(String arg) throws UnsupportedEncodingException {
        return String.format("%x", new BigInteger(1, arg.getBytes()));
    }
}
