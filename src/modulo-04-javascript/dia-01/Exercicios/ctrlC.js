//Exercicio 6
function ctrlC( objeto ) {
    var copia = {};
    for ( var propriedade in objeto ) {
        if ( objeto.hasOwnProperty(propriedade) )
            copia[propriedade] = objeto[propriedade];
    }
    return copia;
}
