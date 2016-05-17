<div>
  <table class="table table-striped table-bordered">
    <thead>
    <tr>
      <th>LastName</th>
      <th>FirstName</th>
      <th>MiddleName</th>
      <th>Birthday</th>
      <th>Gender</th>
      <th>Phone</th>
      <th>Change</th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="p in dentist.patients">
      <td>{{p.lastName}}</td>
      <td>{{p.firstName}}</td>
      <td>{{p.middleName}}</td>
      <td>{{p.birthday}}</td>
      <td>{{p.gender}}</td>
      <td>{{p.phone}}</td>
      <td><a ng-href="#edit/{{p.id}}" ng-click="edit(p.id)">edit</a> | <a href="javascript:void(0)" >delete</a>
    </tr>
    </tbody>
  </table>
</div>
