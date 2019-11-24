<!DOCTYPE html>
<html lang="pl">
<#setting number_format="computer">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <meta charset="UTF-8">
    <title>Formularz kontaktowy</title>
    <link rel="stylesheet" href="../../css/rocket.css" />
    <link rel="stylesheet" href="../../css/info.css"/>
</head>
<body>
<h2>Formularz kontaktowy</h2>
<form>
    <div class="form-group">
        <label for="exampleInputEmail1">Adres e-mail</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    </div>
    <div class="form-group">
        <label for="exampleFormControlTextarea1">Wpisz swoje pytanie</label>
        <textarea class="form-control" id="exampleText" rows="3"></textarea>
    </div>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <button type="submit" class="btn btn-primary center-block">Wyślij</button>
        </div>
        <div class="col-md-4"></div>
    </div>
</form>
</body>
</html>