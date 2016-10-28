using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class FogueteDePlutonio : IEquipamento
    {
        public FogueteDePlutonio(int nivel = 2)
        {
            bool nivelEntreUmECinco = nivel >= 1 && nivel <= 5;
            this.Nivel = nivelEntreUmECinco ? nivel : 2;
        }

        public int Bonus
        {
            get
            {
                return this.Nivel;
            }
        }

        public int Nivel { get; }

    }
}
