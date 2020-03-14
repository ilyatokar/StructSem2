<!DOCTYPE html>
<html>
<head>
    <title>Ломаная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU&amp;apikey=<16d41075-07d4-4280-a890-438457d750b3>" type="text/javascript"></script>
    <script src="polyline.js" type="text/javascript"></script>
    <style>
        html, body, #map {width: 100%; height: 100%; padding: 0; margin: 0;}
    </style>
</head>
<body>
<div id="map"></div>
<script>
    ymaps.ready(init);
    function init() {
        var myMap = new ymaps.Map("map", {
            center: [${centerMapX}, ${centerMapY}],
            zoom: 4
        }, {
            searchControlProvider: 'yandex#search'
        });
        <#if positionDotsSelectedSize != 0>
        var Second = new ymaps.Polyline([
            // Указываем координаты вершин ломаной.
            <#list positionDotsSelected as item>
            [${item.latitude}, ${item.longitude}],
            </#list>
        ], {
            balloonContent: "Ломаная линия"
        }, {
            balloonCloseButton: false,
            strokeColor: "#0057e7",
            strokeWidth: 4,
            strokeOpacity: 0.8
        });
        </#if>
        var myPolyline = new ymaps.Polyline([
            // Указываем координаты вершин ломаной.
            <#list positions as item>
            [${item.latitude}, ${item.longitude}],
            </#list>
        ], {
            balloonContent: "Ломаная линия"
        }, {
            balloonCloseButton: false,
            strokeColor: "#00a651",
            strokeWidth: 4,
            strokeOpacity: 0.8
        });
        myMap.geoObjects
            .add(myPolyline)
            <#if positionDotsSelectedSize != 0>.add(Second)</#if>
            <#if positionDotsSelectedSize != 0>
            .add(new ymaps.Placemark([${positionStartX}, ${positionStartY}], {
                balloonContent: ' Выбранный путь '
            }, {
                preset: 'islands#icon',
                iconColor: '#0057e7'
            }))
            .add(new ymaps.Placemark([${positionEndX}, ${positionEndY}], {
                balloonContent: ' Выбранный путь '
            }, {
                preset: 'islands#icon',
                iconColor: '#0057e7'
            }))
            </#if>
            .add(new ymaps.Placemark([${startX}, ${startY}], {
                balloonContent: ' Начало маршурута'
            }, {
                preset: 'islands#icon',
                iconColor: '#ff0000'
            }))
            .add(new ymaps.Placemark([${endX}, ${endY}], {
                balloonContent: 'Окончание маршурута'
            }, {
                preset: 'islands#icon',
                iconColor: '#ff0000'
            }));
    }
</script>
</body>
</html>
