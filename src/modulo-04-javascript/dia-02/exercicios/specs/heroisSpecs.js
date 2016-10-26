describe('new Herois()', function() {

  it('deve criar um novo objeto Herois recebendo um array com informações dos personagens', function() {
    var heroi = {id: 8888888, name: 'Homem-aranha', description: 'O aranha'};
    var herois = new Array(heroi);
    var resultado = new Herois(herois);
    expect(resultado.arrayHerois).toEqual(herois);
    expect(resultado.arrayHerois[0]).toEqual(heroi);
  });

  it('deve criar um novo objeto Herois recebendo o array do arquivo marve.js', function() {
    var herois = new Herois(marvel);
    expect(herois.arrayHerois).toEqual(marvel);
  });

});
