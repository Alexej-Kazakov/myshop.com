<#import "parts/_common.ftlh" as c>
<@c.page>
    <#if isCurrentUser>
        <#include "parts/productEdit.ftlh"/>
    </#if>

    <#include "parts/productList.ftlh"/>

</@c.page>