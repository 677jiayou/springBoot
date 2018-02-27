$().ready(function() {
    $("#commentForm").validate();
    $(".goback").click(function () {
        window.history.go(-1);
    })
});