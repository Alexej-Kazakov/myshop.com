<#import "parts/_common.ftlh" as c>

<@c.page>
    <h5 xmlns="http://www.w3.org/1999/html"> Имя пользователя: ${username}</h5>
    ${message?ifExists}
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Пароль" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email:</label>
            <div class="col-sm-6">
                <input type="email" name="email" class="form-control" placeholder="some@some.com" value="${email!''}" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label" >Телефон:</label>
            <div class="col-sm-6">
                <input type="text" name="phone" class="form-control" placeholder="Номер телефона" value="${phone!''}" />
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</@c.page>