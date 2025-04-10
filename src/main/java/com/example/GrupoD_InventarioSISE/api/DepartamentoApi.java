/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.GrupoD_InventarioSISE.api;

import com.example.GrupoD_InventarioSISE.iservice.IDepartamentoService;
import com.example.GrupoD_InventarioSISE.model.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RANDY
 */
@RestController
@RequestMapping("/api/departamento")
public class DepartamentoApi {
    
    @Autowired
    private IDepartamentoService iDepartamentoService;
    
    @GetMapping
    public Page<Departamento> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(value = "search", required = false) String search
            ) {
        return iDepartamentoService.paginado(search, PageRequest.of(page, size));
    }

    @GetMapping("/listartodo")
    public Page<Departamento> listartodo(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size,
            @RequestParam(value = "search", required = false) String search
            ) {
        return iDepartamentoService.paginado(search, PageRequest.of(page, size));
        }
}
