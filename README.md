# Programa de Lectura de Archivos en Java

Este programa en Java permite leer información desde varios archivos de texto (clientes, ventas, detalles y productos) y mostrarla mediante un menú interactivo en la consola.

## Estructura del Proyecto

El proyecto está organizado en varios paquetes que cumplen funciones específicas:

- **`ar.com.unpaz.main`**: Contiene la clase principal `MenuPrincipal` que ejecuta el programa y muestra un menú interactivo.
  
- **`ar.com.unpaz.model`**: Define las clases modelo (`Cliente`, `Venta`, `Detalle`, `Producto`) que representan los datos leídos de los archivos.

- **`ar.com.unpaz.repository`**: Contiene los repositorios (`ClienteRepository`, `VentaRepository`, `DetalleRepository`, `ProductoRepository`) que se encargan de leer los datos desde los archivos y convertirlos en objetos.

## Archivos de Datos

Los archivos de datos utilizados por el programa están en formato CSV (valores separados por comas):

- **`cliente.txt`**: Contiene la información de los clientes (id, nombre, apellido, teléfono).

- **`venta.txt`**: Contiene la información de las ventas (id, fecha, idCliente, monto).

- **`detalle.txt`**: Contiene los detalles de las ventas (idVenta, idProducto, cantidad, precioUnitario).

- **`producto.txt`**: Contiene la información de los productos (id, nombre, stock, precio).

## Funcionalidades del Menú

El programa presenta las siguientes funcionalidades en el menú:

1. **Leer archivo cliente**: Muestra la lista de clientes almacenados en `cliente.txt`.
  
2. **Leer archivo venta**: Muestra la lista de ventas almacenadas en `venta.txt`.

3. **Leer archivo detalle**: Muestra la lista de detalles de ventas almacenados en `detalle.txt`.

4. **Leer archivo producto**: Muestra la lista de productos almacenados en `producto.txt`.

5. **Leer completo**: Muestra la información completa de clientes, ventas, detalles y productos almacenados en los respectivos archivos.

## Ejecución del Programa

Para ejecutar el programa, simplemente sigue estos pasos:

1. Abre el proyecto en tu entorno de desarrollo Java (como Eclipse).
  
2. Ejecuta la clase `MenuPrincipal` ubicada en el paquete `ar.com.unpaz.main`.
  
3. Se mostrará un menú interactivo en la consola. Selecciona la opción deseada para ver la información correspondiente.

## Notas Adicionales

- Asegúrate de tener los archivos de datos (`cliente.txt`, `venta.txt`, `detalle.txt`, `producto.txt`) en la raíz del proyecto para que el programa pueda leerlos correctamente.
  
- Puedes agregar más funcionalidades y mejorar la interfaz según tus necesidades.

