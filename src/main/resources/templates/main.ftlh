<#import "parts/_common.ftlh" as c>
<@c.page>
    <div class="form-group mt-3">
        <form method="GET" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control col-md-8" value="${filter?ifExists}" placeholder="Вставьте ссылку на товар">
            <button type="submit" class="btn btn-primary ml-2" >Найти</button>
        </form>
    </div>
    <br>




    <#include "parts/productEdit.ftlh"/>



    <#include "parts/productList.ftlh"/>


</@c.page>