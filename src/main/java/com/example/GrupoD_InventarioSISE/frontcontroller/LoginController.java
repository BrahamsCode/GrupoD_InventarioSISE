package com.example.GrupoD_InventarioSISE.frontcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.GrupoD_InventarioSISE.model.Usuario;
import com.example.GrupoD_InventarioSISE.repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

/**
 *
 * @author RANDY
 */
@Controller
public class LoginController {
    
    @Autowired
     private UsuarioRepository usuarioRepository;
 
     @GetMapping("/login")
     public String login() {
         return "login"; // Vista del formulario de login
     }
 
     @PostMapping("/login")
     public String processLogin(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
         Usuario usuario = usuarioRepository.findByUsername(username);
 
         if (usuario != null && usuario.getPassword().equalsIgnoreCase(org.apache.commons.codec.digest.DigestUtils.sha256Hex(password))) {
             session.setAttribute("usuario", usuario.getUsername()); // Guardar usuario en la sesión
             return "redirect:/producto"; // Redirigir al formulario de producto
         } else {
             model.addAttribute("error", "Credenciales inválidas");
             return "login"; // Volver al formulario de login con un mensaje de error
         }
     }
 
     @GetMapping("/logout")
     public String logout(HttpSession session) {
         session.invalidate(); // Invalidar la sesión
         return "redirect:/login"; // Redirigir al login
     }
}
