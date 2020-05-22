
package dam108t3_tratamiento_xml;

public class Libro {
    String ISBN, nombre, nPaginas;

    Libro(String isbn, String n, String nPaginas){
        this.ISBN = isbn;
        this.nombre = n;
        this.nPaginas = nPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", nombre=" + nombre + ", nPaginas=" + nPaginas + '}';
    }
       
}
