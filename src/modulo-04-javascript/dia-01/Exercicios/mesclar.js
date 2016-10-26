function mesclar ( objeto1, objeto2, recursiva = false) {
    for ( var propriedade in objeto2 ) {
        if (recursiva && typeof objeto2[propriedade] === 'object' )
            mesclar(objeto1[propriedade], objeto2[propriedade], recursiva)
        else 
            objeto1[propriedade] = objeto2[propriedade];
    }
}