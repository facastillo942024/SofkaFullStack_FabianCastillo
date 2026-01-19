Sistema de Liquidación de Comisiones - Frontend

Este proyecto es una aplicación web desarrollada en Angular 19 que permite registrar transacciones financieras y visualizar un dashboard de comisiones procesadas en tiempo real.

🚀 Requisitos Funcionales Cumplidos:

Formulario Reactivo: Implementado con validaciones de monto (mínimo 1) y selección de tipo de transacción (BASE/PREMIUM).

Dashboard en Tiempo Real: Visualización dinámica de los datos procesados mediante una tabla de Angular Material.

Integración con Backend: Consumo de API REST/Reactiva para persistencia y cálculo de comisiones.

Visualización de Datos: La tabla muestra los 4 campos clave: ID, Monto, Comisión Calculada y Fecha de Transacción.

🛠️ Tecnologías Utilizadas:

Angular (Standalone Components): Estructura moderna sin NgModules para mayor eficiencia.

Angular Material: Interfaz profesional basada en Material Design.

Reactive Forms: Manejo robusto de validaciones en el lado del cliente.

HttpClient: Comunicación asíncrona con el servicio de Spring Boot.

📋 Estructura de Datos (DTO):

El sistema maneja la siguiente interfaz para asegurar la integridad de la información:

id: Identificador único generado por el sistema.

amount: Monto original de la transacción.

commission: Valor calculado por el backend (2% para PREMIUM, 5% para BASE).

transactionDate: Fecha y hora exacta del procesamiento.

⚙️ Configuración e Instalación

Instalar dependencias:

Bash
npm install
Instalar Angular Animations (Necesario para los componentes de Material):

Bash
npm install @angular/animations@latest
Ejecutar la aplicación:

Bash
npm start
La aplicación estará disponible en http://localhost:4200.

🖥️ Arquitectura del Proyecto

main.ts: Punto de entrada que inicializa la aplicación con AppComponent.

app.config.ts: Configuración global de proveedores como provideHttpClient() y provideAnimations().

transaction.ts: Componente principal que contiene la lógica de negocio, validaciones y llamadas al API.

transaction.html: Plantilla que utiliza mat-card, mat-form-field y mat-table para la interfaz de usuario.

Nota sobre CORS: Asegúrese de que el backend en http://localhost:8080 tenga habilitado el acceso para el origen http://localhost:4200 para permitir el flujo de datos al Dashboard.