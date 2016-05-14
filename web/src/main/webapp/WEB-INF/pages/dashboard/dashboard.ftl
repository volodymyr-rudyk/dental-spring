<#import "../layout/loggedbasement.ftl" as base />

<@base.page dentist=dentist title="Dashboard" css=["header", "content"]
js=["main-module", "dashboard-module", "bootstrap"] bowerdist=["jquery"] bower=["angular", "angular-route"]>

<section class="white">
  <div class="container">
    <div class="row">
      <div class="col-md-2">
        <div class="list-group">
          <a href="/dashboard/patient" class="list-group-item">Patients</a>
        </div>
      </div>

      CONTENT

    </div>
  </div>
</section>


</@base.page>