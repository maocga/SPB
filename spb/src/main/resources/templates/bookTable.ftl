<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Table</title>
</head>
<body>
    <h1>${t}</h1>
    <table border="1px" cellpadding="0px">
        <thead>
            <tr>
                <td>编号</td>
                <td>书名</td>
                <td>作者</td>
                <td>价格</td>
                <td>类别id</td>
            </tr>
        </thead>

        <tbody>
            <#list booklist as b>
                <tr>
                     <td>${b.bid}</td>
                     <td>${b.bname}</td>
                     <td>${b.author}</td>
                     <td>${b.price}</td>
                     <td>${b.cid}</td>
                </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>