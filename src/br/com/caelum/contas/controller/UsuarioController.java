package br.com.caelum.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class UsuarioController {

	  @RequestMapping("/loginForm")
	  public String loginForm() {
	    return "/usuario/login";
	  }

	  @RequestMapping("/efetuaLogin")
	  public String efetuaLogin(Usuario usuario, HttpSession session) {
	    if(new UsuarioDAO().existeUsuario(usuario)) {
	      session.setAttribute("usuarioLogado", usuario);
	      return "menu";
	    }
	    return "/usuario/login";
	  }
	  
	  @RequestMapping("logout")
	  public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:loginForm";
	  }
}
