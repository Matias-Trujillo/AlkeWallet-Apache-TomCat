<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="AlkeWallet.Wallet" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alke Wallet - Saldo</title>
</head>
<body>
    <h1>Saldo Disponible:</h1>
    <c:choose>
        <c:when test="${saldo == null}">
            <p>0 CLP</p>
        </c:when>
        <c:otherwise>
            <p>${saldo} CLP</p>
        </c:otherwise>
    </c:choose>

    <h2>Realizar Depósito</h2>
    <form action="WalletController?action=deposito" method="post">
        Monto a depositar: <input type="number" name="monto" required>
        <input type="submit" value="Depositar">
    </form>

    <h2>Realizar Retiro</h2>
    <form action="WalletController?action=retiro" method="post">
        Monto a retirar: <input type="number" name="monto" required>
        <input type="submit" value="Retirar">
    </form>

    <c:if test="${not empty mensaje}">
        <p>${mensaje}</p>
    </c:if>
</body>
</html>
