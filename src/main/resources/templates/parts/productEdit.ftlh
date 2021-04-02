
<div class="collapse <#if product??>show</#if>" id="collapseExample">
    <style>
        h1 {
            font-family: 'Times New Roman', Times, serif;
            font-size: 250%;
            color: #0000ff;
        }
    </style>

    <form method="post"  enctype="multipart/form-data">
        <div class="card flex-md-row mb-4 box-shadow h-md-250">
            <div class="card-body d-flex flex-column align-items-start">


                <div class="form-group">
                    <h1><#if product??>${product.productName}</#if></h1>
                    <input  type="hidden" class="form-control ${(productNameError??)?string('is-invalid', '')}"
                            value="<#if product??>${product.productName}</#if>" name="productName" placeholder="Наименование товара" readonly />
                    <#if productNameError??>
                        <div class="invalid-feedback">
                            ${productNameError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <label class="col-sm-0 col-form-label">Размер:</label>
                    <input type="text" class="form-control"
                           value="<#if product??>${product.productSize}</#if>" name="productSize" placeholder="Введите размер"/>

                </div>
                <div class="form-group">
                    <label class="col-sm-0 col-form-label">Количество:</label>
                    <style>
                        #pyat::-webkit-inner-spin-button {
                            opacity: 1;
                        }
                    </style>
                    <input type="number" required  id="pyat" min="1" class="form-control  col col-lg-5 "
                           value="<#if product??>${product.quantity}</#if>" name="quantity" placeholder="Кол-во"  />


                </div>
                <div class="form-group">
                    <label class="col-sm-0 col-form-label">Цена:</label>
                    <input type="text" class="form-control ${(productPriceError??)?string('is-invalid', '')}"
                           value="<#if product??>${product.productPrice}</#if>" name="productPrice" placeholder="Цена товара" readonly/>
                    <#if productPriceError??>
                        <div class="invalid-feedback">
                            ${productPriceError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">

                    <input type="hidden" class="form-control ${(productLinkError??)?string('is-invalid', '')}"
                           value="<#if product??>${product.productLink}</#if>" name="productLink" placeholder="Вставьте ссылку на товар" readonly/>
                    <#if productLinkError??>
                        <div class="invalid-feedback">
                            ${productLinkError}
                        </div>
                    </#if>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" name="id" value="<#if (product.id)??>${product.id}</#if>" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                    <button formaction="/user-products-delete/<#if (user.id)??>${user.id}</#if>" type="submit" class="btn btn-danger">Удалить</button>
                </div>
            </div>
            <input type="hidden" class="form-control " value="<#if product??>${product.photo}</#if>" name="photo"  />
            <img class="card-img-right mt-1 mr-3" data-src="<#if product??>${product.photo}</#if>" alt="Thumbnail [200x250]" style="width: 300px; height: 450px;" src="<#if product??>${product.photo}</#if>" data-holder-rendered="true">

        </div>
    </form>

</div>