using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;
using MySql.Data.MySqlClient;

namespace sigepiApp01
{
    public partial class FormLogin : Form
    {
        public FormLogin()
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

                    string mSQL = "select * from usuario where login = '" + textBox1.Text + "' and nome = '" + textBox2.Text + "' and is_administrador = 1 " +"  ;";

                 //   MessageBox.Show("sql" + mSQL);
                    MySqlCommand cmd = new MySqlCommand(mSQL, conexaoMySQL);

                  //  MySqlDataAdapter da = new MySqlDataAdapter(cmd);

                  //  DataTable dtMensagens = new DataTable();
                  //  da.Fill(dtMensagens);
                    //this.dataGridView1.DataSource = dtMensagens;
			

                    MySqlDataReader dados = cmd.ExecuteReader();
                  //  SqlDataReader dados = cmd.ExecuteReader();
                    result = dados.Read();

                    while (dados.Read() )
                    {
                        if (dados.Read() == true)
                        {
                            MessageBox.Show("true...");
                        }
                   }


                    
                                     
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
                
            

            


        private void autenticarLogin_Click(object sender, EventArgs e)
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

        private void usuarioBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.usuarioBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.sigepi2DataSet);

        }

        private void FormLogin_Load(object sender, EventArgs e)
        {
            // TODO: esta linha de código carrega dados na tabela 'sigepi2DataSet.usuario'. Você pode movê-la ou removê-la conforme necessário.
            this.usuarioTableAdapter.Fill(this.sigepi2DataSet.usuario);

        }
    }
}
