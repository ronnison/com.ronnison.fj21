package com.ronnison.jf11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.List;

public class JDBCexample {

	public static void main(String[] args) {	
		
		Contato c = new Contato();
		c.setNome("ronnison");
		c.setEmail("ronnison.reges@gmail.com");
		c.setEndereco("Rua Tenente Moacir Matos, 299");
		c.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(c);
		
//		List<Contato> lista = dao.pesquisa();
//		
////		dao.remove(lista.get(1));
//		
//		for (Contato contato : lista) {
//			System.out.println("Nome: " + contato.getNome());
//			System.out.println("Email: " + contato.getEmail());
//			System.out.println("Endereço: " + contato.getEndereco());
//			System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTime() + "\n");
//		}
		
	}

}
