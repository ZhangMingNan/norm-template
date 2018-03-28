<@utils.body>

<#include "/common/ui.link.validator.ftl">

<script type="text/javascript">
    $(document).ready(function() {
        $.formValidator.initConfig({autotip:true,formid:"myform",onerror:function(msg){}});
        $("#password").formValidator({empty:true,onshow:"不修改密码请留空。",onfocus:"密码应该为6-20位之间"}).inputValidator({min:6,max:20,onerror:"密码应该为6-20位之间"});
        $("#pwdconfirm").formValidator({empty:true,onshow:"不修改密码请留空。",onfocus:"请输入两次密码不同。",oncorrect:"密码输入一致"}).compareValidator({desid:"password",operateor:"=",onerror:"请输入两次密码不同。"});
        $("#email").formValidator({onshow:"请输入E-mail",onfocus:"E-mail格式错误",oncorrect:"E-mail格式正确"}).regexValidator({regexp:"email",datatype:"enum",onerror:"E-mail格式错误"});
    })
</script>
<div class="subnav">
    <div class="content-menu ib-a blue line-x">
        <a href='/admin/manage/list.html?f=1' ><em>管理员管理</em></a>
        <span>|</span>
        <a href='javascript:;' class="on"><em>添加管理员</em></a>    </div>
</div>
<div class="pad_10">
    <div class="common-form">
        <form name="myform" action="/admin/manage/update" method="post" id="myform">
            <table width="100%" class="table_form contentWrap">
                <tr>
                    <td width="80">用户名</td>
                    <td><input type="text" name="username" id="username" class="input-text"></input></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="password" id="password" class="input-text"></input></td>
                </tr>
                <tr>
                    <td>确认密码</td>
                    <td><input type="password" name="pwdconfirm" id="pwdconfirm" class="input-text"></input></td>
                </tr>
                <tr>
                    <td>E-mail</td>
                    <td>
                        <input type="text" name="email" value="" class="input-text" id="email"
                               size="30"></input>
                    </td>
                </tr>

                <tr>
                    <td>真实姓名</td>
                    <td>
                        <input type="text" name="realname" value="" class="input-text"
                               id="realname"></input>
                    </td>
                </tr>
                <tr>
                    <td>所属角色 </td>
                    <td>
                        <#if roleList?size != 0>
                        <select name="roleid">

                                <#list  roleList as role >
                                    <option value="${role.roleid}"> ${role.rolename}</option>
                                </#list>
                        </select>
                        <#else>
                        没有可用的角色,请添加或者启用.
                        </#if>
                    </td>
                </tr>
            </table>

            <div class="bk15"></div>
    <#if roleList?size != 0>
            <input name="dosubmit" type="submit" value="提交" class="button" id="dosubmit">
    </#if>
        </form>
    </div>
</div>
</@utils.body>