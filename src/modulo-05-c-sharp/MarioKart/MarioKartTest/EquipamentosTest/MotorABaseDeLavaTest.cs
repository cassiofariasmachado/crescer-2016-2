using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;

namespace MarioKartTest.EquipamentosTest
{
    [TestClass]
    public class MotorABaseDeLavaTest
    {
        [TestMethod]
        public void MotorABaseDeLavaTem3DeBonus()
        {
            var motorABaseDeLava = new MotorABaseDeLava();
            Assert.AreEqual(3, motorABaseDeLava.BonusVelocidade);
        }
    }
}
