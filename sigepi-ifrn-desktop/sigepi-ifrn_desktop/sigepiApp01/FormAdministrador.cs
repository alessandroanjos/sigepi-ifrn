using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace sigepiApp01
{
    public partial class FormAdministrador : Form
    {
        public FormAdministrador()
        {
            InitializeComponent();
        }

        private void formEditais(object sender, EventArgs e)
        {
            FormEditais editais = new FormEditais();
            editais.Show();
        }

        private void logout(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
