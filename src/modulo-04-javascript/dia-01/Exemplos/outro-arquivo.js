// Definindo um objeto
var elfo = { nome: 'Legolas', experiencia: 1 };

function exibirElfoNaTela(elfo) {

  alert( maisculo(elfo.nome) );

  function maisculo (texto) {
    return texto.toUpperCase();
  }

}

// Definindo e ja chamando a funcao
(function imprimeArray (array) {
  for (var i = 0, len = array.lenght; i < len; i++) {
    console.log(array[i]);
  }
  console.log(i);
})( [4, '3', false, 'oi'] )

// imprimeArray() não funciona, pois imprimeArray não foi definido globalmente

// Dois escopos: globais e dentro de functions
// Exemplo: if não gera um escopo..
// Variaves e functions definidas dentro do escopo de uma function so existem dentro dela.
// Rooinstin: organiza declarações primeiro

// Para verificar se alguma variavel é undefined
typeof goku === 'undefined'

// Funcao anonima
var maisculo = function (texto) {
  texto.toUpperCase();

}

// Arrays
var array = [1, 2, 3]
var array2 = [1, null, '2', {nome: 'Nome qualquer'} ]

for (var i = 0, len = array.lenght; i < len; i++) {
  console.log(array[i]);
}
