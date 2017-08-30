/**
 * _ajax Service
 */
(function service_ajax() {
	
	//add listener
	setTimeout(function(){
		var checkBtn = $("#checkBtn").get(0);
		checkBtn.addEventListener("click", get_ajax , false);
	},500);
	
})();

function get_ajax(){
	
	var _data = {
        event: "CHECK_SERVLET",
        data: ""
        }

	 $.ajax({
	        type: "POST",
	        url: "AndroidServiceServlet",
	        dataType: "json",
	        data: _data,
	        cache:false,
	        success: function (response) {
	        	$("#responseArea").html(response.data).show();
	        	setTimeout(function(){
	        		location.reload();
	        	},2000);
	      
	        },
            error: function(error)
            {
                console.log(error);
            }
	 });
};