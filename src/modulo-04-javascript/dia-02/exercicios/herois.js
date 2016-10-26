class Herois {

  constructor( arrayHerois = marvel ) {
      this.arrayHerois = arrayHerois;
  }

  foraDaGuerraCivil() {
    return this.arrayHerois.filter(heroi => heroi.events.items.every(element => element.name !== 'Civil War'));
  }

  maisPublicado() {
    let herois = [].concat(this.arrayHerois);
    return herois.sort( (herois1, herois2) => herois2.comics.available - herois1.comics.available)[0];
  }

  mediaPaginas() {
    var totalPaginas = 0;
    var totalComics = 0;
    for (let i = 0, len = this.arrayHerois.length; i < len; i++){
      let items = this.arrayHerois[i].comics.items;
      totalComics += items.length;
      for (let j = 0, len = items.length; j < len; j++) {
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
    for (let i = 0, len = this.arrayHerois.length; i < len; i++){
      let items = this.arrayHerois[i].series.items;
      for (let j = 0, len = items.length; j < len; j++) {
          retorno = retorno.concat(items[j])
      }
    }

    return retorno.sort(longevidade);
  }

  comicMaisCara() {
    let comicMaisCara;
    let valorComicMaisCara = 0;

    for (let i = 0, len = this.arrayHerois.length; i < len; i++){
      let comic = this.arrayHerois[i].comics;
      let items = comic.items;
      let somaValorComicAtual = 0;
      for (let j = 0, len = items.length; j < len; j++ ) {
          let prices = items[j].prices;
          for (let k = 0, len = prices.length; k < len; k++)
            somaValorComicAtual += prices[k].price;
      }
      if (somaValorComicAtual > valorComicMaisCara) {
        comicMaisCara = comic;
        valorComicMaisCara = somaValorComicAtual;
      }
    }
    return comicMaisCara;
  }

}
