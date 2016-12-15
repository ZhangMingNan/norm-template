<@utils.body>
    <#include "/common/ui.link.validator.ftl">
<script type="text/javascript">
    $(function(){
        $.formValidator.initConfig({autotip:true,formid:"myform",onerror:function(msg){}});
        $("#rolename").formValidator({onshow:"请输入角色名称",onfocus:"角色名称不能为空。"}).inputValidator({min:1,max:999,onerror:"角色名称不能为空。"});
    })
</script>

<#--表格头部子导航-->
<div class="subnav">
    <div class="content-menu ib-a line-x">
        <a href="<#if subnav == 1>javascript:;<#else>/admin/role</#if>" class="<#if subnav == 1>on</#if>"><em>角色管理</em></a>
        <span>|</span>
        <a href="<#if subnav == 2>javascript:;<#else>/admin/role/add</#if>" class="<#if subnav == 2>on</#if>"><em>添加角色</em></a>
    </div>
</div>

    <div class="pad_10">
        <div class="common-form">
            <form name="myform" action="/admin/role/add" method="post" id="myform">
                <table width="100%" class="table_form contentWrap">
                    <tr>
                        <td>角色名称</td>
                        <td><input type="text" name="rolename" value="" class="input-text" id="rolename"></input></td>
                    </tr>
                    <tr>
                        <td>角色描述</td>
                        <td><textarea name="description" rows="2" cols="20" id="description" class="inputtext" style="height:100px;width:500px;"></textarea></td>
                    </tr>
                    <tr>
                        <td>是否启用</td>
                        <td><input type="radio" name="disabled" value="0" checked>启用<label><input type="radio" name="disabled" value="1" >禁止</td>
                    </tr>
                    <tr>
                        <td>排序</td>
                        <td><input type="text" name="listorder" size="3" value="0" class="input-text"></input></td>
                    </tr>
                </table>
                <div class="bk15"></div>
                <input name="dosubmit" type="submit" value="提交" class="button" id="dosubmit">
            </form>

        </div>
    </div>
</@utils.body>

