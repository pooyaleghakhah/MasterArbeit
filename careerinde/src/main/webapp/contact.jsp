<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Careerinde – Kontakt</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Kontakt</h2>
        <form>
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">E-Mail</label>
                <input type="email" class="form-control" id="email">
            </div>
            <div class="mb-3">
                <label for="message" class="form-label">Nachricht</label>
                <textarea class="form-control" id="message" rows="4"></textarea>
            </div>
            <button type="submit" class="btn btn-success">Absenden</button>
        </form>
        <a href="index.jsp" class="btn btn-link mt-3">Zurück</a>
    </div>
</body>
</html>
