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
import java.util.List;
import com.example.GrupoD_InventarioSISE.model.Marca;
import com.example.GrupoD_InventarioSISE.model.Producto;
import com.example.GrupoD_InventarioSISE.service.MarcaService;
import com.example.GrupoD_InventarioSISE.service.ProductoService;

/**
 *
 * @author RANDY
 */
@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    private final MarcaService marcaService;
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService, MarcaService marcaService) {
         this.productoService = productoService;
         this.marcaService = marcaService;
     }

    @GetMapping
    public String mantenimiento() {
        return "producto/mantenimiento-producto";
    }
    
    @GetMapping("{id}")
    public String listarProductos(Model model, @PathVariable("id") Long id) {
        
        model.addAttribute("id", id);
        return "producto/productos-por-subcategoria";
    }

    @GetMapping("/nuevo")
    public String nuevoProducto(Model model) {
        List<Marca> marcas = marcaService.listarTodas(); // Obtener la lista de marcas
        model.addAttribute("marcas", marcas);
        model.addAttribute("titulo", "Nuevo Producto");
        model.addAttribute("accion", "nuevo");
        return "producto/form-producto";
    }
    
    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.obtenerPorId(id); // Obtener el producto por su ID
        List<Marca> marcas = marcaService.listarTodas(); // Obtener la lista de marcas
        model.addAttribute("producto", producto); // Pasar el producto al modelo
        model.addAttribute("marcas", marcas); // Pasar la lista de marcas al modelo
        model.addAttribute("titulo", "Editar Producto");
        model.addAttribute("accion", "editar");
        model.addAttribute("id", id);
        return "producto/form-producto";
    }
}