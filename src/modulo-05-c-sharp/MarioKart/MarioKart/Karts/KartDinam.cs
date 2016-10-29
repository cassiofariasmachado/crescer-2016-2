using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class KartDinam : Kart
    {
        public KartDinam(Corredor corredor) : base(corredor)
        {
        }

        public override int GetBonusPorNivelDeHabilidadeDoCorredor()
        {
            //Dinam: dobra o bônus de velocidade que o kart ganha do corredor (e apenas do corredor).
            return base.GetBonusPorNivelDeHabilidadeDoCorredor() * 2;
        }
    }
}
