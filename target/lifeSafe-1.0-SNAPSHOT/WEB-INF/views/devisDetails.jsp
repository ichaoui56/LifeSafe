
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Devis Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/devis.css">
</head>
<body>

<div class="container">
    <h1>Devis Details</h1>

    <!-- Displaying the Devis details -->
    <div class="devis-details">
        <h2>Devis Information</h2>
        <p><strong>Devis ID:</strong> ${devis.id}</p>
        <p><strong>Request Date:</strong> ${devis.requestDate}</p>
        <p><strong>Calculated Quote:</strong> $${devis.calculatedQuote}</p>
        <p><strong>Status:</strong> ${devis.status}</p>
    </div>

    <!-- Displaying the insurance details -->
    <div class="insurance-details">
        <h2>Insurance Information</h2>
        <p><strong>Insurance Type:</strong> ${devis.insurance.type}</p>
        <p><strong>Car Model:</strong> ${devis.insurance.car.model}</p>
        <p><strong>Car Brand:</strong> ${devis.insurance.car.brand}</p>
        <p><strong>Car Use:</strong> ${devis.insurance.carUse}</p>
        <p><strong>Driver Age:</strong> ${devis.insurance.driverAge}</p>
        <p><strong>Driving History:</strong> ${devis.insurance.drivingHistory}</p>
        <p><strong>Last Accident Date:</strong> ${devis.insurance.lastAccidentDate}</p>
    </div>

    <!-- Accept or reject options -->
    <div class="action-buttons">
        <form action="${pageContext.request.contextPath}/devis/${devis.id}/accept" method="post">
            <button type="submit" class="accept-button">Accept</button>
        </form>

        <form action="${pageContext.request.contextPath}/devis/${devis.id}/reject" method="post">
            <button type="submit" class="reject-button">Reject</button>
        </form>
    </div>
</div>

</body>
</html>
