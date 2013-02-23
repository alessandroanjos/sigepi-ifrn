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
    public partial class FormCampus : Form
    {
        public FormCampus()
        {
            InitializeComponent();
        }

        private void campusBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.campusBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.sigepi2DataSet);

        }

        private void FormCampus_Load(object sender, EventArgs e)
        {
            // TODO: esta linha de código carrega dados na tabela 'sigepi2DataSet.campus'. Você pode movê-la ou removê-la conforme necessário.
            this.campusTableAdapter.Fill(this.sigepi2DataSet.campus);

        }
    }
}
