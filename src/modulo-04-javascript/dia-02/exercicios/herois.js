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

}
