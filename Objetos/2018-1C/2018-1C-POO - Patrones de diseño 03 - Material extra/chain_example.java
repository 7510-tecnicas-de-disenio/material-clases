public class ErrorResponse {
	private String message;
	public ErrorResponse(String msg) {
		this.message = msg;
	}
}

public abstract class StatusHandler {
	private StatusHandler nextLink;
	
	public StatusHandler(StatusHandler nextLink) {
		this.nextLink = nextLink;
	}
	
	public Response handle (HttpException exception) {
		return this.nextLink.handle(exception);
	}
}

public class NotFoundStatusHandler implements StatusHandler {
	public NotFoundStatusHandler(StatusHandler nextLink) {
		super(nextLink);
	}
	public Response handle (HttpException exception) {
		if(exception.getStatus() = Response.Status.NOT_FOUND) {
			ErrorResponse errorResponse = new ErrorResponse("Resurce could not be found");
			return Response.status(Response.Status.NOT_FOUND).entity(errorResponse).build();
		} else {
			return super.handle(exception);
		}
	}
}

public class ForbiddenStatusHandler implements StatusHandler {
	public ForbiddenStatusHandler(StatusHandler nextLink) {
		super(nextLink);
	}
	public Response handle (HttpException exception) {
		if(exception.getStatus() = Response.Status.FORBIDDEN) {
			ErrorResponse errorResponse = new ErrorResponse("You shall not pass!");
			return Response.status(Response.Status.FORBIDDEN).entity(errorResponse).build();
		} else {
			return super.handle(exception);
		}
	}
}

public class UnauthorizedStatusHandler implements StatusHandler {
	public UnauthorizedStatusHandler(StatusHandler nextLink) {
		super(nextLink);
	}
	public Response handle (HttpException exception) {
		if(exception.getStatus() = Response.Status.UNAUTHORIZED) {
			ErrorResponse errorResponse = new ErrorResponse("You need different credentials to access this section.");
			return Response.status(Response.Status.UNAUTHORIZED).entity(errorResponse).build();
		} else {
			return super.handle(exception);
		}
	}
}

public class UnknownErrorStatusHandler implements StatusHandler {
	public UnknownErrorStatusHandler(StatusHandler nextLink) {
		super(nextLink);
	}
	public Response handle (HttpException exception) {
		ErrorResponse errorResponse = new ErrorResponse("Something went wrong and we've logged it to try to fix it.");
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
	}
}


[...]
public class FavorResource {
	
	private FavorService favorService;
	private StatusHandler statusHandler;
	
	public FavorResource(FavorService service) {
		this.favorService = service;
		
		StatusHandler handler = new UnknownErrorStatusHandler(null);
		handler = new UnauthorizedStatusHandler(handler);
		handler = new ForbiddenStatusHandler(handler);
		this.statusHandler = new NotFoundStatusHandler(handler);
	}
	
	[...]
	public Response get(@PathParam(value = "favor") Long favorId) {
		try {
			Favor favor = this.favorService.get(favorId);
			return Response.ok(favor).build();
		} catch (HttpException e) {
			return this.statusHandler.handle(e);
		}
	}
	
}

