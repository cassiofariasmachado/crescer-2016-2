// Exercicio 2
function diglettDig() {
  for (var i = 1; i <= 100; i++) {
    let valorImprimido = i; // variável de bloco disponivel a partir do JS 6
    if ( divisivelPor15(i) )
      valorImprimido = 'Diglett dig, trio trio';
    else if ( divisivelPor3(i) )
      valorImprimido = 'Diglett dig';
    else if ( divisivelPor5(i) )
      valorImprimido = 'trio trio trio';
    console.log(valorImprimido);
  }
}

function divisivelPor3(numero) {
  return numero % 3 === 0;
}

function divisivelPor5(numero) {
  return numero % 5 === 0;
}

function divisivelPor15(numero) {
  return numero % 15 === 0;
}

diglettDig();
