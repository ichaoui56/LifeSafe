<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/automobile.css">
</head>
<body>
<div class="demo-page">
    <main class="demo-page-content">
        <section>
            <div class="href-target" id="input-types"></div>
            <h1>
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                     stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                     class="feather feather-align-justify">
                    <line x1="21" y1="10" x2="3" y2="10"/>
                    <line x1="21" y1="6" x2="3" y2="6"/>
                    <line x1="21" y1="14" x2="3" y2="14"/>
                    <line x1="21" y1="18" x2="3" y2="18"/>
                </svg>
                Input types
            </h1>
            <p>All available input types are included</p>
            <form action="${pageContext.request.contextPath}/automobile/addInsurance" method="post">
                <div class="nice-form-group">
                    <label for="driverAge">Driver Age</label>
                    <input type="number" id="driverAge" name="driverAge" required/>
                </div>

                <div class="nice-form-group">
                    <label for="car">Select Car</label>
                    <select id="car" name="car.id" required>
                        <c:forEach var="car" items="${cars}">
                            <option value="${car.id}">${car.brand} ${car.model} (${car.type})</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="nice-form-group">
                    <label for="carUse">Car Use</label>
                    <input type="text" id="carUse" name="carUse" required/>
                </div>

                <div class="nice-form-group">
                    <label for="drivingHistory">Driving History</label>
                    <input type="text" id="drivingHistory" name="drivingHistory" required/>
                </div>

                <div class="nice-form-group">
                    <label for="sinisterTime">Last time u had an accident:</label>
                    <input type="date" id="sinisterTime" name="lastAccidentDate" required/>
                </div>

                <div class="nice-form-group">
                    <button type="submit">Submit Insurance</button>
                </div>
            </form>
        </section>
    </main>
</div>
</body>
</html>
