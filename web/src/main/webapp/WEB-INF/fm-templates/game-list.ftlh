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

        th {
            text-align: center
        }

    </style>
</head>
<body text="#f5f5dc">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
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
            <#if game.extraLook>
                <tr class="game">

                    <td scope="row" style="color: #7a6e0e" >${game.gameName}</td>
                    <td align="center" style="color: #7a6e0e">${game.minPlayers} - ${game.maxPlayers}</td>
                    <td style="color: #7a6e0e">${game.category}</td>

                </tr>


            <#else >

                <tr class="game">

                    <td scope="row">${game.gameName}</td>
                    <td align="center">${game.minPlayers} - ${game.maxPlayers}</td>
                    <td>${game.category}</td>

                </tr>
            </#if>
        </#items>
    </#list>
    </tbody>
</table>


<script>

</script>
</body>
</html>