function startListening() {
    ajaxCall("/web/mongo-training/start-listening");
}

function stopListening() {
    ajaxCall("/web/mongo-training/stop-listening");
}
function ajaxCall(url) {

    $.ajax({
      url: url,
    });

}

function searchText() {
    $.ajax({
      url: '/web/mongo-training/search?searchText=' + $('#search').val(),
      success: function(data) {
        var text = '';
        for (var i = 0; i < data.length; i++) {
            text += data[i].text + "\n";
        }
        $('#hello').text(text);
      }
    });
}

function nearSphere() {
    $.ajax({
      url: '/web/mongo-training/near-sphere',
      success: function(data) {
        var text = '';
        for (var i = 0; i < data.length; i++) {
            text += data[i].text + "\n";
        }
        $('#hello').text(text);
      }
    });
}