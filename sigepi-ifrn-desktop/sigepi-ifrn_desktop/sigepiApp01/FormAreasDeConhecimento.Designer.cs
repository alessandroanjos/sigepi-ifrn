namespace sigepiApp01
{
    partial class FormAreasDeConhecimento
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormAreasDeConhecimento));
            this.sigepi2DataSet = new sigepiApp01.sigepi2DataSet();
            this.area_conhecimentoBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.area_conhecimentoTableAdapter = new sigepiApp01.sigepi2DataSetTableAdapters.area_conhecimentoTableAdapter();
            this.tableAdapterManager = new sigepiApp01.sigepi2DataSetTableAdapters.TableAdapterManager();
            this.area_conhecimentoBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.area_conhecimentoBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.area_conhecimentoDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.sigepi2DataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.area_conhecimentoBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.area_conhecimentoBindingNavigator)).BeginInit();
            this.area_conhecimentoBindingNavigator.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.area_conhecimentoDataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // sigepi2DataSet
            // 
            this.sigepi2DataSet.DataSetName = "sigepi2DataSet";
            this.sigepi2DataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // area_conhecimentoBindingSource
            // 
            this.area_conhecimentoBindingSource.DataMember = "area_conhecimento";
            this.area_conhecimentoBindingSource.DataSource = this.sigepi2DataSet;
            // 
            // area_conhecimentoTableAdapter
            // 
            this.area_conhecimentoTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.area_conhecimentoTableAdapter = this.area_conhecimentoTableAdapter;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.bolsistaTableAdapter = null;
            this.tableAdapterManager.campusTableAdapter = null;
            this.tableAdapterManager.cursoTableAdapter = null;
            this.tableAdapterManager.editalTableAdapter = null;
            this.tableAdapterManager.grupo_pesquisaTableAdapter = null;
            this.tableAdapterManager.play_evolutionsTableAdapter = null;
            this.tableAdapterManager.projeto_avaliadoTableAdapter = null;
            this.tableAdapterManager.projetoTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = sigepiApp01.sigepi2DataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            this.tableAdapterManager.usuarioTableAdapter = null;
            // 
            // area_conhecimentoBindingNavigator
            // 
            this.area_conhecimentoBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.area_conhecimentoBindingNavigator.BindingSource = this.area_conhecimentoBindingSource;
            this.area_conhecimentoBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.area_conhecimentoBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.area_conhecimentoBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.area_conhecimentoBindingNavigatorSaveItem});
            this.area_conhecimentoBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.area_conhecimentoBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.area_conhecimentoBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.area_conhecimentoBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.area_conhecimentoBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.area_conhecimentoBindingNavigator.Name = "area_conhecimentoBindingNavigator";
            this.area_conhecimentoBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.area_conhecimentoBindingNavigator.Size = new System.Drawing.Size(784, 25);
            this.area_conhecimentoBindingNavigator.TabIndex = 0;
            this.area_conhecimentoBindingNavigator.Text = "bindingNavigator1";
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
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(35, 15);
            this.bindingNavigatorCountItem.Text = "of {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Total number of items";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 6);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(23, 20);
            this.bindingNavigatorMoveNextItem.Text = "Move next";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(23, 20);
            this.bindingNavigatorMoveLastItem.Text = "Move last";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 6);
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
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(23, 20);
            this.bindingNavigatorDeleteItem.Text = "Delete";
            // 
            // area_conhecimentoBindingNavigatorSaveItem
            // 
            this.area_conhecimentoBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.area_conhecimentoBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("area_conhecimentoBindingNavigatorSaveItem.Image")));
            this.area_conhecimentoBindingNavigatorSaveItem.Name = "area_conhecimentoBindingNavigatorSaveItem";
            this.area_conhecimentoBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 23);
            this.area_conhecimentoBindingNavigatorSaveItem.Text = "Save Data";
            this.area_conhecimentoBindingNavigatorSaveItem.Click += new System.EventHandler(this.area_conhecimentoBindingNavigatorSaveItem_Click);
            // 
            // area_conhecimentoDataGridView
            // 
            this.area_conhecimentoDataGridView.AutoGenerateColumns = false;
            this.area_conhecimentoDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.area_conhecimentoDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn2,
            this.dataGridViewTextBoxColumn1});
            this.area_conhecimentoDataGridView.DataSource = this.area_conhecimentoBindingSource;
            this.area_conhecimentoDataGridView.Location = new System.Drawing.Point(0, 28);
            this.area_conhecimentoDataGridView.Name = "area_conhecimentoDataGridView";
            this.area_conhecimentoDataGridView.Size = new System.Drawing.Size(784, 402);
            this.area_conhecimentoDataGridView.TabIndex = 1;
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.DataPropertyName = "nome";
            this.dataGridViewTextBoxColumn2.HeaderText = "Nome da Área";
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            this.dataGridViewTextBoxColumn2.Width = 740;
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.DataPropertyName = "id";
            this.dataGridViewTextBoxColumn1.HeaderText = "id";
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            this.dataGridViewTextBoxColumn1.Visible = false;
            // 
            // FormAreasDeConhecimento
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(784, 442);
            this.Controls.Add(this.area_conhecimentoDataGridView);
            this.Controls.Add(this.area_conhecimentoBindingNavigator);
            this.Name = "FormAreasDeConhecimento";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Gerenciar Áreas de Conhecimento";
            this.Load += new System.EventHandler(this.FormAreasDeConhecimento_Load);
            ((System.ComponentModel.ISupportInitialize)(this.sigepi2DataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.area_conhecimentoBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.area_conhecimentoBindingNavigator)).EndInit();
            this.area_conhecimentoBindingNavigator.ResumeLayout(false);
            this.area_conhecimentoBindingNavigator.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.area_conhecimentoDataGridView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private sigepi2DataSet sigepi2DataSet;
        private System.Windows.Forms.BindingSource area_conhecimentoBindingSource;
        private sigepi2DataSetTableAdapters.area_conhecimentoTableAdapter area_conhecimentoTableAdapter;
        private sigepi2DataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator area_conhecimentoBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton area_conhecimentoBindingNavigatorSaveItem;
        private System.Windows.Forms.DataGridView area_conhecimentoDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
    }
}