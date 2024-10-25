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
      <form action="${pageContext.request.contextPath}/health/addInsurance" method="post">
        <div class="nice-form-group">
          <label for="clientAge">Client Age</label>
          <input type="number" id="clientAge" name="age" required/>
        </div>

        <div class="nice-form-group">
          <label for="coverType">Cover Type</label>
          <select id="coverType" name="medicalCoverageType" required>
            <c:forEach var="coverType" items="${coverTypes}">
              <option value="${coverType}">${coverType}</option>
            </c:forEach>
          </select>
        </div>

        <div class="nice-form-group">
          <label for="healthState">Health State:</label>
          <select id="healthState" name="healthState" required>
            <option value="Excellent">Excellent</option>
            <option value="Good">Good</option>
            <option value="Fair">Fair</option>
            <option value="Poor">Poor</option>
          </select><br><br>
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
