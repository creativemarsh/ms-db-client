# Ejemplos de JSON para probar en Postman

Aquí tienes los cuerpos JSON (Body -> raw -> JSON) que necesitas para probar cada endpoint de tu microservicio.

## 1. Registrar un Nuevo Usuario
**Método:** `POST`
**URL:** `http://localhost:8080/clients`

```json
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan.perez@duocuc.cl",
  "password": "passwordSegura123",
  "telefono": "+56912345678",
  "region": "Región Metropolitana",
  "comuna": "Santiago"
}
```

## 2. Iniciar Sesión (Login)
**Método:** `POST`
**URL:** `http://localhost:8080/clients/login`

```json
{
  "email": "juan.perez@duocuc.cl",
  "password": "passwordSegura123"
}
```

## 3. Obtener Todos los Usuarios
**Método:** `GET`
**URL:** `http://localhost:8080/clients`
*(No requiere cuerpo JSON)*

## 4. Obtener Usuario por ID
**Método:** `GET`
**URL:** `http://localhost:8080/clients/1`
*(Reemplaza el 1 por el ID real. No requiere cuerpo JSON)*

## 5. Actualizar Usuario
**Método:** `PUT`
**URL:** `http://localhost:8080/clients/1`
*(Reemplaza el 1 por el ID del usuario que quieres editar)*

```json
{
  "id": 1,
  "nombre": "Juan Editado",
  "apellido": "Pérez",
  "email": "juan.perez@duocuc.cl",
  "password": "nuevaPassword123",
  "telefono": "+56987654321",
  "region": "Región de Valparaíso",
  "comuna": "Viña del Mar"
}
```

## 6. Eliminar Usuario
**Método:** `DELETE`
**URL:** `http://localhost:8080/clients/1`
*(Reemplaza el 1 por el ID real. No requiere cuerpo JSON)*
