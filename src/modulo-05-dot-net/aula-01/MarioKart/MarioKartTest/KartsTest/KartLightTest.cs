using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Karts;

namespace MarioKartTest.KartsTest
{
    [TestClass]
    public class KartLightTest
    {
        [TestMethod]
        public void KartLightRecebeBonusDeMais3SeNivelDeHabilidadeDoCorredorEhNoob()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Noob);
            var kartLight = new KartLight(corredor);
            var velocidade = kartLight.Velocidade;
            Assert.AreEqual(9, kartLight.Velocidade);
        }

        [TestMethod]
        public void KartLightRecebeBonusDeMenos1SeNivelDeHabilidadeDoCorredorEhProfissional()
        {
            var corredor = new Corredor("Luigi", NivelDeHabilidade.Profissional);
            var kartLight = new KartLight(corredor);
            var velocidade = kartLight.Velocidade;
            Assert.AreEqual(8, kartLight.Velocidade);
        }

        [TestMethod]
        public void KartLightNaoRecebeBonusSeNivelDeHabilidadeDoCorredorEhMediano()
        {
            var corredor = new Corredor("Luigi", NivelDeHabilidade.Mediano);
            var kartLight = new KartLight(corredor);
            var velocidade = kartLight.Velocidade;
            Assert.AreEqual(8, kartLight.Velocidade);
        }

    }
}
