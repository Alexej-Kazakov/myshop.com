<#include "security.ftlh">



<table class="table table-bordered mx-auto table-hover mt-3 " >
    <thead >
    <tr>
       <!-- <th style="vertical-align: middle; text-align: center">Пользователь</th> -->
        <th style="vertical-align: middle; text-align: center">Наименование</th>
        <th style="vertical-align: middle; text-align: center">Размер</th>
        <th style="vertical-align: middle; text-align: center">Кол-во</th>
        <th style="vertical-align: middle; text-align: center">Цена за ед.</th>
        <th style="vertical-align: middle; text-align: center">Сумма</th>
        <th style="vertical-align: middle; text-align: center" >Ссылка</th>
    </tr>
    </thead>
    <#list products as product>
    <tr>
        <!--<td style="vertical-align: middle; text-align: center"><a href="/user-products/${product.customer.id }">${product.customerName}</a></td>-->
        <td style="white-space: nowrap; vertical-align: middle; text-align: center">
            <#if product.customer.id == currentUserId>
                <a  href="/user-products/${product.customer.id }?product=${product.id}">${product.productName}</a>

                <#else>
                    ${product.productName}
            </#if>
        </td>
        <td style="vertical-align: middle; text-align: center"> ${product.productSize}</td>
        <td style="vertical-align: middle; text-align: center"> ${product.quantity}</td>
        <td style="vertical-align: middle; text-align: center"> ${product.productPrice}</td>
        <td style="vertical-align: middle; text-align: center"> ${product.quantity * product.productPrice} </td>
        <td  >
            <a href="${product.productLink}">${product.productLink}</a>

        </td>

    </tr>
    <#else>
    Список товаров пуст
    </#list>
</table>