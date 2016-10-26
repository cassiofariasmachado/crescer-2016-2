describe('mediaPaginas()', function() {

  it('deve retornar a media de paginas por comics do heroi que possui mais comics publicadas', function() {
    var herois = new Herois(marvel);
    var resultado = herois.mediaPaginas();
    expect(resultado).toEqual(37.03125);
  });

});
