describe('ctrlC()', function() {
    var origem = { a: '1' };

    it('deve retornar uma copia do objeto', function() {
        var destino = ctrlC(origem);
        expect(destino).toEqual( { a: '1' } );
    });

    it('deve retornar false para comparação da referência', function() {
        var destino = ctrlC(origem);
        expect( origem === destino ).toBeFalsy();
    });

    it('deve retornar true para a comparação com a função iguais()', function() {
        var destino = ctrlC(origem);
        expect(iguais(origem, destino)).toBeTruthy();
    });

    it('deve retornar uma copia completa do objeto', function() {
        var destino = ctrlC({ a: [ { b: '1', c: '2' }, { d: false }, { e: function() { return 3; } } ] });
        expect( destino.a[2].e() ).toEqual(3);
    });

});
