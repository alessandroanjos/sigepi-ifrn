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
    public partial class FormCursos : Form
    {
        public FormCursos()
        {
            InitializeComponent();
        }

        private void cursoBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.cursoBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.sigepi2DataSet);

        }

        private void FormCursos_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'sigepi2DataSet.curso' table. You can move, or remove it, as needed.
            this.cursoTableAdapter.Fill(this.sigepi2DataSet.curso);

        }
    }
}
