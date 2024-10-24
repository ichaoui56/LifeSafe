<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Health Devis Details</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/devis.css">
</head>
<body>

<div class="container">
  <h1>Health Insurance Devis Details</h1>

  <!-- Displaying the Devis details -->
  <div class="devis-details">
    <h2>Devis Information</h2>
    <p><strong>Devis ID:</strong> ${devis.id}</p>
    <p><strong>Request Date:</strong> ${devis.requestDate}</p>
    <p><strong>Calculated Quote:</strong> $${devis.calculatedQuote}</p>
    <p><strong>Status:</strong> ${devis.status}</p>
  </div>

  <!-- Displaying the health insurance details -->
  <div class="insurance-details">
    <h2>Health Insurance Information</h2>
    <p><strong>Age:</strong> ${devis.insurance.age}</p>
    <p><strong>Chronic Illness:</strong> ${devis.insurance.chronicIllness ? 'Yes' : 'No'}</p>
    <p><strong>Medical Coverage Type:</strong> ${devis.insurance.medicalCoverageType}</p>
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
