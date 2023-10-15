<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Подробная информация о товаре</h4>
<#--<#list images as img>-->
<#--    <img src="/images/${img.id}" height="160px"/><br><br>-->
<#--</#list>-->
<b>Название товара: </b>${car.model}<br>
<b>Описание товара: </b>${car.color}<br>
<b>Цена: </b>${car.year}<br>
<b>Город: </b>${car.state_number}<br>
<b>Автор: </b>${car.retal_period}<br>
<hr>
<#--<form action="/cars/delete/${product.id}" method="post">-->
<#--    <input type="submit" value="Удалить товар"/>-->
<#--</form>-->
</body>
</html>