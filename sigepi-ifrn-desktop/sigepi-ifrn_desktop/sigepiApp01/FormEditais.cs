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
            // TODO: This line of code loads data into the 'sigepi2DataSet.edital' table. You can move, or remove it, as needed.
            this.editalTableAdapter.Fill(this.sigepi2DataSet.edital);
            // TODO: This line of code loads data into the 'sigepi2DataSet.edital' table. You can move, or remove it, as needed.
            this.editalTableAdapter.Fill(this.sigepi2DataSet.edital);

        }

        private void editalBindingNavigatorSaveItem_Click_1(object sender, EventArgs e)
        {
            this.Validate();
            this.editalBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.sigepi2DataSet);

        }

        private void editalDataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void data_cadastroDateTimePicker_ValueChanged(object sender, EventArgs e)
        {

        }

        
    }
}
