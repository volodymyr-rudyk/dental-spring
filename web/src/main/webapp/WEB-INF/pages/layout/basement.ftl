<#macro page title="Dental" css=[] js=[] bowerpath=[] bowerdist=[] bower=[]>
    <#include "macro.ftl" />

<#--<#import "spring.ftl" as spring />-->

<!DOCTYPE html>
<html>
<head>
  <title>${title}</title>

  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" href="/bower/bootstrap/dist/css/bootstrap.css">
  <link rel='stylesheet' href='/bower/angular-loading-bar/build/loading-bar.min.css' type='text/css' media='all' />
  <#--<link rel="stylesheet" href="/bower/bootstrap/dist/css/bootstrap-theme.css">-->

    <#list css as c>
      <link rel="stylesheet" href="/css/${c}.css">
    </#list>
</head>
<body>
    <@header />
    <#nested />
    <@footer />
    <#list bowerdist as b>
    <script type="application/javascript" src="/bower/${b}/dist/${b}.js"></script>
    </#list>
    <#list bower as b>
    <script type="application/javascript" src="/bower/${b}/${b}.js"></script>
    </#list>
    <#list bowerpath as path>
    <script type="application/javascript" src="/bower/${path}.js"></script>
    </#list>
    <#list js as j>
    <script type="application/javascript" src="/js/${j}.js"></script>
    </#list>
</body>
</html>
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
