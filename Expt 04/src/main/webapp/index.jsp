<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Experiment 04 - Web Tech</title>
</head>
<body>
<h2>Enter Your Details</h2>

<form action="process" method="post">
    <label>Name:</label>
    <input type="text" name="name" required />
    <br><br>

    <label>Age:</label>
    <input type="text" name="age" required />
    <br><br>

    <button type="submit">Submit</button>
</form>
</body>
</html>
