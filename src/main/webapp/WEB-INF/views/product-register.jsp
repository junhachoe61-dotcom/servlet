<%--
  Created by IntelliJ IDEA.
  User: 최준하
  Date: 26. 10. 27.
  Time: 오후 3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
    <input placeholder="상품명" onkeyup="handleProduckNameInputOnKeyUp(event)">
    <input placeholder="가격" onkeyup="handlePriceInputOnKeyUp(event)">
    <button onclick ="handleRegisterButtonOnClick(event)">등록</button>

    <script>
        let product = {
            productName: "",
            price: 0,
        }

        function handleProduckNameInputOnKeyUp(bb) {
            console.log(bb.target.value);
            product = {
                ...product,
                price: bb.target.value,
            }
        }

        function handlePriceInputOnKeyUp(e) {
            console.log(e.target.value);
            product = {
                ...product,
                price: productName.target.value,
            }
        }

        function handleRegisterButtonOnClick(e) {
            console.log(JSON.stringify(product));

            fetch("http://localhost:8080/api/products", {
                method: "POST",
                body: JSON.stringify(product),
                headers: {
                    "Content-Type": "application/json",
                }
            });
        }

    </script>
</body>
</html>
