<#import "../layout/loggedbasement.ftl" as base />

<@base.page dentist=dentist title="Dashboard" css=["header", "content"]
js=["main-module", "dashboard-module", "bootstrap"] bowerdist=["jquery"] bower=["angular", "angular-route"]>

<section class="white">
  <div class="container">
    <div class="row">
      <#--<div class="col-md-2">-->
        <#--<div class="list-group">-->
          <#--<a href="/dashboard/patient" class="list-group-item">Patients</a>-->
        <#--</div>-->
      <#--</div>-->

      <#--CONTENT-->
      <ul class="nav nav-tabs">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1
            <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Submenu 1-2</a></li>
            <li><a href="#">Submenu 1-3</a></li>
          </ul>
        </li>
        <li><a href="/dashboard/patient" >Patients</a>            </li>

        <li><a href="#">Menu 2</a></li>
        <li><a href="#">Menu 3</a></li>
      </ul>
    </div>
  </div>
</section>


</@base.page>