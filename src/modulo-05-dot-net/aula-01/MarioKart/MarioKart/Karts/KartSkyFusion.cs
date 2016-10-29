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
        public KartSkyFusion(Corredor corredor) : base(corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                // Se a velocidade do SKY FUSION!!! for maior que 12, concede + 5 de bônus.
                int velocidadeDoSkyFusion = base.Velocidade;
                if (velocidadeDoSkyFusion > 12)
                    velocidadeDoSkyFusion += 5;
                return base.Velocidade;
            }
        }

        public int BonusVelocidade
        {
            get
            {   
                /* Bônus:
                 * +1 por equipamento equipado.
                 * +1 por nível de habilidade do corredor(Noob 1, Mediano 2, Profissional 3)
                 */
                 return this.Equipamentos.Count + this.GetBonusVelocidadePorNivelDeHabilidadeDoCorredorDoSkyFusion();
            }
        }

        public int GetBonusVelocidadePorNivelDeHabilidadeDoCorredorDoSkyFusion()
        {
            // +1 por nível de habilidade do corredor(Noob 1, Mediano 2, Profissional 3)
            int bonusVelocidadeDoCorredorDeSkyFusion = 0;
            if (this.Corredor.NivelDeHabilidade.Equals(NivelDeHabilidade.Noob))
                bonusVelocidadeDoCorredorDeSkyFusion = 1;
            if (this.Corredor.NivelDeHabilidade.Equals(NivelDeHabilidade.Mediano))
                bonusVelocidadeDoCorredorDeSkyFusion = 2;
            if (this.Corredor.NivelDeHabilidade.Equals(NivelDeHabilidade.Profissional))
                bonusVelocidadeDoCorredorDeSkyFusion = 3;
            return bonusVelocidadeDoCorredorDeSkyFusion;
        }

    }
}
