<?php
require_once 'db.php';
require_once 'show_events.php';
session_start();
?>
<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="bg-dark">
<div class="container-fluid">
    <div class="col-lg-8 mx-auto shadow border rounded bg-light mt-3">
        <form method="post" action="add_event.php" class="p-3" id="register_form" data-mod='register'>
            <div class="row justify-content-around">
                <div class="col-12">
                    <div class="form-group">
                        <label for="name">Nazwa wydarzenia:</label>
                        <input class="form-control" type="text" name="name" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label for="place">Miejsce:</label>
                        <input class="form-control" type="text" name="place" autocomplete="off">
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="players">Ilość graczy:</label>
                        <input class="form-control" type="number" value="1" min="1" name="players" autocomplete="off">
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="date">Data:</label>
                        <input class="form-control" type="date" name="date" autocomplete="off">
                    </div>
                </div>
                <button class="btn btn-dark w-100" type="submit" name="add">Dodaj</button>
            </div>
        </form>
    </div>
    <div class="col-lg-8 mx-auto shadow border rounded bg-light mt-3">
        <table class="table">
            <thead>
            <tr>
                <th>Nr</th>
                <th>Nazwa</th>
                <th>Miejsce</th>
                <th>Ilość graczy</th>
                <th>Data</th>
            </tr>
            </thead>
            <tbody>
            <?php showEvents($mysqli); ?>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>