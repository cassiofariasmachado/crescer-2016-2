using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;

namespace MarioKartTest
{
    [TestClass]
    public class CorredorTest
    {
        [TestMethod]
        public void CorredorNasceComNome()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Noob);
            Assert.AreEqual(corredor.Nome, "Mario");
        }

        [TestMethod]
        public void CorredorNasceComNivelDeHabilidade()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Mediano);
            Assert.AreEqual(corredor.NivelDeHabilidade, NivelDeHabilidade.Mediano);
        }

    }
}
