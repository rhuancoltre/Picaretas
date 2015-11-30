<%@page import="br.grupointegrado.ads.picaretas.modelo.Produto"%>
<%@page import="br.grupointegrado.ads.picaretas.util.Util"%>
<%@page import="java.util.List"%>
<%@page import="br.grupointegrado.ads.picaretas.modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int categoria = 0;
    String descricao = "";
    String detalhes = "";
    String valor = "";
    
    String mensagemErro = (String) request.getAttribute("mensagem_erro");
    if (mensagemErro != null) {
        categoria = Integer.parseInt(request.getParameter("categoria"));
        descricao = request.getParameter("descricao");
        detalhes = request.getParameter("detalhes");
        valor = request.getParameter("valor");
    }
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Produto</title>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/logout.jsp"%>
        <h1>Produto</h1>
        <% if (mensagemErro != null) {%>
        <p class="erro"><%= mensagemErro%></p>
        <% }%>
        <form name="produto" action="Produto"  method="POST">
            <input type="hidden" name="id" value="" />
            <label>Categoria</label><br />
            <select name="categoria">
                <option value="0">(Selecione)</option>
                <%
                    if (categorias != null) {
                        for (Categoria c : categorias) {
                            if (c.getId() == categoria) {
                %>
                <option value="<%= c.getId()%>" selected><%= c.getDescricao()%></option>
                <%
                            } else {
                %>
                                <option value="<%= c.getId()%>" ><%= c.getDescricao()%></option>
                <%
                            }
                        }
                    }
                %>
            </select>
            <br /><br />
            <label>Descrição</label><br />
            <input type="text" name="descricao" value="<%= descricao%>" />
            <br /><br />
            <label>Detalhes</label><br />
            <textarea name="detalhes" rows="10" cols="50" ><%= detalhes%></textarea>
            <br /><br />
            <label>Valor</label><br />
            <input type="text" name="valor" value="<%= valor%>" />
            <br /><br />
            <input type="submit" value="Publicar" />
        </form>
    </body>
</html>
