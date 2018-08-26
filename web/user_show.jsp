<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>管理员信息管理</title>
    <style>
    </style>
  </head>
  <body>

    <form action="/UserServlet" method="post">
        <table class="table table-hover" >
          <thead>
          <tr>
            <th scope="col"><input type="checkbox" id="cboBig" />多选</th>
            <th scope="col">登入账号</th>
            <th scope="col">用户名</th>
            <th scope="col">用户密码</th>
            <th scope="col">操作</th>
          </tr>
          </thead>
          <tbody id="tbody_user">
          </tbody>
        </table>

      <input style="margin-left:20px;" data-toggle="modal" data-target="#exampleModal_add" type="button" class="btn btn-secondary" value="添加管理" />
      <input style="margin-left:10px;" type="submit" class="btn btn-danger" value="批量删除" />

    </form>

    
    <%@include file="user_add_update.jsp"%>
    

  <script src="js_css/js/jquery-3.3.1.js" ></script>
  <script src="js_css/js/bootstrap.min.js"></script>
  <script>

      <!-- 修改点击事件 -->
      $("#btn_user_upd").click(function () {
          $.ajax({
              type:"get",
              url:"/UserServlet",
              data:{"action":"userUpd","u_id":$("#u_id").val(),"user_id":$("#user_id_upd").val(),"user_name":$("#user_name_upd").val(),"user_pwd":$("#user_pwd_upd").val()},
              success:function (data) {
                  alert(data.msg);
                  $("#btn_user_upd_close").trigger("click");
                  startQuery();  //数据重新渲染
              },
              error:function(XML,state,erro){
                  console.log(erro);
              }
          });
      });

      <!-- 添加点击事件 -->
      $("#btn_user_add").click(function () {
          $.ajax({
             type:"get" ,
              data:{"action":"add","user_id":$("#user_id").val(),"user_name":$("#user_name").val(),"user_pwd":$("#user_pwd").val()},
              url:"/UserServlet",
              success:function(data){
                  $("#btn_user_add_close").trigger("click");
                  alert(data.msg);
                 startQuery();
              },
              error:function(XML,state,erro){
                  console.log(erro);
              }
          });
      });



      $("#bntSearch").click(function(){
            startQuery();
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
              url:"/UserServlet",
              success:function(data){
                  //清空旧数据
                  $("#tbody_user tr").remove();
                  $.each(data,function(index,obj){  //数据渲染
                      var tr = $("<tr/>");
                      var cbo = $("<input type='checkbox' class='cbo' name='user_id' value='"+obj.u_id+"' />");
                      tr.append($("<td/>").prop("scope","row").append(cbo));
                      tr.append($("<td/>").text(obj.user_id));
                      tr.append($("<td/>").text(obj.user_name));
                      tr.append($("<td/>").text("******"));
                      var btnDel = $("<input type='button' style='margin-left:5px;' class='btn btn-danger userDel' id='"+obj.u_id+"' value='删除' />");
                      var btnUpd = $("<input type='button' data-toggle='modal' data-target='#exampleModal_upd' class='btn btn-secondary userUpd' id='"+obj.u_id+"' value='修改' />");
                      var td = $("<td/>");
                      td.append(btnUpd);
                      td.append(btnDel);
                      tr.append(td);
                      $("#tbody_user").append(tr);
                  });
              },
              error:function(XML,state,erro){
                  console.log(erro);
              }
          });
      };


      $(document).ready(function(){
          startQuery();//第一次加载渲染数据

          //动态修改点击事件绑定
          $("#tbody_user").on("click",".userUpd",function(){
              //获得id
              var u_id = $(this).prop("id");
              $.ajax({
                  type:"get",
                  data:{"action":"infoUser","u_id":u_id},
                  url:"/UserServlet",
                  success:function(data){
                         $("#u_id").val(data.u_id);
                         $("#user_id_upd").val(data.user_id);
                         $("#user_name_upd").val(data.user_name);
                         $("#user_pwd_upd").val(data.user_pwd);
                  },
                  error:function(XML,state,erro){
                      console.log(erro);
                  }
              });
          });

          //动态删除点击事件绑定
          $("#tbody_user").on("click",".userDel",function(){
              //获得id
              var u_id = $(this).prop("id");
              $.ajax({
                 type:"get",
                  data:{"action":"del","u_id":u_id},
                  url:"/UserServlet",
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
