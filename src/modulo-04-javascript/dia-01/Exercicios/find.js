// Exericio 3
function find(array, funcao) {
  var retorno = [];
  for ( var i = 0, len = array.length; i < len; i++ ) {
    var elementoAtual = array[i]
    if ( typeof funcao === 'function') {
      if ( funcao( elementoAtual ) )
        retorno.push( elementoAtual );
    } else
        retorno.push( elementoAtual );
  }
  return retorno;
}