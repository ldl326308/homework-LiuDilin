<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机品牌</title>
</head>
<body>

<form action="/BrandServlet" method="post">
    <table class="table table-hover" >
        <thead>
        <tr>
            <th scope="col"><input type="checkbox" id="cboBig" />多选</th>
            <th scope="col">序号</th>
            <th scope="col">品牌编号</th>
            <th scope="col">品牌名称</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody id="tbody_brand">
        </tbody>
    </table>

    <input style="margin-left:20px;" data-toggle="modal" data-target="#exampleModal_add" type="button" class="btn btn-secondary" value="添加品牌" />
    <input style="margin-left:10px;" type="submit" class="btn btn-danger" value="批量删除" />

</form>


<%@include file="brand_add_update.jsp"%>


<script src="js_css/js/jquery-3.3.1.js" ></script>
<script src="js_css/js/bootstrap.min.js"></script>
<script>

    <!-- 添加点击事件 -->
    $("#btn_brand_add").click(function () {
        $.ajax({
            type:"get" ,
            data:{"action":"add","brand_name":$("#brand_name").val(),"brand_id":$("#brand_id").val()},
            url:"/BrandServlet",
            success:function(data){
                $("#btn_brand_add_close").trigger("click");
                alert(data.msg);
                startQuery();
            },
            error:function(XML,state,erro){
                console.log(erro);
            }
        });
    });


    <!-- 修改点击事件 -->
    $("#btn_brand_upd").click(function () {
        $.ajax({
            type:"get",
            url:"/BrandServlet",
            data:{"action":"brandUpd","b_id":$("#b_id_hidden").val(),"brand_id":$("#brand_id_upd").val(),"brand_name":$("#brand_name_upd").val()},
            success:function (data) {
                alert(data.msg);
                $("#btn_brand_upd_close").trigger("click");
                startQuery();  //数据重新渲染
            },
            error:function(XML,state,erro){
                console.log(erro);
            }
        });
    });


    //查询显示的数据方法
    function startQuery(){
        var term =$("#Txt-trem").val();
        if(term==""){
            var term = "term";
        }

        $.ajax({
            type:"get",
            data:{"action":"query","term":term},
            url:"/BrandServlet",
            success:function(data){
                //清空旧数据
                $("#tbody_brand tr").remove();
                $.each(data,function(index,obj){  //数据渲染
                    var tr = $("<tr/>");
                    var cbo = $("<input type='checkbox' class='cbo' name='b_id' value='"+obj.b_id+"' />");
                    tr.append($("<td/>").prop("scope","row").append(cbo));
                    tr.append($("<td/>").text((index+1)));
                    tr.append($("<td/>").text(obj.brand_id));
                    tr.append($("<td/>").text(obj.brand_name));
                    var btnDel = $("<input type='button' style='margin-left:5px;' class='btn btn-danger brandDel' id='"+obj.b_id+"' value='删除' />");
                    var btnUpd = $("<input type='button' data-toggle='modal' data-target='#exampleModal_upd' class='btn btn-secondary brandUpd' id='"+obj.b_id+"' value='修改' />");
                    var td = $("<td/>");
                    td.append(btnUpd);
                    td.append(btnDel);
                    tr.append(td);
                    $("#tbody_brand").append(tr);
                });
            },
            error:function(XML,state,erro){
                console.log(erro);
            }
        });
    };


    $(document).ready(function() {
        startQuery();//第一次加载渲染数据

        //动态修改点击事件绑定
        $("#tbody_brand").on("click", ".brandUpd", function () {
            //获得id
            var b_id = $(this).prop("id");
            $.ajax({
                type: "get",
                data: {"action": "infoBrand", "b_id": b_id},
                url: "/BrandServlet",
                success: function (data) {
                    $("#b_id_hidden").val(data.b_id);
                    $("#brand_id_upd").val(data.brand_id);
                    $("#brand_name_upd").val(data.brand_name);
                },
                error: function (XML, state, erro) {
                    console.log(erro);
                }
            });
        });

        //动态删除点击事件绑定
        $("#tbody_brand").on("click",".brandDel",function(){
            //获得id
            var b_id = $(this).prop("id");
            console.log(b_id);
            $.ajax({
                type:"get",
                data:{"action":"del","b_id":b_id},
                url:"/BrandServlet",
                success:function(data){
                    alert(data.msg);
                    //重新渲染数据
                    startQuery();
                },
                error:function(XML,state,erro){
                    console.log(erro);
                }
            });
        });


    });



</script>
<script>
    <!-- 添加弹框 -->
    $('#exampleModal_add').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) ;
        var recipient = button.data('whatever') ;
        var modal = $(this);
        //modal.find('.modal-title').text('New message to ' + recipient);
        modal.find('.modal-body input').val(recipient);
    });


    <!-- 添加弹框 -->
    $('#exampleModal_upd').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) ;
        var recipient = button.data('whatever') ;
        var modal = $(this);
        //modal.find('.modal-title').text('New message to ' + recipient);
        modal.find('.modal-body input').val(recipient);
    });

</script>
</body>
</html>
