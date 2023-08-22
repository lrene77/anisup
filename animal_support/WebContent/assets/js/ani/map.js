var select = "";
$(function() {
	$("#dropdown1").change(
		function() {
			select = $(this).find("option:selected").val();
			var new_option = $("<option>");
			new_option.attr({
				"value" : ""
			}).html("선택하세요");

		if (select == "서울") {
			$("#dropdown2").children().remove();

			var new_option1 = $("<option>");
			new_option1.attr({
				"value" : "서울 보호소"
			}).html("관악구");
			var new_option2 = $("<option>");
			new_option2.attr({
				"value" : "서울 보호소"
			}).html("강남구");
			var new_option3 = $("<option>");
			new_option3.attr({
				"value" : "서울 보호소"
			}).html("강서구");

			$("#dropdown2").append(new_option).append(new_option1)
					.append(new_option2).append(new_option3);
		} else if (select == "경기") {
			$("#dropdown2").children().remove();

			var new_option1 = $("<option>");
			new_option1.attr({
				"value" : "경기 보호소"
			}).html("아주구");
			var new_option2 = $("<option>");
			new_option2.attr({
				"value" : "경기 보호소"
			}).html("상현구");
			var new_option3 = $("<option>");
			new_option3.attr({
				"value" : "경기 보호소"
			}).html("일산구");

			$("#dropdown2").append(new_option).append(new_option1)
					.append(new_option2).append(new_option3);
		} else if (select == "부산") {
			$("#dropdown2").children().remove();

			var new_option1 = $("<option>");
			new_option1.attr({
				"value" : "부산 보호소"
			}).html("해운구");
			var new_option2 = $("<option>");
			new_option2.attr({
				"value" : "부산 보호소"
			}).html("서면구");
			var new_option3 = $("<option>");
			new_option3.attr({
				"value" : "부산 보호소"
			}).html("낙동구");

			$("#dropdown2").append(new_option).append(new_option1)
					.append(new_option2).append(new_option3);
		} else {
			$("#dropdown2").children().remove();
			$("#dropdown2").append(new_option);
		}
	});
});