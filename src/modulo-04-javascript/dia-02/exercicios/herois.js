class Herois {

  constructor( arrayHerois = marvel ) {
      this.arrayHerois = arrayHerois;
  }

  foraDaGuerraCivil() {
    function naoParticipouGuerraCivil (heroi) {
      var items = heroi.events.items;
      for (let indice in items) {
        if (items[indice].name === "Civil War")
          return false;
      }
      return true;
    }
    return this.arrayHerois.filter(naoParticipouGuerraCivil);
  }

  maisPublicado() {
    var availableMaisPublicado = 0;
    var maisPublicado;
    for (let indice in this.arrayHerois){
      if (this.arrayHerois[indice].comics.available > availableMaisPublicado) {
        maisPublicado = this.arrayHerois[indice];
        availableMaisPublicado = maisPublicado.comics.available;
      }
    }
    return maisPublicado;
  }

  mediaPaginas() {
    var totalPaginas = 0;
    var totalComics = 0;
    for (let i in this.arrayHerois){
      let items = this.arrayHerois[i].comics.items;
      totalComics += items.length;
      for (let j in items) {
          totalPaginas += items[j].pageCount;
      }
    }
    return totalPaginas / totalComics;
  }

  seriesPorLongevidade() {
    function longevidade (element1, element2) {
      let longevidade1 = element1.endYear - element1.startYear;
      let longevidade2 = element2.endYear - element2.startYear;
      if (longevidade1 > longevidade2) {
          return -1;
      }
      if (longevidade1 < longevidade2) {
        return 1;
      }
      return 0;
    }

    let retorno = [];
    for (let i in this.arrayHerois){
      let items = this.arrayHerois[i].series.items;
      for (let j in items) {
          retorno = retorno.concat(items[j])
      }
    }

    return retorno.sort(longevidade);
  }
}
