<@utils.body>
<#--表格头部子导航-->
<div class="subnav">
    <div class="content-menu ib-a line-x">
        <a href="<#if subnav == 1>javascript:;<#else>/admin/role</#if>" class="<#if subnav == 1>on</#if>"><em>角色管理</em></a>
        <span>|</span>
        <a href="<#if subnav == 2>javascript:;<#else>/admin/role/add</#if>"
           class="<#if subnav == 2>on</#if>"><em>添加角色</em></a>
    </div>
</div>
<form method="post" action="/admin/role/listorders" id="listOrderForm">
        <div class="pad_10">
            <div class="table-list">
                <table width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th align="center">排序</th>
                        <th align="center">ID</th>
                        <th align="center">角色名称</th>
                        <th align="center">角色描述</th>
                        <th align="center">状态</th>
                        <th align="center">管理操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list roleList as role>
                        <tr>
                            <td align="center">
                                <input name="listorders[${role_index}].listorder" type="text" size="3"
                                       value="${role.listorder!}" class="input-text-c input-text">
                                <input type="hidden" name="listorders[${role_index}].roleid" value="${role.roleid!}">
                            </td>
                            <td align="center">${role.roleid!}</td>
                            <td align="center">${role.rolename!}</td>
                            <td align="center">${role.description!}</td>
                            <td align="center">

                                <#if role.disabled == true >
                                    <a href="/admin/role/changeStatus?roleid=${role.roleid!}&disabled=false"> <font color="blue">×</font>
                                    </a>
                                <#elseif role.disabled == false >
                                    <a href="/admin/role/changeStatus?roleid=${role.roleid!}&disabled=true"><font color="red">√</font></a>
                                </#if>
                            </td>
                            <td class="text-c">
                                <#if role.roleid == 1>
                                    <font color="#cccccc">权限设置</font> |
                                    <font color="#cccccc">栏目权限</font> |
                                    <a href="/admin/manage?roleid=${role.roleid!}">成员管理</a> |
                                    <font color="#cccccc">修改</font> |
                                    <font color="#cccccc">删除</font>
                                <#else >
                                    <a href="javascript:do_setting_role(${role.roleid!},'${role.rolename!}')">权限设置</a> |
                                    <a href="javascript:void(0)" onclick="do_setting_cat_priv(4, '总编')">栏目权限</a> |
                                    <a href="/admin/manage?roleid=${role.roleid!}">成员管理</a> |
                                    <a href="javascript:do_edit_role(${role.roleid!},'${role.rolename!}')">修改</a> |
                                    <a href="javascript:;" onclick="do_delete(this,${role.roleid!})">删除</a>
                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>

            </div>
            <div class="btn">
                <input type="submit" class="button" value="排序">
            </div>
        </div>
</form>

<script type="text/javascript">

    function do_setting_cat_priv(){

    }
    function do_setting_role(id, name) {
        window.top.art.dialog({
            title: '设置[' + name + ']',
            id: 'edit',
            iframe: '/admin/role/priv?roleid=' + id,
            width: '700',
            height: '500'
        });
    }

    function do_delete(obj, id) {
        window.top.art.dialog({content: '确认删除吗？', fixed: true, style: 'confirm', id: 'att_delete'},
                function () {
                    $.getJSON('/admin/role/delete?roleid=' + id, function (data) {

                        if (data.status == 0) $(obj).parent().parent().fadeOut("slow");
                    })
                },
                function () {
                });
    }

    function do_edit_role(id, name) {
        window.top.art.dialog({
                    title: '修改角色[' + name + ']',
                    id: 'do_edit_role',
                    iframe: '/admin/role/edit?roleid=' + id,
                    width: '700',
                    height: '500'
                },
                function () {
                    var d = window.top.art.dialog({id: 'do_edit_role'}).data.iframe;
                    var form = d.document.getElementById('dosubmit');
                    form.click();
                    return false;
                },
                function () {
                    window.top.art.dialog({id: 'do_edit_role'}).close();
                });
    }
</script>
</@utils.body>







