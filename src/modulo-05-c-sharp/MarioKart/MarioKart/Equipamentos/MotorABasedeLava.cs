using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class MotorABaseDeLava : IEquipamento
    {
        public int BonusVelocidade
        {
            get
            {
                return 3;
            }
        }
    }
}
