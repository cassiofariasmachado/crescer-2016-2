using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
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

        public virtual int Velocidade {
            get
            {   /*
                 *  A velocidade de um kart é a seguinte soma: 
                 *  3 + a soma dos bônus de todos os equipamentos 
                 *  + bônus de habilidade do 
                 *  Corredor (
                 *              Noob: 3, 
                 *              Mediano: 5, 
                 *              Profissional: 6 + quantidade de equipamentos no kart
                 *           ). 
                 */ 
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
            this.Equipamentos.ForEach(equipamento => somaTodosBonus += equipamento.BonusVelocidade);
            return somaTodosBonus;
        }

        public virtual int GetBonusPorNivelDeHabilidadeDoCorredor()
        {
            // Bônus de habilidade do Corredor (Noob: 3, Mediano: 5, Profissional: 6 + quantidade de equipamentos no kart)
            if (Corredor.NivelDeHabilidade.Equals(NivelDeHabilidade.Profissional))
                return (int)this.Corredor.NivelDeHabilidade + this.Equipamentos.Count;
            return (int)this.Corredor.NivelDeHabilidade;
        }

    }
}
