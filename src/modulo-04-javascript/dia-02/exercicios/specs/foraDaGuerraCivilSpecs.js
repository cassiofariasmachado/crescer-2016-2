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
    var herois = new Herois(marvel);
    var resultado = herois.foraDaGuerraCivil();
    expect(verificaSeNaoParticiparamDaGuerraCivil(resultado)).toBeTruthy();
  });

});
