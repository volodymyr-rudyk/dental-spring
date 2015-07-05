<#macro page title>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
    <@page_header />
<h1>${title}</h1>
    <#nested />
    <@page_footer />
</body>
</html>
</#macro>

<#macro page_header>
    <#include "header.ftl" />
</#macro>

<#macro page_footer>
    <#include "footer.ftl" />
</#macro>