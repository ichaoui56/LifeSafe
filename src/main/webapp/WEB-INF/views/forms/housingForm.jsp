<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Ajouter Assurance Habitation</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/automobile.css">
</head>
<body>
<div class="demo-page">
  <main class="demo-page-content">
    <section>
      <h1>Ajouter Assurance Habitation</h1>

      <form action="${pageContext.request.contextPath}/housing/addInsurance" method="post">
        <!-- Home Value -->
        <div class="nice-form-group">
          <label for="homeValue">Valeur du Logement (en €)</label>
          <input type="number" id="homeValue" name="homeValue" required/>
        </div>

        <!-- Type de logement -->
        <div class="nice-form-group">
          <label for="homeType">Type de Logement</label>
          <select id="homeType" name="homeType" required>
            <option value="Maison">Maison</option>
            <option value="Appartement">Appartement</option>
            <option value="Studio">Studio</option>
          </select>
        </div>

        <!-- Location -->
        <div class="nice-form-group">
          <label for="location">Emplacement</label>
          <input type="text" id="location" name="location" required/>
        </div>

        <!-- Système de sécurité -->
        <div class="nice-form-group">
          <label for="securitySystem">Système de Sécurité</label>
          <select id="securitySystem" name="securitySystem" required>
            <option value="Alarme">Alarme</option>
            <option value="Caméra">Caméra</option>
            <option value="Aucun">Aucun</option>
          </select>
        </div>

        <!-- Submit Button -->
        <div class="nice-form-group">
          <button type="submit">Soumettre l'Assurance</button>
        </div>
      </form>
    </section>
  </main>
</div>
</body>
</html>
