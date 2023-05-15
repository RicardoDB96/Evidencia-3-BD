# Evidencia 3 BD
Proyecto de Base de Datos - Gestión de universidad
## Descripción
Este proyecto es parte de la materia de Base de Datos y consiste en una aplicación en Java cutilizando la biblioteca gráfica Swing. La aplicación se conecta a una base de datos MongoDB para gestionar información relacionada con una universidad. La primera pantalla de despliegue es el inicio de sesión utilizando la seguridad de la base de datos. La aplicación permite realizar consultas de información de alumnos y carreras, así como también realizar altas, bajas y modificaciones de alumnos y carreras.
## Características principales
- Inicio de sesión utilizando la seguridad de base de datos.
- Consulta de información de alumnos.
- Consulta de información de carreras.
- Alta de un nuevo alumno.
- Alta de una nueva carrera.
- Baja de un alumno.
- Modificación de un alumno (cambio de dirección, cambio de carrera, etc.).
## Requisitos
- Java JDK 8 o superior.
- Biblioteca gráfica Swing.
- LGoodDatePicker (Interfaz de seleccionar fecha)
- MongoDB instalado y configurado.
- Librerías de MongoDB:
  - Bson
  - MongoDB Driver Core
  - MongoDB Driver Sync
## Datos de ejemplo
Se proporcionan archivos JSON de ejemplo que puedes utilizar para realizar pruebas de la aplicación con MongoDB. Estos archivos contienen datos simulados de alumnos, carreras y otros registros relacionados.

Para utilizar los datos de ejemplo, sigue los siguientes pasos:

1. Abre el archivo JSON correspondiente a la entidad que deseas utilizar, por ejemplo, Alumnos.json.
2. Copia el contenido del archivo JSON.
3. Abre una herramienta de administración de MongoDB, como MongoDB Compass o la interfaz de línea de comandos mongo.
4. Conéctate a la base de datos utilizada por la aplicación.
5. Selecciona la colección correspondiente a la entidad que deseas importar los datos, por ejemplo, Alumnos.
6. Pega el contenido del archivo JSON en la colección.
7. Confirma la importación de los datos.
8. Una vez importados los datos de ejemplo, podrás utilizar la aplicación para realizar consultas, altas, bajas y modificaciones utilizando estos registros simulados.

Nota: Recuerda que los datos de ejemplo son simulados y no representan información real. Se proporcionan únicamente con fines de prueba y demostración.

Si deseas utilizar tus propios conjuntos de datos, asegúrate de que los documentos JSON estén formateados correctamente y sigan la estructura requerida por la aplicación.
