package com.biblioteca.controller; // Paquete que contiene los controladores REST.

import com.biblioteca.dto.LibroRequest; // Importa el DTO de entrada para libros.
import com.biblioteca.dto.LibroResponse; // Importa el DTO de salida para libros.
import com.biblioteca.service.LibroService; // Importa la interfaz de servicio para libros.
import jakarta.validation.Valid; // Importa la anotación para activar validaciones del DTO.
import org.springframework.context.support.DefaultMessageSourceResolvable; // Importa una utilidad para obtener mensajes de validación.
import org.springframework.http.HttpStatus; // Importa los códigos de estado HTTP.
import org.springframework.http.ResponseEntity; // Importa la clase para construir respuestas HTTP.
import org.springframework.web.bind.MethodArgumentNotValidException; // Importa la excepción de validación de argumentos.
import org.springframework.web.bind.annotation.DeleteMapping; // Importa la anotación para endpoints DELETE.
import org.springframework.web.bind.annotation.ExceptionHandler; // Importa la anotación para manejar errores del controlador.
import org.springframework.web.bind.annotation.GetMapping; // Importa la anotación para endpoints GET.
import org.springframework.web.bind.annotation.PathVariable; // Importa la anotación para leer variables de la URL.
import org.springframework.web.bind.annotation.PostMapping; // Importa la anotación para endpoints POST.
import org.springframework.web.bind.annotation.PutMapping; // Importa la anotación para endpoints PUT.
import org.springframework.web.bind.annotation.RequestBody; // Importa la anotación para leer el cuerpo JSON.
import org.springframework.web.bind.annotation.RequestMapping; // Importa la anotación para definir la ruta base.
import org.springframework.web.bind.annotation.RestController; // Importa la anotación para declarar un controlador REST.
import java.util.List; // Importa la lista usada para retornar varios libros.
import java.util.Map; // Importa el mapa usado para retornar mensajes simples en español.

@RestController // Declara esta clase como controlador REST que responde en formato JSON.
@RequestMapping("/api/libros") // Define la ruta base del flujo de libros.
public class LibroController { // Controlador encargado de recibir peticiones HTTP del flujo de libros.

    private final LibroService libroService; // Guarda la dependencia de la capa de servicio.

    public LibroController(LibroService libroService) { // Constructor usado por Spring para inyectar el servicio.
        this.libroService = libroService; // Asigna el servicio recibido a la variable de la clase.
    } // Fin del constructor.

    @PostMapping // Atiende peticiones POST en /api/libros.
    public ResponseEntity<LibroResponse> createBook(@Valid @RequestBody LibroRequest request) { // Crea un libro usando el JSON recibido.
        LibroResponse response = libroService.createBook(request); // Envía la solicitud a la capa de servicio.
        return ResponseEntity.status(HttpStatus.CREATED).body(response); // Retorna código 201 con el libro creado.
    } // Fin del endpoint de creación.

    @GetMapping // Atiende peticiones GET en /api/libros.
    public ResponseEntity<List<LibroResponse>> getAllBooks() { // Lista todos los libros registrados.
        List<LibroResponse> books = libroService.getAllBooks(); // Solicita todos los libros a la capa de servicio.
        return ResponseEntity.ok(books); // Retorna código 200 con la lista de libros.
    } // Fin del endpoint de listado.

    @GetMapping("/{id}") // Atiende peticiones GET en /api/libros/{id}.
    public ResponseEntity<LibroResponse> getBookById(@PathVariable String id) { // Consulta un libro usando el ID recibido por URL.
        LibroResponse response = libroService.getBookById(id); // Solicita el libro a la capa de servicio.
        return ResponseEntity.ok(response); // Retorna código 200 con el libro encontrado.
    } // Fin del endpoint de consulta por ID.

    @PutMapping("/{id}") // Atiende peticiones PUT en /api/libros/{id}.
    public ResponseEntity<LibroResponse> updateBook(@PathVariable String id, @Valid @RequestBody LibroRequest request) { // Actualiza un libro usando el ID y el JSON recibido.
        LibroResponse response = libroService.updateBook(id, request); // Envía la actualización a la capa de servicio.
        return ResponseEntity.ok(response); // Retorna código 200 con el libro actualizado.
    } // Fin del endpoint de actualización.

    @DeleteMapping("/{id}") // Atiende peticiones DELETE en /api/libros/{id}.
    public ResponseEntity<Void> deleteBook(@PathVariable String id) { // Elimina un libro usando el ID recibido por URL.
        libroService.deleteBook(id); // Solicita la eliminación a la capa de servicio.
        return ResponseEntity.noContent().build(); // Retorna código 204 sin cuerpo de respuesta.
    } // Fin del endpoint de eliminación.

    @ExceptionHandler(IllegalArgumentException.class) // Maneja errores de recursos no encontrados o reglas inválidas.
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException exception) { // Construye una respuesta de error en español.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensaje", exception.getMessage())); // Retorna código 404 con el mensaje de error.
    } // Fin del manejador de errores de negocio.

    @ExceptionHandler(MethodArgumentNotValidException.class) // Maneja errores de validación del DTO.
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) { // Construye una respuesta de validación en español.
        String message = exception.getBindingResult().getFieldErrors().stream() // Obtiene los errores de campos enviados por el cliente.
                .findFirst() // Toma el primer error encontrado para responder de forma clara.
                .map(DefaultMessageSourceResolvable::getDefaultMessage) // Extrae el mensaje definido en la anotación de validación.
                .orElse("La solicitud contiene datos inválidos."); // Usa un mensaje general si no existe detalle específico.
        return ResponseEntity.badRequest().body(Map.of("mensaje", message)); // Retorna código 400 con el mensaje de validación.
    } // Fin del manejador de errores de validación.
} // Fin del controlador LibroController.
