using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;

namespace MarioKartTest.EquipamentosTest
{
    [TestClass]
    public class FogueteDePlutonioTest
    {
        [TestMethod]
        public void DeveCriarFogueteDePlutonioComNivelEntreUmECinco()
        {
            var fogueteDePlutonio = new FogueteDePlutonio(5);
            Assert.AreEqual(5, fogueteDePlutonio.Nivel);
        }

        [TestMethod]
        public void DeveCriarFogueteDePlutonioComNivelDoisQuandoNaoInformado()
        {
            var fogueteDePlutonio = new FogueteDePlutonio();
            Assert.AreEqual(2, fogueteDePlutonio.Nivel);
        }

        [TestMethod]
        public void DeveCriarFogueteDePlutonioComNivelDoisQuandoNivelInvalido()
        {
            var fogueteDePlutonio = new FogueteDePlutonio(10);
            Assert.AreEqual(2, fogueteDePlutonio.Nivel);
        }

        [TestMethod]
        public void DeveRetornarBonusDeUmPorNivel()
        {
            var fogueteDePlutonio = new FogueteDePlutonio(5);
            Assert.AreEqual(5, fogueteDePlutonio.BonusVelocidade);
        }

    }
}
