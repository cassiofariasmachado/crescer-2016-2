using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;

namespace MarioKartTest.EquipamentosTest
{
    [TestClass]
    public class PneusDeCouroDeDragaoTest
    {
        [TestMethod]
        public void PneuDeCouroDeDragaoTem2DeBonus()
        {
            var pneusDeCouroDeDragao = new PneusDeCouroDeDragao();
            Assert.AreEqual(2, pneusDeCouroDeDragao.BonusVelocidade);
        }
    }
}
