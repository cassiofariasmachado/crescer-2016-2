describe('comicMaisCara()', function() {

  it('deve retornar o objeto comic mais caro entre todos personagens que é o sétimo personagem.', function() {
    var herois = new Herois(marvel);
    var resultado = herois.comicMaisCara();
    expect(resultado).toEqual(herois.arrayHerois[6].comics);
  });

  it('deve retornar o objeto comic mais caro entre todos personagens que é o primeiro personagem.', function() {
    var herois = new Herois(marvel);
    herois.arrayHerois[0].comics.items[0].prices[0].price = 200;
    var resultado = herois.comicMaisCara();
    expect(resultado).toEqual(herois.arrayHerois[0].comics);
  });

});
