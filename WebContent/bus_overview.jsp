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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"></a>
                      </li>
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
                          <th>License plate</th>
                        </tr>
                      </thead>


                      <tbody>

                        <c:forEach var="listValue" items="${listBusses}">
                          <tr data-id="${listValue.id}" data-brand="${listValue.brand}" data-maxpassengers="${listValue.maxPassengers}" data-licenceplate="${listValue.licencePlate}">
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
                <jsp:include page="footer.jsp"></jsp:include>
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
                                <form action="listBusses" method="POST" id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                                        <input type="hidden" id="busid" name="busid">
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
                    $('.bus-overview-table tbody tr').click(function(){
                        var busid = $(this).data().id;
                        var brand = $(this).data().brand;
                        var maxpassengers = $(this).data().maxpassengers;
                        var licenceplate = $(this).data().licenceplate;

                        $("#brand").val(brand);
                        $("#max-passenger").val(maxpassengers);
                        $("#license-plate").val(licenceplate);
                        $("#busid").val(busid);

                        $('#editBusModal').modal('show');
                    })
                </script>

                    </div>
