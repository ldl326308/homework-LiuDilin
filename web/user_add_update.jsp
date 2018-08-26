<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 添加弹框 -->
<div class="modal fade" id="exampleModal_add" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">添加管理</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                            <div class="form-group row">
                                <label for="user_id" class="col-sm-2 col-form-label">账号</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="账号" autocomplete="off"  id="user_id" >
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="user_name" class="col-sm-2 col-form-label">呢称</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="user_name" placeholder="昵称">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="user_pwd" class="col-sm-2 col-form-label">密码</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="user_pwd" placeholder="密码">
                                </div>
                            </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" id="btn_user_add" class="btn btn-primary">添加</button>
                        <button type="button" id="btn_user_add_close" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                    </div>

        </div>
    </div>
</div>

<!-- 修改弹框 -->
<div class="modal fade" id="exampleModal_upd" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel_upd" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel_upd">信息更新</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

               <input type="hidden"  id="u_id"  />

                <div class="form-group row">
                    <label for="user_id_upd" class="col-sm-2 col-form-label">账号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="账号" autocomplete="off"  id="user_id_upd" >
                    </div>
                </div>

                <div class="form-group row">
                    <label for="user_name_upd" class="col-sm-2 col-form-label">呢称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="user_name_upd" placeholder="昵称">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="user_pwd_upd" class="col-sm-2 col-form-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="user_pwd_upd" placeholder="密码">
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" id="btn_user_upd" class="btn btn-primary">更新</button>
                <button type="button" id="btn_user_upd_close" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>