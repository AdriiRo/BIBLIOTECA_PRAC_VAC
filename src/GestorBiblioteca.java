public class GestorBiblioteca {

    public void sacarLibro(Libro[] libros) throws InterruptedException {    // No funciona correctamente. REVISAR

        System.out.println("Introduce el título del libro que quieres sacar: ");
        String inputTitulo = EntradaDatos.leerString();

        try {

            for (int i = 0; i < libros.length; i++) {
                if (inputTitulo.equals(libros[i].getTitulo())) {
                    System.out.println("Libro encontrado, gestionando préstamo...");
                    Thread.sleep(1000);
                    if (libros[i].getNumEjemplares() > 0) {
                        int tempEjemplares = libros[i].getNumEjemplares() - 1;
                        libros[i].setNumEjemplares(tempEjemplares);
                        System.out.println(
                                "Préstamo realizado. Actualmente hay " + libros[i].getNumEjemplares() + " ejemplares");
                    } else {
                        System.out.println("No hay más libros disponibles");
                    }
                    break;
                } else {
                    System.out.println("El libro que has seleccionado no existe o no está disponible");
                }
            }
        } catch (NullPointerException e) {
            System.out.println(" ");
        }

    }

    public void devolverLibro() {   // Inverso al sacarLibro, añadir un ejemplar más del libro seleccionado.

    }

    public void eliminarLibro() {   // Buscar por título, introducir ISBN para verificar la eliminación del libro, setear la posición seleccionada a null.

    }

}
