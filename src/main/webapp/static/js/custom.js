//noinspection JSUnresolvedFunction
/**
 * Created by LiZhengxian on 2016/12/22 0022.
 */
$(document).ready(function(){
    websiteSetting.setActive();
});

var websiteSetting = {
    setActive: function () {
        var actionKey = window.location.pathname;
        $("#nav-ul li a").each(function () {
            var href = $(this).attr("href");
            //console.log(actionKey,href);
            if(href==actionKey){
                //console.log("添加active");
                $(this).parent().addClass("active");
            }else{
                //console.log("删除active");
                $(this).parent().removeClass("active");
            }
        });
    }
}

var crawlerJob = {
    buttonOnClick : function () {
        var url = $("#host_input").val();
        crawlerJob.startCrawlerJob(url);
    },
    startCrawlerJob : function (url) {
        var requestUrl = "/read?url=http://"+url;
        $.ajax({
            type : "GET",
            url : requestUrl,
            success : function(result) {
                console.log(result['success'],result['msg']);
                alert(result['msg']);
                if(result['success']){
                    window.location.reload();//刷新
                }
            },
            error : function (xhr,status,error) {
                
            }
        });
    }
}
