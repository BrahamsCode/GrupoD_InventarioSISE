/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.GrupoD_InventarioSISE.service;

import com.example.GrupoD_InventarioSISE.iservice.IMarcaService;
import com.example.GrupoD_InventarioSISE.model.Marca;
import com.example.GrupoD_InventarioSISE.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author RANDY
 */
@Service
public class MarcaService implements IMarcaService{
    
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Page<Marca> paginado(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return marcaRepository.findAll(pageable);
        } else {
            return marcaRepository.paginarMarcas(search, pageable);
        }
    }
}
