using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Karts;

namespace MarioKartTest.KartsTest
{
    [TestClass]
    public class KartSkyFusionTest
    {
        //TO-DO: Revisar e implementar mais testes
        [TestMethod]
        public void DeveRetornarBonusVelocidadeDoKartSkyFusion()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Noob);
            var kartSkyFusion = new KartSkyFusion(corredor);
            Assert.AreEqual(4, kartSkyFusion.BonusVelocidade);
        }

        [TestMethod]
        public void DeveRetornarVelocidadeDoKartSkyFusion()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Noob);
            var kartSkyFusion = new KartSkyFusion(corredor);
            Assert.AreEqual(7, kartSkyFusion.Velocidade);
        }


    }
}
