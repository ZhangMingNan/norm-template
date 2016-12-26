<div id="pages">
    <a class="a1">${pageInfo.total}条</a>

    <#if !pageInfo.isFirstPage>
        <a  href="${requestURI}?f=1&pageRequest.pageNum=${pageInfo.prePage}&pageRequest.pageSize=${pageInfo.pageSize}${currentParams!""}" class="a1">上一页</a>
    </#if>

    <#list pageInfo.navigatepageNums as num>

    <#if pageInfo.pageNum == num>
        <span>${num}</span>
    <#else >
        <a href="${requestURI}?f=1&pageRequest.pageNum=${num}&pageRequest.pageSize=${pageInfo.pageSize}${currentParams!""}" >${num}</a>
    </#if>

    </#list>

<#if !pageInfo.isLastPage>
    <a href="${requestURI}?f=1&pageRequest.pageNum=${pageInfo.nextPage}&pageRequest.pageSize=${pageInfo.pageSize}${currentParams!""}" class="a1">下一页</a>
</#if>

</div>

