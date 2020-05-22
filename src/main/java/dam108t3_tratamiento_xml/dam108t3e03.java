/*
Realiza un programa que muestre el título de todos los libros presentes en ‘librería.xml’ con su
precio. (Todos los libros tienen precio)
*/
package dam108t3_tratamiento_xml;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class dam108t3e03 {

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
               String precio = elemento.getElementsByTagName("precio").item(0).getTextContent();
               
               System.out.println("Titulo: "+titulo+", precio: "+precio);
           }
           
       }
       catch (Exception e){ e.printStackTrace();}
    }
    
}
