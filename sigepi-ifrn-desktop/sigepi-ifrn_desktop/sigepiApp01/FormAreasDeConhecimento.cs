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
    public partial class FormAreasDeConhecimento : Form
    {
        public FormAreasDeConhecimento()
        {
            InitializeComponent();
        }

        private void area_conhecimentoBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.area_conhecimentoBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.sigepi2DataSet);

        }

        private void FormAreasDeConhecimento_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'sigepi2DataSet.area_conhecimento' table. You can move, or remove it, as needed.
            this.area_conhecimentoTableAdapter.Fill(this.sigepi2DataSet.area_conhecimento);

        }
    }
}
