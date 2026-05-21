# Documentación Técnica del Proyecto KALIJ

## 1. Introducción del proyecto

* **Nombre del proyecto:** Proyecto Integrador KALIJ (`PI_KALIJ_-2526`)
* **Objetivo de la aplicación:** Software Central de Gestión Corporativa (ERP básico). El sistema está diseñado para controlar y organizar internamente la información esencial de la compañía en plena expansión.
* **Problema que resuelve:** Caos y desorganización en la gestión interna de la empresa. Soluciona el registro y control sobre qué empleados pertenecen a qué departamentos, qué dispositivos de hardware tienen asignados (con su IP y MAC), y permite realizar el seguimiento integral de las incidencias técnicas (asignación, alta, cierre y resolución).
* **Público objetivo:** Equipo directivo, Departamento de Sistemas (IT) y Recursos Humanos (RRHH).

## 2. Tecnologías utilizadas

* **Frontend / Interfaz:** Consola de texto interactiva (CLI) gestionada mediante `java.util.Scanner` e impresiones estándar (`System.out.println`).
* **Backend:** Java 21 estructurado bajo el gestor de dependencias Maven.
* **Base de datos:** PostgreSQL, persistencia de datos relacional.
* **Infraestructura o hosting:** Base de datos alojada en la plataforma en la nube **Supabase**.
* **Librerías externas:**
  * Conector JDBC de PostgreSQL (`org.postgresql:postgresql:42.7.11`) para conectividad.
  * `dotenv-java` (`io.github.cdimascio:dotenv-java`) para la gestión segura de variables de entorno y credenciales.

## 3. Arquitectura del sistema

* **Explicación general:** La aplicación sigue un patrón de diseño arquitectónico enfocado en la separación de responsabilidades y orientado a objetos (POO). El punto de entrada centraliza la vista y navegación por consola, conectando las peticiones del usuario con el backend.
* **Componentes principales:**
  * **Modelos de Datos (POJO):** Clases puras (`Empleado`, `Dispositivo`, `Incidencia`, `Departamento`, `Ubicacion`, `Usuario`) que representan las entidades del sistema de forma orientada a objetos.
  * **Capa de Acceso a Datos (DAO):** Implementación del patrón Data Access Object para separar la lógica de base de datos de la lógica de negocio. Realiza todas las operaciones de mantenimiento y persistencia (CRUD).
  * **Conexión Central (`ConexionBD.java`):** Clase *singleton* o utilitaria que abstrae la cadena de conexión JDBC conectándose a Supabase.
  * **Controladores/Vista (`AppGestorEmpleados.java`):** Punto de interacción (menús, submenús y lectura de la entrada del usuario).

## 4. Funcionalidades principales

* **Login Seguro:** Autenticación básica de usuarios al inicio del sistema.
* **Mantenimiento de Departamentos y Empleados:** Operaciones CRUD para el control del Capital Humano de la empresa. Asignación de trabajadores, roles y departamentos físicos o virtuales.
* **Control de Inventario Tecnológico:** Alta, lectura, actualización y borrado de los equipos (dirección MAC, IP, tipo de dispositivo y sistema operativo) así como la asignación al empleado responsable.
* **Gestión de Incidencias Técnicas:** Creación y seguimiento de tickets de averías o problemas, registrando el dispositivo afectado, la fecha de alta, el empleado encargado de solucionarla, la fecha de cierre y su estado actual.

## 5. Instalación y ejecución

* **Requisitos previos:** 
  * Java Development Kit (JDK) 21 instalado.
  * Apache Maven configurado en las variables de sistema.
  * Acceso a internet para conectar con la base de datos remota (Supabase).
* **Variables de entorno:** Se requiere crear un archivo `.env` en la raíz del proyecto para alojar las variables sensibles, por ejemplo:
  ```env
  DB_URL=jdbc:postgresql://<host>.supabase.co:5432/<dbname>
  DB_USER=<usuario>
  DB_PASSWORD=<contraseña>
  ```
* **Instalación de dependencias:** 
  Ejecutar en la raíz del proyecto para descargar el driver de Postgres y dotenv:
  ```bash
  mvn clean install
  ```
* **Ejecución en desarrollo/producción:**
  Dado que es una aplicación de escritorio por consola, se lanza desde el punto de entrada principal del IDE o compilando el JAR:
  ```bash
  java -cp target/clases org.camp.gestor_empleados.AppGestorEmpleados
  ```

## 6. Estructura del proyecto

La arquitectura de directorios sigue la convención estándar de un proyecto Maven de Java:

```
Proyecto_KALIJ/
├── src/
│   └── main/
│       └── java/
│           └── org/camp/gestor_empleados/
│               ├── model/       # Entidades POJO (Empleado, Dispositivo, etc.)
│               ├── database/    # Configuración de base de datos y clases DAO
│               ├── view/        # Opcional (separación de las interfaces de terminal si existe)
│               ├── ConexionBD.java       # Manejador central JDBC
│               └── AppGestorEmpleados.java  # Clase principal y bucle del menú CLI
├── supabase/
│   └── copia de tablas.sql  # Scripts DDL para instanciar la base de datos
├── pom.xml          # Configuración de Maven y dependencias
├── .env             # Variables de entorno secretas (no versionado)
└── README.md
```

## 7. APIs o endpoints

La aplicación desarrollada es monolítica y su interfaz es estrictamente de consola (*CLI*). Por lo tanto, **no expone endpoints ni métodos HTTP** (GET, POST, PUT, DELETE) públicos al exterior. El intercambio de datos se produce de forma local a través del `java.util.Scanner` para la entrada de parámetros, y la persistencia se realiza mediante conexiones seguras *TCP* directas (JDBC) al motor de PostgreSQL alojado en Supabase.

## 8. Problemas encontrados y soluciones aplicadas

* **Gestión segura de credenciales:** El mayor riesgo en las aplicaciones conectadas a bases de datos alojadas en la nube (como Supabase) es filtrar las contraseñas en el código al hacer `commit` a un repositorio colaborativo (GitHub). 
  * **Solución:** Hemos implementado la librería `dotenv-java`. Se separó la cadena de conexión en un archivo local `.env` (ignorado en `.gitignore`), protegiendo de esta forma la seguridad de la infraestructura y manteniendo las buenas prácticas de desarrollo.
* **Separación de Lógica / Escalabilidad:** Una aplicación que maneja consola y BBDD puede volverse rápidamente *Código Espagueti*.
  * **Solución:** Se aplicó desde el inicio el diseño DAO con clases puras (POJO) y una clase `ConexionBD` para modularizar, separar el acceso a datos de la impresión por pantalla, y preparar la app por si en el futuro se desea integrar con una API o GUI sin reescribir la lógica base.
