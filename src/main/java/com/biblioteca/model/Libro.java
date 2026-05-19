package com.biblioteca.model; // Paquete que contiene los modelos de MongoDB.

import org.springframework.data.annotation.Id; // Importa la anotación para identificar el campo ID.
import org.springframework.data.mongodb.core.mapping.Document; // Importa la anotación para mapear una colección MongoDB.
import org.springframework.data.mongodb.core.mapping.Field; // Importa la anotación para definir nombres de campos en MongoDB.

@Document(collection = "libros") // Indica que esta clase se guarda en la colección libros.
public class Libro { // Modelo que representa un libro dentro de la biblioteca.

    @Id // Marca este atributo como identificador único del documento.
    private String id; // Guarda el identificador generado por MongoDB.

    @Field("isbn") // Guarda este atributo en MongoDB con el nombre isbn.
    private String isbn; // Guarda el código ISBN del libro.

    @Field("titulo") // Guarda este atributo en MongoDB con el nombre titulo.
    private String title; // Guarda el título del libro.

    @Field("autor") // Guarda este atributo en MongoDB con el nombre autor.
    private String author; // Guarda el autor del libro.

    @Field("anioPublicacion") // Guarda este atributo en MongoDB con el nombre anioPublicacion.
    private Integer publicationYear; // Guarda el año de publicación del libro.

    @Field("categoria") // Guarda este atributo en MongoDB con el nombre categoria.
    private String category; // Guarda la categoría del libro.

    public Libro() { // Constructor vacío requerido por Spring Data MongoDB.
    } // Fin del constructor vacío.

    public Libro(String id, String isbn, String title, String author, Integer publicationYear, String category) { // Constructor con todos los atributos del libro.
        this.id = id; // Asigna el identificador del libro.
        this.isbn = isbn; // Asigna el ISBN del libro.
        this.title = title; // Asigna el título del libro.
        this.author = author; // Asigna el autor del libro.
        this.publicationYear = publicationYear; // Asigna el año de publicación del libro.
        this.category = category; // Asigna la categoría del libro.
    } // Fin del constructor completo.

    public String getId() { // Obtiene el identificador del libro.
        return id; // Retorna el identificador del libro.
    } // Fin del getter del identificador.

    public void setId(String id) { // Actualiza el identificador del libro.
        this.id = id; // Asigna el nuevo identificador del libro.
    } // Fin del setter del identificador.

    public String getIsbn() { // Obtiene el ISBN del libro.
        return isbn; // Retorna el ISBN del libro.
    } // Fin del getter del ISBN.

    public void setIsbn(String isbn) { // Actualiza el ISBN del libro.
        this.isbn = isbn; // Asigna el nuevo ISBN del libro.
    } // Fin del setter del ISBN.

    public String getTitle() { // Obtiene el título del libro.
        return title; // Retorna el título del libro.
    } // Fin del getter del título.

    public void setTitle(String title) { // Actualiza el título del libro.
        this.title = title; // Asigna el nuevo título del libro.
    } // Fin del setter del título.

    public String getAuthor() { // Obtiene el autor del libro.
        return author; // Retorna el autor del libro.
    } // Fin del getter del autor.

    public void setAuthor(String author) { // Actualiza el autor del libro.
        this.author = author; // Asigna el nuevo autor del libro.
    } // Fin del setter del autor.

    public Integer getPublicationYear() { // Obtiene el año de publicación del libro.
        return publicationYear; // Retorna el año de publicación del libro.
    } // Fin del getter del año de publicación.

    public void setPublicationYear(Integer publicationYear) { // Actualiza el año de publicación del libro.
        this.publicationYear = publicationYear; // Asigna el nuevo año de publicación del libro.
    } // Fin del setter del año de publicación.

    public String getCategory() { // Obtiene la categoría del libro.
        return category; // Retorna la categoría del libro.
    } // Fin del getter de la categoría.

    public void setCategory(String category) { // Actualiza la categoría del libro.
        this.category = category; // Asigna la nueva categoría del libro.
    } // Fin del setter de la categoría.
} // Fin del modelo Libro.
