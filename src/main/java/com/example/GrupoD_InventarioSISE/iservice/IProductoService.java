/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.GrupoD_InventarioSISE.iservice;

import com.example.GrupoD_InventarioSISE.dto.ProductoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author RANDY
 */
public interface IProductoService {
    
    Page<ProductoDto> Paginado(String search, Pageable pageable);
    Page<ProductoDto> listarDtoPorSubCategoria(Long idsubcategoria, String search, Pageable pageable);
}
