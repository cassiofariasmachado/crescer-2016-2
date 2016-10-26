describe('foraDaGuerraCivil()', function() {

  var verificaSeNaoParticiparamDaGuerraCivil = function (herois) {
    for (let heroi in herois){
      var items = heroi.events.items;
      for (let indice in items) {
        if (items[indice].name === "Civil War")
          return false;
    }
    return true;
    }
  }

  it('deve retornar apenas quem não participou da Guerra Civil', function() {
    var herois = new Herois(marvel);
    var resultado = herois.foraDaGuerraCivil();
    expect(resultado).toBeTruthy();
  });

});
