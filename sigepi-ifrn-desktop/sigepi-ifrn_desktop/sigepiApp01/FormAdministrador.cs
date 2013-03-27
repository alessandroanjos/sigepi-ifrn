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
    public partial class FormAdministrador : Form
    {
        public FormAdministrador()
        {
            InitializeComponent();
        }

        private void logout(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void formEditais(object sender, EventArgs e)
        {
            FormEditais editais = new FormEditais();
            editais.Show();
        }

        private void formCampus(object sender, EventArgs e)
        {
            FormCampus campus = new FormCampus();
            campus.Show();
        }

        private void formGruposDePesquisa(object sender, EventArgs e)
        {
            FormGruposDePesquisa gruposDePesquisa = new FormGruposDePesquisa();
            gruposDePesquisa.Show();
        }

        private void formAreasDeConhecimento(object sender, EventArgs e)
        {
            FormAreasDeConhecimento areasDeConhecimento = new FormAreasDeConhecimento();
            areasDeConhecimento.Show();
        }

        private void formCursos(object sender, EventArgs e)
        {
            FormCursos cursos = new FormCursos();
            cursos.Show();
        }

    }
}
