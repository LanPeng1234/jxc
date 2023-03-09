let form;
form.on = function (login) {
    
}
form.on('submit.login'),function (data){
    data=data.field;
    if(data.username==="undefined"||data.username===""||data.username.trim()===""){
        layer.msg("用户不能为空！");
        return false;
    }
    if(data.password==="undefined"||data.password===""||data.password.trim()===""){
        layer.msg("密码器不能为空！");
        return false;
    }
    $.ajax({
        type:"post",
        url:ctx+"/login",
        data:{
            userName:data.username,
            password:data.password,
        },
        dataType:"json",
        success:function (data){
            if(data.code==200){
                layer.msg("登陆成功",function (){
                    window.location.href=ctx+"/main";
                })
            }else {
                layer.msg(data.message);
            }
        }
    });
    return false;
}