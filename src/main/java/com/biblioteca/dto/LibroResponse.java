package com.biblioteca.dto; // Paquete que contiene los objetos de transferencia de datos.

import com.fasterxml.jackson.annotation.JsonProperty; // Importa la anotación para definir nombres JSON en español.

public class LibroResponse { // DTO que representa los datos devueltos por la API para un libro.

    @JsonProperty("id") // Define que el campo JSON se llama id.
    private String id; // Guarda el identificador del libro.

    @JsonProperty("isbn") // Define que el campo JSON se llama isbn.
    private String isbn; // Guarda el ISBN del libro.

    @JsonProperty("titulo") // Define que el campo JSON se llama titulo.
    private String title; // Guarda el título del libro.

    @JsonProperty("autor") // Define que el campo JSON se llama autor.
    private String author; // Guarda el autor del libro.

    @JsonProperty("anioPublicacion") // Define que el campo JSON se llama anioPublicacion.
    private Integer publicationYear; // Guarda el año de publicación del libro.

    @JsonProperty("categoria") // Define que el campo JSON se llama categoria.
    private String category; // Guarda la categoría del libro.

    public LibroResponse() { // Constructor vacío requerido para serializar respuestas JSON.
    } // Fin del constructor vacío.

    public LibroResponse(String id, String isbn, String title, String author, Integer publicationYear, String category) { // Constructor con todos los datos de salida.
        this.id = id; // Asigna el identificador del libro.
        this.isbn = isbn; // Asigna el ISBN del libro.
        this.title = title; // Asigna el título del libro.
        this.author = author; // Asigna el autor del libro.
        this.publicationYear = publicationYear; // Asigna el año de publicación del libro.
        this.category = category; // Asigna la categoría del libro.
    } // Fin del constructor completo.

    public String getId() { // Obtiene el identificador del DTO.
        return id; // Retorna el identificador del libro.
    } // Fin del getter del identificador.

    public void setId(String id) { // Actualiza el identificador del DTO.
        this.id = id; // Asigna el identificador del libro.
    } // Fin del setter del identificador.

    public String getIsbn() { // Obtiene el ISBN del DTO.
        return isbn; // Retorna el ISBN del libro.
    } // Fin del getter del ISBN.

    public void setIsbn(String isbn) { // Actualiza el ISBN del DTO.
        this.isbn = isbn; // Asigna el ISBN del libro.
    } // Fin del setter del ISBN.

    public String getTitle() { // Obtiene el título del DTO.
        return title; // Retorna el título del libro.
    } // Fin del getter del título.

    public void setTitle(String title) { // Actualiza el título del DTO.
        this.title = title; // Asigna el título del libro.
    } // Fin del setter del título.

    public String getAuthor() { // Obtiene el autor del DTO.
        return author; // Retorna el autor del libro.
    } // Fin del getter del autor.

    public void setAuthor(String author) { // Actualiza el autor del DTO.
        this.author = author; // Asigna el autor del libro.
    } // Fin del setter del autor.

    public Integer getPublicationYear() { // Obtiene el año de publicación del DTO.
        return publicationYear; // Retorna el año de publicación del libro.
    } // Fin del getter del año de publicación.

    public void setPublicationYear(Integer publicationYear) { // Actualiza el año de publicación del DTO.
        this.publicationYear = publicationYear; // Asigna el año de publicación del libro.
    } // Fin del setter del año de publicación.

    public String getCategory() { // Obtiene la categoría del DTO.
        return category; // Retorna la categoría del libro.
    } // Fin del getter de la categoría.

    public void setCategory(String category) { // Actualiza la categoría del DTO.
        this.category = category; // Asigna la categoría del libro.
    } // Fin del setter de la categoría.
} // Fin del DTO LibroResponse.
