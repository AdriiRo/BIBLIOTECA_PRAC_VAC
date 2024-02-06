import java.util.Scanner;

public class GestorBiblioteca {

    public void sacarLibro(Libro[] libros) throws InterruptedException {    

        System.out.println("Introduce el título del libro que quieres sacar: ");
        String inputTitulo = EntradaDatos.leerString();
        boolean libroEncontrado = false;

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
                libroEncontrado = true;
                break;
            }
        }
        
        if (!libroEncontrado) {
            System.out.println("El libro que has seleccionado no existe o no está disponible");
        }
    }

    public void devolverLibro(Libro [] libros) throws InterruptedException {   

        System.out.println("Introduce el título del libro que quieres devolver: ");
        String inputTitulo = EntradaDatos.leerString();
        boolean libroEncontrado = false;

        for (int i = 0; i < libros.length; i++) {
            if (inputTitulo.equals(libros[i].getTitulo())) {
                System.out.println("Libro encontrado, gestionando devolución...");
                Thread.sleep(1000);
                if (libros[i].getNumEjemplares() > 0) {
                    int tempEjemplares = libros[i].getNumEjemplares() + 1;
                    libros[i].setNumEjemplares(tempEjemplares);
                    System.out.println(
                            "Devolución realizada. Actualmente hay " + libros[i].getNumEjemplares() + " ejemplares");
                } 
                
                libroEncontrado = true;
                break;
            }
        }

    }

    public void eliminarLibro(Libro [] libros) throws InterruptedException {   
        // Buscar por título, introducir ISBN para verificar la eliminación del libro, setear la posición seleccionada a null.
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el título del libro a eliminar:  ");
        String inputTitulo = sc.nextLine();

        try {
            for (int i = 0; i < libros.length; i++) {
                if(inputTitulo.equals(libros[i].getTitulo())) {
                    System.out.println("Libro encontrado, gestionando eliminación...");
                    Thread.sleep(1000);
                    System.out.println("Para confirmar el borrado del libro, introduce su ISBN: ");
                    long inputISBN = sc.nextLong();
                    if(inputISBN == libros[i].getCodigoISBN()) {
                        libros[i] = null; 
                        System.out.println("Libro eliminado correctamente");
                    }
                }
            }  
        } catch (NullPointerException e) {
            System.out.println(" ");
        }
    }

}
