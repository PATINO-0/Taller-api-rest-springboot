package com.biblioteca.dto; // Paquete que contiene los objetos de transferencia de datos.

import com.fasterxml.jackson.annotation.JsonProperty; // Importa la anotación para definir nombres JSON en español.

public class UsuarioResponse { // DTO que representa los datos devueltos por la API para un usuario.

    @JsonProperty("id") // Define que el campo JSON se llama id.
    private String id; // Guarda el identificador del usuario.

    @JsonProperty("nombre") // Define que el campo JSON se llama nombre.
    private String name; // Guarda el nombre del usuario.

    @JsonProperty("correo") // Define que el campo JSON se llama correo.
    private String email; // Guarda el correo electrónico del usuario.

    @JsonProperty("tipoUsuario") // Define que el campo JSON se llama tipoUsuario.
    private String userType; // Guarda el tipo de usuario.

    public UsuarioResponse() { // Constructor vacío requerido para serializar respuestas JSON.
    } // Fin del constructor vacío.

    public UsuarioResponse(String id, String name, String email, String userType) { // Constructor con todos los datos de salida.
        this.id = id; // Asigna el identificador del usuario.
        this.name = name; // Asigna el nombre del usuario.
        this.email = email; // Asigna el correo electrónico del usuario.
        this.userType = userType; // Asigna el tipo de usuario.
    } // Fin del constructor completo.

    public String getId() { // Obtiene el identificador del DTO.
        return id; // Retorna el identificador del usuario.
    } // Fin del getter del identificador.

    public void setId(String id) { // Actualiza el identificador del DTO.
        this.id = id; // Asigna el identificador del usuario.
    } // Fin del setter del identificador.

    public String getName() { // Obtiene el nombre del DTO.
        return name; // Retorna el nombre del usuario.
    } // Fin del getter del nombre.

    public void setName(String name) { // Actualiza el nombre del DTO.
        this.name = name; // Asigna el nombre del usuario.
    } // Fin del setter del nombre.

    public String getEmail() { // Obtiene el correo del DTO.
        return email; // Retorna el correo electrónico del usuario.
    } // Fin del getter del correo.

    public void setEmail(String email) { // Actualiza el correo del DTO.
        this.email = email; // Asigna el correo electrónico del usuario.
    } // Fin del setter del correo.

    public String getUserType() { // Obtiene el tipo de usuario del DTO.
        return userType; // Retorna el tipo de usuario.
    } // Fin del getter del tipo de usuario.

    public void setUserType(String userType) { // Actualiza el tipo de usuario del DTO.
        this.userType = userType; // Asigna el tipo de usuario.
    } // Fin del setter del tipo de usuario.
} // Fin del DTO UsuarioResponse.
