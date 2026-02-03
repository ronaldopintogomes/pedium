package com.pedium.mono.usuario.controle;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
 

    @GetMapping("/dashboard")
    public String showDashboard(Principal principal, HttpSession session, Model model) {
        session.setAttribute("ultimoAcesso", LocalDateTime.now());
        model.addAttribute("usuario", principal.getName());
        model.addAttribute("ultimoAcesso", session.getAttribute("ultimoAcesso"));
        return "dashboard";
    }
}