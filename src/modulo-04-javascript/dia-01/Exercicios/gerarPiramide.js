// Exericios 1
function gerarPiramide(tamanho) {
  for (var i = 2; i <= tamanho + 1; i++) {
    console.log( Array(i).join('R$') );
  }
}

gerarPiramide(3);
gerarPiramide(9);
