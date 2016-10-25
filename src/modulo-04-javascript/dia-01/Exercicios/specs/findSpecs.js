describe('find()', function() {
    
    it ('find( [ 1, 2, 3 ], maiorIgualADois ) deve retornar [ 2, 3 ] ', function() {
        var resultado = find( [ 1, 2, 3 ], function(elemento) { return elemento >= 2; } );
        expect(resultado).toEqual( [ 2, 3 ] );
    });

    it ('find( [ \'a\', 5, null, false, \'false\' ], ehString ) deve retornar [ \'a\', \'false\' ] ', function() {
        var resultado = find( [ 'a', 5, null, false, 'false' ], function(elem) { return typeof elem === 'string'; } );
        expect(resultado).toEqual( [ 'a', 'false' ] );
    });

    it ('find( [ { nome: \'a\' }, { nome: \'b\' }  ], nomeIgualC ) deve retornar [] ', function() {
        var resultado = find( [ { nome: 'a' }, { nome: 'b' }  ], function(elem) { return typeof elem.nome === 'c'; } );
        expect(resultado).toEqual( [] );
    });

    it ('find( [ 1, 2, 3 ], \'maior ou igual a dois\' ) deve retornar [ 1, 2, 3 ] ', function() {
        var resultado = find( [ 1, 2, 3 ], 'maior ou igual a dois' );
        expect(resultado).toEqual( [1, 2, 3] );
    });
    
});

