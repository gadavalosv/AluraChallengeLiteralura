# AluraChallengeLiteralura - Catálogo de Libros 📚

Este proyecto es una aplicación de consola que permite a los usuarios interactuar con un catálogo de libros. Utiliza la API de [Gutendex](https://gutendex.com/books/) para buscar y registrar información sobre libros y autores, ofreciendo diversas opciones de consulta y manejo de datos.

## Objetivo 🎯

El objetivo del proyecto es desarrollar un Catálogo de Libros que ofrezca interacción textual (vía consola) con los usuarios. Se han implementado al menos 5 opciones de interacción, integrando los datos de la API mencionada y una base de datos local para almacenar la información.

## Menú de Opciones 📋

El programa presenta el siguiente menú de interacción:

```
1 - Buscar Libro por Título
2 - Listar Libros Registrados
3 - Listar Autores Registrados
4 - Listar Autores Vivos en un Determinado Año
5 - Listar Libros por Idioma

0 - Salir
```

### Funcionalidades

1. **Buscar Libro por Título**  
   Permite buscar libros por título a través de la API de Gutendex. Los resultados se guardan en la base de datos para futuras consultas.

2. **Listar Libros Registrados**  
   Muestra todos los libros que han sido registrados previamente en la base de datos.

3. **Listar Autores Registrados**  
   Muestra una lista de todos los autores registrados en la base de datos, junto con información adicional como su año de nacimiento y muerte.

4. **Listar Autores Vivos en un Determinado Año**  
   Consulta autores que estaban vivos en un año específico, basado en su año de nacimiento y muerte.

5. **Listar Libros por Idioma**  
   Permite buscar libros almacenados en la base de datos que están escritos en un idioma específico.

0. **Salir**  
   Finaliza la ejecución del programa.

## Instalación y Configuración 🚀

### Prerrequisitos

- **Java** (JDK 17 o superior)
- **Spring Boot** (3.3.4 o superior)
- **PostgreSQL** como base de datos
- **Maven** para la gestión de dependencias

### Pasos

1. Clona este repositorio:
   ```bash
   git clone https://github.com/gadavalosv/AluraChallengeLiteralura.git
   ```

2. Configura la base de datos en el archivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/alura_literalura
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Instala las dependencias con Maven (si no lo tienes disponible en tu IDE):
   ```bash
   mvn install
   ```

4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Estructura del Proyecto 🏗️

### Paquetes Principales

- **Model**: Contiene las clases `Book` y `Author` para modelar los datos.
- **Repository**: Interfaces para interactuar con la base de datos.
- **Service**: Contiene la lógica de negocio para procesar las solicitudes del usuario.

### Base de Datos

La base de datos tiene dos tablas principales:

1. **Books**  
   Almacena información sobre los libros, incluyendo título, idiomas y autores asociados.

2. **Authors**  
   Almacena información sobre los autores, incluyendo su nombre, año de nacimiento y año de muerte.

## API Utilizada 🌐

La aplicación consume datos de la API de [Gutendex](https://gutendex.com/books/) para buscar información de libros.

### Ejemplo de Llamada a la API

- **Buscar por Título**:  
  URL: `https://gutendex.com/books/?search=<TITULO>`

  **Respuesta**:
  ```json
  {
    "count": 1,
    "results": [
      {
        "id": 123,
        "title": "Frankenstein; Or, The Modern Prometheus",
        "authors": [
          {
            "name": "Mary Wollstonecraft Shelley",
            "birth_year": 1797,
            "death_year": 1851
          }
        ],
        "languages": ["en"],
        "download_count": 12345
      }
    ]
  }
  ```

## Cómo Contribuir 🤝

¡Las contribuciones son bienvenidas! Sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu función:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios y haz commit:
   ```bash
   git commit -m "Agrega nueva funcionalidad"
   ```
4. Haz push de la rama:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Abre un Pull Request.
