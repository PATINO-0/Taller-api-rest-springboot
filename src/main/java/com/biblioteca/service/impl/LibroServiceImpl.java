package com.biblioteca.service.impl; // Paquete que contiene las implementaciones de la capa de servicio.

import com.biblioteca.dto.LibroRequest; // Importa el DTO de entrada para libros.
import com.biblioteca.dto.LibroResponse; // Importa el DTO de salida para libros.
import com.biblioteca.model.Libro; // Importa el modelo Libro usado para MongoDB.
import com.biblioteca.repository.LibroRepository; // Importa el repositorio que comunica con MongoDB.
import com.biblioteca.service.LibroService; // Importa la interfaz que esta clase implementa.
import org.springframework.stereotype.Service; // Importa la anotación que marca esta clase como servicio.
import java.util.List; // Importa la lista usada para devolver varios libros.
import java.util.stream.Collectors; // Importa el recolector usado para convertir listas.

@Service // Indica que esta clase pertenece a la capa de lógica de negocio.
public class LibroServiceImpl implements LibroService { // Implementa las operaciones del flujo de libros.

    private final LibroRepository libroRepository; // Guarda la dependencia del repositorio de libros.

    public LibroServiceImpl(LibroRepository libroRepository) { // Constructor usado por Spring para inyectar el repositorio.
        this.libroRepository = libroRepository; // Asigna el repositorio recibido a la variable de la clase.
    } // Fin del constructor.

    @Override // Indica que este método implementa una operación definida en la interfaz.
    public LibroResponse createBook(LibroRequest request) { // Crea un nuevo libro con los datos recibidos.
        Libro libro = new Libro(); // Crea una nueva instancia del modelo Libro.
        libro.setIsbn(request.getIsbn()); // Copia el ISBN desde el DTO hacia el modelo.
        libro.setTitle(request.getTitle()); // Copia el título desde el DTO hacia el modelo.
        libro.setAuthor(request.getAuthor()); // Copia el autor desde el DTO hacia el modelo.
        libro.setPublicationYear(request.getPublicationYear()); // Copia el año de publicación desde el DTO hacia el modelo.
        libro.setCategory(request.getCategory()); // Copia la categoría desde el DTO hacia el modelo.
        Libro savedBook = libroRepository.save(libro); // Guarda el libro en MongoDB y obtiene el documento con ID.
        return mapToResponse(savedBook); // Convierte el modelo guardado en DTO de respuesta.
    } // Fin del método createBook.

    @Override // Indica que este método implementa una operación definida en la interfaz.
    public LibroResponse updateBook(String id, LibroRequest request) { // Actualiza un libro existente con los datos recibidos.
        Libro libro = libroRepository.findById(id) // Busca el libro en MongoDB por su ID.
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado con id: " + id)); // Lanza un mensaje en español si no existe.
        libro.setIsbn(request.getIsbn()); // Actualiza el ISBN del libro.
        libro.setTitle(request.getTitle()); // Actualiza el título del libro.
        libro.setAuthor(request.getAuthor()); // Actualiza el autor del libro.
        libro.setPublicationYear(request.getPublicationYear()); // Actualiza el año de publicación del libro.
        libro.setCategory(request.getCategory()); // Actualiza la categoría del libro.
        Libro updatedBook = libroRepository.save(libro); // Guarda los cambios en MongoDB.
        return mapToResponse(updatedBook); // Convierte el modelo actualizado en DTO de respuesta.
    } // Fin del método updateBook.

    @Override // Indica que este método implementa una operación definida en la interfaz.
    public void deleteBook(String id) { // Elimina un libro existente por su ID.
        if (!libroRepository.existsById(id)) { // Verifica si el libro existe antes de eliminarlo.
            throw new IllegalArgumentException("Libro no encontrado con id: " + id); // Lanza un mensaje en español si el libro no existe.
        } // Fin de la validación de existencia.
        libroRepository.deleteById(id); // Elimina el libro desde MongoDB.
    } // Fin del método deleteBook.

    @Override // Indica que este método implementa una operación definida en la interfaz.
    public LibroResponse getBookById(String id) { // Consulta un libro por su ID.
        Libro libro = libroRepository.findById(id) // Busca el libro en MongoDB por su ID.
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado con id: " + id)); // Lanza un mensaje en español si no existe.
        return mapToResponse(libro); // Convierte el modelo encontrado en DTO de respuesta.
    } // Fin del método getBookById.

    @Override // Indica que este método implementa una operación definida en la interfaz.
    public List<LibroResponse> getAllBooks() { // Consulta todos los libros registrados.
        return libroRepository.findAll() // Obtiene todos los documentos Libro desde MongoDB.
                .stream() // Convierte la lista en un flujo para transformarla.
                .map(this::mapToResponse) // Convierte cada modelo Libro en DTO LibroResponse.
                .collect(Collectors.toList()); // Recolecta los DTOs en una lista final.
    } // Fin del método getAllBooks.

    private LibroResponse mapToResponse(Libro libro) { // Convierte un modelo Libro en un DTO de respuesta.
        return new LibroResponse( // Crea y retorna un nuevo DTO con los datos del modelo.
                libro.getId(), // Envía el identificador del libro.
                libro.getIsbn(), // Envía el ISBN del libro.
                libro.getTitle(), // Envía el título del libro.
                libro.getAuthor(), // Envía el autor del libro.
                libro.getPublicationYear(), // Envía el año de publicación del libro.
                libro.getCategory() // Envía la categoría del libro.
        ); // Fin de la creación del DTO de respuesta.
    } // Fin del método auxiliar mapToResponse.
} // Fin de la clase LibroServiceImpl.
