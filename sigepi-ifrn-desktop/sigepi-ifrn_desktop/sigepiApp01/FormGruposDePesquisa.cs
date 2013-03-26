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
    public partial class FormGruposDePesquisa : Form
    {
        public FormGruposDePesquisa()
        {
            InitializeComponent();
        }

        private void grupo_pesquisaBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.grupo_pesquisaBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.sigepi2DataSet);

        }

        private void FormGruposDePesquisa_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'sigepi2DataSet.campus' table. You can move, or remove it, as needed.
            this.campusTableAdapter.Fill(this.sigepi2DataSet.campus);
            // TODO: This line of code loads data into the 'sigepi2DataSet.grupo_pesquisa' table. You can move, or remove it, as needed.
            this.grupo_pesquisaTableAdapter.Fill(this.sigepi2DataSet.grupo_pesquisa);

        }
    }
}
