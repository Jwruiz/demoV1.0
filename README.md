# Demo Version 1.0

Este proyecto es una aplicación backend desarrollada con **Java** y **Spring Boot**, que implementa un sistema básico de login y autenticación utilizando **JWT**. Está pensado para escalarse en el futuro hacia una arquitectura de **microservicios**.

##  🚀 Características principales

- Autenticación y autorización con **JSON Web Tokens (JWT)**
- Gestión de usuarios con **Spring Security**
- Persistencia de datos con **Spring Data JPA** y **Hibernate**
- Base de datos **MySQL**
- Documentación de API generada con **Swagger/OpenAPI**

##  🛠️ Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- JWT
- Swagger / Springdoc OpenAPI

## ⚙️ Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- [Java JDK 17 o superior](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/) 
- [MySQL](https://www.mysql.com/) y una base de datos creada

## 📄 Documentación de la API
Una vez levantado el servidor, puedes acceder a la documentación Swagger en:
http://localhost:8080/swagger-ui/index.html

## 🔒 Seguridad
Los endpoints están protegidos mediante JWT.

Se requiere autenticación para acceder a rutas privadas.

El token debe enviarse en la cabecera Authorization: Bearer <token>.

## 📈 Futuras mejoras
Escalamiento a arquitectura de microservicios

Implementación de roles y permisos más complejos

Registro de usuarios

Pruebas automatizadas

Despliegue en la nube (Docker, Kubernetes, etc.)

## 👨‍💻 Autor
Desarrollado por Jeheremi Ruiz



