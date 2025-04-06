/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.GrupoD_InventarioSISE.service;

import com.example.GrupoD_InventarioSISE.dto.CategoriaDto;
import com.example.GrupoD_InventarioSISE.iservice.ICategoriaService;
import com.example.GrupoD_InventarioSISE.mapper.CategoriaMapper;
import com.example.GrupoD_InventarioSISE.model.Categoria;
import com.example.GrupoD_InventarioSISE.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author RANDY
 */
@Service
public class CategoriaService implements ICategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Page<CategoriaDto> Paginado(String search, Pageable pageable) {
        Page<Categoria> categorias;
        if (search == null || search.isEmpty()) {
            categorias = categoriaRepository.findAllActive(pageable);
        } else {
            categorias = categoriaRepository.paginarCategorias(search, pageable);
        }
        return CategoriaMapper.toDtoList(categorias, pageable);
    }

    @Override
    public Page<CategoriaDto> listarDtoPorDepartamento(Long iddepartamento, String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            search = "";
        }
        Page<Categoria> categorias = categoriaRepository.paginarCategoriasPorDepartamento(iddepartamento, search, pageable);
        return CategoriaMapper.toDtoList(categorias, pageable);
    }    
}
