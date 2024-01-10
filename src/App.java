import java.util.NoSuchElementException;

public class App {
    public static void main(String[] args) throws Exception {

        Biblioteca[] bibliotecas = new Biblioteca[2];

        Libro[] librosB1 = new Libro[10];
        Libro[] librosB2 = new Libro[10];

        Biblioteca b1 = new Biblioteca("Isaac Albeniz", "Avenida de las Lagunas s/n", librosB1);
        Biblioteca b2 = new Biblioteca("Gloria Fuertes", "Calle Isabel II s/n", librosB2);

        bibliotecas[0] = b1;
        bibliotecas[1] = b2;

        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, 9780307474728L, 2);
        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, 9780156013925L, 3);
        Libro libro3 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 1997, 9788478884455L, 4);
        Libro libro4 = new Libro("1984", "George Orwell", 1949, 9788423342477L, 2);
        Libro libro5 = new Libro("El código Da Vinci", "Dan Brown", 2003, 9788495618600L, 5);
        Libro libro6 = new Libro("Orgullo y prejuicio", "Jane Austen", 1813, 9788491052425L, 1);

        librosB1[0] = libro1;
        librosB1[1] = libro2;
        librosB1[2] = libro3;

        librosB2[0] = libro4;
        librosB2[1] = libro5;
        librosB2[2] = libro6;

        int optionSelector = 0;

        do {
            System.out.println(
                    "GESTOR DE BIBLIOTECAS \n [1]. Sacar un libro de una biblioteca \n [2]. Devolver un libro de una biblioteca \n [3]. Introducir libro nuevo en una biblioteca \n [4]. Eliminar un libro de una biblioteca \n [5]. Consultar número de libros de una biblioteca");

            try {
                optionSelector = EntradaDatos.leerEntero();
            } catch (NoSuchElementException e) {
                System.out.println("Opción aún en desarollo...");
                optionSelector = 0; // O establecer un valor predeterminado para evitar bucles infinitos
            }

            switch (optionSelector) {
                case 1:
                    b1.anadirLibros(); // Las opciones asignadas aquí no corresponden con las del menú 
                    break;
                case 2:
                    b1.buscarLibrosAutor();
                    break;
                case 3:
                    // Opción 3
                    break;
                case 4:
                    // Opción 4
                    break;
                case 5:
                    // Opción 5
                    System.out.println(
                            "Selecciona una biblioteca: \n" + "1. " + b1.getNombre() + "\n" + "2. " + b2.getNombre());

                    int selectorBiblioteca = 0;

                    try {
                        selectorBiblioteca = EntradaDatos.leerEntero();
                    } catch (NoSuchElementException e) {
                        System.out.println("Error al leer la entrada del usuario: " + e.getMessage());
                        selectorBiblioteca = 0; // O establecer un valor predeterminado para evitar bucles infinitos
                    }

                    if (selectorBiblioteca == 1) {
                        b1.consultarEjemplares();
                    } else if (selectorBiblioteca == 2) {
                        b2.consultarEjemplares();
                    } else {
                        System.out.println("La biblioteca seleccionada no existe");
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción seleccionada no válida");
                    break;
            }

        } while (optionSelector != 6);

    }

}
