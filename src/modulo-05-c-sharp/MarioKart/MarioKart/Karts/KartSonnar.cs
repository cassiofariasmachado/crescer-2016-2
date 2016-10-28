using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class KartSonnar : Kart
    {
        public KartSonnar(Corredor corredor) : base(corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                return base.Velocidade + this.GetBonusDoKartSonnar();
            }
        }

        private int GetBonusDoKartSonnar()
        {
            // Sonnar: possui + 2 de velocidade se possuir pelo menos 1 equipamento.
            bool possuiUmOuMaisEquipamentos = this.Equipamentos.Count > 0;
            int bonusDoKartSonnar = possuiUmOuMaisEquipamentos ? 2 : 0;
            return bonusDoKartSonnar;
        }

    }
}
