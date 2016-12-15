<div id="pages">
    <a class="a1">${pageInfo.total}条</a>

    <#if !pageInfo.isFirstPage>
        <a  href="${requestURI}?f=1&pageNum=${pageInfo.prePage}&pageSize=${pageInfo.pageSize}" class="a1">上一页</a>
    </#if>

    <#list pageInfo.navigatepageNums as num>

    <#if pageInfo.pageNum == num>
        <span>${num}</span>
    <#else >
        <a href="${requestURI}?f=1&pageNum=${num}&pageSize=${pageInfo.pageSize}" >${num}</a>
    </#if>

    </#list>

<#if !pageInfo.isLastPage>
    <a href="${requestURI}?f=1&pageNum=${pageInfo.nextPage}&pageSize=${pageInfo.pageSize}" class="a1">下一页</a>
</#if>

</div>

