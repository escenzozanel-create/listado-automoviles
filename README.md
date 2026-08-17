# Listado de Automóviles

## Clonar el proyecto

Abrir una terminal y ejecutar:

```bash
git clone URL_DEL_REPOSITORIO
```

Luego entrar a la carpeta del proyecto:

```bash
cd Web
```

## Base de datos

La base de datos que utiliza el proyecto se llama:

```text
automoviles
```

Dentro del proyecto se encuentra la carpeta:

```text
bd
```

Ahí está incluido el script SQL necesario para crear la base de datos, las tablas y cargar los datos utilizados por la aplicación.

Importar ese archivo `.sql` en MySQL antes de ejecutar el proyecto.

## Configuración de MySQL

Revisar el archivo:

```text
src/main/resources/application.properties
```

Verificar que el usuario y contraseña de MySQL coincidan con los de tu computadora.

Por ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/automoviles
spring.datasource.username=root
spring.datasource.password=
```

Si tu usuario `root` tiene contraseña, colocarla en:

```properties
spring.datasource.password=TU_CONTRASEÑA
```

## Puerto del proyecto

La aplicación está configurada para ejecutarse en el puerto:

```text
8090
```

Por lo tanto, una vez iniciado Spring Boot, acceder desde el navegador a:

```text
http://localhost:8090
```

## Ejecutar el proyecto

Desde la carpeta raíz del proyecto se puede ejecutar:

```bash
mvn spring-boot:run
```

## Importante

Antes de ejecutar, comprobar que:

* MySQL esté iniciado.
* La base `automoviles` haya sido creada/importada usando el script de la carpeta `bd`.
* El usuario y contraseña de MySQL en `application.properties` sean correctos.
* El puerto `8090` esté disponible.

Una vez iniciado correctamente, abrir:

```text
http://localhost:8090
```
