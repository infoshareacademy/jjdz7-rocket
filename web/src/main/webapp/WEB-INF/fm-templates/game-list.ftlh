<html>
<head>
    <title>Lista gier</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID gry</th> <th>Nazwa gry</th> <th>Liczba graczy</th> <th>Typ gry</th>
    </tr>
    </thead>
    <tbody>

    <#list games>
     <ul>
         <#items as game>
             <li>
                 <td>${game.gameID}</td> <td>${game.gameName}</td> <td>${game.minPlayers} - ${game.maxPlayers}</td> <td>${game.category}</td>
             </li>
         </#items>
     </ul>
    </#list>

    </tbody>
</table>

</body>
</html>