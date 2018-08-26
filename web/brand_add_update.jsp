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
                                <label for="brand_id" class="col-sm-2 col-form-label">品牌编号</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="编号" autocomplete="off"  id="brand_id" >
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="brand_name" class="col-sm-2 col-form-label">品牌名称</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="brand_name" placeholder="名称">
                                </div>
                            </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" id="btn_brand_add" class="btn btn-primary">添加</button>
                        <button type="button" id="btn_brand_add_close" class="btn btn-secondary" data-dismiss="modal">关闭</button>
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

               <input type="hidden"  id="b_id_hidden"  />

                <div class="form-group row">
                    <label for="brand_id_upd" class="col-sm-2 col-form-label">编号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="编号" autocomplete="off"  id="brand_id_upd" >
                    </div>
                </div>

                <div class="form-group row">
                    <label for="brand_name_upd" class="col-sm-2 col-form-label">名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="brand_name_upd" placeholder="名称">
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" id="btn_brand_upd" class="btn btn-primary">更新</button>
                <button type="button" id="btn_brand_upd_close" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>