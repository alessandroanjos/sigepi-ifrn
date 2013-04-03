namespace sigepiApp01
{
    partial class FormAdministrador
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.administradorToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.sairToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.editaisToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.gerenciarToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.gruposDePesquisaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.gerenciarToolStripMenuItem5 = new System.Windows.Forms.ToolStripMenuItem();
            this.gruposDePesquisaToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.gerenciarToolStripMenuItem4 = new System.Windows.Forms.ToolStripMenuItem();
            this.áreaDeConhecimentoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.gerenciarToolStripMenuItem3 = new System.Windows.Forms.ToolStripMenuItem();
            this.cursosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.gerenciarToolStripMenuItem2 = new System.Windows.Forms.ToolStripMenuItem();
            this.usuáriosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.gerenciarToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.administradorToolStripMenuItem,
            this.editaisToolStripMenuItem,
            this.gruposDePesquisaToolStripMenuItem,
            this.gruposDePesquisaToolStripMenuItem1,
            this.áreaDeConhecimentoToolStripMenuItem,
            this.cursosToolStripMenuItem,
            this.usuáriosToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(784, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // administradorToolStripMenuItem
            // 
            this.administradorToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.sairToolStripMenuItem});
            this.administradorToolStripMenuItem.Name = "administradorToolStripMenuItem";
            this.administradorToolStripMenuItem.Size = new System.Drawing.Size(95, 20);
            this.administradorToolStripMenuItem.Text = "Administrador";
            // 
            // sairToolStripMenuItem
            // 
            this.sairToolStripMenuItem.Name = "sairToolStripMenuItem";
            this.sairToolStripMenuItem.Size = new System.Drawing.Size(154, 22);
            this.sairToolStripMenuItem.Text = "Sair do Sistema";
            this.sairToolStripMenuItem.Click += new System.EventHandler(this.logout);
            // 
            // editaisToolStripMenuItem
            // 
            this.editaisToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.gerenciarToolStripMenuItem});
            this.editaisToolStripMenuItem.Name = "editaisToolStripMenuItem";
            this.editaisToolStripMenuItem.Size = new System.Drawing.Size(53, 20);
            this.editaisToolStripMenuItem.Text = "Editais";
            // 
            // gerenciarToolStripMenuItem
            // 
            this.gerenciarToolStripMenuItem.Name = "gerenciarToolStripMenuItem";
            this.gerenciarToolStripMenuItem.Size = new System.Drawing.Size(133, 22);
            this.gerenciarToolStripMenuItem.Text = "Gerenciar...";
            this.gerenciarToolStripMenuItem.Click += new System.EventHandler(this.formEditais);
            // 
            // gruposDePesquisaToolStripMenuItem
            // 
            this.gruposDePesquisaToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.gerenciarToolStripMenuItem5});
            this.gruposDePesquisaToolStripMenuItem.Name = "gruposDePesquisaToolStripMenuItem";
            this.gruposDePesquisaToolStripMenuItem.Size = new System.Drawing.Size(63, 20);
            this.gruposDePesquisaToolStripMenuItem.Text = "Câmpus";
            // 
            // gerenciarToolStripMenuItem5
            // 
            this.gerenciarToolStripMenuItem5.Name = "gerenciarToolStripMenuItem5";
            this.gerenciarToolStripMenuItem5.Size = new System.Drawing.Size(152, 22);
            this.gerenciarToolStripMenuItem5.Text = "Gerenciar...";
            this.gerenciarToolStripMenuItem5.Click += new System.EventHandler(this.formCampus);
            // 
            // gruposDePesquisaToolStripMenuItem1
            // 
            this.gruposDePesquisaToolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.gerenciarToolStripMenuItem4});
            this.gruposDePesquisaToolStripMenuItem1.Name = "gruposDePesquisaToolStripMenuItem1";
            this.gruposDePesquisaToolStripMenuItem1.Size = new System.Drawing.Size(122, 20);
            this.gruposDePesquisaToolStripMenuItem1.Text = "Grupos de Pesquisa";
            // 
            // gerenciarToolStripMenuItem4
            // 
            this.gerenciarToolStripMenuItem4.Name = "gerenciarToolStripMenuItem4";
            this.gerenciarToolStripMenuItem4.Size = new System.Drawing.Size(133, 22);
            this.gerenciarToolStripMenuItem4.Text = "Gerenciar...";
            this.gerenciarToolStripMenuItem4.Click += new System.EventHandler(this.formGruposDePesquisa);
            // 
            // áreaDeConhecimentoToolStripMenuItem
            // 
            this.áreaDeConhecimentoToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.gerenciarToolStripMenuItem3});
            this.áreaDeConhecimentoToolStripMenuItem.Name = "áreaDeConhecimentoToolStripMenuItem";
            this.áreaDeConhecimentoToolStripMenuItem.Size = new System.Drawing.Size(141, 20);
            this.áreaDeConhecimentoToolStripMenuItem.Text = "Área de Conhecimento";
            // 
            // gerenciarToolStripMenuItem3
            // 
            this.gerenciarToolStripMenuItem3.Name = "gerenciarToolStripMenuItem3";
            this.gerenciarToolStripMenuItem3.Size = new System.Drawing.Size(133, 22);
            this.gerenciarToolStripMenuItem3.Text = "Gerenciar...";
            this.gerenciarToolStripMenuItem3.Click += new System.EventHandler(this.formAreasDeConhecimento);
            // 
            // cursosToolStripMenuItem
            // 
            this.cursosToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.gerenciarToolStripMenuItem2});
            this.cursosToolStripMenuItem.Name = "cursosToolStripMenuItem";
            this.cursosToolStripMenuItem.Size = new System.Drawing.Size(55, 20);
            this.cursosToolStripMenuItem.Text = "Cursos";
            // 
            // gerenciarToolStripMenuItem2
            // 
            this.gerenciarToolStripMenuItem2.Name = "gerenciarToolStripMenuItem2";
            this.gerenciarToolStripMenuItem2.Size = new System.Drawing.Size(152, 22);
            this.gerenciarToolStripMenuItem2.Text = "Gerenciar...";
            this.gerenciarToolStripMenuItem2.Click += new System.EventHandler(this.formCursos);
            // 
            // usuáriosToolStripMenuItem
            // 
            this.usuáriosToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.gerenciarToolStripMenuItem1});
            this.usuáriosToolStripMenuItem.Name = "usuáriosToolStripMenuItem";
            this.usuáriosToolStripMenuItem.Size = new System.Drawing.Size(64, 20);
            this.usuáriosToolStripMenuItem.Text = "Usuários";
            // 
            // gerenciarToolStripMenuItem1
            // 
            this.gerenciarToolStripMenuItem1.Name = "gerenciarToolStripMenuItem1";
            this.gerenciarToolStripMenuItem1.Size = new System.Drawing.Size(152, 22);
            this.gerenciarToolStripMenuItem1.Text = "Gerenciar...";
            this.gerenciarToolStripMenuItem1.Click += new System.EventHandler(this.formUsuarios);
            // 
            // FormAdministrador
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(784, 442);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "FormAdministrador";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Área do Administrador";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem administradorToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem sairToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem editaisToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem gerenciarToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem gruposDePesquisaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem gerenciarToolStripMenuItem5;
        private System.Windows.Forms.ToolStripMenuItem gruposDePesquisaToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem gerenciarToolStripMenuItem4;
        private System.Windows.Forms.ToolStripMenuItem áreaDeConhecimentoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem gerenciarToolStripMenuItem3;
        private System.Windows.Forms.ToolStripMenuItem cursosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem gerenciarToolStripMenuItem2;
        private System.Windows.Forms.ToolStripMenuItem usuáriosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem gerenciarToolStripMenuItem1;
    }
}