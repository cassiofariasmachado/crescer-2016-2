describe('new Herois()', function() {

  it('deve criar um novo objeto Herois recebendo um array com informações dos personagens', function() {
    var herois = new Herois(marvel);
    expect(herois.arrayHerois).toEqual(marvel);
  });

});
