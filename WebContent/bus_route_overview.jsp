<%--
  Created by IntelliJ IDEA.
  User: dionc
  Date: 3/11/2017
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>Busroutes</h3>
            </div>

            <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Register busroutes
                        </h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-expanded="false"></a>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <br/>
                        <form action="listBusRoutes" method="POST" id="demo-form2" data-parsley-validate
                              class="form-horizontal form-label-left">

                            <div class="form-group">
                                <label for="estimatedDeparture" class="control-label col-md-3 col-sm-3 col-xs-12">Estimated
                                    Departure*<span class="required">*</span></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="datetime-local" id="estimatedDeparture" required
                                           name="estimatedDeparture">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="estimatedDArrival" class="control-label col-md-3 col-sm-3 col-xs-12">Estimated
                                    Arrival*<span class="required">*</span></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="datetime-local" id="estimatedDArrival" required
                                           name="estimatedDArrival">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="bus" class="control-label col-md-3 col-sm-3 col-xs-12">Bus*<span
                                        class="required">*</span></label>
                                <select id="bus" name="bus" class="col-md-3 col-sm-3  col-xs-12" required>
                                    <option disabled selected value> -- select an option -- </option>
                                    <c:forEach var="listValue" items="${listBusses}">
                                        <option data-busid="${listValue.id}">
                                                ${listValue.licencePlate}
                                        </option>
                                    </c:forEach>

                                </select>
                            </div>
                            <input type="hidden" id="busId" name="busId">

                            <div class="form-group">
                                <label for="route" class="control-label col-md-3 col-sm-3 col-xs-12">Route*<span
                                        class="required">*</span></label>
                                <select id="route" name="route" class="col-md-3 col-sm-3 col-xs-12" required>
                                    <option disabled selected value> -- select an option -- </option>
                                    <c:forEach var="listValue" items="${listRoutes}">
                                        <option data-routeid="${listValue.id}">
                                                ${listValue.name}
                                        </option>
                                    </c:forEach>

                                </select>
                            </div>
                            <input type="hidden" id="routeId" name="routeId">

                            <script>
                                document.getElementById('bus').onchange = function () {
                                    var selected = $(this).find('option:selected');
                                    var busid = selected.data().busid;
                                    $("#busId").val(busid);
                                };
                                document.getElementById('route').onchange = function () {
                                    var selected = $(this).find('option:selected');
                                    var routeid = selected.data().routeid;
                                    $("#routeId").val(routeid);
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
                            <h2>BusRoute list
                            </h2>
                            <div class="clearfix"></div>
                        </div>
                        <table id="datatable" class="table table-striped table-bordered bus-overview-table">
                            <thead>
                            <tr>
                                <th>Bus id</th>
                                <th>Estimated Departure</th>
                                <th>Estimated Arrival</th>
                                <th>Bus Plate</th>
                                <th>Route Name</th>
                            </tr>
                            </thead>


                            <tbody>

                            <c:forEach var="listValue" items="${listBusRoutes}">
                                <tr>
                                    <td>
                                            ${listValue.id}
                                    </td>
                                    <td>
                                            ${listValue.estimatedDeparture}
                                    </td>
                                    <td>
                                            ${listValue.estimatedDArrival}
                                    </td>
                                    <td>
                                            ${listValue.bus.licencePlate}
                                    </td>
                                    <td>
                                            ${listValue.route.name}
                                    </td>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- /page content -->
<jsp:include page="footer.jsp"></jsp:include>
