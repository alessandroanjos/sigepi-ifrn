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
       
        private void autenticarLogin_Click(object sender, RoutedEventArgs e)
        {
            bool result = MySQLDao.VerificaLogin(textBox1.Text, passwordBox1.Password);

            Logado = result;

            if (result)
            {

                MessageBox.Show("Seja bem-vindo!");
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
