<%--
  Created by IntelliJ IDEA.
  User: dionc
  Date: 3/11/2017
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>

<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>Routes </h3>
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Route overview <small>A list of all routes</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"></a>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <table id="datatable" class="table table-striped table-bordered route-overview-table">
                            <thead>
                            <tr>
                                <th>Route id</th>
                                <th>Name</th>
                                <th>Departure</th>
                                <th>Destination</th>
                                <th>Price per passenger</th>
                            </tr>
                            </thead>


                            <tbody>

                            <c:forEach var="listValue" items="${listRoutes}">
                                <tr data-id="${listValue.id}" data-name="${listValue.name}" data-departure="${listValue.departure}" data-destination="${listValue.destination}" data-pricePerPassenger="${listValue.pricePerPassenger}">
                                    <td>
                                            ${listValue.id}
                                    </td>
                                    <td>
                                            ${listValue.name}
                                    </td>
                                    <td>
                                            ${listValue.departure}
                                    </td>
                                    <td>
                                            ${listValue.destination}
                                    </td>
                                    <td>
                                            ${listValue.pricePerPassenger}
                                    </td>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
            <!-- /page content -->
            <!-- Modal -->
            <div id="editRouteModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Edit route</h4>
                        </div>
                        <div class="modal-body">
                            <form action="listRoutes" method="POST" id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                                <input type="hidden" id="routeid" name="routeid">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Name <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="name" name="name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="departure">Departure <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="departure" name="departure" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="departure">Destination <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="destination" name="destination" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="pricePerPassenger">Price per passenger <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="number" id="pricePerPassenger" name="pricePerPassenger" min=0 step="0.01"required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                                    <input type="submit" class="btn btn-success">
                                    <input type="submit" value="Delete" name="delete" class="btn btn-success">
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
                <script>
                    $('.route-overview-table tbody tr').click(function(){
                        var routeid = $(this).data().id;
                        var name = $(this).data().name;
                        var departure = $(this).data().departure;
                        var destination = $(this).data().destination;
                        var pricePerPassenger = $(this).data().pricePerPassenger;

                        $("#routeid").val(routeid);
                        $("#name").val(name);
                        $("#departure").val(departure);
                        $("#destination").val(destination);
                        $("#pricePerPassenger").val(pricePerPassenger);

                        $('#editRouteModal').modal('show');
                    })
                </script>
                </div>
            </div>
        </div>
    </div>

