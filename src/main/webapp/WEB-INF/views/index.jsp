<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h2>Simple Calculator</h2>
<form action="calculate" method="post">
    <input type="number" name="num1" step="any" required />
    <select name="operator">
        <option value="add">+</option>
        <option value="subtract">-</option>
        <option value="multiply">*</option>
        <option value="divide">/</option>
    </select>
    <input type="number" name="num2" step="any" required />
    <input type="submit" value="Calculate"/>
</form>

<c:if test="${not empty result}">
    <h3>Result: ${result}</h3>
</c:if>

<c:if test="${not empty message}">
    <h3 style="color:red;">${message}</h3>
</c:if>
</body>
</html>
