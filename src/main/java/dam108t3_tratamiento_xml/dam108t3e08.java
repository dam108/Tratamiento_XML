/*
Diseña una clase llamada Libro, que sea capaz de mantener para un libro su ISBN, nombre,
precio y autores. Crea un programa que cargue en un ArrayList de ‘Libro’ la información
correspondiente que viene en el archivo ‘libreria.xml’. A continuación, ordenará el ArrayList por
título de libro y mostrará por pantalla el contenido completo de ese ArrayList. Pista:
Implementar en la clase Libro el método toString() para facilitar el programa.
 */
package dam108t3_tratamiento_xml;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class dam108t3e08 {
    public static ArrayList<Libro> libros;
    public static CompararNombre compNom = new CompararNombre();
    public static void main(String[] args) {
        libros = new ArrayList<>();
    
       File f = new File("archivos\\libreria.xml");
       try (FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dB = factory.newDocumentBuilder();
           Document doc = dB.parse(new InputSource(isr));
           
           NodeList listaLibros = doc.getElementsByTagName("libro");
           NodeList listaDimensiones = doc.getElementsByTagName("dimensiones");
           for (int i = 0; i < listaLibros.getLength(); i++) {
               Element elemento = (Element)listaLibros.item(i);
               String isbn = elemento.getElementsByTagName("isbn").item(0).getTextContent();
               String titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
        
                Element dimensiones = (Element) listaDimensiones.item(i);
                String paginas;
                if (dimensiones != null){
                    if (dimensiones.hasAttribute("paginas"))
                    paginas = dimensiones.getAttribute("paginas");
                    else paginas = "?";
                }
                else {
                    paginas = "?";
                }
                libros.add(new Libro(isbn,titulo,paginas));
           }

           Collections.sort(libros, compNom);
           
           for (Libro x : libros) {
               System.out.println(x.toString());
           }
           
       }
       catch (Exception e){ e.printStackTrace();}
    
    }
    
    static class CompararNombre implements Comparator {
        public int compare(Object o1, Object o2){
            Libro l1 = (Libro) o1; Libro l2 = (Libro) o2;
            return l1.nombre.compareToIgnoreCase(l2.nombre);
        }
    }
    
}
