<%--
  Created by IntelliJ IDEA.
  User: rpm
  Date: 27.03.2019
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../styles/page1.css"/>
    <link rel="stylesheet" href="../styles/table1.css"/>
    <%--<style>  div{border-radius: 10px}  </style>--%>
</head>
<body>
<div class="header">
    <table width="100%" height="100%" cellspacing="0" cellpadding="4" padding="0px">
        <tr>
            <td class="header-logo"><img src="../images/logo.png" alt="Найти подарок - легко!"></td>
            <td class="header-contact">
                <ul>
                    <li><img padding="0px" src="../images/mts.png" height="20px" width="20px"> <a
                            href="tel:+375295630777">375(29)-56-30-777</a></li>
                    <li><img padding="0px" src="../images/welcom.png" height="20px" width="20px"> <a
                            href="tel:+375335630888">375(33)-56-30-888</a></li>
                    <li><img src="../images/viber.png" height="25px" width="25px"
                             href="viber://add?number=375295630777"></li>
                </ul>
            </td>
            <td class="header-logo2"><img height="130px" src="../images/logo11.png" alt="Найти подарок - легко!"></td>
            <td class="header-find">

                <a class="a-btn-text" href="https://www.google.com/maps/dir/%D0%A2%D0%A6+%D0%9A%D0%BE%D1%80%D0%BE%D0%BD%D0%B0/%D0%91%D0%BE%D1%80%D0%B8%D1%81%D0%BE%D0%B2%D1%81%D0%BA%D0%B8%D0%B9+%D1%82%D1%80%D0%B0%D0%BA%D1%82,+%D0%BF%D1%80%D0%BE%D1%81%D0%BF%D0%B5%D0%BA%D1%82+%D0%9D%D0%B5%D0%B7%D0%B0%D0%B2%D0%B8%D1%81%D0%B8%D0%BC%D0%BE%D1%81%D1%82%D0%B8,+%D0%9C%D0%B8%D0%BD%D1%81%D0%BA/53.9372191,27.6729538/@53.9363479,27.6711403,17.5z/data=!4m15!4m14!1m5!1m1!1s0x46dbcec7d60a8e57:0x6fecf48629b72b98!2m2!1d27.6731286!2d53.9368532!1m5!1m1!1s0x46dbcecf65dd9c89:0x57c3d362592f63da!2m2!1d27.6663906!2d53.9384151!1m0!3e2">
                    <img height="30px" width="25px" src="../images/place_link.png"/>
                    <span >ТЦ Корона, пр-т Независимости 154, Минск</span>
                </a>
                <%--<p></p>--%>
                <div>
                <form action="" method="post" class="search">
                    <input type="search" name="" placeholder="поиск" class="input"/>
                    <input type="submit" name="" value="" class="submit"/>
                </form>
                </div>
            </td>
            <td class="header-logo3"><img height="130px" src="../images/logo9.png" alt="Найти подарок - легко!"></td>
            <th class="header-reg">
                <form>
                    <button formaction="user_reg" class="basket-btn">
                        <img src="../images/basket_empty.png" height="80" alt="Корзина"/>
                        <span class="a-btn-text">Корзина</span>
                    </button>
                </form>
            </th>

        </tr>
    </table>
