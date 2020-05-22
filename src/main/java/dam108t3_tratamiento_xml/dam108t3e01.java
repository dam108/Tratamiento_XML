 /*
Realiza un programa que muestre el nombre del documento raíz del archivo ‘librería.xml’
*/
package dam108t3_tratamiento_xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class dam108t3e01 {

    public static void main(String[] args) {
       File f = new File("archivos\\libreria.xml");
       try (FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dB = factory.newDocumentBuilder();
           Document doc = dB.parse(new InputSource(isr));
           
           System.out.println("Raiz: "+ doc.getDocumentElement().getNodeName());
           
       }
       catch (Exception e){ e.printStackTrace();}
    
           
    }
    
}
