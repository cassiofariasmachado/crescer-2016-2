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
    public class PersonagemRepositorioAdo : RepositorioBase, IPersonagemRepositorio
    {
        public Personagem BuscarPersonagemPorId(int id)
        {
            Personagem personagem = null;

            using (var connection = new SqlConnection(ConnectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Id = @param_id";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_id", id));

                SqlDataReader reader = command.ExecuteReader();

                if (reader.Read())
                {
                    personagem = this.ConverterReaderParaPersonagem(reader);
                }

                connection.Close();
            }
            return personagem;
        }

        public void EditarPersonagem(Personagem personagem)
        {
            using (var connection = new SqlConnection(ConnectionString))
            {
                connection.Open();

                string sql = $"UPDATE Personagem SET Nome = @param_nome," +
                                                    "DataNascimento = CONVERT(DATETIME, @param_dataNascimento, 103), " +
                                                    "Altura = @param_altura, " +
                                                    "Peso = @param_peso, " +
                                                    "Origem = @param_origem, " +
                                                    "GolpesEspeciais = @param_golpesEspeciais, " +
                                                    "UrlDaImagem = @param_urlDaImagem," +
                                                    "PersonagemOculto = @param_personagemOculto " +
                                                    "FROM Personagem " + 
                                                    "WHERE Id = @param_id";

                var command = new SqlCommand(sql, connection);

                var parametros = this.GetParametersDePersonagem(personagem);
                parametros.Add(new SqlParameter("param_id", personagem.Id));
                foreach (SqlParameter parametro in parametros)
                {
                    command.Parameters.Add(parametro);
                }
                    
                command.ExecuteNonQuery();

                connection.Close();
            }
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            using (var connection = new SqlConnection(ConnectionString))
            {
                connection.Open();

                string sql = $"DELETE FROM Personagem WHERE Id = @param_id";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_id", personagem.Id));

                command.ExecuteNonQuery();

                connection.Close();
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            using (var connection = new SqlConnection(ConnectionString))
            {
                connection.Open();

                string sql = $"INSERT INTO Personagem (Nome, DataNascimento, Altura, Peso, Origem, GolpesEspeciais, UrlDaImagem, PersonagemOculto) " +
                                           "VALUES(@param_nome, CONVERT(DATETIME, @param_dataNascimento, 103), @param_altura, @param_peso, " +
                                                  "@param_origem, @param_golpesEspeciais, @param_urlDaImagem, @param_personagemOculto)";
                                                   

                var command = new SqlCommand(sql, connection);

                var parametros = this.GetParametersDePersonagem(personagem);
                foreach (SqlParameter parametro in parametros)
                {
                    command.Parameters.Add(parametro);
                }

                command.ExecuteNonQuery();

                connection.Close();
            }
        }

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            List<Personagem> personagens = new List<Personagem>();

            using (var connection = new SqlConnection(ConnectionString))
            {
                connection.Open();

                string sql = "";
                var parametros = new List<SqlParameter>();

                if (filtroNome == null)
                {
                     sql = $"SELECT * FROM Personagem";
                }
                else
                {
                    sql = $"SELECT * FROM Personagem WHERE Nome LIKE @param_filtroNome";
                    parametros.Add(new SqlParameter("param_filtroNome", $"%{filtroNome}%"));
                }

                var command = new SqlCommand(sql, connection);

                foreach (var parametro in parametros)
                {
                    command.Parameters.Add(parametro);
                }

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    personagens.Add(this.ConverterReaderParaPersonagem(reader));
                }

                connection.Close();
            }
            return personagens;
        }

        private Personagem ConverterReaderParaPersonagem(SqlDataReader reader)
        {
            return new Personagem( id: Convert.ToInt32(reader["Id"]),
                                   nome: reader["Nome"].ToString(),
                                   dataNascimento: Convert.ToDateTime(reader["DataNascimento"]),
                                   altura: Convert.ToInt32(reader["Altura"]),
                                   peso: Convert.ToDouble(reader["Peso"]),
                                   origem: reader["Origem"].ToString(),
                                   golpesEspeciais: reader["GolpesEspeciais"].ToString(),
                                   urlDaImagem: reader["UrlDaImagem"].ToString(),
                                   personagemOculto: Convert.ToBoolean(reader["PersonagemOculto"]) );
        }

        private List<SqlParameter> GetParametersDePersonagem(Personagem personagem)
        {
            var parametros = new List<SqlParameter>();

            parametros.Add(new SqlParameter("param_nome", personagem.Nome));
            parametros.Add(new SqlParameter("param_dataNascimento", personagem.DataNascimento.ToString("dd/MM/yyyy")));
            parametros.Add(new SqlParameter("param_altura", personagem.Altura));
            parametros.Add(new SqlParameter("param_peso", personagem.Peso));
            parametros.Add(new SqlParameter("param_origem", personagem.Origem));
            parametros.Add(new SqlParameter("param_golpesEspeciais", personagem.GolpesEspeciais));
            parametros.Add(new SqlParameter("param_urlDaImagem", personagem.UrlDaImagem));
            parametros.Add(new SqlParameter("param_personagemOculto", Convert.ToByte(personagem.PersonagemOculto)));

            return parametros;
        }
    }
}
