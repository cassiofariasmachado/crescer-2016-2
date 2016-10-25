// Exericio 3
function find(array, funcao) {
  var retorno = [];
  if ( typeof funcao === 'function') {
    for ( var i = 0, len = array.length; i < len; i++ ) {
      var elementoAtual = array[i]
        if ( funcao( elementoAtual ) )
          retorno.push( elementoAtual );
    }
  }
  return retorno;
}
