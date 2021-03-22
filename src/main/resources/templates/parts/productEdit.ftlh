

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Редактирование товара
</a>
<div class="collapse <#if product??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">

            <div class="form-group">
                <input type="text" class="form-control ${(productNameError??)?string('is-invalid', '')}"
                       value="<#if product??>${product.productName}</#if>" name="productName" placeholder="Наименование товара" />
                <#if productNameError??>
                    <div class="invalid-feedback">
                        ${productNameError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if product??>${product.productSize}</#if>" name="productSize" placeholder="Введите размер"/>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="quantity" placeholder="Кол-во" value="1" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control ${(productPriceError??)?string('is-invalid', '')}"
                       value="<#if product??>${product.productPrice}</#if>" name="productPrice" placeholder="Цена товара"/>
                <#if productPriceError??>
                    <div class="invalid-feedback">
                        ${productPriceError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control ${(productLinkError??)?string('is-invalid', '')}"
                       value="<#if product??>${product.productLink}</#if>" name="productLink" placeholder="Вставьте ссылку на товар"/>
                <#if productLinkError??>
                    <div class="invalid-feedback">
                        ${productLinkError}
                    </div>
                </#if>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="hidden" name="id" value="<#if product??>${product.id}</#if>" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Изменить</button>
            </div>
        </form>
    </div>
</div>