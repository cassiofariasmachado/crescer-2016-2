// Exericio 3
function find(array, funcao) {
  retorno = [];
  for ( var i = 0, var len = array.length; i < len; i++ ) {
    if ( funcao(array[i]) )
      retorno.push(i);
  }
}

function maiorIgualADois(elemento) {
    return elemento >= 2;
}

//TO-DO: terminar
