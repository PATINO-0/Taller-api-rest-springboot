package com.biblioteca.model; // Paquete que contiene los modelos de MongoDB.

import org.springframework.data.annotation.Id; // Importa la anotación para identificar el campo ID.
import org.springframework.data.mongodb.core.mapping.Document; // Importa la anotación para mapear una colección MongoDB.
import org.springframework.data.mongodb.core.mapping.Field; // Importa la anotación para definir nombres de campos en MongoDB.

@Document(collection = "usuarios") // Indica que esta clase se guarda en la colección usuarios.
public class Usuario { // Modelo que representa un usuario del sistema de biblioteca.

    @Id // Marca este atributo como identificador único del documento.
    private String id; // Guarda el identificador generado por MongoDB.

    @Field("nombre") // Guarda este atributo en MongoDB con el nombre nombre.
    private String name; // Guarda el nombre del usuario.

    @Field("correo") // Guarda este atributo en MongoDB con el nombre correo.
    private String email; // Guarda el correo electrónico del usuario.

    @Field("tipoUsuario") // Guarda este atributo en MongoDB con el nombre tipoUsuario.
    private String userType; // Guarda el tipo de usuario dentro de la biblioteca.

    public Usuario() { // Constructor vacío requerido por Spring Data MongoDB.
    } // Fin del constructor vacío.

    public Usuario(String id, String name, String email, String userType) { // Constructor con todos los atributos del usuario.
        this.id = id; // Asigna el identificador del usuario.
        this.name = name; // Asigna el nombre del usuario.
        this.email = email; // Asigna el correo electrónico del usuario.
        this.userType = userType; // Asigna el tipo de usuario.
    } // Fin del constructor completo.

    public String getId() { // Obtiene el identificador del usuario.
        return id; // Retorna el identificador del usuario.
    } // Fin del getter del identificador.

    public void setId(String id) { // Actualiza el identificador del usuario.
        this.id = id; // Asigna el nuevo identificador del usuario.
    } // Fin del setter del identificador.

    public String getName() { // Obtiene el nombre del usuario.
        return name; // Retorna el nombre del usuario.
    } // Fin del getter del nombre.

    public void setName(String name) { // Actualiza el nombre del usuario.
        this.name = name; // Asigna el nuevo nombre del usuario.
    } // Fin del setter del nombre.

    public String getEmail() { // Obtiene el correo electrónico del usuario.
        return email; // Retorna el correo electrónico del usuario.
    } // Fin del getter del correo electrónico.

    public void setEmail(String email) { // Actualiza el correo electrónico del usuario.
        this.email = email; // Asigna el nuevo correo electrónico del usuario.
    } // Fin del setter del correo electrónico.

    public String getUserType() { // Obtiene el tipo de usuario.
        return userType; // Retorna el tipo de usuario.
    } // Fin del getter del tipo de usuario.

    public void setUserType(String userType) { // Actualiza el tipo de usuario.
        this.userType = userType; // Asigna el nuevo tipo de usuario.
    } // Fin del setter del tipo de usuario.
} // Fin del modelo Usuario.
