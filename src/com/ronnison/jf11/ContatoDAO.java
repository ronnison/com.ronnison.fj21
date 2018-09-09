package com.ronnison.jf11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

public class ContatoDAO {

	private Connection con;
	
	public ContatoDAO (){
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void adiciona (Contato cont) {
		
		String sql = "insert into contatos (nome, email, endereco, dataNascimento)"
				+ " values (?, ?, ?,?)";
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cont.getNome());
			stm.setString(2, cont.getEndereco());
			stm.setString(3, cont.getEmail());
			stm.setDate(4, new Date(cont.getDataNascimento().getTimeInMillis()));
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Contato> pesquisa () {
		
		List<Contato> lista = new ArrayList<Contato>();
		
		try {

			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stm = con.prepareStatement("select * from contatos");
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				Contato c = new Contato();
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				c.setDataNascimento(data);
				
				lista.add(c);
				
			}
			
			rs.close();
			stm.close();
			con.close();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
		
		return lista;
		
	}
	
	public void altera (Contato c) {
		String sql = "update contatos set nome=?, email=?, "
				+ "endereco=?, dataNascimento=? where id=?";
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, c.getNome());
			stm.setString(2, c.getEmail());
			stm.setString(3, c.getEndereco());
			stm.setDate(4, new Date(c.getDataNascimento().getTimeInMillis()));
			stm.setLong(5, c.getId());
			stm.execute();
			stm.close();
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove (Contato c) {
		try {
			
			PreparedStatement stm = con.prepareStatement("delete from contatos where id=?");
			stm.setLong(1, c.getId());
			stm.execute();
			stm.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
