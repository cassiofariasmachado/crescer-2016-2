using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Equipamentos;

namespace MarioKartTest
{
    [TestClass]
    public class KartTest
    {
        [TestMethod]
        public void KartPossuiCorredor()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new Kart(corredor);
            Assert.AreEqual(kart.Corredor, corredor);
        }

        [TestMethod]
        public void KartPossuiListaDeEquipamentos()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new Kart(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            kart.Equipar(pneusDeCouroDeDragao);
            Assert.IsTrue(kart.Equipamentos.Contains(pneusDeCouroDeDragao));
        }

        [TestMethod]
        public void KartRecebeSomaDeBonusDeEquipamentos()
        {
            var corredor = new Corredor("Donkey Kong", NivelDeHabilidade.Profissional);
            var kart = new Kart(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            var motorABaseDeLava = new MotorABaseDeLava();
            kart.Equipar(pneusDeCouroDeDragao);
            kart.Equipar(motorABaseDeLava);
            Assert.AreEqual(kart.GetSomaDosBonusDeTodosEquipamentos(), 5);
        }

        [TestMethod]
        public void CorredorNoobGanhaBonusDe3()
        {
            var corredor = new Corredor("Luigi", NivelDeHabilidade.Noob);
            var kart = new Kart(corredor);
            Assert.AreEqual(kart.GetBonusHabilidadeCorredor(), 3);
        }

        [TestMethod]
        public void CorredorMedianoGanhaBonusDe5()
        {
            var corredor = new Corredor("Peach", NivelDeHabilidade.Mediano);
            var kart = new Kart(corredor);
            Assert.AreEqual(kart.GetBonusHabilidadeCorredor(), 5);
        }

        [TestMethod]
        public void CorredorProfissionalGanhaBonusDe6MaisQuantidadeDeEquipamentos()
        {
            var corredor = new Corredor("Donkey Kong", NivelDeHabilidade.Profissional);
            var kart = new Kart(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            var motorABaseDeLava = new MotorABaseDeLava();
            kart.Equipar(pneusDeCouroDeDragao);
            kart.Equipar(motorABaseDeLava);
            Assert.AreEqual(kart.GetBonusHabilidadeCorredor(), 8);
        }

        [TestMethod]
        public void KartPossuiVelocidadeDe3MaisASomaDeBonusDosEquipamentosMaisBonusDoCorredor()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new Kart(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            kart.Equipar(pneusDeCouroDeDragao);
            Assert.AreEqual(kart.Velocidade, 10);
        }
    }
}
