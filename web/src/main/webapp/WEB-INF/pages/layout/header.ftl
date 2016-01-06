<header class="header">
  <div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a href="/" class="navbar-brand">dntistpro.com</a>
      </div>

      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
        <#if profile?has_content>
          <li>
            <#--<div class="dropdown pull-right">-->
              <#--<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" id="dropdownmenu1"-->
                      <#--aria-haspopup="true" aria-expanded="true">-->
                <#--${profile.firstName} ${profile.lastName}-->
                <#--<span class="caret"></span>-->
              <#--</button>-->
              <#--<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownmenu1">-->
                <li><a href="/profile">${profile.firstName} ${profile.lastName}</a></li>
                <li><a href="/logout">Logout</a></li>
              <#--</ul>-->
            </div>
          </li>
        </#if>
        </ul>
      </div>
    </div>
  </div>
</header>
