using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data.MySqlClient;
using System.Configuration;

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
    }
}
