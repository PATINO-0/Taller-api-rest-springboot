package com.biblioteca; // Paquete raíz de la aplicación.

import org.springframework.boot.SpringApplication; // Importa la clase que inicia Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación principal de Spring Boot.

@SpringBootApplication // Marca esta clase como punto de arranque y configuración automática.
public class BibliotecaApiApplication { // Clase principal de la API REST.

    public static void main(String[] args) { // Método principal que ejecuta la aplicación.
        SpringApplication.run(BibliotecaApiApplication.class, args); // Inicia el servidor embebido y carga el contexto de Spring.
    } // Fin del método principal.
} // Fin de la clase principal.
