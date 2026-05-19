package com.biblioteca.dto; // Paquete que contiene los objetos de transferencia de datos.

import com.fasterxml.jackson.annotation.JsonProperty; // Importa la anotación para definir nombres JSON en español.
import jakarta.validation.constraints.Email; // Importa la anotación para validar correos electrónicos.
import jakarta.validation.constraints.NotBlank; // Importa la anotación para validar textos obligatorios.

public class UsuarioRequest { // DTO que representa los datos recibidos para crear o actualizar un usuario.

    @NotBlank(message = "El nombre es obligatorio.") // Valida que el nombre no esté vacío.
    @JsonProperty("nombre") // Define que el campo JSON se llama nombre.
    private String name; // Guarda el nombre recibido desde la petición.

    @NotBlank(message = "El correo es obligatorio.") // Valida que el correo no esté vacío.
    @Email(message = "El correo debe tener un formato válido.") // Valida que el correo tenga formato de email.
    @JsonProperty("correo") // Define que el campo JSON se llama correo.
    private String email; // Guarda el correo recibido desde la petición.

    @NotBlank(message = "El tipo de usuario es obligatorio.") // Valida que el tipo de usuario no esté vacío.
    @JsonProperty("tipoUsuario") // Define que el campo JSON se llama tipoUsuario.
    private String userType; // Guarda el tipo de usuario recibido desde la petición.

    public UsuarioRequest() { // Constructor vacío requerido para convertir JSON a objeto Java.
    } // Fin del constructor vacío.

    public UsuarioRequest(String name, String email, String userType) { // Constructor con todos los datos de entrada.
        this.name = name; // Asigna el nombre recibido.
        this.email = email; // Asigna el correo recibido.
        this.userType = userType; // Asigna el tipo de usuario recibido.
    } // Fin del constructor completo.

    public String getName() { // Obtiene el nombre del DTO.
        return name; // Retorna el nombre recibido.
    } // Fin del getter del nombre.

    public void setName(String name) { // Actualiza el nombre del DTO.
        this.name = name; // Asigna el nombre recibido.
    } // Fin del setter del nombre.

    public String getEmail() { // Obtiene el correo del DTO.
        return email; // Retorna el correo recibido.
    } // Fin del getter del correo.

    public void setEmail(String email) { // Actualiza el correo del DTO.
        this.email = email; // Asigna el correo recibido.
    } // Fin del setter del correo.

    public String getUserType() { // Obtiene el tipo de usuario del DTO.
        return userType; // Retorna el tipo de usuario recibido.
    } // Fin del getter del tipo de usuario.

    public void setUserType(String userType) { // Actualiza el tipo de usuario del DTO.
        this.userType = userType; // Asigna el tipo de usuario recibido.
    } // Fin del setter del tipo de usuario.
} // Fin del DTO UsuarioRequest.
