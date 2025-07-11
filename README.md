<h1>Comanda Backend</h1
<p>Aplicación monolítica que centraliza la gestión de un bar, permitiendo controlar productos, menús, clientes y pedidos de forma eficiente.</p>

<h2>Diagrama de Base de Datos</h2>
<img src="images/diagram-db.png" alt="Diagrama de la base de datos" />

<h2>Tecnologías utilizadas</h2>
<p>⭐️ Java 17+ / Spring Boot 3.4</p>
<p>⭐️ Spring Security con autenticación y autorización basada en JWT (JSON Web Tokens)</p>
<p>⭐️ Hibernate / JPA</p>
<p>⭐️ MySQL</p>
<p>⭐️ Swagger / OpenAPI</p>

<h2>Cómo ejecutar el proyecto</h2>

<p>Esta es una <strong>aplicación monolítica</strong> desarrollada en Java con Spring Boot que centraliza la gestión integral de un bar. Permite administrar productos, menús, clientes y pedidos de forma eficiente y sencilla.</p>

<h3>Requisitos previos</h3>
<ul>
  <li>Tener instalado Java 17 o superior.</li>
  <li>Tener instalado MySQL </li>
  <li>Configurar las variables de entorno necesarias (ejemplo en archivo <code>.env</code> o en tu entorno local).</li>
</ul>

<h3>Variables de entorno necesarias</h3>
<p>Configura las siguientes variables en tu entorno o en un archivo <code>.env</code> (que <strong>no debe subirse a Git</strong>):</p>

<pre>
DB_USER=root
DB_PASSWORD=tu_password
DB_URL=jdbc:mysql://localhost:3306/nombre_basedatos
SECRET_KEY=tu_clave_secreta_para_jwt
</pre>

<p>Asegúrate de modificar los valores según tu configuración local.</p>

<h3>Pasos para ejecutar</h3>
<ol>
  <li>Clonar el repositorio:
    <pre>git clone https://github.com/tu_usuario/tu_repositorio.git
cd tu_repositorio</pre>
  </li>
  <li>Configurar las variables de entorno según corresponda.</li>
  <li>Construir el proyecto con Maven o Gradle (según corresponda):
    <pre>./mvnw clean install
-- o --
./gradlew build</pre>
  </li>
  <li>Ejecutar la aplicación:
   Ejecutar la aplicación:
  <p>Antes de ejecutarlo, debes declarar las variables en la consola manualmente, de la siguiente manera:</p>
    <p>Ejemplo: </p>
  <p><code>$env:DB_USER="valor"</code></p>
  <p>Luego, ejecuta el siguiente comando:</p>
  <pre>./mvnw spring-boot:run</pre>
-- o --
java -jar target/nombre-del-jar.jar</pre>
  </li>
  <li>Acceder a la API en:
    <pre>http://localhost:8080</pre>
  </li>
  <li>Para la documentación Swagger, visitar:
    <pre>http://localhost:8080/swagger-ui.html</pre>
  </li>
</ol>
<h2>Datos iniciales requeridos (seeding)</h2>
<p>Para que la aplicación funcione correctamente, es necesario insertar algunos roles y permisos básicos en la base de datos:</p>

<h3>🎯 Inserts de roles</h3>
<pre><code>INSERT INTO comanda.role_entity (role_enum) VALUES ('MOZO');
INSERT INTO comanda.role_entity (role_enum) VALUES ('ADMIN');
</code></pre>

<h3>🔐 Inserts de permisos</h3>
<pre><code>INSERT INTO comanda.permission_entity (name) VALUES ('READ_');
INSERT INTO comanda.permission_entity (name) VALUES ('WRITE_');
INSERT INTO comanda.permission_entity (name) VALUES ('DELETE_');
</code></pre>

<h3>🔗 Asociación de roles y permisos</h3>
<pre><code>INSERT INTO comanda.role_permissions (role_id, permission_id) VALUES (1, 1);
INSERT INTO comanda.role_permissions (role_id, permission_id) VALUES (1, 2);
INSERT INTO comanda.role_permissions (role_id, permission_id) VALUES (1, 3);
INSERT INTO comanda.role_permissions (role_id, permission_id) VALUES (2, 1);
INSERT INTO comanda.role_permissions (role_id, permission_id) VALUES (2, 2);
</code></pre>

