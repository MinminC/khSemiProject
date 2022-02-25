$(function () {
  addDate();
  // 영화 클릭하면 상영 극장 띄우기
  $(".movie-list").click(function () {
    // 영화 이름 뽑기
    $mName = $(this).children().eq(1).text();
    $.ajax({
      url: "selectTh.ti",
      data: { mName: $mName },
      type: "get",
      success: function (list) {
        var tlist = list;
        $(".theater-location-wrapper").empty();
        $.each(tlist, function (index, item) {
          $(".theater-location-wrapper").append(
            '<button class="theater-location">' +
              item.theaterName +
              "(" +
              item.theaterNum +
              ")"
          );
        });
      },
    });

    // 선택한 영화 저장
    $(".mName").val($mName);
    $(".movieAge").val($(this).children().eq(0).text());
  });

  // 지역 클릭하면 해당 지역 극장 띄우기
  $(document).on("click", ".theater-location", function () {
    $(".theater-place-wrapper").empty();
    // 특정 지역 받아오기
    var $tAddr = $(".theater-location").text().split(" ")[0];

    $.ajax({
      url: "selectPl.ti",
      data: { tAddr: $tAddr, mName: $mName },
      type: "get",
      success: function (list) {
        var tlist = list;

        $.each(tlist, function (index, item) {
          $(".theater-place-wrapper").append(
            '<button class="theater-place">' + item + "</button>"
          );
        });
      },
    });
  });

  // 날짜 클릭하면 시간 띄우기
  $(document).on("click", ".theater-place", function () {
    $(".selectedTheater").val($(this).text());
    $(".reserve-time").empty();
    $.ajax({
      url: "selectTime.ti",
      data: {
        mName: $mName,
        theater: $(this).text(),
        date: $(".movie-date").text(),
      },
      type: "get",
      success: function (list) {
        var tlist = list;

        var $reserveTimeWrapper = $('<div class="reserve-time-wrapper"></div>');
        var $reserveTimeButton = $(
          '<button class="reserve-time-button"></button>'
        );
        var $reserveTimeWant = $('<span class="reserve-time-want"></span>');
        var $reserveSeatRemain = $('<span class="reserve-time-remain"></span>');

        $.each(tlist, function (index, item) {
          var $reserveTime = $(".reserve-time");
          var $reserveWhere = $('<div class="reserve-where"><div>');

          $reserveTime.append($reserveWhere);
          $reserveWhere.append(
            item.auditoriumName + "(총 " + item.seatNum + "석)"
          );
          $reserveTime.append(
            '<div class="reserve-time-wrapper">' +
              '<button class="reserve-time-button">' +
              	'<span class="reserve-time-want">' + item.runSch +'</span>' +
              	'<span class="reserve-time-remain">' + item.remain + '석</span>' +
              	'<div class="reserve-time-no" style="display:none">' + item.runNo + '</div>' +
              '</button>' +
             '</div>'
          );
        });
      },
    });
  });

  // 요일 선택하기
  $(document).on("click", ".movie-date-wrapper", function () {
    $(".reserveDate").val($(this).text());
  });

  // 시간 선택하면 시간 저장하기 & 넘어가기
  $(document).on("click", ".reserve-time-button", function () {
    $(".runningTime").val($(this).children().eq(0).text());
    $(".AuditoriumSeat").val($(this).parent().prev().text());
    $(".remainSeat").val($(this).children().eq(1).text());
    $(".runNo").val($(this).children().eq(2).text());
    
    if (
      !!$(".mName").val() &&
      !!$(".movieAge").val() &&
      !!$(".selectedTheater").val() &&
      !!$(".reserveDate").val() &&
      !!$(".runningTime").val()
    ) {
      $(".moveSeatForm").submit();
    } else {
      alert("전부 다 선택해주세요");
      
    }
  });
});

const date = new Date(); // 오늘 날짜 받아오기
reserveDate = $(".reserve-date");
year = date.getFullYear();
month = date.getMonth();
reserveDate.append(year + "/" + month);
var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0); // 이번달 마지막 날

const weekDay = ["일", "월", "화", "수", "목", "금", "토"];

function addDate() {
  // 이번달 전부 확인해보기
  for (i = date.getDate(); i <= lastDay.getDate(); i++) {
    // 오늘 today[newDate(2022-01-날짜)]
    var today =
      weekDay[
        new Date(
          date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + i
        ).getDay()
      ];

    // 요일에 맞는 css넣기
    if (today === "토") {
      $(".movie-day").addClass("saturday");
      $(".movie-date").addClass("saturday");
    } else if (today === "일") {
      $(".movie-day").addClass("sunday");
      $(".movie-date").addClass("sunday");
    }

    if (i < 10) {
      i = "0" + i;
    }

    // day: 요일 , date: 날짜
    $(".reserve-date").append(
      '<button class="movie-date-wrapper">' +
        '<span class="movie-day">' +
        today +
        "</span>" +
        '<span class="movie-date">' +
        i +
        "</span>" +
        "</button>"
    );

    var button = $(".reserve-date");
  }
}
