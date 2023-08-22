/**
 * 
 * @param elid				- 지도가 표시될 div요소의 id
 * @param lat_value		- 지도에 표시할 위치의 정도
 * @param lng_value	- 지도에 표시할 위치의 경도
 * @returns
 */
function createGoogleMap(elid, lat_value, lng_value) {
	var map = new GMaps({
		el : elid,
		lat : lat_value,
		lng : lng_value,

		zoomControl : true
	});

	return map;
}
/**
 * 
 * @param map
 * @param lat_value
 * @param lng_value
 * @param title_string
 * @param icon_url
 * @param content_html
 * @returns
 */
function addMapMarker(map, lat_value, lng_value, title_string, icon_url,
	content_html) {
	map.addMarker({
		lat : lat_value,
		lng : lng_value,
		
		title : title_string,
		
		icon : {
			url: icon_url,
			scaledSize : new google.maps.Size(50, 50)
		},
		
		infoWindow : {
			content : content_html
		}
	});
}
