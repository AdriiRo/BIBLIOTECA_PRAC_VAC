public class Libro {

    static int contadorLibros = 0; 

    private String titulo; // Los 4 primeros atributos deben de ser final, aparentemente no me deja ya que no están inicializados, una opción sería borrar el método "set" de esos 4 atributos para que de esa forma no sea modificable por ninguna otra clase 
    private String autor; 
    private int anoPublicacion; 
    private long codigoISBN; 
    private int numEjemplares;

    public Libro(String titulo, String autor, int anoPublicacion, long codigoISBN, int numEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.codigoISBN = codigoISBN;
        this.numEjemplares = numEjemplares;
        contadorLibros++;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public long getCodigoISBN() {
        return codigoISBN;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        if (numEjemplares >= 0) {
            this.numEjemplares = numEjemplares;
        } else {
            System.out.println("ERROR. No puede haber una cantidad negativa de libros.");
        }
    } 

}
