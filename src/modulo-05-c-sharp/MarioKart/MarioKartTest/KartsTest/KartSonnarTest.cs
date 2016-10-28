using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Karts;
using MarioKart.Equipamentos;

namespace MarioKartTest.KartsTest
{
    [TestClass]
    public class KartSonnarTest
    {
        [TestMethod]
        public void KartSonnarRecebeBonusDe2SePossuirPeloMenosUmEquipamento()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kartSonnar = new KartSonnar(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            kartSonnar.Equipar(pneusDeCouroDeDragao);
            Assert.AreEqual(14, kartSonnar.Velocidade);
        }

        [TestMethod]
        public void KartSonnarNaoRecebeBonusDe2SeNaoPossuirPeloMenosUmEquipamento()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kartSonnar = new KartSonnar(corredor);
            Assert.AreEqual(9, kartSonnar.Velocidade);
        }

    }
}
