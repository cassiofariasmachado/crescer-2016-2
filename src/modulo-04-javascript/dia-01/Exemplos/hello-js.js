console.log('Olá "JS"!');
console.log('Olá \'JS\'!');

console.log("Nome: 'oi' ", elfo.nome);

elfo.flechas = 42;

console.log(elfo.flechas);

delete elfo.nome;
elfo.flechas = undefined;
elfo['Nome Completo'] = 'Legolas da Silva';

// Definindo functions
var outraFuncao = function() {
  console.log('Oi');
}

elfo.atirarFlecha = function(dwarf, opt) {
  dwarf.vida -= 10;
  opt();
  elfo.experiencia++;
}

// IIFE - Aula 2

var dwarf = { vida: 110 };
elfo.atirarFlecha(dwarf, outraFuncao);

console.log(elfo, dwarf);

// "Funções são o coração do javascript" Bernardo

// Verificar tipo da variavel
console.log('Typeof 0.3: ');
console.log(typeof 0.3);

// NaN = Not a number
console.log('Divisão de 0/0: ');
console.log(0/0);

// Infinity
console.log('Divisão de 1/0');
console.log(1/0);

// NaN não é igual a NaN, mas NaN é um number
console.log('NaN não é igual a NaN, mas NaN é um number: ');
console.log(NaN == NaN);
console.log(typeof NaN);

// isNaN(var) == false é um número

// Três iguais: comparação de valores iguais...ganha dinheiro.
// Dois iguais: tenta converter uma das duas variaveis e testa igualdade.. nao ganha dinheiro.

// <strong>Quase!!!!!<strong> sempre melhor incluir os scripts no fim do html.

elfo.nome = 'Fingolfin';
exibirElfoNaTela(elfo);
