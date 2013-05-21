package models;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import controllers.GrupoPesquisaController;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * Entidade responsável pela representação dos usuários do sistema
 * no banco de dados.
 * 
 * @author Alessandro
 */
@Entity
public class Usuario extends Model {
	
	@Id
	public Long id;
	
	@Required(message="O campo deve ser preenchido.")
	@Column(unique=true)
	@MinLength(value=4,message="A login deve conter no mínimo 4 caracteres.")
	public String login;
	
	@Required(message="O campo deve ser preenchido.")
	@MinLength(value=4,message="A senha deve conter no mínimo 4 caracteres.")
	public String senha;
	
	@Required(message="O campo deve ser preenchido.")
	public String nome;
	
	@Required(message="O campo deve ser preenchido.")
	@Column(unique=true)
	@Email(message="Você deve informar um email válido.")
	public String email;
	
	@Required(message="O campo deve ser preenchido.")
	@Column(unique=true)
	@MinLength(value=11)
	@MaxLength(value=11)
	public String cpf;
	
	@ManyToOne
	public AreaConhecimento areaConhecimento;
	
	@ManyToOne
	public GrupoPesquisa grupoPesquisa;
	
	public String chaveRedefinicaoSenha;
	public boolean isProfessor;
	public boolean isGestor;
	public boolean isAdministrador;
	public boolean isAvaliador;
	public boolean isCoordenador;
	public boolean isAtivo;
	
	@ManyToOne
	public Campus campus;
	
	@OneToMany
	public List<Projeto> projetos;
	
	@OneToMany
	public List<ProjetoAvaliado> progresso;
	
	public Usuario() {
		this.chaveRedefinicaoSenha = null;
		this.isAtivo = false;
		this.progresso = new ArrayList<ProjetoAvaliado>();
		this.projetos = new ArrayList<Projeto>();
		
	}
	
	public List<Projeto> getProjeto() {
		return projetos;
	}

	public void setProjeto(List<Projeto> projeto) {
		this.projetos = projeto;
	}

	public boolean isAvaliador() {
		return isAvaliador;
	}

	public void setAvaliador(boolean isAvaliador) {
		this.isAvaliador = isAvaliador;
	}

	public boolean isCoordenador() {
		return isCoordenador;
	}

	public void setCoordenador(boolean isCoordenador) {
		this.isCoordenador = isCoordenador;
	}

	public boolean isGestor() {
		return isGestor;
	}

	public void setGestor(boolean isGestor) {
		this.isGestor = isGestor;
	}

	public boolean isAdministrador() {
		return isAdministrador;
	}

	public void setAdministrador(boolean isAdministrador) {
		this.isAdministrador = isAdministrador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getChaveRedefinicaoSenha() {
		return chaveRedefinicaoSenha;
	}

	public void setChaveRedefinicaoSenha(String chaveRedefinicaoSenha) {
		this.chaveRedefinicaoSenha = chaveRedefinicaoSenha;
	}

	public boolean isProfessor() {
		return isProfessor;
	}

	public void setProfessor(boolean isProfessor) {
		this.isProfessor = isProfessor;
	}

	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<ProjetoAvaliado> getProgresso() {
		return progresso;
	}

	public void setProgresso(List<ProjetoAvaliado> progresso) {
		this.progresso = progresso;
	}

	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public GrupoPesquisa getGrupoPesquisa() {
		return grupoPesquisa;
	}

	public void setGrupoPesquisa(GrupoPesquisa grupoPesquisa) {
		this.grupoPesquisa = grupoPesquisa;
	}

	public static Finder<Long, Usuario> find = new Finder<Long, Usuario>(Long.class, Usuario.class);
	
	/**
	 * Método <strong>Save()</strong> sobrescrito para criptografar 
	 * a senha do usuário antes de enviar para o banco de dados.
	 * <br/>
	 * Método de Criptografia: MD5
	 */
	@Override
	public void save() {
		try {
			this.senha = criptografarSenha(senha);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		super.save();
	}
	
	/**
     * Método responsável por verificar se o usuário e senha conferem no banco de dados.
	 * @throws NoSuchAlgorithmException 
     */
    public static Usuario autenticar(String login, String senha) throws NoSuchAlgorithmException {
        return find.where()
            .eq("login", login)
            .eq("senha", criptografarSenha(senha))
            .findUnique();
    }
    
    /**
     * Método responsável pela criptografia em MD5 da senha do usuário 
     * no momento em que o objeto é persistido no banco de dados.
     * 
     * @param senha
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String criptografarSenha(String senha) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(senha.getBytes(), 0, senha.length());
		return new BigInteger(1, digest.digest()).toString(16);
	}
    
    /**
     * Valida um cpf.
     *
     * @param CPF o cpf do usuário
     * @return <code> true</code> ou <code> false</code>
     */
    public static boolean validaCPF(String CPF) {
// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
// converte o i-esimo caractere do CPF em um numero:
// por exemplo, transforma o caractere '0' no inteiro 0        
// (48 eh a posicao de '0' na tabela ASCII)        
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

// Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return false;
        }
    }
}
