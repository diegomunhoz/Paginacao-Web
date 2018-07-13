package br.com.choice.paginacao.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.choice.paginacao.bean.Curso;
import br.com.choice.paginacao.util.HibernateUtil;

public class CursoDAO extends GenericDAO{
	
	public Curso buscarPorCodigo (int codigo) throws Exception{
		Session sessao = null;
		Curso filme = null;

		sessao = HibernateUtil.getSessionFactory().openSession();
		filme = (Curso) sessao.get(Curso.class, codigo);

		return filme;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Curso> buscarTodos() throws Exception{
		ArrayList<Curso> listaRetorno = new ArrayList<Curso>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Curso.class);
		
		criteria.addOrder (Order.asc("codigo"));
		
		listaRetorno = (ArrayList<Curso>) criteria.list();
		
		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Curso> pesquisarPorNome(String nome) throws Exception{
		ArrayList<Curso> listaRetorno = new ArrayList<Curso>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Curso.class);

		criteria.add(Restrictions.ilike("nome", "%" + nome + "%"));

		criteria.addOrder(Order.asc("nome"));
		
		listaRetorno = (ArrayList<Curso>) criteria.list();
		
		return listaRetorno;
	}
}