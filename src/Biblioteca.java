public class Biblioteca {

    static int contadorLibros = 0; 

    private String nombre; 
    private String direccion; 
    private Libro [] libros; 

    
    public Biblioteca(String nombre, String direccion, Libro[] libros) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.libros = libros;
    }

    

    public void anadirLibros() {

        System.out.println("Introduce el titulo del libro: ");
        String titulo = EntradaDatos.leerString();
        System.out.println("Introduce el autor del libro: ");
        String autor = EntradaDatos.leerString();
        System.out.println("Introduce el año de publicación del libro: ");
        int anoPublicacion = EntradaDatos.leerEntero(); 
        System.out.println("Introduce el ISBN del libro: ");
        long codigoISBN = EntradaDatos.leerLong();
        System.out.println("Introduce el número de ejemplares del libro: ");
        int numEjemplares = EntradaDatos.leerEntero();
                
        Libro l = new Libro(titulo, autor, anoPublicacion, codigoISBN, numEjemplares);
        libros[contadorLibros] = l; 
        contadorLibros++; 
    }

    public void buscarLibrosAutor() {

        System.out.println("Introduce el autor del libro a buscar: ");
        String autorInput = EntradaDatos.leerString(); 

        for (int i = 0; i < libros.length; i++) {
            if(autorInput.equals(libros[i].getAutor())) {
                System.out.println("Resultado de la búsqueda: \n" + libros[i].getTitulo() + libros[i].getAutor());
            }
        }

    }

    public void buscarLibrosTitulo() {
        
    }

    public void buscarLibrosISBN() {
        
    }

    public void modificarEjemplares() {

        System.out.println("Introduzca el ISBN del libro del cual desea modificar los ejemplares: ");
        int inputISBN = EntradaDatos.leerEntero();

        for (int i = 0; i < libros.length; i++) {
            if(libros[i].getCodigoISBN() == inputISBN) {
                System.out.println("Introduce el número de ejemplares: ");
                int inputEjemplares = EntradaDatos.leerEntero();
                libros[i].setNumEjemplares(inputEjemplares);

                if(libros[i].getNumEjemplares() == inputEjemplares) {
                    System.out.println("Número de ejemplares modificado correctamente.");
                } else {
                    System.out.println("Error durante la modificación.");
                }
            }
        }
    }

    public void consultarEjemplares() { // Usar en el main un if que pregunte por el nombre de la biblioteca a consultar, poniendo en una condición b1.consultarEjemplares() y en la otra b2.consultarEjemplares()
        System.out.println("En la biblioteca seleccionada hay " + libros.length + " libros."); // Verificar que las posiciones no tengan null por valor. 
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDireccion() {
        return direccion;
    }



    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public Libro[] getLibros() {
        return libros;
    }



    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

}
