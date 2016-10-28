using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;

namespace MarioKartTest.EquipamentosTest
{
    [TestClass]
    public class UltraPackTest
    {
        [TestMethod]
        public void DeveCriarUltraPackComUmEquipamento()
        {
            var pneuDeCouroDeDragao = new PneusDeCouroDeDragao();
            var ultraPack = new UltraPack(pneuDeCouroDeDragao);
            Assert.AreEqual(pneuDeCouroDeDragao, ultraPack.Equipamento);
        }

        [TestMethod]
        public void DeveRetornarBonusDoEquipamentoMaisVintePorCento()
        {
            var pneuDeCouroDeDragao = new PneusDeCouroDeDragao();
            var ultraPack = new UltraPack(pneuDeCouroDeDragao);
            Assert.AreEqual(3, ultraPack.Bonus);
        }

        [TestMethod]
        public void DeveRetornarUltraPackComUltraPack()
        {
            var pneuDeCouroDeDragao = new PneusDeCouroDeDragao();
            var ultraPack = new UltraPack(pneuDeCouroDeDragao);
            var ultraPackComUltraPack = new UltraPack(ultraPack);
            Assert.AreEqual(pneuDeCouroDeDragao, ultraPack.Equipamento);
            Assert.AreEqual(ultraPack, ultraPackComUltraPack.Equipamento);
            Assert.AreEqual(4, ultraPackComUltraPack.Bonus);
        }
    }
}
