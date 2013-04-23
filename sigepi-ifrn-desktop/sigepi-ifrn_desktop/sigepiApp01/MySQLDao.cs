using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data.MySqlClient;
using System.Configuration;
using System.Windows.Forms;

namespace sigepiApp01
{
    class MySQLDao
    {
        private static readonly MySQLDao instanciaMySQL = new MySQLDao();

        private MySQLDao() { }

        public static MySQLDao getInstancia()
        {
            return instanciaMySQL;
        }

        public MySqlConnection getConexao()
        {
            string conn = ConfigurationManager.ConnectionStrings["sigepiApp01.Properties.Settings.sigepi2ConnectionString"].ToString();
            return new MySqlConnection(conn);
        }

        public static bool VerificaLogin(String login, String senha)
        {
            bool result = false;
            string StringDeConexao = "server=localhost;uid=root;pwd=root;database=sigepi2";

            using (MySqlConnection conexaoMySQL = MySQLDao.getInstancia().getConexao())
            {
                conexaoMySQL.ConnectionString = StringDeConexao;
                try
                {
                    conexaoMySQL.Open();
                    string mSQL = "select * from usuario where login = '" + login + "' and nome = '" + senha + "' and is_administrador = 1 " + "  ;";
                    MySqlCommand cmd = new MySqlCommand(mSQL, conexaoMySQL);
                    MySqlDataReader dados = cmd.ExecuteReader();
                    result = dados.Read();
                }
                catch (MySqlException msqle)
                {
                    MessageBox.Show("Erro de acesso ao MySQL : " + msqle.Message, "Erro");
                }
                finally
                {
                    conexaoMySQL.Close();
                }
                return result;
            }
        }
    }
}
