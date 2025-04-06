/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.GrupoD_InventarioSISE.service;

import com.example.GrupoD_InventarioSISE.dto.ProveedorDto;
import com.example.GrupoD_InventarioSISE.iservice.IProveedorService;
import com.example.GrupoD_InventarioSISE.mapper.ProveedorMapper;
import com.example.GrupoD_InventarioSISE.model.Proveedor;
import com.example.GrupoD_InventarioSISE.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author RANDY
 */
@Service
public class ProveedorService implements IProveedorService{
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Page<ProveedorDto> Paginado(String search, Pageable pageable) {
        Page<Proveedor> proveedores;
        if (search == null || search.isEmpty()) {
            proveedores = proveedorRepository.findAllActive(pageable);
        } else {
            proveedores = proveedorRepository.paginarProveedores(search, pageable);
        }
        return ProveedorMapper.toDtoList(proveedores, pageable);
    }
    
}
