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
        <th scope="col">NAZWA WYDARZENIA</th>
        <th scope="col">ADRES WYDARZENIA</th>
        <th scope="col">DATA I GODZINA</th>
    </tr>
    </thead>
    <tbody>
    <#list events>
        <#items as event>

               <tr class="event">

                    <td scope="row">${event.eventName}</td>
                    <td align="center">${event.eventCity} - ${event.eventAddress}</td>
                    <td align="center">${event.eventDate} - ${event.eventStartTime}</td>

                </tr>
        </#items>
    </#list>
    </tbody>
</table>


<script>

</script>
</body>
</html>