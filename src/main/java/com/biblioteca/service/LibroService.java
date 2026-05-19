package com.biblioteca.service; // Paquete que contiene las interfaces de la capa de servicio.

import com.biblioteca.dto.LibroRequest; // Importa el DTO de entrada para libros.
import com.biblioteca.dto.LibroResponse; // Importa el DTO de salida para libros.
import java.util.List; // Importa la lista usada para devolver varios libros.

public interface LibroService { // Define el contrato de operaciones del flujo de libros.

    LibroResponse createBook(LibroRequest request); // Crea un nuevo libro a partir de los datos recibidos.

    LibroResponse updateBook(String id, LibroRequest request); // Actualiza un libro existente usando su identificador.

    void deleteBook(String id); // Elimina un libro existente usando su identificador.

    LibroResponse getBookById(String id); // Consulta un libro específico usando su identificador.

    List<LibroResponse> getAllBooks(); // Lista todos los libros registrados en la base de datos.
} // Fin de la interfaz LibroService.
