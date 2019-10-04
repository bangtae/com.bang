var commonWrapper = (function(window) {
	
	var interfaceManager = (function () {

		function restSend(settings) {
			var server = settings.server,
				path = settings.path,
				method = settings.method,
				payload = settings.payload,
				success = settings.success,
				error = settings.error;

			if (!server) {
				server = CONSTANT.AJAX.SERVER.DEV;
			}

			if (!method) {
				method = CONSTANT.AJAX.METHOD;
			}

		}

		return {
			restSend: restSend
		};
	})();

	return {
		interfaceManager: interfaceManager
	};

})(window);


(function() {
	window.interfaceManager = commonWrapper.interfaceManager;
})();