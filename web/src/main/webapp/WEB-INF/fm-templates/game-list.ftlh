<html>
<head>
    <title>Lista gier</title>
    <style> td, th { border: 1px solid #f8fffd; }</style>

</head>
<body>
<table>
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