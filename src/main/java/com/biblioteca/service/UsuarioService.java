package com.biblioteca.service; // Paquete que contiene las interfaces de la capa de servicio.

import com.biblioteca.dto.UsuarioRequest; // Importa el DTO de entrada para usuarios.
import com.biblioteca.dto.UsuarioResponse; // Importa el DTO de salida para usuarios.
import java.util.List; // Importa la lista usada para devolver varios usuarios.

public interface UsuarioService { // Define el contrato de operaciones del flujo de usuarios.

    UsuarioResponse createUser(UsuarioRequest request); // Crea un nuevo usuario a partir de los datos recibidos.

    UsuarioResponse updateUser(String id, UsuarioRequest request); // Actualiza un usuario existente usando su identificador.

    void deleteUser(String id); // Elimina un usuario existente usando su identificador.

    UsuarioResponse getUserById(String id); // Consulta un usuario específico usando su identificador.

    List<UsuarioResponse> getAllUsers(); // Lista todos los usuarios registrados en la base de datos.
} // Fin de la interfaz UsuarioService.
