using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Equipamentos;
using MarioKart.Karts;

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
            Assert.AreEqual(corredor, kart.Corredor);
        }

        [TestMethod]
        public void KartEhCriadoComListaVazia()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new Kart(corredor);
            Assert.IsTrue(kart.Equipamentos.Count == 0);
        }

        [TestMethod]
        public void KartPodeEquiparUmEquipamento()
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
            Assert.AreEqual(5, kart.GetSomaDosBonusDeTodosEquipamentos());
        }

        [TestMethod]
        public void CorredorNoobGanhaBonusDe3()
        {
            var corredor = new Corredor("Luigi", NivelDeHabilidade.Noob);
            var kart = new Kart(corredor);
            Assert.AreEqual(3, kart.GetBonusPorNivelDeHabilidadeDoCorredor());
        }

        [TestMethod]
        public void CorredorMedianoGanhaBonusDe5()
        {
            var corredor = new Corredor("Peach", NivelDeHabilidade.Mediano);
            var kart = new Kart(corredor);
            Assert.AreEqual(5, kart.GetBonusPorNivelDeHabilidadeDoCorredor());
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
            Assert.AreEqual(8, kart.GetBonusPorNivelDeHabilidadeDoCorredor());
        }

        [TestMethod]
        public void KartPossuiVelocidadeDe3MaisASomaDeBonusDosEquipamentosMaisBonusDoCorredor()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            var kart = new Kart(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            kart.Equipar(pneusDeCouroDeDragao);
            Assert.AreEqual(10, kart.Velocidade);
        }
    }
}
