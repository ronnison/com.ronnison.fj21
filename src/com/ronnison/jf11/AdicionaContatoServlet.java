package com.ronnison.jf11;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		log("iniciando a servlet");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		log("Destruindo a servlet.");
	}
	
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) 
    			throws ServletException, IOException {
    	
    		PrintWriter out = resp.getWriter();
    		String nome = req.getParameter("nome");
    		String email = req.getParameter("email");
    		String endereco = req.getParameter("endereco");
    		String data = req.getParameter("dataNascimento");
    		
    		Calendar dataNascimento = null;
    		
    		try {
				Date date = new SimpleDateFormat("dd/mm/yyy").parse(data);
			} catch (ParseException e) {
				out.println("Erro de Conversão na data");
				return;
			}
    		
    		Contato c = new Contato();
    		c.setNome(nome);
    		c.setEmail(email);
    		c.setEndereco(endereco);
    		c.setDataNascimento(dataNascimento);
    		
    		ContatoDAO dao = new ContatoDAO();
    		dao.adiciona(c);
    		
    		out.println("<hmtl>");
    		out.println("<body>");
    		out.println("Contato " + c.getNome() + " adicionado com sucesso...");
    		out.println("</body>");
    		out.println("</hmtl>");
    		
    	}

}
