## 🧪 Matriz de Pruebas

| # | Clase de Equivalencia / Valor Límite | Entrada (`Person`) | Resultado Esperado | Test que lo cubre |
|---|--------------------------------------|--------------------|--------------------|-------------------|
| 1 | Persona válida (edad ≥ 18, viva, con datos válidos) | `"Ana", id=1, age=30, FEMALE, alive=true` | `VALID` | `shouldRegisterValidPerson()` |
| 2 | Persona muerta | `"Carlos", id=2, age=40, MALE, alive=false` | `DEAD` | `shouldRejectDeadPerson()` |
| 3 | Edad menor al mínimo (17 años) | `"Pedro", id=1005, age=17, MALE, alive=true` | `INVALID` | `shouldRejectUnderagePerson()` |
| 4 | Persona duplicada | `"Juan Pérez", id=1001, age=25, MALE, alive=true` | `DUPLICATED` | `shouldRejectDuplicatedPerson()` |
| 5 | Nombre nulo | `null name, id=5, age=25, MALE, alive=true` | `INVALID` | `shouldRejectNullName()` |
| 6 | ID inválido | `"Laura", id=0, age=22, FEMALE, alive=true` | `INVALID` | `shouldRejectInvalidId()` |
