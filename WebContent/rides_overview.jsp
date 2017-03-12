<%--
  Created by IntelliJ IDEA.
  User: dionc
  Date: 3/12/2017
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>

<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>Rides </h3>
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                    <div class="x_content">
                        <br/>
                        <form action="listRides" method="POST" id="demo-form2" data-parsley-validate
                              class="form-horizontal form-label-left">

                            <div class="form-group">
                                <label for="actualDeparture" class="control-label col-md-3 col-sm-3 col-xs-12">Actual
                                    Departure*<span class="required">*</span></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="datetime-local" id="actualDeparture" required
                                           name="actualDeparture">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="actualArrival" class="control-label col-md-3 col-sm-3 col-xs-12">Actual
                                    Arrival*<span class="required">*</span></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="datetime-local" id="actualArrival" required
                                           name="actualArrival">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="maxPass">Max passengers<span class="required">*</span>
                                </label>
                                <div class="col-md-2 col-sm-2 col-xs-4">
                                    <input type="number" id="maxPass" name="maxPass" disabled class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="soldTickets">Tickets sold <span class="required">*</span>
                                </label>
                                <div class="col-md-2 col-sm-2 col-xs-4">
                                    <input type="number" id="soldTickets" name="soldTickets" min=0 required="required" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="busRoute" class="control-label col-md-3 col-sm-3 col-xs-12">BusRoute*<span
                                        class="required">*</span></label>
                                <select id="busRoute" name="busRoute" class="col-md-3 col-sm-3  col-xs-12"
                                       required>

                                    <option disabled selected value> -- select an option -- </option>

                                    <c:forEach var="listValue" items="${listBusRoutes}">
                                        <option data-name="${listValue.busRoute}" data-depart="${listValue.estimatedDeparture}"
                                                data-arr="${listValue.estimatedDArrival}" data-busrouteid="${listValue.id}"
                                                data-maxpassengers = "${listValue.bus.maxPassengers}">

                                                ${listValue.busRoute}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <input type="hidden" id="busRouteId" name="busRouteId">
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="estDep">Estimated departure:<span class="required">*</span>
                                </label>
                                <div class="col-md-3 col-sm-3 col-xs-3">
                                    <input type="text" id="estDep" name="estDep" disabled class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="estArr">Estimated arrival:<span class="required">*</span>
                                </label>
                                <div class="col-md-3 col-sm-3 col-xs-3">
                                    <input type="text" id="estArr" name="estArr" disabled class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>


                            <script>
                                document.getElementById('busRoute').onchange = function () {
                                    var selected = $(this).find('option:selected');
                                    var depart = selected.data().depart;
                                    var arr = selected.data().arr;
                                    var busRouteId = selected.data().busrouteid;
                                    var maxpassengers = selected.data().maxpassengers;
                                    $("#estDep").val(depart);
                                    $("#estArr").val(arr);
                                    $("#busRouteId").val(busRouteId);
                                    $("#maxPass").val(maxpassengers);
                                    //currently from the db we get times like: 2014-01-02 11:42:13 while it needs to be like 2014-01-02T11:42:13 to be put in datetime
                                    depart = depart.replace(/\s/g, "T");
                                    arr = arr.replace(/\s/g, "T");
                                    $("#actualDeparture").val(depart);
                                    $("#actualArrival").val(arr);
                                    //set soldTickets max to maxPassengers value
                                    $("#soldTickets").attr({
                                        "max" : maxpassengers,
                                        "min" : 0
                                    });
                                };
                            </script>




                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" class="btn btn-success" value="Create">
                                </div>
                            </div>
                        </form>

                        <div class="ln_solid"></div>

                    <div class="x_title">
                        <h2>Rides overview <small>A list of all rides</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Settings 1</a>
                                    </li>
                                    <li><a href="#">Settings 2</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <table id="datatable" class="table table-striped table-bordered bus-overview-table">
                            <thead>
                            <tr>
                                <th>Ride id</th>
                                <th>Route name</th>
                                <th>Estimated Departure</th>
                                <th>Actual Departure</th>
                                <th>Estimated Arrival</th>
                                <th>Actual Arrival</th>
                                <th>Sold tickets</th>
                                <th>Maximum passengers</th>
                                <th>Bus plate</th>
                            </tr>
                            </thead>


                            <tbody>

                            <c:forEach var="listValue" items="${listRides}">
                                <tr>
                                    <td>
                                            ${listValue.id}
                                    </td>
                                    <td>
                                            ${listValue.busRoute.route.name}
                                    </td>
                                    <td>
                                            ${listValue.busRoute.estimatedDeparture}
                                    </td>
                                    <td>
                                            ${listValue.actualDeparture}
                                    </td>
                                    <td>
                                            ${listValue.busRoute.estimatedDArrival}
                                    </td>
                                    <td>
                                            ${listValue.actualArrival}
                                    </td>
                                    <td>
                                            ${listValue.soldTickets}
                                    </td>
                                    <td>
                                            ${listValue.busRoute.bus.maxPassengers}
                                    </td>
                                    <td>
                                            ${listValue.busRoute.bus.licencePlate}
                                    </td>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
<jsp:include page="footer.jsp"></jsp:include>