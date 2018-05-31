<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>
<h3>Форма добавления фильма</h3>
<form  id="movieCreateForm" method="POST" action="/api/movies/">

  <label for="title">Название</label>
  <input id="title" name="title"><br>

  <label for="description">Описание</label>
  <input id="description" name="description"><br>


  <label for="director">Режисер</label>
  <input id="director" name="director"><br>

  <label for="durationMin">Длительность</label>
  <input id="durationMin" name="durationMin"><br>


  <button id="submitBtn">Создать</button>
  <button id="submitBtn2">Создать</button>
  <input type="submit"/>
</form>

<script type="application/javascript">
  $( document ).ready(function() {
    $('#movieCreateForm').submit(function () {
      var movie = {
          title: $("#title").val(),
          description: $("#description").val(),
          director: $("#director").val(),
          durationMin: $("#durationMin").val()
      };
      $.ajax({
          url: $(this).attr('action'),
          type: 'POST',
          data: JSON.stringify(movie),
          contentType: 'application/json',
          success: function (data) {
              alert('Movie created.')
          },
          error: function (jqXHR, textStatus, errorThrown) {
            alert('Error while creating movie.')
          }
      });
      return false
    });
  });
</script>
</body>
</html>
