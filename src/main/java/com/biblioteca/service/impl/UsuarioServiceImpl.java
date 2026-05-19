package com.biblioteca.service.impl; // Paquete que contiene las implementaciones de la capa de servicio.

import com.biblioteca.dto.UsuarioRequest; // Importa el DTO de entrada para usuarios.
import com.biblioteca.dto.UsuarioResponse; // Importa el DTO de salida para usuarios.
import com.biblioteca.model.Usuario; // Importa el modelo Usuario usado para MongoDB.
import com.biblioteca.repository.UsuarioRepository; // Importa el repositorio que comunica con MongoDB.
import com.biblioteca.service.UsuarioService; // Importa la interfaz que esta clase implementa.
import org.springframework.stereotype.Service; // Importa la anotación que marca esta clase como servicio.
import java.util.List; // Importa la lista usada para devolver varios usuarios.
import java.util.stream.Collectors; // Importa el recolector usado para convertir listas.

@Service // Indica que esta clase pertenece a la capa de lógica de negocio.
public class UsuarioServiceImpl implements UsuarioService { // Implementa las operaciones del flujo de usuarios.

    private final UsuarioRepository usuarioRepository; // Guarda la dependencia del repositorio de usuarios.

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) { // Constructor usado por Spring para inyectar el repositorio.
        this.usuarioRepository = usuarioRepository; // Asigna el repositorio recibido a la variable de la clase.
    } // Fin del constructor.

    @Override // Indica que este método implementa una operación definida en la interfaz.
    public UsuarioResponse createUser(UsuarioRequest request) { // Crea un nuevo usuario con los datos recibidos.
        Usuario usuario = new Usuario(); // Crea una nueva instancia del modelo Usuario.
        usuario.setName(request.getName()); // Copia el nombre desde el DTO hacia el modelo.
        usuario.setEmail(request.getEmail()); // Copia el correo desde el DTO hacia el modelo.
        usuario.setUserType(request.getUserType()); // Copia el tipo de usuario desde el DTO hacia el modelo.
        Usuario savedUser = usuarioRepository.save(usuario); // Guarda el usuario en MongoDB y obtiene el documento con ID.
        return mapToResponse(savedUser); // Convierte el modelo guardado en DTO de respuesta.
    } // Fin del método createUser.

    @Override // Indica que este método implementa una operación definida en la interfaz.
    public UsuarioResponse updateUser(String id, UsuarioRequest request) { // Actualiza un usuario existente con los datos recibidos.
        Usuario usuario = usuarioRepository.findById(id) // Busca el usuario en MongoDB por su ID.
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id)); // Lanza un mensaje en español si no existe.
        usuario.setName(request.getName()); // Actualiza el nombre del usuario.
        usuario.setEmail(request.getEmail()); // Actualiza el correo del usuario.
        usuario.setUserType(request.getUserType()); // Actualiza el tipo de usuario.
        Usuario updatedUser = usuarioRepository.save(usuario); // Guarda los cambios en MongoDB.
        return mapToResponse(updatedUser); // Convierte el modelo actualizado en DTO de respuesta.
    } // Fin del método updateUser.

    @Override // Indica que este método implementa una operación definida en la interfaz.
    public void deleteUser(String id) { // Elimina un usuario existente por su ID.
        if (!usuarioRepository.existsById(id)) { // Verifica si el usuario existe antes de eliminarlo.
            throw new IllegalArgumentException("Usuario no encontrado con id: " + id); // Lanza un mensaje en español si el usuario no existe.
        } // Fin de la validación de existencia.
        usuarioRepository.deleteById(id); // Elimina el usuario desde MongoDB.
    } // Fin del método deleteUser.

    @Override // Indica que este método implementa una operación definida en la interfaz.
    public UsuarioResponse getUserById(String id) { // Consulta un usuario por su ID.
        Usuario usuario = usuarioRepository.findById(id) // Busca el usuario en MongoDB por su ID.
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id)); // Lanza un mensaje en español si no existe.
        return mapToResponse(usuario); // Convierte el modelo encontrado en DTO de respuesta.
    } // Fin del método getUserById.

    @Override // Indica que este método implementa una operación definida en la interfaz.
    public List<UsuarioResponse> getAllUsers() { // Consulta todos los usuarios registrados.
        return usuarioRepository.findAll() // Obtiene todos los documentos Usuario desde MongoDB.
                .stream() // Convierte la lista en un flujo para transformarla.
                .map(this::mapToResponse) // Convierte cada modelo Usuario en DTO UsuarioResponse.
                .collect(Collectors.toList()); // Recolecta los DTOs en una lista final.
    } // Fin del método getAllUsers.

    private UsuarioResponse mapToResponse(Usuario usuario) { // Convierte un modelo Usuario en un DTO de respuesta.
        return new UsuarioResponse( // Crea y retorna un nuevo DTO con los datos del modelo.
                usuario.getId(), // Envía el identificador del usuario.
                usuario.getName(), // Envía el nombre del usuario.
                usuario.getEmail(), // Envía el correo electrónico del usuario.
                usuario.getUserType() // Envía el tipo de usuario.
        ); // Fin de la creación del DTO de respuesta.
    } // Fin del método auxiliar mapToResponse.
} // Fin de la clase UsuarioServiceImpl.
