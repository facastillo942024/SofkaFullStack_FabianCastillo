# Sistema de Liquidación de Comisiones "Sofka-Fintech"

Este proyecto consiste en un módulo financiero diseñado para procesar transacciones y liquidar comisiones de forma dinámica y asíncrona. La solución aplica principios de **Arquitectura Limpia (Clean Architecture)** y **Programación Reactiva**.

## 🚀 Arquitectura del Sistema
El sistema sigue el diseño propuesto en la prueba técnica:
* **Frontend**: Angular SPA con Material UI.
* **Backend**: Spring Boot 3.4+ con Spring WebFlux (Non-blocking).
* **Persistencia**: R2DBC con base de datos H2 (en memoria) o MySQL (XAMPP).
* **Flujos**: Reactividad de extremo a extremo (End-to-End Reactive).

## 🛠️ Requisitos Funcionales Implementados
Basado en los requerimientos del equipo de banca:
1. **Endpoint Reactivo**: Registro de transacciones mediante WebFlux.
2. **Reglas de Negocio Dinámicas**:
   * Monto > $10,000.00: Comisión del **5%**.
   * Monto <= $10,000.00: Comisión del **2%**.
3. **Persistencia**: Almacenamiento de ID, Monto, Comisión, Tipo y Fecha de Transacción.

## 💻 Stack Tecnológico
* **Java 25** (optimizado para Virtual Threads).
* **Spring Boot 3.4.1**.
* **Spring Data R2DBC**.
* **H2 Database** (entorno local de pruebas).
* **Lombok**.
* **JUnit 5 & StepVerifier** (para pruebas reactivas).

## ⚙️ Configuración y Ejecución

### Requisitos previos
* JDK 25 instalado.
* Maven 3.9+.
* (Opcional) XAMPP si se desea persistencia en MariaDB/MySQL.

### Ejecución del Backend
1. Clonar el repositorio.
2. Configurar `src/main/resources/application.properties` para usar H2 o MySQL.
3. Ejecutar el comando:

   mvn spring-boot:run