var list = (function(document) {

	function setInit() {
		
	}

	function setEvent() {
		var serchBtn = $('#serchBtn');

		serchBtn.click(function(e) {
		});
	}

	function getData(payload) {
		if ( !payload ) {
			payload = {};
		}
		Interface.httpSend({
			path : '/example',
			payload : payload,
			success : function(data, setting) {
				setExampleListView(data.list);
			},
			error: function(failCode, failMessage, setting) {
				console.error(failCode + ' ' + failMessage);
			}
		});

	}

	function setExampleListView(list) {
		var	exampleListHtml = '',
			exampleListTemplate = $('#exampleListTemplate').html(),
			exampleListCount = exampleList.length,
			currentElement = $('#exampleListView'),
			exampleListItem, i;

		if ( list.length == 0 )  {
			return;
		}

		for ( i = 0; i < exampleListCount; i ++ ) {
			exampleListItem = exampleList[i];
			exampleListHtml += exampleListTemplate
					.replace(/\{\{NUMBER\}\}/, exampleListItem.number)
					.replace(/\{\{SUBJECT\}\}/, exampleListItem.subject);
		}

		var $exampleListHtml = $(exampleListHtml);
		$exampleListHtml = $exampleListHtml.not('#text');
		currentElement.html($exampleListHtml);

	}

	return {
		setInit: setInit,
		setEvent: setEvent
	};
})(document);

$(document).ready(function() {
	list.setInit();
	list.setEvent();
}).hide(function() {
})
