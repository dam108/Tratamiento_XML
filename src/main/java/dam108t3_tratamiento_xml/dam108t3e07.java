/*
Realiza un programa que muestre el nombre de todos los libros con su alto, ancho y número
de páginas. (Algunos puede que no tengan toda o parte de esa información, mostrar una
interrogación en sus valores, por ejemplo: “El perfume  Dimensiones ? cm x ? cm. ? páginas)
 */
package dam108t3_tratamiento_xml;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class dam108t3e07 {

    public static void main(String[] args) {
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
               String titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
               System.out.print("Titulo: "+titulo);
                Element dimensiones = (Element) listaDimensiones.item(i);
                String alto, ancho, paginas;
                if (dimensiones != null){
                    if (dimensiones.hasAttribute("alto"))
                    alto = dimensiones.getAttribute("alto");
                    else alto = "?";
                    if (dimensiones.hasAttribute("ancho"))
                    ancho = dimensiones.getAttribute("ancho");
                    else ancho = "?";
                    if (dimensiones.hasAttribute("paginas"))
                    paginas = dimensiones.getAttribute("paginas");
                    else paginas = "?";
                }
                else {
                    alto = "?"; ancho = "?"; paginas = "?";
                }
                System.out.printf(", alto : %s, ancho: %s, numero de paginas: %s\n", alto, ancho, paginas);

           }
           
       }
       catch (Exception e){ e.printStackTrace();}
    }
    
}
