/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.GrupoD_InventarioSISE.api;

import com.example.GrupoD_InventarioSISE.dto.CategoriaDto;
import com.example.GrupoD_InventarioSISE.iservice.ICategoriaService;
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
@RequestMapping("/api/categoria")
public class CategoriaApi {
    
    @Autowired
    private ICategoriaService iCategoriaService;
    
    @GetMapping("/listar")
    public Page<CategoriaDto> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return iCategoriaService.Paginado(search, PageRequest.of(page, size));
    }
    
    @GetMapping("/listar-departamento/{id}")
    public Page<CategoriaDto> listarPorDepartamento(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return iCategoriaService.listarDtoPorDepartamento(id, search, PageRequest.of(page, size));
    }
}
