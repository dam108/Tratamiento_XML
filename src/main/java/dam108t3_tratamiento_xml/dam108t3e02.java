/*
Realiza un programa que muestre el título de todos los libros presentes ‘librería.xml’.
*/
package dam108t3_tratamiento_xml;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class dam108t3e02 {

    public static void main(String[] args) {
       File f = new File("archivos\\libreria.xml");
       try (FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dB = factory.newDocumentBuilder();
           Document doc = dB.parse(new InputSource(isr));
           
           NodeList listaTitulos = doc.getElementsByTagName("titulo");
           for (int i = 0; i < listaTitulos.getLength(); i++) {
               Node nodo = listaTitulos.item(i);
               System.out.println("Titulo del libro: "+ nodo.getTextContent());
           }
           
       }
       catch (Exception e){ e.printStackTrace();}
    }
    
}
