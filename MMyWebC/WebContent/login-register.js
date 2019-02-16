function showRegisterForm(){
    $('.loginBox').fadeOut('fast',function(){
        $('.registerBox').fadeIn('fast');
        $('.login-footer').fadeOut('fast',function(){
            $('.register-footer').fadeIn('fast');
        });
        $('.modal-title').html('注册');
    }); 
    $('.error').removeClass('alert alert-danger').html('');
       
}
function showLoginForm(){
    $('#loginModal .registerBox').fadeOut('fast',function(){
        $('.loginBox').fadeIn('fast');
        $('.register-footer').fadeOut('fast',function(){
            $('.login-footer').fadeIn('fast');    
        });
        
        $('.modal-title').html('登录');
    });       
     $('.error').removeClass('alert alert-danger').html(''); 
}

function openLoginModal(){
    showLoginForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}
function openRegisterModal(){
    showRegisterForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}

function loginAjax(){
    //想服务器发送请求并接收返回的数据
	$.ajax({
        url:"CheckLogin",
        type:"post",
        data:$('#loginf').serialize(),
        success:function(data){
            //success请求成功时执行的方法，这data是服务器返回的数据
        	if (data==1) {
				alert("登录成功");
				//进入主页
				window.location.replace("showStudent")
			}else {
				shakeModal();
			}
        },
        error:function(e){
            //请求失败时执行的方法
        }
    }); 	
}

function registerAjax(){
	//想服务器发送请求并接收返回的数据
	$.ajax({
        url:"registerAction",
        type:"post",
        data:$('#registerf').serialize(),
        success:function(data){
            //success请求成功时执行的方法，这data是服务器返回的数据
        	if (data==1) {
				alert("注册成功");
				//显示登录窗口
				showLoginForm();
			}else if(data==2){
				alert("两次密码不相同请重新输入")
			}else if(data==3){
				alert("用户名已存在");
			}else if(data==4){
				alert("用户名和密码不能为空");
			}
        },
        error:function(e){
            //请求失败时执行的方法
        }
    }); 		
}

function shakeModal(){
    $('#loginModal .modal-dialog').addClass('shake');
             $('.error').addClass('alert alert-danger').html("账号或密码无效");
             $('input[type="password"]').val('');
             setTimeout( function(){ 
                $('#loginModal .modal-dialog').removeClass('shake'); 
    }, 1000 ); 
}

   