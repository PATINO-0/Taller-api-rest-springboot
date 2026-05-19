package com.biblioteca.repository; // Paquete que contiene los repositorios de acceso a datos.

import com.biblioteca.model.Libro; // Importa el modelo Libro que será administrado por el repositorio.
import org.springframework.data.mongodb.repository.MongoRepository; // Importa la interfaz base para operaciones CRUD en MongoDB.
import org.springframework.stereotype.Repository; // Importa la anotación que marca esta interfaz como repositorio.

@Repository // Indica que esta interfaz pertenece a la capa de acceso a datos.
public interface LibroRepository extends MongoRepository<Libro, String> { // Repositorio que administra documentos Libro con ID de tipo String.
} // Fin del repositorio LibroRepository.
