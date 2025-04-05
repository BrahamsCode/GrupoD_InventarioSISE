/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.GrupoD_InventarioSISE.iservice;

import com.example.GrupoD_InventarioSISE.dto.ProveedorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author RANDY
 */
public interface IProveedorService {
    
    Page<ProveedorDto> Paginado(String search, Pageable pageable);
}
