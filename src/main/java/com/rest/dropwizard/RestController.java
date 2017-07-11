package com.rest.dropwizard;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/rest")
@Produces(MediaType.APPLICATION_JSON)
public class RestController {

	@GET
	public Response getStudents() {
		return Response.ok(RestDAO.getStudents()).build();
	}

	@GET
	@Path("/{id}")
	public Response getStudentById(@PathParam("id") Integer id) {
		Student student = RestDAO.getStudent(id);
		if (student != null) {
			return Response.ok(student).build();
		} else {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@POST
	public Response createStudentData(Student student) {
		Student studentInfo = RestDAO.getStudent(student.getId());
		if (studentInfo == null) {
			RestDAO.updateStudent(RestDAO.getStudents().size() + 1, student);
			return Response.status(200).build();
		} else {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

}
