function search() {
    var data = {keyword: $('#keyword').val(), perPage: $('#perPage').val()};
    $.post('/', data, function (items) {
        console.log($(items).find('#columns').has("div"));
        if ($(items).find('#columns').has("div").length){
            $('#columns').html($(items).find('#columns').html());
        }else{
            $('#columns').html("<h1>Ooops, you have to search for something</h1>");
        }
    },'html');
}

$("#form").submit(function(e) {
    search();
    e.preventDefault();
});