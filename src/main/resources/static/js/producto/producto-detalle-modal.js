// Archivo: /static/js/producto/producto-detalle-modal.js
$(document).ready(function() {
    // Variable para almacenar los datos del producto seleccionado
    let productoSeleccionado = null;
    
    // Modificar la columna de acciones en la tabla
    $('#tblProducto').on('draw.dt', function() {
        $('#tblProducto tbody tr').each(function() {
            const row = $(this);
            const id = row.find('td:first').text();
            const actionCell = row.find('td:last');
            
            // Agregar botón de ver detalles
            if (actionCell.find('.btn-ver-detalle').length === 0) {
                actionCell.html('<button class="btn btn-info btn-sm btn-ver-detalle" data-id="' + id + '"><i class="bi bi-eye"></i></button>');
            }
        });
    });
    
    // Manejador para botón de ver detalles
    $('#tblProducto').on('click', '.btn-ver-detalle', function() {
        const id = $(this).data('id');
        
        // Obtener los datos completos del producto
        $.ajax({
            url: '/api/producto/' + id,
            type: 'GET',
            success: function(producto) {
                productoSeleccionado = producto;
                cargarDatosEnModal(producto);
                $('#detalleProductoModal').modal('show');
            },
            error: function() {
                alert('Error al cargar los detalles del producto');
            }
        });
    });
    
    // Función para cargar los datos en el modal
    function cargarDatosEnModal(producto) {
        $('#detalle-id').text(producto.id);
        $('#detalle-codigo').text(producto.codigo);
        $('#detalle-nombre').text(producto.nombre);
        $('#detalle-precio').text('S/ ' + parseFloat(producto.precio).toFixed(2));
        $('#detalle-stock').text(producto.stock);
        $('#detalle-categoria').text(producto.nombre_categoria);
        $('#detalle-marca').text(producto.nombre_marca);
        $('#detalle-proveedor').text(producto.nombre_proveedor);
        $('#detalle-descripcion').text(producto.descripcion || 'No disponible');
        $('#detalle-especificaciones').text(producto.especificaciones || 'No disponible');
        
        // Manejo de la imagen del producto
        if (producto.imagen_url) {
            $('#detalle-imagen').attr('src', producto.imagen_url);
            $('#detalle-imagen-url').text(producto.imagen_url);
        } else {
            $('#detalle-imagen').attr('src', '/img/no-image.png');
            $('#detalle-imagen-url').text('No disponible');
        }
        
        $('#detalle-fabricante').text(producto.informacion_fabricante_url || 'No disponible');
    }
    
    // Manejador para botón de editar producto desde el modal
    $('#btnEditarProducto').on('click', function() {
        if (productoSeleccionado) {
            window.location.href = '/producto/editar/' + productoSeleccionado.id;
        }
    });
    
    // Manejador para botón de nuevo producto
    $('#btnNuevoProducto').on('click', function() {
        window.location.href = '/producto/nuevo';
    });
});