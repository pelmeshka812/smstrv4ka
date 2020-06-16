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
<#if user ??>
    ${user.name}
    <#if user.posts ??>
        <#list user.posts as post>
            <h1>${post.topic}<br></h1>
            <h3>${post.text}<br></h3>
        </#list>
    </#if>
</#if>
</body>
</html>