$(function () {
  // 인원 선택하기
  $(".select-seat-ul").on("click", "li", function () {
    seatNum = $(this).text();
    var price;
    var ticketType;

    // 선택된 좌석 hover 넣기
    $(".select-seat-ul").children().removeClass("select-seat-ul-active");
    $(this).addClass("select-seat-ul-active");
    
    // 좌석 번호 지우기
    $(".selected-seats").text('선택한 좌석이 없습니다.');
    $('button').addClass("btn-outline-secondary");
    $('button').removeClass('btn-primary');

    // 좌석 수 넣기
    if ($(this).attr("class").match("select-number-normal")) {
      $(".reserve-number").text("일반 X " + seatNum);
      price = 11000 * seatNum;
      ticketType = "일반";
    } else if ($(this).attr("class").match("select-number-teen")) {
      $(".reserve-number").text("청소년 X " + seatNum);
      price = 9000 * seatNum;
      ticketType = "청소년";
    } else {
      $(".reserve-number").text("우대 X " + seatNum);
      price = 9000 * seatNum;
      ticketType = "우대";
    }
    
    // 인원, 티켓 타입, 결제금액 넘기기
    $(".ticketNumber").val(seatNum);
    $(".ticketType").val(ticketType);
    $(".payMoney").val(price);
    
    // 가격 넣기
    price = addComma(price);
    $(".ticket-price").text(price + "원");
  });

  $(".select-seat-wrapper").on("click", "button", function () {
	// 초기 input값, 선택된 좌석 값 받아오기
	var seatNum = $(".ticketNumber").val();
	var selectedNum = $(".btn-primary").length;

	// 선택하면 파란색
	$(this).removeClass("btn-outline-secondary");
    $(this).addClass("btn-primary");
    
    // 좌석 번호 받아오기
    var selectedRow;
    selectedRow =  $(this).parent('div').attr('class');
    var selectedSeat = selectedRow + " "+ $(this).text();
    var selectedList = $(".selected-seats").text();
    
    // 미리 선택한 좌석 있으면 그 뒤에 추가
	if(selectedList !== '선택한 좌석이 없습니다.') {
		if(selectedNum <= seatNum) {
			$(".selected-seats").text(selectedList + ", " + selectedSeat);
		}
	} else { // 처음 선택하는거면 그냥 추가
		$(".selected-seats").text(selectedSeat);
	}
	
	// 선택 좌석 넘기기
	$(".selectedSeat").val(selectedList);

    // 두 번 선택하면 선택 취소 / 안됨ㅅㅂㅅㅂㅅㅂㅅㅂㅅㅂㅅㅂㅅㅂㅅㅂㅅㅂㅅㅂㅅㅂ
    /*
    if($(this).hasClass(".btn-primary")){
    	$(this).removeClass('btn-primary');
		$(this).addClass("btn-outline-secondary");
		$(this).blur();
    }
    */
    
	// 인원 선택 전 좌석 선택 불가
	if(seatNum.length == 0 && seatNum == 0) {
		alert("인원을 먼저 선택해주세요");
		$(this).removeClass('btn-primary');
		$(this).addClass("btn-outline-secondary");
		$(this).blur();
		$(".selected-seats").text('선택한 좌석이 없습니다.');	
	}
	
	// 인원수만큼 좌석 선택 가능
	if(seatNum > 0 && selectedNum > seatNum) {
		alert("좌석을 모두 선택하셨습니다.");
		$(this).removeClass('btn-primary');
		$(this).addClass("btn-outline-secondary");
		$(this).blur();
	}
    
  });
});

// 천 단위 콤마
function addComma(value) {
  value = value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
  return value;
}

// 결제 api
function kakaopay(){
	$.ajax({
		url : "pay.ti",
		type : 'POST',
		data: {
			runNo: $('.runNo').val(), // runNo in SCHEDULE
			title : $('.title').val(), // mName in MOVIE
			ticketNumber : $('.ticketNumber').val(), // ticketNumber 
			payMoney : $('.payMoney').val() // payment in PAYMENT
		}
	}).done(function(result){
		if(result.status === 500){
			alert("카카오페이 결제를 실패했습니다.")
		} else { 

			var box = result;
			
			location.href = box;
			
			// 결제 성공하면 결제테이블에 값 넣기
			$.ajax({
				url : "insert.ti",
				type : 'POST',
				data: {
					memberNo : $('.memberNo').val(), // memberNo in MEMBER
					runNo: $('.runNo').val(), // runNo in SCHEDULE
					ticketType : $('.ticketType').val(),
					selectedSeat : $('.selectedSeat').val(), // seatNo in seat (,로 구분)
					payMoney : $('.payMoney').val() // payment in PAYMENT
				}, success : function(result){
					console.log(result);
				}, error: function(){
					alert("결제정보 저장에 실패했습니다.");
				}
			})
		}
	}).fail(function(error){
		window.open(JSON.stringify(error));
	})
}
