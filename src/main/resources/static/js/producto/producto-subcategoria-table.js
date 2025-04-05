$(document).ready(function () {
    let subcategoriaId = window.location.pathname.split("/").pop();
    $('#tblProducto').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/api/producto/listar-subcategoria/" + subcategoriaId,
            "type": "GET",
            "data": function (d) {
                d.page = d.start / d.length;
                d.size = d.length;
                d.search = d.search.value;
            },
            "dataSrc": function (json) {
                json.recordsTotal = json.totalElements;
                json.recordsFiltered = json.totalElements;
                return json.content;
            }
        },
        "columns": [
            {
                "data": "id"
            },
            {
                "data": "nombre_categoria"
            },
            {
                "data": "nombre_marca"
            },
            {
                "data": "nombre_proveedor"
            },
            {
                "data": "codigo"
            },
            {
                "data": "nombre"
            },
            {
                "data": "descripcion"
            },
            {
                "data": "especificaciones"
            },
            {
                "data": "precio"
            },
            {
                "data": "stock"
            },
            {
                "data": "imagen_url"
            },
            {
                "data": "informacion_fabricante_url"
            },
            {
                "data": "id",
                "render": function (data, _, _) {
                    return '';
                }
            }
        ],
        "lengthMenu": [3, 6, 9, 12],
        "pageLength": 3
    });
    
    $(".btn-return").click(function () {
        window.history.back();
    });
});