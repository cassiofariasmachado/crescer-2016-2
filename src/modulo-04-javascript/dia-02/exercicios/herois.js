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

}
