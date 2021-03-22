

<table class="table table-bordered mx-auto table-hover mt-3 " >
    <thead >
    <tr>
        <th scope="col">Пользователь</th>
        <th scope="col">Наименование</th>
        <th scope="col">Размер</th>
        <th scope="col">Кол-во</th>
        <th scope="col">Цена за ед.</th>
        <th scope="col">Ссылка</th>
    </tr>
    </thead>
    <#list products as product>
        <tr>
            <td> ${product.customerName}</td>
            <td> ${product.productName}</td>
            <td> ${product.productSize}</td>
            <td> ${product.quantity}</td>
            <td> ${product.productPrice}</td>
            <td><a href="${product.productLink}">${product.productLink}</a></td>
        </tr>
    <#else>
        Список товаров пуст
    </#list>
</table>