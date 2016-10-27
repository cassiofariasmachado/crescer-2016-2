using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;

namespace MarioKartTest.EquipamentosTest
{
    [TestClass]
    public class PneuDeCouroDeDragaoTest
    {
        [TestMethod]
        public void PneuDeCouroDeDragaoTem2DeBonus()
        {
            var pneuDeCouroDeDragao = new PneuDeCouroDeDragao();
            Assert.AreEqual(pneuDeCouroDeDragao.Bonus, 2);
        }
    }
}
