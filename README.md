<h1>Spring Boot REST API</h1>

<p>
A simple CRUD REST API built using Spring Boot, Spring Data JPA, and MySQL for managing student records.
</p>

<h2>🚀 Technologies Used</h2>
<ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Spring Data JPA</li>
    <li>MySQL</li>
    <li>Maven</li>
</ul>

<h2>📌 Features</h2>
<ul>
    <li>Create Student</li>
    <li>Get Student Details</li>
    <li>Update Student</li>
    <li>Delete Student</li>
    <li>MySQL Database Integration</li>
</ul>

<h2>⚠️ Before Running the Project</h2>

<p>
Create a MySQL database named <strong>studentdb</strong>.
</p>

<pre>
CREATE DATABASE studentdb;
</pre>

<p>
Update your database credentials in the <code>application.properties</code> file before starting the application.
</p>

<h2>▶️ Run the Project</h2>

<pre>
git clone https://github.com/gauravsgunjal/SprintBootRestAPI.git
cd SprintBootRestAPI
mvn spring-boot:run
</pre>

<p>
The application will run on:
</p>

<pre>
http://localhost:8080
</pre>

<h2>🛠 API Endpoints</h2>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Method</th>
        <th>Endpoint</th>
    </tr>
    <tr>
        <td>GET</td>
        <td>/students</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/students/{id}</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/student/add</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/student/update</td>
    </tr>
    <tr>
        <td>DELETE</td>
        <td>/student/delete/{id}</td>
    </tr>
</table>

<h2>👨‍💻 Author</h2>

<p>
<strong>Gaurav Gunjal</strong><br>
<a href="https://github.com/gauravsgunjal">GitHub Profile</a>
</p>

<hr>

<p>
⭐ If you found this project useful, please give it a star.
</p>
