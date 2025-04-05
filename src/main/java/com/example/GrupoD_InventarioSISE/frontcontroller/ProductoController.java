/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.GrupoD_InventarioSISE.frontcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author RANDY
 */
@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @GetMapping
    public String mantenimiento() {
        return "producto/mantenimiento-producto";
    }
    
    @GetMapping("{id}")
    public String listarProductos(Model model, @PathVariable("id") Long id) {
        model.addAttribute("id", id);
        return "producto/productos-por-subcategoria";
    }
}