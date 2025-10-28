# Proyecto: Registro de Votantes

## Descripción del dominio

El dominio del proyecto representa un **sistema de registro de votantes**.  
Cada persona tiene atributos como **nombre, identificación, edad, género y estado de vida (vivo o muerto)**.

El sistema valida las siguientes reglas antes de permitir el registro:

1. La persona no puede ser `null`.
2. El nombre debe estar definido.
3. La edad debe ser mayor o igual a **18 años**.
4. El identificador (`id`) debe ser positivo.
5. El género no puede ser `null`.
6. La persona debe estar **viva**.
7. El identificador no puede estar previamente registrado.

Si todas las condiciones se cumplen, la persona se registra correctamente y el sistema devuelve `RegisterResult.VALID`.

---

## Instrucciones para compilar y ejecutar pruebas

Para compilar el proyecto y ejecutar todas las pruebas unitarias, usa los siguientes comandos Maven:

```bash
mvn clean test