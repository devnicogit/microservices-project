# Proyecto de Microservicios

Este proyecto es una implementación de microservicios utilizando Spring Boot, Spring Cloud (Eureka), y H2 como base de datos en memoria. El objetivo es demostrar la creación, gestión y comunicación de microservicios, incluyendo clientes, cuentas y movimientos.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.3.2
- Spring Cloud Netflix Eureka
- Spring Data JPA
- H2 Database
- Docker

## Estructura del Proyecto

El proyecto está dividido en tres microservicios principales:

1. **cliente-persona-service**: Gestión de clientes y personas.
2. **cuenta-movimientos-service**: Gestión de cuentas y movimientos.
3. **eureka-server**: Servidor Eureka para el descubrimiento de servicios.

## Configuración de la Base de Datos
## cliente-persona-service

server.port=8081

spring.application.name=cliente-persona-service
spring.datasource.url=jdbc:h2:mem:clientedb;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

eureka.client.service-url.defaultZone=http://eureka-server:8761/eureka
eureka.instance.prefer-ip-address=true


## cuenta-movimientos-service

server.port=8082

spring.application.name=cuenta-movimientos-service
spring.datasource.url=jdbc:h2:mem:cuentadb;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

eureka.client.service-url.defaultZone=http://eureka-server:8761/eureka
eureka.instance.prefer-ip-address=true

## Ejecución del Proyecto
- Requisitos Previos
- Docker y Docker Compose instalados
- JDK 17 instalado
- Maven instalado


## Endpoints
- cliente-persona-service

- GET /clientes: Obtiene todos los clientes.
- GET /clientes/{id}: Obtiene un cliente por ID.
- POST /clientes: Crea un nuevo cliente.
- PUT /clientes/{id}: Actualiza un cliente existente.
- DELETE /clientes/{id}: Elimina un cliente por ID.

- cuenta-movimientos-service

- GET /cuentas: Obtiene todas las cuentas.
- POST /cuentas: Crea una nueva cuenta.
- PUT /cuentas/{id}: Actualiza una cuenta existente.
- DELETE /cuentas/{id}: Elimina una cuenta por ID.
- GET /movimientos: Obtiene todos los movimientos.
- POST /movimientos: Crea un nuevo movimiento.
- PUT /movimientos/{id}: Actualiza un movimiento existente.
- DELETE /movimientos/{id}: Elimina un movimiento por ID.

## Validación de Endpoints con Postman
- Importa el archivo PostmanCollection.json en Postman para probar todos los endpoints disponibles.
