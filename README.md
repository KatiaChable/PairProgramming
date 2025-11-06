## Explicación

Presentamos la solución de este sistema de una cafetería el cual se conforma de 5 clases cada una de ellas tiene un rol especfíco para modelar lo que serían las entidades del negocio

Cliente
Modela las personas que realizan compras. Tiene un identificador en String (no se realizan operaciones con el id) que es el código único asignado al cliente. y el nombre en String que almacena el nombre completo.

Producto 
Son los artículos disponibles para vender. Sus atributos son su SKU en string (id), codigo de inventario único para el producto, nombre en String y su precio base en double por costo unitario

Pedido 
Se trata de una orden de compra específica. Cada pedido se identifica de manera única con un idPedido, generado por un contador que es estático, Mantiene una referencia al objeto cliente que lor ealizó y guarda el detalle de la compra en una lista List LineaPedido. Calcula y almacena el totalPedido en double, este es el total de la suma de precios de los productos que se compró.

LineaPedido
La clase LineaPedido es un detalle de las transacciones. Su propósito es capturar un artículo específico dentro de un Pedido. Sus atributos son una referencia al objeto producto que se está comprando, la cantidad de unidades en enteros solicitadas de ese producto, y el precioLinea es un double este es el resultado de multiplicar la cantidad por el precio base del producto.
