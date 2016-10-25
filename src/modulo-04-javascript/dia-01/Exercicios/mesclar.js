function mesclar ( objeto1, objeto2, recursiva ) {
    if ( null === objeto1 || typeof objeto1 != "object" || null === objeto2 || typeof objeto2 != "object" ) 
        return null;
    for ( var propriedade in objeto2 ) {
        if (recursiva && propriedade != null && typeof propriedade === 'object' )
            mesclar(objeto1[propriedade], objeto2[propriedade])
        else 
            objeto1[propriedade] = objeto2[propriedade];
    }
    return objeto1;
}

/*
function mesclar ( objeto1, objeto2 ) {
    if ( null == objeto1 || typeof objeto1 != "object" || null == objeto2 || typeof objeto2 != "object" ) 
        return null;
    var chaves = Object.keys(objeto2);
    return recursiveMesclar (objeto1, objeto2, chaves, 0);
}

function recursiveMesclar(objeto1, objeto2, chaves, indice) {
    if ( indice >= chaves.length )
        return objeto1;
    else {
        var propriedade = chaves[indice];
        objeto1[propriedade] = objeto2 [propriedade] ;
        return recursiveMesclar(objeto1, objeto2, chaves, indice + 1);
    }
}
*/