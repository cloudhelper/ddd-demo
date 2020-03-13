package org.cloudhelper.ddd.demo.ui.web.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cloudhelper.ddd.demo.ui.web.constant.ReturnCode;
import org.cloudhelper.ddd.demo.infrastructure.exception.ExceptionHandler;
import org.cloudhelper.ddd.demo.infrastructure.util.ApplicationUtil;
import org.cloudhelper.ddd.demo.ui.web.dto.base.ResponseBody;
import org.cloudhelper.ddd.demo.ui.web.dto.base.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 */
public class BaseController {

	private static Logger logger = LogManager.getLogger(BaseController.class);

	@Autowired
	private ApplicationUtil applicationUtil;

	@Autowired
	private ExceptionHandler exceptionHandler;

	/**
	 * format 失败 response。
	 * @param e
	 * @return
	 */
	protected ResponseDto formatErrorResponse(final Exception e) {
		ResponseDto responseDto = new ResponseDto();
		//将response 的data body置为空
		responseDto.setBody(null);

		//依据异常类型进行分别处理，将异常信息转义为用户友好的提示信息
		Map<String, String> exceptionMap = exceptionHandler.handle(e);
		responseDto.setReturnCode(exceptionMap.get("errorCode"));
		responseDto.setReturnMsg(exceptionMap.get("errorMsg"));
		logger.debug("Response is: "+responseDto);
		return responseDto;
	}


	/**
	 * format成功的response
	 * @param responseBody
	 * @return ResponseDto
	 */
	protected ResponseDto formatSuccessResponse(ResponseBody responseBody) {
		ResponseDto responseDto = new ResponseDto();
		//设置返回码和返回信息为成功
		responseDto.setReturnCode(ReturnCode.SUCCESS);
		responseDto.setReturnMsg(applicationUtil.getReturnMsg(ReturnCode.SUCCESS));

		//将response 的data body置为实际的业务body
		responseDto.setBody(responseBody);
		logger.debug("Response is: "+responseDto);
		return responseDto;
	}


}
