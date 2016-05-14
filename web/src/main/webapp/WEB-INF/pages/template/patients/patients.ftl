<div class=" col-md-9">
  <div class="">
    <table class="table table-striped table-bordered">
      <thead>
      <tr>
        <th>LastName</th>
        <th>FirstName</th>
        <th>MiddleName</th>
        <th>Change</th>
      </tr>
      </thead>
      <tbody>
      <tr ng-repeat="p in dentist.patients">
        <td>{{p.lastName}}</td>
        <td>{{p.firstName}}</td>
        <td>{{p.middleName}}</td>
        <td> <a href="javascript:void(0)" ng-click="edit(contact.id)">edit</a> | <a href="javascript:void(0)" ng-click="delete(contact.id)">delete</a>
      </tr>
      </tbody>
    </table>
  </div>
</div>