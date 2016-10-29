using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using MarioKart.Karts;
using MarioKart.Equipamentos;

namespace MarioKartTest.KartsTest
{
    [TestClass]
    public class KartSkyFusionTest
    {
        [TestMethod]
        public void DeveRetornarBonusVelocidadeDoKartSkyFusionComCorredorNoob()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Noob);
            var kartSkyFusion = new KartSkyFusion(corredor);
            Assert.AreEqual(1, kartSkyFusion.BonusVelocidade);
        }

        [TestMethod]
        public void DeveRetornarVelocidadeDoKartSkyFusionComCorredorNoob()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Noob);
            var kartSkyFusion = new KartSkyFusion(corredor);
            Assert.AreEqual(6, kartSkyFusion.Velocidade);
        }

        [TestMethod]
        public void DeveRetornarBonusVelocidadeDoKartSkyFusionComCorredorMediano()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Mediano);
            var kartSkyFusion = new KartSkyFusion(corredor);
            Assert.AreEqual(2, kartSkyFusion.BonusVelocidade);
        }

        [TestMethod]
        public void DeveRetornarVelocidadeDoKartSkyFusionComCorredorMediano()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Mediano);
            var kartSkyFusion = new KartSkyFusion(corredor);
            Assert.AreEqual(8, kartSkyFusion.Velocidade);
        }

        [TestMethod]
        public void DeveRetornarBonusVelocidadeDoKartSkyFusionComCorredorProfissional()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kartSkyFusion = new KartSkyFusion(corredor);
            Assert.AreEqual(3, kartSkyFusion.BonusVelocidade);
        }

        [TestMethod]
        public void DeveRetornarVelocidadeDoKartSkyFusionComCorredorProfissional()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kartSkyFusion = new KartSkyFusion(corredor);
            Assert.AreEqual(9, kartSkyFusion.Velocidade);
        }

        [TestMethod]
        public void DeveRetornarBonusVelocidadeDoKartSkyFusionComCorredorNoobEUmEquipamento()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Noob);
            var kartSkyFusion = new KartSkyFusion(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            kartSkyFusion.Equipar(pneusDeCouroDeDragao);
            Assert.AreEqual(2, kartSkyFusion.BonusVelocidade);
        }

        [TestMethod]
        public void DeveRetornarVelocidadeDoKartSkyFusionComCorredorNoobEUmEquipamento()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Noob);
            var kartSkyFusion = new KartSkyFusion(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            kartSkyFusion.Equipar(pneusDeCouroDeDragao);
            Assert.AreEqual(8, kartSkyFusion.Velocidade);
        }

        [TestMethod]
        public void DeveRetornarBonusVelocidadeDoKartSkyFusionComCorredorMedianoEUmEquipamento()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Mediano);
            var kartSkyFusion = new KartSkyFusion(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            kartSkyFusion.Equipar(pneusDeCouroDeDragao);
            Assert.AreEqual(3, kartSkyFusion.BonusVelocidade);
        }

        [TestMethod]
        public void DeveRetornarVelocidadeDoKartSkyFusionComCorredorMedianoEUmEquipamento()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Mediano);
            var kartSkyFusion = new KartSkyFusion(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            kartSkyFusion.Equipar(pneusDeCouroDeDragao);
            Assert.AreEqual(10, kartSkyFusion.Velocidade);
        }

        [TestMethod]
        public void DeveRetornarBonusVelocidadeDoKartSkyFusionComCorredorProfissionalEUmEquipamento()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kartSkyFusion = new KartSkyFusion(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            kartSkyFusion.Equipar(pneusDeCouroDeDragao);
            Assert.AreEqual(4, kartSkyFusion.BonusVelocidade);
        }

        [TestMethod]
        public void DeveRetornarVelocidadeDoKartSkyFusionComCorredorProfissionalEUmEquipamento()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kartSkyFusion = new KartSkyFusion(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            kartSkyFusion.Equipar(pneusDeCouroDeDragao);
            Assert.AreEqual(12, kartSkyFusion.Velocidade);
        }

        [TestMethod]
        public void DeveRetornarBonusVelocidadeDoKartSkyFusionComCorredorNoobEDezEquipamento()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Noob);
            var kartSkyFusion = new KartSkyFusion(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            for (int i = 0; i < 10; i++)
            {
                kartSkyFusion.Equipar(pneusDeCouroDeDragao);
            }
            Assert.AreEqual(11, kartSkyFusion.BonusVelocidade);
        }

        [TestMethod]
        public void DeveRetornarVelocidadeDoKartSkyFusionComCorredorNoobEDezEquipamento()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Noob);
            var kartSkyFusion = new KartSkyFusion(corredor);
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            for (int i = 0; i < 10; i++)
            {
                kartSkyFusion.Equipar(pneusDeCouroDeDragao);
            }
            Assert.AreEqual(26, kartSkyFusion.Velocidade);
        }

        [TestMethod]
        public void DeveRetornarBonusVelocidadeDoKartSkyFusionQuandoEquipadoPorUmKart()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Mediano);
            var kart = new Kart(corredor);
            var kartSkyFusion = new KartSkyFusion(corredor);
            kartSkyFusion.Equipar(new PneusDeCouroDeDragao());
            kart.Equipar(kartSkyFusion);
            Assert.AreEqual(11, kart.Velocidade);
        }

    }
}
