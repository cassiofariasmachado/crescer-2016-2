describe('mesclar()', function() {

  it('mesclar(objeto1, objeto2, false) deve retornar { abacaxi: 0, banana: { preco: 200 }, cereja: 97, damasco: 100 }', function() {
    var objeto1 = {
        abacaxi: 0,
        banana: { peso: 52, preco: 100 },
        cereja: 97
    };
    var objeto2 = {
        banana: { preco: 200 },
        damasco: 100
    };
    mesclar(objeto1, objeto2, false);
    expect(objeto1).toEqual( { abacaxi: 0, banana: { preco: 200 }, cereja: 97, damasco: 100 } );
  });

  it('mesclar(objeto2, objeto1, false) deve retornar { banana: { peso: 52, preco: 100 }, damasco: 100, abacaxi: 0, cereja: 97 }', function() {
    var objeto1 = {
        abacaxi: 0,
        banana: { peso: 52, preco: 100 },
        cereja: 97
    };
    var objeto2 = {
        banana: { preco: 200 },
        damasco: 100
    };
    mesclar(objeto2, objeto1, false);
    expect(objeto2).toEqual( { banana: { peso: 52, preco: 100 }, damasco: 100, abacaxi: 0, cereja: 97 } );
  });

  it('mesclar(objeto2, objeto1, true) deve retornar { abacaxi: 0, banana: {peso: 52,preco: 200,origem: {cidade: \'cachoeira do sul\', estado: \'rs\'}},cereja: 97,damasco: 100}', 
  function() {
    var objeto1 = {
      abacaxi: 0,
      banana: { peso: 52, preco: 100, origem: { cidade: 'taquari', estado: 'rs' } },
      cereja: 97
    };
    var objeto2 = {
      banana: { preco: 200, origem: { cidade: 'cachoeira do sul', estado: 'rs' } },
      damasco: 100
    };
    mesclar(objeto1, objeto2, true);
    expect(objeto1).toEqual( { abacaxi: 0, banana: {peso: 52, preco: 200, origem: { cidade: 'cachoeira do sul', estado: 'rs'} }, cereja: 97, damasco: 100 } );
  });

});