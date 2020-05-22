/*
 Realiza un programa que muestre el nombre de todos los libros y su autor o autores
 */
package dam108t3_tratamiento_xml;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class dam108t3e06 {
    public static void main(String[] args) {
       File f = new File("archivos\\libreria.xml");
       try (FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dB = factory.newDocumentBuilder();
           Document doc = dB.parse(new InputSource(isr));
           
           NodeList listaLibros = doc.getElementsByTagName("libro");
           for (int i = 0; i < listaLibros.getLength(); i++) {
               Element elemento = (Element)listaLibros.item(i);
               String titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
               System.out.print("Titulo: "+titulo);
               NodeList listaAutores = elemento.getElementsByTagName("autor");
               for (int j = 0; j < listaAutores.getLength(); j++) {
                   String autor = listaAutores.item(j).getTextContent();
                   System.out.printf(", Autor %d: %s",j+1, autor);
                 }
               System.out.println();
           }
           
       }
       catch (Exception e){ e.printStackTrace();}
    }
    
}