</div>
<div class="layout">
    <div class="sidebar">
        <form>
            <div class="filter">
            <div class="name_list" >Подарки</div>
            <%--<output>Цена от </output>--%>
            <%--<input type="number" id="min_val" name="min_val" placeholder="цена от" >--%>
            <%--<input type="number" id="max_val" name="max_val"placeholder="до" >--%>
            <input type="number" id="min_val" name="min_val"
                   min="0" max="99999" placeholder="цена от" >
            <input type="number" id="max_val" name="max_val"
                   min="0" max="99999" placeholder="до" >
            <input type="submit" id="Find" value="Найти" formaction="user_reg">
            </div>
        </form>

        <ul class="menu-left">
            <li><a href="link1.html">Девушке</a></li>
            <li><a href="link1.html">Парню</a></li>
            <li><a href="link1.html">Мужу</a></li>
            <li><a href="link1.html">Жене</a></li>
            <li><a href="link1.html">Сыну</a></li>
            <li><a href="link1.html">Дочке</a></li>
            <li><a href="link1.html">Маме</a></li>
            <li><a href="link1.html">Папе</a></li>
            <li><a href="link1.html">Другу</a></li>
            <li><a href="link1.html">Подруге</a></li>
            <li><a href="link1.html">Коллеге</a></li>
            <li><a href="link1.html">Дедушке</a></li>
            <li><a href="link1.html">Бабушке</a></li>
        </ul>
    </div>
    <div class="content">
        <table class="main-table">
            <tr>
                <td class="product"><div> <img src="../images/product/1.jpg"></div><div class="price">47$</div></td>
                <td class="product"><div> <img src="../images/product/2.jpg"></div><div class="price">1$</div></td>
                <td class="product"><div> <img src="../images/product/3.jpg"></div><div class="price">22$</div></td>
                <td class="product"><div> <img src="../images/product/4.jpg"></div><div class="price">3$</div></td>
                <td class="product"><div> <img src="../images/product/5.jpg"></div><div class="price">57$</div></td>
            </tr>
            <tr>
                <td class="product"><div> <img src="../images/product/5.jpg"></div><div class="price">47$</div></td>
                <td class="product"><div> <img src="../images/product/7.jpg"></div><div class="price">1$</div></td>
                <td class="product"><div> <img src="../images/product/8.jpg"></div><div class="price">22$</div></td>
                <td class="product"><div> <img src="../images/product/9.jpg"></div><div class="price">3$</div></td>
                <td class="product"><div> <img src="../images/product/10.jpg"></div><div class="price">57$</div></td>
            </tr>
            <tr>
                <td class="product"><div> <img src="../images/product/11.jpg"></div><div class="price">47$</div></td>
                <td class="product"><div> <img src="../images/product/12.jpg"></div><div class="price">1$</div></td>
                <td class="product"><div> <img src="../images/product/13.jpg"></div><div class="price">22$</div></td>
                <td class="product"><div> <img src="../images/product/14.jpg"></div><div class="price">3$</div></td>
                <td class="product"><div> <img src="../images/product/15.jpg"></div><div class="price">57$</div></td>
            </tr>
            <tr>
                <td class="product"><div> <img src="../images/product/16.jpg"></div><div class="price">47$</div></td>
                <td class="product"><div> <img src="../images/product/17.jpg"></div><div class="price">1$</div></td>
                <td class="product"><div> <img src="../images/product/18.jpg"></div><div class="price">22$</div></td>
                <td class="product"><div> <img src="../images/product/19.jpg"></div><div class="price">3$</div></td>
                <td class="product"><div> <img src="../images/product/20.jpg"></div><div class="price">57$</div></td>
            </tr>
            <tr>
                <td class="product"><div> <img src="../images/product/21.jpg"></div><div class="price">47$</div></td>
                <td class="product"><div> <img src="../images/product/22.jpg"></div><div class="price">1$</div></td>
                <td class="product"><div> <img src="../images/product/23.jpg"></div><div class="price">22$</div></td>
                <td class="product"><div> <img src="../images/product/24.jpg"></div><div class="price">3$</div></td>
                <td class="product"><div> <img src="../images/product/25.jpg"></div><div class="price">57$</div></td>
            </tr>
        </table>
    </div>
