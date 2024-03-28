<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%--
  ~ Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
  ~ All rights reserved.
  --%>

<!DOCTYPE html>
<html>

<head>
    <title><msg:message code="page.compose.title"/></title>

    <%@ include file="../common/head.jspf" %>
    <%@ include file="../common/navigation.jspf" %>

    <header class="masthead"
            style="background: url(&quot;/assets/img/banner.png&quot;) center / cover no-repeat;">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-lg-8 mx-auto position-relative">
                    <div class="site-heading">
                        <h1><msg:message code="page.compose.biglabel"/></h1>
                        <span class="subheading"><msg:message code="page.compose.sublabel"/></span>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <!-- PAGE MAIN CONTENT -->


    <div class="container">

        <div style="box-sizing: border-box;
    padding: 0;" method="post" id="postForm" enctype="multipart/form-data">
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"></div>
            <div class="form-group mb-3"><label class="form-label">Title</label>
                <input id="titleInput" class="form-control form-control" type="text" placeholder="title here..."
                       value="${articleEntity.title}" name="title" autocomplete="off" required minlength="6"
                       style="width: 620px;"/></div>
            <div>
                <input type="file" id="avatarInput" accept="image/png" style="display: none"
                       onchange="previewAvatar(this)">
           <%--     <textarea type="text" name="content" id="tiny"> ${articleEntity.contents}</textarea>--%>


                    <div class="row row-editor">
                        <div class="editor-container">
                            <div class="editor">
                                ${articleEntity.contents}
                            </div>
                        </div>
                    </div>


            <div class="row" style="margin-top: 18px;margin-bottom: 18px;">
                <div class="col-xxl-10" style="margin-bottom: 0px;width: 359.672px;">
                    <button class="btn btn-primary btn-sm" id="discardBtn"
                            style="position: relative;background: rgb(31,31,31);">Discard
                    </button>
                    <button class="btn btn-primary btn-sm" id="draftBtn"
                            style="position: relative;background: rgb(31,31,31);">Draft
                    </button>
                    <button class="btn btn-primary btn-sm" id="submitBtn"
                            style="position: relative;background: rgb(31,31,31);">Submit
                    </button>
                    <sec:authorize access="hasRole('ADMIN')">
                        ${notAuthor ? '<button class="btn btn-primary btn-sm" id="rejectArt" style="position: relative;background: rgb(31,31,31);">Reject Article</button>' : ''}
                    </sec:authorize>
                </div>
                <div class="col">
                    <div class="form-group mb-3" style="padding-left: 40px;"><label class="form-label">Category</label>
                        <input class="form-control form-control" type="text" id="categoryInput"
                               placeholder="category (e.g. allgemein, angeschaut...)" value="${articleEntity.category}"
                               name="category" autocomplete="off" required minlength="6" style="width: 429px;"/>
                    </div>
                </div>
            </div>
        </div>

        <div id="avatarPreview" style="width: 100px; height: 100px; border: 1px solid #ddd;"></div>
        <img id="existingAvatar" src="data:image/png;base64, ${articleEntity.base64preview}" alt="Existing Avatar"
             style="max-width: 100px; max-height: 100px; border: 1px solid #ddd; display: block;">
        <button type="button" onclick="openFileInput()">Select Thumbnail</button>

    </div>


    <!-- END PAGE MAIN CONTENT -->


    <%@ include file="../common/footer.jspf" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>


    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <script src="/assets/js/script.min.js"></script>
    <script src="/assets/js/ckeditor/build/ckeditor.js"></script>

    <script>
        window.addEventListener('load', function () {
/*            tinymce.init({
                selector: 'textarea#tiny',
                plugins: 'media',
                theme: 'silver',
                width: '100%',
                height: '600',
                menubar: 'insert',
                toolbar: 'undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | outdent indent',
                menubar: 'favs edit view insert format tools table help',
            });*/

            ClassicEditor
                .create( document.querySelector( '.editor' ), {} )
                .then( editor => {
                    window.editor = editor;
                } )
                .catch( error => {
                    console.error( error );
                } );

            const path = window.location.pathname;

// Split the path by '/' and find the index of 'compose'
            const pathArray = path.split('/');
            const indexOfCompose = pathArray.indexOf('compose');

// Obtain the id from the path
            postId = indexOfCompose !== -1 ? pathArray[indexOfCompose + 1] : null;

            console.log(postId); // Output: The value of {id} in the URL or null if not found
        });

        $(document).on('click', '#submitBtn', function () {
            save();
            setTimeout(() => {
                setPublished(true);

            }, 900);
            alert('Article Submitted!');

            setTimeout(() => {
                window.location.href = "/article?a=" + postId;
            }, 1200);
        });

        $(document).on('click', '#rejectArt', function () {
            setPublished(false)
            alert("Article rejected and sent back to author!")
        });


        $(document).on('click', '#draftBtn', function () {
            save();
        });


        $(document).on('click', '#discardBtn', function () {
            console.log("Discarded");
            // get the form data
            var formData = {
                id: postId
            };

            // send the form data to the server
            $.ajax({
                type: 'DELETE',
                url: '/api/v1/article?article=' + postId,
                dataType: 'json',
                encode: true
            })
                .done(function (response) {
                    // handle the server response
                    if (response.status == 200) {
                        console.log(response.message);
                        alert(response.message);
                        // redirect to the URL received from the server
                        setTimeout(() => {
                            window.location.href = "/home";
                        }, 1200);
                    } else {
                        console.log(response.message + response.status);
                        alert(response.message);
                        // display an error message to the user
                    }
                });
        });

        function openFileInput() {
            document.getElementById('avatarInput').click();
        }

        // Function to preview the selected avatar image
        function previewAvatar(input) {
            var preview = document.getElementById('avatarPreview');
            var existingAvatar = document.getElementById('existingAvatar');
            // Hide existing avatar if it's visible
            existingAvatar.style.display = 'none';
            preview.innerHTML = ''; // Clear previous content

            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    var img = document.createElement("img");
                    img.src = e.target.result;
                    img.style.width = '100%';
                    img.style.height = '100%';
                    preview.appendChild(img);
                };
                reader.readAsDataURL(input.files[0]);
            }
        }

        function save() {
            console.log("Drafted");
            // get the form data
            var formData = new FormData();
            formData.append('title', $('input[name=title]').val());
            formData.append('content', btoa(editor.getData()/*tinymce.activeEditor.getContent()*/));
            formData.append('category', $('input[name=category]').val());
            formData.append('article', postId);

            var avatarInput = document.getElementById('avatarInput');
            if (avatarInput.files && avatarInput.files[0]) {
                formData.append('previewImage', avatarInput.files[0]);
            }


            // send the form data to the server
            $.ajax({
                type: 'PATCH',
                url: '/api/v1/article',
                data: formData,
                processData: false,
                contentType: false,
                dataType: 'json',
            })
                .done(function (response) {
                    // handle the server response
                    if (response.status == 200) {
                        console.log(response.message);
                        alert(response.message);
                        // redirect to the URL received from the server
                    } else {
                        console.log(response.message);
                        alert(response.message);
                        // display an error message to the user
                    }
                });
        }

        function setPublished(boolean) {
            // send the form data to the server
            $.ajax({
                type: 'POST',
                url: '/api/v1/article?article=' + postId + '&pub=' + boolean,
                dataType: 'json',
                encode: true
            })
                .done(function (response) {
                    // handle the server response
                    if (response.status == 200) {
                        console.log(response.message);
                        alert(response.message);
                        // redirect to the URL received from the server
                        setTimeout(() => {
                            window.location.href = '/' + postId;
                        }, 4000);
                    } else {
                        console.log(response.message);
                        alert(response.message);
                        // display an error message to the user
                    }
                });
        }


    </script>

    </body>
</html>