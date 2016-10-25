describe('ctrlC()', function() {
    var origem = { a: '1' };

    it('ctrlC({a: \'1\'}) deve retornar { a: \'1\' }', function() {
        var destino = ctrlC(origem);
        expect(destino).toEqual( { a: '1' } );
    });

    it('origem === destino deve retornar false', function() {
        var destino = ctrlC(origem);
        expect( origem === destino ).toEqual(false);
    });

    it('iguais(origem, destino) deve retornar true', function() {
        var destino = ctrlC(origem);
        expect(iguais(origem, destino)).toEqual(true);
    });

    it('destino.a[2].e() deve retornar 3', function() {
        var destino = ctrlC({ a: [ { b: '1', c: '2' }, { d: false }, { e: function() { return 3; } } ] });
        expect( destino.a[2].e() ).toEqual(3);
    });
  
});