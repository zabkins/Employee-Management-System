<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="EmployeeManagementSystem_0"></a>Employee-Management-System</h1>
<h2 class="code-line" data-line-start=1 data-line-end=2 ><a id="Simple_REST_service_for_managing_employees_database_1"></a>Simple REST service for managing employees database.</h2>
<p class="has-line-data" data-line-start="3" data-line-end="7">Application imitates how employees database could look like. It is built using Spring Boot, secured by Spring Security<br>
and runs on embedded H2 database. Few predefined Employee entities are loaded into database on startup in DataLoader class,<br>
which is in app sub-module.<br>
Application is split in two sub-modules:</p>
<ul>
<li class="has-line-data" data-line-start="7" data-line-end="8">DATA - contains domain classes</li>
<li class="has-line-data" data-line-start="8" data-line-end="10">APP - contains application logic</li>
</ul>
<p class="has-line-data" data-line-start="10" data-line-end="11">H2 Console is excluded from Spring Security and can be visited without authenticating</p>
<ul>
<li class="has-line-data" data-line-start="11" data-line-end="12">to open the console visit <code>localhost:8080/h2-console</code></li>
<li class="has-line-data" data-line-start="12" data-line-end="13">DB url is <code>jdbc:h2:mem:test</code></li>
<li class="has-line-data" data-line-start="13" data-line-end="14">username is <code>admin</code></li>
<li class="has-line-data" data-line-start="14" data-line-end="15">password should be left blank</li>
</ul>
<h1 class="code-line" data-line-start=15 data-line-end=16 ><a id="ENDPOINTS_OVERVIEW_15"></a>ENDPOINTS OVERVIEW</h1>
<p class="has-line-data" data-line-start="16" data-line-end="17">ALL ENDPOINTS MUST BE PREFIXED WITH <code>localhost:8080/api</code></p>
<table class="table table-striped table-bordered">
<thead>
<tr>
<th>URL</th>
<th>METHOD</th>
<th>REQUEST BODY</th>
<th>RESPONSE</th>
</tr>
</thead>
<tbody>
<tr>
<td>/login</td>
<td>POST</td>
<td>-</td>
<td></td>
</tr>
<tr>
<td>/logout</td>
<td>GET</td>
<td>-</td>
<td></td>
</tr>
<tr>
<td>/employees</td>
<td>GET</td>
<td>-</td>
<td>List of EmployeeModels</td>
</tr>
<tr>
<td>/employees</td>
<td>POST</td>
<td>EmployeeModel</td>
<td>Saved EmployeeModel</td>
</tr>
<tr>
<td>/employees/{id}</td>
<td>GET</td>
<td>-</td>
<td>EmployeeModel with specified ID</td>
</tr>
<tr>
<td>/employees/{id}</td>
<td>DELETE</td>
<td>-</td>
<td></td>
</tr>
</tbody>
</table>
<p class="has-line-data" data-line-start="26" data-line-end="29">LOGIN ENDPOINT - while trying to login, POST method must be requested and in order<br>
to authorize successfully, request must contain headers : ‘username’ and ‘password’ with values<br>
corresponding to one of the employees in database.</p>
<p class="has-line-data" data-line-start="30" data-line-end="31">LOGOUT ENDPOINT - to logout, only an empty GET call must be made and authentication will be removed.</p>
<h2 class="code-line" data-line-start=32 data-line-end=33 ><a id="EmployeeModel__32"></a>EmployeeModel :</h2>
<p class="has-line-data" data-line-start="33" data-line-end="34">JSON containing values as follows :</p>
<ul>
<li class="has-line-data" data-line-start="34" data-line-end="35">username</li>
<li class="has-line-data" data-line-start="35" data-line-end="36">password</li>
<li class="has-line-data" data-line-start="36" data-line-end="37">name</li>
<li class="has-line-data" data-line-start="37" data-line-end="38">lastName</li>
<li class="has-line-data" data-line-start="38" data-line-end="39">position</li>
<li class="has-line-data" data-line-start="39" data-line-end="41">salary</li>
</ul>
<p class="has-line-data" data-line-start="41" data-line-end="43"><code>IMPORTANT</code> - new employee can be saved only when login was made with MANAGER’s position employee, otherwise<br>
it won’t be saved</p>
<h1 class="code-line" data-line-start=44 data-line-end=45 ><a id="REQUESTS_PACK_44"></a>REQUESTS PACK</h1>
<p class="has-line-data" data-line-start="45" data-line-end="47">Repository contains file named <code>EmployeeAPI.postman_collection</code><br>
It includes collection of predefined requests that can be imported to PostMan for application testing</p>
<h1 class="code-line" data-line-start=48 data-line-end=49 ><a id="HOW_TO_RUN_48"></a>HOW TO RUN</h1>
<p class="has-line-data" data-line-start="49" data-line-end="51">To run the application, clone repository to your local drive and start main method in Application class<br>
which is in the app sub-module.</p>
