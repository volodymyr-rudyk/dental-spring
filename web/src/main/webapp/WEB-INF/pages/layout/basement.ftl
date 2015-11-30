<#macro page title="Dental" css=[] js=[]>
<#--<#import "spring.ftl" as spring />-->

<!DOCTYPE html>
<html>
<head>
  <title>${title}</title>

  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/bootstrap.css">
    <#list css as c>
      <link rel="stylesheet" href="/css/${c}.css">
    </#list>
</head>
<body>
    <@page_header />

    <#nested />
    <@page_footer />

    <#list js as j>
    <script type="application/javascript" src="/js/${j}.js"></script>
    </#list>
</body >
</html>
</#macro>

<#macro page_header>
    <#include "header.ftl" />
</#macro>

<#macro page_footer>
    <#include "footer.ftl" />
</#macro>




<#--<#macro list title items>-->
<#--<p>${title?cap_first}:-->
<#--<ul>-->
<#--<#list items as x>-->
<#--<li>${x?cap_first}-->
<#--</#list>-->
<#--</ul>-->
<#--</#macro>-->
<#--<@list items=["mouse", "elephant", "python"] title="Animals"/>-->
