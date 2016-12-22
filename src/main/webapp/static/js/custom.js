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
