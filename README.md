# Teatro Moro - Gestión de Entradas

Este programa en Java simula un sistema de gestión de entradas para el Teatro Moro.

## Funcionalidades

- Menú interactivo con opciones:
  1. Venta de entradas
  2. Promociones disponibles
  3. Búsqueda de entradas por número
  4. Eliminación de entradas
  5. Salir del sistema
- Aplicación de descuentos:
  - 10% para estudiantes
  - 15% para personas de la tercera edad (65+)
- Almacena hasta **4 entradas** sin uso de arreglos o listas.
- Validaciones de ingreso y manejo de errores con `try-catch`.

## Variables utilizadas

### Variables locales (mínimo 4)
- `locationOption`, `age`, `discount`, `type`, etc.

### Variables de instancia (mínimo 4)
- `ticketNum1`, `location1`, `type1`, `price1` ... hasta la entrada 4.

### Variables estáticas (mínimo 3)
- `totalTicketsSold`, `totalIncome`, `ticketCounter`

### Otras variables clave
- `String theaterName = "Teatro Moro";`
- `int theaterCapacity = 100;`
- `double basePrice = 10000;`

## Validaciones y control
- Ingreso validado con `InputMismatchException`
- Ciclo `while` para ejecutar múltiples operaciones
- Uso de `if`, `else if`, ternarios y validaciones de estado
