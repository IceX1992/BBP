<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Busses </h3>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Bus overview <small>A list of all busses</small></h2>
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
                          <th>Bus id</th>
                          <th>Brand</th>
                          <th>Max # passengers</th>
                          <th>Licence plate</th>
                        </tr>
                      </thead>


                      <tbody>

                        <c:forEach var="listValue" items="${listBusses}">
                          <tr>
                            <td>
                                ${listValue.id}
                            </td>
                            <td>
                                ${listValue.brand}
                            </td>
                            <td>
                                ${listValue.maxPassengers}
                            </td>
                            <td>
                                ${listValue.licencePlate}
                            </td>
                          </tr>

                        </c:forEach>

                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
        <!-- /page content -->
                <!-- Modal -->
                <div id="editBusModal" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Edit bus</h4>
                            </div>
                            <div class="modal-body">
                                <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="brand">Brand <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="brand" name="brand" required="required" class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="max-passenger">Max passengers <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="number" id="max-passenger" name="max-passenger" min=0 required="required" class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="license-plate" class="control-label col-md-3 col-sm-3 col-xs-12">License plate <span class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input id="license-plate" class="form-control col-md-7 col-xs-12" type="text" required="required" name="license-plate">
                                        </div>
                                    </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-success">Update</button>
                            </div>
                            </form>
                        </div>

                    </div>
                </div>
                <script>
                    $('.bus-overview-table tbody tr').click(function(){
                        $('#editBusModal').modal('show');
                    })
                </script>
<jsp:include page="footer.jsp"></jsp:include>