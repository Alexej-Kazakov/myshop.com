<#import "parts/_common.ftlh" as c>

<@c.page>
    <h1> Список пользователей </h1>

    <table class="table table-bordered mx-auto table-hover mt-3 " >
        <thead>
        <tr>
            <th scope="col">Имя пользователя</th>
            <th scope="col">Номер телефона</th>
            <th scope="col">Email</th>
            <th scope="col">Роли</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.phone}</td>
                <td>${user.email}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">Изменить</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>

