using StreetFighter.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;
using System.Configuration;
using System.Data.SqlClient;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorioAdo : IPersonagemRepositorio
    {
        public Personagem BuscarPersonagemPorId(int id)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighterConnection"].ConnectionString;

            Personagem personagem = null;

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Id = @param_id";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_id", id));

                SqlDataReader reader = command.ExecuteReader();

                if (reader.Read())
                {
                    int idLinha = Convert.ToInt32(reader["Id"]);
                    string nomeLinha = reader["Nome"].ToString();
                    DateTime dataNascimentoLinha = Convert.ToDateTime(reader["DataNascimento"]);
                    int alturaLinha = Convert.ToInt32(reader["Altura"]);
                    double pesoLinha = Convert.ToDouble(reader["Peso"]);
                    string origemLinha = reader["Origem"].ToString();
                    string golpesEspeciaisLinha = reader["GolpesEspeciais"].ToString();
                    string urlDaImagemLinha = reader["UrlDaImagem"].ToString();
                    bool personagemOcultoLinha = Convert.ToBoolean(reader["PersonagemOculto"]);

                    personagem = new Personagem( id: idLinha,
                                                 nome: nomeLinha,
                                                 dataNascimento: dataNascimentoLinha,
                                                 altura: alturaLinha,
                                                 peso: pesoLinha,
                                                 origem: origemLinha,
                                                 golpesEspeciais: golpesEspeciaisLinha,
                                                 urlDaImagem: urlDaImagemLinha,
                                                 personagemOculto: personagemOcultoLinha );
                }

                connection.Close();
            }
            return personagem;
        }

        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            throw new NotImplementedException();
        }
    }
}
