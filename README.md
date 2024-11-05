# Conversor de Monedas

Este es un programa en Java que permite convertir entre distintas monedas utilizando tasas de cambio en tiempo real. El programa obtiene los tipos de cambio mediante una API externa, permite que el usuario seleccione las monedas de origen y destino mediante un menú interactivo, y realiza la conversión de la cantidad ingresada.

## Características

- Selección de monedas por nombre y código (incluyendo monedas latinoamericanas).
- Conversión en tiempo real utilizando la API de ExchangeRate-API.
- Opción de realizar múltiples conversiones.
- Menú interactivo y fácil de usar.

## Requisitos

- Java 8 o superior.
- Conexión a internet para consultar la API de tasas de cambio.

## Configuración

1. **Obtener una clave API:**
   - Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener una clave de API gratuita.
   - Una vez obtenida, reemplaza `YOUR-API-KEY` en el código con tu clave API personal.

2. **Iniciar el proyecto:**
   - Clona o descarga el repositorio.
   - Abre el proyecto en tu IDE preferido (por ejemplo, IntelliJ IDEA, Eclipse, etc.).
   - Asegúrate de que Java esté instalado y configurado correctamente en tu entorno de desarrollo.

## Uso

1. Ejecuta el programa. El menú de selección de monedas aparecerá en la consola.
2. Ingresa el código de la moneda de origen (por ejemplo, "USD" para dólares).
3. Ingresa el código de la moneda de destino (por ejemplo, "EUR" para euros).
4. Ingresa la cantidad a convertir.
5. El programa mostrará el valor convertido.
6. Puedes hacer otra conversión o salir del programa.

### Ejemplo de ejecución:

Seleccione la moneda de origen:

USD - Dólar estadounidense
EUR - Euro
CLP - Peso chileno ...
Seleccione una opción: 1

Seleccione la moneda de destino:

USD - Dólar estadounidense
EUR - Euro
CLP - Peso chileno ...
Seleccione una opción: 3

Ingrese la cantidad a convertir: 100

Resultado: 100 USD = 80000 CLP

¿Quieres realizar otra conversión? (S/N): S


## Estructura del Proyecto

- **MainApp.java**: Clase principal que maneja la ejecución del programa y la interacción con el usuario.
- **CurrencyConverter.java**: Clase que se encarga de la conversión de monedas, incluyendo la obtención de tasas de cambio de la API.
- **Currency.java**: Representa una moneda con su código y nombre.
- **Moneda.java**: Representa una moneda en el sistema con su código y nombre.

## API utilizada

Este programa utiliza la [API de ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio en tiempo real. La API soporta más de 150 monedas, incluidas las principales monedas latinoamericanas.

