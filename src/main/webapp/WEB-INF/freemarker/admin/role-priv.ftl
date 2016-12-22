<@utils.body>
    <#include "/common/ui.link.tree.ftl" parse=true encoding="UTF-8">

<div class="table-list" id="load_priv">

<table width="100%" cellspacing="0">
    <thead>
    <tr>
        <th class="text-l cu-span" style='padding-left:30px;'><span onClick="javascript:checkAll(true)">全选</span>/<span onClick="javascript:checkAll(false)">取消</span></th>
    </tr>
    </thead>
</table>

<ul id="privTree" class="ztree"></ul>
<div class="btn"><input type="button"  class="button" value="提交" onclick="javascript:submitSetting()" /></div>
</div>
<script type="text/javascript">
    
    function checkAll(flag) {
        var zTree = $.fn.zTree.getZTreeObj("privTree");
        zTree.checkAllNodes(flag);
    }

    function submitSetting() {
        var zTree = $.fn.zTree.getZTreeObj("privTree");
        var nodes =  zTree.getCheckedNodes(true);

        var privList = "";
        for(var i=0;i<nodes.length;i++){
            privList = privList + nodes[i].id + ","
        }
        privList= privList.substring(0,privList.length-1);
        $.post('/admin/role/settingPriv?roleid=${roleid}&privList='+privList, function (data) {
            if(data.status == 0){
                window.location = window.location;
            }else{
                alert(data.msg);
            }
        },'json')
    }

    $(function () {
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            view: {
                selectedMulti: false
            },
            check: {
                enable: true
            }
        };
        $.get('/admin/role/privData?roleid=${roleid}', function (data) {
            $.fn.zTree.init($("#privTree"), setting, data);
        }, 'json')
    })
</script>
</@utils.body>