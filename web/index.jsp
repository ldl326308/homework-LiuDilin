<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TITLE</title>
</head>
<body>
<h1 style="color: green;text-align: center;font-family: 新宋体;font-size: 24px;">每个故事都会有结局，只是有人欢喜有人愁。</h1>

<marquee behavior="behavior" style="font-size: 34px;color:orange;" direction="right">每个故事都会有结局</marquee>
<marquee behavior="behavior" style="font-size: 34px;color:orange;" direction="left">只是有人欢喜有人愁</marquee>
<marquee behavior="behavior" style="font-size: 34px;color:orange;" direction="right">在我的世界里</marquee>
<marquee behavior="behavior" style="font-size: 34px;color:orange;" direction="left">在你的世界里</marquee>
<marquee behavior="behavior" style="font-size: 34px;color:orange;" direction="right">路过你的世界</marquee>
<marquee behavior="behavior" style="font-size: 34px;color:orange;" direction="left">Deep Love</marquee>

<input type="checkbox" value="篮球">篮球
<input type="checkbox" value="足球">足球
<input type="checkbox" value="羽毛球">羽毛球
<input type="checkbox" value="排球">排球
<input type="checkbox" value="气球">气球
<input type="button" id="btn" value="点击" />
<script src="js_css/js/jquery-3.3.1.js"></script>
<script>
    $("#btn").click(function () {
        var checkList=[];
        $("input[type=checkbox]:checked").each(function(index,obj){
            checkList.push($(obj).val());
        });
        console.log(checkList.join("/"));
    });

</script>
</body>
</html>
</body>
</html>
