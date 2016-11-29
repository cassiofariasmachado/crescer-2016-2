
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="bulma.css">
    </head>
    <body>
        <div class="container">

            <div class="box">
                <form action="/aula4/pessoa" method="post">
                    <p class="control">
                        <label for="nome">Nome</label>
                        <input class="input is-success" type="text" name="nome" placeholder="Digite o nome...">
                    </p>

                    <p class="control">
                        <input id="botao-salvar" class="button is-primary is-left" type="submit" value="Salvar">
                    <p>
                </form>
            </div>

            <div class="box" id="lista-pessoas"></div>
        </div>
    </body>

    <script src="jquery-3.1.1.min.js"></script>
    <script src="pessoa.js"></script>
</html>
