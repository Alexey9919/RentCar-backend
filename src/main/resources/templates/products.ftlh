<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Товары со всей России</h4>
<form action="/cars" method="get">
    Поиск по названию объявления: <input type="text" name="model"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list cars as car>
    <div>
        <p><b>${car.model}</b> ${car.color} руб. | <a href="/cars/${car.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/cars/create" method="post" enctype="multipart/form-data">
    Модель: <input type="text" name="model"/><br><br>
    Цвет: <input type="text" name="color"/><br><br>
    Год: <input type="number" name="year"/><br><br>
    Номер: <input type="text" name="stateNumber"/><br><br>
    Срок аренды: <input type="number" name="rentalPeriod"/><br><br>
    <div>
        <p> <input type = "radio" name="body" value="1"/> Sedan</p>
        <p> <input type = "radio" name="body" value="2"/> Crossover</p>
        <p> <input type = "radio" name="body" value="3"/> Minivan</p>
        <p> <input type = "radio" name="body" value="4"/> Electrificated</p>
    </div>
    Фото: <input type="file" name="file"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>