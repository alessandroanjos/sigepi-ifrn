using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.Data.SqlClient;
using MySql.Data.MySqlClient;

namespace sigepiApp01
{
    /// <summary>
    /// Interaction logic for Login.xaml
    /// </summary>
    public partial class Login : Window
    {
        public Login()
        {
            InitializeComponent();
        }

        private bool Logado = false;


        private bool VerificaLogin()
        {
            bool result = false;
            string StringDeConexao = "server=localhost;uid=root;pwd=root;database=sigepi2";

            using (MySqlConnection conexaoMySQL = MySQLDao.getInstancia().getConexao())
            {
                conexaoMySQL.ConnectionString = StringDeConexao;

                try
                {
                    conexaoMySQL.Open();

                    string mSQL = "select * from usuario where login = '" + textBox1.Text + "' and nome = '" + passwordBox1.Password +"' and is_administrador = 1 " + "  ;";

                    //MessageBox.Show("sql" + mSQL);
                    MySqlCommand cmd = new MySqlCommand(mSQL, conexaoMySQL);

                    //  MySqlDataAdapter da = new MySqlDataAdapter(cmd);

                    //  DataTable dtMensagens = new DataTable();
                    //  da.Fill(dtMensagens);
                    //this.dataGridView1.DataSource = dtMensagens;


                    MySqlDataReader dados = cmd.ExecuteReader();
                    //  SqlDataReader dados = cmd.ExecuteReader();
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
        

        
       
        private void autenticarLogin_Click(object sender, RoutedEventArgs e)
        {
            bool result = VerificaLogin();

            Logado = result;

            if (result)
            {

                MessageBox.Show("Seja bem vindo!");
                FormAdministrador f = new FormAdministrador();
                f.Show();

                this.Close();
            }
            else
            {
                MessageBox.Show("Usuário ou senha incorreto!");
            }
        }
    }
}
