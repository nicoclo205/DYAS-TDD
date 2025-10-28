# Registro de Defectos

Este documento recopila los defectos encontrados durante la ejecución de las **pruebas unitarias** del proyecto **Registraduría (Registry)**.  
Su objetivo es evidenciar los errores detectados, analizar sus causas y dejar constancia del proceso de mejora continua del sistema.

Cada defecto se documenta para facilitar su análisis y corrección, siguiendo buenas prácticas de **gestión de calidad y TDD**.

---

## Formato 1: Lista detallada (narrativa)

### **Defecto 01**
**Caso de prueba:** Persona con edad negativa (edad inválida).  
**Entrada:** `Person(name="Juan", id=101, age=-1, gender=MALE, alive=true)`  
**Resultado esperado:** `INVALID_AGE`  
**Resultado obtenido:** `VALID`  
**Causa probable:** Falta validación para edades negativas en `Registry.registerVoter`.  
**Estado:**  **Cerrado** (corregido al agregar la validación `age < MIN_AGE`).

---

### **Defecto 02**
**Caso de prueba:** Persona muerta.  
**Entrada:** `Person(name="Ana", id=102, age=45, gender=FEMALE, alive=false)`  
**Resultado esperado:** `DEAD`  
**Resultado obtenido:** `VALID`  
**Causa probable:** No se estaba evaluando correctamente la condición `alive == false`.  
**Estado:**  **Cerrado** (se añadió la regla de validación de vida en el registro).

---

### **Defecto 03**
**Caso de prueba:** Registro duplicado con el mismo ID.  
**Entradas:**  
- `Person(name="Carlos", id=200, age=30, gender=MALE, alive=true)`  
- `Person(name="Carla", id=200, age=25, gender=FEMALE, alive=true)`  
**Resultado esperado:**  
- Persona 1 : `VALID`  
- Persona 2 : `DUPLICATED`  
**Resultado obtenido:**  
- Persona 1 : `VALID`  
- Persona 2 : `VALID`  
**Causa probable:** No se estaba verificando si el ID ya existía previamente.  
**Estado:** **Cerrado** (corregido agregando validación de duplicidad de IDs).

---

### **Defecto 04**
**Caso de prueba:** Persona con edad superior al límite máximo permitido.  
**Entrada:** `Person(name="Laura", id=103, age=120, gender=FEMALE, alive=true)`  
**Resultado esperado:** `INVALID_AGE`  
**Resultado obtenido:** `VALID`  
**Causa probable:** Falta validación del límite superior (`age > MAX_AGE`).  
**Estado:** **Cerrado** (se añadió verificación de rango de edad).

---

### **Defecto 05**
**Caso de prueba:** Campos nulos o vacíos en nombre.  
**Entrada:** `Person(name="", id=104, age=25, gender=MALE, alive=true)`  
**Resultado esperado:** `INVALID_NAME`  
**Resultado obtenido:** `VALID`  
**Causa probable:** No se validaba que el campo `name` no fuera vacío o nulo.  
**Estado:** **Cerrado** (se implementó validación de campos obligatorios).

---

## Formato 2: Tabla de defectos (bug tracking)

| ID | Caso de Prueba | Entrada | Resultado Esperado | Resultado Obtenido | Causa Probable | Estado |
|----|----------------|----------|--------------------|--------------------|----------------|---------|
| 01 | Edad negativa | `Person(age=-1, alive=true)` | INVALID_AGE | VALID | No se validaba edad < 0 | Cerrado |
| 02 | Persona muerta | `Person(age=45, alive=false)` | DEAD | VALID | No se evaluaba condición de vida | Cerrado |
| 03 | Registro duplicado | `Person(id=200, …)` x2 | 2º → DUPLICATED | 2º → VALID | Falta verificación de IDs duplicados | Cerrado |
| 04 | Edad mayor a máxima | `Person(age=120, alive=true)` | INVALID_AGE | VALID | No se controlaba límite superior | Cerrado |
| 05 | Nombre vacío | `Person(name="", alive=true)` | INVALID_NAME | VALID | Falta validación de nombre vacío | Cerrado |

---

## Convenciones de Estado
- **Abierto:** El defecto aún no ha sido corregido.  
- **En progreso:** El defecto está siendo trabajado.  
- **Cerrado:** El defecto fue corregido y validado mediante pruebas exitosas.

---

## Observaciones
- Todos los defectos fueron detectados durante las primeras iteraciones del ciclo **TDD (Red → Green → Refactor)**.  
- Después de cada corrección, las pruebas fueron re-ejecutadas con éxito, confirmando el **estado “Verde”** del sistema.  
- Este registro se mantendrá actualizado mientras se continúe el desarrollo del proyecto.

---
