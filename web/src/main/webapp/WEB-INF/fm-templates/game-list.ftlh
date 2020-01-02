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
            <tr class="game">

                <td scope="row">${game.gameName}</td>
                <td align="center">${game.minPlayers} - ${game.maxPlayers}</td>
                <td>${game.category}</td>
                <td>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target=".bd-example-modal-lg">Informacje
                    </button>

                    <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog"
                         aria-labelledby="myLargeModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-body">
                                <table class="table table-striped table-dark">
                                    <thead>
                                    <tr>
                                        <th scope="col">Twórca gry</th>
                                        <th scope="col">Rok wydania</th>
                                        <th scope="col">Minimalny wiek</th>
                                        <th scope="col">Ranking BGG</th>
                                        <th scope="col">Mechanika</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td scope="row" align="center">${game.gameDesigner}</td>
                                        <td align="center">${game.yearPublished}</td>
                                        <td align="center">${game.minAge}</td>
                                        <td align="center">${game.bggRank}</td>
                                        <td align="center">${game.mechanic}</td>
                                    </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </#items>
    </#list>
    </tbody>
</table>


<script>

</script>
</body>
</html>