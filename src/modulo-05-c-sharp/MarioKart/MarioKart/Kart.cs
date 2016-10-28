using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Kart
    {
        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
            this.Equipamentos = new List<IEquipamento>();
        }

        public Corredor Corredor { get; }

        public List<IEquipamento> Equipamentos { get; }

        public int Velocidade {
            get
            {
                return 3 + this.GetSomaDosBonusDeTodosEquipamentos() + GetBonusHabilidadeCorredor(); 
            }
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        public int GetSomaDosBonusDeTodosEquipamentos()
        {
            int somaTodosBonus = 0;
            this.Equipamentos.ForEach(equipamento => somaTodosBonus += equipamento.Bonus);
            return somaTodosBonus;
        }

        public int GetBonusHabilidadeCorredor()
        {
            if (Corredor.NivelDeHabilidade.Equals(NivelDeHabilidade.Profissional))
                return (int)this.Corredor.NivelDeHabilidade + this.Equipamentos.Count;
            return (int)this.Corredor.NivelDeHabilidade;
        }

    }
}
