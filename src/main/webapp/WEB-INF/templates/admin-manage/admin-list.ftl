<@utils.body>

<#--表格头部子导航-->
<div class="subnav">
    <div class="content-menu ib-a line-x">
        <#if f == 1>
            <a href="javascript:;" class="on"><em>管理员管理</em></a>
        <#else >
            <a href="/admin/role"><em>角色管理</em></a>
        </#if>
        <span>|</span>
        <#if f == 1>
            <a href="/admin/manage/add"><em>添加管理员</em></a>
        <#else >
            <a href="/admin/role/add"><em>添加角色</em></a>
        </#if>

    </div>
</div>
<#--<@dict key="article_type.1" />-->

<div class="table-list pad-lr-10">
    <table width="100%" cellspacing="0">
        <thead>
        <tr>

            <th align="center">序号</th>
            <th align="center">用户名</th>
            <th align="center">所属角色</th>
            <th align="center">最后登录IP</th>
            <th align="center">最后登录时间</th>
            <th align="center">E-mail</th>
            <th align="center">真实姓名</th>
            <th align="center">管理操作</th>
        </tr>
        </thead>
        <tbody>
            <#list  pageInfo.list as admin >
            <tr>
                <td align="center">${admin.userid!}</td>
                <td align="center">${admin.username!}</td>
                <td align="center">${admin.roleid!}</td>
                <td align="center">
                    <#if admin.lastloginip??>
                    ${admin.lastloginip!}
                    <#else >
                        无
                    </#if>
                </td>
                <td align="center">
                <#if admin.lastlogintime??>
                    ${admin.lastlogintime?string("YYYY-MM-dd hh:mm:ss")}
                <#else >
                    无
                </#if>
                </td>
                <td align="center">${admin.email!}</td>
                <td align="center">${admin.realname!}</td>
                <td class="text-c">
                    <a href="javascript:do_edit(${admin.userid!})">修改</a>
                    <span>|</span>
                    <a href="javascript:;" onclick="do_delete(this,${admin.userid!})">删除</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
    <#include "/common/ui.pagination.ftl">
</div>



<script type="text/javascript">
    function do_edit(userid) {
        window.top.art.dialog({title:'修改',id:'edit', iframe:'/admin/manage/edit?userid='+userid,width:'500px',height:'400px'},function(){
                var d = window.top.art.dialog({id:'edit'}).data.iframe;
                var form = d.document.getElementById('dosubmit');form.click();return false;
        },function () {
                window.top.art.dialog({id:'edit'}).close();
        });
    }

    function do_delete(obj,id){
    	 window.top.art.dialog({content:'确认删除吗？', fixed:true, style:'confirm', id:'att_delete'},
    	function(){
            $.getJSON('/admin/manage/delete?userid='+id,function(data){
    				if(data.status == 0) $(obj).parent().parent().fadeOut("slow");
    			});
        },
    	function(){});
    };


</script>
</@utils.body>