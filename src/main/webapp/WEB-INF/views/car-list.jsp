<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>차량 목록</title>
    <style>
        table {
            border: 1px solid #222;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #222;
            text-align: center;
            width: 300px;
            height: 50px;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>번호</th>
        <th>차이름</th>
        <th>가격</th>
        <th>브랜드</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>



<script>
        async function getCarList() {
        const response = await fetch("http://localhost:8080/api/car");
        const cars = await response.json();
        const tbody = document.querySelector("tbody");

        tbody.innerHTML = cars.map(car =>
        "<tr>" +
        "<td>" + car.id + "</td>" +
        "<td>" + car.name + "</td>" +
        "<td>" + car.price + "</td>" +
        "<td>" + car.brand + "</td>" +
        "</tr>"
        ).join("");
    }

        getCarList();

</script>
</body>
</html>
