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
    public partial class FormEditais : Form
    {
        public FormEditais()
        {
            InitializeComponent();
        }

        private void editalBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.editalBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.sigepi2DataSet);

        }

        private void FormEditais_Load(object sender, EventArgs e)
        {
            // TODO: esta linha de código carrega dados na tabela 'sigepi2DataSet.edital'. Você pode movê-la ou removê-la conforme necessário.
            this.editalTableAdapter.Fill(this.sigepi2DataSet.edital);

        }
    }
}
