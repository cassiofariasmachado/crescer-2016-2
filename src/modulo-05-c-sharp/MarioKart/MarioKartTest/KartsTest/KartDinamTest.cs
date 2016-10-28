using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Karts;

namespace MarioKartTest.KartsTest
{
    [TestClass]
    public class KartDinamTest
    {
        [TestMethod]
        public void KartDinamRecebeODobroDeBonusDoCorredor()
        {
            var corredor = new Corredor("Bowser", NivelDeHabilidade.Noob);
            var kartDinam = new KartDinam(corredor);
            Assert.AreEqual(9, kartDinam.Velocidade);
        }
    }
}
