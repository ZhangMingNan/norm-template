<@utils.body>

<div class="subnav">
    <div class="content-menu ib-a line-x">
        <a href="javascript:;" class="on"><em>子页面1</em></a>
        <span>|</span>
        <a href="javascript:;" class="on"><em>子页面2</em></a>
    </div>
</div>
<div class="pad-lr-10">

    <form action="/admin/dict/list.html" method="get">
        <div class="explain-col search-form">
            类型
            <input type="text" name="sp_type_greaterThanEquals" value="${sp_type_greaterThanEquals!""}"
                   class="input-text">
            <input type="submit" value="搜索" class="button" name="dosubmit">
        </div>
    </form>
    <div class="table-list">
        <table width="100%" cellspacing="0">
            <thead>
            <tr>
                <th align="center">编号</th>
                <th align="center">类型</th>
                <th align="center">标签名</th>
                <th align="center">数据值</th>
                <th align="center">备注信息</th>
                <th align="center">排序</th>
            </tr>
            </thead>
            <tbody>
                <#list pageInfo.list as dict>
                <tr>
                    <td align="center">${dict.id!}</td>
                    <td align="center">${dict.type!}</td>
                    <td align="center">${dict.label!}</td>
                    <td align="center">${dict.value!}</td>
                    <td align="center">${dict.remarks!}</td>
                    <td align="center">${dict.sort!}</td>

                </tr>
                </#list>
            </tbody>
        </table>
    </div>
    <#include "/common/ui.pagination.ftl">
</div>
</@utils.body>