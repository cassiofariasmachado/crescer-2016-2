using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class KartSkyFusion : Kart, IEquipamento
    {
        //TO-DO: Revisar e implementar mais testes
        public KartSkyFusion(Corredor corredor) : base(corredor)
        {
        }

        public int BonusVelocidade
        {
            get
            {
                int bonusDeVelocidadeSkyFusion = this.Equipamentos.Count + 
                                                 this.GetBonusHabilidadeCorredor();
                if (bonusDeVelocidadeSkyFusion > 12)
                    bonusDeVelocidadeSkyFusion += 5;
                return bonusDeVelocidadeSkyFusion;
            }
        }

        public override int GetBonusHabilidadeCorredor()
        {
            int bonusVelocidadeDoCorredorDeSkyFusion = 0;
            if (this.Corredor.NivelDeHabilidade.Equals(NivelDeHabilidade.Noob))
                bonusVelocidadeDoCorredorDeSkyFusion = 1;
            if (this.Corredor.NivelDeHabilidade.Equals(NivelDeHabilidade.Mediano))
                bonusVelocidadeDoCorredorDeSkyFusion = 2;
            if (this.Corredor.NivelDeHabilidade.Equals(NivelDeHabilidade.Profissional))
                bonusVelocidadeDoCorredorDeSkyFusion = 3;
            return base.GetBonusHabilidadeCorredor() + bonusVelocidadeDoCorredorDeSkyFusion;
        }

    }
}
