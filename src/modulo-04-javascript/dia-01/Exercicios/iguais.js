// Exercicio 5
function iguais ( objeto1, objeto2 ) {

    function ehObjeto (objeto) {
       return typeof objeto === 'object';
    }

    function qtdPropriedades(obj) {
      return Object.keys(obj).length;
    }

    if (ehObjeto(objeto1) && ehObjeto(objeto2)) {

      if (qtdPropriedades(objeto1) !== qtdPropriedades(objeto2))
        return false;


      for (let prop in objeto1) {
          let saoIguais = iguais(objeto1[prop], objeto2[prop]);
          if (!saoIguais) return false;
      }
      return true;
    }

    return objeto1 === objeto2;

}
