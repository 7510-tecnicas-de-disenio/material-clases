
Kata Monitoreo Mercado de Monedas / Monitor Crypto Market Kata 
Autores Diego Montaldo y Agustin Carames. 2022/04/18
Objetivo: Implementar aplicando TDD, para experimentar con un proyecto con un poco mas de dificultad de otras katas tradicionales.
Nivel de Dificultar: Medio 
Tiempo estimado: entre 2 y 4 horas para un programador experimentado. Se puede terminar probando la logica con los test y mocks de compra y venta, sin conectar realmente a un mercado real.
Extensiones: 
- Seguir agregando reglas, que se puedan componer haciendo mas inteligente la logica de compra y venta.
- Definir estados del mercado, para poder cambiar estretegias (conjunto de reglas) segun si el mercado esta a la alza, a la baja, o con vaivenes estables

Enunciado:
Se desea contar con una billetera virtual, que pueda guardar monedas. Las monedas cambian la cotización frente a otra moneda base. La billetera puede tener mas de un tipo de moneda. 
Se desea monitorear los cambios de valor de las monedas sobre otra, para detectar cambios de dicho valor. 
Existe un mercado externo que maneja el valor de las monedas y nos permite integrarnos via API para consular precios y colocar ordenes de compra y venta. Y por otro lado provee un websocket para que podamos subscribirnos y ser notificados ante el cambio de un tipo de moneda. 
Específicamente se desea detectar cuando el valor de cada moneda, desde el momento que se empieza a monitorear, cae un 5% del valor máximo registrado, y en ese caso se desea vender la totalidad de esa moneda contra la moneda base. Se puede pensar como una estrategia de escape, si vemos que el valor de la moneda cae mas de un 5% del maximo observado, decidimos salirnos porque creemos que puede seguir cayendo aun mas.
A partir de ese momento, se resetean los maximos y minimos, y se continua el monitoreo pero ahora para registrar cuando el valor de la misma sube un 5% del valor mínimo registrado, y en ese caso se desea comprar nuevamente la moneda original en toda la cantidad posible. Se supone que si pasa eso creemos que ahora esta recuperando y queremos nuevamente pasarnos a nuestra moneda.
Y así continuar iterando y monitoreando continuamente el mercado.

Esta es una posible estrategia solo a efectos didacticos de la kata, no pensada con objetivo de ganar con el cambio, sino mas bien de resguardo, de ante una caida brusca salirnos y cuando comienza a recuperar volver a entrar. Es un ejemplo didactico muy simple pensado para hacer en esta kata. 
El tiempo aproximado puede llevar entre 2 y 4 horas para un programador con experiencia. 

Implementarlo completo requiere obtener API keys de un exchange por ejemplo binance para poder integrarse a la API y websockets.
Ver info: https://academy.binance.com/en/articles/binance-api-series-pt-1-spot-trading-with-postman

Se pide implementar esta kata utilizando Node, Javascript o TypeScript, aplicando TDD lo mas puro posible, recordar las 3 leyes de UncleBob  
http://butunclebob.com/ArticleS.UncleBob.TheThreeRulesOfTdd
La idea es experimentar aplicando TDD correctamente, avanzando con baby steps, pensando muy bien cada nuevo test a agregar, resolviendolo de la manera mas simple que lo haga pasar, y seguir agregando nuevos tests que describan todo requerimiento que quiero que el modelo o diseño o implentación brinde. 

Recuerden que la idea de la kata es justamente experimentar, probar, no es el objetivo hacerla rapido o apurado ni llegar a una solución puntual, sino al contrario tomar esta oportunidad para aplicar TDD lo mas puro posible, esto implica seguir las 3 leyes de Robert C Martin. 

Si la solución para que un test corra es agregar un método que retorne un nro fijo. (return 1) hagan eso, porque esto implicará que tengan que agregar un nuevo test, que haga que el modelo con el “return 1” falle y tenga que modificarlo nuevamente ahora si con el “return value” y lo que sea necesario mantener un value en el estado, la idea que los tests sean los que definen que cumple o no el modelo. Y que el modelo sea lo mas simple posible, en katas previas veíamos algunos equipos modelaron clases como Currency, y luego heredaban otras como DoigCoin, Peronio, Bitcoin, etc, ahi la pregunta es, es necesario tener una jerarquía de currencies? al menos a esta altura con lo que los tests nos van pidiendo? Que comportamiento diferente tiene cada clase de esa jerarquía que requiera que la diseñemos? (No vemos un smell de código duplicado, o clases anémicas?) Recuerden que buscamos mantener un diseño simple, evaluemos si es necesaria o no, y si ahora no, dejemos a futuro para un refactor incorporar esa jerarquía cuando realmente sea necesaria. 

Suerte!
