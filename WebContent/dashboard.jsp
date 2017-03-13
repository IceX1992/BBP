<%--
  Created by IntelliJ IDEA.
  User: jeanjongloy
  Date: 3/11/17
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
<!-- page content -->
<div class="right_col" role="main">
    <!-- top tiles -->
    <div class="row tile_count">
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-bus"></i> Total Bus amount</span>
            <div class="count" id="busAmount">
            </div>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i> Total passenger capacity</span>
            <div class="count" id="maxPassengers">
            </div>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i>Number of rides</span>
            <div class="count" id="ridesCount">
            </div>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i> Total sold tickets</span>
            <div class="count" id="soldTickets">
            </div>
        </div>
    </div>
    <!-- /top tiles -->

    <script>
        var countBus = "${countBus}";
        var maxPassengers = "${maxPassengers}";
        var ridesCount = "${ridesCount}";
        var soldTickets = "${soldTickets}";
        document.getElementById("busAmount").innerHTML = countBus;
        document.getElementById("maxPassengers").innerHTML = maxPassengers;
        document.getElementById("ridesCount").innerHTML = ridesCount;
        document.getElementById("soldTickets").innerHTML = soldTickets;
    </script>


    <div class="row">
      <div class="col-md-4 col-sm-4 col-xs-12">
            <div class="x_panel tile fixed_height_320">
                <div class="x_title">
                    <h2>Drukste routes</h2>
                    <ul class="nav navbar-right panel_toolbox">
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <h4>Top 5 Drukste routes in aantal route_bussen</h4>
                    <h4 class="pull-right">test</h4>

                    <c:forEach var="listValue" items="${routeCountObject}">
                        <div class="widget_summary">
                            <div class="w_left w_25">
                                <span>
                                        ${listValue.name}
                                </span>
                            </div>
                            <div class="w_center w_55">
                                <div class="progress">
                                    <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60"
                                         aria-valuemin="0" aria-valuemax="100" style="width: ${listValue.countPerc}%;"
                                         id="barId">
                                        <span class="sr-only">60% Complete</span>
                                    </div>
                                </div>
                            </div>
                            <div class="w_right w_20">
                                <span>${listValue.count}</span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <%--<script>
                            var countBus = "${routeCountObject}";
                            var test = "${routeCountObject}";

                            $("#barId").attr({
                                "style" : "width:${listValue.count}%"
                            });

                        </script>--%>
                    </c:forEach>

                    <%--
                    <div class="widget_summary">
                        <div class="w_left w_25">
                            <span>0.1.5.6</span>
                        </div>
                        <div class="w_center w_55">
                            <div class="progress">
                                <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 2%;">
                                    <span class="sr-only">60% Complete</span>
                                </div>
                            </div>
                        </div>
                        <div class="w_right w_20">
                            <span>1k</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>--%>

                </div>
            </div>
        </div>

        <div class="col-md-4 col-sm-4 col-xs-12">
            <div class="x_panel tile fixed_height_320 overflow_hidden">
                <div class="x_title">
                    <h2>Device Usage</h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
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
                    <table class="" style="width:100%">
                        <tr>
                            <th style="width:37%;">
                                <p>Top 5</p>
                            </th>
                            <th>
                                <div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
                                    <p class="">Device</p>
                                </div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <p class="">Progress</p>
                                </div>
                            </th>
                        </tr>
                        <tr>
                            <td>
                                <canvas class="canvasDoughnut" height="140" width="140"
                                        style="margin: 15px 10px 10px 0"></canvas>
                            </td>
                            <td>


                                <table class="tile_info">
                                    <tr>
                                        <td>
                                            <p><i class="fa fa-square blue"></i>IOS </p>
                                        </td>
                                        <td>30%</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p><i class="fa fa-square green"></i>Android </p>
                                        </td>
                                        <td>10%</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p><i class="fa fa-square purple"></i>Blackberry </p>
                                        </td>
                                        <td>20%</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p><i class="fa fa-square aero"></i>Symbian </p>
                                        </td>
                                        <td>15%</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p><i class="fa fa-square red"></i>Others </p>
                                        </td>
                                        <td>30%</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- /page content -->
<jsp:include page="footer.jsp"></jsp:include>