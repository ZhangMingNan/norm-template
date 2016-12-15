<@utils.body>
    <#include "/common/ui.link.validator.ftl">
<script type="text/javascript">
    $(function(){
        $.formValidator.initConfig({autotip:true,formid:"myform",onerror:function(msg){}});
        $("#rolename").formValidator({onshow:"请输入角色名称",onfocus:"角色名称不能为空。"}).inputValidator({min:1,max:999,onerror:"角色名称不能为空。"});
    })
</script>

<div class="pad_10">
    <div class="common-form">
        <form name="myform" action="/admin/role/edit" method="post" id="myform">
            <input type="hidden" name="roleid" value="${role.roleid}"></input>
            <table width="100%" class="table_form contentWrap">
                <tr>
                    <td>角色名称</td>
                    <td><input type="text" name="rolename" value="${role.rolename}" class="input-text" id="rolename"></input></td>
                </tr>
                <tr>
                    <td>角色描述</td>
                    <td><textarea name="description" rows="2" cols="20" id="description" class="inputtext" style="height:100px;width:500px;">${role.description}</textarea></td>
                </tr>
                <tr>
                    <td>是否启用</td>
                    <td><input type="radio" name="disabled" value="0"  checked> 启用  <label><input type="radio" name="disabled" value="1" >禁止</td>
                </tr>
                <tr>
                    <td>排序</td>
                    <td><input type="text" name="listorder" size="3" value="${role.listorder}" class="input-text"></input></td>
                </tr>
            </table>

            <div class="bk15"></div>
            <input name="dosubmit" type="submit" value="提交" class="dialog" id="dosubmit">
        </form>


    </div>
</div>
</@utils.body>