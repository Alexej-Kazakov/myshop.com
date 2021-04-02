<#include "security.ftlh">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Главная</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/main">Товары</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/user-products/${currentUserId}">Мои товары</a>
            </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Пользователи</a>
                </li>
            </#if>

        </ul>
        <#if user??>
        <div class="nav-bar-text mr-3" > Добро пожаловать:</div>
        <a class="nav-link" href="/user/profile">${name}</a>
        </#if>
        <div>
            <form action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button class="btn btn-primary" type="submit">Выйти</button>
            </form>

        </div>
    </div>
</nav>