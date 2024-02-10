public class Biblioteca {

    static int contadorLibros = 0;

    private String nombre;
    private String direccion;
    private Libro[] libros;

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void anadirLibros(Libro [] misLibros) {

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

        Libro libro = new Libro(titulo, autor, anoPublicacion, codigoISBN, numEjemplares);
        misLibros[contadorLibros] = libro;
        contadorLibros++;

        // Corección creación array aux si el array por defecto se llena 

        // try {
        //     libros[contadorLibros] = l; 
        // } catch (ArrayIndexOutOfBoundsException e) {    // Posible error. Comprobar el funcionamiento. 

        //     System.out.println("Has llenado la capacidad del array. Generando una posición adicional... ");

        //     Libro [] arrayAux = new Libro[libros.length + 1];

        //     System.arraycopy(libros, 0, arrayAux, 0, arrayAux.length);

        //     libros = arrayAux; 


        // }
    }

    public void buscarLibrosAutor() {

        System.out.println("Introduce el autor del libro a buscar: ");
        String autorInput = EntradaDatos.leerString();

        try {
            for (int i = 0; i < libros.length; i++) {
                if (autorInput.equals(libros[i].getAutor())) {
                    System.out.println("Resultado de la búsqueda: \n" + "Título: " +libros[i].getTitulo() + "  |  Autor:  " + libros[i].getAutor());
                    break; // Con esto se arregla el error del comentario de abajo, pero quizás no es lícito utilizar un break aquí.
                } else {
                    System.out.println("Libro no encontrado"); // Error aquí, muestra este mensaje aunque encuentre el libro
                }
            }
        } catch (NullPointerException e) {
            System.out.println(" ");
        }

    }

    public void buscarLibrosTitulo() {

    }

    public void buscarLibrosISBN() {

    }

    public void modificarEjemplares(Libro [] libros) {

        System.out.println("Introduzca el ISBN del libro del cual desea modificar los ejemplares: ");
        int inputISBN = EntradaDatos.leerEntero();

        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getCodigoISBN() == inputISBN) {
                System.out.println("Introduce el número de ejemplares: ");
                int inputEjemplares = EntradaDatos.leerEntero();
                libros[i].setNumEjemplares(inputEjemplares);

                if (libros[i].getNumEjemplares() == inputEjemplares) {
                    System.out.println("Número de ejemplares modificado correctamente.");
                } else {
                    System.out.println("Error durante la modificación.");
                }
            }
        }
    }

    public void consultarEjemplares(Libro [] libros) { // No actualiza al añadir un nuevo libro durante la ejecución, REVISAR

        int contadorLibros = 0; 

        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                contadorLibros++;
            }
        }

        System.out.println("En la biblioteca seleccionada hay " + contadorLibros + " libros");

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
