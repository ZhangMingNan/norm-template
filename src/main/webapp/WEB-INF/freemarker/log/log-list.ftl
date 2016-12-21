<@utils.body>
<link rel="stylesheet" type="text/css" href="${basePath}/statics/js/calendar/jscal2.css"/>
<link rel="stylesheet" type="text/css" href="${basePath}/statics/js/calendar/border-radius.css"/>
<link rel="stylesheet" type="text/css" href="${basePath}/statics/js/calendar/win2k.css"/>
<script type="text/javascript" src="${basePath}/statics/js/calendar/calendar.js"></script>
<script type="text/javascript" src="${basePath}/statics/js/calendar/lang/en.js"></script>
<div style="margin-top: 10px;"></div>

<div class="pad_10">
    <form action="/admin/log/list.html" method="get">
        <div class="explain-col search-form">
            调用时间
            <input type="text" name="sp_createTime_greaterThanEquals" id="start_uploadtime" value="${sp_createTime_greaterThanEquals!""}" size="10" class="date" readonly>&nbsp;
            <script type="text/javascript">
            Calendar.setup({
                weekNumbers: true,
                inputField : "start_uploadtime",
                trigger    : "start_uploadtime",
                dateFormat: "%Y-%m-%d",
                showTime: false,
                minuteStep: 1,
                onSelect   : function() {this.hide();}
            });
        </script>
            至
            <input type="text" name="sp_createTime_lessThanEqual" id="end_uploadtime" value="${sp_createTime_lessThanEqual!""}" size="10" class="date" readonly>&nbsp;
            <script type="text/javascript">
            Calendar.setup({
                weekNumbers: true,
                inputField : "end_uploadtime",
                trigger    : "end_uploadtime",
                dateFormat: "%Y-%m-%d",
                showTime: false,
                minuteStep: 1,
                onSelect   : function() {this.hide();}
            });
        </script>
            <input type="submit" value="搜索" class="button" name="dosubmit">
        </div>
    </form>

    <div class="table-list">
        <table width="100%" cellspacing="0">
            <thead>
            <tr>
                <th align="center">人员</th>
                <th align="center">操作</th>
                <th align="center">IP</th>
                <th align="center">调用方法</th>
                <th align="center">参数</th>
                <th align="center">调用时间</th>
            </tr>
            </thead>
            <tbody>
                <#list pageInfo.list as log>
                <tr>
                    <td align="center">${log.userid!}</td>
                    <td align="center">${log.operation!}</td>
                    <td align="center">${log.ip!}</td>
                    <td align="center">${log.method!}</td>
                    <td align="center">${log.params!}</td>
                    <td align="center">${log.createTime?string("YYYY-MM-dd hh:mm:ss")}</td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
    <#include "/common/ui.pagination.ftl">
</div>
<script type="application/javascript" >

</script>
</@utils.body>