
/**
 * ServicioComunicacionCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.6  Built on : Jul 30, 2017 (09:08:31 BST)
 */

    package service;

    /**
     *  ServicioComunicacionCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ServicioComunicacionCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ServicioComunicacionCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ServicioComunicacionCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for readComunas method
            * override this method for handling normal response from readComunas operation
            */
           public void receiveResultreadComunas(
                    service.ServicioComunicacionStub.ReadComunasResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readComunas operation
           */
            public void receiveErrorreadComunas(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readEmpresasAll method
            * override this method for handling normal response from readEmpresasAll operation
            */
           public void receiveResultreadEmpresasAll(
                    service.ServicioComunicacionStub.ReadEmpresasAllResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readEmpresasAll operation
           */
            public void receiveErrorreadEmpresasAll(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteEmpleado method
            * override this method for handling normal response from deleteEmpleado operation
            */
           public void receiveResultdeleteEmpleado(
                    service.ServicioComunicacionStub.DeleteEmpleadoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteEmpleado operation
           */
            public void receiveErrordeleteEmpleado(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readEmpresaByIdCuentaUsuario method
            * override this method for handling normal response from readEmpresaByIdCuentaUsuario operation
            */
           public void receiveResultreadEmpresaByIdCuentaUsuario(
                    service.ServicioComunicacionStub.ReadEmpresaByIdCuentaUsuarioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readEmpresaByIdCuentaUsuario operation
           */
            public void receiveErrorreadEmpresaByIdCuentaUsuario(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readRoles method
            * override this method for handling normal response from readRoles operation
            */
           public void receiveResultreadRoles(
                    service.ServicioComunicacionStub.ReadRolesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readRoles operation
           */
            public void receiveErrorreadRoles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertCurso method
            * override this method for handling normal response from insertCurso operation
            */
           public void receiveResultinsertCurso(
                    service.ServicioComunicacionStub.InsertCursoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertCurso operation
           */
            public void receiveErrorinsertCurso(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for validarUsuario method
            * override this method for handling normal response from validarUsuario operation
            */
           public void receiveResultvalidarUsuario(
                    service.ServicioComunicacionStub.ValidarUsuarioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validarUsuario operation
           */
            public void receiveErrorvalidarUsuario(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertEmpresa method
            * override this method for handling normal response from insertEmpresa operation
            */
           public void receiveResultinsertEmpresa(
                    service.ServicioComunicacionStub.InsertEmpresaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertEmpresa operation
           */
            public void receiveErrorinsertEmpresa(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readVisitaMedicaByEmpresafECHA method
            * override this method for handling normal response from readVisitaMedicaByEmpresafECHA operation
            */
           public void receiveResultreadVisitaMedicaByEmpresafECHA(
                    service.ServicioComunicacionStub.ReadVisitaMedicaByEmpresafECHAResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readVisitaMedicaByEmpresafECHA operation
           */
            public void receiveErrorreadVisitaMedicaByEmpresafECHA(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertMedico method
            * override this method for handling normal response from insertMedico operation
            */
           public void receiveResultinsertMedico(
                    service.ServicioComunicacionStub.InsertMedicoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertMedico operation
           */
            public void receiveErrorinsertMedico(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteCuentaUsuario method
            * override this method for handling normal response from deleteCuentaUsuario operation
            */
           public void receiveResultdeleteCuentaUsuario(
                    service.ServicioComunicacionStub.DeleteCuentaUsuarioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteCuentaUsuario operation
           */
            public void receiveErrordeleteCuentaUsuario(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readCuentaUsuarioByRol method
            * override this method for handling normal response from readCuentaUsuarioByRol operation
            */
           public void receiveResultreadCuentaUsuarioByRol(
                    service.ServicioComunicacionStub.ReadCuentaUsuarioByRolResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readCuentaUsuarioByRol operation
           */
            public void receiveErrorreadCuentaUsuarioByRol(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteEmpresa method
            * override this method for handling normal response from deleteEmpresa operation
            */
           public void receiveResultdeleteEmpresa(
                    service.ServicioComunicacionStub.DeleteEmpresaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteEmpresa operation
           */
            public void receiveErrordeleteEmpresa(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertAlumno method
            * override this method for handling normal response from insertAlumno operation
            */
           public void receiveResultinsertAlumno(
                    service.ServicioComunicacionStub.InsertAlumnoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertAlumno operation
           */
            public void receiveErrorinsertAlumno(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readEmpleadoByEmpresa method
            * override this method for handling normal response from readEmpleadoByEmpresa operation
            */
           public void receiveResultreadEmpleadoByEmpresa(
                    service.ServicioComunicacionStub.ReadEmpleadoByEmpresaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readEmpleadoByEmpresa operation
           */
            public void receiveErrorreadEmpleadoByEmpresa(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateEmpleado method
            * override this method for handling normal response from updateEmpleado operation
            */
           public void receiveResultupdateEmpleado(
                    service.ServicioComunicacionStub.UpdateEmpleadoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateEmpleado operation
           */
            public void receiveErrorupdateEmpleado(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertCuentaUsuario method
            * override this method for handling normal response from insertCuentaUsuario operation
            */
           public void receiveResultinsertCuentaUsuario(
                    service.ServicioComunicacionStub.InsertCuentaUsuarioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertCuentaUsuario operation
           */
            public void receiveErrorinsertCuentaUsuario(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readCursoByIdPlan method
            * override this method for handling normal response from readCursoByIdPlan operation
            */
           public void receiveResultreadCursoByIdPlan(
                    service.ServicioComunicacionStub.ReadCursoByIdPlanResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readCursoByIdPlan operation
           */
            public void receiveErrorreadCursoByIdPlan(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readVisitaMedicaByRutEmpresa method
            * override this method for handling normal response from readVisitaMedicaByRutEmpresa operation
            */
           public void receiveResultreadVisitaMedicaByRutEmpresa(
                    service.ServicioComunicacionStub.ReadVisitaMedicaByRutEmpresaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readVisitaMedicaByRutEmpresa operation
           */
            public void receiveErrorreadVisitaMedicaByRutEmpresa(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readRegiones method
            * override this method for handling normal response from readRegiones operation
            */
           public void receiveResultreadRegiones(
                    service.ServicioComunicacionStub.ReadRegionesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readRegiones operation
           */
            public void receiveErrorreadRegiones(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readPlanByRutEmpresa method
            * override this method for handling normal response from readPlanByRutEmpresa operation
            */
           public void receiveResultreadPlanByRutEmpresa(
                    service.ServicioComunicacionStub.ReadPlanByRutEmpresaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readPlanByRutEmpresa operation
           */
            public void receiveErrorreadPlanByRutEmpresa(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readCursoByIdCurso method
            * override this method for handling normal response from readCursoByIdCurso operation
            */
           public void receiveResultreadCursoByIdCurso(
                    service.ServicioComunicacionStub.ReadCursoByIdCursoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readCursoByIdCurso operation
           */
            public void receiveErrorreadCursoByIdCurso(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertEmpleado method
            * override this method for handling normal response from insertEmpleado operation
            */
           public void receiveResultinsertEmpleado(
                    service.ServicioComunicacionStub.InsertEmpleadoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertEmpleado operation
           */
            public void receiveErrorinsertEmpleado(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readMedicoByIdUsuario method
            * override this method for handling normal response from readMedicoByIdUsuario operation
            */
           public void receiveResultreadMedicoByIdUsuario(
                    service.ServicioComunicacionStub.ReadMedicoByIdUsuarioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readMedicoByIdUsuario operation
           */
            public void receiveErrorreadMedicoByIdUsuario(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateCuentaUsuario method
            * override this method for handling normal response from updateCuentaUsuario operation
            */
           public void receiveResultupdateCuentaUsuario(
                    service.ServicioComunicacionStub.UpdateCuentaUsuarioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateCuentaUsuario operation
           */
            public void receiveErrorupdateCuentaUsuario(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readProvincias method
            * override this method for handling normal response from readProvincias operation
            */
           public void receiveResultreadProvincias(
                    service.ServicioComunicacionStub.ReadProvinciasResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readProvincias operation
           */
            public void receiveErrorreadProvincias(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateCurso method
            * override this method for handling normal response from updateCurso operation
            */
           public void receiveResultupdateCurso(
                    service.ServicioComunicacionStub.UpdateCursoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateCurso operation
           */
            public void receiveErrorupdateCurso(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertEmpleadoCursor method
            * override this method for handling normal response from insertEmpleadoCursor operation
            */
           public void receiveResultinsertEmpleadoCursor(
                    service.ServicioComunicacionStub.InsertEmpleadoCursorResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertEmpleadoCursor operation
           */
            public void receiveErrorinsertEmpleadoCursor(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateEmpresa method
            * override this method for handling normal response from updateEmpresa operation
            */
           public void receiveResultupdateEmpresa(
                    service.ServicioComunicacionStub.UpdateEmpresaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateEmpresa operation
           */
            public void receiveErrorupdateEmpresa(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertPlanCapacitacion method
            * override this method for handling normal response from insertPlanCapacitacion operation
            */
           public void receiveResultinsertPlanCapacitacion(
                    service.ServicioComunicacionStub.InsertPlanCapacitacionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertPlanCapacitacion operation
           */
            public void receiveErrorinsertPlanCapacitacion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readVisitaMedicaByRutMedico method
            * override this method for handling normal response from readVisitaMedicaByRutMedico operation
            */
           public void receiveResultreadVisitaMedicaByRutMedico(
                    service.ServicioComunicacionStub.ReadVisitaMedicaByRutMedicoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readVisitaMedicaByRutMedico operation
           */
            public void receiveErrorreadVisitaMedicaByRutMedico(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readVisitaMedicaByRutEmpleado method
            * override this method for handling normal response from readVisitaMedicaByRutEmpleado operation
            */
           public void receiveResultreadVisitaMedicaByRutEmpleado(
                    service.ServicioComunicacionStub.ReadVisitaMedicaByRutEmpleadoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readVisitaMedicaByRutEmpleado operation
           */
            public void receiveErrorreadVisitaMedicaByRutEmpleado(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for readAlumnoByIdUsuario method
            * override this method for handling normal response from readAlumnoByIdUsuario operation
            */
           public void receiveResultreadAlumnoByIdUsuario(
                    service.ServicioComunicacionStub.ReadAlumnoByIdUsuarioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readAlumnoByIdUsuario operation
           */
            public void receiveErrorreadAlumnoByIdUsuario(java.lang.Exception e) {
            }
                


    }
    