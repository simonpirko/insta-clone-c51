<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-white border">
    <div class="row">
        <div class="row">
            <div class="col d-flex align-items-center">
                <a href="#">
                    <img src="/page/images/sample_logo_user.jpg" alt="user" width="40" height="40">
                    <a href="#" class="link-dark text-decoration-none">friend_name</a>
                </a>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <img src="/user_data_storage/userid_2_imgid_20.jpg" class="img-fluid" alt="image_user">
            </div>
        </div>

        <div class="row">
            <div class="col d-flex justify-content-start">
                <div class="col-11">
                    <a class="navbar-brand" href="#">
                        <img src="/page/images/logo_heart.jpg" alt="like">
                    </a>
                    <a class="navbar-brand" href="#">
                        <img src="/page/images/logo_comments.png" alt="comments">
                    </a>
                    <a class="navbar-brand" href="#">
                        <img src="/page/images/logo_share.png" alt="share">
                    </a>
                </div>
                <!--                     INST-24: card-block-save-->
                <div class="col-1">
                    <form action="/account/savePost/">
                        <button type="submit" class="btn btn-primary" name="postId" value="${post.id}">
                            <a class="navbar-brand" href="#">
                                <img src="/page/images/logo_save.png" alt="save">
                            </a>
                        </button>
                    </form>

                </div>
            </div>
        </div>

        <div class="row">
            <div class="links">
                <a href="#" class="link-dark text-decoration-none">33 отметок "Нравиться"</a>
            </div>
        </div>

        <div class="row">
            <div class="col-3 d-flex justify-content-start">
                <dt class="links-sm-2">
                    <a href="#" class="link-dark text-decoration-none">userName</a>
                </dt>
            </div>
            <div class="col d-flex align-items-center">
                <small class="text-dark text-decoration-none fw">commentsUser</small>
            </div>
        </div>

        <div class="row">
            <div class="links">
                <a href="#" class="link-dark text-decoration-none">Посмотреть все коментарии</a>
            </div>
        </div>

        <div class="row">
            <div class="links">
                <a href="#" class="link-dark text-decoration-none">dataNewPost</a>
            </div>
        </div>

        <div class="row">
            <div class="col-2 d-flex justify-content-center p-1">
                <a class="navbar-brand" href="#">
                    <img src="/page/images/logo_smile.png" alt="smile">
                </a>
            </div>
            <div class="col-7">
                <form class="d-flex mb-0" action="/comment" method="post">
                    <button class="btn btn-outline" type="submit">
                        <input class="form-control" type="search" placeholder="Добавить комментарий...">
                    </button>
                </form>
            </div>
            <div class="col-2 d-flex justify-content-start p-3">
                <div class="links">
                    <a href="#" class="link-primary text-decoration-none">Опубликовать</a>
                </div>
            </div>
        </div>
    </div>
</nav>