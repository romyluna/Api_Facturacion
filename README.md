# 🧾 API de Facturación - Backend Java + Spring Boot

## 🚀 Descripción General

🔧 Proyecto backend desarrollado en Java utilizando Spring Boot. Permite gestionar operaciones de facturación y está documentado con Swagger para facilitar las pruebas de los endpoints.
</br>
🔧Esta es una API sencilla para la gestión de facturación, desarrollada con Java Spring Boot. 
</br>
🔧La API incluye funcionalidades para manejar facturas y sus detalles, además de contar con autenticación para asegurar el acceso.

---

## Funcionalidades

- Autenticación para proteger los endpoints de factura-controller
- Gestión de facturas (crear, leer, actualizar, eliminar).
- Gestión de detalles de factura asociados a cada factura.
- Documentación de la API generada con Swagger UI para facilitar la prueba y consulta de los endpoints.

## Cálculo de totales en la factura:
</br>
Esta API de facturación realiza automáticamente el cálculo de los montos totales de cada factura para garantizar la precisión y consistencia en la información.

Total: Es la suma de los importes de todos los productos incluidos en el detalle de la factura.

IVA: Se aplica un impuesto al valor agregado (IVA) sobre el total, calculado según la tasa vigente del 21%

Total con IVA: Es la suma del total más el importe correspondiente al IVA.

Estos cálculos se realizan automáticamente en el backend al momento de crear una factura, por lo que no es necesario que el cliente envíe los valores de total ni de total con IVA al consumir los endpoints. De esta manera, se asegura que los valores reflejados en la factura sean consistentes y correctos.

![calculos-facturacion](https://github.com/romyluna/Api_Facturacion/blob/master/screenshot/calculos_facturacion.png?raw=true)

---
### Datos iniciales en la base (`custom-data.sql`)

El archivo `custom-data.sql`, ubicado en la carpeta `resources`, contiene sentencias SQL para insertar datos iniciales en la base de datos (modo prueba) ## LO DEJE INACTIVO PORQUE FUE DE PRUEBA ##

**Importante:** Si este archivo se ejecuta automáticamente cada vez que se inicia la aplicación, las sentencias `INSERT` se ejecutarán en cada arranque, lo que puede provocar:

- Inserción de datos duplicados si no existen restricciones que lo impidan.  
- Errores por claves primarias duplicadas si se intenta insertar registros con IDs ya existentes.  
- Posible sobrescritura o pérdida de datos si el archivo incluye sentencias `DELETE` o `TRUNCATE`.

---

## ⚙️ Tecnologías Utilizadas

- Java 17+
- Spring Boot
- Spring Security (para autenticación)
- Maven
- Spring Data JPA
- Swagger
- Base de datos (MySQL)
- ModelMapper

---

## 🗂️ Modelo Entidad-Relación

A continuación se muestra el modelo entidad-relación que representa la estructura principal de la base de datos utilizada por el sistema:

![Modelo entidad-relación](https://github.com/romyluna/Api_Facturacion/blob/master/screenshot/der_diagrama.png?raw=true)


## 🧪 Cómo Probar la API

📄 La documentación de la API se encuentra disponible en Swagger UI:

👉 [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui.html) 
> Asegurate de tener el proyecto corriendo localmente.

---

## ▶️ Cómo ejecutar el proyecto

---

## 🗂️ Documentación API - Swagger UI

La siguiente imagen muestra la documentación automática generada por Swagger para la API de facturación. Desde aquí se pueden consultar y probar los distintos endpoints disponibles.

![Swagger UI](https://github.com/romyluna/Api_Facturacion/blob/master/screenshot/pantalla_Swagger.png?raw=true)

### Ejemplo de GET: Obtener Productos

Este endpoint **no requiere autenticación**, por lo tanto puede probarse directamente desde Swagger.

- **Método:** `GET`
- **Descripción:** Devuelve el listado completo de productos.

#### Vista en Swagger:
![Swagger UI - GET Productos](https://github.com/romyluna/Api_Facturacion/blob/master/screenshot/get_productos.png?raw=true)

---

### Ejemplo de GET: Obtener Facturas (Este endpoint **requiere autenticación**)

> 🛡️ Todos los endpoints relacionados a **facturación** requieren autenticación.  
> Esto incluye: listar facturas, crear, y eliminar.

  json
{
  "username": "user",
  "password": "facturacion01"
}

![Swagger UI - GET Facturas Protegido](https://github.com/romyluna/Api_Facturacion/blob/master/screenshot/login_facturacion.png?raw=true)

- **Método:** `GET`
- **Descripción:** Devuelve el listado completo de facturas registradas en el sistema.


#### Vista en Swagger:

![Swagger UI - GET Facturas Protegido](https://github.com/romyluna/Api_Facturacion/blob/master/screenshot/get_facturas.PNG?raw=true)


---

### Colección de Postman para pruebas (`api-postman-swagg.json`)

En la carpeta `resources` se encuentra el archivo `api-postman-swagg.json`, que contiene la colección de Postman con los endpoints configurados para facilitar las pruebas de la API.

Para usarla:

1. Abrir Postman.  
2. Importar el archivo `api-postman-swagg.json`.  
3. Ejecutar las solicitudes para probar los diferentes métodos de la API de facturación.  

Esto permite realizar pruebas rápidas sin necesidad de configurar manualmente cada endpoint.

adjunto un ejemplo de como se podria probar tambien en postman:

![postman](https://github.com/romyluna/Api_Facturacion/blob/master/screenshot/postman.png?raw=true)

---

### 👩‍💻 Contacto
<a name="contacto"></a>

👩‍💻 Romina Olivera Luna
</br>
💌 rominalunaolivera@gmail.com
</br>
🔗 [LinkedIn
](https://www.linkedin.com/in/romina-bluna/)

[⬆️ Volver arriba](#readme)

---

© 2025 Romina Olivera Luna. Todos los derechos reservados.

Este README fue redactado íntegramente por Romina Olivera Luna y no puede ser reproducido, copiado ni distribuido sin permiso explícito.

El código fuente está licenciado bajo la Licencia MIT.  
Para más detalles, ver el archivo [LICENSE](LICENSE.txt).

---

