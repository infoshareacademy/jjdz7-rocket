<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Form</title>
    <link rel="stylesheet" href="../../css/rocket.css" />
    <link rel="stylesheet" href="../../css/info.css"/>
</head>
<body>
<h2>Contact</h2>
<h5>
    Email: example@email.com
    <br>
    Phone: 123-456-789
    <br>
</h5>
<form>
    <div class="form-group">
        <label for="name">Name</label>
        <input type="name" class="form-contro" id="name" placeholder="Name">
        <br>
        <label for="email">e-mail</label>
        <input type="email" class="form-contro" id="email" placeholder="e-mail">
        <br>
        <label for="question">Your question</label>
        <textarea class="form-control" id="question" rows="2" placeholder="Type question..."></textarea>

        <form method="post" action="multiPartServlet" enctype="multipart/form-data">
            Choose a file: <input type="file" name="multiPartServlet" />
            <input type="submit" value="Upload" />
        </form>
    </div>

    <button type="button" class="btn btn-outline-success">Wylie</button>
</form>
</body>
</html>