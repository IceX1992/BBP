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
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="soldTickets">Tickets sold <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="number" id="soldTickets" name="soldTickets" min=0 required="required" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>



                            <div class="form-group">
                                <label for="busRoute" class="control-label col-md-3 col-sm-3 col-xs-12">BusRoute*<span
                                        class="required">*</span></label>
                                <select id="busRoute" name="busRoute" class="col-md-3 col-sm-3  col-xs-12"
                                     <%--   required onchange="myFunction()" data-name=${listValue.busRoute} data-dep=${listValue.estimatedDeparture}data-arr=${listValue.estimatedDArrival}--%>
                                >
                                    <c:forEach var="listValue" items="${listBusRoutes}">
                                        <option>
                                                ${listValue.busRoute}
                                        </option>

                                               est dep: ${listValue.estimatedDeparture}


                                               est arr: ${listValue.estimatedDArrival}

                                    </c:forEach>

                                </select>
                            </div>
<%--

                            <p id="demo">${listValue.estimatedDeparture}</p>
                            <p id="demo2"  id="busid" name="busid"></p>

                            <script>
                                function myFunction() {

                                    var busid = $(this).data().dep;


                                    $("#busid").val(busid);

                                }
                            </script>
--%>



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
                                <th>estimatedDeparture</th>
                                <th>estimatedDArrival</th>
                                <th>actualDeparture</th>
                                <th>actualArrival</th>
                                <th>soldTickets</th>
                                <th>Bus plate</th>
                                <th>Maximum passengers</th>
                                <th>Route name</th>
                            </tr>
                            </thead>


                            <tbody>

                            <c:forEach var="listValue" items="${listRides}">
                                <tr>
                                    <td>
                                            ${listValue.id}
                                    </td>
                                    <td>
                                            ${listValue.busRoute.estimatedDeparture}
                                    </td>
                                    <td>
                                            ${listValue.busRoute.estimatedDArrival}
                                    </td>
                                    <td>
                                            ${listValue.actualDeparture}
                                    </td>
                                    <td>
                                            ${listValue.actualArrival}
                                    </td>
                                    <td>
                                            ${listValue.soldTickets}
                                    </td>
                                    <td>
                                            ${listValue.busRoute.bus.licencePlate}
                                    </td>
                                    <td>
                                            ${listValue.busRoute.bus.maxPassengers}
                                    </td>
                                    <td>
                                            ${listValue.busRoute.route.name}
                                    </td>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
<jsp:include page="footer.jsp"></jsp:include>