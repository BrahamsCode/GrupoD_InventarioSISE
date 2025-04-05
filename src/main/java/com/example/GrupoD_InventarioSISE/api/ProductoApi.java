/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.GrupoD_InventarioSISE.api;

import com.example.GrupoD_InventarioSISE.dto.ProductoDto;
import com.example.GrupoD_InventarioSISE.iservice.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RANDY
 */
@RestController
@RequestMapping("/api/producto")
public class ProductoApi {
    
    @Autowired
    private IProductoService iProductoService;
    
    @GetMapping("/listar")
    public Page<ProductoDto> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return iProductoService.Paginado(search, PageRequest.of(page, size));
    }
    
    @GetMapping("/listar-subcategoria/{id}")
    public Page<ProductoDto> listarPorSubCategoria(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return iProductoService.listarDtoPorSubCategoria(id, search, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public ProductoDto obtenerPorId(@PathVariable Long id) {
        return iProductoService.obtenerDtoPorId(id);
    }
        
}
