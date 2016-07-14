<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        
        <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAITDKVsmqWFfcBXcEszV0ZMkCj9tJTbns"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script>
        var latOrig=-12.117222;
        var lngOrig=-77.020556; 
        var dif=0.00657;
        var orig=new google.maps.LatLng(latOrig, lngOrig);
        var origDown = new google.maps.LatLng(latOrig - dif, lngOrig);
        var origRight = new google.maps.LatLng(latOrig, lngOrig-dif);
        var origDownRight = new google.maps.LatLng(latOrig - dif, lngOrig-dif);
        var marker;    
            function initialize() {
              var mapProp = {
                center:orig,
                zoom:14,
                mapTypeId:google.maps.MapTypeId.ROADMAP
              };
              var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
              var marker=new google.maps.Marker({
                      position:orig,
                      animation:google.maps.Animation.BOUNCE
                      });

                    marker.setMap(map);
              google.maps.event.addListener(marker,'click',function() {
                  map.setCenter(marker.getPosition());
                  });
      
              var mySector= [orig,origDown,origDownRight,origRight,orig]   ;
              var flightPath=new google.maps.Polygon({
                  path:mySector,
                  strokeColor:"#0000FF",
                  strokeOpacity:0.8,
                  strokeWeight:2,
                  fillColor:"#0000FF",
                  fillOpacity:0.4
                  });
              flightPath.setMap(map);  
              

                google.maps.event.addListener(marker, 'click', function() {
                  $('#crimeEdit').modal('show');
                  });
                google.maps.event.addListener(map, 'click', function() {
                  $('#crimeNew').modal('show');
                  });  

            }
            google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </head>

    <body>
        
        <div class="container">
        
        <table>
            <tr>
                <th>ID</th><th>Nombre</th>
            </tr>
            <c:forEach var="tipoDelito" items="${tipoDelitos}">
                <tr>
                    <td><c:out value="${tipoDelito.getIdTipoDelito()}"></c:out></td>
                    <td><c:out value="${tipoDelito.getNombre()}"></c:out></td>
                </tr>
            </c:forEach>
        </table>    
        <div id="googleMap" style="width:500px;height:380px;"></div>
        
                
       <!-- Modal delito editar --> 
      <div class="modal fade" id="crimeEdit" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Delito</h4>
            </div>
            <div class="modal-body">
                <div class="row" style="margin-top: 10px;">
                    <div class="form-group">
                        <div class="col-md-3 col-sm-3"></div>
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Tipo de delito:</label>
                        <div class="col-md-3 col-sm-3 col-xs-12" id="crime-type">
                        </div>
                    </div>
                </div>

                <div class="row" style="margin-top: 10px;">
                    <div class="form-group">
                        <div class="col-md-3 col-sm-3"></div>
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Fecha:</label>
                        <div class="col-md-3 col-sm-3 col-xs-12" id="date">
                        </div>
                    </div>
                </div>
                      
                <div class="row" style="margin-top: 10px;">
                    <div class="form-group">
                        <div class="col-md-3 col-sm-3"></div>
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Turno:</label>
                        <div class="col-md-3 col-sm-3 col-xs-12" id="turn">
                        </div>
                    </div>
                </div>
                
                <div class="row" style="margin-top: 10px;">
                    <div class="form-group">
                        <div class="col-md-3 col-sm-3"></div>
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Comentarios:</label>
                        <div class="col-md-3 col-sm-3 col-xs-12" id="comment">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
          </div>

        </div>
      </div>
        
       <!-- Modal delito nuevo -->   
      <div class="modal fade" id="crimeNew" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Nuevo delito</h4>
            </div>
            <div class="modal-body">
                <div class="row" style="margin-top: 10px;">
                    <div class="form-group">
                        <div class="col-md-3 col-sm-3"></div>
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Tipo de delito:</label>
                        <select>
                           <option value="0" label="--- Seleccione ---"/>
                           <c:forEach var="tipoDelito" items="${tipoDelitos}">
                                <option  value="${tipoDelito.getIdTipoDelito()}">
                                    <c:out value="${tipoDelito.getNombre()}"></c:out>
                                </option>
                            </c:forEach>
                        </select>
                       
                    </div>
                </div>

                <div class="row" style="margin-top: 10px;">
                    <div class="form-group">
                        <div class="col-md-3 col-sm-3"></div>
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Fecha:</label>
                        <div class="col-md-3 col-sm-3 col-xs-12" id="date">
                        </div>
                    </div>
                </div>
                      
                <div class="row" style="margin-top: 10px;">
                    <div class="form-group">
                        <div class="col-md-3 col-sm-3"></div>
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Turno:</label>
                        <div class="col-md-3 col-sm-3 col-xs-12" id="turn">
                        </div>
                    </div>
                </div>
                
                <div class="row" style="margin-top: 10px;">
                    <div class="form-group">
                        <div class="col-md-3 col-sm-3"></div>
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Descripción:</label>
                        <div class="col-md-3 col-sm-3 col-xs-12" id="description">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
          </div>

        </div>
      </div>  
  </div>
    </body>
</html>
