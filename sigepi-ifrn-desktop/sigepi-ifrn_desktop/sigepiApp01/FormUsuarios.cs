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
    public partial class FormUsuarios : Form
    {
        public FormUsuarios()
        {
            InitializeComponent();
        }

        private void usuarioBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.usuarioBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.sigepi2DataSet);

        }

        private void FormGerenciarProfessor_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'sigepi2DataSet.campus' table. You can move, or remove it, as needed.
            this.campusTableAdapter.Fill(this.sigepi2DataSet.campus);
            // TODO: This line of code loads data into the 'sigepi2DataSet.usuario' table. You can move, or remove it, as needed.
            this.usuarioTableAdapter.Fill(this.sigepi2DataSet.usuario);

        }
    }
}
