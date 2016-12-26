<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="off">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <title>${title}</title>
    <link href="${basePath}/statics/css/reset.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/statics/css/zh-cn-system.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/statics/css/dialog.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${basePath}/statics/css/style/zh-cn-styles1.css" title="styles1" media="screen" />
    <link rel="alternate stylesheet" type="text/css" href="${basePath}/statics/css/style/zh-cn-styles2.css" title="styles2" media="screen" />
    <link rel="alternate stylesheet" type="text/css" href="${basePath}/statics/css/style/zh-cn-styles3.css" title="styles3" media="screen" />
    <link rel="alternate stylesheet" type="text/css" href="${basePath}/statics/css/style/zh-cn-styles4.css" title="styles4" media="screen" />
    <script language="javascript" type="text/javascript" src="${basePath}/statics/js/jquery.min.js"></script>
    <script language="javascript" type="text/javascript" src="${basePath}/statics/js/styleswitch.js"></script>
    <script language="javascript" type="text/javascript" src="${basePath}/statics/js/dialog.js"></script>
    <script language="javascript" type="text/javascript" src="${basePath}/statics/js/hotkeys.js"></script>
    <script language="javascript" type="text/javascript" src="${basePath}/statics/js/jquery.sgallery.js"></script>
    <script type="text/javascript">

    </script>
    <style type="text/css">
        .objbody{overflow:hidden}
        .btns h6{padding:4px; border-bottom:1px solid #666; text-shadow: 0px 0px 2px #000;}
        .pd4 li{border-radius:0px 6spx 0px 6px; margin-top:2px; margin-bottom:3px; padding:2px 0px;}
        .btns .pd4 li span{padding:0px 6px;}

    </style>
</head>
<body scroll="no" class="objbody">

<div id="dvLockScreen" class="ScreenLock" style="display:none">
    <div id="dvLockScreenWin" class="inputpwd">
        <h5><b class="ico ico-info"></b><span id="lock_tips">锁屏状态，请输入密码解锁</span></h5>
        <div class="input">
            <label class="lb">密码：</label><input type="password" id="lock_password" class="input-text" size="24">
            <input type="submit" class="submit" value="&nbsp;" name="dosubmit" onclick="check_screenlock();return false;">
        </div></div>
</div>
<div class="header">
    <div class="logo lf"><a href="" target="_blank"><span class="invisible">xxxxxxxxxxxxx</span></a></div>
    <div class="rt-col">

        <div class="tab_style white cut_line text-r"></span><a href="" target="_blank">帮助？</a>
            <ul id="Skin">
                <li class="s1 styleswitch" rel="styles1"></li>
                <li class="s2 styleswitch" rel="styles2"></li>
                <li class="s3 styleswitch" rel="styles3"></li>
                <li class="s4 styleswitch" rel="styles4"></li>
            </ul>
        </div>
    </div>
    <div class="col-auto">
        <div class="log white cut_line">您好:[${admin.username!""}]<span>|</span><a href="/admin/logout.html">[退出]</a><span>|</span>
            <a href="http://jr.kongzhong.com" target="_blank" id="site_homepage">站点首页</a><span>|</span>
            <a href="http://www.baidu.com" target="_blank" id="site_search">搜索</a>
        </div>
        <ul class="nav white" id="top_menu">
            <#list topMenus as topM >
                <li id="_M${topM.id}" class="<#if topM.id == 1 > on top_menu <#else> top_menu  </#if>"><a href="javascript:_M(${topM.id},'${topM.resource}')" hidefocus="true" style="outline:none;">${topM.name}</a></li>
            </#list>
        </ul>
    </div>
</div>
<div id="content">
    <div class="col-left left_menu">
        <div id="Scroll">
            <div id="leftMain">


            </div>
        </div>
        <a href="javascript:;" id="openClose" style="outline-style: none; outline-color: invert; outline-width: medium;" hideFocus="hidefocus" class="open" title="展开与关闭"><span class="hidden">展开</span></a>
    </div>
    <div class="col-1 lf cat-menu" id="display_center_id" style="display: none" height="100%">
        <div class="content">
            <iframe name="center_frame" id="center_frame" src="" frameborder="false" scrolling="auto" style="border:none" width="100%" height="auto" allowtransparency="true">
            </iframe>
        </div>
    </div>
    <div class="col-auto mr8">
        <div class="crumbs">
            <div class="shortcut cu-span"><a href="?m=content&c=create_html&a=public_index&pc_hash=q9g99a" target="right"><span>生成首页</span></a><a href="?m=admin&c=cache_all&a=init&pc_hash=q9g99a" target="right"><span>更新缓存</span></a><a href="javascript:art.dialog({id:'map',iframe:'?m=admin&c=index&a=public_map', title:'后台地图', width:'700', height:'500', lock:true});void(0);"><span>后台地图</span></a></div>
            当前位置：<span id="current_pos"></span></div>
        <div class="col-1">
            <div class="content" style="position:relative; overflow:hidden">
                <iframe name="right" id="rightMain" src="/admin/main.html" frameborder="false" scrolling="auto" style="border:none; margin-bottom:30px" width="100%" height="auto" allowtransparency="true"></iframe>
                <div class="fav-nav">
                    <div id="panellist">
                    </div>
                    <div id="paneladd"></div>
                    <input type="hidden" id="menuid" value="">
                    <input type="hidden" id="bigid" value="" />
                    <div id="help" class="fav-help"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="scroll"><a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(1);"></a><a href="javascript:;" class="next" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a></div>



<script language="javascript" type="text/javascript">
    /**
     * Created by zhangmingnan on 15/12/29.
     */
    if(!Array.prototype.map)
        Array.prototype.map = function(fn,scope) {
            var result = [],ri = 0;
            for (var i = 0,n = this.length; i < n; i++){
                if(i in this){
                    result[ri++]  = fn.call(scope ,this[i],i,this);
                }
            }
            return result;
        };

    var getWindowSize = function(){
        return ["Height","Width"].map(function(name){
            return window["inner"+name] ||
                    document.compatMode === "CSS1Compat" && document.documentElement[ "client" + name ] || document.body[ "client" + name ]
        });
    };
    window.onload = function (){
        if(!+"\v1" && !document.querySelector) { // for IE6 IE7
            document.body.onresize = resize;
        } else {
            window.onresize = resize;
        }
        function resize() {
            wSize();
            return false;
        }
    };
    function wSize(){
        //这是一字符串
        var str=getWindowSize();
        var strs= []; //定义一数组
        strs=str.toString().split(","); //字符分割
        var heights = strs[0]-150,Body = $('body');$('#rightMain').height(heights);
        //iframe.height = strs[0]-46;
        if(strs[1]<980){
            $('.header').css('width',980+'px');
            $('#content').css('width',980+'px');
            Body.attr('scroll','');
            Body.removeClass('objbody');
        }else{
            $('.header').css('width','auto');
            $('#content').css('width','auto');
            Body.attr('scroll','no');
            Body.addClass('objbody');
        }

        var openClose = $("#rightMain").height()+39;
        $('#center_frame').height(openClose+9);
        $("#openClose").height(openClose+30);
        $("#Scroll").height(openClose-20);
        windowW();
    }
    wSize();
    function windowW(){
        if($('#Scroll').height()<$("#leftMain").height()){
            $(".scroll").show();
        }else{
            $(".scroll").hide();
        }
    }
    windowW();

    $(function(){


        //默认加载第一个菜单
        $("#leftMain").load("/admin/menu-left.html?pid=38");
        //面板切换
        $("#btnx").removeClass("btns2");
        $("#Site_model,#btnx h6").css("display","none");
        $("#btnx").hover(function(){$("#Site_model,#btnx h6").css("display","block");$(this).addClass("btns2");$(".bg_btn").hide();},function(){$("#Site_model,#btnx h6").css("display","none");$(this).removeClass("btns2");$(".bg_btn").show();});
        $("#Site_model li").hover(function(){$(this).toggleClass("hvs");},function(){$(this).toggleClass("hvs");});
        $("#Site_model li").click(function(){$("#Site_model li").removeClass("ac"); $(this).addClass("ac");});


    });

    function _M(menuid,targetUrl) {
        $("#menuid").val(menuid);
        $("#bigid").val(menuid);
        $("#paneladd").html('<a class="panel-add" href="javascript:add_panel();"><em>添加</em></a>');
        //$("#rightMain").attr('src', targetUrl);
        $("#leftMain").load("/admin/menu-left.html?pid="+menuid+"&random="+Math.random());
        $('.top_menu').removeClass("on");
        $('#_M'+menuid).addClass("on");



        $.get("/admin/currentPos?menuId="+menuid, function(result){

            $("#current_pos").html(result.data);
        });

        //当点击顶部菜单后，隐藏中间的框架
        $('#display_center_id').css('display','none');
        //显示左侧菜单，当点击顶部时，展开左侧
        $(".left_menu").removeClass("left_menu_on");
        $("#openClose").removeClass("close");
        $("html").removeClass("on");
    }

    function _MP(menuid,targetUrl) {

        $("#menuid").val(menuid);
        $('.sub_menu').removeClass("on fb blue");
        $('#_MP'+menuid).addClass("on fb blue");
        //打开新的右侧页面
        $("#rightMain").attr('src',targetUrl);
        //更新面包屑导航
        $.get("/admin/currentPos?menuId="+menuid, function(result){
            $("#current_pos").html(result.data+'<span id="current_pos_attr"></span>');
        });
        $("#current_pos").data('clicknum', 1);
    }


    //左侧开关
    $("#openClose").click(function(){
        if($(this).data('clicknum')==1) {
            $("html").removeClass("on");
            $(".left_menu").removeClass("left_menu_on");
            $(this).removeClass("close");
            $(this).data('clicknum', 0);
            $(".scroll").show();
        } else {
            $(".left_menu").addClass("left_menu_on");
            $(this).addClass("close");
            $("html").addClass("on");
            $(this).data('clicknum', 1);
            $(".scroll").hide();
        }
        return false;
    });

</script>
</body>
</html>