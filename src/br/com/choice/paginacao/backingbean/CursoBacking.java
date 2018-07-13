package br.com.choice.paginacao.backingbean;

import java.util.ArrayList;
import java.util.List;

import br.com.choice.paginacao.bean.Curso;
import br.com.choice.paginacao.dao.CursoDAO;
import br.com.choice.paginacao.util.JSFUtil;

public class CursoBacking {

	private Curso curso = new Curso();
	private Curso cursoSelecionado = new Curso();
	private int codigo;
	private int horas;
	private String nome;
	private List<Curso> listaCursoTotal;
	private List<Curso> listaCurso;
	private int scrollerPage;
	private int qtdLinhas;
	private int paginaTotal;

	public String consultarCurso(){
		try {
			scrollerPage = 1;
			qtdLinhas = 10;
			listaCursoTotal = new CursoDAO().buscarTodos();
			if (listaCursoTotal.size()%10==0){
				paginaTotal = listaCursoTotal.size()/10;
			}else{
				paginaTotal = (listaCursoTotal.size()/10)+1;
			}
			montarLista();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro na busca.");
		}
		return "";
	}
	
	public String voltar(){
		if (scrollerPage>1){
			scrollerPage--;
			montarLista();
			return "atualizar";
		}else{
			JSFUtil.addInfoMessage("Não há mais páginas para voltar.");
			return "";
		}		
	}
	
	public String avancar(){
		if (scrollerPage<paginaTotal){
			scrollerPage++;
			montarLista();
			return "atualizar";
		}else{
			JSFUtil.addInfoMessage("Não há mais páginas para avançar.");
			return "";
		}
	}
	
	public void montarLista (){
		listaCurso = new ArrayList<Curso>();
		int contador = 0;
		int contCurso = 0;
		for (Curso c : listaCursoTotal){
			contCurso++;
			if (contador==qtdLinhas)
				break;
			if ((contCurso<=(qtdLinhas*scrollerPage))&&
			    (contCurso>(qtdLinhas*(scrollerPage-1)))){
				listaCurso.add(c);
				contador++;
			}
		}
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Curso getCursoSelecionado() {
		return cursoSelecionado;
	}

	public void setCursoSelecionado(Curso cursoSelecionado) {
		this.cursoSelecionado = cursoSelecionado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getListaCurso() {
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public String cadastrarCurso(){
		return "";
	}
	
	public String cancelar(){
		return "cancelar";
	}

}