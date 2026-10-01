# Laboratorio 7: Patrón de Diseño Creacional - Builder

Este proyecto implementa de forma nativa el patrón de diseño creacional **Builder** bajo los lineamientos de la arquitectura clásica de objetos del GoF. El componente modela la fabricación progresiva, guiada y heterogénea de preguntas académicas para el sistema de Gestión de Banco de Preguntas de la Universidad del Cauca.

## Por:
*   Carlos Arturo Bambagüé Martínez- Ingeniería de Sistemas
*   **Grupo de Laboratorio:** g07

## Justificación del Patrón Usado
Se incorporó el patrón estructurando un componente **Director** (`QuestionDirector`) independiente. Esto se hizo para centralizar y encapsular la secuencia estricta de fabricación de las preguntas. Así se garantiza que el cliente no conozca la lógica interna de instanciación de las opciones ni las claves de respuestas correctas asociadas a cada especialidad de evaluación (Selección Múltiple, Verdadero/Falso y Abiertas), promoviendo el bajo acoplamiento.

## Instrucciones de Ejecución (Consola Nativa)

### 1. Compilación del Proyecto
Para compilar el árbol completo de clases y paquetes sin depender del entorno gráfico del IDE, ejecute:
```bash
javac -d bin --source-path src\main\java src\main\java\co\unicauca\iso2\bancopreguntas\ApplicationMain.java
```

### 2. Despliegue de la Aplicación Principal
Para poner en marcha la ejecución del cliente de consola:
```bash
java -cp bin co.unicauca.iso2.bancopreguntas.ApplicationMain
```

## Certificación de la Suite de Pruebas Unitarias
El proyecto incorpora un set completo de **10 pruebas unitarias automatizadas con JUnit 5** ejecutadas de forma nativa en Visual Studio Code. Estas pruebas certifican las siguientes reglas de negocio del sistema:
1. Validaciones de obligatoriedad sobre el enunciado (bloqueo de valores `null` y vacíos).
2. Control de consistencia en el volumen de distractores/opciones según la naturaleza de la pregunta.
3. Versatilidad del proceso al construir múltiples productos usando la misma firma secuencial del Director.
