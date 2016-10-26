describe('maisPublicado()', function() {

  it('deve retornar o objeto Herois que possui mais comics publicadas', function() {
    var herois = new Herois(marvel);
    var resultado = herois.maisPublicado();
    expect(resultado).toEqual(marvel[7]);
  });

});
