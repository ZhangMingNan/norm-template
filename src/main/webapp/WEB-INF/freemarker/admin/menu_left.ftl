
<#list menus as menu>
<h3 class="f14"><span class="switchs cu on" title="展开与收缩"></span>${menu.name}</h3>
<ul>
    <#list menu.subMenus as sub>
        <li id="_MP${sub.id}" class="sub_menu"><a href="javascript:_MP(${sub.id},'${sub.resource}');" hidefocus="true" style="outline:none;">${sub.name}</a></li>
    </#list>
</ul>
</#list>
<script type="text/javascript">
    $(".switchs").each(function(i){
        var ul = $(this).parent().next();
        $(this).click(
                function(){
                    if(ul.is(':visible')){
                        ul.hide();
                        $(this).removeClass('on');
                    }else{
                        ul.show();
                        $(this).addClass('on');
                    }
                })
    });
</script>