</div>
<div class="footer">
    <h2>Милости просим в нашем интернет магазине интересных подарков и хорошего настроения.</h2>
    <p><a href="http://localhost:8080">Магазин подарков для всех</a>.</p>
    <p>Мы как и вы по жизни проявляем большое внимание креативными предметам и прикольным дизайнерским вещицам, мы поднимаем настроение и заряжаем позитивом всех, кто находится рядом с нами. Мы продаем только то что купили бы сами!</p>
    <p><a href="http://localhost:8080">Интернет-магазин «Счастье»</a> – место в Минске и всей Беларуси, где всегда будут находиться самые классные вещи: дизайнерские изделия, модная одежда, аксессуары, украшения, предметы интерьера, уникальные а так же оригинальные подарки и товары для дома, – все неординарное с доставкой по всей Беларуси.</p>
    <p>У нас вы сможете отыскать все самые-самые крутые и прикольные подарки, которые не просто удобны и оригинальны в использовании но и созданы гениями промышленного дизайна из множества стран. Необычные подарки от Морковки - это удобство и функциональность: каждая деталь, каждая черта рассчитаны и расположены с максимальной продуманностью.</p>

    <h2><a href="http://localhost:8080">Интернет магазин Счастье</a>. Креативные подарки</h2>
    <p>Мы видим свою миссию в воодушевлении людей, делая их жизнь намного ярче, радостнее и удобнее.
        Мы продвигаем только креативные подарки. Мы предпочитаем работать только с лучшими мировыми дизайнерскими студиями, внимательно подбираем и сортируем в их разнообразии товаров всё самое новое, модное и крутое. Подарков жуть как много, и все эти «няшки» собраны в одном месте, чтобы вам было проще выбрать подходящий подарок.</p>
    <p>Наши преимущества:</p>
    <ol>
        <li>Необычные, дизайнерские, сумасшедшие подарки и аксессуары, подарки для любимых и дорогих;</li>
        <li>Высокое качество материалов и уникальность всего что предлагаем; удобный каталог забавных подарков;</li>
        <li>Доступные, рекомендованные производителями цены;</li>
        <li>Всего в одном клике от вас, нужные и стильные подарки и <a href="http://localhost:8080/category/predmety_interera">предметы интерьера</a>.</li>
    </ol>
    <p>«Счастье» – это сайт-витрина подарков с многообразным, уникальным и инновационным ассортиментом предметов от множества производителей. Мы предлагаем большое количество креативных идей, новых дизайнерских подарков и аксессуаров от самых успешных дизайн-студий со всего земного шара, а также оригинальные вещи молодых белорусских дизайнеров.</p>
    <p>Мы организовали все наши замечательные подарки в нескольких разделах и объединили их по тематикам.</p>
    <p><a href="http://localhost:8080/category/accessories">Аксессуары</a>, <a href="http://localhost:8080/category/ukrashenija">Украшения</a>, <a href="http://localhost:8080/category/predmety_interera">Предметы интерьера</a>, <a href="http://localhost:8080/category/stationery">Канцелярские штучки</a>, <a href="http://localhost:8080/category/kitchen">Для кухни</a>, <a href="http://localhost:8080/category/comfort">Уют и тепло</a>.</p>


    <h2>Подарки на день рождения</h2>
    <p>Не можете найти оригинальные подарки на день рождения друзьям и товарищам, любимым и родным?</p>
    <p>Загляните к нам. Новинки это кладезь, где вы сможете отыскать всё самое интересное и актуальное, необычные подарки и модные, оригинальные аксессуары на день рождения, потрясающие подарочные наборы, интерьерные штучки – заглядывайте к нам почаще и узнавайте первыми о всех новинках. Мы выбрали самое популярное, чтобы вам было легче подбирать нужное. Хиты продаж – это выбор людей которые привыкли получать максимум от жизни, чьими приоритетами являются стиль и комфорт, творческие идеи. Следите за <a href="http://localhost:8080/posts">нашими новостями</a>, заходите на наши странички в соцсетях и вы не пропустите новинки.</p>

    <h2>Подарки для любимых</h2>
    <p>Счастье приходит на помощь, если обычные подарки достали и глаза бегают в поисках новых открытий. На наших полках вы найдете все, от <a href="http://localhost:8080/category/accessories/Oblozhki">ярких обложек для автодокументов</a> до <a href="http://localhost:8080/category/stationery/bloknoty">загадочных блокнотов и ежедневников</a>, от <a href="http://localhost:8080/category/comfort">плюшевых игрушек</a> до <a href="http://localhost:8080/category/predmety_interera/polki">настенных полок</a> и <a href="http://localhost:8080/category/predmety_interera">предметов интерьера</a>. Здесь с легкостью найдете оригинальный подарок на любой день рождения, любимой девушке, необычный подарок любимому мужчине, полезный подарок маме, сувенир для коллеги по работе, или желанную вещицу для себя любимого.</p>

    <p>Каждый предмет, будь то подарок на юбилей или подарок другу или милая безделушка на стол в офис, прикольные подарки для мужчин или дизайнерские штучки, наделены некой энергией положительного настроения: доброй, созидательной, абсолютно позитивной. Такое же настроение они приносят в дом, где будут находиться после.</p>
</div>
</body>
</html>
