describe('find()', function() {

    it ('deve retornar um novo array apenas com os números maiores ou iguais a dois', function() {
        var resultado = find( [ 1, 2, 3 ], function(elemento) { return elemento >= 2; } );
        expect(resultado).toEqual( [ 2, 3 ] );
    });

    it ('deve retornar um novo array apenas com as strings', function() {
        var resultado = find( [ 'a', 5, null, false, 'false' ], function(elem) { return typeof elem === 'string'; } );
        expect(resultado).toEqual( [ 'a', 'false' ] );
    });

    it ('deve retornar um array vazio, pois não existe objetos iguais a { nome: c }', function() {
        var resultado = find( [ { nome: 'a' }, { nome: 'b' }  ], function(elem) { return typeof elem.nome === 'c'; } );
        expect(resultado).toEqual( [] );
    });

    it ('deve retornar array vazio quando não passada uma função', function() {
        var resultado = find( [ 1, 2, 3 ], 'maior ou igual a dois' );
        expect(resultado).toEqual( [] );
    });

});
