using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class KartLight : Kart
    {
        public KartLight(Corredor corredor) : base(corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                return base.Velocidade + this.GetBonusDoKartLight();
            }
        }

        private int GetBonusDoKartLight()
        {
            // Light: ganha velocidade + 3 se dirigido por um corredor Noob, perde 1 de velocidade se dirigido por um corredor Profissional
            bool corredorNoob = this.Corredor.NivelDeHabilidade.Equals(NivelDeHabilidade.Noob);
            bool corredorProfissional = this.Corredor.NivelDeHabilidade.Equals(NivelDeHabilidade.Profissional);
            if (corredorNoob)
                return 3;
            if (corredorProfissional)
                return -1;
            return 0;
        }

    }
}
