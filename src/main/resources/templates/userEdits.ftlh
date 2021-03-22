<#import "parts/_common.ftlh" as c>

<@c.page>
    Редактирование пользователя
    <div class="form-group mt-3">
        <form action="/user" method="post">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Имя пользователя :</label>

                <div class="col-sm-6">
                    <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                           class="form-control ${(usernameError??)?string('is-invalid', '')}"
                           placeholder="User name" />
                    <#if usernameError??>
                        <div class="invalid-feedback">
                            ${usernameError}
                        </div>
                    </#if>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 form-label"> Телефон:  </label>
                <div class="col-sm-6">
                    <input type="text" name="phone" value="<#if user??> ${user.phone}</#if>"
                           class="form-control ${(phoneError??)?string('is-invalid', '')}" placeholder="Номер телефона"/>
                    <#if phoneError??>
                        <div class="invalid-feedback">
                            ${phoneError}
                        </div>
                    </#if>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Email:</label>
                <div class="col-sm-6">
                    <input type="email" name="email" value="<#if user??>${user.email}</#if>"
                           class="form-control ${(emailError??)?string('is-invalid', '')}"
                           placeholder="some@some.com" />
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
                </div>
            </div>


            <#list roles as role>
                <div>
                    <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                </div>
            </#list>


            <input type="hidden" value="${user.id}" name="userId">

            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Изменить</button>

        </form>
    </div>
</@c.page>