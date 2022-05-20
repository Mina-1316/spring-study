// To isolate the app from the global scope
const main = {
    init: function () {
        // Initialize the app
        var _this = this;
        // save button event listener
        $('#btn-save').on('click', function () {
            _this.save();
        });
        // update button event listener
        $('#btn-update').on('click', function () {
            _this.update();
        });
        // delete button event listener
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save: function (){
        // Save the data
        // field is title, author, content
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };
        // ajax on /api/v1/posts
        // datatype is json, data stringifys the data to json
        $.ajax({
            url: '/api/v1/posts',
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json',
        }).done(function (data) {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (data) {
            alert('글 등록에 실패했습니다.');
        });
    },
    update: function () {
        // Update the data
        // field is title, author, content
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };
        // ajax on PUT /api/v1/posts/:id
        // datatype is json, data stringifys the data to json
        $.ajax({
            url: '/api/v1/posts/' + $('#id').val(),
            type: 'PUT',
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json',
        }).done(function (data) {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (data) {
            alert('글 수정에 실패했습니다.');
        });
    },
    delete: function () {
        // Delete the data
        // ajax on DELETE /api/v1/posts/:id
        $.ajax({
            url: '/api/v1/posts/' + $('#id').val(),
            type: 'DELETE',
            dataType: 'json',
        }).done(function (data) {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (data) {
            alert('글 삭제에 실패했습니다.');
        });
    }
}

main.init();