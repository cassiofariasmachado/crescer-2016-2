describe('foraDaGuerraCivil()', function() {

  var verificaSeNaoParticiparamDaGuerraCivil = function(herois) {
    for (let i = 0, len = herois.length; i < len; i++){
      var items = herois[i].events.items;
      for (let j = 0, len = items.length; j < len; j++) {
        if (items[j].name === "Civil War")
          return false;
      }
    return true;
    }
  }

  it('deve retornar apenas quem não participou da Guerra Civil', function() {
    var arrayHerois = [ {events: {items: [{name:'Civil War'}]}},
                        {events: {items: [{name:'Queda de Sauron'}]}},
                        {events: {items: [{name:'Campeonato de truco'}]}}]
    var herois = new Herois(arrayHerois);
    var resultado = herois.foraDaGuerraCivil();
    expect(verificaSeNaoParticiparamDaGuerraCivil(resultado)).toBeTruthy();
  });

  it('deve retornar apenas quem não participou da Guerra Civil utilizando o arquivo marvel.js', function() {
    var herois = new Herois();
    var resultado = herois.foraDaGuerraCivil();
    expect(verificaSeNaoParticiparamDaGuerraCivil(resultado)).toBeTruthy();
  });


});
