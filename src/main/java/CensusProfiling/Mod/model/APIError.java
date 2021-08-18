package CensusProfiling.Mod.model;
import org.springframework.http.HttpStatus;

public class APIError {
	private String msg;
	private HttpStatus httpStatus;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}