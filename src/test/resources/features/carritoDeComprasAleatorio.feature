#language: es
Característica: Agregar productos al carrito de compras aleatoriamente

  Esquema del escenario: El usuario agrega exitoxamnete 5 productos aleatorios al carrito de compras
    Dado que el usuario ingresa a la pagina del exito <url>
    Cuando el usuario agrega cinco productos al carrito aleatoriamente
    Entonces el usuario podra ver sus productos agregadaos en el carrito
    Ejemplos:
      | url |
      | https://www.exito.com/ |