<!DOCTYPE html>
<html lang="pl" >
<#setting number_format="computer">
<head>
    <meta charset="UTF-8">
    <title>Lista gier</title>
    <style> td, th { border: 1px solid #fcff6a; }
      body {background-image: url("../images/wood-grain-texture.jpg")}
        td{background-color: #000000
        }
        </style>
</head>
<body text="#f5f5dc">
<table align="center" style="width: 100%" cellspacing="10" >
    <thead>
    <tr>
        <th>ID GRY</th>
        <th>NAZWA GRY</th>
        <th>LICZBA GRACZY</th>
        <th>TYP GRY</th>
    </tr>
    </thead>
    <tbody>
    <#list games>

            <#items as game>
                    <tr >
                        <td align="left">${game.gameId}</td>
                        <td align="center">${game.gameName}</td>
                        <td align="center">${game.minPlayers} - ${game.maxPlayers}</td>
                        <td align="center">${game.category}</td>
                    </tr>
            </#items>
    </#list>

    </tbody>
</table>
</body>
</html>