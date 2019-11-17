<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="../../css/CSS.Roket.css" />
    <link rel="stylesheet" href="../../css/fontello.css" />
    <link rel="stylesheet" href="../../https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="kubuś">
</head>

<body>

<div class="wrapper">
    <div class="header">

        <div class="logo" >
            <img src="../../resources/grajdolex10.png" style="float: left;"/>
            <div style="clear:both;"></div>
        </div>
    </div>
    <div class="nav">
        <div style="clear:both;"></div>
        <ol>
            <li><a href="#">Strona główna</a></li>
            <li><a href="#">O Nas</a>
                <ul>
                    <li><a href="html-style/contactForm.html">kontakt</a></li>
                    <li><a href="html-style/Info.html">informacje</a></li>
                </ul>
            </li>
            <li><a href="#">Baza Gier</a>
                <ul>
                    <li><a href="#">Dodaj Gre</a></li>
                    <li><a href="#">Ulubione</a></li>
                    <li><a href="#">lista gier</a></li>
                </ul>
            </li>
            <li><a href="#">Wydarzenia</a>
                <ul>
                    <li><a href="#">Dodaj Wydarzenie</a></li>
                    <li><a href="#">wydarzenia</a></li>
                    <li><a href="#">miejsca na gry</a></li>
                </ul>
            </li>

            <li><a href="html-style/mapsG.html">mapa</a></li>
        </ol>

    </div>

    <div class="content">


    <div class="socials">
        <div class="socialdivs">
            <div class="fb">
                <i class="icon-facebook"></i>
            </div>
            <div class="yt">
                <i class="icon-youtube"></i>
            </div>
            <div class="tw">
                <i class="icon-twitter"></i>
            </div>
            <div class="gplus">
                <i class="icon-gplus"></i>
            </div>
            <div style="clear:both"></div>
        </div>
    </div>

    <div class="footer">Retrogranie.com &copy; </div>
</div>

<script src="jquery-1.11.3.min.js"></script>

<script>

    $(document).ready(function() {
        var NavY = $('.nav').offset().top;

        var stickyNav = function(){
            var ScrollY = $(window).scrollTop();

            if (ScrollY > NavY) {
                $('.nav').addClass('sticky');
            } else {
                $('.nav').removeClass('sticky');
            }
        };

        stickyNav();

        $(window).scroll(function() {
            stickyNav();
        });
    });

</script>


</body>
</html>