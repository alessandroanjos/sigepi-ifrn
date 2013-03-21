namespace sigepiApp01
{
    partial class FormEditais
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormEditais));
            this.sigepi2DataSet = new sigepiApp01.sigepi2DataSet();
            this.editalBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.editalTableAdapter = new sigepiApp01.sigepi2DataSetTableAdapters.editalTableAdapter();
            this.tableAdapterManager = new sigepiApp01.sigepi2DataSetTableAdapters.TableAdapterManager();
            this.editalBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.editalBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.editalDataGridView = new System.Windows.Forms.DataGridView();
            this.usuarioBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.usuarioTableAdapter = new sigepiApp01.sigepi2DataSetTableAdapters.usuarioTableAdapter();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.data_cadastro = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewComboBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.sigepi2DataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.editalBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.editalBindingNavigator)).BeginInit();
            this.editalBindingNavigator.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.editalDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.usuarioBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // sigepi2DataSet
            // 
            this.sigepi2DataSet.DataSetName = "sigepi2DataSet";
            this.sigepi2DataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // editalBindingSource
            // 
            this.editalBindingSource.DataMember = "edital";
            this.editalBindingSource.DataSource = this.sigepi2DataSet;
            // 
            // editalTableAdapter
            // 
            this.editalTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.campusTableAdapter = null;
            this.tableAdapterManager.editalTableAdapter = this.editalTableAdapter;
            this.tableAdapterManager.play_evolutionsTableAdapter = null;
            this.tableAdapterManager.projeto_avaliadoTableAdapter = null;
            this.tableAdapterManager.projetoTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = sigepiApp01.sigepi2DataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            this.tableAdapterManager.usuarioTableAdapter = null;
            // 
            // editalBindingNavigator
            // 
            this.editalBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.editalBindingNavigator.BindingSource = this.editalBindingSource;
            this.editalBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.editalBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.editalBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.editalBindingNavigatorSaveItem});
            this.editalBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.editalBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.editalBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.editalBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.editalBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.editalBindingNavigator.Name = "editalBindingNavigator";
            this.editalBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.editalBindingNavigator.Size = new System.Drawing.Size(359, 25);
            this.editalBindingNavigator.TabIndex = 0;
            this.editalBindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorAddNewItem.Text = "Add new";
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(35, 22);
            this.bindingNavigatorCountItem.Text = "of {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Total number of items";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorDeleteItem.Text = "Delete";
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveFirstItem.Text = "Move first";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMovePreviousItem.Text = "Move previous";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Position";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 23);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Current position";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator1";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveNextItem.Text = "Move next";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveLastItem.Text = "Move last";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator2";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 25);
            // 
            // editalBindingNavigatorSaveItem
            // 
            this.editalBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.editalBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("editalBindingNavigatorSaveItem.Image")));
            this.editalBindingNavigatorSaveItem.Name = "editalBindingNavigatorSaveItem";
            this.editalBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.editalBindingNavigatorSaveItem.Text = "Salvar Dados";
            this.editalBindingNavigatorSaveItem.Click += new System.EventHandler(this.editalBindingNavigatorSaveItem_Click);
            // 
            // editalDataGridView
            // 
            this.editalDataGridView.AutoGenerateColumns = false;
            this.editalDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.editalDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn2,
            this.data_cadastro,
            this.dataGridViewTextBoxColumn4});
            this.editalDataGridView.DataSource = this.editalBindingSource;
            this.editalDataGridView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.editalDataGridView.Location = new System.Drawing.Point(0, 25);
            this.editalDataGridView.Name = "editalDataGridView";
            this.editalDataGridView.Size = new System.Drawing.Size(359, 253);
            this.editalDataGridView.TabIndex = 1;
            // 
            // usuarioBindingSource
            // 
            this.usuarioBindingSource.DataMember = "usuario";
            this.usuarioBindingSource.DataSource = this.sigepi2DataSet;
            // 
            // usuarioTableAdapter
            // 
            this.usuarioTableAdapter.ClearBeforeFill = true;
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.DataPropertyName = "titulo";
            this.dataGridViewTextBoxColumn2.HeaderText = "titulo";
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            // 
            // data_cadastro
            // 
            this.data_cadastro.DataPropertyName = "data_cadastro";
            this.data_cadastro.HeaderText = "data_cadastro";
            this.data_cadastro.Name = "data_cadastro";
            // 
            // dataGridViewTextBoxColumn4
            // 
            this.dataGridViewTextBoxColumn4.DataPropertyName = "autor_id";
            this.dataGridViewTextBoxColumn4.DataSource = this.usuarioBindingSource;
            this.dataGridViewTextBoxColumn4.DisplayMember = "nome";
            this.dataGridViewTextBoxColumn4.HeaderText = "autor_id";
            this.dataGridViewTextBoxColumn4.Name = "dataGridViewTextBoxColumn4";
            this.dataGridViewTextBoxColumn4.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridViewTextBoxColumn4.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.dataGridViewTextBoxColumn4.ValueMember = "id";
            // 
            // FormEditais
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(359, 278);
            this.Controls.Add(this.editalDataGridView);
            this.Controls.Add(this.editalBindingNavigator);
            this.Name = "FormEditais";
            this.Text = "Gerenciar Editais";
            this.Load += new System.EventHandler(this.FormEditais_Load);
            ((System.ComponentModel.ISupportInitialize)(this.sigepi2DataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.editalBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.editalBindingNavigator)).EndInit();
            this.editalBindingNavigator.ResumeLayout(false);
            this.editalBindingNavigator.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.editalDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.usuarioBindingSource)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private sigepi2DataSet sigepi2DataSet;
        private System.Windows.Forms.BindingSource editalBindingSource;
        private sigepi2DataSetTableAdapters.editalTableAdapter editalTableAdapter;
        private sigepi2DataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator editalBindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton editalBindingNavigatorSaveItem;
        private System.Windows.Forms.DataGridView editalDataGridView;
        private System.Windows.Forms.BindingSource usuarioBindingSource;
        private sigepi2DataSetTableAdapters.usuarioTableAdapter usuarioTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn data_cadastro;
        private System.Windows.Forms.DataGridViewComboBoxColumn dataGridViewTextBoxColumn4;
    }
}