/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.GrupoD_InventarioSISE.service;

import com.example.GrupoD_InventarioSISE.iservice.IDepartamentoService;
import com.example.GrupoD_InventarioSISE.model.Departamento;
import com.example.GrupoD_InventarioSISE.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author RANDY
 */
@Service
public class DepartamentoService implements IDepartamentoService{

    @Autowired
    private DepartamentoRepository departamentoRepository;
    
    @Override
    public Page<Departamento> paginado(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return departamentoRepository.findAll(pageable);
        } else {
            return departamentoRepository.paginarDepartamentos(search, pageable);
        }
    }
    
}
