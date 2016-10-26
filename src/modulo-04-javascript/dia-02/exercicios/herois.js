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

}
