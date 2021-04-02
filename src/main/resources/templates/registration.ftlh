
<#import "parts/_common.ftlh" as c>
<#import "parts/_login.ftlh" as l>

<@c.page>
   <div class="mb-1">Форма регистрации</div>
   ${message?ifExists}
   <@l.login "/registration" true />
</@c.page>