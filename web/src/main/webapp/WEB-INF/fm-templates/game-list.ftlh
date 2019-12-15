<!DOCTYPE html>
<html lang="pl-PL">
<#setting number_format="computer">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Lista gier</title>
    <style>
        body {
            background-image: url("../images/wood-grain-texture.jpg")
        }

        td {
            background-color: #000000
        }
        th{text-align: center}
    </style>
</head>
<body text="#f5f5dc">
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">NAZWA GRY</th>
        <th scope="col">LICZBA GRACZY</th>
        <th scope="col">TYP GRY</th>
    </tr>
    </thead>
    <tbody>
    <#list games>
        <#items as game>
    <tr>
        <td scope="row">${game.gameName}</td>
        <td align="center">${game.minPlayers} - ${game.maxPlayers}</td>
        <td>${game.category}</td>
    </tr>
        </#items>
    </#list>
    </tbody>
</table>
</body>
</html>