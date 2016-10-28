using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class UltraPack : IEquipamento
    {
        public UltraPack(IEquipamento equipamento)
        {
            this.Equipamento = equipamento;
        }

        public int Bonus
        {
            get
            {
                return (int) Math.Ceiling(Equipamento.Bonus * 1.2);
            }
        }

        public IEquipamento Equipamento { get; }
    }
}
