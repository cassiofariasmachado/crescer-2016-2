describe('seriesPorLongevidade()', function() {

  var verificaOrdemDescendenteDeLongevidade = function (series) {
    for (let i = 0, len = series.length; i + 1 < len; i++){
      let serieAtual = series[i];
      let proximaSerie = series[i + 1];
      let longevidadeSerieAtual = serieAtual.endYear - serieAtual.startYear;
      let longevidadeProximaSerie = proximaSerie.endYear - proximaSerie.startYear;
      if (longevidadeProximaSerie > longevidadeSerieAtual)
        return false;
    }
    return true;
  }
  
  it('deve retornar todas as séries dos personagens', function() {
    var herois = new Herois(marvel);
    var resultado = herois.seriesPorLongevidade();
    expect(resultado.length).toEqual(64);
  });


  it('deve retornar todas as séries dos personagens ordenadas por tempo de atividade descendente', function() {
    var herois = new Herois(marvel);
    var resultado = herois.seriesPorLongevidade();
    expect(verificaOrdemDescendenteDeLongevidade(resultado)).toBeTruthy();
  });

});
