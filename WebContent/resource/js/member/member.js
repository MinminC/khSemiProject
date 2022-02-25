$(function(){
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
	};
	
	
		// 중복 체크 했는지 여부 중복체크하면 id 입력란 잠금 했으면 1 안했으면 0
		var idResult = 0;
		// 이메일 인증 했는지 여부 안했으면 0 했으면 1
		var emailResult = 0;
		// 이메일 인증번호
		var emailCertification;
		
		var updateEmailCheck = 1;
		
		//아이디 포거스 이벤트 
		$('#memberId').focusout(function(){
			if(idResult == 0){
				//영문 대.소문자, 숫자 _,-만 입력 가능하고 5에서 20자리
				var memberIdCheck = RegExp(/^[A-Za-z0-9_\-]{5,20}$/);
				
				if(!(memberIdCheck.test($('#memberId').val()))){
					$('#memberId').val('');
					
				}else{
					$('.id_text').text('중복체크 해주세요');
					$('.id_text').css('color', 'rgb(13, 71, 161)');
				}
			}
		})
		
		//비밀번호 포커스 이벤트
		$('#memberPwd').focusout(function(){
			// 영문 대문자와 소문자, 숫자, 특수문자를 하나 이상 포함하여 8~16
			var memberPwdCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\'",.<>\/?]).{8,16}$/);
			
			if(!(memberPwdCheck.test($('#memberPwd').val()))){
				$('#memberPwd').val('');
			}
		})
		
		//비밀번호 확인 포거스 이벤트 
		$('#pwdCheck').focusout(function(){
			if(!($('#pwdCheck').val() == $("#memberPwd").val())){
				$('#pwdCheck').val('');
			}
		})
		
		
		//이름 확인 이벤트
		$('#memberName').focusout(function(){
			
			// 2~6자 한글만 가능
			var nameCheck = RegExp(/^[가-힣]{2,6}$/);
			if(!(nameCheck.test($('#memberName').val()))){
				$('#memberName').val('');
			}
			
		})
		
		//이메일 확인 인벤트
		$('#email').focusout(function(){
			if(emailResult == 0 ){
				// 이메일 형식 체크
				var emailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
				if(!(emailCheck.test($('#email').val()))){
					$('#email').val('');
				}else{
					$('.email_text').text('');
				}
			}
		})
		
		//전화번호 확인 이벤트
		$('#phone').focusout(function(){
			//숫자만 입력 가능
			var phoneCheck = RegExp(/^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/);

			if(!(phoneCheck.test($('#phone').val()))){
				$('#phone').val('');
				
			}
		})
		//생년월일 중 생년 확인 이벤트
		$('#yyyy').focusout(function(){
			
			// 1900~ 2019까지 
			var yyyyCheck = RegExp(/^(19([0-9]{2}))|(20([0-1]{1}[0-9]{1}))$/);

			if(!(yyyyCheck.test($('#yyyy').val()))){
				$('#yyyy').val('');
			}
		})
		
		// 생년월일 중 일자 확인 이벤트
		$('#dd').focusout(function(){
			// 날짜 01~31 까지만 가능
			var ddCheck = RegExp(/^0[1-9]|[1-2][0-9]|3[0-1]$/);
			if(!(ddCheck.test($('#dd').val()))){
				$('#dd').val('');
			}
		})
		
		// 아이디 중복 체크 이벤트
		$('#idCheck').on('click', function(){
			if($('#memberId').val() == null || $('#memberId').val() == ""){
				$('.id_text').text('아이디를 입력해 주세요.');
				$('.id_text').css('color', 'red');
			}else{
				// 중복확인 AJAX
				$.ajax({
					url : getContextPath()+"/idCheck.me",
					data : { memberId : $('#memberId').val()},
					type : "post",
					success : function(result){
						
						if(result == 1){
							$('.id_text').text('중복된 아이디 입니다.');
							$('.id_text').css('color', 'red');
						}else{
							$('.id_text').text('사용 가능 한 아이디 입니다.');
							$('.id_text').css('color', 'rgb(13, 71, 161)');
							$('#memberId').attr('readonly', true);
							idResult = 1;
						}
						
					},
					error : function(){
						console.log('중복확인 실패');
					}
				})
			}
		})
		
		//이메일 인증 이벤트
		$('#emailCheck').on('click', function(){
			if($('#email').val() == null || $('#email').val() == ""){
				$('.email_text').text('이메일을 입력해 주세요.');
				$('.email_text').css('color', 'red');
			}else{
				// 중복확인 AJAX 및 인증번호 발급 후 이메일 전송
				$.ajax({
					url : getContextPath()+"/emailAuth.me",
					data : { email : $('#email').val()},
					type : "post",
					success : function(result){
						if(result.check == 1){
							$('.email_text').text('사용 할 수 없는 이메일 입니다.');
							$('.email_text').css('color', 'red');
						}else{
							alert('이메일 인증번호가 해당 이메일로 전송 되었습니다.')
							$('.email_certification_text').text('인증번호를 입력해주세요.');
							$('.email_certification_text').css('color', 'rgb(13, 71, 161)');
							emailCertification = result.authNumber;
							console.log(emailCertification);
						}
					},
					error : function(){
						console.log('인증 번호 발송 실패');
					}
				})
			}
		})
		
		
		//이메일 수정시 인증 이벤트
		$('#emailReCheck').on('click', function(){
			updateEmailCheck = 0;
			if($('#email').val() == $('#beforeEmail').val()){
				alert('같은 이메일 입니다.');
				emailCertification = 1;
			}else{
				emailCertification = 0;
				if($('#email').val() == null || $('#email').val() == ""){
					$('.email_text').text('이메일을 입력해 주세요.');
					$('.email_text').css('color', 'red');
				}else{
					// 중복확인 AJAX 및 인증번호 발급 후 이메일 전송
					$.ajax({
						url : getContextPath()+"/emailAuth.me",
						data : { email : $('#email').val()},
						type : "post",
						success : function(result){
							if(result.check == 1){
								$('.email_text').text('사용 할 수 없는 이메일 입니다.');
								$('.email_text').css('color', 'red');
							}else{
								alert('이메일 인증번호가 해당 이메일로 전송 되었습니다.')
								$('.email_certification_text').text('인증번호를 입력해주세요.');
								$('.email_certification_text').css('color', 'rgb(13, 71, 161)');
								emailCertification = result.authNumber;
								console.log(emailCertification);
							}
						},
						error : function(){
							console.log('인증 번호 발송 실패');
						}
					})
				}
			}
			
			
		})
		
		// 이메일에 발송 된 인증 번호 일치 확인 이벤트
		$('#CheckBtn').on('click', function(){
			if(emailCertification == $('#email_check').val()){
				$('.email_certification_text').text('인증이 완료 되었습니다.');
				$('.email_certification_text').css('color', 'rgb(13, 71, 161)');
				$('#email').attr('readonly', true);
				emailResult = 1;
			}else{
				$('.email_certification_text').text('인증번호가 일치 하지 않습니다.');
				$('.email_certification_text').css('color', 'red');
			}
		})
		
		$('#emailChange').on('click', function(){
			$('.button_hidden').css('display', 'block');
			$('.remove').empty();
			emailCertification = 0;
		})
		
		
		$('.update_btn').on('click', function(){
			if(updateEmailCheck == 0){
				// 이메일 인증 확인
				if(emailResult != 1){
					alert('이메일 인증 해주세요.');
					return false;
				}
			}

			
			if($('#mm').val() == 0){
				alert('월을 선택 해주세요.');
				return false;
			}
			if($('#gender').val() == 0){
				alert('성별을 선택 해주세요.')
				return false;
			}
			if($('#memberPwd2').val() != null){
				//비밀번호 포커스 이벤트
				$('#memberPwd2').focusout(function(){
					// 영문 대문자와 소문자, 숫자, 특수문자를 하나 이상 포함하여 8~16
					var memberPwdCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\'",.<>\/?]).{8,16}$/);
					
					if(!(memberPwdCheck.test($('#memberPwd2').val()))){
						$('#memberPwd2').val('');
						return false;
					}
				})
				
				//비밀번호 확인 포거스 이벤트 
				$('#pwdCheck1').focusout(function(){
					if(!($('#pwdCheck2').val() == $("#memberPwd2").val())){
						$('#pwdCheck2').val('');
						return false;
					}
				})
			}
				
		})
		
		
		// submit 버튼 클릭시 이벤트 
		$('.insert_btn').on('click',function(){
			//아이디 중복 체크 확인 
			if(idResult != 1){
				alert('아이디 중복 체크 해주세요.');
				return false;
			}
			// 이메일 인증 확인
			if(emailResult != 1){
				alert('이메일 인증 해주세요.');
				return false;
			}
			// 생년월일 중 월 선택 했는지 여부 확인
			if($('#mm').val() == 0){
				alert('월을 선택 해주세요.');
				return false;
			}
			//성별 선택 여부 확인
			if($('#gender').val() == 0){
				alert('성별을 선택 해주세요.')
				return false;
			}
			return true;
		})
		
		
})