<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<#if user??>
    ${user.email}<br>
    ${user.createdAt}<br>
    ${user.role} <br>
    <a href="/add_post"  > ADDD POSTTTTT</a>
    <#if user.posts??>
    <#list user.posts as post>
        <h5>Topic </h5>
        ${post.topic}<br>
        <h5>Text </h5>
        ${post.text}<br>
        <form action="/delete_post" method="post">
            <input type="hidden" value="${post.id}" name="id">
            <input type="submit" value="delete post">
        </form>
    </#list>
    </#if>
    <#else>
    USer not found
</#if>
</body>
</html>