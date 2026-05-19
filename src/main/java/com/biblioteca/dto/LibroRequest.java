package com.biblioteca.dto; // Paquete que contiene los objetos de transferencia de datos.

import com.fasterxml.jackson.annotation.JsonProperty; // Importa la anotación para definir nombres JSON en español.
import jakarta.validation.constraints.Min; // Importa la anotación para validar valores mínimos.
import jakarta.validation.constraints.NotBlank; // Importa la anotación para validar textos obligatorios.
import jakarta.validation.constraints.NotNull; // Importa la anotación para validar valores obligatorios.

public class LibroRequest { // DTO que representa los datos recibidos para crear o actualizar un libro.

    @NotBlank(message = "El ISBN es obligatorio.") // Valida que el ISBN no esté vacío.
    @JsonProperty("isbn") // Define que el campo JSON se llama isbn.
    private String isbn; // Guarda el ISBN recibido desde la petición.

    @NotBlank(message = "El título es obligatorio.") // Valida que el título no esté vacío.
    @JsonProperty("titulo") // Define que el campo JSON se llama titulo.
    private String title; // Guarda el título recibido desde la petición.

    @NotBlank(message = "El autor es obligatorio.") // Valida que el autor no esté vacío.
    @JsonProperty("autor") // Define que el campo JSON se llama autor.
    private String author; // Guarda el autor recibido desde la petición.

    @NotNull(message = "El año de publicación es obligatorio.") // Valida que el año de publicación exista.
    @Min(value = 1, message = "El año de publicación debe ser mayor que 0.") // Valida que el año sea positivo.
    @JsonProperty("anioPublicacion") // Define que el campo JSON se llama anioPublicacion.
    private Integer publicationYear; // Guarda el año de publicación recibido desde la petición.

    @NotBlank(message = "La categoría es obligatoria.") // Valida que la categoría no esté vacía.
    @JsonProperty("categoria") // Define que el campo JSON se llama categoria.
    private String category; // Guarda la categoría recibida desde la petición.

    public LibroRequest() { // Constructor vacío requerido para convertir JSON a objeto Java.
    } // Fin del constructor vacío.

    public LibroRequest(String isbn, String title, String author, Integer publicationYear, String category) { // Constructor con todos los datos de entrada.
        this.isbn = isbn; // Asigna el ISBN recibido.
        this.title = title; // Asigna el título recibido.
        this.author = author; // Asigna el autor recibido.
        this.publicationYear = publicationYear; // Asigna el año de publicación recibido.
        this.category = category; // Asigna la categoría recibida.
    } // Fin del constructor completo.

    public String getIsbn() { // Obtiene el ISBN del DTO.
        return isbn; // Retorna el ISBN recibido.
    } // Fin del getter del ISBN.

    public void setIsbn(String isbn) { // Actualiza el ISBN del DTO.
        this.isbn = isbn; // Asigna el ISBN recibido.
    } // Fin del setter del ISBN.

    public String getTitle() { // Obtiene el título del DTO.
        return title; // Retorna el título recibido.
    } // Fin del getter del título.

    public void setTitle(String title) { // Actualiza el título del DTO.
        this.title = title; // Asigna el título recibido.
    } // Fin del setter del título.

    public String getAuthor() { // Obtiene el autor del DTO.
        return author; // Retorna el autor recibido.
    } // Fin del getter del autor.

    public void setAuthor(String author) { // Actualiza el autor del DTO.
        this.author = author; // Asigna el autor recibido.
    } // Fin del setter del autor.

    public Integer getPublicationYear() { // Obtiene el año de publicación del DTO.
        return publicationYear; // Retorna el año de publicación recibido.
    } // Fin del getter del año de publicación.

    public void setPublicationYear(Integer publicationYear) { // Actualiza el año de publicación del DTO.
        this.publicationYear = publicationYear; // Asigna el año de publicación recibido.
    } // Fin del setter del año de publicación.

    public String getCategory() { // Obtiene la categoría del DTO.
        return category; // Retorna la categoría recibida.
    } // Fin del getter de la categoría.

    public void setCategory(String category) { // Actualiza la categoría del DTO.
        this.category = category; // Asigna la categoría recibida.
    } // Fin del setter de la categoría.
} // Fin del DTO LibroRequest.
